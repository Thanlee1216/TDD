package com.test.tdd.calculator;

public class Calculator {

    public static int calculate(String input) throws RuntimeException{
        String regexStr = ",,:";
        if(input.indexOf("\n") != -1) {
            String[] inputSplit = input.split("\n");
            regexStr = inputSplit[0].replace("//", "");
            input = inputSplit[1];
        }
        int result = 0;
        int maxResultValue = Integer.MAX_VALUE;
        for(String s : input.split("[\\" + regexStr + "]")) {
            int strToInt = Integer.parseInt(s);
            if(strToInt <= maxResultValue) {
                maxResultValue -= strToInt;
                result += Integer.parseInt(s);
            }else {
                throw new RuntimeException("int 자료형의 크기를 벗어났습니다.");
            }
        }
        return result;
    }
}
