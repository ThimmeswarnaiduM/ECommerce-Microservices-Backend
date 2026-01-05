package e_Commerce_project.Notification.Records;

import java.math.BigDecimal;
import java.math.BigInteger;

import java.math.BigDecimal;

public record PaymentConfirmation(
        Long id,
        BigDecimal amount,
        String OrderId,
        String paymentMethod,
        String CustomerFirstname,
        String CustomerLastName,
        String CustomerEmail
) {}

