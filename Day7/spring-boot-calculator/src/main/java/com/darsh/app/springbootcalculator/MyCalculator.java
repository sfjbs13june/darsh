package com.darsh.app.springbootcalculator;

import org.springframework.stereotype.Component;

@Component
public class MyCalculator {
    public String addString(String a, String b){
        return a+b;
    }
    public float add(float a, float b){
        return a+b;
    }
    public float sub(float a, float b){
        return a-b;
    }
    public float mul(float a, float b){
        return a*b;
    }
    public float div(float a, float b){
        return a/b;
    }
}
