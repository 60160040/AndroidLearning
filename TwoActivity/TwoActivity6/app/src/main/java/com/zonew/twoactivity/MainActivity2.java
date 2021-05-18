package com.zonew.twoactivity;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.os.Bundle;
import android.util.Log;
import android.view.View;
import android.widget.EditText;
import android.widget.TextView;

public class MainActivity2 extends AppCompatActivity {
    String msgSend;          //  ข้อความที่ส่งมา
    String msgReply;         //  ข้อความตอบกลับ
    TextView tvMsgSendShow;  //  ข้อความแสดงผล
    EditText etMsgReply;     //  กล่องข้อความตอบกลับ

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main2);
        Log.d("Main2","--onCreate--");
        //  เชื่อมตัวแปรกับ Activity
        tvMsgSendShow = findViewById(R.id.idTvDisplay2);
        etMsgReply    = findViewById(R.id.idEtMsgReply);

        Intent i = getIntent();                         //  รับข้อมูลจาก Activity อื่น
        msgSend = i.getStringExtra("MSG_SEND");  //  ข้อความที่รับมาเก็บที่ตัวแปร [msgSend]
        tvMsgSendShow.setText(msgSend);                 //  set ข้อความแสดงผล

    }

    public void goPage1(View v){
        Intent i = new Intent();                                 //  Intent เอาไว้สื่อสารกับ Activity อื่น
        msgReply = etMsgReply.getText().toString();              //  ข้อความจาก painText เก็บที่ตัวแปร [msgReply]
        i.putExtra("MSG_REPLY",msgReply);                 //  ส่งข้อมูล
        setResult(RESULT_OK,i);  // setResult(<สถานะ>,<ข้อมูลส่งกลับ>)  //  set ผลลัพธ์เป็น OK (ใช้คู่กลับ startActivityForResult)
        finish();                                               //  ลบ page นี้ทิ้ง
    }

    @Override
    protected void onStart() {
        super.onStart();
        Log.d("Main2","--onStart--");
    }

    @Override
    protected void onResume() {
        super.onResume();
        Log.d("Main2","--onResume--");
    }

    // running

    @Override
    protected void onPause() {
        super.onPause();
        Log.d("Main2","--onPause--");
    }

    @Override
    protected void onStop() {
        super.onStop();
        Log.d("Main2","--onStop--");
    }

    @Override
    protected void onRestart() {
        super.onRestart();
        Log.d("Mai2n","--onRestart--");
    }

    @Override
    protected void onDestroy() {
        super.onDestroy();
        Log.d("Main2","--onDestroy--");
    }

}