package com.sunflower.pantaucovid19.model;

import com.google.gson.annotations.SerializedName;

public class ModelData {
    @SerializedName("kodeProvinsi")
    private String kodeProvinsi;
    @SerializedName("provinsi")
    private String provinsi;
    @SerializedName("kasusPositif")
    private String kasusPositif;
    @SerializedName("kasusNegatif")
    private String kasusNegatif;
    @SerializedName("kasusMeninggal")
    private String kasusMeninggal;

    public String getKodeProvinsi() {
        return kodeProvinsi;
    }

    public String getProvinsi() {
        return provinsi;
    }

    public String getKasusPositif() {
        return kasusPositif;
    }

    public String getKasusNegatif() {
        return kasusNegatif;
    }

    public String getKasusMeninggal() {
        return kasusMeninggal;
    }
}
