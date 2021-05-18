package com.zonew.friendship;

import android.content.ContentValues;
import android.content.Context;
import android.database.Cursor;
import android.database.sqlite.SQLiteDatabase;
import android.database.sqlite.SQLiteOpenHelper;
import android.util.Log;
import android.widget.Toast;

import androidx.annotation.Nullable;

public class DBHelper extends SQLiteOpenHelper {
    Context ct;
    public static final String DATABASE_NAME = "FriendshipDB" ;
    public static final int DATABASE_VERSION = 4              ;
    public static final String DROP_TABLE_PERSON = "drop table if exists "+ DBStructure.Person.TABLE_NAME;

    // คำสั่ง SQL
    private static final String
            CREATE_TABLE_PERSON = "create table " +
            DBStructure.Person.TABLE_NAME     + "("                      +
            DBStructure.Person.PERSON_ID      + " integer primary key, " +
            DBStructure.Person.PERSON_NAME    + " text, "                +
            DBStructure.Person.PERSON_EMAIL   + " text, "                +
            DBStructure.Person.PERSON_ADDRESS + " text, "                +
            DBStructure.Person.PERSON_TELL    + " text);";
    // มันคือประโยคนี้ "create table person(personId integer primary key, personName text, personEmail text, personAddress text, personTell text);"

    // Constructor สร้างเอง
    public DBHelper(Context c){
        super(c,DATABASE_NAME,null,DATABASE_VERSION);
        ct = c ;
        Log.d("Test Database","database created ... ");
    }

    // Constructor
    public DBHelper(@Nullable Context context, @Nullable String name, @Nullable SQLiteDatabase.CursorFactory factory, int version) {
        super(context, name, factory, version);
    }

    // Create TABLE
    @Override
    public void onCreate(SQLiteDatabase db) {
        db.execSQL(CREATE_TABLE_PERSON); // ใช้งาน คำสั่ง SQL
        Log.d("Test Database","Table created ... ");
    }

    // Drop database and create
    @Override
    public void onUpgrade(SQLiteDatabase db, int i, int i1) {
        db.execSQL(DROP_TABLE_PERSON);
        onCreate(db);
    }

    // เอาข้อมูลใส่ DB (add person)
    public void addPerson(int id, String name, String email,String address,String tell,SQLiteDatabase db){
        ContentValues cv = new ContentValues()            ; // เอาไว้ใส่ข้อมูล
        cv.put(DBStructure.Person.PERSON_ID,id)           ; // id
        cv.put(DBStructure.Person.PERSON_NAME,name)       ; // name
        cv.put(DBStructure.Person.PERSON_EMAIL,email)     ; // email
        cv.put(DBStructure.Person.PERSON_ADDRESS,address) ; // address
        cv.put(DBStructure.Person.PERSON_TELL,tell)       ; // tell


        db.insert(DBStructure.Person.TABLE_NAME,null,cv); // เอาข้อมูลใส่ DB
        Log.d("Test Database","One row of person added ... ");
        Toast.makeText(ct,"Person record added ... ",Toast.LENGTH_SHORT).show();

    }

    // อ่านข้อมูล
    public Cursor readPerson(SQLiteDatabase db){

        // ข้อมูลที่ใส่แต่ละ คน
        String[] cols = {DBStructure.Person.PERSON_ID,DBStructure.Person.PERSON_NAME,DBStructure.Person.PERSON_EMAIL,DBStructure.Person.PERSON_ADDRESS,DBStructure.Person.PERSON_TELL};

        Cursor c;
        c = db.query(DBStructure.Person.TABLE_NAME,cols,null,null,null,null,null);
        // เอาข้อมูลใส่
        return c;
    }

    // Update Data
    public void updatePerson(int id, String name,String email,String address,String tell,SQLiteDatabase db){
        // สร้างก้อนข็อมูล
        ContentValues cv = new ContentValues();
        cv.put(DBStructure.Person.PERSON_NAME,name);
        cv.put(DBStructure.Person.PERSON_EMAIL,email);
        cv.put(DBStructure.Person.PERSON_ADDRESS,address);
        cv.put(DBStructure.Person.PERSON_TELL,tell);

        // เงื่อนไข
        String str = DBStructure.Person.PERSON_ID + "=" + id;

        db.update(DBStructure.Person.TABLE_NAME,cv,str,null); // where case เงื่อนไข cv คือก้อนข้อมูล
        Toast.makeText(ct,"Updated Success",Toast.LENGTH_SHORT).show();
    }

    public void deletePerson(int id, SQLiteDatabase db){
        // เงื่อนไข
        String str = DBStructure.Person.PERSON_ID + "=" + id;
        db.delete(DBStructure.Person.TABLE_NAME,str,null);
        Toast.makeText(ct,"Data ID : "+id+" is deleted.",Toast.LENGTH_SHORT).show();
    }

}
