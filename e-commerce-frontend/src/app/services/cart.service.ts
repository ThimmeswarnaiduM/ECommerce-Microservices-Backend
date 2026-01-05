import { Injectable } from '@angular/core';
import { BehaviorSubject, Observable } from 'rxjs';
import { CartItem } from '../models/cart.model';
import { Product } from '../models/product.model';
import { map } from 'rxjs/operators';

@Injectable({
    providedIn: 'root'
})
export class CartService {
    private cartItems = new BehaviorSubject<CartItem[]>([]);
    private readonly CART_STORAGE_KEY = 'shopping_cart';

    constructor() {
        // Load cart from localStorage on service initialization
        this.loadCartFromStorage();
    }

    /**
     * Get cart items as observable
     */
    getCartItems(): Observable<CartItem[]> {
        return this.cartItems.asObservable();
    }

    /**
     * Get cart total price
     */
    getCartTotal(): Observable<number> {
        return this.cartItems.pipe(
            map(items => items.reduce((total, item) => {
                return total + (item.product.price * item.quantity);
            }, 0))
        );
    }

    /**
     * Get cart items count
     */
    getCartItemsCount(): Observable<number> {
        return this.cartItems.pipe(
            map(items => items.reduce((count, item) => count + item.quantity, 0))
        );
    }

    /**
     * Add product to cart
     */
    addToCart(product: Product, quantity: number = 1): void {
        const currentItems = this.cartItems.value;
        const existingItemIndex = currentItems.findIndex(
            item => item.product.id === product.id
        );

        if (existingItemIndex !== -1) {
            // Update quantity if product already in cart
            currentItems[existingItemIndex].quantity += quantity;
        } else {
            // Add new item to cart
            currentItems.push({ product, quantity });
        }

        this.cartItems.next(currentItems);
        this.saveCartToStorage();
    }

    /**
     * Update quantity of a cart item
     */
    updateQuantity(productId: number, quantity: number): void {
        const currentItems = this.cartItems.value;
        const itemIndex = currentItems.findIndex(
            item => item.product.id === productId
        );

        if (itemIndex !== -1) {
            if (quantity <= 0) {
                // Remove item if quantity is 0 or less
                currentItems.splice(itemIndex, 1);
            } else {
                currentItems[itemIndex].quantity = quantity;
            }
            this.cartItems.next(currentItems);
            this.saveCartToStorage();
        }
    }

    /**
     * Remove item from cart
     */
    removeFromCart(productId: number): void {
        const currentItems = this.cartItems.value;
        const filteredItems = currentItems.filter(
            item => item.product.id !== productId
        );
        this.cartItems.next(filteredItems);
        this.saveCartToStorage();
    }

    /**
     * Clear all items from cart
     */
    clearCart(): void {
        this.cartItems.next([]);
        this.saveCartToStorage();
    }

    /**
     * Save cart to localStorage
     */
    private saveCartToStorage(): void {
        localStorage.setItem(
            this.CART_STORAGE_KEY,
            JSON.stringify(this.cartItems.value)
        );
    }

    /**
     * Load cart from localStorage
     */
    private loadCartFromStorage(): void {
        const storedCart = localStorage.getItem(this.CART_STORAGE_KEY);
        if (storedCart) {
            try {
                const items = JSON.parse(storedCart);
                this.cartItems.next(items);
            } catch (error) {
                console.error('Error loading cart from storage:', error);
                this.cartItems.next([]);
            }
        }
    }
}
