package com.e_commerce_project.orderservice.Service.Imp;

import com.e_commerce_project.orderservice.Entity.OrderLine;
import com.e_commerce_project.orderservice.Mapping.OrderLineMapper;
import com.e_commerce_project.orderservice.Mapping.OrderMapper;
import com.e_commerce_project.orderservice.Records.OrderLineRequest;
import com.e_commerce_project.orderservice.Records.OrderLineResponse;
import com.e_commerce_project.orderservice.Repository.OrderLineRespository;
import com.e_commerce_project.orderservice.Service.OrderLineService;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Optional;
import java.util.stream.Collectors;
import java.util.stream.Stream;

@Service
@RequiredArgsConstructor
public class OrderLineservice implements OrderLineService {
    private final OrderLineMapper Mapper;
    private final OrderLineRespository orderLineRespository;
    public Long saveOrderline(OrderLineRequest orderLineRequest){
        var order= Mapper.toOrderLine(orderLineRequest);
        return this.orderLineRespository.save(order).getId();
    }

    @Override
    public List<OrderLineResponse> getAllOrderLines() {
        List<OrderLineResponse> collect = orderLineRespository.findAll().stream().map(Mapper::toOrderLineResponse).collect(Collectors.toList());
        return collect;
    }

    @Override
    public OrderLineResponse getOrderLineById(Long id) {
        Optional<OrderLine> byId = orderLineRespository.findById(id);
        OrderLineResponse orderLineResponse = byId.map(Mapper::toOrderLineResponse).orElseThrow(() -> new RuntimeException("OrderLine not found with id: " + id));
        return orderLineResponse ;
    }
}
