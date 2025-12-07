package com.spring.payment.controller;

import com.spring.payment.model.PaymentRequest;
import com.spring.payment.service.PaymentService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

@RestController
@RequestMapping("/api")
public class PaymentController {
    @Autowired
    private PaymentService paymentService;

    @PostMapping("/savePayment")
    public String savePayment(@RequestBody PaymentRequest paymentRequest) {
        return paymentService.savePayment(paymentRequest);
    }

    @GetMapping("/viewPaymentStatus")
    public Object viewPaymentStatus(@RequestParam Long id) {
        return paymentService.viewPaymentStatus(id);
    }
}
