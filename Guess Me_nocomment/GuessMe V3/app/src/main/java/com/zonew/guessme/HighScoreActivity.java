package com.zonew.guessme;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.TextView;
import android.widget.Toast;

public class HighScoreActivity extends AppCompatActivity {
    SavedData sd;
    EditText etName;
    Button btSave;
    TextView tvName;
    TextView tvScore;
    Button btNewGame;
    Button btReset;
    int score;
    int count;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_high_score);

        sd = new SavedData(this);
        tvName  = findViewById(R.id.idTvName);
        tvScore = findViewById(R.id.idTvScore);
        etName  = findViewById(R.id.idEtName);
        btSave  = findViewById(R.id.idBtSave);
        btNewGame  = findViewById(R.id.idBtNewGame);
        btReset = findViewById(R.id.idBtReset);

        showScore();
        checkStart();
    }

    public void showScore(){
        String strName;
        strName = sd.readHighScore().name;
        score   = sd.readHighScore().score;

        tvName.setText(strName);
        String strScore = Integer.toString(score);
        tvScore.setText(strScore);
    }

    public void checkStart(){
        Intent i = getIntent();
        count = i.getIntExtra("COUNT",999);

        // show save button, hide new game and reset button
        if(count < score){
            btReset.setVisibility(View.INVISIBLE);
            btNewGame.setVisibility(View.INVISIBLE);
            etName.setVisibility(View.VISIBLE);
            btSave.setVisibility(View.VISIBLE);
        }
    }

    public void saveHighScore(View v){
        HighScore hs = new HighScore();
        hs.name = etName.getText().toString();
        hs.score = count;
        sd.writeHighRecord(hs);
        showScore();

        // show new game and reset button, hide save button
        etName.setVisibility(View.INVISIBLE);
        btSave.setVisibility(View.INVISIBLE);
        btNewGame.setVisibility(View.VISIBLE);
        btReset.setVisibility(View.VISIBLE);
    }

    public void newGame(View v){
        Intent i = new Intent(this,MainActivity.class);
        startActivity(i);
        finish();
    }

    public void reset(View v){
        sd.writeHighRecord("none",999);
        Toast.makeText(getApplicationContext(),"Reset",Toast.LENGTH_SHORT).show();
        showScore();
    }
}
