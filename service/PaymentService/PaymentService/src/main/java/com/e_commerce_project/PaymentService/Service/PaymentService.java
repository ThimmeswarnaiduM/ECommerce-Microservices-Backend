package com.e_commerce_project.PaymentService.Service;

import com.e_commerce_project.PaymentService.Entity.Payment;
import com.e_commerce_project.PaymentService.Records.PaymentRequest;

public interface PaymentService {
    Long createPayment(PaymentRequest request);
}
