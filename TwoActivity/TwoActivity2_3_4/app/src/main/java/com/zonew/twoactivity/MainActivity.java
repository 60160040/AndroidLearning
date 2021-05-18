package com.zonew.twoactivity;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.EditText;
import android.widget.TextView;

public class MainActivity extends AppCompatActivity {
    TextView tvValueback;      //ข้อความที่แสดง
    EditText etMsgSend;     //ข้อความที่จะส่ง
    String msgReply;        //ข้อความที่รับมา

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        //  เชื่อมตัวแปรกับ Activity
        etMsgSend = findViewById(R.id.idEtMsgSend);
        tvValueback = findViewById(R.id.idTvValueback);

        Intent i =getIntent();                                        //  รับค่าจาก activity อื่นมา
        msgReply = i.getStringExtra("MSG_REPLY");              //   เก็บ [String] ไว้ที่ตัวแปร
        tvValueback.setText(msgReply);                                //   set ข้อความแสดงผล
    }

    public void goPage2(View v){
        Intent i = new Intent(this,MainActivity2.class);
        // Intent(ความตั้งใจ) ใช้สื่อสารกับ activity อื่น Intent(<จาก>,<ไปยัง>)
        String msg = etMsgSend.getText().toString(); //ข้อความจาก painText เก็บเป็นข้อความ [msg] เตรียมส่ง
        i.putExtra("MSG_SEND",msg);           //ส่งข้อความ
        startActivity(i);                           //เริ่มทำงาน [i]
        finish();                                   //ลบ page นี้ทิ้ง
    }
}