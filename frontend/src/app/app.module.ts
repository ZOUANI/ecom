import {BrowserModule} from '@angular/platform-browser';
import {BrowserAnimationsModule} from '@angular/platform-browser/animations';
import {CalendarModule} from 'primeng/calendar';
import {NgModule} from '@angular/core';

import {AppComponent} from './app.component';
import {FormsModule} from '@angular/forms';
import {HttpClientModule} from '@angular/common/http';
import {AppRoutingModule} from './app-routing.module';
import {CategoryCreateComponent} from './view/category/create/category-create.component';
import {CategorylistComponent} from './view/category/list/category-list.component';
import {CategoryDetailsComponent} from './view/category/details/category-details.component';
import {CategoryEditComponent} from './view/category/edit/category-edit.component';
import {CategoryComponent} from './view/category/category.component';
import {UserCreateComponent} from './view/user/create/user-create.component';
import {UserlistComponent} from './view/user/list/user-list.component';
import {UserDetailsComponent} from './view/user/details/user-details.component';
import {UserEditComponent} from './view/user/edit/user-edit.component';
import {UserComponent} from './view/user/user.component';
import {CategoryProductCreateComponent} from './view/categoryProduct/create/categoryProduct-create.component';
import {CategoryProductlistComponent} from './view/categoryProduct/list/categoryProduct-list.component';
import {CategoryProductDetailsComponent} from './view/categoryProduct/details/categoryProduct-details.component';
import {CategoryProductEditComponent} from './view/categoryProduct/edit/categoryProduct-edit.component';
import {CategoryProductComponent} from './view/categoryProduct/categoryProduct.component';
import {DeliveryCostCreateComponent} from './view/deliveryCost/create/deliveryCost-create.component';
import {DeliveryCostlistComponent} from './view/deliveryCost/list/deliveryCost-list.component';
import {DeliveryCostDetailsComponent} from './view/deliveryCost/details/deliveryCost-details.component';
import {DeliveryCostEditComponent} from './view/deliveryCost/edit/deliveryCost-edit.component';
import {DeliveryCostComponent} from './view/deliveryCost/deliveryCost.component';
import {ProductCreateComponent} from './view/product/create/product-create.component';
import {ProductlistComponent} from './view/product/list/product-list.component';
import {ProductDetailsComponent} from './view/product/details/product-details.component';
import {ProductEditComponent} from './view/product/edit/product-edit.component';
import {ProductComponent} from './view/product/product.component';
import {CityCreateComponent} from './view/city/create/city-create.component';
import {CitylistComponent} from './view/city/list/city-list.component';
import {CityDetailsComponent} from './view/city/details/city-details.component';
import {CityEditComponent} from './view/city/edit/city-edit.component';
import {CityComponent} from './view/city/city.component';
import {RoleCreateComponent} from './view/role/create/role-create.component';
import {RolelistComponent} from './view/role/list/role-list.component';
import {RoleDetailsComponent} from './view/role/details/role-details.component';
import {RoleEditComponent} from './view/role/edit/role-edit.component';
import {RoleComponent} from './view/role/role.component';
import {OrderStatusCreateComponent} from './view/orderStatus/create/orderStatus-create.component';
import {OrderStatuslistComponent} from './view/orderStatus/list/orderStatus-list.component';
import {OrderStatusDetailsComponent} from './view/orderStatus/details/orderStatus-details.component';
import {OrderStatusEditComponent} from './view/orderStatus/edit/orderStatus-edit.component';
import {OrderStatusComponent} from './view/orderStatus/orderStatus.component';
import {CommandCreateComponent} from './view/command/create/command-create.component';
import {CommandlistComponent} from './view/command/list/command-list.component';
import {CommandDetailsComponent} from './view/command/details/command-details.component';
import {CommandEditComponent} from './view/command/edit/command-edit.component';
import {CommandComponent} from './view/command/command.component';
import {OrderLineCreateComponent} from './view/orderLine/create/orderLine-create.component';
import {OrderLinelistComponent} from './view/orderLine/list/orderLine-list.component';
import {OrderLineDetailsComponent} from './view/orderLine/details/orderLine-details.component';
import {OrderLineEditComponent} from './view/orderLine/edit/orderLine-edit.component';
import {OrderLineComponent} from './view/orderLine/orderLine.component';
import {ClientCreateComponent} from './view/client/create/client-create.component';
import {ClientlistComponent} from './view/client/list/client-list.component';
import {ClientDetailsComponent} from './view/client/details/client-details.component';
import {ClientEditComponent} from './view/client/edit/client-edit.component';
import {ClientComponent} from './view/client/client.component';
import {StockCreateComponent} from './view/stock/create/stock-create.component';
import {StocklistComponent} from './view/stock/list/stock-list.component';
import {StockDetailsComponent} from './view/stock/details/stock-details.component';
import {StockEditComponent} from './view/stock/edit/stock-edit.component';
import {StockComponent} from './view/stock/stock.component';
import {DeliveryTypeCreateComponent} from './view/deliveryType/create/deliveryType-create.component';
import {DeliveryTypelistComponent} from './view/deliveryType/list/deliveryType-list.component';
import {DeliveryTypeDetailsComponent} from './view/deliveryType/details/deliveryType-details.component';
import {DeliveryTypeEditComponent} from './view/deliveryType/edit/deliveryType-edit.component';
import {DeliveryTypeComponent} from './view/deliveryType/deliveryType.component';
import {NavbarComponent} from './navbar/navbar.component';
import {LandingPageComponent} from './landing-page/landing-page.component';


