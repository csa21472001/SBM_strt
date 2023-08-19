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
        assertEquals("<b>Добро пожаловать в калькулятор</b>",result);
    }

    @Test
    void sum() {
    }

     @Test
    void minus() {
    }

    @Test
    void multiply() {
    }

    @Test
    void divide_num1DividedByNum2_floatResultWithoutFraction() {
        var result = underTest.divide(6, 6);
        assertEquals( 1,result);
    }
    @Test
    void divide_num1DividedByNum2_floatResultWithFraction() {
        var result = underTest.divide(3, 6);
        assertEquals( 0.5,result);
    }

    @Test
    void divide_num2Is0_throwIllegalArgumentException() {
        assertThrows(IllegalArgumentException.class, () -> underTest.divide(1, 0));
    }

    @ParameterizedTest
    @MethodSource("dataForDivide")
    void divide__returnFloat(int num1, int num2, double expectedResult ) {
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