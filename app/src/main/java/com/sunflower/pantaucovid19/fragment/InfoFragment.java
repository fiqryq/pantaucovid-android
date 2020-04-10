package com.sunflower.pantaucovid19.fragment;

import android.os.Bundle;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;

import androidx.fragment.app.Fragment;

import com.sunflower.pantaucovid19.R;
import com.sunflower.pantaucovid19.base.BaseFragment;


/**
 * A simple {@link Fragment} subclass.
 */
public class InfoFragment extends BaseFragment {

    public InfoFragment() {
        // Required empty public constructor
    }


    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container,
                             Bundle savedInstanceState) {
        // Inflate the layout for this fragment
        return inflater.inflate(R.layout.fragment_infok, container, false);
    }
}
