package com.e_commerce_project.orderservice.Entity;

import jakarta.persistence.*;
import lombok.*;
import org.springframework.data.annotation.CreatedBy;
import org.springframework.data.annotation.LastModifiedDate;
import org.springframework.data.jpa.domain.support.AuditingEntityListener;

import java.math.BigDecimal;
import java.time.LocalDateTime;
import java.util.List;

@Entity
@AllArgsConstructor
@NoArgsConstructor
@Builder
@ToString
@Getter
@Setter
@EntityListeners(AuditingEntityListener.class)
public class Order {
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
    @CreatedBy
    @Column(updatable = false, nullable = false)

    private LocalDateTime createdAt;
    @LastModifiedDate
    @Column(nullable = false,insertable = false)
    private LocalDateTime updatedAt;
}
