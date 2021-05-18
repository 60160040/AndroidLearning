package com.zonew.hellotoast;

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
        tvCount = findViewById(R.id.txtDisplay);  // เชื่อมตัวแปรกับ activity_main (UI)
        // R.id.<ตัวแปรฝั่ง activity_main (UI)>
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

    public void countDown(View v) {
        String strNumber;
        number =number -1 ;                     // เเพิ่มค่า
        strNumber = Integer.toString(number);   // เปลี่ยงเป็น String
        tvCount.setText(strNumber);             // set ที่ TextView
    }

    public void reset(View v) {
        String strNumber;
        number = 0 ;                     // เเพิ่มค่า
        strNumber = Integer.toString(number);   // เปลี่ยงเป็น String
        tvCount.setText(strNumber);             // set ที่ TextView
    }
}