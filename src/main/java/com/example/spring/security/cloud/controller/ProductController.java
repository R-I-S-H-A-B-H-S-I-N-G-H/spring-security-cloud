package com.example.spring.security.cloud.controller;

import java.util.ArrayList;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.example.spring.security.cloud.model.Product;
import com.example.spring.security.cloud.repo.ProductRepo;

@RestController
@RequestMapping("/products")
public class ProductController {
    @Autowired
    private ProductRepo productRepo;

    @PostMapping("")
    public void createProduct(@RequestBody Product product) {
        // System.out.println("POST MAPPING");
        productRepo.save(product);
    }

    @GetMapping("")
    public ArrayList<Product> getAllproducts() {
        // return List.of();
        return productRepo.findAll();
    }

    @GetMapping("/{code}")
    public Product getProductByName(@PathVariable("code") String code) {
        Product product = productRepo.findByName(code);
        return product;
    }
}
