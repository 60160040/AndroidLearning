package com.zonew.healthrecord;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.os.Bundle;
import android.view.View;

public class SleepActivity extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_sleep);
    }


    public void pageAdd(View v){
        Intent i = new Intent(this,AddSleepActivity.class);
        startActivity(i);
    }

    public void pageView(View v){
        Intent i = new Intent(this,ViewSleepActivity.class);
        startActivity(i);
    }
}