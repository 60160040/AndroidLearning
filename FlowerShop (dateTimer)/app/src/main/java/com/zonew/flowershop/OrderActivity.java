package com.zonew.flowershop;

import androidx.annotation.NonNull;
import androidx.appcompat.app.AppCompatActivity;
import androidx.appcompat.widget.Toolbar;
import androidx.fragment.app.DialogFragment;

import android.app.AlertDialog;
import android.content.DialogInterface;
import android.content.Intent;
import android.os.Bundle;
import android.view.Menu;
import android.view.MenuInflater;
import android.view.MenuItem;
import android.view.View;
import android.widget.AdapterView;
import android.widget.ArrayAdapter;
import android.widget.EditText;
import android.widget.Spinner;
import android.widget.TextView;
import android.widget.Toast;

public class OrderActivity extends AppCompatActivity implements AdapterView.OnItemSelectedListener {
    TextView tvOrder   ; // รายการที่เลือก
    Spinner spPhoneType; // ประเภทเบอร์โทร
    String str         ; // เก็บประเภทเบอร์โทร
    Toolbar tbMenuBar  ; // menu bar

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_order);

        tvOrder = findViewById(R.id.idTvOrder);         // เชื่อมตัวแปร [ข้อความแสดงผล]
        spPhoneType = findViewById(R.id.idSpPhoneType); // เชื่อมตัวแปร [ประเภทเบอร์โทร]

        // แสดงชื่อรายการที่เลือก
        Intent i = getIntent();
        //String str = "Order : " + i.getStringExtra("ORDER");  // แบบพื้นฐาน
        String str = "Order : " + i.getStringExtra(MainActivity.ORDER_KEY); // แบบง่าย
        tvOrder.setText(str);

         // แสดง ประเภทเบอร์โทรศัพท์
        spPhoneType.setOnItemSelectedListener(this);  // ใครเป็นผู้ดักฟัง (ตัวเอง) เมื่อเลือกจาก spinner (dropdown)
        ArrayAdapter<CharSequence> a = ArrayAdapter.createFromResource(this,R.array.phone_type_array,
                android.R.layout.simple_spinner_dropdown_item);  // ArrayAdapter.createFromResource(<ที่ไหน>,<ข้อมูลจาก>,<รูปแบบ>)
        a.setDropDownViewResource(android.R.layout.simple_spinner_dropdown_item); // set รูปแบบ
        spPhoneType.setAdapter(a); // เริ่มทำการ set

        // Menu bar
        tbMenuBar = findViewById(R.id.idTbMenuBarOrder);         // เชื่อมตัวแปร [menu]
        setSupportActionBar(tbMenuBar);                     // ทำ toolbar เป็น actionbar
    }

    // Create Menu bar
    @Override
    public boolean onCreateOptionsMenu(Menu menu) {
        MenuInflater mi = getMenuInflater();  // สร้างตัรแปรรับข้อมูล
        mi.inflate(R.menu.order_menu,menu);   // เชื่อมข้อมูล
        return true;
    }

    // Selected Option
    @Override
    public boolean onOptionsItemSelected(@NonNull MenuItem item) {
        int id = item.getItemId(); // เก็บ id
        switch(id){
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

    // Age
    public void selectAge(View v){
        int id = v.getId();
        switch (id){
            case R.id.idRbLessThen18:
                Toast.makeText(this,"You select less then 18.",Toast.LENGTH_SHORT).show(); // Toast: popup ชั่วคราว
                break;
            case R.id.idRb18to40:
                Toast.makeText(this,"You select 18 to 40.",Toast.LENGTH_SHORT).show();
                break;
            case R.id.idRbMoreThen40:
                Toast.makeText(this,"You select more then.",Toast.LENGTH_SHORT).show();
                break;
        }
    }

    // Delivery Method
    public void selectDelivery(View v){
        int id = v.getId();  // id ของ radio Button ที่เลือก
        switch (id) {
            case R.id.idRbSameday:
                Toast.makeText(this,"You select Same Day Delivery.",Toast.LENGTH_SHORT).show(); // Toast: popup ชั่วคราว
                break;
            case R.id.idRbnextday:
                Toast.makeText(this,"You select Next Day Delivery.",Toast.LENGTH_SHORT).show();
                break;
            case R.id.idRbPickup:
                Toast.makeText(this,"You select Pick up.",Toast.LENGTH_SHORT).show();
                break;
        }
    }

    // เมื่อ item(ประเภทเนอร์โทร) ถูกเลือก
    @Override
    public void onItemSelected(AdapterView<?> adapterView, View view, int i, long l) { // i คือ Position
        str = adapterView.getItemAtPosition(i).toString();
        Toast.makeText(this,str,Toast.LENGTH_SHORT).show();  // แสดงข้อความแสดงผล
    }

    // เมื่อ item ไม่ถูกเลือก
    @Override
    public void onNothingSelected(AdapterView<?> adapterView) {

    }

    // Button Dialog Clear
    public void clearDialog(View v){
        final AlertDialog.Builder adb = new AlertDialog.Builder(this);
        adb.setTitle("Alert Message");
        adb.setTitle("Clear Data");
        adb.setMessage(" ");

        // create Positive button dialog
        adb.setPositiveButton("Clear", new DialogInterface.OnClickListener() {
            @Override
            public void onClick(DialogInterface dialogInterface, int i) {

                startActivity(new Intent(OrderActivity.this,OrderActivity.class)); // Reset (โหลดหน้า activity_order อีกครั้ง)
                finish(); // ปิดหน้านี้
            }

        });

        //create Negative button dialog
        adb.setNegativeButton("Cancel", new DialogInterface.OnClickListener() {
            @Override
            public void onClick(DialogInterface dialogInterface, int i) {
                dialogInterface.cancel(); // cancel
            }
        });
        adb.show();
    }

    // Button Date shipping
    public void dateShopping(View v){
        DialogFragment df = new DatePickerFragment();
        df.show(getSupportFragmentManager(),"DATE_PICKER");
    }

    // Show date (Toast)
    public void showDate(int year,int month,int day){
        String str;
        str = "Date : "+ year +"/"+ month +"/"+ day;
        Toast.makeText(this,str,Toast.LENGTH_SHORT).show();
    }

}