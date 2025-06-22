package e_Commerce_project.productservice.service;

import e_Commerce_project.productservice.dto.ProductDto;
import jakarta.validation.Valid;

import java.util.List;

public interface ProductService {
    public void createProduct(@Valid ProductDto productDto);
    ProductDto getProductById(Long id, ProductDto dto);
    ProductDto UpdateProductById(Long id, ProductDto dto);
    List<ProductDto> GetAllProducts();
    String DeleteProductById(Long id);
}
