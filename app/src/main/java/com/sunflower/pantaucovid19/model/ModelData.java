package com.sunflower.pantaucovid19.model;

import com.google.gson.annotations.Expose;
import com.google.gson.annotations.SerializedName;

public class ModelData {
    @Expose
    @SerializedName("Kode_Provi")
    private String kodeProvinsi;

    @Expose
    @SerializedName("Provinsi")
    private String provinsi;

    @Expose
    @SerializedName("Kasus_Posi")
    private String kasusPositif;

    @Expose
    @SerializedName("Kasus_Semb")
    private String kasusSembuh;

    @Expose
    @SerializedName("Kasus_Meni")
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

    public String getKasusSembuh() {
        return kasusSembuh;
    }

    public void setKasusSembuh(String kasusSembuh) {
        this.kasusSembuh = kasusSembuh;
    }

    public String getKasusMeninggal() {
        return kasusMeninggal;
    }

    public void setKasusMeninggal(String kasusMeninggal) {
        this.kasusMeninggal = kasusMeninggal;
    }
}
