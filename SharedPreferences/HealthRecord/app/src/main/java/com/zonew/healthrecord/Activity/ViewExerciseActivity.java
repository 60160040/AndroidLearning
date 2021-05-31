package com.zonew.healthrecord.Activity;

import androidx.appcompat.app.AppCompatActivity;

import android.os.Bundle;
import android.view.View;
import android.widget.TextView;

import com.zonew.healthrecord.R;
import com.zonew.healthrecord.SavedData;

public class ViewExerciseActivity extends AppCompatActivity {

    TextView  tvWalk   ; // ข้อความแสดงผล walk
    TextView  tvJog    ; // ข้อความแสดงผล jog

    float     walk,jog ; // รับข้อมูลจาก SavedData

    SavedData sd       ; // ข้อมูลที่บันทึกไว้


    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_view_exercise);

        // เเชื่อมตัวแปล
        tvWalk = findViewById(R.id.idTvWalkDisplay) ;
        tvJog  = findViewById(R.id.idTvJogDisplay)  ;

        // สร้างตัวเก็บข้อมูล
        sd = new SavedData(getApplicationContext()) ;
        walk = sd.readWalk()                        ; // ดึงข้อมูล walk ที่เก็บออกมา
        jog  = sd.readJog()                         ; // ดึงข้อมูล jog ที่เก็บออกมา

        // แปลงเป็น String
        String strW = Float.toString(walk) ;
        String strJ = Float.toString(jog)  ;

        // set ข้อความแสดงผล
        tvWalk.setText(strW) ;
        tvJog.setText(strJ)  ;

    }

    public void clearData(View v){
        sd.writeWalk(0) ;
        sd.writeJog ( 0) ;
        tvWalk.setText("0.0") ;
        tvJog.setText("0.0")  ;

    }
}