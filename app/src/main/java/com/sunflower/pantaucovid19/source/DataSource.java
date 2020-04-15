package com.sunflower.pantaucovid19.source;

import com.frogobox.frogonewsapi.data.response.ArticleResponse;
import com.frogobox.frogonewsapi.data.response.SourceResponse;
import com.sunflower.pantaucovid19.source.model.Negara;
import com.sunflower.pantaucovid19.source.model.ResponseProvinsi;
import com.sunflower.pantaucovid19.source.remote.GetRemoteCallback;

import java.util.List;

/**
 * Created by Faisal Amir
 * FrogoBox Inc License
 * =========================================
 * Pantau-Covid19
 * Copyright (C) 12/04/2020.
 * All rights reserved
 * -----------------------------------------
 * Name     : Muhammad Faisal Amir
 * E-mail   : faisalamircs@gmail.com
 * Github   : github.com/amirisback
 * LinkedIn : linkedin.com/in/faisalamircs
 * -----------------------------------------
 * FrogoBox Software Industries
 * com.sunflower.pantaucovid19.source
 */
public interface DataSource {

    void getNegara(GetRemoteCallback<List<Negara>> callback);

    void getProvinsi(GetRemoteCallback<List<ResponseProvinsi>> callback);

    void getTopHeadline(
            String apiKey,
            String q,
            String sources,
            String category,
            String country,
            GetRemoteCallback<ArticleResponse> callback
    );

    // Get Everythings
    void getEverythings(
            String apiKey,
            String q,
            String from,
            String to,
            String qInTitle,
            String sources,
            String domains,
            String excludeDomains,
            String language,
            String sortBy,
            GetRemoteCallback<ArticleResponse> callback
    );

    // Get Sources
    void getSources(
            String apiKey,
            String language,
            String country,
            String category,
            GetRemoteCallback<SourceResponse> callback
    );

}
