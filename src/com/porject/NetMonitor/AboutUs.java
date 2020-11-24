package com.porject.NetMonitor;

/**
 * Created by Rahul Dcosta on 11/11/2015.
 */
import android.app.ActionBar;
import android.app.Activity;
import android.os.Bundle;

public class AboutUs  extends Activity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.about);

        // get action bar
        ActionBar actionBar = getActionBar();

        // Enabling Up / Back navigation
        actionBar.setDisplayHomeAsUpEnabled(true);
        actionBar.setIcon(R.drawable.micon);

    }
}