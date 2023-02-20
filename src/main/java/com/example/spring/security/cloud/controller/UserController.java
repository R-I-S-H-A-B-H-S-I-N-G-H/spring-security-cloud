package com.example.spring.security.cloud.controller;

import java.util.ArrayList;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.example.spring.security.cloud.dto.UserCreateDto;
import com.example.spring.security.cloud.dto.UserDto;
import com.example.spring.security.cloud.model.Role;
import com.example.spring.security.cloud.model.User;
import com.example.spring.security.cloud.service.UserService;

@RestController
@RequestMapping("/users")
public class UserController {

    @Autowired
    UserService userService;

    @GetMapping("")
    ArrayList<User> getAllUsers() {

        return userService.getAllUsers();
    }

    @PostMapping("/add")
    void createUser(@RequestBody UserCreateDto userCreateDto) {
        User user = new User();
        user.setFirstname(userCreateDto.getFirstname());
        user.setLastname(userCreateDto.getLastname());
        user.setEmail(userCreateDto.getEmail());
        user.setPassword(userCreateDto.getPassword());

        userService.saveUser(user);
    }

    @PostMapping("/addrole")
    void addRole(@RequestBody UserDto userDto) {
        User user = new User();
        Role role = new Role();

        user.setEmail(userDto.getEmail());
        role.setName(userDto.getRolename());

        userService.addRole(user, role);
        // userService.saveUser(user);
    }
}