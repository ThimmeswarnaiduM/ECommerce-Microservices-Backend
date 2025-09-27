package com.e_commerce_project.orderservice.OpenFeign;

import com.e_commerce_project.orderservice.Records.CustomerResponse;
import org.springframework.cloud.openfeign.FeignClient;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;

import java.util.Optional;

@FeignClient(
        name = "customer-service",
        url = "${application.customer.url}"  // comes from application.yml/properties
)
public interface customerResponse {

    @GetMapping("/{id}")
    Optional<CustomerResponse> getCustomer(@PathVariable("id") String id);
}
