package e_Commerce_project.customer.service.imp;

import e_Commerce_project.customer.dto.CustomerDto;
import e_Commerce_project.customer.dto.CustomerUpdateDto;
import e_Commerce_project.customer.entity.Customer;
import e_Commerce_project.customer.mapper.CustomerMapper;
import e_Commerce_project.customer.repository.CustomerRepository;
import e_Commerce_project.customer.service.CustomerService;
import lombok.AllArgsConstructor;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Optional;

@Service
@AllArgsConstructor
public class CustomerServiceImp implements CustomerService {
    private final CustomerRepository customerRepo;

    @Override
    public void createCustomer(CustomerDto customerDto) throws IllegalAccessException {
        if (customerDto == null || customerDto.getPhoneNumber() == null || customerDto.getEmail() == null) {
            throw new IllegalAccessException("Customer DTO or phone/email cannot be null");
        }

        List<Customer> customersWithPhone = customerRepo.findByPhoneNumber(customerDto.getPhoneNumber());
        if (!customersWithPhone.isEmpty()) {
            throw new IllegalAccessException("Customer already exists with this phone number");
        }

        List<Customer> customersWithEmail = customerRepo.findByEmail(customerDto.getEmail());
        if (!customersWithEmail.isEmpty()) {
            throw new IllegalAccessException("Customer already exists with this email");
        }

        Customer customer = CustomerMapper.mapToCustomer(customerDto);
        customerRepo.save(customer);
    }

    @Override
    public List<CustomerDto> getCustomer(String id) {
        Optional<Customer> byId = customerRepo.findById(id);
        Customer customer = byId.get();
        CustomerDto customerDto = CustomerMapper.mapToCustomerDto(customer);
        return List.of(customerDto);
    }

    @Override
    public List<CustomerDto> updateCustomer(String id, CustomerUpdateDto customerDto) {
        // 1. Find the existing customer
        Optional<Customer> byId = customerRepo.findById(id);

        if (byId.isEmpty()) {
            return List.of();
        }

        Customer existingCustomer = byId.get();


        if (customerDto.getFirstName() != null) {
            existingCustomer.setFirstName(customerDto.getFirstName());
        }
        if (customerDto.getLastName() != null) {
            existingCustomer.setLastName(customerDto.getLastName());
        }
        if (customerDto.getEmail() != null) {
            existingCustomer.setEmail(customerDto.getEmail());
        }
        if (customerDto.getAddress() != null) {
            existingCustomer.setAddress(customerDto.getAddress());
        }
        // Add more fields as needed

        // 3. Save the updated customer
        Customer savedCustomer = customerRepo.save(existingCustomer);

        // 4. Map back to DTO and return
        CustomerDto customerDto1 = CustomerMapper.mapToCustomerDto(savedCustomer);
        return List.of(customerDto1);
    }

    @Override
    public List<CustomerDto> updateCustomerAllDetails(String id, CustomerDto customerDto) {
        Optional<Customer> byId = customerRepo.findById(id);
        byId.ifPresent(customer -> {
                    customer.setFirstName(customerDto.getFirstName());
                    customer.setLastName(customerDto.getLastName());
                    customer.setEmail(customerDto.getEmail());
                    customer.setPassword(customerDto.getPassword());
                    customer.setPhoneNumber(customerDto.getPhoneNumber());
                    customer.setAge(customerDto.getAge());
                    customer.setAddress(customerDto.getAddress());
                }
        );
        return List.of(CustomerMapper.mapToCustomerDto(byId.get()));

    }

    @Override
    public String deleteCustomer(String id) {
        customerRepo.findById(id).ifPresent(customerRepo::delete);
        return "deleted successfully your profile based on id: "+id+"";
    }

    @Override
    public String deleteByEmail(String email) {
        List<Customer> byEmail = customerRepo.findByEmail(email);
        byEmail.forEach(customerRepo::delete);

        return " deleted successfully your profile based on email: "+email+"";
    }

    @Override
    public String deleteByphoneNumber(String phoneNumber) {
        List<Customer> byPhoneNumber = customerRepo.findByPhoneNumber(phoneNumber);
        byPhoneNumber.forEach(customerRepo::delete);
        return " deleted successfully your profile based on phone number: "+phoneNumber+"";
    }
}
