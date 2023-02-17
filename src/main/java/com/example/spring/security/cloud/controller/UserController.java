package com.example.spring.security.cloud.controller;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.core.userdetails.UsernameNotFoundException;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.example.spring.security.cloud.dto.Useraddrole;
import com.example.spring.security.cloud.model.Role;
import com.example.spring.security.cloud.model.User;
import com.example.spring.security.cloud.repo.UserRepo;

@RestController
@RequestMapping("/users")
public class UserController {
    @Autowired
    UserRepo userRepo;

    @GetMapping("")
    List<User> getAllUsers() {

        userRepo.findAll().forEach(ele -> System.out.println(ele.getFirstname()));

        return List.of(new User("RISHABH", "SINGH", "SDSSS", "DSJKHDJDHKJDH"));
    }

    @PostMapping("")
    void createUser(@RequestBody User user) {
        userRepo.save(user);
    }

    @PostMapping("/addrole")
    void addRole(@RequestBody Useraddrole obj) {
    User user = userRepo.findByEmail(obj.getEmail());
    Role role = new Role("");
    if (user == null)
    throw new UsernameNotFoundException("USER DOES NOT EXIST : " +
    obj.getEmail());

    user.addRole(role);
    userRepo.save(user);
    }
}
