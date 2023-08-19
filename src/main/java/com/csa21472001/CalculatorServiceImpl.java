package com.csa21472001;
import org.springframework.stereotype.Service;
@Service
public class CalculatorServiceImpl implements CalculatorService {
    @Override
    public String hello() {
        return "<b>Добро пожаловать в калькулятор</b>";
    }
    @Override
    public int sum(int num1, int num2) {
        return num1 + num2;
    }
    @Override
    public int minus(int num1, int num2) {
        return num1 - num2;
    }
    @Override
    public int multiply(int num1, int num2) {
        return num1 * num2;
    }
    @Override
    public float divide(int num1, int num2) {
        if (num2 == 0) {
            throw new IllegalArgumentException();
        }
        return (float) num1 / num2;
    }

}

