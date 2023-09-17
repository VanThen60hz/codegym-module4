package com.codegym.controller;

import com.codegym.model.Currency;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.servlet.ModelAndView;

@Controller
public class CurrencyController {
    @GetMapping()
    public String home(Model model) {
        return "home";
    }

    @PostMapping("convert")
    public ModelAndView convert(Currency currency) {
        ModelAndView modelAndView = new ModelAndView("home");
        double result = currency.getUsd() * currency.getRate();
        modelAndView.addObject("result", String.format("%.2f", result));
        return modelAndView;
    }

}
