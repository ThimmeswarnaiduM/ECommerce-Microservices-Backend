package com.e_commerce_project.orderservice.Records;

public record PurchaseRequest(
        Long productId,
        Double quantity
) {
}
