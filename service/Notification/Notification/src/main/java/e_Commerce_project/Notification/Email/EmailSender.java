package e_Commerce_project.Notification.Email;


import e_Commerce_project.Notification.Records.PurchaseResponse;
import jakarta.mail.MessagingException;
import jakarta.mail.internet.MimeMessage;
import lombok.RequiredArgsConstructor;
import lombok.extern.slf4j.Slf4j;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.mail.javamail.JavaMailSender;
import org.springframework.mail.javamail.MimeMessageHelper;
import org.springframework.scheduling.annotation.Async;
import org.springframework.stereotype.Service;
import org.thymeleaf.context.Context;
import org.thymeleaf.spring6.SpringTemplateEngine;

import java.nio.charset.StandardCharsets;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

import static e_Commerce_project.Notification.Records.EmailTemplate.Order_Confirmation;
import static e_Commerce_project.Notification.Records.EmailTemplate.Payment_Confirmation;

@Service
@Slf4j

public class EmailSender {
    @Autowired
    private JavaMailSender mailSender;
    @Autowired
    private SpringTemplateEngine template;
    @Async
    public void  sendPaymentsuccessEmail(
            String destinationEmail,
            String customerName,
            String amount,
            String orderReference
    ) throws MessagingException {
        MimeMessage message=mailSender.createMimeMessage();
       MimeMessageHelper helper=new MimeMessageHelper
               (message,MimeMessageHelper.MULTIPART_MODE_MIXED_RELATED, StandardCharsets.UTF_8.name());
       helper.setFrom("thimmeswarnaidu1107@gmail.com");
        helper.setTo(destinationEmail);
        final String  templateName=Payment_Confirmation.getTemplate();
       Map<String,Object> varaibles=new HashMap<>();
       varaibles.put("customerName",customerName);
       varaibles.put("amount",amount);
       varaibles.put("orderReference",orderReference);
      Context context=new Context();
      context.setVariables(varaibles);
      String content=template.process(templateName,context);
      helper.setSubject(Payment_Confirmation.getSubject());
      helper.setText(content,true);
      mailSender.send(message);
      log.info("Payment confirmation email sent to {}",destinationEmail);
    }
    public void sendOrderConfirmationEmail(
            String destinationEmail,
            String customerName,
            String amount,
            String orderReference,
            List<PurchaseResponse> products
    ) throws MessagingException {
        MimeMessage message=mailSender.createMimeMessage();
        MimeMessageHelper helper=new MimeMessageHelper
                (message,MimeMessageHelper.MULTIPART_MODE_MIXED_RELATED, StandardCharsets.UTF_8.name());
        helper.setFrom("thimmeswarnaidu1107@gmail.com");
        helper.setTo(destinationEmail);
        final String  templateName=Order_Confirmation.getTemplate();
        Map<String,Object> varaibles=new HashMap<>();
        varaibles.put("customerName",customerName);
        varaibles.put("amount",amount);
        varaibles.put("orderReference",orderReference);
       Context context=new Context();
       context.setVariables(varaibles);
       String content=template.process(templateName,context);
       helper.setSubject(Order_Confirmation.getSubject());
       helper.setText(content,true);
       mailSender.send(message);
       log.info("Order confirmation email sent to {}",destinationEmail);
    }
}
