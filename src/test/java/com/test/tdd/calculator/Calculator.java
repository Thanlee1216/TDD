package com.test.tdd.calculator;

public class Calculator {

    public int calculate(String input) throws RuntimeException {

        int result = 0;
        if(input == "" || input == null) exceptionTriger(Message.INVALID_STRING.getMessage());

        String regexStr = ",,:";
        //Custom string settings
        if(input.contains("\n") && input.contains("//")) {
            String[] inputSplit = input.split("\n");
            regexStr = inputSplit[0].replace("//", "");
            input = inputSplit[1];
        }
        int maxResultValue = Integer.MAX_VALUE;
        for(String s : input.split("[\\" + regexStr + "]")) {
            int strToInt = parseInt(s);
            //Overflow check
            if(strToInt <= maxResultValue) {
                maxResultValue -= strToInt;
                result += Integer.parseInt(s);
            }else {
                exceptionTriger(Message.OVERFLOW_INT.getMessage());
            }
        }

        return result;
    }

    private int parseInt(String str) {
        int i = 0;
        try {
            i = Integer.parseInt(str);
        }catch (NumberFormatException e) {
            exceptionTriger(Message.INVALID_STRING.getMessage());
        }
        return i;
    }

    private void exceptionTriger(String message) {
        throw new RuntimeException(message);
    }
}
