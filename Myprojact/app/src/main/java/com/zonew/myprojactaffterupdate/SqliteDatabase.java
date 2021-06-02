package com.zonew.myprojactaffterupdate;

import android.content.ContentValues;
import android.content.Context;
import android.database.Cursor;
import android.database.sqlite.SQLiteDatabase;
import android.database.sqlite.SQLiteOpenHelper;
import android.util.Log;
import android.widget.Toast;

import androidx.annotation.Nullable;

import java.util.ArrayList;

public class SqliteDatabase extends SQLiteOpenHelper {
    Context ct;
    public static final String DATABASE_NAME = "MemberDB";
    public static final int DATABASE_VERSION = 1;
    private static final String TABLE_NAME = DBStructure.Member.TABLE_NAME;
    private static final String COLUMN_ID        = DBStructure.Member.COLUMN_ID  ;
    private static final String COLUMN_NAME      = DBStructure.Member.COLUMN_NAME;
    private static final String COLUMN_NO        = DBStructure.Member.COLUMN_NO  ;

    /*__________________________command SQL__________________________*/
    // Create
    private static final String CREATE_TABLE_MEMBER = "create table "      +
            TABLE_NAME  + "("                      +
            COLUMN_ID   + " integer primary key, " +
            COLUMN_NAME + " text,"                 +
            COLUMN_NO   + " text"                  +
                          ");"                     ;
    // Delete
    public static final String DROP_TABLE_MEMBER = "drop table if exists " +
            TABLE_NAME                                                     ;

    // default
    public SqliteDatabase(@Nullable Context context, @Nullable String name, @Nullable android.database.sqlite.SQLiteDatabase.CursorFactory factory, int version) {
        super(context, name, factory, version);
    }

    // my constructor
    public SqliteDatabase(Context context){
        super(context,DATABASE_NAME,null,DATABASE_VERSION);
//        ct = context ;
//        Log.d("Test Database","database created ... ");
    }

    // ของอาจารย์ คือ สร้างใส่ page.java เลย
    public ArrayList<Members> listMembers() {
        String sql = "select * from " + TABLE_NAME;
        android.database.sqlite.SQLiteDatabase db = this.getReadableDatabase();
        ArrayList<Members> storeMembers = new ArrayList<>();
        Cursor cursor = db.rawQuery(sql, null); // readDatabase
        if (cursor.moveToFirst()) {
            do {
                int id = Integer.parseInt(cursor.getString(0));
                String name = cursor.getString(1);
                String phno = cursor.getString(2);
                storeMembers.add(new Members(id, name, phno));
            }
            while (cursor.moveToNext());
        }
        cursor.close();
        return storeMembers;
    }

    // create TABLE
    @Override
    public void onCreate(android.database.sqlite.SQLiteDatabase sqLiteDatabase) {
        sqLiteDatabase.execSQL(CREATE_TABLE_MEMBER)         ; // ใช้งาน คำสั่ง SQL
        Log.d("Test Database","Table created ... ");

    }

    // drop database and create
    @Override
    public void onUpgrade(android.database.sqlite.SQLiteDatabase sqLiteDatabase, int i, int i1) {
        sqLiteDatabase.execSQL(DROP_TABLE_MEMBER);
        onCreate(sqLiteDatabase);
    }

    // add member
    public void addMember(Members member) {
        ContentValues values = new ContentValues(); // เอาไว้ใส่ข้อมูล
        values.put(COLUMN_NAME, member.getName()); // name
        values.put(COLUMN_NO, member.getPhno()); // phone number
        SQLiteDatabase db = this.getWritableDatabase();
        db.insert(TABLE_NAME, null, values); // put data into DB

        Log.d("Test Database", "One row of member added ... ");
        Toast.makeText(ct, "Member record added ... ", Toast.LENGTH_SHORT).show();
    }

    // Update Data
    public void updateMember(Members member) {
        // สร้างก้อนข็อมูล
        ContentValues values = new ContentValues();
        values.put(COLUMN_NAME, member.getName());
        values.put(COLUMN_NO, member.getPhno());
        SQLiteDatabase db = this.getWritableDatabase();
        db.update(TABLE_NAME, values, COLUMN_ID + " = ?", new String[]{String.valueOf(member.getId())});
        Toast.makeText(ct, "Updated Success", Toast.LENGTH_SHORT).show();
    }

    public void deleteMember(int id){
        SQLiteDatabase db = this.getWritableDatabase();
        db.delete(TABLE_NAME, COLUMN_ID + " = ?", new String[]{String.valueOf(id)});
//        String condition = COLUMN_NO + " = ?" ;
//        db.delete(TABLE_NAME, COLUMN_ID + " = ?", new String[]{String.valueOf(id)});

        Toast.makeText(ct,"Data is deleted.",Toast.LENGTH_SHORT).show();
    }
}
