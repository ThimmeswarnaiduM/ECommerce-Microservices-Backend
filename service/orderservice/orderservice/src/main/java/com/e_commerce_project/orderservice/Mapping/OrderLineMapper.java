package com.e_commerce_project.orderservice.Mapping;

import com.e_commerce_project.orderservice.Entity.Order;
import com.e_commerce_project.orderservice.Entity.OrderLine;
import com.e_commerce_project.orderservice.Records.OrderLineRequest;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;

@Service
@RequiredArgsConstructor
public class OrderLineMapper {
    public OrderLine toOrderLine(OrderLineRequest orderLineRequest){
        return OrderLine.builder()
                .id(orderLineRequest.id())
                .quantity(orderLineRequest.quantity())
                .order(
                        Order.builder().id(orderLineRequest.orderId()).build())
                .productId(orderLineRequest.productId()).build();

    }
}
