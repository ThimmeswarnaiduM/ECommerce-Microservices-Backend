package com.e_commerce_project.PaymentService.Mapper;

import com.e_commerce_project.PaymentService.Entity.Payment;
import com.e_commerce_project.PaymentService.Records.PaymentRequest;
import java.time.LocalDateTime;

public class Mapper {

    public static Payment toPayment(PaymentRequest request) {
        LocalDateTime now = LocalDateTime.now();
        return Payment.builder()
                .id(request.id())
                .amount(request.amount())
                .paymentMethod(request.paymentMethod())
                .orderId(request.OrderId())

                .customer(CustomerEmbedded.builder()
                        .id(request.Customer().id())
                        .firstName(request.Customer().firstName())
                        .lastName(request.Customer().lastName())
                        .email(request.Customer().email())
                        .build())
                .createDate(now)
                .lastModifiedDate(now)
                .build();
    }
}
