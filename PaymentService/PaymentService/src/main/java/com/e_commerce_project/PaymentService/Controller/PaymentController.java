package com.e_commerce_project.PaymentService.Controller;

import com.e_commerce_project.PaymentService.Records.PaymentRequest;
import com.e_commerce_project.PaymentService.Repository.PaymentRepository;
import com.e_commerce_project.PaymentService.Service.PaymentService;
import lombok.RequiredArgsConstructor;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequestMapping("/api/v1/payments")
@RequiredArgsConstructor
public class PaymentController {
    private final PaymentService paymentService;

    @PostMapping("/Payment")
    public ResponseEntity<Long>createPayment(@RequestBody PaymentRequest request){

        return ResponseEntity.ok(paymentService.createPayment(request));
    }
}
