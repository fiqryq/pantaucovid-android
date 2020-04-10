package com.sunflower.pantaucovid19.base;

import android.os.Bundle;

import androidx.annotation.Nullable;
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
public class BaseFragment extends Fragment {

    protected BaseActivity mActivity;

    @Override
    public void onCreate(@Nullable Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        mActivity = (BaseActivity) getActivity();
    }


    protected void showToastShort(String message) {
        mActivity.showToastShort(message);
    }

    protected void showToastLong(String message) {
        mActivity.showToastLong(message);
    }

    protected void setupFragment(Fragment fragment, int layout) {
        getChildFragmentManager()
                .beginTransaction()
                .replace(layout, fragment)
                .commit();
    }



}
