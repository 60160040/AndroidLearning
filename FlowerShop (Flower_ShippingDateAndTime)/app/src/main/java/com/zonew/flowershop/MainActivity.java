package com.zonew.flowershop;

import androidx.annotation.NonNull;
import androidx.appcompat.app.AppCompatActivity;
import androidx.appcompat.widget.Toolbar;

import android.content.Intent;
import android.os.Bundle;
import android.view.Menu;
import android.view.MenuInflater;
import android.view.MenuItem;
import android.view.View;
import android.widget.Toast;

import com.google.android.material.floatingactionbutton.FloatingActionButton;

public class MainActivity extends AppCompatActivity {
    //String strOrder ="No item selected"; // hard code
    String strOrder ;                // เก็บรายการที่เพิ่มใส่ตะกร้า
    FloatingActionButton fbShopping; // ปุ่มราการที่เลือก
    Toolbar tbMenuBar;               // menu bar


    //public static final String ORDER_KEY = "ORDER"; // key ของ Intent ที่ส่ง (แบบง่าย)
    public static final String ORDER_KEY = "com.zonew.flowershop.ORDER"; // แบบใช้งานจริง จะได้ม่ซ้ำกับอันอื่น **แนะนำอันนี้

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        strOrder = getString(R.string.no_selected); // set ข้อความเริ่มต้น

        fbShopping = findViewById(R.id.idFbShoppingCart);   // เชื่อมตัวแปร[ปุ่ม]
        fbShopping.setEnabled(false);                       // ปุ่มไม่สามารถกดได้

        // Menu bar
        tbMenuBar = findViewById(R.id.idTbMenuBar);         // เชื่อมตัวแปร [menu]
        setSupportActionBar(tbMenuBar);                     // ทำ toolbar เป็น actionbar
    }


    // Create Menu Bar
    @Override
    public boolean onCreateOptionsMenu(Menu menu) {
        MenuInflater mi = getMenuInflater();  // สร้างตัรแปรรับข้อมูล
        mi.inflate(R.menu.main_menu,menu);    // เชื่อมข้อมูล
        return true;
    }

    // Selected Option
    @Override
    public boolean onOptionsItemSelected(@NonNull MenuItem item) {
        int id = item.getItemId(); // เก็บ id
        switch(id){
            case R.id.idMenuOrder:
                Toast.makeText(this,"You select menu Order",Toast.LENGTH_SHORT).show();
                Intent i = new Intent(this,OrderActivity.class);
                i.putExtra(ORDER_KEY,strOrder);
                startActivity(i);
                break;
            case R.id.idMenuStatus:
                Toast.makeText(this,"You select menu Status",Toast.LENGTH_SHORT).show();
                break;
            case R.id.idMenuFavorites:
                Toast.makeText(this,"You select menu Favorites",Toast.LENGTH_SHORT).show();
                break;
            case R.id.idMenuContact:
                Toast.makeText(this,"You select menu Contact",Toast.LENGTH_SHORT).show();
                break;
            default:
                return super.onOptionsItemSelected(item);

        }
        return true;
    }

    public void orderPug(View v) {
        strOrder = getString(R.string.order_pug);                         // เอามาจากไฟล์ string.xml
        Toast.makeText(this,strOrder,Toast.LENGTH_SHORT).show();  // Toast = pop up ข้อความ
        fbShopping.setEnabled(true);              // ปุ่มสามารถกดได้
    }

    public void orderConfused(View v) {
        strOrder = getString(R.string.order_Confused_dog);
        Toast.makeText(this, strOrder,Toast.LENGTH_SHORT).show();
        fbShopping.setEnabled(true);
    }

    public void orderLittle(View v){
        strOrder = getString(R.string.order_little_dog);
        Toast.makeText(this,strOrder,Toast.LENGTH_SHORT).show();
        fbShopping.setEnabled(true);
    }

    public void order(View v) {
        Intent i = new Intent(this,OrderActivity.class);
        i.putExtra(ORDER_KEY,strOrder);
        startActivity(i);
    }
}