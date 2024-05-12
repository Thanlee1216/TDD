package com.test.tdd.calculator;

import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.assertEquals;

public class CalculatorTest {

    @Test
    void 구분자로_문자_나눠_더하기() {
        assertEquals(6, Calculator.calculate("1:2:3"));
        assertEquals(6, Calculator.calculate("1,2:3"));
        assertEquals(7, Calculator.calculate("2:2:3"));
        assertEquals(9, Calculator.calculate("4,2:3"));
    }

    @Test
    void 커스텀_구분자로_문자_나눠_더하기() {
        assertEquals(6, Calculator.calculate("//;\n1;2;3"));
        assertEquals(6, Calculator.calculate("//,\n1,2,3"));
        assertEquals(8, Calculator.calculate("//[\n3[2[3"));
    }

    @Test
    void 숫자가_하나만_입력된_경우() {
        assertEquals(1, Calculator.calculate("1"));
        assertEquals(2, Calculator.calculate("//;\n2"));
    }

    @Test
    void 결과가_int_크기를_벗어난_경우() {
        assertEquals(-1, Calculator.calculate("1:2147483647"));
        assertEquals(-1, Calculator.calculate("//;\n2000000000;2000000000"));
    }

    @Test
    void 커스텀_구분자와_실제_구분자가_다른_경우() {
        assertEquals(-1, Calculator.calculate("//:\n1;2;3"));
    }

    @Test
    void 공백_혹은_NULL이_입력된_경우() {
        assertEquals(-1, Calculator.calculate(""));
        assertEquals(-1, Calculator.calculate(null));
    }

}
