package com.zonew.fivebutton;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.os.Bundle;
import android.view.View;

public class MainActivity extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
    }

    public void twoActivities(View v){
        Intent i = new Intent(this, twoActivity.class);
      //startActivityForResult(i, 1);
        startActivity(i);
    }
    public void count(View v){
        Intent i = new Intent(this, CountActivity.class);
        startActivity(i);
    }
    public void scrollText(View v){
        Intent i = new Intent(this, ScrollText.class);
        startActivity(i);
    }
    public void implicitIntents(View v){
        Intent i = new Intent(this, ImplicitIntents.class);
        startActivity(i);
    }
    public void EasyCalculate(View v){
        Intent i = new Intent(this, EasyCalculate.class);
        startActivity(i);
    }

}
