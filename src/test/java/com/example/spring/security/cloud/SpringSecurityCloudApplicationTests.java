package com.example.spring.security.cloud;

import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
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
		User user = new User("test", "test", "test", passwordEncoder.encode("test"));
		Role role = new Role();
		role.setName("ADMIN");
		Rolerepo.save(role);

		user.addRole(role);
		repo.save(user);

	}

}
