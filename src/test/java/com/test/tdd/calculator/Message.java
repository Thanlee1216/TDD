package com.test.tdd.calculator;

public enum Message {

    INVALID_STRING("잘못된 문자열입니다.")
    , OVERFLOW_INT("int 자료형의 크기를 벗어났습니다.");

    String message;


    Message(String message) {
        this.message = message;
    }

    public String getMessage() {
        return message;
    }
}
