package e_Commerce_project.customer.dto;

import e_Commerce_project.customer.entity.Address;
import jakarta.validation.constraints.Email;
import jakarta.validation.constraints.Pattern;
import lombok.*;

@NoArgsConstructor
@AllArgsConstructor
@Setter
@Getter
@ToString
public class CustomerUpdateDto {

    @Pattern(regexp = "[a-zA-Z]+", message = "First name must contain only letters")
    private String firstName;

    @Pattern(regexp = "[a-zA-Z]+", message = "Last name must contain only letters")
    private String lastName;

    @Email(message = "Email should be valid")
    @Pattern(regexp = "^[a-zA-Z0-9._%+-]+@[a-zA-Z0-9.-]+\\.[a-zA-Z]{2,}$", message = "Email should be valid")
    private String email;

    @Pattern(
            regexp = "(?=.*[A-Za-z])(?=.*\\d)(?=.*[@$!%*#?&])[A-Za-z\\d@$!%*#?&]{8,}",
            message = "Password must be at least 8 characters with uppercase, digit, and special character"
    )
    private String password;

    @Pattern(regexp = "^\\+?[0-9]{10,15}$", message = "Phone number must be valid")
    private String phoneNumber;

    private Integer age;

    private Address address;
}
