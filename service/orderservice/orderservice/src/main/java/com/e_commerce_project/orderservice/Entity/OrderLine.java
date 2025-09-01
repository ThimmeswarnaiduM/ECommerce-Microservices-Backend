package com.e_commerce_project.orderservice.Entity;

import jakarta.persistence.Entity;
import jakarta.persistence.JoinColumn;
import lombok.*;

@AllArgsConstructor
@NoArgsConstructor
@Getter
@Setter
@Builder
@ToString
@Entity
public class OrderLine {
    private long id;
    @JoinColumn(name = "order_id")
    private Order order;
    private Integer productId;
    private double quantity;
}
