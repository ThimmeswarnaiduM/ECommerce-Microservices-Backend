package com.e_commerce_project.PaymentService.kafka;

import com.e_commerce_project.PaymentService.Records.paymentNotificationRequest;
import lombok.RequiredArgsConstructor;
import org.springframework.kafka.core.KafkaTemplate;
import org.springframework.kafka.support.KafkaHeaders;
import org.springframework.messaging.Message;
import org.springframework.messaging.support.MessageBuilder;
import org.springframework.stereotype.Service;

@Service
@RequiredArgsConstructor
public class NotificationProducer {
    private final KafkaTemplate<String, paymentNotificationRequest>kafkaTemplate;
    public void sendNotification(paymentNotificationRequest request){
        Message<paymentNotificationRequest>msg= MessageBuilder.withPayload(request)
                .setHeader(KafkaHeaders.TOPIC, "payment-topic")
                .build();
        kafkaTemplate.send(msg);

    }
}
