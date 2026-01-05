package e_Commerce_project.Notification.Records;

import java.math.BigDecimal;

public record  PurchaseResponse(
        Long productId,
        String name,
        String description,
        BigDecimal price,
        double quantity


) {
}
