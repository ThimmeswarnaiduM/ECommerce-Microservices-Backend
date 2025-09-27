package com.e_commerce_project.orderservice.Records;

import java.math.BigDecimal;

public record PurchaseResponse(
        long id,
        String name,
        String description,
        BigDecimal price,
        double quantity
) {
}
