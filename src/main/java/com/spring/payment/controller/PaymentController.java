package com.spring.payment.controller;

import com.spring.payment.model.PaymentRequest;
import com.spring.payment.model.PaymentResponse;
import com.spring.payment.service.PaymentService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/payment")
public class PaymentController {
    @Autowired
    private PaymentService paymentService;

    @PostMapping("/savePayment")
    public ResponseEntity<String> savePayment(@RequestBody PaymentRequest paymentRequest) {
        return ResponseEntity.ok(paymentService.savePayment(paymentRequest));
    }

    @GetMapping("/viewPayment")
    public ResponseEntity<PaymentResponse> viewPaymentStatus(@RequestParam Long id) {
        return ResponseEntity.ok(paymentService.viewPayment(id));
    }

    @GetMapping("/viewAllPayments")
    public ResponseEntity<List<PaymentResponse>> viewAllPayments() {
        return ResponseEntity.ok(paymentService.viewAllPayments());
    }
}
