package com.coupon.couponsystem.service;

import com.coupon.couponsystem.domain.Coupon;
import com.coupon.couponsystem.producer.CouponCreateProducer;
import com.coupon.couponsystem.repository.CouponCountRepository;
import com.coupon.couponsystem.repository.CouponRepository;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

@RequiredArgsConstructor
@Service
public class CouponServiceImpl implements CouponService {

    private final CouponCountRepository couponCountRepository;
    private final CouponCreateProducer couponCreateProducer;

    @Transactional
    @Override
    public void apply(Long userId) {
        long count = this.couponCountRepository.incrementCouponCount();

        if(count > 100) {
            return;
        }

        this.couponCreateProducer.create(userId);

//        couponRepository.save(new Coupon(userId));
    }
}
