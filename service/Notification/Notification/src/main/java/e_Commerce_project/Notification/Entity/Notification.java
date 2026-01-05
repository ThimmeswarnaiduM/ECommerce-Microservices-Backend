package e_Commerce_project.Notification.Entity;


import e_Commerce_project.Notification.Records.OrderConfirmation;

import e_Commerce_project.Notification.Records.PaymentConfirmation;
import lombok.*;
import org.springframework.data.mongodb.core.mapping.Document;

import java.time.LocalDateTime;


@AllArgsConstructor
@NoArgsConstructor
@ToString
@Builder
@Document(collection = "notification")
public class Notification{
    private String id;
  private  NotificationType notificationType;
  private LocalDateTime notificationDate;
  private OrderConfirmation orderconfirmation;
  private PaymentConfirmation paymentConfirmation;
}
