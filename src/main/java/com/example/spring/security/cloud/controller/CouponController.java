package com.example.spring.security.cloud.controller;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.autoconfigure.data.web.SpringDataWebProperties.Pageable;
import org.springframework.data.domain.PageRequest;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.example.spring.security.cloud.model.Coupon;
import com.example.spring.security.cloud.repo.CouponRepo;

@RestController
@RequestMapping("/coupons")
public class CouponController {
    @Autowired
    private CouponRepo couponRepo;

    @PostMapping("")
    public void createCoupon(@RequestBody Coupon coupon) {
        System.out.println("POST MAPPING");
        couponRepo.save(coupon);
    }

    @GetMapping("")
    public List<Coupon> getAllCoupons() {
        return couponRepo.findAll();
    }

    @GetMapping("/coupons/{code}")
    public Coupon getCoupon(@PathVariable("code") String code) {
        Coupon coupon = couponRepo.findByCode(code);
        return coupon;
    }

    @PostMapping("/test")
    void test() {
        System.out.println("TESTPOST");
    }
}
