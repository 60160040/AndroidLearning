package com.zonew.healthrecord;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.os.Bundle;
import android.view.View;

public class ExerciseActivity extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_exercise);
    }

    public void pageAdd(View v){
        Intent i = new Intent(this,AddExerciseActivity.class);
        startActivity(i);
    }

    public void pageView(View v){
        Intent i = new Intent(this,ViewExerciseActivity.class);
        startActivity(i);
    }

}