package com.codegym.service;

import com.codegym.service.impl.SimpleCustomerService;

public class CustomerServiceFactory {
    private static CustomerService singleton;

    public static synchronized CustomerService getInstance() {
        if (singleton == null) {
            singleton = new SimpleCustomerService();
        }
        return singleton;
    }

}