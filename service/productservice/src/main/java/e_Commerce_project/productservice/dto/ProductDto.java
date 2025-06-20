package e_Commerce_project.productservice.dto;

import e_Commerce_project.productservice.entity.Category;
import lombok.*;

import java.math.BigDecimal;

@Getter
@Setter
@AllArgsConstructor
@NoArgsConstructor
@ToString
@Builder
public class ProductDto {
    private Long id;
    private String name;
    private String description;
    private String availabilityQuantity;
    private BigDecimal price;
    private Category category;
}
