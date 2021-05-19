package com.zonew.fivebutton;

import androidx.appcompat.app.AppCompatActivity;

import android.os.Bundle;
import android.view.View;
import android.widget.EditText;
import android.widget.TextView;

public class EasyCalculate extends AppCompatActivity {
    EditText     etNum1,etNum2   ;
    TextView     tvResult        ;
    MyCalculator mCal            ;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState)              ;
        setContentView(R.layout.activity_easy_calculate);

        mCal     = new MyCalculator();

        etNum1   = findViewById(R.id.idEtNum1  );
        etNum2   = findViewById(R.id.idEtNum2  );
        tvResult = findViewById(R.id.idTvResult);
    }

    //Operate
    public void add(View v)     {compute(MyCalculator.ADD)     ;}
    public void sub(View v)     {compute(MyCalculator.SUB)     ;}
    public void multiply(View v){compute(MyCalculator.MULTIPLY);}
    public void divide(View v)  {compute(MyCalculator.DIVIDE)  ;}

    //
    public void compute(int operator){
        double result = 0;
        prepareInput()   ;

        switch  (operator){
            case MyCalculator.ADD     : result = mCal.add()     ;break;
            case MyCalculator.SUB     : result = mCal.sub()     ;break;
            case MyCalculator.MULTIPLY: result = mCal.multiply();break;
            case MyCalculator.DIVIDE  : result = mCal.divide()  ;break;
        }
        showOutput(result);
    }
    public void prepareInput(){
        String value1 = etNum1.getText().toString();
        String value2 = etNum2.getText().toString();
        double num1   = Double.parseDouble(value1) ;
        double num2   = Double.parseDouble(value2) ;
        mCal.setOperand1(num1)                     ;
        mCal.setOperand2(num2)                     ;
    }
    public void showOutput(double result){
        String strResult = Double.toString(result);
        tvResult.setText(strResult)               ;
    }
}
