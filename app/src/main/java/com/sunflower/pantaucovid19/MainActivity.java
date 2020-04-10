package com.sunflower.pantaucovid19;

import androidx.appcompat.app.AppCompatActivity;
import androidx.fragment.app.Fragment;
import androidx.fragment.app.FragmentManager;

import android.os.Bundle;
import android.util.Log;

import com.ismaeldivita.chipnavigation.ChipNavigationBar;
import com.sunflower.pantaucovid19.fragment.HomeFragment;
import com.sunflower.pantaucovid19.fragment.InfoFragment;

public class MainActivity extends AppCompatActivity {

    ChipNavigationBar bottomnav;
    FragmentManager fragmentManager;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        bottomnav = findViewById(R.id.navbar);
        if (savedInstanceState==null){
            bottomnav.setItemSelected(R.id.home,true);
            fragmentManager= getSupportFragmentManager();
            HomeFragment homeFragment = new HomeFragment();
            fragmentManager.beginTransaction()
                    .replace(R.id.fragment_container,homeFragment)
                    .commit();
        }

        bottomnav.setOnItemSelectedListener(new ChipNavigationBar.OnItemSelectedListener() {
            @Override
            public void onItemSelected(int i) {
                Fragment fragment = null;
                switch (i){
                    case R.id.home:
                        fragment = new HomeFragment();
                        break;
                    case R.id.info:
                        fragment = new InfoFragment();
                        break;
                }

                if (fragment !=null){
                    fragmentManager = getSupportFragmentManager();
                    fragmentManager.beginTransaction()
                            .replace(R.id.fragment_container,fragment)
                            .commit();
                } else {
                    Log.e("TAG","Error Creating Fragment");
                }
            }
        });
    }
}
