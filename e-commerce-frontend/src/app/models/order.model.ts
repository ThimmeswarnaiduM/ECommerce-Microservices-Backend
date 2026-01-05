import { ProductPurchaseRequest } from './product.model';

// Payment status enum
export enum PaymentStatus {
    PENDING = 'PENDING',
    PAID = 'PAID',
    FAILED = 'FAILED',
    CANCELLED = 'CANCELLED'
}

// Purchase request for order
export interface PurchaseRequest {
    productId: number;
    quantity: number;
}

// Order request matching backend OrderRequest
export interface OrderRequest {
    id?: number;
    referenceNumber?: string;
    totalAmount: number;
    paymentStatus: PaymentStatus;
    customerId: string;
    products: PurchaseRequest[];
}

// Order response matching backend OrderResponse
export interface OrderResponse {
    referenceNumber: string;
    totalAmount: number;
    paymentStatus: PaymentStatus;
    customerId: string;
}

// Order line response
export interface OrderLineResponse {
    id?: number;
    quantity: number;
    productId: number;
    orderId: number;
}
