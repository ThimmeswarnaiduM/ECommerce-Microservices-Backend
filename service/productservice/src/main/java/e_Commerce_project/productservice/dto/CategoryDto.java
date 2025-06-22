package e_Commerce_project.productservice.dto;

import com.fasterxml.jackson.annotation.JsonManagedReference;
import e_Commerce_project.productservice.entity.Product;
import io.swagger.v3.oas.annotations.media.Schema;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;
import jakarta.persistence.OneToMany;
import jakarta.validation.constraints.NotBlank;
import lombok.*;

import java.util.List;
@Data
@Getter
@Setter
@AllArgsConstructor
@NoArgsConstructor
@ToString
@Builder
@Schema(name = "Category", description = "Category")
public class CategoryDto {
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Id
    private Long id;
    @Schema(name = "name", description = "name")
    @NotBlank(message = "name is required")
    private String name;
    @Schema(name = "description", description = "description")
    @NotBlank(message = "Description is required")
    private String description;
    @OneToMany(mappedBy = "category")
    @JsonManagedReference
    private List<Product> products;
}
