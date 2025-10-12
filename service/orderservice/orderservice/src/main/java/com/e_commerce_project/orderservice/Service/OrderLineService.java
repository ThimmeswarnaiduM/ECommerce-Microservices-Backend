package com.e_commerce_project.orderservice.Service;

import com.e_commerce_project.orderservice.Records.OrderLineResponse;

import java.util.List;

public interface OrderLineService {
    List<OrderLineResponse> getAllOrderLines();

    OrderLineResponse getOrderLineById(Long id);
}
