package com.coupon.couponsystem.service;

import com.coupon.couponsystem.repository.CouponCountRepository;
import com.coupon.couponsystem.repository.CouponRepository;
import org.junit.jupiter.api.AfterEach;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.data.redis.core.RedisTemplate;
import org.springframework.transaction.annotation.Transactional;

import java.util.concurrent.CountDownLatch;
import java.util.concurrent.ExecutorService;
import java.util.concurrent.Executors;

import static org.assertj.core.api.Assertions.assertThat;

@SpringBootTest
class CouponServiceImplTest {

    @Autowired
    private CouponService couponService;

    @Autowired
    private CouponRepository couponRepository;

//    @Autowired
//    private RedisTemplate<String, String> redisTemplate;

//
//    @BeforeEach
//    public void tearUp() {
//        redisTemplate.delete("coupon_count");
//    }

//    @AfterEach
//    public void tearDown() {
//       redisTemplate.delete("coupon_count");
//    }

    @Test
    public void apply() {
        couponService.apply(1L);
        assertThat(couponRepository.count()).isEqualTo(1);
    }

    @Transactional
    @Test
    public void apply_동시성_테스트() throws InterruptedException {
        int threadCount = 1000;
        ExecutorService executorService = Executors.newFixedThreadPool(32);
        CountDownLatch latch = new CountDownLatch(threadCount);

        for (long i = 0; i < threadCount; i++) {

            long userId = i;
            executorService.execute(() -> {
                try {
                    couponService.apply(userId);

                } finally {
                    latch.countDown();
                }
            });
        }

        latch.await();

        assertThat(couponRepository.count()).isEqualTo(100);
    }

}