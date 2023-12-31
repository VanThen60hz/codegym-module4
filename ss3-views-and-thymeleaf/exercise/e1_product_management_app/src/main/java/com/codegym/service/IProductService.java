package com.codegym.service;

import com.codegym.model.Product;

import java.util.List;
import java.util.Optional;

public interface IProductService {
    List<Product> findAll();

    void save(Product product);

    void delete(int id);

    Optional<Product> getById(int id);

    List<Product> search(String name);
}
