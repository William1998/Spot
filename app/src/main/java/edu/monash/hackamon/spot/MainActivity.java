package edu.monash.hackamon.spot;

import android.content.Intent;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.widget.TextView;

public class MainActivity extends AppCompatActivity {

    TextView yourLocation;

    TextView libraryName;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
    }

    public void getYourLocation() {}

    public void gotoLibrary(String libraryID) {

        startActivity(new Intent(this, LibraryInfo.class)
                .putExtra("libraryID", libraryID));
    }
}
