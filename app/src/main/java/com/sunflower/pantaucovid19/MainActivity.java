package com.sunflower.pantaucovid19;

import android.os.Bundle;

import com.ismaeldivita.chipnavigation.ChipNavigationBar;
import com.sunflower.pantaucovid19.base.BaseActivity;
import com.sunflower.pantaucovid19.ui.fragment.HomeFragment;
import com.sunflower.pantaucovid19.ui.fragment.InfoFragment;

public class MainActivity extends BaseActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        ChipNavigationBar bottomnav = findViewById(R.id.navbar);
        setupBottomNav(bottomnav);
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
            }

        });
        chipNavigationBar.setItemSelected(R.id.home, true);
    }

}
