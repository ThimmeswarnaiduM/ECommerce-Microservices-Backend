package e_Commerce_project.Notification.Records;

import e_Commerce_project.Notification.Entity.PaymentStatus;

import java.math.BigDecimal;
import java.util.List;

public record OrderConfirmation(
        String referenceNumber,
        BigDecimal totalAmount,
        PaymentStatus paymentStatus,
        CustomerResponse customerResponse,
        List<PurchaseResponse> products



) {
}
