package com.jihee.nlcamping.activity;


import android.os.Bundle;
import android.view.MenuItem;
import android.widget.FrameLayout;

import androidx.annotation.NonNull;
import androidx.appcompat.app.AppCompatActivity;
import androidx.fragment.app.Fragment;

import com.google.android.material.bottomnavigation.BottomNavigationView;
import com.jihee.nlcamping.Model.CampingAdmin;
import com.jihee.nlcamping.R;


public class MainActivity extends AppCompatActivity {
    private CampingAdmin c;
    private FrameLayout frameLayout;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        c = new CampingAdmin();
        c.makingReview();
        c.setRandomPropertyAmentities();
        frameLayout = findViewById(R.id.fragmentContainer);

        BottomNavigationView bottomNavigationView = findViewById(R.id.bottomNavigationView);
        bottomNavigationView.setOnNavigationItemSelectedListener(navListener);
        if(savedInstanceState== null){
            bottomNavigationView.setSelectedItemId(R.id.homeFaragment);
        }
    }
    private BottomNavigationView.OnNavigationItemSelectedListener navListener =
            new BottomNavigationView.OnNavigationItemSelectedListener() {
                @Override
                public boolean onNavigationItemSelected(@NonNull MenuItem menuItem) {
                    Fragment selectedFragment =null;

                    switch (menuItem.getItemId()){
                        case R.id.homeFaragment:
                            selectedFragment = new HomeFargment();
                            break;
                        case R.id.favoriteFragment:
                            selectedFragment = new FavoriteFragment();
                            break;
                        case R.id.seachingFragment:
                            selectedFragment = new SearchFragment();
                            break;
                        case R.id.overviewFragment:
                            selectedFragment = new OverviewFragment();
                            break;
                        case R.id.settingFragment:
                            selectedFragment = new SettingFragment();
                            break;

                    }
                    getSupportFragmentManager().beginTransaction().replace(R.id.fragmentContainer,selectedFragment).commit();

                    return true;
                }
            };

}
