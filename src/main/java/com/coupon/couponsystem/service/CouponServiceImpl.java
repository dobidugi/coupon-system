package com.coupon.couponsystem.service;

import com.coupon.couponsystem.domain.Coupon;
import com.coupon.couponsystem.repository.CouponCountRepository;
import com.coupon.couponsystem.repository.CouponRepository;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

@RequiredArgsConstructor
@Service
public class CouponServiceImpl implements CouponService {

    private final CouponRepository couponRepository;
    private final CouponCountRepository couponCountRepository;

    @Transactional
    @Override
    public void apply(Long userId) {
        long count = this.couponCountRepository.incrementCouponCount();

        if(count > 100) {
            return;
        }

        couponRepository.save(new Coupon(userId));
    }
}
