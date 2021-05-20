package com.zonew.guessme;

import android.content.Context;
import android.content.SharedPreferences;

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
        strName = sp.getString("HIGHSCORE_NAME","XXX");
        return strName;
    }
    public int readScore(){
        int score;
        score = sp.getInt("HIGHSCORE_COUNT",999);
        return score;
    }

    // V3
    public void writeHighRecord(HighScore hs){
        SharedPreferences.Editor e = sp.edit();
        e.putString("HIGHSCORE_NAME",hs.name);
        e.putInt("HIGHSCORE_COUNT",hs.score);
        e.commit();
    }

    public HighScore readHighScore(){
        HighScore hs;
        hs = new HighScore();
        hs.name = sp.getString("HIGHSCORE_NAME","XXX");
        hs.score = sp.getInt("HIGHSCORE_COUNT",999);

        return hs;
    }
}
