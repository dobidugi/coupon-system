package com.coupon.couponsystem.service;

import com.coupon.couponsystem.domain.Coupon;
import com.coupon.couponsystem.repository.CouponRepository;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;

@RequiredArgsConstructor
@Service
public class CouponServiceImpl implements CouponService {

    private final CouponRepository couponRepository;

    @Override
    public void apply(Long userId) {
        long count = couponRepository.count();

        if(count > 100) {
            return;
        }

        couponRepository.save(new Coupon(userId));
    }
}
