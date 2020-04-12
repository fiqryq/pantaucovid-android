package com.sunflower.pantaucovid19.ui.fragment;

import android.content.Intent;
import android.os.Bundle;

import androidx.annotation.NonNull;
import androidx.annotation.Nullable;
import androidx.fragment.app.Fragment;

import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.TextView;

import com.sunflower.pantaucovid19.R;
import com.sunflower.pantaucovid19.ui.activity.AboutActivity;


/**
 * A simple {@link Fragment} subclass.
 */
public class InfoFragment extends Fragment {

    private TextView mAbout;

    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container, Bundle savedInstanceState) {
        return inflater.inflate(R.layout.fragment_info, container, false);
    }

    @Override
    public void onViewCreated(@NonNull View view, @Nullable Bundle savedInstanceState) {
        super.onViewCreated(view, savedInstanceState);
        mAbout = view.findViewById(R.id.tv_aboutapp);
        mAbout.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                IntentAbout();
            }
        });
    }

    private void IntentAbout() {
        Intent intent = new Intent(getActivity(), AboutActivity.class);
        startActivity(intent);
    }
}
