package com.example.spring.security.cloud.controller;

import java.util.ArrayList;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.example.spring.security.cloud.model.User;
import com.example.spring.security.cloud.repo.UserRepo;

@RestController
@RequestMapping("/users")
public class UserController {
    @Autowired
    UserRepo userRepo;

    @GetMapping("")
    ArrayList<User> getAllUsers() {
        return userRepo.findAll();
    }
}
