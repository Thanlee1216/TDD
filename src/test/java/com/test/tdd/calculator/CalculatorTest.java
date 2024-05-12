package com.test.tdd.calculator;

import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.assertEquals;

public class CalculatorTest {

    @Test
    void 구분자로_문자_나눠_더하기() {
        String input = "1:2:3";
        assertEquals(6, getCalculateResult(input));

        input = "1,2:3";
        assertEquals(6, getCalculateResult(input));

        input = "2:2:3";
        assertEquals(7, getCalculateResult(input));

        input = "4,2:3";
        assertEquals(9, getCalculateResult(input));
    }

    @Test
    void 커스텀_구분자로_문자_나눠_더하기() {
        String input = "//;\n1;2;3";
        assertEquals(6, getCalculateResult(input));

        input = "//,\n1,2,3";
        assertEquals(6, getCalculateResult(input));

        input = "//[\n3[2[3";
        assertEquals(8, getCalculateResult(input));
    }

    @Test
    void 숫자가_하나만_입력된_경우() {
        String input = "1";
        assertEquals(1, getCalculateResult(input));

        input = "//;\n2";
        assertEquals(2, getCalculateResult(input));
    }

    @Test
    void 결과가_int_크기를_벗어난_경우() {
        String input = "1:2147483647";
        assertEquals(-1, getCalculateResult(input));

        input = "//;\n2000000000;2000000000";
        assertEquals(-1, getCalculateResult(input));
    }

    private int getCalculateResult(String input) {
        int result = -1;
        try {
            result = Calculator.calculate(input);
        } catch (RuntimeException e) {
            System.out.println(e.getMessage());
        }
        return result;
    }

}
