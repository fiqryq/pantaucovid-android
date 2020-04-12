package com.sunflower.pantaucovid19.source.remote;

import android.content.Context;

import com.sunflower.pantaucovid19.source.DataSource;
import com.sunflower.pantaucovid19.source.model.Negara;
import com.sunflower.pantaucovid19.source.model.ResponseProvinsi;

import java.util.List;

import retrofit2.Call;
import retrofit2.Callback;
import retrofit2.Response;

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
 * com.sunflower.pantaucovid19.source.remote
 */
public class RemoteDataSource implements DataSource {

    private Context context;

    public RemoteDataSource(Context context) {
        this.context = context;
    }

    @Override
    public void getNegara(GetRemoteCallback<List<Negara>> callback) {
        callback.onShowProgress();
        Call<List<Negara>> call = ApiService.getApiClient(context).create(Api.class).getDataNegara();
        call.enqueue(new Callback<List<Negara>>() {
            @Override
            public void onResponse(Call<List<Negara>> call, Response<List<Negara>> response) {
                callback.onHideProgress();
                callback.onSuccess(response.body());
            }

            @Override
            public void onFailure(Call<List<Negara>> call, Throwable t) {
                callback.onFailed(t.getLocalizedMessage());
            }
        });
    }

    @Override
    public void getProvinsi(GetRemoteCallback<List<ResponseProvinsi>> callback) {
        callback.onShowProgress();
        Call<List<ResponseProvinsi>> call = ApiService.getApiClient(context).create(Api.class).getDataProvinsi();
        call.enqueue(new Callback<List<ResponseProvinsi>>() {
            @Override
            public void onResponse(Call<List<ResponseProvinsi>> call, Response<List<ResponseProvinsi>> response) {
                if (response.isSuccessful()) {
                    callback.onHideProgress();
                    callback.onSuccess(response.body());
                }
            }

            @Override
            public void onFailure(Call<List<ResponseProvinsi>> call, Throwable t) {
                callback.onFailed(t.getLocalizedMessage());
            }
        });
    }

}
