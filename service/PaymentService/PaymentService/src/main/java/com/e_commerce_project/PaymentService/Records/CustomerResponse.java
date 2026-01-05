package com.e_commerce_project.PaymentService.Records;

import lombok.Builder;

@Builder
public record CustomerResponse(
        String id,
        String firstName,
        String lastName,
        String email) {
}
