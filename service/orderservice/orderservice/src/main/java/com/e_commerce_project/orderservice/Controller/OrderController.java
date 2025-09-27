package com.e_commerce_project.orderservice.Controller;

import com.e_commerce_project.orderservice.Records.OrderRequest;
import com.e_commerce_project.orderservice.Service.OrderService;
import lombok.RequiredArgsConstructor;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequestMapping("/orders")
//url=http://localhost:8080/orders/createOrder
@RequiredArgsConstructor
public class OrderController {
    private final OrderService orderService;
    @PostMapping("/createOrder")
    public ResponseEntity<Long> CreateOrder(@RequestBody OrderRequest orderRequest){
        return ResponseEntity.ok(orderService.createOrder(orderRequest));

    }



}
