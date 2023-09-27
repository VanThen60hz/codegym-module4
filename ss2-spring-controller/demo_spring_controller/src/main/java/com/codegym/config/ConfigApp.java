package com.codegym.config;

import com.codegym.service.StudentService;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;

@Configuration
public class ConfigApp {
    @Bean
    public StudentService studentService(){
        return new  StudentService();
    }
}
