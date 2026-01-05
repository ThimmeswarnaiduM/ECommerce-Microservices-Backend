import { Injectable } from '@angular/core';
import { HttpClient } from '@angular/common/http';
import { Observable } from 'rxjs';
import { environment } from '../../environments/environment';
import { PaymentRequest, PaymentResponse } from '../models/payment.model';

@Injectable({
    providedIn: 'root'
})
export class PaymentService {
    private apiUrl = environment.apiUrls.payment;

    constructor(private http: HttpClient) { }

    /**
     * Create a payment
     */
    createPayment(payment: PaymentRequest): Observable<number> {
        return this.http.post<number>(`${this.apiUrl}/Payment`, payment);
    }
}
