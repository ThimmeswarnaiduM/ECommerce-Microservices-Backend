package com.e_commerce_project.orderservice.Records;

import com.e_commerce_project.orderservice.Entity.PaymentStatus;

import java.math.BigDecimal;

public record PaymentRequest(

        BigDecimal amount,
        Long OrderId,
        PaymentStatus paymentMethod,
        CustomerResponse Customer
) {
}
