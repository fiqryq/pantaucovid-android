package com.sunflower.pantaucovid19.source;

import android.content.Context;

import com.sunflower.pantaucovid19.source.model.Negara;
import com.sunflower.pantaucovid19.source.model.ResponseProvinsi;
import com.sunflower.pantaucovid19.source.remote.GetRemoteCallback;
import com.sunflower.pantaucovid19.source.remote.RemoteDataSource;

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
public class DataRepository implements DataSource {

    private RemoteDataSource remoteDataSource;

    public DataRepository(Context context) {
        this.remoteDataSource = new RemoteDataSource(context);
    }

    @Override
    public void getNegara(GetRemoteCallback<List<Negara>> callback) {
        remoteDataSource.getNegara(callback);
    }

    @Override
    public void getProvinsi(GetRemoteCallback<List<ResponseProvinsi>> callback) {
        remoteDataSource.getProvinsi(callback);
    }

}
