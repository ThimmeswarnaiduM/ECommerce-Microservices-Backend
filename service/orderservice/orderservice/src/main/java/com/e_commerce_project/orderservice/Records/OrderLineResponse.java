package com.e_commerce_project.orderservice.Records;

import lombok.Builder;
import lombok.Data;
import lombok.ToString;


@Builder


public record OrderLineResponse(
        Long id,
        Long orderId,
        Long productId,
        double quantity
) {
}
