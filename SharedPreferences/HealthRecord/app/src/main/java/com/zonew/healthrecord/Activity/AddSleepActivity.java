package com.zonew.healthrecord.Activity;

import androidx.appcompat.app.AppCompatActivity;

import android.os.Bundle;
import android.view.View;
import android.widget.EditText;
import android.widget.Toast;

import com.zonew.healthrecord.R;
import com.zonew.healthrecord.SavedData;

public class AddSleepActivity extends AppCompatActivity {

    float hrs    ;
    int   wakeup ; // ค่า hours, wakeup ที่มีอยู่
    int count    ; // จำนวนวันที่นอน

    EditText etHrs    ; // กล่องข้อความ hours
    EditText etWakeup ; // กล่องข้อความ wakeup

    SavedData sd      ; // บันทึกข้อมูล
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_add_sleep);

        etHrs = findViewById(R.id.idEtHours)        ; // เชื่อมกับ กล่องข้อความ hours
        etWakeup = findViewById(R.id.idEtWakeup)    ; // เชื่อมกับ กล่องข้อความ wakeup

        sd = new SavedData(getApplicationContext()) ; // สร้างตัวบันทึกข้อมูล
        hrs = sd.readHours()    ; // เรียกค่า hours ที่เก็บไว้
        wakeup = sd.readWakeup() ; // เรียกค่า wakeup ที่เก็บไว้
        count = sd.readCount()  ; // เรียกค่า count ที่เก็บไว้
    }

    public void addSleep(View v){

        String strW,strJ                     ; // เก็บ String จากกล่องข้อความ
        strW = etHrs.getText().toString()    ; // เก็บ hours เป็น String
        strJ = etWakeup.getText().toString() ; // เก็บ wakeup  เป็น String

        float h                    ;
        int   t                    ; // hours, times ที่กรอกเพิ่มมา
        h = Float.parseFloat(strW) ; // แปลง hours เป็น float
        t = Integer.parseInt(strJ) ; // แปลง wakeup  เป็น float
        hrs += h                   ; // บวกกับค่าเดิม
        wakeup += t                ; // บวกกับค่าเดิม
        count ++                   ; // เพิ่มจำนนวัน
        sd.writeHours(hrs)         ; // บันทึก hours ลงไฟล์
        sd.writeWakeup(wakeup)      ; // บันทึก wakeup ลงไฟล์
        sd.writeCount(count)       ; // บันทึก count ลงไฟล์

        Toast.makeText(this,"add",Toast.LENGTH_SHORT).show();

        finish()       ; // ปิดหน้า Activity นี้

    }
}