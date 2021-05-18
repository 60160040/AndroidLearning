package com.zonew.flowershop;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.Toast;

public class MainActivity extends AppCompatActivity {
    //String strOrder ="No item selected"; // hard code
    String strOrder ; // เก็บรายการที่เพิ่มใส่ตะกร้า
    //public static final String ORDER_KEY = "ORDER"; // key ของ Intent ที่ส่ง (แบบง่าย)
    public static final String ORDER_KEY = "com.zonew.flowershop.ORDER"; // แบบใช้งานจริง จะได้ม่ซ้ำกับอันอื่น **แนะนำอันนี้

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        strOrder = getString(R.string.no_selected); // set ข้อความเริ่มต้น
    }

    public void orderPug(View v) {
        strOrder = getString(R.string.order_pug);                         // เอามาจากไฟล์ string.xml
        Toast.makeText(this,strOrder,Toast.LENGTH_SHORT).show();  // Toast = pop up ข้อความ
    }

    public void orderConfused(View v) {
        strOrder = getString(R.string.order_Confused_dog);
        Toast.makeText(this, strOrder,Toast.LENGTH_SHORT).show();
    }

    public void orderLittle(View v){
        strOrder = getString(R.string.order_little_dog);
        Toast.makeText(this,strOrder,Toast.LENGTH_SHORT).show();
    }

    public void order(View v) {
        Intent i = new Intent(this,OrderActivity.class);
        i.putExtra(ORDER_KEY,strOrder);
        startActivity(i);
    }
}