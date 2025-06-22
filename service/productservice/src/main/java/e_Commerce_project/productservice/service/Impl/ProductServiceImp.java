package e_Commerce_project.productservice.service.Impl;

import e_Commerce_project.productservice.dto.ProductDto;
import e_Commerce_project.productservice.entity.Product;
import e_Commerce_project.productservice.exceptions.ProductNotFoundException;
import e_Commerce_project.productservice.mapper.ProductMapper;
import e_Commerce_project.productservice.repository.ProductRepository;
import e_Commerce_project.productservice.service.ProductService;
import lombok.AllArgsConstructor;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Optional;
import java.util.stream.Collectors;

@Service
@AllArgsConstructor
public class ProductServiceImp implements ProductService {
    private final ProductRepository productRepo;



    @Override
    public void createProduct(ProductDto productDto) {

        productRepo.save(ProductMapper.MapToProduct(productDto));
    }

    @Override
    public ProductDto getProductById(Long id, ProductDto dto) {
        Product product = productRepo.findById(id).orElseThrow(() -> new ProductNotFoundException("Product not found by these Id"));
        ProductDto productDto = ProductMapper.MapToProductDto(product);
        return productDto;
    }

    @Override
    public ProductDto UpdateProductById(Long id, ProductDto dto) {
        Product product = productRepo.findById(id).orElseThrow(
                () -> new ProductNotFoundException("Product is not found by these Id can check your Id" + id)
        );

        product.setName(dto.getName());
        product.setDescription(dto.getDescription());
        product.setPrice(dto.getPrice());
        product.setAvailabilityQuantity(dto.getAvailabilityQuantity());
        product.setCategory(dto.getCategory());
        Product save = productRepo.save(product);
        ProductDto productDto = ProductMapper.MapToProductDto(product);


        return productDto;
    }

    @Override
    public List<ProductDto> GetAllProducts() {
        List<Product> all = productRepo.findAll();
        List<ProductDto> collect = all.stream().map(c -> ProductMapper.MapToProductDto(c)).collect(Collectors.toList());
        return collect;
    }

    @Override
    public String DeleteProductById(Long id) {
        Product product = productRepo.findById(id).orElseThrow(
                () -> new RuntimeException("Product is found ny these id " + id)
        );
        return " Product is delete Successfully base on your " + id;
    }


}
