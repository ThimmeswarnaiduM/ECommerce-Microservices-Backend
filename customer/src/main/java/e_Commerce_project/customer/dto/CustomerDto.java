package e_Commerce_project.customer.dto;

import e_Commerce_project.customer.entity.Address;
import io.swagger.v3.oas.annotations.media.Schema;
import jakarta.persistence.*;
import jakarta.validation.Valid;
import jakarta.validation.constraints.Email;
import jakarta.validation.constraints.Min;
import jakarta.validation.constraints.NotEmpty;
import jakarta.validation.constraints.Pattern;
import lombok.*;
import org.springframework.data.annotation.Id;

@NoArgsConstructor
@AllArgsConstructor
@Setter
@Getter
@ToString
@Schema(description = "Customer details")
public class CustomerDto {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Schema(description = "id of the customer", example = "1")
    private String id;
    @NotEmpty(message = "first Name cannot be empty")
    @Schema(description = "first name of the customer", example = "John")
    @Pattern(regexp = "[a-zA-Z]+", message = "name should contain only alphabets")
    private String firstName;
    @NotEmpty(message = "last Name cannot be empty")
    @Schema(description = "last name of the customer", example = "Doe")
    @Pattern(regexp = "[a-zA-Z]+", message = "name should contain only alphabets")
    private  String lastName;
    @NotEmpty
    @Email(message = "email should be valid")
    @Schema(description = "email of the customer", example = "john.doe@example.com")
    @Pattern(regexp = "^[a-zA-Z0-9._%+-]+@[a-zA-Z0-9.-]+\\.[a-zA-Z]{2,}$", message = "email should be valid")
    private String email;
    @Schema(description = "password of the customer", example = "Password@123")
    @NotEmpty(message = "password cannot be empty")
    @Pattern(regexp = "(?=.*[A-Za-z])(?=.*\\d)(?=.*[@$!%*#?&])[A-Za-z\\d@$!%*#?&]{8,}",message ="Password must have at least one uppercase letter,one lowercase letter,one digit and one special character" )
    private String password;
    @Schema(description = "phone number of the customer", example = "+919876543210")
    @NotEmpty(message = "phone number cannot be empty")
    @Pattern(regexp = "^\\+?[0-9]{10,15}$", message = "Phone number should be a valid phone number")
    private String phoneNumber;
    @Min(value = 1, message = "Age must be at least 1")
    @Schema(description = "age of the customer", example = "25")
    private int age;
@Schema(description = "address of the customer", example = "123 Main St, Anytown, USA")
    @Valid
    private Address address;
}
