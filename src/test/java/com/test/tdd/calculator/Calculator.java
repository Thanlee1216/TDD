package com.test.tdd.calculator;

public class Calculator {

    public static int calculate(String input) throws RuntimeException{

        if(input == "" || input == null) {
            throw new RuntimeException("잘못된 문자열입니다.");
        }

        String regexStr = ",,:";
        if(input.indexOf("\n") != -1) {
            String[] inputSplit = input.split("\n");
            regexStr = inputSplit[0].replace("//", "");
            input = inputSplit[1];
        }
        int result = 0;
        int maxResultValue = Integer.MAX_VALUE;
        for(String s : input.split("[\\" + regexStr + "]")) {
            int strToInt = 0;
            try {
                strToInt = Integer.parseInt(s);
            }catch (NumberFormatException e) {
                throw new RuntimeException("잘못된 문자열입니다.");
            }
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
