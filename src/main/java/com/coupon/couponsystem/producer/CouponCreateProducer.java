package com.coupon.couponsystem.producer;

import lombok.RequiredArgsConstructor;
import org.springframework.kafka.core.KafkaTemplate;
import org.springframework.stereotype.Component;

@RequiredArgsConstructor
@Component
public class CouponCreateProducer {

    private final KafkaTemplate<String, Long> kafkaTemplate;

    public void create(Long userId) {
        System.out.println("Coupon created for user: " + userId);
        this.kafkaTemplate.send("coupon_create", userId);
    }

}
