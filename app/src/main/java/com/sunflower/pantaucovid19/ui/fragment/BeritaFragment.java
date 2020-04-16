package com.sunflower.pantaucovid19.ui.fragment;

import android.content.Intent;
import android.os.Bundle;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ImageView;
import android.widget.ProgressBar;
import android.widget.TextView;

import androidx.annotation.NonNull;
import androidx.annotation.Nullable;
import androidx.fragment.app.Fragment;
import androidx.swiperefreshlayout.widget.SwipeRefreshLayout;

import com.bumptech.glide.Glide;
import com.frogobox.frogonewsapi.data.model.Article;
import com.frogobox.frogonewsapi.data.response.ArticleResponse;
import com.frogobox.frogonewsapi.util.NewsConstant;
import com.frogobox.frogonewsapi.util.NewsUrl;
import com.frogobox.recycler.FrogoRecyclerView;
import com.frogobox.recycler.callback.FrogoAdapterCallback;
import com.sunflower.pantaucovid19.R;
import com.sunflower.pantaucovid19.base.BaseFragment;
import com.sunflower.pantaucovid19.source.DataRepository;
import com.sunflower.pantaucovid19.source.remote.GetRemoteCallback;
import com.sunflower.pantaucovid19.ui.activity.WebViewActivity;

import org.jetbrains.annotations.NotNull;

import java.util.List;
import java.util.Objects;

/**
 * A simple {@link Fragment} subclass.
 */
public class BeritaFragment extends BaseFragment {
    private SwipeRefreshLayout swipe2refresh;
    private ProgressBar progressBar;
    private FrogoRecyclerView frogoRecyclerView;

    public BeritaFragment() {
        // Required empty public constructor
    }

    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container,
                             Bundle savedInstanceState) {
        // Inflate the layout for this fragment
        return inflater.inflate(R.layout.fragment_berita, container, false);
    }

    @Override
    public void onViewCreated(@NonNull View view, @Nullable Bundle savedInstanceState) {
        super.onViewCreated(view, savedInstanceState);
        frogoRecyclerView = view.findViewById(R.id.rv_news_category);
        progressBar = view.findViewById(R.id.progress_view);
        swipe2refresh = view.findViewById(R.id.refreshNews);
        getTopHeadLine(frogoRecyclerView, progressBar);
        swipeAction();
    }

    private void swipeAction() {
        swipe2refresh.setOnRefreshListener(() -> {
            getTopHeadLine(frogoRecyclerView, progressBar);
            swipe2refresh.setRefreshing(false);
        });
        swipe2refresh.setColorSchemeResources(R.color.colorPrimary);
    }

    private void getTopHeadLine(FrogoRecyclerView frogoRecyclerView, ProgressBar progressBar) {
        DataRepository dataRepository = new DataRepository(getContext());
        dataRepository.getTopHeadline(
                NewsUrl.NEWS_API_KEY,
                "Virus Corona",
                null,
                null,
                NewsConstant.COUNTRY_ID,
                new GetRemoteCallback<ArticleResponse>() {
                    @Override
                    public void onSuccess(ArticleResponse data) {
                        setupRecyclerView(frogoRecyclerView, data.getArticles());
                    }

                    @Override
                    public void onFailed(String errorMessage) {
                        showToastLong(errorMessage);
                    }

                    @Override
                    public void onShowProgress() {
                        progressBar.setVisibility(View.VISIBLE);
                    }

                    @Override
                    public void onHideProgress() {
                        progressBar.setVisibility(View.GONE);
                    }
                }
        );
    }

    private void setupRecyclerView(FrogoRecyclerView frogoRecyclerView, List<Article> articles) {

        frogoRecyclerView.injectAdapter(
                R.layout.list_article_vertical,
                articles,
                null,
                new FrogoAdapterCallback<Article>() {
                    @Override
                    public void setupInitComponent(@NotNull View view, Article article) {

                        TextView tvTitle = view.findViewById(R.id.tv_title);
                        TextView tvPublishdDate = view.findViewById(R.id.tv_published);
                        TextView tvDescription = view.findViewById(R.id.tv_description);
                        ImageView ivUrl = view.findViewById(R.id.iv_url);

                        tvTitle.setText(article.getTitle());
                        tvPublishdDate.setText(article.getPublishedAt());
                        tvDescription.setText(article.getDescription());
                        Glide.with(view.getContext()).load(article.getUrlToImage()).into(ivUrl);

                    }

                    @Override
                    public void onItemClicked(Article article) {
                        showToastShort(article.getTitle());
                        Intent intent = new Intent(getActivity(), WebViewActivity.class);
                        intent.putExtra("url", article.getUrl());
                        Objects.requireNonNull(getActivity()).startActivity(intent);
                    }

                    @Override
                    public void onItemLongClicked(Article article) {
                        showToastShort(article.getTitle());
                    }
                });
        frogoRecyclerView.isViewLinearVertical(false);
    }


}
