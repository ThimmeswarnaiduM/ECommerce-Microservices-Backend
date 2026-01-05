import { PaymentStatus } from './order.model';

// Payment method enum
export enum PaymentMethod {
    CREDIT_CARD = 'CREDIT_CARD',
    DEBIT_CARD = 'DEBIT_CARD',
    PAYPAL = 'PAYPAL',
    CASH_ON_DELIVERY = 'CASH_ON_DELIVERY'
}

// Payment request
export interface PaymentRequest {
    amount: number;
    paymentMethod: PaymentMethod;
    orderId: number;
    customerId: string;
}

// Payment response
export interface PaymentResponse {
    id: number;
    amount: number;
    paymentMethod: PaymentMethod;
    status: PaymentStatus;
    orderId: number;
}
