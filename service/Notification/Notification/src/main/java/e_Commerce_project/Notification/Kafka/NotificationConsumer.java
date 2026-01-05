package e_Commerce_project.Notification.Kafka;

import com.fasterxml.jackson.databind.ObjectMapper;
import e_Commerce_project.Notification.Email.EmailSender;
import e_Commerce_project.Notification.Entity.Notification;
import e_Commerce_project.Notification.Entity.NotificationType;
import e_Commerce_project.Notification.Records.OrderConfirmation;
import e_Commerce_project.Notification.Records.PaymentConfirmation;
import e_Commerce_project.Notification.Repository.NotificationRepository;
import jakarta.mail.MessagingException;
import lombok.RequiredArgsConstructor;
import lombok.extern.slf4j.Slf4j;
import org.springframework.kafka.annotation.KafkaListener;
import org.springframework.stereotype.Service;

import java.time.LocalDateTime;

@Service
@RequiredArgsConstructor
@Slf4j
public class NotificationConsumer {

    private final NotificationRepository repo;
    private final EmailSender emailSender;
    private final ObjectMapper objectMapper;

    // ✅ PAYMENT
    @KafkaListener(topics = "payment-topic", groupId = "payment-success-group")
    public void consumerPaymentSuccessNotification(String message) throws Exception {

        PaymentConfirmation payment =
                objectMapper.readValue(message, PaymentConfirmation.class);

        log.info("Payment confirmation received: {}", payment);

        repo.save(
                Notification.builder()
                        .notificationType(NotificationType.Payment_confirmation)
                        .notificationDate(LocalDateTime.now())
                        .paymentConfirmation(payment)
                        .build()
        );

        String customerName =
                payment.CustomerFirstname() + " " + payment.CustomerLastName();

        emailSender.sendPaymentsuccessEmail(
                payment.CustomerEmail(),
                customerName,
                payment.amount().toString(),
                payment.amount().toString()
        );
    }

    // ✅ ORDER
    @KafkaListener(topics = "order-topic", groupId = "order-success-group")
    public void consumerOrderSuccessNotification(String message) throws Exception {

        OrderConfirmation order =
                objectMapper.readValue(message, OrderConfirmation.class);

        log.info("Order confirmation received: {}", order);

        repo.save(
                Notification.builder()
                        .notificationType(NotificationType.Order_confirmation)
                        .notificationDate(LocalDateTime.now())
                        .orderconfirmation(order)
                        .build()
        );

        String customerName =

                order.customerResponse().firstName()+" "+order.customerResponse().lastName();

        emailSender.sendOrderConfirmationEmail(
                order.customerResponse().email(),
                customerName,
                order.totalAmount().toString(),
                order.referenceNumber(),
                order.products()
        );
    }
}
