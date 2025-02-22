package com.coupon.couponsystem.repository;

import lombok.RequiredArgsConstructor;
import org.springframework.data.redis.core.RedisTemplate;
import org.springframework.stereotype.Repository;


@RequiredArgsConstructor
@Repository
public class CouponCountRepositoryImpl implements CouponCountRepository {

    private final RedisTemplate<String, String> redisTemplate;

    @Override
    public Long incrementCouponCount() {
        return this.redisTemplate
                .opsForValue()
                .increment("coupon_count");
    }
}
