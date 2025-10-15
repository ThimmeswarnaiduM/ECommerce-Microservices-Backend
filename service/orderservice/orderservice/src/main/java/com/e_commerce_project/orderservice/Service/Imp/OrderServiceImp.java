package com.e_commerce_project.orderservice.Service.Imp;

import com.e_commerce_project.orderservice.Entity.Order;
import com.e_commerce_project.orderservice.Kafka.OrderProducer;
import com.e_commerce_project.orderservice.Mapping.OrderMapper;
import com.e_commerce_project.orderservice.OpenFeign.customerResponse;
import com.e_commerce_project.orderservice.Records.*;
import com.e_commerce_project.orderservice.Repository.OrderRepository;
import com.e_commerce_project.orderservice.RestTemplateConfigs.ProductClient;
import com.e_commerce_project.orderservice.Service.OrderService;
import lombok.RequiredArgsConstructor;
import org.springframework.beans.factory.annotation.Qualifier;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.stream.Collectors;

@Service
@RequiredArgsConstructor


public class OrderServiceImp implements OrderService {
    private final customerResponse customerResponse;
    @Qualifier("productClient")

    private final ProductClient productClient;
    private final OrderRepository orderRepository;
    private final OrderMapper orderMapper;
    private final OrderLineservice orderLineservice;
    private final OrderProducer orderProducer;
    @Override
    public Long createOrder(OrderRequest orderRequest) {
   var customer= this.customerResponse.getCustomer(orderRequest.customerId()).orElseThrow(() -> new RuntimeException("Customer not found with the give CustomerId: "+orderRequest.customerId()));
      var products= this.productClient.purchaseResponse(orderRequest.products());
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

       orderProducer.sendOrderConfirmation(
               new OrderConfirmation(
                       orderRequest.referenceNumber(),
                       orderRequest.totalAmount(),
                       orderRequest.paymentStatus(),
                      customer,
                       products

               )
       );
        return order.getId();
    }

    @Override
    public List<OrderResponse> getAllOrders() {
        List<Order> all = orderRepository.findAll();
        List<OrderResponse> collect = all.stream().map(orderMapper::FromOrder).collect(Collectors.toList());
        return collect;
    }

    @Override
    public OrderResponse getOrderById(Long id) {
        return orderRepository.findById(id)
                .map(orderMapper::FromOrder)
                .orElseThrow(() -> new RuntimeException("Order not found with id: " + id));
    }

}
