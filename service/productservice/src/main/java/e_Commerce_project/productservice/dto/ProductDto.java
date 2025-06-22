package e_Commerce_project.productservice.dto;

import e_Commerce_project.productservice.entity.Category;
import io.swagger.v3.oas.annotations.media.Schema;
import jakarta.validation.constraints.NotBlank;
import jakarta.validation.constraints.NotEmpty;
import jakarta.validation.constraints.NotNull;
import lombok.*;
import org.apache.logging.log4j.message.Message;

import java.math.BigDecimal;

@Getter
@Setter
@AllArgsConstructor
@NoArgsConstructor
@ToString
@Builder
@Schema
public class ProductDto {
    private Long id;

    @NotBlank(message = "Name cannot be empty")
    @Schema(description = "Product name", example = "Laptop", name = "name")
    private String name;

    @NotBlank(message = "Description is required")
    @Schema(description = "Product description", example = "High-performance laptop", name = "description")
    private String description;

    @NotBlank(message = "Availability quantity is required")
    @Schema(description = "Available stock quantity", example = "50", name = "availabilityQuantity")
    private String availabilityQuantity;

    @NotNull(message = "Price is required")
    @Schema(description = "Product price", example = "139999.99", name = "price")
    private BigDecimal price;

    @NotNull(message = "Category is required")
    @Schema(description = "Product category")
    private Category category;
}
