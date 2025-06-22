package e_Commerce_project.productservice.exceptions;

public class ProductNotFoundException extends RuntimeException{
       public ProductNotFoundException (String resource,String fieldName,String fieldValue){
           super(String.format("%s not found with %s: %s", resource, fieldName, fieldValue));
       }


    public ProductNotFoundException(String resource) {
        super(String.format("%s not found", resource));
    }
}
