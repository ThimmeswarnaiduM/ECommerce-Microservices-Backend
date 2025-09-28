package com.e_commerce_project.orderservice.Mapping;

import com.e_commerce_project.orderservice.Entity.Order;
import com.e_commerce_project.orderservice.Records.OrderRequest;
import lombok.AllArgsConstructor;
import lombok.Data;
import org.springframework.stereotype.Service;

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
}
