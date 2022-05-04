package com.sunflower.pantaucovid19.source.remote;

import com.frogobox.coreapi.news.NewsConstant;
import com.frogobox.coreapi.news.NewsUrl;
import com.frogobox.coreapi.news.response.ArticleResponse;
import com.frogobox.coreapi.news.response.SourceResponse;
import com.sunflower.pantaucovid19.source.model.Negara;
import com.sunflower.pantaucovid19.source.model.ResponseProvinsi;
import com.sunflower.pantaucovid19.utils.Constant;

import java.util.List;

import retrofit2.Call;
import retrofit2.http.GET;
import retrofit2.http.Query;

public interface Api {
    @GET(Constant.Url.PROVINSI)
    Call<List<ResponseProvinsi>> getDataProvinsi();

    @GET(Constant.Url.NEGARA)
    Call<List<Negara>> getDataNegara();

    // Get Top Headline
    @GET(NewsUrl.URL_TOP_HEADLINE)
    Call<ArticleResponse> getTopHeadline(
            @Query(NewsConstant.QUERY_API_KEY) String apiKey,
            @Query(NewsConstant.QUERY_Q) String q,
            @Query(NewsConstant.QUERY_SOURCES) String sources,
            @Query(NewsConstant.QUERY_CATEGORY) String category,
            @Query(NewsConstant.QUERY_COUNTRY) String country
    );

    // Get Everythings
    @GET(NewsUrl.URL_EVERYTHING)
    Call<ArticleResponse> getEverythings(
            @Query(NewsConstant.QUERY_API_KEY) String apiKey,
            @Query(NewsConstant.QUERY_Q) String q,
            @Query(NewsConstant.QUERY_FROM) String from,
            @Query(NewsConstant.QUERY_TO) String to,
            @Query(NewsConstant.QUERY_Q_IN_TITLE) String qInTitle,
            @Query(NewsConstant.QUERY_SOURCES) String sources,
            @Query(NewsConstant.QUERY_DOMAINS) String domains,
            @Query(NewsConstant.QUERY_EXCLUDE_DOMAINS) String excludeDomains,
            @Query(NewsConstant.QUERY_LANGUAGE) String language,
            @Query(NewsConstant.QUERY_SORT_BY) String sortBy
    );

    // Get Sources
    @GET(NewsUrl.URL_SOURCES)
    Call<SourceResponse> getSources(
            @Query(NewsConstant.QUERY_API_KEY) String apiKey,
            @Query(NewsConstant.QUERY_LANGUAGE) String language,
            @Query(NewsConstant.QUERY_COUNTRY) String country,
            @Query(NewsConstant.QUERY_CATEGORY) String category
    );

}
