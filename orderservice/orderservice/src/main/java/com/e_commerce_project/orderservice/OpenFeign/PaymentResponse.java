package com.e_commerce_project.orderservice.OpenFeign;

import com.e_commerce_project.orderservice.Records.PaymentRequest;
import org.springframework.cloud.openfeign.FeignClient;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;

@FeignClient(
        name = "PaymentService",
         url = "${application.payment.url}"
)
//PAYMENT_URL
public interface PaymentResponse {
    @PostMapping("/Payment")
    Long createPayment(@RequestBody PaymentRequest request);
}
