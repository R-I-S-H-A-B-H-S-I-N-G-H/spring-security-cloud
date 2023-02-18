package com.example.spring.security.cloud;

import javax.annotation.security.RolesAllowed;

import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.security.crypto.password.PasswordEncoder;

import com.example.spring.security.cloud.model.Role;
import com.example.spring.security.cloud.model.User;
import com.example.spring.security.cloud.repo.RoleRepo;
import com.example.spring.security.cloud.repo.UserRepo;
import com.example.spring.security.cloud.service.RoleService;
import com.example.spring.security.cloud.service.UserService;

@SpringBootTest
class SpringSecurityCloudApplicationTests {

	@Test
	void contextLoads() {
	}

	@Autowired
	UserService userService;

	@Autowired
	RoleService roleService;

	@Test
	void createAdminUser() {
		User user = new User("helix", "nebula", "helix", "helix");
		userService.saveUser(user);
		Role role = new Role("ADMIN");
		roleService.createRole(role);

		userService.addRole(user, role);
	}
}
