import { Component, OnInit } from '@angular/core';
import { CommonModule } from '@angular/common';
import { RouterLink } from '@angular/router';
import { MatCardModule } from '@angular/material/card';
import { MatButtonModule } from '@angular/material/button';
import { MatIconModule } from '@angular/material/icon';
import { MatProgressSpinnerModule } from '@angular/material/progress-spinner';
import { MatSnackBar, MatSnackBarModule } from '@angular/material/snack-bar';
import { ProductService } from '../../../services/product.service';
import { CartService } from '../../../services/cart.service';
import { Product } from '../../../models/product.model';

@Component({
    selector: 'app-product-list',
    standalone: true,
    imports: [
        CommonModule,
        RouterLink,
        MatCardModule,
        MatButtonModule,
        MatIconModule,
        MatProgressSpinnerModule,
        MatSnackBarModule
    ],
    templateUrl: './product-list.component.html',
    styleUrls: ['./product-list.component.scss']
})
export class ProductListComponent implements OnInit {
    products: Product[] = [];
    loading = false;
    error = '';

    constructor(
        private productService: ProductService,
        private cartService: CartService,
        private snackBar: MatSnackBar
    ) { }

    ngOnInit(): void {
        this.loadProducts();
    }

    loadProducts(): void {
        this.loading = true;
        this.productService.getAllProducts().subscribe({
            next: (products) => {
                this.products = products;
                this.loading = false;
            },
            error: (error) => {
                this.error = 'Failed to load products. Please try again later.';
                this.loading = false;
                console.error('Error loading products:', error);
            }
        });
    }

    addToCart(product: Product): void {
        if (product.availabilityQuantity > 0) {
            this.cartService.addToCart(product, 1);
            this.snackBar.open(`${product.name} added to cart!`, 'Close', {
                duration: 3000,
                horizontalPosition: 'right',
                verticalPosition: 'top'
            });
        } else {
            this.snackBar.open('Product is out of stock', 'Close', {
                duration: 3000,
                horizontalPosition: 'right',
                verticalPosition: 'top'
            });
        }
    }
}
