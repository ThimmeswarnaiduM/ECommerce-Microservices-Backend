package com.e_commerce_project.orderservice.Records;

import com.e_commerce_project.orderservice.Entity.Address;
import com.fasterxml.jackson.annotation.JsonProperty;

public record CustomerResponse(
        @JsonProperty("_id") String id,
        String firstName,
        @JsonProperty("lastName") String lastName,
        String email,
        String password,
        String phoneNumber,
        int age,
        Address address
) {}