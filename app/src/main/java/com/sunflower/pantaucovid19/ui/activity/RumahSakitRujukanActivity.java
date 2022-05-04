package com.sunflower.pantaucovid19.ui.activity;

import android.os.Bundle;

import androidx.annotation.NonNull;
import androidx.annotation.Nullable;

import com.sunflower.pantaucovid19.base.BaseActivity;
import com.sunflower.pantaucovid19.databinding.ActivityRumahSakitRujukanBinding;

public class RumahSakitRujukanActivity extends BaseActivity<ActivityRumahSakitRujukanBinding> {

    @NonNull
    @Override
    public ActivityRumahSakitRujukanBinding setupViewBinding() {
        return ActivityRumahSakitRujukanBinding.inflate(getLayoutInflater());
    }

    @Override
    public void setupOnCreate(@Nullable Bundle bundle) {

    }

}
