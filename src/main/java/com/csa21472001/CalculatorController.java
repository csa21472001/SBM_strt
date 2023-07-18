package com.csa21472001;
import org.springframework.web.bind.annotation.*;
@RestController
@RequestMapping("/calculator")
public class CalculatorController {
    private final CalculatorService cService;
    public CalculatorController(CalculatorService cService) {
        this.cService = cService;
    }
    @GetMapping
    public String welcome() {
        return cService.hello();
    }

    @GetMapping("/sum")
    public String sum(@RequestParam int num1, @RequestParam int num2) {
        return cService.sum(num1, num2);
    }

    @GetMapping("/minus")
    public String minus(@RequestParam int num1, @RequestParam int num2) {
        return cService.minus(num1, num2);
    }

    @GetMapping("/multiply")
    public String multiply(@RequestParam int num1, @RequestParam int num2) {
        return cService.multiply(num1, num2);
    }

    @GetMapping("/divide")
    public String divide(@RequestParam int num1, @RequestParam int num2) {
        if (num2 == 0) {
            return "На ноль делить нельзя!";}
        return cService.divide(num1, num2);
    }
    @ExceptionHandler(Exception.class)
    public String handlException(Exception ex) {
        return "Получена ошибка: " + ex.getMessage();
    }
}
