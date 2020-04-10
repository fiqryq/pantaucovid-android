package com.sunflower.pantaucovid19.base;

import android.os.Bundle;
import android.widget.Toast;

import androidx.annotation.Nullable;
import androidx.appcompat.app.AppCompatActivity;
import androidx.fragment.app.Fragment;

/**
 * Created by Faisal Amir
 * FrogoBox Inc License
 * =========================================
 * Pantau-Covid19
 * Copyright (C) 04/04/2020.
 * All rights reserved
 * -----------------------------------------
 * Name     : Muhammad Faisal Amir
 * E-mail   : faisalamircs@gmail.com
 * Github   : github.com/amirisback
 * LinkedIn : linkedin.com/in/faisalamircs
 * -----------------------------------------
 * FrogoBox Software Industries
 * com.sunflower.pantaucovid19
 */
public class BaseActivity extends AppCompatActivity {

    protected AppCompatActivity mActivity;

    @Override
    protected void onCreate(@Nullable Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        mActivity = this;
    }

    protected void showToastShort(String message) {
        Toast.makeText(this, message, Toast.LENGTH_SHORT).show();
    }

    protected void showToastLong(String message) {
        Toast.makeText(this, message, Toast.LENGTH_LONG).show();
    }

    protected void setupFragment(Fragment fragment, int layout) {
        getSupportFragmentManager()
                .beginTransaction()
                .replace(layout, fragment)
                .commit();
    }

}
