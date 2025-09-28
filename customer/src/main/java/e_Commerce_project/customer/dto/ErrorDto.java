package e_Commerce_project.customer.dto;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;
import org.springframework.http.HttpStatus;

import java.time.LocalDateTime;
@Data
@AllArgsConstructor
@NoArgsConstructor
public class ErrorDto {
    private String apiPath;
    private HttpStatus errorCode;
    private String errorMessage;
    private LocalDateTime error;

    public ErrorDto(String errorMessage, HttpStatus errorCode, LocalDateTime error) {
        this.errorMessage = errorMessage;
        this.errorCode = errorCode;
        this.error = error;
    }

}
