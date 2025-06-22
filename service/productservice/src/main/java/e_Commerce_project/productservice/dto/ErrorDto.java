package e_Commerce_project.productservice.dto;

import io.swagger.v3.oas.annotations.media.Schema;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;
import org.springframework.http.HttpStatus;

import java.time.LocalDateTime;
@AllArgsConstructor
@NoArgsConstructor
@Data
@Schema(name = "ErrorDto")
public class ErrorDto {
    @Schema(name = "api",description = "api name",example = "product-service")
    private String api;
    @Schema(name = "errorCode",description = "error code",example = "404")
    private HttpStatus errorCode;
    @Schema(name = "errorMessage",description = "error message",example = "Product not found")
    private String errorMessage;
    @Schema(name = "error",description = "error timestamp",example = "2023-03-01T00:00:00")
    private LocalDateTime error;

    public ErrorDto(String message, HttpStatus httpStatus, LocalDateTime timestamp) {
        this.errorMessage = message;
        this.errorCode = httpStatus;
        this.error = timestamp;
        this.api = api;
    }

}
