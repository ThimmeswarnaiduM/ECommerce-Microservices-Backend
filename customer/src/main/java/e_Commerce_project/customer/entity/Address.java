package e_Commerce_project.customer.entity;

import jakarta.validation.constraints.NotBlank;
import lombok.*;

@NoArgsConstructor
@AllArgsConstructor
@Getter
@Setter
@Builder
@ToString
public class Address {
    @NotBlank(message = "Street cannot be empty")
    private String street;

    @NotBlank(message = "House number cannot be empty")
    private String houseNumber;

    @NotBlank(message = "Zip code cannot be empty")
    private String zipCode;

    @NotBlank(message = "City cannot be empty")
    private String city;

    @NotBlank(message = "Country cannot be empty")
    private String country;

    @NotBlank(message = "State cannot be empty")
    private String state;
}
