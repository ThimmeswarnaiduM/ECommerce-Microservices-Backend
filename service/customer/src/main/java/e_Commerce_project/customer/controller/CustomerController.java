package e_Commerce_project.customer.controller;

import e_Commerce_project.customer.constants.CustomerConstants;
import e_Commerce_project.customer.dto.CustomerDto;
import e_Commerce_project.customer.dto.CustomerUpdateDto;
import e_Commerce_project.customer.dto.SuccessDto;
import e_Commerce_project.customer.service.CustomerService;
import io.swagger.v3.oas.annotations.Operation;
import io.swagger.v3.oas.annotations.responses.ApiResponse;
import io.swagger.v3.oas.annotations.responses.ApiResponses;
import io.swagger.v3.oas.annotations.tags.Tag;
import jakarta.validation.Valid;
import lombok.AllArgsConstructor;
import lombok.extern.slf4j.Slf4j;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.time.LocalDateTime;
import java.util.List;


@RestController
@AllArgsConstructor
@Slf4j
@RequestMapping("/api/v1/customers")
@Tag(
        name = "Customer Controller",
        description = "This is for all CRUD operations on Customers"


)
public class CustomerController {
private CustomerService customerService;
//http://localhost:8082/api/v1/customers/customer
   @Operation(
           summary = "Create new customer",
           description = "This will create a new customer in our application",
           tags = {"Customer"}


   )
   @ApiResponse(
           responseCode = "201",
           description = "Customer created successfully",
           content = @io.swagger.v3.oas.annotations.media.Content(
                   mediaType = "application/json",
                   schema = @io.swagger.v3.oas.annotations.media.Schema(
                           implementation = SuccessDto.class
                   )
           )
   )
    @PostMapping("/customer")
    public ResponseEntity<  SuccessDto> createCustomer(@RequestBody @Valid CustomerDto customerDto) throws IllegalAccessException {


        customerService.createCustomer(customerDto);

     return ResponseEntity.status(HttpStatus.CREATED).body(new SuccessDto(CustomerConstants.CUSTOMER_CREATED_SUCCESSFULLY, HttpStatus.CREATED.value(), LocalDateTime.now()));
    }
    @Operation(
            summary = "Get customer by Id",
            description = "This will fetch a single customer based on its id",
            tags = {"Customer"}
    )
    @ApiResponses(
            value = {
                    @ApiResponse(
                            responseCode = "200",
                            description = "Customer found successfully",
                            content = @io.swagger.v3.oas.annotations.media.Content(
                                    mediaType = "application/json",
                                    schema = @io.swagger.v3.oas.annotations.media.Schema(
                                            implementation = CustomerDto.class
                                    )
                            )
                    ),
                    @ApiResponse(
                            responseCode = "404",
                            description = "Customer not found",
                            content = @io.swagger.v3.oas.annotations.media.Content(
                                    mediaType = "application/json",
                                    schema = @io.swagger.v3.oas.annotations.media.Schema(
                                            implementation = SuccessDto.class
                                    )
                            )
                    )
            }
    )
    @GetMapping("customer/{id}")
    public ResponseEntity<List<CustomerDto>> getCustomer(@PathVariable("id") String id){
        List<CustomerDto> customer = customerService.getCustomer(id);
        return ResponseEntity.status(HttpStatus.OK).body(customer);



    }
    @Operation(
            summary = "Update customer details",
            description = "This will update existing customer's details",
            tags = {"Customer"}
    )
    @ApiResponses(
            value = {
                    @ApiResponse(
                            responseCode = "200",
                            description = "Customer updated successfully",
                            content = @io.swagger.v3.oas.annotations.media.Content(
                                    mediaType = "application/json",
                                    schema = @io.swagger.v3.oas.annotations.media.Schema(
                                            implementation = CustomerDto.class
                                    )
                            )
                    ),
                    @ApiResponse(
                            responseCode = "404",
                            description = "Customer not found",
                            content = @io.swagger.v3.oas.annotations.media.Content(
                                    mediaType = "application/json",
                                    schema = @io.swagger.v3.oas.annotations.media.Schema(
                                            implementation = SuccessDto.class
                                    )
                            )
                    )
            }
    )
    @PatchMapping("customer/{id}")
    public ResponseEntity<List<CustomerDto>> updateCustomer(@PathVariable("id") String id,@RequestBody @Valid CustomerUpdateDto customerDto){
        List<CustomerDto> Dtos = customerService.updateCustomer(id, customerDto);
        return ResponseEntity.status(HttpStatus.OK).body(Dtos);
    }
    @Operation(
            summary = "Update customer details",
            description = "This will update existing customer's details",
            tags = {"Customer"}
    )
    @ApiResponses(
            value = {
                    @ApiResponse(
                            responseCode = "200",
                            description = "Customer updated successfully",
                            content = @io.swagger.v3.oas.annotations.media.Content(
                                    mediaType = "application/json",
                                    schema = @io.swagger.v3.oas.annotations.media.Schema(
                                            implementation = CustomerDto.class
                                    )
                            )
                    ),
                    @ApiResponse(
                            responseCode = "404",
                            description = "Customer not found",
                            content = @io.swagger.v3.oas.annotations.media.Content(
                                    mediaType = "application/json",
                                    schema = @io.swagger.v3.oas.annotations.media.Schema(
                                            implementation = SuccessDto.class
                                    )
                            )
                    )
            }
    )
   @PutMapping("customer/{id}")
    public ResponseEntity<List<CustomerDto>> updateCustomerAllDetails(@PathVariable("id") String id,@RequestBody @Valid CustomerDto customerDto){
        List<CustomerDto> Dtos = customerService.updateCustomerAllDetails(id, customerDto);
        return ResponseEntity.status(HttpStatus.OK).body(Dtos);
    }
    @Operation(
            summary = "Delete customer",
            description = "This will delete a single customer based on its id",
            tags = {"Customer"}
    )
   @ApiResponses(
            value = {
                    @ApiResponse(
                            responseCode = "200",
                            description = "Customer deleted successfully",
                            content = @io.swagger.v3.oas.annotations.media.Content(
                                    mediaType = "application/json",
                                    schema = @io.swagger.v3.oas.annotations.media.Schema(
                                            implementation = SuccessDto.class
                                    )
                            )
                    ),
                    @ApiResponse(
                            responseCode = "404",
                            description = "Customer not found",
                            content = @io.swagger.v3.oas.annotations.media.Content(
                                    mediaType = "application/json",
                                    schema = @io.swagger.v3.oas.annotations.media.Schema(
                                            implementation = SuccessDto.class
                                    )
                            )
                    )
            }
    )
    @DeleteMapping("customer/{id}")
    public String deleteCustomer(@PathVariable("id") String id){
        return customerService.deleteCustomer(id);
    }
    @Operation(
            summary = "Delete customer",
            description = "This will delete a single customer based on its id",
            tags = {"Customer"}
    )
    @ApiResponses(
            value = {
                    @ApiResponse(
                            responseCode = "200",
                            description = "Customer deleted successfully",
                            content = @io.swagger.v3.oas.annotations.media.Content(
                                    mediaType = "application/json",
                                    schema = @io.swagger.v3.oas.annotations.media.Schema(
                                            implementation = SuccessDto.class
                                    )
                            )
                    ),
                    @ApiResponse(
                            responseCode = "404",
                            description = "Customer not found",
                            content = @io.swagger.v3.oas.annotations.media.Content(
                                    mediaType = "application/json",
                                    schema = @io.swagger.v3.oas.annotations.media.Schema(
                                            implementation = SuccessDto.class
                                    )
                            )
                    )
            }
    )
    @DeleteMapping("customer")
    public String deleteByemail(@RequestParam("email") String email){
            return customerService.deleteByEmail(email);}
@Operation(
        summary = "Delete customer",
        description = "This will delete a single customer based on its id",
        tags = {"Customer"}
)
@ApiResponses(
        value = {
                @ApiResponse(
                        responseCode = "200",
                        description = "Customer deleted successfully",
                        content = @io.swagger.v3.oas.annotations.media.Content(
                                mediaType = "application/json",
                                schema = @io.swagger.v3.oas.annotations.media.Schema(
                                        implementation = SuccessDto.class
                                )
                        )
                ),
                @ApiResponse(
                        responseCode = "404",
                        description = "Customer not found",
                        content = @io.swagger.v3.oas.annotations.media.Content(
                                mediaType = "application/json",
                                schema = @io.swagger.v3.oas.annotations.media.Schema(
                                        implementation = SuccessDto.class
                                )
                        )
                )
        }
)
   @DeleteMapping("customers")
    public String deleteByphoneNumber(@RequestParam("phoneNumber") String phoneNumber){
    return customerService.deleteByphoneNumber(phoneNumber);}

}
