import { Injectable } from '@angular/core';
import { HttpClient, HttpHeaders } from '@angular/common/http';
import { Observable } from 'rxjs';
import { environment } from '../../environments/environment';
import { Customer, CustomerUpdateDto, SuccessResponse } from '../models/customer.model';

@Injectable({
    providedIn: 'root'
})
export class CustomerService {
    private apiUrl = environment.apiUrls.customer;

    constructor(private http: HttpClient) { }

    /**
     * Create a new customer
     */
    createCustomer(customer: Customer): Observable<SuccessResponse> {
        return this.http.post<SuccessResponse>(`${this.apiUrl}/customer`, customer);
    }

    /**
     * Get customer by ID
     */
    getCustomer(id: string): Observable<Customer> {
        return this.http.get<Customer>(`${this.apiUrl}/${id}`);
    }

    /**
     * Update customer (partial update)
     */
    updateCustomer(id: string, customer: CustomerUpdateDto): Observable<Customer[]> {
        return this.http.patch<Customer[]>(`${this.apiUrl}/customer/${id}`, customer);
    }

    /**
     * Update customer (full update)
     */
    updateCustomerAllDetails(id: string, customer: Customer): Observable<Customer[]> {
        return this.http.put<Customer[]>(`${this.apiUrl}/customer/${id}`, customer);
    }

    /**
     * Delete customer by ID
     */
    deleteCustomer(id: string): Observable<string> {
        return this.http.delete<string>(`${this.apiUrl}/customer/${id}`);
    }

    /**
     * Delete customer by email
     */
    deleteByEmail(email: string): Observable<string> {
        return this.http.delete<string>(`${this.apiUrl}/customer?email=${email}`);
    }

    /**
     * Delete customer by phone number
     */
    deleteByPhoneNumber(phoneNumber: string): Observable<string> {
        return this.http.delete<string>(`${this.apiUrl}/customers?phoneNumber=${phoneNumber}`);
    }
}
