package e_Commerce_project.productservice.service.Impl;

import e_Commerce_project.productservice.dto.ProductDto;
import e_Commerce_project.productservice.dto.ProductPurchaseResponse;
import e_Commerce_project.productservice.dto.productPurchaseRequest;
import e_Commerce_project.productservice.entity.Product;
import e_Commerce_project.productservice.exceptions.ProductNotFoundException;
import e_Commerce_project.productservice.mapper.ProductMapper;
import e_Commerce_project.productservice.repository.ProductRepository;
import e_Commerce_project.productservice.service.ProductService;
import lombok.AllArgsConstructor;
import org.springframework.stereotype.Service;

import java.util.ArrayList;
import java.util.Comparator;
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

    @Override
    public List<ProductPurchaseResponse> purchaseProduct(List<productPurchaseRequest> productPurchaseRequests) {
        var productIds = productPurchaseRequests.stream().map(productPurchaseRequest -> productPurchaseRequest.productId()).collect(Collectors.toList());
        var storedProducts = productRepo.findAllByIdInOrderById(productIds);
        if (storedProducts.size() != productIds.size()) {
            throw new ProductNotFoundException("Product is not found by these Id can check your Id");
        }
        var storedRequests = productPurchaseRequests.stream().sorted(Comparator.comparing(productPurchaseRequest -> productPurchaseRequest.productId())).toList();

        var purchasedProducts = new ArrayList<ProductPurchaseResponse>();
        for (int i = 0; i < storedProducts.size(); i++) {
            var storedProduct = storedProducts.get(i);
            var storedRequest = storedRequests.get(i);
            if (storedProduct.getAvailabilityQuantity() < storedRequest.quantity()) {
                throw new RuntimeException("Insufficient stock");
            }
            var newAvailableQuantity = storedProduct.getAvailabilityQuantity() - storedRequest.quantity();
            storedProduct.setAvailabilityQuantity(newAvailableQuantity);
            productRepo.save(storedProduct);
            purchasedProducts.add(ProductMapper.toproductPurchaseResponse(storedProduct, storedRequest.quantity()));


        }
    return purchasedProducts;

    }
}
