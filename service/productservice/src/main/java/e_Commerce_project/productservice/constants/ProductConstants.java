package e_Commerce_project.productservice.constants;

public class ProductConstants {
    public static final int STATUS_OK = 200;
    public static final String Product = "product data retrieved successfully.";
    public static final String Product_UPDATED_SUCCESSFULLY = "product updated successfully.";

    // 201 - Created
    public static final int STATUS_CREATED = 201;
    public static final String Product_CREATED_SUCCESSFULLY = "product created successfully.";

    // 400 - Bad Request
    public static final int STATUS_BAD_REQUEST = 400;
    public static final String INVALID_Product_DATA = "Invalid product data provided.";
    public static final String Product_ALREADY_EXISTS = "product with the given email already exists.";

    // 404 - Not Found
    public static final int STATUS_NOT_FOUND = 404;
    public static final String Product_NOT_FOUND = "product not found with the given ID.";

    // 500 - Internal Server Error
    public static final int STATUS_INTERNAL_SERVER_ERROR = 500;
    public static final String INTERNAL_SERVER_ERROR = "An unexpected error occurred. Please try again later.";
    public static final String DATABASE_ERROR = "Failed to process productdata due to a database error.";
   public static final String Product_DELETED_SUCCESSFULLY="product deleted successfully";
    private ProductConstants() {
        // Prevent instantiation
    }
}
