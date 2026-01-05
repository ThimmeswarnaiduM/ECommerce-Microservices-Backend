package com.e_commerce_project.PaymentService.Records;

import com.e_commerce_project.PaymentService.Entity.PaymentStatus;

import java.math.BigDecimal;

public record paymentNotificationRequest(
        long id,
        BigDecimal amount,
        String OrderId,
        PaymentStatus paymentMethod,
        String CustomerFirstname,
        String CustomerLastName,
        String CustomerEmail
) {
}
