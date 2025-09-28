package com.e_commerce_project.orderservice.DTo;

import com.e_commerce_project.orderservice.Entity.OrderLine;
import com.e_commerce_project.orderservice.Entity.PaymentStatus;
import jakarta.persistence.*;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

import java.math.BigDecimal;
import java.util.List;

@Data
@AllArgsConstructor
@NoArgsConstructor
public class OrderDto {
    @Id
    @GeneratedValue(strategy = GenerationType.AUTO)
    private long id;
    private String referenceNumber;
    private BigDecimal totalAmount;
    private String customerId;
    @Enumerated(EnumType.STRING)
    private PaymentStatus paymentStatus;
    @OneToMany(mappedBy = "order")
    private List<OrderLine> orderLines;
}
