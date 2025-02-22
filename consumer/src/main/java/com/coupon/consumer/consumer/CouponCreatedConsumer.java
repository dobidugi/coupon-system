package com.coupon.consumer.consumer;

import com.coupon.consumer.domain.Coupon;
import com.coupon.consumer.repository.CouponRepository;
import lombok.RequiredArgsConstructor;
import org.springframework.kafka.annotation.KafkaListener;
import org.springframework.stereotype.Component;

@RequiredArgsConstructor
@Component
public class CouponCreatedConsumer {

    private final CouponRepository couponRepository;

    @KafkaListener(topics = "coupon_create")
    public void consume(Long userId) {
        System.out.println("Coupon created for user: " + userId);
        couponRepository.save(new Coupon(userId));
    }
}
