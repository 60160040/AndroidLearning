package com.zonew.myprojactaffterupdate;

import androidx.appcompat.app.AppCompatActivity;

import android.os.Bundle;
import android.view.View;
import android.widget.EditText;

public class AddMemberActivity extends AppCompatActivity {
    EditText etPhoneNumber,etName;


    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_add_member);

        etPhoneNumber = findViewById(R.id.idEtPhoneNumber);
        etName = findViewById(R.id.idEtName);


    }


}