package com.zonew.guessme;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.EditText;
import android.widget.TextView;

import org.w3c.dom.Text;

import java.util.Random;

public class MainActivity extends AppCompatActivity {
    TextView tvCount;
    TextView tvAns;
    EditText etGuessNum;
    TextView tvMsg;
    GameGuessme game;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        tvAns = findViewById(R.id.idTvAns);
        etGuessNum = findViewById(R.id.idEtGuessNum);
        tvMsg = findViewById(R.id.idTvMsg);
        tvCount = findViewById(R.id.idTvCount);
        tvMsg.setText("-----------------");


        game = new GameGuessme();
        String strCompNum = "Ans: "  + game.getCompNum();
        String strCount   = "Count: " + game.getScore();
        tvAns.setText(strCompNum);
        tvCount.setText(strCount);
    }

    public void checkNum(View v){
        String str = etGuessNum.getText().toString();
        int guessNum = Integer.parseInt(str);
        game.setGuessNum(guessNum);

        //set count
        game.updateCount();
        String strCount   = "Count: " + game.getScore();
        tvCount.setText(strCount);

        switch (game.check()){
            case GameGuessme.TOO_HIGH:
                tvMsg.setText("Too High.");
                break;
            case GameGuessme.TOO_LOW:
                tvMsg.setText("Too Low." );
                break;
            case GameGuessme.CORRECT:
                tvMsg.setText("Correct." );
                Intent i = new Intent(this,HighScoreActivity.class);
                i.putExtra("COUNT",game.getScore());
                startActivity(i);
                finish();
                break;
        }
        etGuessNum.setText("");

    }

    public void pageHighScore(View v){
        Intent i = new Intent(getApplicationContext(),HighScoreActivity.class);
        startActivity(i);
    }

    public void exit(View v){
        finish();
    }

}
