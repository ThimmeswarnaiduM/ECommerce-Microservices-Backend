package com.e_commerce_project.orderservice.Service.Imp;

import com.e_commerce_project.orderservice.Mapping.OrderLineMapper;
import com.e_commerce_project.orderservice.Mapping.OrderMapper;
import com.e_commerce_project.orderservice.Records.OrderLineRequest;
import com.e_commerce_project.orderservice.Repository.OrderLineRespository;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;

@Service
@RequiredArgsConstructor
public class OrderLineservice {
    private final OrderLineMapper Mapper;
    private final OrderLineRespository orderLineRespository;
    public Long saveOrderline(OrderLineRequest orderLineRequest){
        var order= Mapper.toOrderLine(orderLineRequest);
        return this.orderLineRespository.save(order).getId();
    }
}
