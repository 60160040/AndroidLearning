package com.zonew.myprojactaffterupdate;

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
    public static final String DATABASE_NAME = "MemberDB" ;
    public static final int DATABASE_VERSION = 2          ;
    public static final String DROP_TABLE_MEMBER = "drop table if exists "+ DBStructure.Member.TABLE_NAME;

    // default
    public DBHelper(@Nullable Context context, @Nullable String name, @Nullable SQLiteDatabase.CursorFactory factory, int version) {
        super(context, name, factory, version);
    }

    // command SQL
    private static final String CREATE_TABLE_MEMBER = "create table "        +
            DBStructure.Member.TABLE_NAME         + "("                      +
            DBStructure.Member.MEMBER_PHONENUMBER + " text primary key, "    +
            DBStructure.Member.MEMBER_NAME        + " text);"                ;

    // my constructor
    public DBHelper(Context c){
        super(c,DATABASE_NAME,null,DATABASE_VERSION);
        ct = c ;
        Log.d("Test Database","database created ... ");
    }

    // create TABLE
    @Override
    public void onCreate(SQLiteDatabase sqLiteDatabase) {
        sqLiteDatabase.execSQL(CREATE_TABLE_MEMBER); // ใช้งาน คำสั่ง SQL
        Log.d("Test Database","Table created ... ");

    }

    // drop database and create
    @Override
    public void onUpgrade(SQLiteDatabase sqLiteDatabase, int i, int i1) {
        sqLiteDatabase.execSQL(DROP_TABLE_MEMBER);
        onCreate(sqLiteDatabase);
    }

    // add member
    public void addMember(String phoneNumber,String name,SQLiteDatabase sqLiteDatabase){
        ContentValues cv = new ContentValues()                    ; // เอาไว้ใส่ข้อมูล
        cv.put(DBStructure.Member.MEMBER_PHONENUMBER,phoneNumber) ; // phone number
        cv.put(DBStructure.Member.MEMBER_NAME,name)               ; // name

        sqLiteDatabase.insert(DBStructure.Member.TABLE_NAME,null,cv); // put data into DB
        Log.d("Test Database","One row of member added ... ");
        Toast.makeText(ct,"Member record added ... ",Toast.LENGTH_SHORT).show();
    }

    // read Data
    public Cursor readMember(SQLiteDatabase sqLiteDatabase){
        // ข้อมูลที่ใส่แต่ละ คน
        String[] cols = {DBStructure.Member.MEMBER_PHONENUMBER,DBStructure.Member.MEMBER_NAME};

        Cursor cursor;
        cursor = sqLiteDatabase.query(DBStructure.Member.TABLE_NAME,cols,null,null,null,null,null);
        // เอาข้อมูลใส่
        return cursor;
    }

    // Update Data
    public void updateMember(String phoneNumber,String name,SQLiteDatabase sqLiteDatabase){
        // สร้างก้อนข็อมูล
        ContentValues cv = new ContentValues();
        cv.put(DBStructure.Member.MEMBER_PHONENUMBER,phoneNumber);
        cv.put(DBStructure.Member.MEMBER_NAME,name);

        // condition
        String str = DBStructure.Member.MEMBER_PHONENUMBER + "=" + phoneNumber;

        sqLiteDatabase.update(DBStructure.Member.TABLE_NAME,cv,str,null);  // where case เงื่อนไข cv คือก้อนข้อมูล
        Toast.makeText(ct,"Updated Success",Toast.LENGTH_SHORT).show();
    }

    public void deleteMember(String phoneNumber,SQLiteDatabase sqLiteDatabase){
        String str = DBStructure.Member.MEMBER_PHONENUMBER + "=" + phoneNumber;
        sqLiteDatabase.delete(DBStructure.Member.TABLE_NAME,str,null);
        Toast.makeText(ct,"Data phone number : "+phoneNumber+" is deleted.",Toast.LENGTH_SHORT).show();
    }
}
