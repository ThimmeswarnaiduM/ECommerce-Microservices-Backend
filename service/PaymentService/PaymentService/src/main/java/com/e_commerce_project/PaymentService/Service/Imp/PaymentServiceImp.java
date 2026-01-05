package com.e_commerce_project.PaymentService.Service.Imp;

import com.e_commerce_project.PaymentService.Entity.Payment;
import com.e_commerce_project.PaymentService.Mapper.Mapper;
import com.e_commerce_project.PaymentService.Records.PaymentRequest;
import com.e_commerce_project.PaymentService.Records.paymentNotificationRequest;
import com.e_commerce_project.PaymentService.Repository.PaymentRepository;
import com.e_commerce_project.PaymentService.Service.PaymentService;
import com.e_commerce_project.PaymentService.kafka.NotificationProducer;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;

@Service
@RequiredArgsConstructor
public class PaymentServiceImp implements PaymentService {
    private final PaymentRepository paymentRepository;
    private final NotificationProducer notificationProducer;
    //private final Mapper mapper;
    @Override
    public Long createPayment(PaymentRequest request) {
        Payment save = paymentRepository.save(Mapper.toPayment(request));
        notificationProducer.sendNotification(
        new paymentNotificationRequest(
                save.getId(),
                save.getAmount(),
                save.getOrderId(),
                save.getPaymentMethod(),
                save.getCustomer().firstName,
                save.getCustomer().lastName,
                save.getCustomer().email
        )
        );
        return request.id();


    }
}
