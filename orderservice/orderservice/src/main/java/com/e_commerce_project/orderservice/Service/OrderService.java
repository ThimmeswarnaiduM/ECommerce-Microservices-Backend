package com.e_commerce_project.orderservice.Service;

import com.e_commerce_project.orderservice.Records.OrderRequest;
import com.e_commerce_project.orderservice.Records.OrderResponse;

import java.util.List;

public interface OrderService {
    Long createOrder(OrderRequest orderRequest);

    List<OrderResponse> getAllOrders();

    OrderResponse getOrderById(Long id);
}
