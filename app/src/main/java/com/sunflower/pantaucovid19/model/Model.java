package com.sunflower.pantaucovid19.model;

import com.google.gson.annotations.SerializedName;

public class Model {
    private String kodeProvinsi;
    private String provinsi;
    private String kasusPositif;
    private String kasusNegatif;
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
