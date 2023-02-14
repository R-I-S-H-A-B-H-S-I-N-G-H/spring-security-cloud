package com.example.spring.security.cloud;

import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;

import com.example.spring.security.cloud.model.Coupon;
import com.example.spring.security.cloud.repo.CouponRepo;

@SpringBootTest
class SpringSecurityCloudApplicationTests {

	@Test
	void contextLoads() {
	}

	@Autowired
	private CouponRepo repo;

	@Test
	void testPostCoupon() {
		Coupon coupon = new Coupon();
		coupon.setCode("ABC");
		coupon.setDiscount(1);
		coupon.setExpdate("srt345534");
		repo.save(coupon);
	}
}
