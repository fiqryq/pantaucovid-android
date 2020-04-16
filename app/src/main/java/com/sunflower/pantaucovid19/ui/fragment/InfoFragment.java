package com.sunflower.pantaucovid19.ui.fragment;

import android.content.Intent;
import android.os.Bundle;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;

import androidx.annotation.NonNull;
import androidx.annotation.Nullable;
import androidx.constraintlayout.widget.ConstraintLayout;
import androidx.fragment.app.Fragment;

import com.sunflower.pantaucovid19.R;
import com.sunflower.pantaucovid19.base.BaseFragment;
import com.sunflower.pantaucovid19.ui.activity.AboutActivity;
import com.sunflower.pantaucovid19.ui.activity.EmergencyNumberActivity;
import com.sunflower.pantaucovid19.ui.activity.RumahSakitRujukanActivity;


/**
 * A simple {@link Fragment} subclass.
 */
public class InfoFragment extends BaseFragment {

    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container, Bundle savedInstanceState) {
        return inflater.inflate(R.layout.fragment_info, container, false);
    }

    @Override
    public void onViewCreated(@NonNull View view, @Nullable Bundle savedInstanceState) {
        super.onViewCreated(view, savedInstanceState);

        ConstraintLayout mCall = view.findViewById(R.id.CallSelect);
        ConstraintLayout mAbout = view.findViewById(R.id.aboutSelect);
        ConstraintLayout mHospital = view.findViewById(R.id.RumahSakit);
        mAbout.setOnClickListener(v -> IntentAbout());
        mCall.setOnClickListener(v -> IntentCall());
        mHospital.setOnClickListener(view1 -> IntentRumahSakit());
    }

    private void IntentCall() {
        Intent intentCall = new Intent(getActivity(), EmergencyNumberActivity.class);
        startActivity(intentCall);
    }

    private void IntentAbout() {
        Intent intent = new Intent(getActivity(), AboutActivity.class);
        startActivity(intent);
    }

    private void IntentRumahSakit() {
        Intent intent = new Intent(getActivity(), RumahSakitRujukanActivity.class);
        startActivity(intent);
    }
}
