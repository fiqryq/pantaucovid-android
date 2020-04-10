package com.sunflower.pantaucovid19.model;

import com.google.gson.annotations.Expose;
import com.google.gson.annotations.SerializedName;

public class ResponseBody {

    @Expose
    @SerializedName("attributes")
    private ModelDataProvinsi modelDataProvinsi;

    public ModelDataProvinsi getModelDataProvinsi() {
        return modelDataProvinsi;
    }

    public void setModelDataProvinsi(ModelDataProvinsi modelDataProvinsi) {
        this.modelDataProvinsi = modelDataProvinsi;
    }
}
