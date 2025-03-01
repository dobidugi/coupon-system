package com.coupon.couponsystem.repository;

import lombok.RequiredArgsConstructor;
import org.springframework.data.redis.core.RedisTemplate;
import org.springframework.stereotype.Repository;

@RequiredArgsConstructor
@Repository
public class AppliedUserRepository {

    private final RedisTemplate<String, String> redisTemplate;


    public Long add(Long userId) {
        return this.redisTemplate
                .opsForSet()
                .add("applied_user", userId.toString());
    }
}
