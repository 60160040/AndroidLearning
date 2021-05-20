package com.zonew.guessme;

import java.util.Random;

public class GameGuessme {
    public static final int CORRECT  = 0;
    public static final int TOO_LOW  = 1;
    public static final int TOO_HIGH = 2;

    private int compNum;
    private int guessNum;
    private int count;

    public GameGuessme(){
        compNum = think();
        count   = 0      ;
    }
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
    public int check(){
        if      (guessNum < compNum)
            return 1;
        else if (guessNum > compNum)
            return 2;
        else
            return 0;
    }

}
