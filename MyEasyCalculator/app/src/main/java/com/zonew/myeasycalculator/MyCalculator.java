package com.zonew.myeasycalculator;

public class MyCalculator {
    private double          operand1     ;
    private double          operand2     ;

    public static final int ADD = 1      ;
    public static final int SUB = 2      ;
    public static final int MULTIPLY = 3 ;
    public static final int DIVIDE   = 4 ;

    // set variable
    public void setOperand1(double operand1){
        this.operand1 = operand1;
    }
    public void setOperand2(double operand2){
        this.operand2 = operand2;
    }

    //operate
    public double add()     { return operand1 + operand2;} // +
    public double sub()     { return operand1 - operand2;} // -
    public double multiply(){ return operand1 * operand2;} // *
    public double divide()  { return operand1 / operand2;} // /
}
