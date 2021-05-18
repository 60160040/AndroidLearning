package com.zonew.healthrecord;

import androidx.appcompat.app.AppCompatActivity;

import android.os.Bundle;
import android.view.View;
import android.widget.EditText;
import android.widget.Toast;

public class AddExerciseActivity extends AppCompatActivity {

    float walk,jog  ; // ค่า walk, jog ที่มีอยู่

    EditText etWalk ; // กล่องข้อความ Walk
    EditText etJog  ; // กล่องข้อความ Jog

    SavedData sd    ; // บันทึกข้อมูล

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_add_exercise);

        etWalk = findViewById(R.id.idEtWalk) ; // เชื่อมกับ กล่องข้อความ Walk
        etJog  = findViewById(R.id.idEtJog)  ; // เชื่อมกับ กล่องข้อความ Jog

        sd = new SavedData(getApplicationContext()) ; // สร้างตัวบันทึกข้อมูล
        walk = sd.readWalk() ; // เรียกค่า walk ที่เก็บไว้
        jog  = sd.readJog()  ; // เรียกค่า jog ที่เก็บไว้
    }

    public void addExercise(View v){

        String strW,strJ                   ; // เก็บ String จากกล่องข้อความ
        strW = etWalk.getText().toString() ; // เก็บ Walk เป็น String
        strJ = etJog.getText().toString()  ; // เก็บ Jog  เป็น String

        float w,j                  ; // Walk, Jog ที่กรอกเพิ่มมา
        w = Float.parseFloat(strW) ; // แปลง Walk เป็น float
        j = Float.parseFloat(strJ) ; // แปลง Jog  เป็น float
        walk += w   ; // บวกกับค่าเดิม
        jog  += j   ; // บวกกับค่าเดิม
        sd.writeWalk(walk)            ; // บันทึก Walk ลงไฟล์
        sd.writeJog(jog)              ; // บันทึก Jog ลงไฟล์

        Toast.makeText(this,"add",Toast.LENGTH_SHORT).show();

        finish()       ; // ปิดหน้า Activity นี้

    }
}