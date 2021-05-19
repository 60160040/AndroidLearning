package com.zonew.mywebview;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.net.Uri;
import android.os.Bundle;
import android.widget.TextView;

public class MainActivity extends AppCompatActivity {
    TextView tvContent;


    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        // เชื่อม [บัวแปร] กับ ActivityMain
        tvContent = findViewById(R.id.idTvContent);

        Intent i =  getIntent();            // รับข้อมูลมาจะที่อื่น
        Uri uri = i.getData();              // นำ data ใส่ [uri]
        if(uri != null){                    // ถ้า [uri] มีข้อมูล *กรณีเปิดแอปเองจะไม่มีข้อมูลต้องรับ Intent มา
            String str = uri.toString();    // นำข้อความ [uri] ใส่ [str]
            tvContent.setText(str);         // set ข้อความแสดงผล

        }
    }
}