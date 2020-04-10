package com.sunflower.pantaucovid19.model;

import com.google.gson.annotations.Expose;
import com.google.gson.annotations.SerializedName;

public class ModelDataNegara {
    @Expose
    @SerializedName("name")
    private String nama;
    @Expose
    @SerializedName("positif")
    private String positif;
    @Expose
    @SerializedName("sembuh")
    private String sembuh;
    @Expose
    @SerializedName("meninggal")
    private String meninggal;

    public String getNama() {
        return nama;
    }

    public String getPositif() {
        return positif;
    }

    public String getSembuh() {
        return sembuh;
    }

    public String getMeninggal() {
        return meninggal;
    }
}
