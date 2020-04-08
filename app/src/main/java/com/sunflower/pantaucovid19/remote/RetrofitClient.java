package com.sunflower.pantaucovid19.remote;

import retrofit2.Retrofit;
import retrofit2.converter.gson.GsonConverterFactory;

public class RetrofitClient {

    Retrofit.Builder builder = new Retrofit.Builder()
            .baseUrl("https://api.kawalcorona.com")
            .addConverterFactory(GsonConverterFactory.create());
}
