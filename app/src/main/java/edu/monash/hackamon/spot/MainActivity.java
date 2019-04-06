package edu.monash.hackamon.spot;

import android.content.Intent;
import android.content.pm.PackageManager;

import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;
import android.widget.TextView;

public class MainActivity extends AppCompatActivity{

    boolean hasGPS;
    TextView yourLocation;
    TextView libraryName;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        PackageManager packageManager = this.getPackageManager();
        hasGPS = packageManager.hasSystemFeature(PackageManager.FEATURE_LOCATION_GPS);
    }



    public void getYourLocation() {}

    public void selectCampus(View view) {

        TextView campus = (TextView) view;
        Intent intent = new Intent(this, LibraryInfo.class);
        intent.putExtra("campus", campus.getText().toString());

        startActivity(intent);
    }

}
