package com.spring.payment.repository;

import com.spring.payment.model.PaymentEntity;
import org.jspecify.annotations.NonNull;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface PaymentRepository extends JpaRepository<@NonNull PaymentEntity, @NonNull Long> {
}
