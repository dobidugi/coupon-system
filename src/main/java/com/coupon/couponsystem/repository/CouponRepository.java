package com.coupon.couponsystem.repository;


import com.coupon.couponsystem.domain.Coupon;
import org.springframework.data.jpa.repository.JpaRepository;

public interface CouponRepository extends JpaRepository<Coupon, Long> {
}
