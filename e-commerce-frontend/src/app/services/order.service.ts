import { Injectable } from '@angular/core';
import { HttpClient } from '@angular/common/http';
import { Observable } from 'rxjs';
import { environment } from '../../environments/environment';
import { OrderRequest, OrderResponse } from '../models/order.model';

@Injectable({
    providedIn: 'root'
})
export class OrderService {
    private apiUrl = environment.apiUrls.order;

    constructor(private http: HttpClient) { }

    /**
     * Create a new order
     */
    createOrder(order: OrderRequest): Observable<number> {
        return this.http.post<number>(`${this.apiUrl}/createOrder`, order);
    }

    /**
     * Get all orders
     */
    getAllOrders(): Observable<OrderResponse[]> {
        return this.http.get<OrderResponse[]>(`${this.apiUrl}`);
    }

    /**
     * Get order by ID
     */
    getOrderById(id: number): Observable<OrderResponse> {
        return this.http.get<OrderResponse>(`${this.apiUrl}/${id}`);
    }
}
