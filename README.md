# Coupon System Design

Kafka, Redis를 활용한 선착순 쿠폰 발급 시스템 Design 연습

## Log

- 한명당 하나의 쿠폰 발급 기능 [f0f3ed7](https://github.com/dobidugi/coupon-system/commit/f0f3ed7e5f12eb100dc55939ad827e8bcf35d3a6)
- Kafka를 활용하여 처리량 분산
  - Kafka를 Producer 구현 [f4d4c11](https://github.com/dobidugi/coupon-system/commit/f4d4c114116c3063388972aa05a1a58723282ff4)
  - 쿠폰 발급 Consumer Module 구현 [897c329](https://github.com/dobidugi/coupon-system/commit/897c329bbd01af6c57e80199c25a2706ad438d81)
  - Consumer에서 쿠폰 발급 처리 [9a4a45c](https://github.com/dobidugi/coupon-system/commit/9a4a45c2dbbca009dcf04edf0f5996b859a2f930)
- Redis를 활용하여 쿠폰 발급시 Race condition 
  - Redis를 활용하여 발급시 Race Condition 해결 [b3b90c1](https://github.com/dobidugi/coupon-system/commit/b3b90c1b8b1c6b07318827e99d621aa77ea94646)
- 쿠폰 발급 기능 
  - 쿠폰 발급 기능 구현 [6baf022](https://github.com/dobidugi/coupon-system/commit/6baf022e5e39921a5886190aad504c5043c20472)
  - 쿠폰 발급 테스트 코드 [6bdf575](https://github.com/dobidugi/coupon-system/commit/6bdf5758b86b0b3dc83da4e290d952ee7c1b7e8b)
