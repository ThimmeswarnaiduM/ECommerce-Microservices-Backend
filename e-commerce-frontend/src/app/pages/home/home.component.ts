import { Component } from '@angular/core';
import { RouterLink } from '@angular/router';
import { MatButtonModule } from '@angular/material/button';
import { MatCardModule } from '@angular/material/card';
import { MatIconModule } from '@angular/material/icon';

@Component({
    selector: 'app-home',
    standalone: true,
    imports: [RouterLink, MatButtonModule, MatCardModule, MatIconModule],
    templateUrl: './home.component.html',
    styleUrls: ['./home.component.scss']
})
export class HomeComponent {
    features = [
        {
            icon: 'inventory_2',
            title: 'Wide Selection',
            description: 'Browse thousands of products across multiple categories'
        },
        {
            icon: 'local_shipping',
            title: 'Fast Delivery',
            description: 'Quick and reliable shipping to your doorstep'
        },
        {
            icon: 'security',
            title: 'Secure Payment',
            description: 'Safe and encrypted payment processing'
        },
        {
            icon: 'support_agent',
            title: '24/7 Support',
            description: 'Customer support available round the clock'
        }
    ];
}
