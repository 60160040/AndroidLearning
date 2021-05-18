package com.zonew.friendship;

import androidx.appcompat.app.AppCompatActivity;

import android.database.sqlite.SQLiteDatabase;
import android.os.Bundle;
import android.view.View;
import android.widget.EditText;

public class DeletePersonActivity extends AppCompatActivity {
    EditText etId;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_delete_person);

        etId = findViewById(R.id.idEtPersonIdDelete);
    }

    public void deletePersonData(View v){
        //เอา id มา
        String strId = etId.getText().toString();
        int id = Integer.parseInt(strId);

        DBHelper dh = new DBHelper(getApplicationContext());
        SQLiteDatabase db = dh.getWritableDatabase();

        dh.deletePerson(id,db);
    }
}