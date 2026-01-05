import { Injectable } from '@angular/core';
import { HttpClient } from '@angular/common/http';
import { Observable } from 'rxjs';
import { environment } from '../../environments/environment';
import { Product, ProductPurchaseRequest, ProductPurchaseResponse } from '../models/product.model';
import { SuccessResponse } from '../models/customer.model';

@Injectable({
    providedIn: 'root'
})
export class ProductService {
    private apiUrl = environment.apiUrls.product;

    constructor(private http: HttpClient) { }

    /**
     * Create a new product
     */
    createProduct(product: Product): Observable<SuccessResponse> {
        return this.http.post<SuccessResponse>(`${this.apiUrl}/create`, product);
    }

    /**
     * Get all products
     */
    getAllProducts(): Observable<Product[]> {
        return this.http.get<Product[]>(`${this.apiUrl}/GetAllProducts`);
    }

    /**
     * Get product by ID
     */
    getProductById(id: number): Observable<Product> {
        return this.http.get<Product>(`${this.apiUrl}/getProduct/${id}`);
    }

    /**
     * Update product by ID
     */
    updateProduct(id: number, product: Product): Observable<Product> {
        return this.http.put<Product>(`${this.apiUrl}/updateProduct/${id}`, product);
    }

    /**
     * Delete product by ID
     */
    deleteProduct(id: number): Observable<string> {
        return this.http.delete<string>(`${this.apiUrl}/deleteProduct?id=${id}`);
    }

    /**
     * Purchase products (used during checkout)
     */
    purchaseProducts(requests: ProductPurchaseRequest[]): Observable<ProductPurchaseResponse[]> {
        return this.http.post<ProductPurchaseResponse[]>(`${this.apiUrl}/purchaseProduct`, requests);
    }
}
