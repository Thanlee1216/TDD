package com.test.tdd.calculator;

import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.assertEquals;

public class CalculatorTest {

    @Test
    void 구분자로_문자_나눠_더하기() {
        String input = "1:2:3";
        int result = Calculator.calculate(input);
        assertEquals(6, result);

        input = "1,2:3";
        result = Calculator.calculate(input);
        assertEquals(6, result);

        input = "2:2:3";
        result = Calculator.calculate(input);
        assertEquals(7, result);

        input = "4,2:3";
        result = Calculator.calculate(input);
        assertEquals(9, result);
    }

}
