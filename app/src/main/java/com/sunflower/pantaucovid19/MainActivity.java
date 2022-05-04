package com.sunflower.pantaucovid19;

import android.os.Bundle;
import android.widget.Toast;

import androidx.annotation.NonNull;
import androidx.annotation.Nullable;

import com.ismaeldivita.chipnavigation.ChipNavigationBar;
import com.sunflower.pantaucovid19.base.BaseActivity;
import com.sunflower.pantaucovid19.databinding.ActivityMainBinding;
import com.sunflower.pantaucovid19.ui.fragment.BeritaFragment;
import com.sunflower.pantaucovid19.ui.fragment.HomeFragment;
import com.sunflower.pantaucovid19.ui.fragment.InfoFragment;
import com.sunflower.pantaucovid19.utils.Geography;
import com.sunflower.pantaucovid19.utils.LocationTrack;
import com.sunflower.pantaucovid19.utils.LocationsObject;

public class MainActivity extends BaseActivity<ActivityMainBinding> {

    private LocationTrack locate;

    @NonNull
    @Override
    public ActivityMainBinding setupViewBinding() {
        return ActivityMainBinding.inflate(getLayoutInflater());
    }

    @Override
    public void setupOnCreate(@Nullable Bundle bundle) {
        setupBottomNav(getBinding().navbar);
        locate = new LocationTrack(this);
        if (locate.canGetLocation()) {
            Geography geo = new Geography(locate.getLatitude(), locate.getLongitude(), this);
            LocationsObject lo = geo.getLocationObject();
            Toast.makeText(this, "Provinsi: " + lo.getState(), Toast.LENGTH_LONG).show();
        } else {
            locate.showSettingsAlert();
        }
    }

    private void setupBottomNav(ChipNavigationBar chipNavigationBar) {
        chipNavigationBar.setOnItemSelectedListener(i -> {
            switch (i) {
                case R.id.home:
                    setupFragment(new HomeFragment(), R.id.fragment_container);
                    break;
                case R.id.info:
                    setupFragment(new InfoFragment(), R.id.fragment_container);
                    break;
                case R.id.berita:
                    setupFragment(new BeritaFragment(), R.id.fragment_container);
                    break;
            }

        });
        chipNavigationBar.setItemSelected(R.id.home, true);
    }

    @Override
    protected void onDestroy() {
        super.onDestroy();
        locate.stopListener();
    }

}
