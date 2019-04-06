package edu.monash.hackamon.spot;

import android.content.Intent;
import android.support.v4.view.ViewPager;
import android.support.v7.app.AppCompatActivity;
import android.support.design.widget.TabLayout;
import android.os.Bundle;
import android.widget.TextView;

public class MainActivity extends AppCompatActivity {

    private TabAdapter adapter;
    private TabLayout tabLayout;
    private ViewPager viewPager;

    TextView yourLocation;

    TextView libraryName;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        viewPager = (ViewPager) findViewById(R.id.viewPager);
        tabLayout = (TabLayout) findViewById(R.id.tabLayout);

        adapter = new TabAdapter(getSupportFragmentManager());
        adapter.addFragment(new Tab1Fragment(), "Tab 1");
        adapter.addFragment(new Tab2Fragment(), "Tab 2");
        adapter.addFragment(new Tab3Fragment(), "Tab 3");
        adapter.addFragment(new Tab4Fragment(), "Tab 4");

        viewPager.setAdapter(adapter);
        tabLayout.setupWithViewPager(viewPager);
    }

    public void getYourLocation() {}

    public void gotoLibrary(String libraryID) {

        startActivity(new Intent(this, LibraryInfo.class)
                .putExtra("libraryID", libraryID));
    }
}
