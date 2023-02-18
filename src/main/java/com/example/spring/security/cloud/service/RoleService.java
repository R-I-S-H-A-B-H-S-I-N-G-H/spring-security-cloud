package com.example.spring.security.cloud.service;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;

import com.example.spring.security.cloud.model.Role;
import com.example.spring.security.cloud.repo.RoleRepo;

@Component
public class RoleService {
    @Autowired
    RoleRepo roleRepo;

    public Role createRole(Role role) {
        roleRepo.save(role);
        return role;
    }
}
