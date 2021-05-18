package com.zonew.countrecord;

import android.content.Context;
import android.content.SharedPreferences;

public class SavedData {
    SharedPreferences sp ; // ไว้เก็บข้อมูล
    Context           ct ;

    public SavedData(Context c){
        sp = c.getSharedPreferences("COUNT_RECORD_DATA",Context.MODE_PRIVATE) ;
        ct = c                                                                   ;
    }

    // บันทึกข้อมูล
    public void writeCountNum(int n){
        SharedPreferences.Editor e = sp.edit() ; // สร้าง ข้อมูลสำหรับเก็บ
        e.putInt("COUNT_NUM",n)             ; // ส่งข้อมูลไปเก็บ
        e.commit()                             ;
    }

    // เอาข้อมูลออกมา
    public int readCountNum(){
        int cn                              ;
        cn = sp.getInt("COUNT_NUM",0) ;
        return cn                           ;
    }
}
