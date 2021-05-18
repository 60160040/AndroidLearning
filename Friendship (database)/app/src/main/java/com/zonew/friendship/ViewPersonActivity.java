package com.zonew.friendship;

import androidx.appcompat.app.AppCompatActivity;

import android.database.Cursor;
import android.database.sqlite.SQLiteDatabase;
import android.os.Bundle;
import android.widget.TextView;

public class ViewPersonActivity extends AppCompatActivity {
    TextView tvPerson;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_view_person);

        tvPerson = findViewById(R.id.idTvPersonDisplay);

        readData();
    }

    // read DATA
    public void readData(){
        DBHelper dh = new DBHelper(getApplicationContext());
        SQLiteDatabase db = dh.getReadableDatabase();

        Cursor c = dh.readPerson(db) ; // อ่านข้อมูลจาก database
        String str = ""              ; // สร้างชุดข้อความเอาไว้แสดงผล

        // loop ดึงข้อความ
        while(c.moveToNext() == true){      // อ่านตัวถัดไป ถ้าไม่มีเป็น false
            int colId            = c.getColumnIndex(DBStructure.Person.PERSON_ID)      ; // ID
            int personId         = c.getInt(colId)                                     ;

            colId                = c.getColumnIndex(DBStructure.Person.PERSON_NAME)    ; // name
            String personName    = c.getString(colId)                                  ;

            colId                = c.getColumnIndex(DBStructure.Person.PERSON_EMAIL)   ; // E-mail
            String personEmail   = c.getString(colId)                                  ;

            colId                = c.getColumnIndex(DBStructure.Person.PERSON_ADDRESS) ; // Address
            String personAddress = c.getString(colId)                                  ;

            colId                = c.getColumnIndex(DBStructure.Person.PERSON_TELL)    ; // Tell
            String personTell    = c.getString(colId)                                  ;



            // สร้างชุดข้อความเอาไว้แสดงผล
            str = str + "\n\nId: " + personId + "\nName: " + personName + "\nEmail: " + personEmail + "\nAddress: " + personAddress + "\nTell: " + personTell;
        }
        tvPerson.setText(str);
        dh.close();
    }
}