package com.codegym.controller;

import com.codegym.model.Setting;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.servlet.ModelAndView;

@Controller
public class SettingController {
    private static Setting setting = new Setting();

    @GetMapping
    public String home(){
        return "home";
    }

    @GetMapping("config")
    public String config(Model model){
        model.addAttribute("setting", setting);
        model.addAttribute("languages", new String[]{"English","Chinese","Japanese","Vietnamese"});
        model.addAttribute("pageSize", new String[]{"5","10","15","25","50","100"});
        return "config";
    }

    @PostMapping("/save")
    public String save(Setting s){
        setting=s;
        return "home";
    }
}
