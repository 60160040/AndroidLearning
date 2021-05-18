package com.zonew.flowershop;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.os.Bundle;
import android.widget.TextView;

public class OrderActivity extends AppCompatActivity {
    TextView tvOrder;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_order);

        tvOrder = findViewById(R.id.idTvOrder);

        Intent i = getIntent();
        //String str = "Order : " + i.getStringExtra("ORDER");  // แบบพื้นฐาน
        String str = "Order : " + i.getStringExtra(MainActivity.ORDER_KEY); // แบบง่าย
        tvOrder.setText(str);

    }
}