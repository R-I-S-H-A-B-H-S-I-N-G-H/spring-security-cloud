package com.example.spring.security.cloud.repo;

import java.util.ArrayList;

import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.CrudRepository;

import com.example.spring.security.cloud.model.User;

public interface UserRepo extends CrudRepository<User, Long> {
    User findByEmail(String email);

    @Query(value = "from User")
    ArrayList<User> findAllUsers();

}
