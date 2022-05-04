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
import com.frogobox.frogonewsapi.data.model.Article
import com.frogobox.frogonewsapi.data.response.ArticleResponse
import com.frogobox.frogonewsapi.util.NewsConstant.COUNTRY_ID
import com.frogobox.frogonewsapi.util.NewsUrl.NEWS_API_KEY
import com.frogobox.recycler.core.FrogoRecyclerNotifyListener
import com.frogobox.recycler.core.IFrogoViewAdapter
import com.frogobox.recycler.widget.FrogoRecyclerView
import com.sunflower.pantaucovid19.R
import com.sunflower.pantaucovid19.base.BaseFragment
import com.sunflower.pantaucovid19.source.DataRepository
import com.sunflower.pantaucovid19.source.remote.GetRemoteCallback
import com.sunflower.pantaucovid19.ui.activity.WebViewActivity
import kotlinx.android.synthetic.main.fragment_berita.*

/**
 * A simple [Fragment] subclass.
 */
class BeritaFragment : BaseFragment() {

    override fun onCreateView(
        inflater: LayoutInflater, container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View? {
        // Inflate the layout for this fragment
        return inflater.inflate(R.layout.fragment_berita, container, false)
    }

    override fun onViewCreated(view: View, savedInstanceState: Bundle?) {
        super.onViewCreated(view, savedInstanceState)
        getEverythings(rv_news_category, progress_view)
        swipeAction()
    }

    private fun swipeAction() {
        refreshNews.setOnRefreshListener {
            getEverythings(rv_news_category, progress_view)
            refreshNews!!.isRefreshing = false
        }
        refreshNews.setColorSchemeResources(R.color.colorPrimary)
    }

    private fun getEverythings(frogoRecyclerView: FrogoRecyclerView, progressBar: ProgressBar) {
        val dataRepository = DataRepository(context)
        dataRepository.getEverythings(
            NEWS_API_KEY,
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
                    mActivity.runOnUiThread {
                        progressBar.visibility = View.VISIBLE
                    }
                }

                override fun onHideProgress() {
                    mActivity.runOnUiThread {
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