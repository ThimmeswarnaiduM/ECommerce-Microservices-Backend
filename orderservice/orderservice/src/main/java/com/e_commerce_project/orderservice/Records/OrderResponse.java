package com.e_commerce_project.orderservice.Records;

import com.e_commerce_project.orderservice.Entity.PaymentStatus;
import lombok.Builder;
import lombok.ToString;

import java.math.BigDecimal;

@Builder
public record OrderResponse(
        String referenceNumber,
        BigDecimal totalAmount,
        PaymentStatus paymentStatus,
        String customerId){
}
