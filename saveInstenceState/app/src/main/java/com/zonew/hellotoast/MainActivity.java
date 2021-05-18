package com.zonew.hellotoast;

import androidx.annotation.NonNull;
import androidx.appcompat.app.AppCompatActivity;

import android.os.Bundle;
import android.view.View;
import android.widget.TextView;
import android.widget.Toast;

public class MainActivity extends AppCompatActivity {
    private int number =0;
    private TextView tvCount; //เอาไว้เชื่อมกับ activity_main (UI)

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        // เชื่อมตัวแปรกับ activity_main (UI)
        tvCount = findViewById(R.id.txtCountDisplay);
        // R.id.<ตัวแปรฝั่ง activity_main (UI)>

        // มีข้อมูลอยู่ก่อนหน้านี้ไหม ?
        if(savedInstanceState != null){                                        // ถ้ามีค่าอยู่
            if(savedInstanceState.getBoolean("REPLY") == true){           // มีการตอบกลับจากหน้า 2 แล้ว
                String str = savedInstanceState.getString("REPLY_TEXT");  // เอาข้อความออกมาเก็บที่ตัวแปร [str]
                tvCount.setText(str);                                          // set ข้อความแสดงผล
                tvCount.setVisibility(View.VISIBLE);                           // ให้ข้อความมองเห็น
            }
        }
    }

    // save ข้อมูลก่อนเปลี่ยน state
    @Override
    protected void onSaveInstanceState(@NonNull Bundle outState) {
        super.onSaveInstanceState(outState);

        if(tvCount.getVisibility() == View.VISIBLE){
            outState.putBoolean("REPLY",true);
            outState.putString("REPLY_TEXT",tvCount.getText().toString());
        }
    }

    public void showMessage(View v){
        Toast t = Toast.makeText(this,"Hello ZiXAX",Toast.LENGTH_LONG);
        t.show();   // show ข้อความ pop up ชั่วคราว
    }

    public void countUp(View v) {
        String strNumber;
        number =number +1 ;                     // เเพิ่มค่า
        strNumber = Integer.toString(number);   // เปลี่ยงเป็น String
        tvCount.setText(strNumber);             // set ที่ TextView
    }
}