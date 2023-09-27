package com.codegym.service;

import com.codegym.model.Product;
import org.springframework.core.io.Resource;
import org.springframework.http.ResponseEntity;

import java.util.List;

public interface IProductService {
    List<Product> findAll();

    void save(Product product);

    ResponseEntity<Resource> downloadFile(String code);
}
