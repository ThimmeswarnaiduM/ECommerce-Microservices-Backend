package e_Commerce_project.productservice.mapper;

import e_Commerce_project.productservice.dto.ProductDto;
import e_Commerce_project.productservice.entity.Category;
import e_Commerce_project.productservice.entity.Product;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

@AllArgsConstructor

@Data
public class ProductMapper {
    public static Product MapToProduct(ProductDto productDto){
        return Product.builder()
                .id(productDto.getId())
                .name(productDto.getName())
                .description(productDto.getDescription())
                .availabilityQuantity(productDto.getAvailabilityQuantity())
                .price(productDto.getPrice())
                .category(productDto.getCategory())
                .build();
    }
    public static ProductDto MapToProductDto(Product product){
        return ProductDto.builder()
                .id(product.getId())
                .name(product.getName())
                .description(product.getDescription())
                .availabilityQuantity(product.getAvailabilityQuantity())
                .price(product.getPrice())
                .category(product.getCategory())
                .build();
    }
}
