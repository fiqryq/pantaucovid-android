package com.sunflower.pantaucovid19.ui.fragment

import android.content.Intent
import android.os.Bundle
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.ImageView
import android.widget.ProgressBar
import android.widget.TextView
import com.bumptech.glide.Glide
import com.frogobox.coreapi.news.NewsConstant.COUNTRY_ID
import com.frogobox.coreapi.news.NewsUrl
import com.frogobox.coreapi.news.model.Article
import com.frogobox.coreapi.news.response.ArticleResponse
import com.frogobox.recycler.core.FrogoRecyclerNotifyListener
import com.frogobox.recycler.core.IFrogoViewAdapter
import com.frogobox.recycler.widget.FrogoRecyclerView
import com.sunflower.pantaucovid19.R
import com.sunflower.pantaucovid19.base.BaseFragment
import com.sunflower.pantaucovid19.databinding.FragmentBeritaBinding
import com.sunflower.pantaucovid19.source.DataRepository
import com.sunflower.pantaucovid19.source.remote.GetRemoteCallback
import com.sunflower.pantaucovid19.ui.activity.WebViewActivity

/**
 * A simple [Fragment] subclass.
 */
class BeritaFragment : BaseFragment<FragmentBeritaBinding>() {

    override fun setupViewBinding(
        inflater: LayoutInflater,
        container: ViewGroup?
    ): FragmentBeritaBinding {
        return FragmentBeritaBinding.inflate(inflater, container, false)
    }

    override fun setupOnViewCreated(view: View, savedInstanceState: Bundle?) {

        getEverythings(binding.rvNewsCategory, binding.progressView)
        swipeAction()
    }

    private fun swipeAction() {
        binding.apply {
            refreshNews.setOnRefreshListener {
                getEverythings(binding.rvNewsCategory, binding.progressView)
                refreshNews.isRefreshing = false
            }
            refreshNews.setColorSchemeResources(R.color.colorPrimary)
        }

    }

    private fun getEverythings(frogoRecyclerView: FrogoRecyclerView, progressBar: ProgressBar) {
        val dataRepository = DataRepository(context)
        dataRepository.getEverythings(
            NewsUrl.API_KEY,
            "Covid 19",
            null,
            null,
            null,
            null,
            null,
            null,
            COUNTRY_ID,
            null,
            object : GetRemoteCallback<ArticleResponse> {
                override fun onSuccess(data: ArticleResponse) {
                    data.articles?.let { setupRecyclerView(frogoRecyclerView, it) }
                }

                override fun onFailed(errorMessage: String) {
                    showToastLong(errorMessage)
                }

                override fun onShowProgress() {
                    mActivity?.runOnUiThread {
                        progressBar.visibility = View.VISIBLE
                    }
                }

                override fun onHideProgress() {
                    mActivity?.runOnUiThread {
                        progressBar.visibility = View.GONE
                    }
                }
            }
        )
    }

    private fun setupRecyclerView(frogoRecyclerView: FrogoRecyclerView, articles: List<Article>) {
        val frogoViewAdapterCallback = object : IFrogoViewAdapter<Article> {
            override fun setupInitComponent(
                view: View,
                data: Article,
                position: Int,
                notifyListener: FrogoRecyclerNotifyListener<Article>
            ) {
                val tvTitle = view.findViewById<TextView>(R.id.tv_title)
                val tvPublishdDate = view.findViewById<TextView>(R.id.tv_published)
                val tvDescription = view.findViewById<TextView>(R.id.tv_description)
                val ivUrl = view.findViewById<ImageView>(R.id.iv_url)
                tvTitle.text = data.title
                tvPublishdDate.text = data.publishedAt
                tvDescription.text = data.description
                Glide.with(view.context).load(data.urlToImage).into(ivUrl)
            }

            override fun onItemLongClicked(
                view: View,
                data: Article,
                position: Int,
                notifyListener: FrogoRecyclerNotifyListener<Article>
            ) {
                showToastShort(data.title)
            }

            override fun onItemClicked(
                view: View,
                data: Article,
                position: Int,
                notifyListener: FrogoRecyclerNotifyListener<Article>
            ) {
                showToastShort(data.title)
                val intent = Intent(activity, WebViewActivity::class.java)
                intent.putExtra("url", data.url)
                requireActivity().startActivity(intent)
            }
        }
        frogoRecyclerView.injector<Article>()
            .addData(articles)
            .addCustomView(R.layout.list_article_vertical)
            .addEmptyView(null)
            .addCallback(frogoViewAdapterCallback)
            .createLayoutLinearVertical(false)
            .build()
    }

}