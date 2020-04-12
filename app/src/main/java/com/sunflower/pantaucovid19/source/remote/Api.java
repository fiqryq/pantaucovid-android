package com.sunflower.pantaucovid19.source.remote;

import com.sunflower.pantaucovid19.source.model.Negara;
import com.sunflower.pantaucovid19.source.model.ResponseBody;
import com.sunflower.pantaucovid19.utils.Constant;

import java.util.List;

import retrofit2.Call;
import retrofit2.http.GET;

public interface Api {
    @GET(Constant.Url.PROVINSI)
    Call<List<ResponseBody>> getDataProvinsi();

    @GET(Constant.Url.NEGARA)
    Call<List<Negara>> getDataNegara();
}
