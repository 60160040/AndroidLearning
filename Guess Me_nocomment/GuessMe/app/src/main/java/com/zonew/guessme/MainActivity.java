package com.zonew.guessme;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.EditText;
import android.widget.TextView;

import java.util.Random;

public class MainActivity extends AppCompatActivity {
    TextView tvAns;
    EditText etGuessNum;
    TextView tvResultMsg;
    private int ansNum;
    private int guessNum;
    int count;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        /*SavedData sd = new SavedData(this); // Reset score
        sd.writeHighRecord("none",999);*/

        tvAns = findViewById(R.id.idTvAns);
        etGuessNum = findViewById(R.id.idEtGuessNum);
        tvResultMsg = findViewById(R.id.idTvResultMsg);
        tvResultMsg.setText("Enter number");

        count = 0  ;
        comThink() ;


    }

    // Random number
    public void comThink(){
        Random r = new Random();
        ansNum = r.nextInt(100); // 0 - 99
        String str = "Ans: " + Integer.toString(ansNum);
        tvAns.setText(str);
    }
    // guessNum == ansNum ???
    public void checkNum(View v){
        count++;

        String str = etGuessNum.getText().toString();
        guessNum = Integer.parseInt(str);

        if(guessNum > ansNum)
            tvResultMsg.setText("Too High.");
        else
            if (guessNum < ansNum)
                tvResultMsg.setText("Too Low.");
            else{
                tvResultMsg.setText("Correct.");
                Intent i = new Intent(this,HighScoreActivity.class);
                i.putExtra("COUNT",count);
                startActivity(i);
            }

        etGuessNum.setText("");

    }

}
