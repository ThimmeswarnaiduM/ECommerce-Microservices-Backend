package e_Commerce_project.productservice.dto;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

import java.time.LocalDateTime;
@Data
@AllArgsConstructor
@NoArgsConstructor
public class SuccessDto {
    private String message;
    private int status;
    private LocalDateTime timestamp;
}
