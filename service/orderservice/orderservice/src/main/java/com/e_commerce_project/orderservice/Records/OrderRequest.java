package com.e_commerce_project.orderservice.Records;

import com.e_commerce_project.orderservice.Entity.PaymentStatus;
import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.ToString;

import java.math.BigDecimal;
import java.util.List;

@Builder
public record OrderRequest(Long id,
                           String referenceNumber,
                           BigDecimal totalAmount,
                           PaymentStatus paymentStatus,
                                  String customerId,
                           List<PurchaseRequest> products) {
}
