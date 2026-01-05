package com.e_commerce_project.PaymentService.Mapper;

import jakarta.persistence.Column;
import jakarta.persistence.Embeddable;
import lombok.*;

@Embeddable
@Getter
@Setter
@NoArgsConstructor
@AllArgsConstructor
@Builder
@ToString
public class CustomerEmbedded {

    @Column(name = "customer_id")
    public String id;

    @Column(name = "customer_first_name")
    public String firstName;

    @Column(name = "customer_last_name")
    public String lastName;

    @Column(name = "customer_email")
    public String email;
}
