package com.zonew.friendship;

import androidx.appcompat.app.AppCompatActivity;

import android.database.sqlite.SQLiteDatabase;
import android.os.Bundle;
import android.view.View;
import android.widget.EditText;

public class UpdatePersonActivity extends AppCompatActivity {
    EditText etId,etName,etEmail,etAddress,etTell;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_update_person);

        // เชื่อมตัวแปร
        etId = findViewById(R.id.idEtPersonIdUpdate);
        etName = findViewById(R.id.idEtPersonNameUpdate);
        etEmail = findViewById(R.id.idEtPersonEmailUpdate);
        etAddress = findViewById(R.id.idEtPersonAddressUpdate);
        etTell = findViewById(R.id.idEtPersonTellUpdate);

    }

    public void updatePersonData(View v) {
        // ดึงข้อมูลจากกล่องข้อความ
        String strId = etId.getText().toString();
        int id = Integer.parseInt(strId);
        String strName = etName.getText().toString();
        String strEmail = etEmail.getText().toString();
        String strAddress = etAddress.getText().toString();
        String strTell = etTell.getText().toString();

        // เอาข้อมูลลง  Database
        DBHelper dh = new DBHelper(getApplicationContext());
        SQLiteDatabase db = dh.getWritableDatabase();
        dh.updatePerson(id,strName,strEmail,strAddress,strTell,db);
        dh.close();
    }
}