package com.spring.payment.service;

import com.spring.payment.model.PaymentEntity;
import com.spring.payment.model.PaymentRequest;
import com.spring.payment.model.PaymentResponse;
import com.spring.payment.repository.PaymentRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.ArrayList;
import java.util.List;

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

    public PaymentResponse viewPayment(Long id) {
        PaymentEntity paymentEntity = paymentRepository.findById(id).orElse(new PaymentEntity());
        PaymentResponse paymentResponse = new PaymentResponse();
        paymentResponse.setAmount(paymentEntity.getAmount());
        paymentResponse.setPaymentStatus(paymentEntity.getPaymentStatus());
        paymentResponse.setTransactionId(paymentEntity.getTransactionId());
        return paymentResponse;
    }

    public List<PaymentResponse> viewAllPayments() {
        List<PaymentResponse> paymentResponseList = new ArrayList<>();
        paymentRepository.findAll().forEach(paymentEntity -> {
            PaymentResponse paymentResponse = new PaymentResponse();
            paymentResponse.setAmount(paymentEntity.getAmount());
            paymentResponse.setPaymentStatus(paymentEntity.getPaymentStatus());
            paymentResponse.setTransactionId(paymentEntity.getTransactionId());
            paymentResponseList.add(paymentResponse);
        });
        return paymentResponseList;
    }
}