import {OverlayPanelModule} from 'primeng/overlaypanel';
import { ChartModule } from 'primeng/chart';

import {MenuModule} from 'primeng/menu';
import { TableModule } from 'primeng/table';
import { PaginatorModule } from 'primeng/paginator';
import {DashboardComponent} from './view/dashboard/dashboard.component';
import {AnalyticsComponent} from './view/analytics/analytics.component';
import {BigNumberPipe} from './pipes/big-number.pipe';
import {LoginComponent} from './view/login/login.component';
import {ToastrModule} from 'ngx-toastr';
import {MatCardModule} from '@angular/material/card';
import {MatFormFieldModule} from '@angular/material/form-field';
import {MatInputModule} from '@angular/material/input';
import {MatButtonModule} from '@angular/material/button';

@NgModule({
    declarations: [
        CategoryCreateComponent,
        CategorylistComponent,
        CategoryDetailsComponent,
        CategoryEditComponent,
        CategoryComponent,
        UserCreateComponent,
        UserlistComponent,
        UserDetailsComponent,
        UserEditComponent,
        UserComponent,
        CategoryProductCreateComponent,
        CategoryProductlistComponent,
        CategoryProductDetailsComponent,
        CategoryProductEditComponent,
        CategoryProductComponent,
        DeliveryCostCreateComponent,
        DeliveryCostlistComponent,
        DeliveryCostDetailsComponent,
        DeliveryCostEditComponent,
        DeliveryCostComponent,
        ProductCreateComponent,
        ProductlistComponent,
        ProductDetailsComponent,
        ProductEditComponent,
        ProductComponent,
        CityCreateComponent,
        CitylistComponent,
        CityDetailsComponent,
        CityEditComponent,
        CityComponent,
        RoleCreateComponent,
        RolelistComponent,
        RoleDetailsComponent,
        RoleEditComponent,
        RoleComponent,
        OrderStatusCreateComponent,
        OrderStatuslistComponent,
        OrderStatusDetailsComponent,
        OrderStatusEditComponent,
        OrderStatusComponent,
        CommandCreateComponent,
        CommandlistComponent,
        CommandDetailsComponent,
        CommandEditComponent,
        CommandComponent,
        OrderLineCreateComponent,
        OrderLinelistComponent,
        OrderLineDetailsComponent,
        OrderLineEditComponent,
        OrderLineComponent,
        ClientCreateComponent,
        ClientlistComponent,
        ClientDetailsComponent,
        ClientEditComponent,
        ClientComponent,
        StockCreateComponent,
        StocklistComponent,
        StockDetailsComponent,
        StockEditComponent,
        StockComponent,
        DeliveryTypeCreateComponent,
        DeliveryTypelistComponent,
        DeliveryTypeDetailsComponent,
        DeliveryTypeEditComponent,
        DeliveryTypeComponent,
        AppComponent,
        LandingPageComponent,
        NavbarComponent,
        DashboardComponent,
        AnalyticsComponent,
        BigNumberPipe,
        LoginComponent
    ],
    imports: [
        BrowserModule,
        FormsModule,
        HttpClientModule,
        AppRoutingModule,
        BrowserAnimationsModule,
        CalendarModule,
        OverlayPanelModule,
        MenuModule,
        PaginatorModule,
        TableModule,
        ToastrModule.forRoot(),
        MatCardModule,
        MatFormFieldModule,
        MatInputModule,
        MatButtonModule,
        ChartModule
    ],
    providers: [],
    bootstrap: [AppComponent]
})
export class AppModule {
}
