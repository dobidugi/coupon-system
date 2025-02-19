package com.coupon.couponsystem.service;

import com.coupon.couponsystem.repository.CouponRepository;
import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;

import static org.assertj.core.api.Assertions.assertThat;

@SpringBootTest
class CouponServiceImplTest {

    @Autowired
    private CouponService couponService;

    @Autowired
    private CouponRepository couponRepository;

    @Test
    public void apply() {
        couponService.apply(1L);
        assertThat(couponRepository.count()).isEqualTo(1);
    }


}