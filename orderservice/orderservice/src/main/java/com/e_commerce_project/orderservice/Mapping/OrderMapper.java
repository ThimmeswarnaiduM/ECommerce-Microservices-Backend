package com.e_commerce_project.orderservice.Mapping;

import com.e_commerce_project.orderservice.Entity.Order;
import com.e_commerce_project.orderservice.Records.OrderRequest;
import com.e_commerce_project.orderservice.Records.OrderResponse;
import lombok.AllArgsConstructor;
import lombok.Data;
import org.springframework.stereotype.Service;

import java.util.stream.Collectors;

@Service
@Data
@AllArgsConstructor
public class OrderMapper {
    public Order toOrder(OrderRequest orderRequest){
        return Order.builder()
                //.id(orderRequest.id())
                .customerId(orderRequest.customerId())
                .referenceNumber(orderRequest.referenceNumber())
                .totalAmount(orderRequest.totalAmount())
                .paymentStatus(orderRequest.paymentStatus())
                .build();


    }

    public OrderResponse FromOrder(Order order) {
        if (order == null) {
            return null;
        }

        return OrderResponse.builder()
                .customerId(order.getCustomerId())
                .referenceNumber(order.getReferenceNumber())
                .totalAmount(order.getTotalAmount())
                .paymentStatus(order.getPaymentStatus())
                .build();
    }
}
