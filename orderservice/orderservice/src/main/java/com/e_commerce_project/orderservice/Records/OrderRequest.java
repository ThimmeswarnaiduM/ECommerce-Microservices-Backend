package com.e_commerce_project.orderservice.Records;

import com.e_commerce_project.orderservice.Entity.PaymentStatus;
import lombok.AllArgsConstructor;
import lombok.Data;

import java.math.BigDecimal;
import java.util.List;

public record OrderRequest(Long id,
                           String referenceNumber,
                           BigDecimal totalAmount,
                           PaymentStatus paymentStatus,
                                  String customerId,
                           List<PurchaseRequest> products) {
}
