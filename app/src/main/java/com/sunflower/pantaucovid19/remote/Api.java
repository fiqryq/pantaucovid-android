package com.sunflower.pantaucovid19.remote;

import com.sunflower.pantaucovid19.model.ModelDataNegara;
import com.sunflower.pantaucovid19.model.ResponseBody;

import java.util.List;

import retrofit2.Call;
import retrofit2.http.GET;
import retrofit2.http.Query;

public interface Api {
    @GET("indonesia/provinsi/?fbclid=IwAR2et4U7LTIEnKnPe0uBWfjn6lTmyyu-EEssrIBO4bLxx1W_lJmUtBnASzU")
    Call<List<ResponseBody>> getDataProvinsi();

    @GET("indonesia")
    Call<ModelDataNegara> getDataNegara();
}
