package com.sunflower.pantaucovid19.source.model;

import com.google.gson.annotations.Expose;
import com.google.gson.annotations.SerializedName;

public class ResponseBody {

    @Expose
    @SerializedName("attributes")
    private Provinsi modelDataProvinsi;

    public Provinsi getModelDataProvinsi() {
        return modelDataProvinsi;
    }

    public void setModelDataProvinsi(Provinsi modelDataProvinsi) {
        this.modelDataProvinsi = modelDataProvinsi;
    }
}
