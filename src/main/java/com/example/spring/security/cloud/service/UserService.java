package com.example.spring.security.cloud.service;

import java.util.ArrayList;

import org.springframework.beans.factory.annotation.Autowired;

import org.springframework.security.core.userdetails.UsernameNotFoundException;
import org.springframework.stereotype.Component;

import com.example.spring.security.cloud.model.Role;
import com.example.spring.security.cloud.model.User;
import com.example.spring.security.cloud.repo.RoleRepo;
import com.example.spring.security.cloud.repo.UserRepo;

@Component
public class UserService {
    @Autowired
    UserRepo userRepo;

    @Autowired
    RoleRepo roleRepo;

    public void saveUser(User user) {
        userRepo.save(user);
    }

    public void addRole(User user, Role role) {
        User userres = userRepo.findByEmail(user.getEmail());

        Role roleres = roleRepo.findByName(role.getName());
        if (userres == null) {
            throw new UsernameNotFoundException("User not found" + user.getEmail());
        }

        if (roleres == null) {
            roleRepo.save(role);
        }

        userres.addRole(roleres);

        userRepo.save(userres);

    }

    public ArrayList<User> getAllUsers() {
        return userRepo.findAllUsers();
        // ArrayList<User> resusers = new ArrayList<>();
        // userRepo.findAll().forEach(ele -> {
        // User user = new User();
        // user.setFirstname(ele.getFirstname());
        // user.setLastname(ele.getLastname());
        // user.setEmail(ele.getEmail());
        // resusers.add(user);

        // });
        // return resusers;
    }

}