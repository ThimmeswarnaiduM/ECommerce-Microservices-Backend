// Address model matching backend Address entity
export interface Address {
    street: string;
    houseNumber: string;
    zipCode: string;
    city: string;
    country: string;
    state: string;
}

// Customer model matching backend CustomerDto
export interface Customer {
    id?: string;
    firstName: string;
    lastName: string;
    email: string;
    password?: string;
    phoneNumber: string;
    age: number;
    address: Address;
}

// Customer update DTO
export interface CustomerUpdateDto {
    firstName?: string;
    lastName?: string;
    email?: string;
    phoneNumber?: string;
    age?: number;
    address?: Address;
}

// Success response
export interface SuccessResponse {
    message: string;
    statusCode: number;
    timestamp: string;
}
