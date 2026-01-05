import { Component, OnInit } from '@angular/core';
import { CommonModule } from '@angular/common';
import { RouterLink } from '@angular/router';
import { MatCardModule } from '@angular/material/card';
import { MatButtonModule } from '@angular/material/button';
import { MatIconModule } from '@angular/material/icon';
import { MatTableModule } from '@angular/material/table';
import { MatInputModule } from '@angular/material/input';
import { MatFormFieldModule } from '@angular/material/form-field';
import { CartService } from '../../../services/cart.service';
import { CartItem } from '../../../models/cart.model';
import { Observable } from 'rxjs';

@Component({
    selector: 'app-cart',
    standalone: true,
    imports: [
        CommonModule,
        RouterLink,
        MatCardModule,
        MatButtonModule,
        MatIconModule,
        MatTableModule,
        MatInputModule,
        MatFormFieldModule
    ],
    templateUrl: './cart.component.html',
    styleUrls: ['./cart.component.scss']
})
export class CartComponent implements OnInit {
    cartItems$!: Observable<CartItem[]>;
    cartTotal$!: Observable<number>;

    constructor(private cartService: CartService) { }

    ngOnInit(): void {
        this.cartItems$ = this.cartService.getCartItems();
        this.cartTotal$ = this.cartService.getCartTotal();
    }

    updateQuantity(productId: number, quantity: number): void {
        if (quantity > 0) {
            this.cartService.updateQuantity(productId, quantity);
        }
    }

    removeItem(productId: number): void {
        this.cartService.removeFromCart(productId);
    }

    clearCart(): void {
        this.cartService.clearCart();
    }
}
