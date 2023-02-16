package com.example.spring.security.cloud;

import javax.transaction.Transactional;

import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.context.annotation.Lazy;
import org.springframework.security.crypto.bcrypt.BCryptPasswordEncoder;
import org.springframework.security.crypto.password.PasswordEncoder;

import com.example.spring.security.cloud.model.Role;
import com.example.spring.security.cloud.model.User;
import com.example.spring.security.cloud.repo.RoleRepo;
import com.example.spring.security.cloud.repo.UserRepo;

@SpringBootTest
class SpringSecurityCloudApplicationTests {

	@Test
	void contextLoads() {
	}

	@Autowired
	UserRepo repo;

	@Autowired
	PasswordEncoder passwordEncoder;

	@Autowired
	RoleRepo Rolerepo;

	@Test
	void testt1() {
		User user = new User("random", "random", "abc", passwordEncoder.encode("abc"));
		// Role role = new Role("ADMIN");
		// Rolerepo.save(role);
		// user.addRole(role);

		repo.save(user);

	}

}
