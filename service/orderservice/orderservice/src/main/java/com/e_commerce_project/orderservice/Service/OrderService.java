package com.e_commerce_project.orderservice.Service;

import com.e_commerce_project.orderservice.Records.OrderRequest;

public interface OrderService {
    Long createOrder(OrderRequest orderRequest);
}
