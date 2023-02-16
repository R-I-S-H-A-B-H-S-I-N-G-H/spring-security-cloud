package com.example.spring.security.cloud.repo;

import java.util.ArrayList;

import org.springframework.data.jpa.repository.JpaRepository;

import com.example.spring.security.cloud.model.User;

public interface UserRepo extends JpaRepository<User, Long> {
    User findByEmail(String email);

    ArrayList<User> findAll();
}
