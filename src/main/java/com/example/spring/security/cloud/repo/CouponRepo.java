package com.example.spring.security.cloud.repo;

import java.util.ArrayList;

import org.springframework.data.repository.CrudRepository;

import com.example.spring.security.cloud.model.Coupon;

import antlr.collections.List;

public interface CouponRepo extends CrudRepository<Coupon, Long> {
    Coupon findByCode(String coupon);

    ArrayList<Coupon> findAll();
}
