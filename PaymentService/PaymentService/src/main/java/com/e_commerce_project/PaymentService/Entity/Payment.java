package com.e_commerce_project.PaymentService.Entity;


import com.e_commerce_project.PaymentService.Mapper.CustomerEmbedded;
import com.e_commerce_project.PaymentService.Records.CustomerResponse;
import jakarta.persistence.*;
import lombok.*;
import org.springframework.cglib.core.Local;
import org.springframework.data.annotation.CreatedDate;
import org.springframework.data.annotation.LastModifiedBy;

import java.math.BigDecimal;
import java.time.LocalDateTime;

@Entity
@Getter
@Setter
@AllArgsConstructor
@NoArgsConstructor
@Builder
@ToString
public class Payment {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    private BigDecimal amount;
    private String orderId;

    @Enumerated(EnumType.STRING)
    private PaymentStatus paymentMethod;

    @Embedded
    private CustomerEmbedded customer;  // <- mark as @Embedded

    @CreatedDate
    @Column(updatable = false, nullable = false)
    private LocalDateTime createDate;

    @LastModifiedBy
    @Column(nullable = false)
    private LocalDateTime lastModifiedDate;
}

