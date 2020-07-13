import {NgModule} from '@angular/core';
import {Routes, RouterModule} from '@angular/router';
import {CategorylistComponent} from './view/category/list/category-list.component';
import {CategoryCreateComponent} from './view/category/create/category-create.component';
import {CategoryDetailsComponent} from './view/category/details/category-details.component';
import {CategoryEditComponent} from './view/category/edit/category-edit.component';
import {UserlistComponent} from './view/user/list/user-list.component';
import {UserCreateComponent} from './view/user/create/user-create.component';
import {UserDetailsComponent} from './view/user/details/user-details.component';
import {UserEditComponent} from './view/user/edit/user-edit.component';
import {CategoryProductlistComponent} from './view/categoryProduct/list/categoryProduct-list.component';
import {CategoryProductCreateComponent} from './view/categoryProduct/create/categoryProduct-create.component';
import {CategoryProductDetailsComponent} from './view/categoryProduct/details/categoryProduct-details.component';
import {CategoryProductEditComponent} from './view/categoryProduct/edit/categoryProduct-edit.component';
import {DeliveryCostlistComponent} from './view/deliveryCost/list/deliveryCost-list.component';
import {DeliveryCostCreateComponent} from './view/deliveryCost/create/deliveryCost-create.component';
import {DeliveryCostDetailsComponent} from './view/deliveryCost/details/deliveryCost-details.component';
import {DeliveryCostEditComponent} from './view/deliveryCost/edit/deliveryCost-edit.component';
import {ProductlistComponent} from './view/product/list/product-list.component';
import {ProductCreateComponent} from './view/product/create/product-create.component';
import {ProductDetailsComponent} from './view/product/details/product-details.component';
import {ProductEditComponent} from './view/product/edit/product-edit.component';
import {CitylistComponent} from './view/city/list/city-list.component';
import {CityCreateComponent} from './view/city/create/city-create.component';
import {CityDetailsComponent} from './view/city/details/city-details.component';
import {CityEditComponent} from './view/city/edit/city-edit.component';
import {RolelistComponent} from './view/role/list/role-list.component';
import {RoleCreateComponent} from './view/role/create/role-create.component';
import {RoleDetailsComponent} from './view/role/details/role-details.component';
import {RoleEditComponent} from './view/role/edit/role-edit.component';
import {OrderStatuslistComponent} from './view/orderStatus/list/orderStatus-list.component';
import {OrderStatusCreateComponent} from './view/orderStatus/create/orderStatus-create.component';
import {OrderStatusDetailsComponent} from './view/orderStatus/details/orderStatus-details.component';
import {OrderStatusEditComponent} from './view/orderStatus/edit/orderStatus-edit.component';
import {CommandlistComponent} from './view/command/list/command-list.component';
import {CommandCreateComponent} from './view/command/create/command-create.component';
import {CommandDetailsComponent} from './view/command/details/command-details.component';
import {CommandEditComponent} from './view/command/edit/command-edit.component';
import {OrderLinelistComponent} from './view/orderLine/list/orderLine-list.component';
import {OrderLineCreateComponent} from './view/orderLine/create/orderLine-create.component';
import {OrderLineDetailsComponent} from './view/orderLine/details/orderLine-details.component';
import {OrderLineEditComponent} from './view/orderLine/edit/orderLine-edit.component';
import {ClientlistComponent} from './view/client/list/client-list.component';
import {ClientCreateComponent} from './view/client/create/client-create.component';
import {ClientDetailsComponent} from './view/client/details/client-details.component';
import {ClientEditComponent} from './view/client/edit/client-edit.component';
import {StocklistComponent} from './view/stock/list/stock-list.component';
import {StockCreateComponent} from './view/stock/create/stock-create.component';
import {StockDetailsComponent} from './view/stock/details/stock-details.component';
import {StockEditComponent} from './view/stock/edit/stock-edit.component';
import {DeliveryTypelistComponent} from './view/deliveryType/list/deliveryType-list.component';
import {DeliveryTypeCreateComponent} from './view/deliveryType/create/deliveryType-create.component';
import {DeliveryTypeDetailsComponent} from './view/deliveryType/details/deliveryType-details.component';
import {DeliveryTypeEditComponent} from './view/deliveryType/edit/deliveryType-edit.component';
import {AppComponent} from './app.component';
import {LandingPageComponent} from './landing-page/landing-page.component';
import {DashboardComponent} from './view/dashboard/dashboard.component';
import {AnalyticsComponent} from './view/analytics/analytics.component';
import {LoginComponent} from './view/login/login.component';

