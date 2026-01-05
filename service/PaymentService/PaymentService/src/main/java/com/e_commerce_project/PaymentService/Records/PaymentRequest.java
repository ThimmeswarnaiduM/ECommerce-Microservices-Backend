package com.e_commerce_project.PaymentService.Records;

import com.e_commerce_project.PaymentService.Entity.PaymentStatus;
import lombok.Builder;

import java.math.BigDecimal;
@Builder
public record PaymentRequest(
        Long id,
        BigDecimal amount,
        String OrderId,
        PaymentStatus paymentMethod,
        CustomerResponse Customer
) {
}
