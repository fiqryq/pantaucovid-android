package com.sunflower.pantaucovid19.remote;

import com.sunflower.pantaucovid19.model.Model;

public class Url {
    private static final String BASE_URL = "https://api.kawalcorona.com/indonesia/provinsi/?fbclid=IwAR2et4U7LTIEnKnPe0uBWfjn6lTmyyu-EEssrIBO4bLxx1W_lJmUtBnASzU";

    private static Model getData(){
        return RetrofitClient.getClient(BASE_URL).create(Model.class);
    }
}
