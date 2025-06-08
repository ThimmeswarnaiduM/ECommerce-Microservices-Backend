package e_Commerce_project.customer.entity;

import jakarta.persistence.*;
import jakarta.validation.Valid;
import jakarta.validation.constraints.Email;
import jakarta.validation.constraints.NotEmpty;
import jakarta.validation.constraints.Pattern;
import lombok.*;
import org.springframework.data.annotation.Id;
import org.springframework.data.mongodb.core.mapping.Document;

@NoArgsConstructor
@AllArgsConstructor
@Getter
@Setter
@Builder
@Document
@ToString
public class Customer {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private String id;
    @NotEmpty(message = "first Name cannot be empty")
   @Pattern(regexp = "[a-zA-Z]+", message = "name should contain only alphabets")
    private String firstName;
    @NotEmpty(message = "last Name cannot be empty")
    @Pattern(regexp = "[a-zA-Z]+", message = "name should contain only alphabets")
    private  String lastName;
    @NotEmpty
    @Email(message = "email should be valid")
    @Pattern(regexp = "^[a-zA-Z0-9._%+-]+@[a-zA-Z0-9.-]+\\.[a-zA-Z]{2,}$", message = "email should be valid")
    private String email;
    @NotEmpty(message = "password cannot be empty")
    @Pattern(regexp = "(?=.*[A-Za-z])(?=.*\\d)(?=.*[@$!%*#?&])[A-Za-z\\d@$!%*#?&]{8,}",message ="Password must have at least one uppercase letter,one lowercase letter,one digit and one special character" )
    private String password;
    @NotEmpty(message = "phone number cannot be empty")
    @Pattern(regexp = "^\\+?[0-9]{10,15}$", message = "Phone number should be a valid phone number")
    private String phoneNumber;
    @NotEmpty(message = "age cannot be empty")
    private int age;

    @ManyToOne(cascade = CascadeType.ALL)
    @JoinColumn(name="address_id",nullable=false)

    @Valid
    private Address address;
}
