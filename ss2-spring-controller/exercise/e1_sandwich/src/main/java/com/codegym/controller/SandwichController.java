package com.codegym.controller;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.*;
import org.springframework.web.servlet.ModelAndView;


@Controller
public class SandwichController {

    @GetMapping
    public String home() {
        return "home";
    }


    @PostMapping("save")
    public ModelAndView save(@RequestParam("condiment") String[] condiment) {
        return new ModelAndView("home", "condiment", condiment);
    }
}