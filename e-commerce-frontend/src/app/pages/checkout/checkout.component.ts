import { Component, OnInit } from '@angular/core';
import { CommonModule } from '@angular/common';
import { Router } from '@angular/router';
import { FormBuilder, FormGroup, Validators, ReactiveFormsModule } from '@angular/forms';
import { MatCardModule } from '@angular/material/card';
import { MatStepperModule } from '@angular/material/stepper';
import { MatFormFieldModule } from '@angular/material/form-field';
import { MatInputModule } from '@angular/material/input';
import { MatButtonModule } from '@angular/material/button';
import { MatRadioModule } from '@angular/material/radio';
import { MatIconModule } from '@angular/material/icon';
import { MatSnackBar, MatSnackBarModule } from '@angular/material/snack-bar';
import { CartService } from '../../../services/cart.service';
import { OrderService } from '../../../services/order.service';
import { CartItem } from '../../../models/cart.model';
import { OrderRequest, PaymentStatus, PurchaseRequest } from '../../../models/order.model';
import { PaymentMethod } from '../../../models/payment.model';

@Component({
    selector: 'app-checkout',
    standalone: true,
    imports: [
        CommonModule,
        ReactiveFormsModule,
        MatCardModule,
        MatStepperModule,
        MatFormFieldModule,
        MatInputModule,
        MatButtonModule,
        MatRadioModule,
        MatIconModule,
        MatSnackBarModule
    ],
    templateUrl: './checkout.component.html',
    styleUrls: ['./checkout.component.scss']
})
export class CheckoutComponent implements OnInit {
    customerFormGroup!: FormGroup;
    paymentFormGroup!: FormGroup;
    cartItems: CartItem[] = [];
    cartTotal = 0;
    isSubmitting = false;

    paymentMethods = [
        { value: PaymentMethod.CREDIT_CARD, label: 'Credit Card', icon: 'credit_card' },
        { value: PaymentMethod.DEBIT_CARD, label: 'Debit Card', icon: 'payment' },
        { value: PaymentMethod.PAYPAL, label: 'PayPal', icon: 'account_balance' },
        { value: PaymentMethod.CASH_ON_DELIVERY, label: 'Cash on Delivery', icon: 'local_atm' }
    ];

    constructor(
        private formBuilder: FormBuilder,
        private cartService: CartService,
        private orderService: OrderService,
        private router: Router,
        private snackBar: MatSnackBar
    ) { }

    ngOnInit(): void {
        this.customerFormGroup = this.formBuilder.group({
            customerId: ['CUST001', Validators.required], // Simplified - use logged-in customer ID
            email: ['', [Validators.required, Validators.email]],
            phone: ['', Validators.required]
        });

        this.paymentFormGroup = this.formBuilder.group({
            paymentMethod: [PaymentMethod.CREDIT_CARD, Validators.required]
        });

        this.cartService.getCartItems().subscribe((items: CartItem[]) => {
            this.cartItems = items;
        });

        this.cartService.getCartTotal().subscribe((total: number) => {
            this.cartTotal = total;
        });
    }

    placeOrder(): void {
        if (this.customerFormGroup.valid && this.paymentFormGroup.valid && this.cartItems.length > 0) {
            this.isSubmitting = true;

            const products: PurchaseRequest[] = this.cartItems.map(item => ({
                productId: item.product.id!,
                quantity: item.quantity
            }));

            const orderRequest: OrderRequest = {
                totalAmount: this.cartTotal,
                paymentStatus: PaymentStatus.PENDING,
                customerId: this.customerFormGroup.value.customerId,
                products: products
            };

            this.orderService.createOrder(orderRequest).subscribe({
                next: (orderId: number) => {
                    this.isSubmitting = false;
                    this.cartService.clearCart();
                    this.snackBar.open('Order placed successfully!', 'Close', {
                        duration: 5000,
                        horizontalPosition: 'right',
                        verticalPosition: 'top'
                    });
                    this.router.navigate(['/orders']);
                },
                error: (error: any) => {
                    this.isSubmitting = false;
                    this.snackBar.open('Failed to place order. Please try again.', 'Close', {
                        duration: 5000,
                        horizontalPosition: 'right',
                        verticalPosition: 'top'
                    });
                    console.error('Error placing order:', error);
                }
            });
        }
    }
}
