package com.test.tdd.calculator;

public class Calculator {

    public static int calculate(String input) {
        int result = 0;
        for(String s : input.split("[\\,,:]")) {
            result += Integer.parseInt(s);
        }
        return result;
    }
}
