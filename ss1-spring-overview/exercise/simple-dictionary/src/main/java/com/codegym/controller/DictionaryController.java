package com.codegym.controller;

import com.codegym.service.DictionaryService;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.servlet.ModelAndView;

@Controller
public class DictionaryController {
    private final DictionaryService dictionaryService;

    public DictionaryController(DictionaryService dictionaryService) {
        this.dictionaryService = dictionaryService;
    }

    @GetMapping()
    public String home() {
        return "home";
    }

    @GetMapping("search")
    public ModelAndView search(@RequestParam String search) {
        String result = dictionaryService.search(search);
        return new ModelAndView("home", "result", result == null ? "Not found" : result);
    }
}
