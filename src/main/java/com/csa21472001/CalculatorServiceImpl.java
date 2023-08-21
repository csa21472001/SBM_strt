package com.csa21472001;
import org.springframework.stereotype.Service;
@Service
public class CalculatorServiceImpl implements CalculatorService {
    public String hello() {
        return "<b>Добро пожаловать в калькулятор</b>";
    }
    public String sum(int num1, int num2) {
        int result = num1 + num2;
        return num1 + " + " + num2 + " = " + result;
    }
    public String minus(int num1, int num2) {
        int result = num1 - num2;
        return num1 + " - " + num2 + " = " + result;
    }

    public String multiply(int num1, int num2) {
        int result = num1 * num2;
        return num1 + " * " + num2 + " = " + result;
    }

    public String divide(int num1, int num2) {
        float result = (float) num1 / num2;
        return num1 + " / " + num2 + " = " + result;
    }

}

