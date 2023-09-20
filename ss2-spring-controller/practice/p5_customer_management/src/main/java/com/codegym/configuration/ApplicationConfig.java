package com.codegym.configuration;

import com.codegym.service.CustomerService;
import com.codegym.service.impl.SimpleCustomerService;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.ComponentScan;
import org.springframework.context.annotation.Configuration;
import org.springframework.web.servlet.ViewResolver;
import org.springframework.web.servlet.config.annotation.EnableWebMvc;
import org.springframework.web.servlet.view.InternalResourceViewResolver;

@Configuration
@EnableWebMvc
@ComponentScan("com.codegym")
public class ApplicationConfig {
    @Bean
    public ViewResolver viewResolver() {
        InternalResourceViewResolver viewResolver = new InternalResourceViewResolver();
        viewResolver.setPrefix("/WEB-INF/customers/");
        viewResolver.setSuffix(".jsp");
        return viewResolver;
    }

    @Bean
    public CustomerService customerService() {
        return new SimpleCustomerService();
    }
}
