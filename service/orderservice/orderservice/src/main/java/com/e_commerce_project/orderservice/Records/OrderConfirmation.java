package com.e_commerce_project.orderservice.Records;

import com.e_commerce_project.orderservice.Entity.PaymentStatus;

import java.math.BigDecimal;
import java.util.List;

public record OrderConfirmation(
        String referenceNumber,
        BigDecimal totalAmount,
        PaymentStatus paymentStatus,
        CustomerResponse customerResponse,
        List<PurchaseResponse> products) {

}
