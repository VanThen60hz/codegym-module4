package com.codegym.controller;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.servlet.ModelAndView;

@Controller
public class CalculatorController {

    @GetMapping
    public String home(){
        return "home";
    }

    @PostMapping("/calculate")
    public ModelAndView calculate(
            @RequestParam(required = false) Double num1,
            @RequestParam(required = false) Double num2,
            @RequestParam(required = false) String operator) {

        String result = "";

        if (num1 != null && num2 != null && operator != null) {
            switch (operator) {
                case "+":
                    result = String.valueOf(num1 + num2);
                    break;
                case "-":
                    result = String.valueOf(num1 - num2);
                    break;
                case "*":
                    result = String.valueOf(num1 * num2);
                    break;
                case "/":
                    if (num2 != 0) {
                        result = String.valueOf(num1 / num2);
                    } else {
                        result = "Division by zero is not allowed.";
                    }
                    break;
                default:
                    result = "Invalid operator";
            }
        } else {
            result = "Please provide valid input.";
        }

        return new ModelAndView("home", "result", result);
    }

}
