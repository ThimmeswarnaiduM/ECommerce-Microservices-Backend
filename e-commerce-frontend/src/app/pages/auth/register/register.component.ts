import { Component } from '@angular/core';
import { CommonModule } from '@angular/common';
import { Router } from '@angular/router';
import { FormBuilder, FormGroup, Validators, ReactiveFormsModule } from '@angular/forms';
import { MatCardModule } from '@angular/material/card';
import { MatFormFieldModule } from '@angular/material/form-field';
import { MatInputModule } from '@angular/material/input';
import { MatButtonModule } from '@angular/material/button';
import { MatIconModule } from '@angular/material/icon';
import { MatSnackBar, MatSnackBarModule } from '@angular/material/snack-bar';
import { CustomerService } from '../../../services/customer.service';
import { Customer, Address } from '../../../models/customer.model';

@Component({
    selector: 'app-register',
    standalone: true,
    imports: [
        CommonModule,
        ReactiveFormsModule,
        MatCardModule,
        MatFormFieldModule,
        MatInputModule,
        MatButtonModule,
        MatIconModule,
        MatSnackBarModule
    ],
    templateUrl: './register.component.html',
    styleUrls: ['./register.component.scss']
})
export class RegisterComponent {
    registerForm: FormGroup;
    isSubmitting = false;

    constructor(
        private formBuilder: FormBuilder,
        private customerService: CustomerService,
        private router: Router,
        private snackBar: MatSnackBar
    ) {
        this.registerForm = this.formBuilder.group({
            firstName: ['', [Validators.required, Validators.pattern('[a-zA-Z]+')]],
            lastName: ['', [Validators.required, Validators.pattern('[a-zA-Z]+')]],
            email: ['', [Validators.required, Validators.email]],
            password: ['', [Validators.required, Validators.minLength(8)]],
            phoneNumber: ['', [Validators.required, Validators.pattern('^\\+?[0-9]{10,15}$')]],
            age: ['', [Validators.required, Validators.min(1)]],
            street: ['', Validators.required],
            houseNumber: ['', Validators.required],
            zipCode: ['', Validators.required],
            city: ['', Validators.required],
            country: ['', Validators.required],
            state: ['', Validators.required]
        });
    }

    onSubmit(): void {
        if (this.registerForm.valid) {
            this.isSubmitting = true;

            const formValue = this.registerForm.value;

            const address: Address = {
                street: formValue.street,
                houseNumber: formValue.houseNumber,
                zipCode: formValue.zipCode,
                city: formValue.city,
                country: formValue.country,
                state: formValue.state
            };

            const customer: Customer = {
                firstName: formValue.firstName,
                lastName: formValue.lastName,
                email: formValue.email,
                password: formValue.password,
                phoneNumber: formValue.phoneNumber,
                age: formValue.age,
                address: address
            };

            this.customerService.createCustomer(customer).subscribe({
                next: (response) => {
                    this.isSubmitting = false;
                    this.snackBar.open('Registration successful!', 'Close', {
                        duration: 5000,
                        horizontalPosition: 'right',
                        verticalPosition: 'top'
                    });
                    this.router.navigate(['/products']);
                },
                error: (error) => {
                    this.isSubmitting = false;
                    this.snackBar.open('Registration failed. Please try again.', 'Close', {
                        duration: 5000,
                        horizontalPosition: 'right',
                        verticalPosition: 'top'
                    });
                    console.error('Registration error:', error);
                }
            });
        }
    }
}
