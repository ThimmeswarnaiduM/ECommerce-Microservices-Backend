package e_Commerce_project.productservice.dto;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;
import org.springframework.http.HttpStatus;

import java.time.LocalDateTime;
@AllArgsConstructor
@NoArgsConstructor
@Data
public class ErrorDto {
    private String api;
    private HttpStatus errorCode;
    private String errorMessage;
    private LocalDateTime error;
}
