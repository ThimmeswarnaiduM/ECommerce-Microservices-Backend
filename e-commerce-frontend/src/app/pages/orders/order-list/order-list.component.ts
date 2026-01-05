import { Component, OnInit } from '@angular/core';
import { CommonModule } from '@angular/common';
import { RouterLink } from '@angular/router';
import { MatCardModule } from '@angular/material/card';
import { MatButtonModule } from '@angular/material/button';
import { MatIconModule } from '@angular/material/icon';
import { MatChipsModule } from '@angular/material/chips';
import { MatProgressSpinnerModule } from '@angular/material/progress-spinner';
import { OrderService } from '../../../services/order.service';
import { OrderResponse } from '../../../models/order.model';

@Component({
    selector: 'app-order-list',
    standalone: true,
    imports: [
        CommonModule,
        RouterLink,
        MatCardModule,
        MatButtonModule,
        MatIconModule,
        MatChipsModule,
        MatProgressSpinnerModule
    ],
    templateUrl: './order-list.component.html',
    styleUrls: ['./order-list.component.scss']
})
export class OrderListComponent implements OnInit {
    orders: OrderResponse[] = [];
    loading = false;
    error = '';

    constructor(private orderService: OrderService) { }

    ngOnInit(): void {
        this.loadOrders();
    }

    loadOrders(): void {
        this.loading = true;
        this.orderService.getAllOrders().subscribe({
            next: (orders) => {
                this.orders = orders;
                this.loading = false;
            },
            error: (error) => {
                this.error = 'Failed to load orders. Please try again later.';
                this.loading = false;
                console.error('Error loading orders:', error);
            }
        });
    }

    getStatusColor(status: string): string {
        switch (status) {
            case 'PAID':
                return 'primary';
            case 'PENDING':
                return 'accent';
            case 'FAILED':
            case 'CANCELLED':
                return 'warn';
            default:
                return '';
        }
    }
}
