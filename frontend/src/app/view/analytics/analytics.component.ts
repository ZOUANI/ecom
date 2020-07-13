import {Component, OnInit} from '@angular/core';
import {SortEvent, LazyLoadEvent} from 'primeng/api';
import {ProductService} from '../../controller/service/product.service';
import {ProductVo} from '../../controller/model/Product.model';
import {DeliveryVo} from '../../controller/model/delivery-vo';
import {DeliveryStats} from '../../controller/model/delivery-stats';
import {CommandService} from '../../controller/service/command.service';

@Component({
    selector: 'app-analytics',
    templateUrl: './analytics.component.html',
    styleUrls: ['./analytics.component.css']
})
export class AnalyticsComponent implements OnInit {

    rangeDates: any;
    totalOrdersData: any;
    confirmedOrdersData: any;
    deliveredOrdersData: any;

    totalOrders = 0;
    totalConfirmedOrders = 0;
    totalDeliveredOrders = 0;

    products: ProductVo[];

    cols: any[];

    totalRecords: number;

    rows = 10;

    loading: boolean;

    deliveryData: any;

    deliveries: DeliveryVo[];

    deliveryCols: any[];

    deliveryTotalRecords: number;

    deliveryRows = 10;

    deliveryLoading: boolean;

    deliveryStatsData: any;

    deliveryStats: DeliveryStats[];

    deliveryStatsCols: any[];

    deliveryStatsTotalRecords: number;

    deliveryStatsRows = 10;

    deliveryStatsLoading: boolean;
    analyticsStats: { totalCommandsConfirmed: number; totalCommandsPaid: number; totalCommandsDelivred: number; totalCommands: number; } = {
        totalCommands: 0,
        totalCommandsConfirmed: 0,
        totalCommandsDelivred: 0,
        totalCommandsPaid: 0
    };

    constructor(private productService: ProductService, private commandService: CommandService) {
        this.loading = true;
    }

    ngOnInit() {
        this.productService.getProducts().then(products => {
            this.products = products;
            this.totalRecords = products.length;
        });

        this.productService.getDeliveries().then(deliveries => {
            this.deliveries = deliveries;
            this.deliveryTotalRecords = deliveries.length;
        });

        this.productService.getDeliveryStats().then(deliveryStats => {
            this.deliveryStats = deliveryStats;
            this.deliveryTotalRecords = deliveryStats.length;
        });

        this.commandService.getTotalOrdersChartStats().subscribe(response => {
            this.totalOrders = response.totalOrders;
            this.totalOrdersData = {
                labels: response.labels,
                datasets: [
                    {
                        label: 'Total Orders',
                        data: response.data,
                        fill: false,
                        borderColor: '#37474f'
                    }
                ]
            };
        });
        this.commandService.getConfirmedAndDeliveredOrdersChartStats('confirmed').subscribe(response => {
            this.totalConfirmedOrders = response.totalOrders;
            this.confirmedOrdersData = {
                labels: response.labels,
                datasets: [
                    {
                        label: 'Confirmed Orders',
                        data: response.data,
                        fill: false,
                        borderColor: '#1e88e5'
                    }
                ]
            };
        });
        this.commandService.getConfirmedAndDeliveredOrdersChartStats('delivered').subscribe(response => {
            this.totalDeliveredOrders = response.totalOrders;
            this.deliveredOrdersData = {
                labels: response.labels,
                datasets: [
                    {
                        label: 'Delivered Orders',
                        data: response.data,
                        fill: false,
                        borderColor: '#43a047'
                    }
                ]
            };
        });

        this.cols = [
            {field: 'id', header: 'Id'},
            {field: 'name', header: 'Name'},
            {field: 'totalOrders', header: 'Total Orders'},
            {field: 'confirmed', header: 'Confirmed'},
            {field: 'delivered', header: 'Delivered'},
            {field: 'return', header: 'Return'}
        ];

        this.deliveryCols = [
            {header: 'Id'},
            {header: 'Name'},
            {header: 'Total Orders'},
            {header: 'Delivered'},
            {header: 'Return'}
        ];

    }

    customSort(event: SortEvent) {
        event.data.sort((data1, data2) => {
            let value1 = data1[event.field];
            let value2 = data2[event.field];
            let result = null;

            if (value1 == null && value2 != null) {
                result = -1;
            } else if (value1 != null && value2 == null) {
                result = 1;
            } else if (value1 == null && value2 == null) {
                result = 0;
            } else if (typeof value1 === 'string' && typeof value2 === 'string') {
                result = value1.localeCompare(value2);
            } else {
                result = (value1 < value2) ? -1 : (value1 > value2) ? 1 : 0;
            }

            return (event.order * result);
        });
    }

    loadCarsLazy(event: LazyLoadEvent) {
        this.loading = true;

        //in a real application, make a remote request to load data using state metadata from event
        //event.first = First row offset
        //event.rows = Number of rows per page
        //event.sortField = Field name to sort with
        //event.sortOrder = Sort order as number, 1 for asc and -1 for dec
        //filters: FilterMetadata object having field as key and filter value, filter matchMode as value

        //imitate db connection over a network
        setTimeout(() => {
            this.productService.getProducts().then(data => this.products = data.slice(event.first, (event.first + event.rows)));
            this.loading = false;
        }, 1000);
    }

    loadDeliveriesLazy(event: LazyLoadEvent) {
        this.loading = true;
        setTimeout(() => {
            this.productService.getDeliveries().then(data => this.deliveryData = data.slice(event.first, (event.first + event.rows)));
            this.loading = false;
        }, 1000);
    }

    loadDeliveryStatsLazy(event: LazyLoadEvent) {
        this.loading = true;
        setTimeout(() => {
            // tslint:disable-next-line:max-line-length
            this.productService.getDeliveryStats().then(data => this.deliveryStatsData = data.slice(event.first, (event.first + event.rows)));
            this.loading = false;
        }, 1000);
    }

    public fetchAnalyticsStats() {
        const startDate = (this.rangeDates[0] as Date).toISOString().substring(0, 10);
        const endDate = (this.rangeDates[1] as Date).toISOString().substring(0, 10);
        return this.commandService.getAnalyticsStats(startDate, endDate).subscribe(data => this.analyticsStats = data);
    }

}
