package com.test.tdd.calculator;

public class Calculator {

    public int calculate(String input) throws RuntimeException {

        int result = 0;
        if(input == "" || input == null) exceptionTriger("잘못된 문자열입니다.");

        String regexStr = ",,:";
        //커스텀 문자열 세팅
        if(input.indexOf("\n") != -1) {
            String[] inputSplit = input.split("\n");
            regexStr = inputSplit[0].replace("//", "");
            input = inputSplit[1];
        }
        int maxResultValue = Integer.MAX_VALUE;
        for(String s : input.split("[\\" + regexStr + "]")) {
            int strToInt = parseInt(s);
            //오버플로우 체크
            if(strToInt <= maxResultValue) {
                maxResultValue -= strToInt;
                result += Integer.parseInt(s);
            }else {
                exceptionTriger("int 자료형의 크기를 벗어났습니다.");
            }
        }

        return result;
    }

    private int parseInt(String str) {
        int i = 0;
        try {
            i = Integer.parseInt(str);
        }catch (NumberFormatException e) {
            exceptionTriger("잘못된 문자열입니다.");
        }
        return i;
    }

    private void exceptionTriger(String message) {
        throw new RuntimeException(message);
    }
}
