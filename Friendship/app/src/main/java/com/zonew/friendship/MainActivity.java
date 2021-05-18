package com.zonew.friendship;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.os.Bundle;
import android.view.View;

public class MainActivity extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
    }

    public void pageAddPerson(View v){
        Intent i = new Intent(this,AddPersonActivity.class );
        startActivity(i);
    }

    public void pageViewPerson(View v){
        Intent i = new Intent(this,ViewPersonActivity.class );
        startActivity(i);
    }

    public void pageUpdatePerson(View v){
        Intent i = new Intent(this,UpdatePersonActivity.class );
        startActivity(i);
    }

    public void pageDeletePerson(View v){
        Intent i = new Intent(this,DeletePersonActivity.class );
        startActivity(i);
    }
}