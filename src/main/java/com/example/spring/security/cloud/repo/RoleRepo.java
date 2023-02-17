package com.example.spring.security.cloud.repo;

import org.springframework.data.jpa.repository.JpaRepository;

import com.example.spring.security.cloud.model.Role;

public interface RoleRepo extends JpaRepository<Role, Long> {
    Role findByName(String name);
}
