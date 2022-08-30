package com.darsh.app.springbootcalculator.controller;

import com.darsh.app.springbootcalculator.MyCalculator;
import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.*;

class CalculatorTest {

    @Test
    void addition() {
        //MyCalculator myCalculator = new MyCalculator();
        //Calculator calculator = new Calculator(myCalculator);
        Calculator calculator = new Calculator();
        float result = calculator.addition(3.0f,3.0f);
        assertEquals(6.0f,result,0.01);
    }

    @Test
    void subtraction() {
        //MyCalculator myCalculator = new MyCalculator();
        //Calculator calculator = new Calculator(myCalculator);
        Calculator calculator = new Calculator();
        float result = calculator.subtraction(3.0f,3.0f);
        assertEquals(0.0f,result,0.01);
    }

    @Test
    void multiplication() {
        //MyCalculator myCalculator = new MyCalculator();
        //Calculator calculator = new Calculator(myCalculator);
        Calculator calculator = new Calculator();
        float result = calculator.multiplication(3.0f,3.0f);
        assertEquals(9.0f,result,0.01);
    }

    @Test
    void division() {
        //MyCalculator myCalculator = new MyCalculator();
        //Calculator calculator = new Calculator(myCalculator);
        Calculator calculator = new Calculator();
        float result = calculator.division(3.0f,3.0f);
        assertEquals(1.0f,result,0.01);
    }
    @Test
    void addstring() {
        //MyCalculator myCalculator = new MyCalculator();
        //Calculator calculator = new Calculator(myCalculator);
        Calculator calculator = new Calculator();
        String result = calculator.addString("str1","str2");
        assertEquals("str1str2",result);
    }

}