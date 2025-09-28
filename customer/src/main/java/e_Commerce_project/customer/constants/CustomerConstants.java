package e_Commerce_project.customer.constants;





public class CustomerConstants {

    // 200 - OK
    public static final int STATUS_OK = 200;
    public static final String CUSTOMER_FETCHED_SUCCESSFULLY = "Customer data retrieved successfully.";
    public static final String CUSTOMER_UPDATED_SUCCESSFULLY = "Customer updated successfully.";

    // 201 - Created
    public static final int STATUS_CREATED = 201;
    public static final String CUSTOMER_CREATED_SUCCESSFULLY = "Customer created successfully.";

    // 400 - Bad Request
    public static final int STATUS_BAD_REQUEST = 400;
    public static final String INVALID_CUSTOMER_DATA = "Invalid customer data provided.";
    public static final String CUSTOMER_ALREADY_EXISTS = "Customer with the given email already exists.";

    // 404 - Not Found
    public static final int STATUS_NOT_FOUND = 404;
    public static final String CUSTOMER_NOT_FOUND = "Customer not found with the given ID.";

    // 500 - Internal Server Error
    public static final int STATUS_INTERNAL_SERVER_ERROR = 500;
    public static final String INTERNAL_SERVER_ERROR = "An unexpected error occurred. Please try again later.";
    public static final String DATABASE_ERROR = "Failed to process customer data due to a database error.";

    private CustomerConstants() {
        // Prevent instantiation
    }
}
