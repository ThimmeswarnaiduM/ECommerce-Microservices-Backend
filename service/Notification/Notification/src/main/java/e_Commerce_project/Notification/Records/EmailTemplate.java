package e_Commerce_project.Notification.Records;

import lombok.Getter;
import lombok.Setter;

public enum EmailTemplate {
    Payment_Confirmation ("Payment_confirmation.html","Payment Successfully processed"),
    Order_Confirmation("Order_confirmation.html","Order Successfully processed");
    @Setter
    @Getter
    private String template;
    @Setter
    @Getter
    private String subject;
    EmailTemplate(String template, String subject) {
        this.template = template;
        this.subject = subject;
    }
}
