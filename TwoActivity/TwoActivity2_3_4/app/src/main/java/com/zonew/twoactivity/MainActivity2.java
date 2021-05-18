package com.zonew.twoactivity;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.EditText;
import android.widget.TextView;

public class MainActivity2 extends AppCompatActivity {
    TextView tvValue1Show;  //  ตัวแปรแสดงผล
    EditText etMsgReply;    //  กล่องข้อความ
    String str;             //  เอาไว้เก็บข้อความแสดงผล

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main2);

        // เชื่อมกับ Activity_main
        tvValue1Show = findViewById(R.id.idTvValue1Show); // เชื่อมตัวแสดงผล
        etMsgReply = findViewById(R.id.idEtMsgReply);     // เชื่อมกล่องข้อความ

        Intent i = getIntent();                        //  เอาไว้รับค่าจาก activity อื่น
        str = i.getStringExtra("MSG_SEND");     //  (String) ที่รับมาจาก Activity อื่นเก็บไว้ที [str]
        tvValue1Show.setText(str);                     //  set ข้อความแสดงผล



    }

    public void goPage1(View v){
        Intent i = new Intent(this,MainActivity.class);
        // Intent(ความตั้งใจ) ใช้สื่อสารกับ activity อื่น Intent(<จาก>,<ไปยัง>)
        String str= etMsgReply.getText().toString();     // นำขค่า painText เก็บใน [str] เตรียมส่ง
        i.putExtra("MSG_REPLY",str);              // ส่งข้อมความ
        startActivity(i);                                // เริ่มทำงาน [i]
        finish();                                        // ลบ page นี้ทิ้ง
    }
}