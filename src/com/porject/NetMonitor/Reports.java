package com.porject.NetMonitor;

/**
 * Created by Rahul Dcosta on 11/12/2015.
 */
import android.app.ActionBar;
import android.app.Activity;
import android.os.Bundle;

public class Reports  extends Activity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.reports);


        // get action bar
        ActionBar actionBar = getActionBar();

        // Enabling Up / Back navigation
        actionBar.setDisplayHomeAsUpEnabled(true);
        actionBar.setIcon(R.drawable.micon);

    }
}