package e_Commerce_project.customer.repository;

import e_Commerce_project.customer.entity.Customer;

import jakarta.validation.constraints.Email;
import jakarta.validation.constraints.NotEmpty;
import jakarta.validation.constraints.Pattern;
import org.springframework.data.mongodb.repository.MongoRepository;
import org.springframework.stereotype.Repository;

import java.util.List;
import java.util.Optional;

@Repository
public interface CustomerRepository extends MongoRepository<Customer, String> {

    List<Customer> findByPhoneNumber(@NotEmpty(message = "phone number cannot be empty") @Pattern(regexp = "^\\+?[0-9]{10,15}$", message = "Phone number should be a valid phone number") String phoneNumber);

    List<Customer> findByEmail(@NotEmpty @Email(message = "email should be valid") @Pattern(regexp = "^[a-zA-Z0-9._%+-]+@[a-zA-Z0-9.-]+\\.[a-zA-Z]{2,}$", message = "email should be valid") String email);
}
