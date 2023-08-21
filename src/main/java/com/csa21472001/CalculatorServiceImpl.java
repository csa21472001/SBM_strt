package com.csa21472001;
import org.springframework.stereotype.Service;
@Service
public class CalculatorServiceImpl implements CalculatorService {
    @Override
    public String hello() {
        return "<b>Добро пожаловать в калькулятор</b>";
    }
    @Override
    public long sum(int num1, int num2) {
        return (long)num1 + num2;
    }
    @Override
    public long minus(int num1, int num2) {
        return (long)num1 - num2;
    }
    @Override
    public long multiply(int num1, int num2) {
        return (long)num1 * num2;
    }
    @Override
    public double divide(int num1, int num2) {
        if (num2 == 0) {
            throw new IllegalArgumentException();
        }
        return (double) num1 / num2;
    }

}

