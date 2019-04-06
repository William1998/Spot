package edu.monash.hackamon.spot;

import android.content.Intent;
import android.content.pm.PackageManager;
import android.os.Bundle;
import android.support.annotation.Nullable;
import android.support.design.widget.TabLayout;
import android.support.v4.view.ViewPager;
import android.support.v7.app.AppCompatActivity;

public class LibraryInfo extends AppCompatActivity {

    private TabAdapter adapter;
    private TabLayout tabLayout;
    private ViewPager viewPager;

    boolean hasGPS;


    @Override
    protected void onCreate(@Nullable Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.library_info);

        Intent intent = getIntent();
        this.setTitle(intent.getStringExtra("campus"));

        viewPager = (ViewPager) findViewById(R.id.viewPager);
        tabLayout = (TabLayout) findViewById(R.id.tabLayout);

        adapter = new TabAdapter(getSupportFragmentManager());
        adapter.addFragment(new TabFragment(), "Hargrave-Andrew");
        adapter.addFragment(new TabFragment(), "Sir Louis Matheson");
        adapter.addFragment(new TabFragment(), "Law Library");
        adapter.addFragment(new TabFragment(), "LTB");

        viewPager.setAdapter(adapter);
        tabLayout.setupWithViewPager(viewPager);

        PackageManager packageManager = this.getPackageManager();
        hasGPS = packageManager.hasSystemFeature(PackageManager.FEATURE_LOCATION_GPS);
    }
}
