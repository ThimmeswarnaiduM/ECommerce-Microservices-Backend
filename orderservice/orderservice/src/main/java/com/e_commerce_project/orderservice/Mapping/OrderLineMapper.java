package com.e_commerce_project.orderservice.Mapping;

import com.e_commerce_project.orderservice.Entity.Order;
import com.e_commerce_project.orderservice.Entity.OrderLine;
import com.e_commerce_project.orderservice.Records.OrderLineRequest;
import jakarta.persistence.EntityManager;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;

@Service
@RequiredArgsConstructor
public class OrderLineMapper {
    private final EntityManager entityManager;

    public OrderLine toOrderLine(OrderLineRequest orderLineRequest) {
        return OrderLine.builder()
                .quantity(orderLineRequest.quantity())
                .order(
                        // ✅ Proper managed reference (no detached entity)
                        entityManager.getReference(Order.class, orderLineRequest.orderId())
                )
                .productId(orderLineRequest.productId())
                .build();
    }
}
