package com.zonew.twoactivity;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.os.Bundle;
import android.view.View;

public class MainActivity2 extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main2);
    }

    public void goPage1(View v){
        Intent i = new Intent(this,MainActivity.class);
        // Intent(ความตั้งใจ) ใช้สื่อสารกับ activity อื่น Intent(<จาก>,<ไปยัง>)
        startActivity(i);
        finish();   //ลบ page นี้ทิ้ง
    }
}