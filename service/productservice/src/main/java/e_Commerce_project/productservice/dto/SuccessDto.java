package e_Commerce_project.productservice.dto;

import io.swagger.v3.oas.annotations.media.Schema;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

import java.time.LocalDateTime;
@Data
@AllArgsConstructor
@NoArgsConstructor
@Schema(name = "SuccessDto", description = "SuccessDto")
public class SuccessDto {
    @Schema(description = "Success message", example = "Product created successfully")
    private String message;
    @Schema(description = "Success status code", example = "201")
    private int status;
    @Schema(description = "Timestamp", example = "2023-08-01T12:34:56")
    private LocalDateTime timestamp;
}
