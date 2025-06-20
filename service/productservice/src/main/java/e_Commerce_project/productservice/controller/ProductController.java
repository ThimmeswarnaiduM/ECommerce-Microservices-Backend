package e_Commerce_project.productservice.controller;

import e_Commerce_project.productservice.constants.ProductConstants;
import e_Commerce_project.productservice.dto.ProductDto;
import e_Commerce_project.productservice.dto.SuccessDto;
import e_Commerce_project.productservice.service.ProductService;
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

public class ProductController {
    private final ProductService productService;
  @PostMapping("/create")
    public ResponseEntity<SuccessDto> createProduct(@RequestBody @Valid ProductDto productDto){
       productService.createProduct(productDto);
       return  ResponseEntity.status(HttpStatus.CREATED).body(new SuccessDto(ProductConstants.Product_CREATED_SUCCESSFULLY, HttpStatus.CREATED.value(), LocalDateTime.now()));
  }
  //localhost:8080/api/v1/products/create
  @GetMapping("/{Id}")
    public ResponseEntity<ProductDto> getProduct(@PathVariable("Id")  Long Id){
      productService.getProduct(Id);
      return ResponseEntity.status(HttpStatus.OK).body(new ProductDto());
  }
  @GetMapping("/getId")
  public ResponseEntity<List<ProductDto>> getId(@RequestParam(value ="id") Long Id){
    List<ProductDto> id = productService.getId(Id);
    return ResponseEntity.status(HttpStatus.OK).body(id);
  }
  @PatchMapping("/update/{Id}")
    public ResponseEntity<String> updateProduct(@PathVariable("Id")Long Id,@RequestBody ProductDto productDto){
      String s = productService.updateProduct(Id, productDto);
      return ResponseEntity.status(HttpStatus.OK).body(s);

  }
  @DeleteMapping("/delete/{Id}")
    public ResponseEntity<String> deleteProduct(@PathVariable("Id")Long Id){
      String s = productService.deleteProduct(Id);
      return ResponseEntity.status(HttpStatus.OK).body(s);

  }
  @GetMapping("/all")
    public ResponseEntity<List<ProductDto>> getAllProducts(){
      List<ProductDto> allProducts = productService.getAllProducts();
      return ResponseEntity.status(HttpStatus.OK).body(allProducts);
  }
  @PutMapping("/update/{Id}")
    public ResponseEntity<ProductDto> updateProducts( @PathVariable("Id")Long Id,   @RequestBody ProductDto productDto){
    ProductDto productDto1 = productService.updateProducts(Id, productDto);
    return ResponseEntity.status(HttpStatus.OK).body(productDto1);
       }

     //url=localhost:8080/api/v1/products/getProduct/2
    @GetMapping("/getProduct/{id}")
    public ResponseEntity<ProductDto>getProductById(@PathVariable("id") Long id, ProductDto dto){
      ProductDto productById = productService.getProductById(id, dto);
      return ResponseEntity.status(HttpStatus.OK).body(productById);
    }
     //url=localhost:8080/api/v1/products/updateProduct/2
    @PutMapping("/updateProduct/{id}")
    public ResponseEntity<ProductDto>UpdateProductById(@PathVariable("id") Long id, @RequestBody ProductDto dto){
      ProductDto productDto = productService.UpdateProductById(id, dto);
      return ResponseEntity.status(HttpStatus.OK).body(productDto);
    }
  //url=localhost:8080/api/v1/products/GetAllProducts
    @GetMapping("/GetAllProducts")
    public ResponseEntity<List<ProductDto>>GetAllProducts(){
      List<ProductDto> productDtos = productService.GetAllProducts();
      return ResponseEntity.status(HttpStatus.OK).body(productDtos);
    }
    //url=localhost:8080/api/v1/products/deleteProduct
    @DeleteMapping("/deleteProduct")
       public ResponseEntity<String>DeleteProductById(@RequestParam("id") Long id ){
      String s = productService.DeleteProductById(id);
      return ResponseEntity.status(HttpStatus.OK).body(s);
    }
















}
