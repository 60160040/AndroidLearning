package com.zonew.guessme;

import android.content.Context;
import android.content.SharedPreferences;
import android.util.Log;
import android.widget.Toast;

public class SavedData {
    SharedPreferences sp;

    public SavedData(Context c){
        sp = c.getSharedPreferences("com.zonew.guessme.saved_data",Context.MODE_PRIVATE);
    }

    public void writeHighRecord(String name,int count){
        SharedPreferences.Editor e = sp.edit();
        e.putString("HIGHSCORE_NAME",name);
        e.putInt("HIGHSCORE_COUNT",count);
        e.commit();
    }

    public String readName(){
        String strName;
        strName = sp.getString("HIGHSCORE_NAME","NoName");
        return strName;
    }

    public int readScore(){
        int score;
        score = sp.getInt("HIGHSCORE_COUNT",999);
        return score;
    }


}
