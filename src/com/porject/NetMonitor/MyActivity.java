package com.porject.NetMonitor;

import android.app.ActionBar;
import android.app.Activity;
import android.content.Intent;
import android.graphics.Color;
import android.os.Bundle;
import android.view.*;
import android.widget.*;
import android.widget.LinearLayout.LayoutParams;
import java.util.*;
import java.lang.*;
import java.io.*;
import java.util.Date;
import java.text.SimpleDateFormat;


public class MyActivity extends Activity {
    /**
     * Called when the activity is first created.
     */



    private LinearLayout mLayout;




    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        ActionBar actionBar = getActionBar();

// set the icon
        actionBar.setIcon(R.drawable.micon);

        setContentView(R.layout.main);

        mLayout = (LinearLayout) findViewById(R.id.datacontain);


        ///////////////////////////////////
        Calendar c = Calendar.getInstance();

        SimpleDateFormat ft = new SimpleDateFormat ("dd");
        int b = Integer.parseInt(ft.format(c.getTime()));



        c.set(Calendar.DAY_OF_MONTH, +b);



        int flag=1;
        int counter=1;

        c.add(Calendar.DATE, 0);



       String str;
        String mon;
        String daynyear;


        ft=new SimpleDateFormat("MMMM");

        mon=ft.format(c.getTime()).substring(0, 3);
        ft=new SimpleDateFormat("dd,yyyy");
        daynyear=ft.format(c.getTime());

        str=mon+" "+daynyear;
        mLayout.addView(Createrowwithdetails(str,6.45,4.20,15));

        while(flag!=0)
        {
            c.add(Calendar.DATE, -1);


            ft=new SimpleDateFormat("MMMM");

             mon=ft.format(c.getTime()).substring(0, 3);
            ft=new SimpleDateFormat("dd,yyyy");
             daynyear=ft.format(c.getTime());

             str=mon+" "+daynyear;
            mLayout.addView(Createrowwithdetails(str,6.45,4.20,15));
            if(counter==29)
            {
                flag=0;
                // System.out.println("success");

            }

            counter++;
        }

        //////////////////////////////

       mLayout.addView(Createrowwithdetails(" Last 7 days ",6.45,4.20,15));
       mLayout.addView(Createrowwithdetails(" Last 30 days ",6.45,4.420,15.89));






        /////////////////////////////

    }




    public LinearLayout Createrowwithdetails(String date,double mobile_mb,double wifi_mb,double total_mb)
    {
        LinearLayout dynamiclinearLayout = new LinearLayout(this);

        TextView textView = new TextView(this);


        dynamiclinearLayout.setOrientation(LinearLayout.HORIZONTAL);
        int x=100+1;
        dynamiclinearLayout.setId(x);
        LayoutParams layout_104 = new LayoutParams( LayoutParams.MATCH_PARENT,
                LayoutParams.WRAP_CONTENT);

        layout_104.topMargin = 3;
        dynamiclinearLayout.setLayoutParams(layout_104);



        textView.setText(date);

        textView.setTextAppearance(this, android.R.style.TextAppearance_Small);
        textView.setGravity(Gravity.LEFT);
        textView.setLayoutParams(new LayoutParams(
                LayoutParams.WRAP_CONTENT,
                LayoutParams.WRAP_CONTENT, 0.35f));

        textView.setBackgroundColor(0xff4f4f4f);
        dynamiclinearLayout.addView(textView);

        textView = new TextView(this);
        textView.setText(""+mobile_mb+"MB");

        textView.setTextAppearance(this, android.R.style.TextAppearance_Small);
        textView.setGravity(Gravity.CENTER);
        textView.setLayoutParams(new LayoutParams(
                LayoutParams.WRAP_CONTENT,
                LayoutParams.WRAP_CONTENT, 0.21f));
        textView.setTextColor(Color.BLACK);
        textView.setBackgroundColor(0xFFB1B1B1);
        dynamiclinearLayout.addView(textView);

        textView = new TextView(this);
        textView.setText(""+wifi_mb+"MB");
        textView.setTextAppearance(this, android.R.style.TextAppearance_Small);
        textView.setGravity(Gravity.CENTER);
        textView.setLayoutParams(new LayoutParams(
                LayoutParams.WRAP_CONTENT,
                LayoutParams.WRAP_CONTENT, 0.21f));
        textView.setTextColor(Color.BLACK);
        textView.setBackgroundColor(0xFFB1B1B1);
        dynamiclinearLayout.addView(textView);

        textView = new TextView(this);
        textView.setText(""+total_mb+"MB");
        textView.setTextAppearance(this, android.R.style.TextAppearance_Small);
        textView.setGravity(Gravity.CENTER);
        textView.setLayoutParams(new LayoutParams(
                LayoutParams.WRAP_CONTENT,
                LayoutParams.WRAP_CONTENT, 0.23f));
        textView.setTextColor(Color.BLACK);
        textView.setBackgroundColor(0xFFB1B1B1);
        dynamiclinearLayout.addView(textView);

        return dynamiclinearLayout;
    }


    @Override
    public boolean onCreateOptionsMenu(Menu menu) {
        MenuInflater inflater = getMenuInflater();
        inflater.inflate(R.menu.activity_main_actions, menu);

        return super.onCreateOptionsMenu(menu);
    }


    @Override
    public boolean onOptionsItemSelected(MenuItem item) {
//        TextView myAwesomeTextView ;
        // Take appropriate action for each action item click
        switch (item.getItemId()) {
            case R.id.action_refresh:
                //Reset Couter Actions


//                myAwesomeTextView.setText("Reset Coutner Successful");
                return true;
            case R.id.action_about:
                // About Us Page action
                Aboutus();
//                myAwesomeTextView.setText("About Us Clicked");
                return true;


            case R.id.action_removentify:
                // disable notification action

//                myAwesomeTextView.setText("disable notify Clicked");

                //changing disable txt to enable notification txt here.
                return true;
            case R.id.action_export:
                // export to pdf  action
                Reports();
               // myAwesomeTextView.setText("Export  Clicked");
                return true;
            case R.id.action_stop:
                // stop n exit clicked
//                myAwesomeTextView.setText("Stop and exit clicked");

                //Kill the app code here
               // LocationFound();
                System.exit(0);
                return true;
            default:
                return super.onOptionsItemSelected(item);
        }
    }


    private void Aboutus() {
        Intent i = new Intent(MyActivity.this, AboutUs.class);
        startActivity(i);
    }

    private void Reports() {
        Intent i = new Intent(MyActivity.this, Reports.class);
        startActivity(i);
    }
}
