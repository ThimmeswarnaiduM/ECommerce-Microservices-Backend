package e_Commerce_project.customer.service;

import e_Commerce_project.customer.dto.CustomerDto;
import e_Commerce_project.customer.dto.CustomerUpdateDto;
import jakarta.validation.Valid;

import java.util.List;

public interface CustomerService {
    void createCustomer(CustomerDto customerDto) throws IllegalAccessException;

    List<CustomerDto> getCustomer(String id);

    List<CustomerDto> updateCustomer(String id, CustomerUpdateDto customerDto);

    List<CustomerDto> updateCustomerAllDetails(String id,  CustomerDto customerDto);

    String deleteCustomer(String id);

    String deleteByEmail(String email);

    String deleteByphoneNumber(String phoneNumber);
}
