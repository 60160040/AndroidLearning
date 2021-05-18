package com.zonew.countrecord;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.TextView;

public class MainActivity extends AppCompatActivity {
    SavedData   sd        ;
    private int num       ;
    TextView    tvShowNum ;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState)            ;
        setContentView(R.layout.activity_main)        ;

        tvShowNum = findViewById(R.id.idTvShowNumber) ;  //เชื่อมตัวแปร

        // สร้างที่เก็บข้อมูล
        sd = new SavedData(getApplicationContext())   ;



        // เอาข้อมูลที่เก็บไว้ออกมา
        num = sd.readCountNum()             ;
        String str = Integer.toString(num)  ;
        tvShowNum.setText(str)              ;


    }

    // นับเลข
    public void countUp(View v){
        num = num + 1                      ;
        sd.writeCountNum(num)              ; // เขียนลงที่เก็บข้อมูล
        String str = Integer.toString(num) ;
        tvShowNum.setText(str)             ;



    }

    // Reset number
    public void reset(View v){
        num = 0                            ;
        sd.writeCountNum(num)              ;
        String str = Integer.toString(num) ;
        tvShowNum.setText(str)             ;
    }
}