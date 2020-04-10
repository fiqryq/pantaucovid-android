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

    public void setNama(String nama) {
        this.nama = nama;
    }

    public String getPositif() {
        return positif;
    }

    public void setPositif(String positif) {
        this.positif = positif;
    }

    public String getSembuh() {
        return sembuh;
    }

    public void setSembuh(String sembuh) {
        this.sembuh = sembuh;
    }

    public String getMeninggal() {
        return meninggal;
    }

    public void setMeninggal(String meninggal) {
        this.meninggal = meninggal;
    }
}
