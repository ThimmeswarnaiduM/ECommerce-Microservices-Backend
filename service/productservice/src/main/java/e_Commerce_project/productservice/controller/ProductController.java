package e_Commerce_project.productservice.controller;

import e_Commerce_project.productservice.constants.ProductConstants;
import e_Commerce_project.productservice.dto.ProductDto;
import e_Commerce_project.productservice.dto.SuccessDto;
import e_Commerce_project.productservice.service.ProductService;
import io.swagger.v3.oas.annotations.Operation;
import io.swagger.v3.oas.annotations.responses.ApiResponse;
import io.swagger.v3.oas.annotations.responses.ApiResponses;
import io.swagger.v3.oas.annotations.tags.Tag;
import jakarta.validation.Valid;
import lombok.AllArgsConstructor;
import lombok.NoArgsConstructor;
import org.springframework.data.repository.support.Repositories;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.time.LocalDateTime;
import java.util.List;

@RestController
@RequestMapping("/api/v1/products")
@AllArgsConstructor
@Tag(
        name = "Product controller",
        description = " This is a product controller"

)
public class ProductController {
    private final ProductService productService;
    @Operation(
            summary = "Create a product",
            description = " Create Products "
    )
    @ApiResponse(
            responseCode = "201",
            description = "Product created successfully"


    )
  @PostMapping("/create")
  //localhost:8080/api/v1/products/create
    public ResponseEntity<SuccessDto> createProduct(@RequestBody @Valid ProductDto productDto){
       productService.createProduct(productDto);
       return  ResponseEntity.status(HttpStatus.CREATED).body(new SuccessDto(ProductConstants.Product_CREATED_SUCCESSFULLY, HttpStatus.CREATED.value(), LocalDateTime.now()));
  }


  @Operation(
          summary = "Get product by Id",
          description = "This will fetch a single product based on its id"
  )
  @ApiResponses(
          value = {
                  @ApiResponse(
                          responseCode = "200",
                          description = "Product found successfully"
                  ),
                  @ApiResponse(
                          responseCode = "404",
                          description = "Product not found"
                  )
          }
  )

     //url=localhost:8080/api/v1/products/getProduct/2
    @GetMapping("/getProduct/{id}")
    public ResponseEntity<ProductDto>getProductById(@PathVariable("id") Long id, ProductDto dto){
      ProductDto productById = productService.getProductById(id, dto);
      return ResponseEntity.status(HttpStatus.OK).body(productById);
    }
    @Operation(
            summary = "Update product by Id",
            description = "This will update a single product based on its id"
    )
    @ApiResponses(
            value = {
                    @ApiResponse(
                            responseCode = "200",
                            description = "Product updated successfully"
                    ),
                    @ApiResponse(
                            responseCode = "404",
                            description = "Product not found"
                    )
            }
    )
     //url=localhost:8080/api/v1/products/updateProduct/2
    @PutMapping("/updateProduct/{id}")
    public ResponseEntity<ProductDto>UpdateProductById(@PathVariable("id") Long id,@Valid @RequestBody ProductDto dto){
      ProductDto productDto = productService.UpdateProductById(id, dto);
      return ResponseEntity.status(HttpStatus.OK).body(productDto);
    }
  //url=localhost:8080/api/v1/products/GetAllProducts
    @Operation(
            summary = "Get all products",
            description = "This will fetch all products"
    )
    @ApiResponse(
            responseCode = "200",
            description = "Products found successfully"
    )
    @GetMapping("/GetAllProducts")
    public ResponseEntity<List<ProductDto>>GetAllProducts(){
      List<ProductDto> productDtos = productService.GetAllProducts();
      return ResponseEntity.status(HttpStatus.OK).body(productDtos);
    }
    //url=localhost:8080/api/v1/products/deleteProduct
    @Operation(
            summary = "Delete product by Id",
            description = "This will delete a single product based on its id"
    )
    @ApiResponses(
            value = {
                    @ApiResponse(
                            responseCode = "200",
                            description = "Product deleted successfully"
                    ),
                    @ApiResponse(
                            responseCode = "404",
                            description = "Product not found"
                    )
            }
    )
    @DeleteMapping("/deleteProduct")
       public ResponseEntity<String>DeleteProductById(@RequestParam("id") Long id ){
      String s = productService.DeleteProductById(id);
      return ResponseEntity.status(HttpStatus.OK).body(s);
    }
















}
