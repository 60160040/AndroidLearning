package com.zonew.fivebutton;

import androidx.annotation.NonNull;
import androidx.appcompat.app.AppCompatActivity;

import android.os.Bundle;
import android.view.View;
import android.widget.TextView;
import android.widget.Toast;

public class CountActivity extends AppCompatActivity {
    TextView tvShow;
    private int number = 0;

    String strNumber;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_count);

        tvShow = findViewById(R.id.idTvShow);
        if (savedInstanceState != null) {
            if (savedInstanceState.getBoolean("RESUME") == true) {
                number = savedInstanceState.getInt("COUNT");
                String strNumber = Integer.toString(number);
                tvShow.setText(strNumber);
            }
        }
    }
    @Override
    protected void onSaveInstanceState(@NonNull Bundle outState) {
        super.onSaveInstanceState(outState);

        //if not first times
        if(number != 0){
            outState.putInt("COUNT",number);             //save value 'number' into key "COUNT"
            outState.putBoolean("RESUME",true);         //save state "RESUME" is true
        }
    }
    public void shwMessage(View v)
    {
        Toast t = Toast.makeText(this,"Hello World",Toast.LENGTH_LONG);
        t.show();
    }
    public void countUp(View v){
        number++;
        strNumber = Integer.toString(number);
        tvShow.setText(strNumber);
    }
    public void countDown(View v){
        number--;
        strNumber = Integer.toString(number);
        tvShow.setText(strNumber);
    }
    public void reset(View v){
        number = 0;
        strNumber = Integer.toString(number);
        tvShow.setText(strNumber);
    }
}
