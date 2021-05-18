package com.zonew.implicitintents;

import androidx.appcompat.app.AppCompatActivity;
import androidx.core.app.ShareCompat;

import android.content.Intent;
import android.net.Uri;
import android.os.Bundle;
import android.util.Log;
import android.view.View;
import android.widget.EditText;

public class MainActivity extends AppCompatActivity {
    EditText etWed;
    EditText etMap;
    EditText etMsg;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        // เชื่อม [ตัวแปร] กับ ActivityMain
        etWed = findViewById(R.id.idEtWeb);
        etMap = findViewById(R.id.idEtLocation);
        etMsg = findViewById(R.id.idEtMsg);

    }

    // Open web
    public void openWeb(View v) {
        String str = etWed.getText().toString();            // นำข้อความของ [etWed] เก็บไว้ใน [str]
        Uri    web = Uri.parse("https://"+str);             // [str] แปลงเป็น [เว็บไซต์]
        Intent   i = new Intent(Intent.ACTION_VIEW,web);    // สร้าง Action_view ไว้เปิด Web
        if(i.resolveActivity(getPackageManager()) != null)  // มี PackageManager ไหม (มั่ว)
            startActivity(i);                               // เริ่มทำงาน
        else
            Log.d("ImplicitIntents","Cannot handle this intent.");
    }

    // Open Map
    public void openMap(View v) {
        String str = etMap.getText().toString();            // นำข้อความของ [etWed] เก็บไว้ใน [str]
        Uri    map = Uri.parse("geo:0,0?q="+str);           // [str] แปลงเป็น [พิกัด]
        Intent   i = new Intent(Intent.ACTION_VIEW,map);    // สร้าง Action_view ไว้เปิด Map
        if(i.resolveActivity(getPackageManager()) != null)  // มี PackageManager ไหม (มั่ว)
            startActivity(i);                               // เริ่มทำงาน
        else
            Log.d("ImplicitIntents","Cannot handle this intent.");
    }

    // Share Massage
    public void shareMsg(View v) {
        String str = etMsg.getText().toString();
        ShareCompat.IntentBuilder
                .from(this)
                .setType("Text/pain")
                .setChooserTitle("Choose app to share.")
                .setText(str)
                .startChooser();
    }
}