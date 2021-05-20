package com.zonew.guessme;

import java.util.Random;

public class GameGuessme {
    public static final int CORRECT  = 0; // ถูก
    public static final int TOO_LOW  = 1; // ต่ำไป
    public static final int TOO_HIGH = 2; // สูงไป

    private int compNum  ; // Random number
    private int guessNum ; // เลขที่เราเดา
    private int count    ; // จำนวนครั้งที่เดา

    // Start สุ่มเลขแล้วเริ่มนับ
    public GameGuessme(){
        compNum = think();
        count   = 0      ;
    }

    //เ Random number
    private int think(){
        Random r = new Random();
        return r.nextInt(100);
    }

    public int getCompNum(){
        return compNum;
    }
    public void setGuessNum(int gnum){
        guessNum = gnum;
    }
    public void updateCount(){
        count++;
    }
    public int getScore(){
        return count;
    }

    // ตรวจสอบเลข
    public int check(){
        if      (guessNum < compNum)
            return 1;
        else if (guessNum > compNum)
            return 2;
        else
            return 0;
    }

}
