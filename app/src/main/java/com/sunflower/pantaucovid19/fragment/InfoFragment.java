package com.sunflower.pantaucovid19.fragment;

import android.os.Bundle;

import androidx.fragment.app.Fragment;

import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;

import com.sunflower.pantaucovid19.R;


/**
 * A simple {@link Fragment} subclass.
 */
public class InfoFragment extends Fragment {

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
