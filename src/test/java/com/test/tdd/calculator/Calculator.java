package com.test.tdd.calculator;

public class Calculator {

    public static int calculate(String input) {
        String regexStr = ",,:";
        if(input.indexOf("\n") != -1) {
            String[] inputSplit = input.split("\n");
            regexStr = inputSplit[0].replace("//", "");
            input = inputSplit[1];
        }
        int result = 0;
        for(String s : input.split("[\\" + regexStr + "]")) {
            result += Integer.parseInt(s);
        }
        return result;
    }
}
