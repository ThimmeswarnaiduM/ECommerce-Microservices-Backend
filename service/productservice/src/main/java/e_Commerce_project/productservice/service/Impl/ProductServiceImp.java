package e_Commerce_project.productservice.service.Impl;

import e_Commerce_project.productservice.dto.ProductDto;
import e_Commerce_project.productservice.entity.Product;
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
    public ProductDto getProduct(Long Id) {
        Product product = productRepo.findById(Id).orElseThrow(
                () -> new RuntimeException(" Product is not found by these" + Id)
        );
        ProductDto productDto = ProductMapper.MapToProductDto(product);
        return productDto;
    }

    @Override
    public String updateProduct(Long id, ProductDto productDto) {
        Product product = productRepo.findById(id).orElseThrow(
                () -> new RuntimeException("Product is not found by these Id" + id)
        );
        if(productDto.getName() != null){
            product.setName(productDto.getName());
        }
        if(productDto.getDescription() != null){
            product.setDescription(productDto.getDescription());
        }
        if(productDto.getAvailabilityQuantity() != null){
            product.setAvailabilityQuantity(productDto.getAvailabilityQuantity());
        }
        if(productDto.getPrice() != null){
            product.setPrice(productDto.getPrice());
        }
        if(productDto.getCategory() != null){
            product.setCategory(productDto.getCategory());
        }
        productRepo.save(product);
        return " Product updated successfully based on id " + id;
    }

    @Override
    public String deleteProduct(Long id) {
        productRepo.deleteById(id);
        return " Product deleted successfully based on id " + id;
    }

    @Override
    public List<ProductDto> getAllProducts() {
        List<Product> all = productRepo.findAll();
        List<ProductDto> collect = all.stream().map(c -> ProductMapper.MapToProductDto(c)).collect(Collectors.toList());
       return collect;
    }
  // Update product Details based Id
    @Override
    public ProductDto updateProducts(Long id, ProductDto productDto) {
      Product product=productRepo.findById(id).orElseThrow(
              ()-> new RuntimeException("Product is not found by id " +id)
      );
      product.setId(productDto.getId());
      product.setName(productDto.getName());
      product.setDescription(productDto.getDescription());
      product.setPrice(productDto.getPrice());
      product.setAvailabilityQuantity(productDto.getAvailabilityQuantity());
      product.setCategory(productDto.getCategory());
        Product save = productRepo.save(product);
        ProductDto productDto1 = ProductMapper.MapToProductDto(save);

        return productDto1; //return "product does not exist with this id : %s"
    }
  // Get product details based on Id
    @Override
    public List<ProductDto> getId(Long id) {
        Optional<Product> byId = productRepo.findById(id);
        List<ProductDto> collect = byId.stream().map(c -> ProductMapper.MapToProductDto(c)).collect(Collectors.toList());

        return collect;
    }

    @Override
    public ProductDto getProductById(Long id, ProductDto dto) {
        Product product = productRepo.findById(id).orElseThrow(() -> new RuntimeException("Product not found by these Id"));
        ProductDto productDto = ProductMapper.MapToProductDto(product);
        return productDto;
    }

    @Override
    public ProductDto UpdateProductById(Long id, ProductDto dto) {
        Product product = productRepo.findById(id).orElseThrow(
                () -> new RuntimeException("Product is not found by these Id can check your Id" + id)
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
