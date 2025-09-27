package com.e_commerce_project.orderservice.Service.Imp;

import com.e_commerce_project.orderservice.Mapping.OrderMapper;
import com.e_commerce_project.orderservice.OpenFeign.customerResponse;
import com.e_commerce_project.orderservice.Records.OrderLineRequest;
import com.e_commerce_project.orderservice.Records.OrderRequest;
import com.e_commerce_project.orderservice.Records.PurchaseRequest;
import com.e_commerce_project.orderservice.Repository.OrderRepository;
import com.e_commerce_project.orderservice.RestTemplateConfigs.ProductClient;
import com.e_commerce_project.orderservice.Service.OrderService;
import lombok.RequiredArgsConstructor;
import org.springframework.beans.factory.annotation.Qualifier;
import org.springframework.stereotype.Service;

@Service
@RequiredArgsConstructor


public class OrderServiceImp implements OrderService {
    private final customerResponse customerResponse;
    @Qualifier("productClient")

    private final ProductClient productClient;
    private final OrderRepository orderRepository;
    private final OrderMapper orderMapper;
    private final OrderLineservice orderLineservice;
    @Override
    public Long createOrder(OrderRequest orderRequest) {
   var customer= this.customerResponse.getCustomer(orderRequest.customerId()).orElseThrow(() -> new RuntimeException("Customer not found with the give CustomerId: "+orderRequest.customerId()));
       this.productClient.purchaseResponse(orderRequest.products());
       var  order =this.orderRepository.save(orderMapper.toOrder(orderRequest));
       for(PurchaseRequest purchaseRequest: orderRequest.products()){
           this.orderLineservice.saveOrderline(
                   new OrderLineRequest(
                           null,
                           order.getId(),
                           purchaseRequest.productId(),
                           purchaseRequest.quantity()

                   )
           );
       }
        return order.getId();
    }
}
