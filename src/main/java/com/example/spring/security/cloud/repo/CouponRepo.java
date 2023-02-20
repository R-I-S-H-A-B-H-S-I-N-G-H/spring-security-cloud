package com.example.spring.security.cloud.repo;

import java.util.ArrayList;

import org.springframework.boot.autoconfigure.data.web.SpringDataWebProperties.Pageable;
import org.springframework.data.domain.PageRequest;
import org.springframework.data.repository.CrudRepository;
import org.springframework.data.repository.PagingAndSortingRepository;

import com.example.spring.security.cloud.model.Coupon;

public interface CouponRepo extends PagingAndSortingRepository<Coupon, Long> {
    Coupon findByCode(String coupon);

    ArrayList<Coupon> findAll();

}
