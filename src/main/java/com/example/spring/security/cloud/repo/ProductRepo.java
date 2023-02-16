package com.example.spring.security.cloud.repo;

import java.util.ArrayList;

import org.springframework.data.repository.CrudRepository;

import com.example.spring.security.cloud.model.Product;

public interface ProductRepo extends CrudRepository<Product, Long> {
    ArrayList<Product> findAll();

    Product findByName(String name);
}
