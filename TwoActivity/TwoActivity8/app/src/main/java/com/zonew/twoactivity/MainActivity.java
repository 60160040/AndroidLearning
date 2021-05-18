package com.zonew.twoactivity;

import androidx.annotation.NonNull;
import androidx.annotation.Nullable;
import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.os.Bundle;
import android.util.Log;
import android.view.View;
import android.widget.EditText;
import android.widget.TextView;

public class MainActivity extends AppCompatActivity {
    EditText etMsgSend;       // กล่องข้อความ
    TextView tvMsgReplyShow;  // ข้อความแสดงผล
    String   msgReply;        // ข้อความตอบกลับมา

    public static final String LOG_TAG = MainActivity.class.getSimpleName(); // ใช้เป็น tag

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        Log.d(LOG_TAG,"--onCreate--");

        // เชื่อมตัวแปรกับ Activity
        etMsgSend      = findViewById(R.id.idEtMsgSend);     // เชื่อมกล่องข้อความ
        tvMsgReplyShow = findViewById(R.id.idTvDisplay);     // เชื่อม้อความแสดงผล

        // มีข้อมูลอยู่ก่อนหน้านี้ไหม ?
        if (savedInstanceState != null){                                // ถ้ามีค่าอยู่
            if (savedInstanceState.getBoolean("REPLY") == true){   // มีการตอบกลับจากหน้า 2 แล้ว
                    String str = savedInstanceState.getString("REPLY_TEXT"); // เอาข้อความออกมาเก็บที่ตัวแปร [str]
                tvMsgReplyShow.setText(str);                            // set ข้อความแสดงผล
                tvMsgReplyShow.setVisibility(View.VISIBLE);             // ให้ข้อความมองเห็น
            }
        }

    }

    // Save ค่าตัวเองก่อนที่จะเปลี่ยนสถานะ (rotate ,เปลี่ยน page)
    // เพื่อไม่ให้หมุนเครื่องแล้วค่าหาย
    @Override
    protected void onSaveInstanceState(@NonNull Bundle outState) {
        super.onSaveInstanceState(outState);
        if(tvMsgReplyShow.getVisibility() == View.VISIBLE){                         // ถ้าถูกมองเห็นอยู่เก็บค่าไว้
            outState.putBoolean("REPLY",true);                                      // set REPLY เป็น true
            outState.putString("REPLY_TEXT",tvMsgReplyShow.getText().toString());   // เก็บข้อความ
        }
    }

    public void goPage2(View v){
        Intent i = new Intent(this,MainActivity2.class);  // ส่งข้อมูลจาก page นี้ไป page2
        String str = etMsgSend.getText().toString();                     // เก็บข้อความจาก EditText ไว้ที่ตัวแปร [str]
        i.putExtra("MSG_SEND",str);                               // ส่งข้อมูล
        startActivityForResult(i,1);                        // ไปแบบรอคำตอบจากหน้านั้น
    }

    // สร้างเพราะใช้ starActivityForResult()  เมื่อกลับมาจะทำงานตรงนี้
    @Override
    protected void onActivityResult(int requestCode, int resultCode, @Nullable Intent data) {
        super.onActivityResult(requestCode, resultCode, data);

        // ตรวจที่เราส่งไปไหม ?
        if(requestCode == 1){  // ใช้ตัวที่เราส่งไปไหม ?
            if(resultCode == RESULT_OK){  // ส่งกลับมาถูกต้องหรือป่าว ?
                msgReply = data.getStringExtra("MSG_REPLY");  // เก็บข้อความที่รับรับมาไว้ที่ตัวแปร [msgReply]
                tvMsgReplyShow.setText(msgReply);                    // set ข้อความแสดงผลจาก [msgReply]
            }
        }
    }

    @Override
    protected void onStart() {
        super.onStart();
        Log.d(LOG_TAG,"--onStart--");
    }

    @Override
    protected void onResume() {
        super.onResume();
        Log.d(LOG_TAG,"--onResume--");
    }

    // running

    @Override
    protected void onPause() {
        super.onPause();
        Log.d(LOG_TAG,"--onPause--");
    }

    @Override
    protected void onStop() {
        super.onStop();
        Log.d(LOG_TAG,"--onStop--");
    }

    @Override
    protected void onRestart() {
        super.onRestart();
        Log.d(LOG_TAG,"--onRestart--");
    }

    @Override
    protected void onDestroy() {
        super.onDestroy();
        Log.d(LOG_TAG,"--onDestroy--");
    }

}