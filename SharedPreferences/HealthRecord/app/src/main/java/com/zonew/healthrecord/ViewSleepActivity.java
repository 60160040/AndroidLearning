package com.zonew.healthrecord;

import androidx.appcompat.app.AppCompatActivity;

import android.os.Bundle;
import android.view.View;
import android.widget.TextView;
import android.widget.Toast;

public class ViewSleepActivity extends AppCompatActivity {

    TextView tvHours; // ข้อความแสดงผล hours
    TextView tvWakeup; // ข้อความแสดงผล wakeup

    float hours  ;
    int   wakeup ; // รับข้อมูลจาก SavedData
    int   count  ; // จำนวนวันที่นอน

    SavedData sd ; // ข้อมูลที่บันทึกไว้


    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_view_sleep);

        // เชื่อมตัวแปล
        tvHours = findViewById(R.id.idTvHoursDisplay) ;
        tvWakeup = findViewById(R.id.idTvWakeupDisplay)  ;

        // สร้างตัวเก็บข้อมูล
        sd = new SavedData(getApplicationContext()) ;
        hours = sd.readHours()                      ; // ดึงข้อมูล walk ที่เก็บออกมา
        wakeup = sd.readWakeup()                    ; // ดึงข้อมูล jog ที่เก็บออกมา
        count = sd.readCount()                      ; // ดึงข้อมูล count (วัน) ที่เก็บออกมา

        // หาค่า Average แต่ละวัน
        hours /= count;
        wakeup /= count;

        // แปลงเป็น String
        String strW = Float.toString(hours) ;
        String strJ = Integer.toString(wakeup)  ;

        // set ข้อความแสดงผล
        tvHours.setText(strW) ;
        tvWakeup.setText(strJ)  ;

    }

    public void clearData(View v){
        sd.writeHours(0)     ;
        sd.writeWakeup ( 0)  ;
        sd.writeCount(0)     ;
        tvHours.setText("0.0")  ;
        tvWakeup.setText("0") ;
        Toast.makeText(this,"Data Clear",Toast.LENGTH_SHORT).show();

    }

}