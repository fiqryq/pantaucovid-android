package com.sunflower.pantaucovid19.source.model;

import com.google.gson.annotations.Expose;
import com.google.gson.annotations.SerializedName;

public class ResponseProvinsi {

    @Expose
    @SerializedName("attributes")
    private Provinsi provinsi;

    public Provinsi getProvinsi() {
        return provinsi;
    }

    public void setProvinsi(Provinsi provinsi) {
        this.provinsi = provinsi;
    }
}
