package com.darsh.app.springbootcalculator;

import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.*;

class MyCalculatorTest {

    @Test
    void addString() {
        MyCalculator myCalculator = new MyCalculator();
        String result = myCalculator.addString("str1","str2");
        assertEquals("str1str2",result);
    }

    @Test
    void add() {
        MyCalculator myCalculator = new MyCalculator();
        float result = myCalculator.add(3.0f,4.0f);
        assertEquals(7.0f,result,0.01);
    }

    @Test
    void sub() {
        MyCalculator myCalculator = new MyCalculator();
        float result = myCalculator.sub(5.0f,4.0f);
        assertEquals(1.0f,result,0.01);
    }

    @Test
    void mul() {
        MyCalculator myCalculator = new MyCalculator();
        float result = myCalculator.mul(3.0f,4.0f);
        assertEquals(12.0f,result,0.01);
    }

    @Test
    void div() {
        MyCalculator myCalculator = new MyCalculator();
        float result = myCalculator.div(7.0f,7.0f);
        assertEquals(1.0f,result,0.01);
    }
}