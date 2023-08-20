package com.csa21472001;

import org.junit.jupiter.api.Test;
import org.junit.jupiter.params.ParameterizedTest;
import org.junit.jupiter.params.provider.Arguments;
import org.junit.jupiter.params.provider.MethodSource;

import java.util.stream.Stream;

import static org.junit.jupiter.api.Assertions.*;

class CalculatorServiceImplTest {

    CalculatorService underTest = new CalculatorServiceImpl();

    @Test
    void hello__returnWelcomeString() {
        String result = underTest.hello();
        assertEquals("<b>Добро пожаловать в калькулятор</b>", result);
    }

    @Test
    void sum_num1PlusNum2_intResult() {
        var result = underTest.sum(6, 6);
        assertEquals(12, result);
    }

    @Test
    void plus_num1AndNum2BothIsMaxInt_correctResult() {
        long result = underTest.sum(Integer.MAX_VALUE, Integer.MAX_VALUE);
        assertEquals(4_294_967_294L, result);
    }

    @Test
    void minus() {
        var result = underTest.minus(6, 6);
        assertEquals(0, result);
    }

    @Test
    void minus_num1IsMinIntAndNum2IsMaxInt_correctResult() {
        long result = underTest.minus(Integer.MIN_VALUE, Integer.MAX_VALUE);
        assertEquals(-4_294_967_295L, result);
    }


    @Test
    void multiply() {
        var result = underTest.multiply(6, 6);
        assertEquals(36, result);
    }

    @Test
    void multiply_num1AndNum2BothIsMaxInt_correctResult() {
        long result = underTest.multiply(Integer.MAX_VALUE, Integer.MAX_VALUE);
        assertEquals(4.6116860141324206E18, result);
    }

    @Test
    void divide_num1DividedByNum2_floatResultWithoutFraction() {
        var result = underTest.divide(6, 6);
        assertEquals(1, result);
    }

    @Test
    void divide_num1DividedByNum2_floatResultWithFraction() {
        var result = underTest.divide(3, 6);
        assertEquals(0.5, result);
    }

    @Test
    void divide_num2Is0_throwIllegalArgumentException() {
        assertThrows(IllegalArgumentException.class, () -> underTest.divide(1, 0));
    }

    @ParameterizedTest
    @MethodSource("dataForSum")
    void sum__returnLong(int num1, int num2, long expectedResult) {
        var result = underTest.sum(num1, num2);
        assertEquals(expectedResult, result);
    }

    private static Stream<Arguments> dataForSum() {
        return Stream.of(
                Arguments.of(3, 5, 8),
                Arguments.of(-2, 01, -1),
                Arguments.of(-5, -65, -70),
                Arguments.of(Integer.MAX_VALUE, Integer.MAX_VALUE, 4_294_967_294L),
                Arguments.of(Integer.MIN_VALUE, Integer.MIN_VALUE, -4_294_967_296L)
        );
    }
    @ParameterizedTest
    @MethodSource("dataForMinus")
    void minus__returnLong(int num1, int num2, long expectedResult) {
        var result = underTest.minus(num1, num2);
        assertEquals(expectedResult, result);
    }

    private static Stream<Arguments> dataForMinus() {
        return Stream.of(
                Arguments.of(87, 6, 81),
                Arguments.of(7, 9, -2),
                Arguments.of(Integer.MAX_VALUE, Integer.MIN_VALUE, 4_294_967_295L)
        );
    }
    @ParameterizedTest
    @MethodSource("dataForMultiply")
    void multiply__returnLong(int num1, int num2, long expectedResult) {
        var result = underTest.multiply(num1, num2);
        assertEquals(expectedResult, result);
    }

    private static Stream<Arguments> dataForMultiply() {
        return Stream.of(
                Arguments.of(8, 1, 8),
                Arguments.of(50, -2, -100),
                Arguments.of(-45, -1, 45)
        );
    }

    @ParameterizedTest
    @MethodSource("dataForDivide")
    void divide__returnFloat(int num1, int num2, double expectedResult) {
        var result = underTest.divide(num1, num2);
        assertEquals(expectedResult, result);
    }

    private static Stream<Arguments> dataForDivide() {
        return Stream.of(
                Arguments.of(4, 2, 2),
                Arguments.of(5, 2, 2.5)
        );
    }

}