package com.zonew.myeasycalculator;

import androidx.appcompat.app.AppCompatActivity;

import android.os.Bundle;
import android.view.View;
import android.widget.EditText;
import android.widget.TextView;

public class MainActivity extends AppCompatActivity {
    TextView     tvDisplay ; // ข้อความแสดงผล
    EditText     etNum1    ; // ข้อมูลเข้า 1
    EditText     etNum2    ; // ข้อมูลเข้า 2
    MyCalculator mCal      ; // class คำนวน


    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        // เชื่อ [ตัวแปร] กับ ActivityMain
        tvDisplay = findViewById(R.id.idTvDisplay);
        etNum1    = findViewById(R.id.idEtNumber);
        etNum2    = findViewById(R.id.idEtNumber2);

        mCal = new MyCalculator();
    }

    // step of running
    public void computer(int operator){
        prepareInput()    ;     // set value of [variable]
        double result = 0 ;     // create for collect results

        switch (operator){
            case MyCalculator.ADD      :result = mCal.add()      ;break;
            case MyCalculator.SUB      :result = mCal.sub()      ;break;
            case MyCalculator.MULTIPLY :result = mCal.multiply() ;break;
            case MyCalculator.DIVIDE   :result = mCal.divide()   ;break;
        }
        showOutput(result);
    }


    // set ค่าตัวแปร
    public void prepareInput(){
        String value1 = etNum1.getText().toString() ; // ดึงข้อความออกมา
        String value2 = etNum2.getText().toString() ;
        double num1   = Double.parseDouble(value1)  ; // แปลงเป็น [double]
        double num2   = Double.parseDouble(value2)  ;
        mCal.setOperand1(num1)                      ; // set value
        mCal.setOperand2(num2)                      ;
    }

    // operate
    public void add(View v){
        computer(MyCalculator.ADD);
    }
    public void sub(View v) {
        computer(MyCalculator.SUB);
    }
    public void multiply(View v){
        computer(MyCalculator.MULTIPLY);
    }
    public void divide(View v){
        computer(MyCalculator.DIVIDE);
    }

    // แสดงผล
    public void showOutput(double result){
        String strResult = Double.toString(result) ; // แปลง [double] เป็น [String]
        tvDisplay.setText(strResult)               ; // set ข้อความแสดงผล
    }
}