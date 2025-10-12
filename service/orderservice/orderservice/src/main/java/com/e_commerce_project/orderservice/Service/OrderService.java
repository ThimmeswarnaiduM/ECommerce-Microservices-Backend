package com.e_commerce_project.orderservice.Service;

import com.e_commerce_project.orderservice.Records.OrderRequest;

import java.util.List;

public interface OrderService {
    Long createOrder(OrderRequest orderRequest);

    List<OrderRequest> getAllOrders();

    OrderRequest getOrderById(Long id);
}
