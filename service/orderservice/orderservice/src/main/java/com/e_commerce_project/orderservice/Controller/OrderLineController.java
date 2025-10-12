package com.e_commerce_project.orderservice.Controller;

import com.e_commerce_project.orderservice.Records.OrderLineResponse;
import com.e_commerce_project.orderservice.Service.OrderLineService;
import lombok.RequiredArgsConstructor;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import java.util.List;

@RestController
@RequestMapping("/api/orderLine")
@RequiredArgsConstructor
public class OrderLineController {
    private final OrderLineService service;
    @GetMapping
    public ResponseEntity <List<OrderLineResponse>>getAllOrderLines(){
        return ResponseEntity.ok(service.getAllOrderLines());
    }
    @GetMapping("/{id}")
    public ResponseEntity<OrderLineResponse>getOrderLineById(@PathVariable Long id){
        return ResponseEntity.ok(service.getOrderLineById(id));
    }
}
