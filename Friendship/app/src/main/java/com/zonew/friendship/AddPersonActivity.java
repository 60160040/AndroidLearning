package com.zonew.friendship;

import androidx.appcompat.app.AppCompatActivity;

import android.database.sqlite.SQLiteDatabase;
import android.os.Bundle;
import android.view.View;
import android.widget.EditText;

public class AddPersonActivity extends AppCompatActivity {

    EditText etId,etName,etEmail,etAddress,etTell;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_addperson);

        etId = findViewById(R.id.idEtPersonId)           ;
        etName = findViewById(R.id.idEtPersonName)       ;
        etEmail = findViewById(R.id.idEtPersonEmail)     ;
        etAddress = findViewById(R.id.idEtPersonAddress) ;
        etTell = findViewById(R.id.idEtPersonTell)       ;
    }

    // เอาข้อมูลใส่ DB
    public void savePerson(View v) {
        // เก็บข้อความจาก Edit Text
        String strId      = etId.getText().toString()       ;
        String strName    = etName.getText().toString()     ;
        String strEmail   = etEmail.getText().toString()    ;
        String strAddress = etAddress.getText().toString()  ;
        String strTell    = etTell.getText().toString()     ;
        int id = Integer.parseInt(strId)                    ; // แปลง id เป็น int

        // สร้างตัวเก็บข้อมูล data base
        DBHelper dh = new DBHelper(getApplicationContext()) ;
        SQLiteDatabase db = dh.getWritableDatabase()        ; // อยากเขียน DB ใช้อันนี้

        // ใส่ข้อมูลลง database
        dh.addPerson(id,strName,strEmail,strAddress,strTell,db) ;
        dh.close() ;

        // Clear กล่องข้อความ
        etId.setText("");
        etName.setText("");
        etEmail.setText("");
        etAddress.setText("");
        etTell.setText("");

    }

}