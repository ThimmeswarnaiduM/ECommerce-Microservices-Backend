import { Product } from './product.model';

// Cart item interface
export interface CartItem {
    product: Product;
    quantity: number;
}