const routes: Routes = [
        {
            path: 'category', children: [
                {path: 'list', component: CategorylistComponent},
                {path: 'create', component: CategoryCreateComponent},
                {path: 'details', component: CategoryDetailsComponent},
                {path: 'edit', component: CategoryEditComponent}
            ]
        },
        {
            path: 'user', children: [
                {path: 'list', component: UserlistComponent},
                {path: 'create', component: UserCreateComponent},
                {path: 'details', component: UserDetailsComponent},
                {path: 'edit', component: UserEditComponent}
            ]
        },
        {
            path: 'categoryProduct', children: [
                {path: 'list', component: CategoryProductlistComponent},
                {path: 'create', component: CategoryProductCreateComponent},
                {path: 'details', component: CategoryProductDetailsComponent},
                {path: 'edit', component: CategoryProductEditComponent}
            ]
        },
        {
            path: 'deliveryCost', children: [
                {path: 'list', component: DeliveryCostlistComponent},
                {path: 'create', component: DeliveryCostCreateComponent},
                {path: 'details', component: DeliveryCostDetailsComponent},
                {path: 'edit', component: DeliveryCostEditComponent}
            ]
        },
        {
            path: 'product', children: [
                {path: 'list', component: ProductlistComponent},
                {path: 'create', component: ProductCreateComponent},
                {path: 'details', component: ProductDetailsComponent},
                {path: 'edit', component: ProductEditComponent}
            ]
        },
        {
            path: 'city', children: [
                {path: 'list', component: CitylistComponent},
                {path: 'create', component: CityCreateComponent},
                {path: 'details', component: CityDetailsComponent},
                {path: 'edit', component: CityEditComponent}
            ]
        },
        {
            path: 'role', children: [
                {path: 'list', component: RolelistComponent},
                {path: 'create', component: RoleCreateComponent},
                {path: 'details', component: RoleDetailsComponent},
                {path: 'edit', component: RoleEditComponent}
            ]
        },
        {
            path: 'orderStatus', children: [
                {path: 'list', component: OrderStatuslistComponent},
                {path: 'create', component: OrderStatusCreateComponent},
                {path: 'details', component: OrderStatusDetailsComponent},
                {path: 'edit', component: OrderStatusEditComponent}
            ]
        },
        {
            path: 'command', children: [
                {path: 'list', component: CommandlistComponent},
                {path: 'create', component: CommandCreateComponent},
                {path: 'details', component: CommandDetailsComponent},
                {path: 'edit', component: CommandEditComponent}
            ]
        },
        {
            path: 'orderLine', children: [
                {path: 'list', component: OrderLinelistComponent},
                {path: 'create', component: OrderLineCreateComponent},
                {path: 'details', component: OrderLineDetailsComponent},
                {path: 'edit', component: OrderLineEditComponent}
            ]
        },
        {
            path: 'client', children: [
                {path: 'list', component: ClientlistComponent},
                {path: 'create', component: ClientCreateComponent},
                {path: 'details', component: ClientDetailsComponent},
                {path: 'edit', component: ClientEditComponent}
            ]
        },
        {
            path: 'stock', children: [
                {path: 'list', component: StocklistComponent},
                {path: 'create', component: StockCreateComponent},
                {path: 'details', component: StockDetailsComponent},
                {path: 'edit', component: StockEditComponent}
            ]
        },
        {
            path: 'deliveryType', children: [
                {path: 'list', component: DeliveryTypelistComponent},
                {path: 'create', component: DeliveryTypeCreateComponent},
                {path: 'details', component: DeliveryTypeDetailsComponent},
                {path: 'edit', component: DeliveryTypeEditComponent}
            ]
        },
        {path: 'dashboard', component: DashboardComponent},
        {path: 'analytics', component: AnalyticsComponent},
        {path: '', component: LoginComponent}
    ]
;

@NgModule({
    imports: [RouterModule.forRoot(routes)],
    exports: [RouterModule]
})
export class AppRoutingModule {
}
