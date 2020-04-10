package com.sunflower.pantaucovid19.model;

import com.google.gson.annotations.Expose;
import com.google.gson.annotations.SerializedName;

public class ModelData {
    @Expose
    @SerializedName("kodeProvinsi")
    private String kodeProvinsi;
    @Expose
    @SerializedName("provinsi")
    private String provinsi;
    @Expose
    @SerializedName("kasusPositif")
    private String kasusPositif;
    @Expose
    @SerializedName("kasusNegatif")
    private String kasusNegatif;
    @Expose
    @SerializedName("kasusMeninggal")
    private String kasusMeninggal;

    public String getKodeProvinsi() {
        return kodeProvinsi;
    }

    public void setKodeProvinsi(String kodeProvinsi) {
        this.kodeProvinsi = kodeProvinsi;
    }

    public String getProvinsi() {
        return provinsi;
    }

    public void setProvinsi(String provinsi) {
        this.provinsi = provinsi;
    }

    public String getKasusPositif() {
        return kasusPositif;
    }

    public void setKasusPositif(String kasusPositif) {
        this.kasusPositif = kasusPositif;
    }

    public String getKasusNegatif() {
        return kasusNegatif;
    }

    public void setKasusNegatif(String kasusNegatif) {
        this.kasusNegatif = kasusNegatif;
    }

    public String getKasusMeninggal() {
        return kasusMeninggal;
    }

    public void setKasusMeninggal(String kasusMeninggal) {
        this.kasusMeninggal = kasusMeninggal;
    }
}
