package e_Commerce_project.productservice.exceptions;

import org.springframework.dao.DataAccessException;

public class DataIntegrityViolationException extends DataAccessException {


    public DataIntegrityViolationException(String msg, Throwable cause) {
        super(msg, cause);
    }
}
