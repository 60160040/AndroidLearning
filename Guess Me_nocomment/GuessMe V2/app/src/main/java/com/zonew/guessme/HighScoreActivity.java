package com.zonew.guessme;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.TextView;

public class HighScoreActivity extends AppCompatActivity {
    SavedData sd;
    EditText etName;
    Button btSave;
    TextView tvName;
    TextView tvScore;
    String strName;
    Button btNewGame;
    Button btExit;
    int score;
    int count;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_high_score);

        tvName  = findViewById(R.id.idTvName);
        tvScore = findViewById(R.id.idTvScore);
        etName  = findViewById(R.id.idEtName);
        btSave  = findViewById(R.id.idBtSave);
        btNewGame  = findViewById(R.id.idBtNewGame);
        btExit  = findViewById(R.id.idBtExit);

        sd = new SavedData(this);
        strName = sd.readName();
        score   = sd.readScore();

        tvName.setText(strName);
        String strScore = Integer.toString(score);
        tvScore.setText(strScore);

        Intent i = getIntent();

        count = i.getIntExtra("COUNT",999);

        if(count < score){
            etName.setVisibility(View.VISIBLE);
            btSave.setVisibility(View.VISIBLE);
        }else {
            btNewGame.setVisibility(View.VISIBLE);
            btExit.setVisibility(View.VISIBLE);
        }

    }
    public void saveHighScore(View v){
        // show new high score
        strName = etName.getText().toString();
        String strScore   = Integer.toString(count);
        tvName.setText(strName);
        tvScore.setText(strScore);

        sd.writeHighRecord(strName,score);

        etName.setVisibility(View.INVISIBLE);
        btSave.setVisibility(View.INVISIBLE);
        btNewGame.setVisibility(View.VISIBLE);
        btExit.setVisibility(View.VISIBLE);

    }
    public void newGame(View v){
        Intent i = new Intent(this,MainActivity.class);
        startActivity(i);
        finish();
    }
    public void ExitGame(View v){
        finish();
    }
}
