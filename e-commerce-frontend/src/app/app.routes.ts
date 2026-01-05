import { Routes } from '@angular/router';
import { HomeComponent } from './pages/home/home.component';
import { ProductListComponent } from './pages/products/product-list/product-list.component';
// Temporarily disabled due to module resolution issues
// import { CartComponent } from './pages/cart/cart.component';
// import { CheckoutComponent } from './pages/checkout/checkout.component';
import { OrderListComponent } from './pages/orders/order-list/order-list.component';
import { RegisterComponent } from './pages/auth/register/register.component';

export const routes: Routes = [
    { path: '', component: HomeComponent },
    { path: 'products', component: ProductListComponent },
    // { path: 'cart', component: CartComponent },
    // { path: 'checkout', component: CheckoutComponent },
    { path: 'orders', component: OrderListComponent },
    { path: 'register', component: RegisterComponent },
    { path: '**', redirectTo: '', pathMatch: 'full' }
];
