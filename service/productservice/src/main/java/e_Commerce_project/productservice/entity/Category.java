package e_Commerce_project.productservice.entity;

import jakarta.persistence.*;
import lombok.*;

import java.util.List;

@Entity(name = "category")
@AllArgsConstructor
@NoArgsConstructor
@Builder
@Getter
@Setter
@ToString
public class Category {
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Id
    private Long id;
    private String name;
    private String description;
    @OneToMany(mappedBy = "category")
    private List<Product> products;
}
