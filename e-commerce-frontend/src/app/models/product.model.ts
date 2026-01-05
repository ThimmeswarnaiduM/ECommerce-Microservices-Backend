// Category model matching backend Category entity
export interface Category {
    id?: number;
    name: string;
    description: string;
}

// Product model matching backend ProductDto
export interface Product {
    id?: number;
    name: string;
    description: string;
    availabilityQuantity: number;
    price: number;
    category: Category;
}

// Product purchase request
export interface ProductPurchaseRequest {
    productId: number;
    quantity: number;
}

// Product purchase response
export interface ProductPurchaseResponse {
    productId: number;
    name: string;
    description: string;
    price: number;
    quantity: number;
}
