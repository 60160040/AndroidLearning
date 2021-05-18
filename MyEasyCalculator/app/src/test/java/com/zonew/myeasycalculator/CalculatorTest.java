package com.zonew.myeasycalculator;

//import android.test.suitebuilder.annotation.SmallTest;

import org.junit.Before;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.junit.runners.JUnit4;

import static org.hamcrest.CoreMatchers.equalTo;
import static org.hamcrest.CoreMatchers.is;
import static org.junit.Assert.assertThat;

/**
 * JUnit4 unit tests for the calculator logic. These are local unit tests; no device needed
 */
@RunWith(JUnit4.class)
//@SmallTest
public class CalculatorTest {

    private MyCalculator mCalculator;

    /**
     * Set up the environment for testing
     */
    @Before
    public void setUp() {
        mCalculator = new MyCalculator();
    }

    /**
     * Test for simple addition
     */
    @Test
    public void addTwoNumbers() {
        mCalculator.setOperand1(1d);                     // 1d คือ 1 [double]
        mCalculator.setOperand2(1d);                     // 1d คือ 1 [double]
        double resultAdd = mCalculator.add();
        assertThat(resultAdd, is(equalTo(2d))); // ใช้แบบเท่าเป๊ะๆ
    }

    @Test
    public void addTwoNumbersDecimal() {
        mCalculator.setOperand1(1.5d);                     // 1d คือ 1 [double]
        mCalculator.setOperand2(1.5d);                     // 1d คือ 1 [double]
        double resultAdd = mCalculator.add();
        assertThat(resultAdd, is(equalTo(3d))); // ใช้แบบเท่าเป๊ะๆ
    }

//    @Test
//    public void addTwoNumbersFloat() {
//        mCalculator.setOperand1(1d);                     // 1d คือ 1 [double]
//        mCalculator.setOperand2(1d);                     // 1d คือ 1 [double]
//        double resultAdd = mCalculator.add();
//        assertThat(resultAdd, is(closeTo(2d)));
//    }

    @Test
    public void addTwoNumbersNegative() {
        mCalculator.setOperand1(-1d);                     // 1d คือ 1 [double]
        mCalculator.setOperand2(2d);                     // 1d คือ 1 [double]
        double resultAdd = mCalculator.add();
        assertThat(resultAdd, is(equalTo(1d))); // ใช้แบบเท่าเป๊ะๆ
    }

}
