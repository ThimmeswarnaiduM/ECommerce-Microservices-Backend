package e_Commerce_project.customer.exception;

public class ResourceNotFoundException extends RuntimeException {
    public ResourceNotFoundException(String Resource,String field, String FieldValue) {
        super(String.format("%s not found with %s : '%s'",Resource,field,FieldValue));
    }
}
