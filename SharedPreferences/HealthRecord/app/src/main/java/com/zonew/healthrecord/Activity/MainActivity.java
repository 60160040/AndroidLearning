package com.zonew.healthrecord.Activity;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.os.Bundle;
import android.view.View;

import com.zonew.healthrecord.R;

public class MainActivity extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
    }

    public void pageExercise(View v){
        Intent i = new Intent(this, ExerciseActivity.class);
        startActivity(i);
    }

    public void pageSleep(View v){
        Intent i = new Intent(this, SleepActivity.class);
        startActivity(i);
    }



}