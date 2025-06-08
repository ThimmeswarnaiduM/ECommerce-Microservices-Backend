package e_Commerce_project.customer.mapper;

import e_Commerce_project.customer.dto.CustomerDto;
import e_Commerce_project.customer.entity.Customer; // ✅ corrected import
import lombok.AllArgsConstructor;
import lombok.NoArgsConstructor;

@AllArgsConstructor

public class CustomerMapper {

    public static Customer mapToCustomer(CustomerDto customerDto) {
        return new Customer(
                customerDto.getId(),
                customerDto.getFirstName(),
                customerDto.getLastName(),
                customerDto.getEmail(),
                customerDto.getPassword(),
                customerDto.getPhoneNumber(),
                customerDto.getAge(),
                customerDto.getAddress()
        );
    }

    public static CustomerDto mapToCustomerDto(Customer customer) {
        return new CustomerDto(
                customer.getId(),
                customer.getFirstName(),
                customer.getLastName(),
                customer.getEmail(),
                customer.getPassword(),
                customer.getPhoneNumber(),
                customer.getAge(),
                customer.getAddress()
        );
    }
}
