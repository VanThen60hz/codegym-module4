package com.codegym.controller;

import com.codegym.dao.UserDao;
import com.codegym.model.Login;
import com.codegym.model.User;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.servlet.ModelAndView;

import java.util.Optional;


@Controller
public class UserController {

    @GetMapping("/home")
    public ModelAndView home() {
        return new ModelAndView("home", "login", new Login());
    }

    @PostMapping("/login")
    public ModelAndView login(@ModelAttribute("login") Login login){
        Optional<User> user = UserDao.checkLogin(login);
        if(user.isEmpty()){
            return new ModelAndView("error");
        } else {
            ModelAndView modelAndView = new ModelAndView("user");
            modelAndView.addObject("user", user.get());
            return modelAndView;
        }
    }
}