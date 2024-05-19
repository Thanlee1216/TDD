package com.example.calculator;

import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.junit.jupiter.api.Assertions.assertThrows;

public class CalculatorTest {

    private Calculator calculator;

    @BeforeEach
    void setUp() {
        calculator = new Calculator();
    }

    @Test
    void 구분자로_문자_나눠_더하기() {
        assertEquals(6, calculator.calculate("1:2:3"));
        assertEquals(6, calculator.calculate("1,2:3"));
        assertEquals(7, calculator.calculate("2:2:3"));
        assertEquals(9, calculator.calculate("4,2:3"));
    }

    @Test
    void 커스텀_구분자로_문자_나눠_더하기() {
        assertEquals(6, calculator.calculate("//;\n1;2;3"));
        assertEquals(6, calculator.calculate("//,\n1,2,3"));
        assertEquals(8, calculator.calculate("//[\n3[2[3"));
    }

    @Test
    void 숫자가_하나만_입력된_경우() {
        assertEquals(1, calculator.calculate("1"));
        assertEquals(2, calculator.calculate("//;\n2"));
    }

    @Test
    void 결과가_int_크기를_벗어난_경우() {
        RuntimeException e = assertThrows(RuntimeException.class, () -> calculator.calculate("1:2147483647"));
        assertEquals("int 자료형의 크기를 벗어났습니다.", e.getMessage());
        e = assertThrows(RuntimeException.class, () -> calculator.calculate("//;\n2000000000;2000000000"));
        assertEquals("int 자료형의 크기를 벗어났습니다.", e.getMessage());
    }

    @Test
    void 커스텀_구분자와_실제_구분자가_다른_경우() {
        RuntimeException e = assertThrows(RuntimeException.class, () -> calculator.calculate("//:\n1;2;3"));
        assertEquals("잘못된 문자열입니다.", e.getMessage());
    }

    @Test
    void 공백_혹은_NULL이_입력된_경우() {
        RuntimeException e = assertThrows(RuntimeException.class, () -> calculator.calculate(""));
        assertEquals("잘못된 문자열입니다.", e.getMessage());

        e = assertThrows(RuntimeException.class, () -> calculator.calculate(null));
        assertEquals("잘못된 문자열입니다.", e.getMessage());
    }

}
