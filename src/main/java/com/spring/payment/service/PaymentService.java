package com.spring.payment.service;

import com.spring.payment.model.PaymentEntity;
import com.spring.payment.model.PaymentRequest;
import com.spring.payment.repository.PaymentRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.Optional;

@Service
public class PaymentService {
    @Autowired
    private PaymentRepository paymentRepository;

    public String savePayment(PaymentRequest paymentRequest) {
        PaymentEntity paymentEntity = new PaymentEntity();
        paymentEntity.setAmount(paymentRequest.getAmount());
        paymentEntity.setPaymentStatus(paymentRequest.getPaymentStatus());
        paymentEntity.setTransactionId(paymentRequest.getTransactionId());
        paymentRepository.save(paymentEntity);
        return "Payment processed successfully!";
    }

    public Optional<PaymentEntity> viewPaymentStatus(Long id) {
        return Optional.of(paymentRepository.findById(id)
                .orElseThrow(() -> new RuntimeException("Payment not found for transaction ID: " + id)));
    }
}
