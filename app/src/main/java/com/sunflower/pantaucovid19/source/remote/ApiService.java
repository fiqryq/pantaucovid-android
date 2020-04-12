package com.sunflower.pantaucovid19.source.remote;

import android.content.Context;

import com.readystatesoftware.chuck.ChuckInterceptor;
import com.sunflower.pantaucovid19.utils.Constant;

import java.util.concurrent.TimeUnit;

import okhttp3.OkHttpClient;
import retrofit2.Retrofit;
import retrofit2.converter.gson.GsonConverterFactory;

public class ApiService {

    private static Retrofit retrofit;

    public static Retrofit getApiClient(Context context) {

        OkHttpClient client = new OkHttpClient()
                .newBuilder()
                .addInterceptor(new ChuckInterceptor(context))
                .readTimeout(30, TimeUnit.SECONDS)
                .connectTimeout(30, TimeUnit.SECONDS)
                .build();

        if (retrofit == null) {
            retrofit = new Retrofit.Builder()
                    .baseUrl(Constant.Url.BASE_URL)
                    .addConverterFactory(GsonConverterFactory.create())
                    .build();
        }

        return retrofit;
    }
}
