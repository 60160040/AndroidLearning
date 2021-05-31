package com.zonew.healthrecord;

import android.content.Context;
import android.content.SharedPreferences;

public class SavedData {
    SharedPreferences sp ; // ไว้เก็บข้อมูล
    Context           ct ;

    public SavedData(Context c){
        sp = c.getSharedPreferences("com.zonew.healthrecord.HEALTh_RECORD_DATA",Context.MODE_PRIVATE) ;
        ct = c                                                                   ;
    }

    // บันทึกข้อมูล WALK
    public void writeWalk(float w){
        SharedPreferences.Editor e = sp.edit() ; // สร้าง ข้อมูลสำหรับเก็บ
        e.putFloat("WALK",w)                ; // ส่งข้อมูลไปเก็บ
        e.commit()                             ;
    }

        // บันทึกข้อมูล Jog
    public void writeJog(float j){
        SharedPreferences.Editor e = sp.edit() ; // สร้าง ข้อมูลสำหรับเก็บ
        e.putFloat("JOG",j)                 ; // ส่งข้อมูลไปเก็บ
        e.commit()                             ;
    }

    // จำนวนวันที่นอน
    public void writeCount(int c){
        SharedPreferences.Editor e = sp.edit() ; // สร้าง ข้อมูลสำหรับเก็บ
        e.putInt("COUNT",c)               ; // ส่งข้อมูลไปเก็บ
        e.commit()                             ;

    }

    // บันทึกข้อมูล Hours
    public void writeHours(float h){
        SharedPreferences.Editor e = sp.edit() ; // สร้าง ข้อมูลสำหรับเก็บ
        e.putFloat("HOURS",h)                ; // ส่งข้อมูลไปเก็บ
        e.commit()                             ;
    }

    // บันทึกข้อมูล Times
    public void writeWakeup(int t){
        SharedPreferences.Editor e = sp.edit() ; // สร้าง ข้อมูลสำหรับเก็บ
        e.putInt("WAKEUP",t)              ; // ส่งข้อมูลไปเก็บ
        e.commit()                             ;
    }

//  _______________read_________________
    // เอาข้อมูลออกมา WALK
    public float readWalk(){
        float w                         ;
        w = sp.getFloat("WALK",0) ;
        return w                        ;
    }

    // เอาข้อมูลออกมา Jog
    public float readJog(){
        float j                        ;
        j = sp.getFloat("JOG",0) ;
        return j                       ;
    }

    // จำนวนวันที่นอน
    public int readCount(){
        int c                        ;
        c = sp.getInt("COUNT",0) ;
        return c                       ;
    }

    // เอาข้อมูลออกมา Hours
    public float readHours(){
        float h                          ;
        h = sp.getFloat("HOURS",0) ;
        return h                         ;
    }

    // เอาข้อมูลออกมา Times
    public int readWakeup(){
        int t                           ;
        t = sp.getInt("WAKEUP",0) ;
        return t                          ;
    }
}
