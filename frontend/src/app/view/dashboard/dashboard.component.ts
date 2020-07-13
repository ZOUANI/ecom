import {Component, OnInit} from '@angular/core';
import {CommandService} from '../../controller/service/command.service';
import {ProductService} from '../../controller/service/product.service';
import {UserService} from '../../controller/service/user.service';
import {CityService} from '../../controller/service/city.service';
import {ClientService} from '../../controller/service/client.service';
import * as moment from 'moment';

@Component({
    selector: 'app-dashboard',
    templateUrl: './dashboard.component.html',
    styleUrls: ['./dashboard.component.css']
})
export class DashboardComponent implements OnInit {

    dashboardStats: any = {};
    charCommandsData: any;
    rangeDates: any;
    data: any;
    topProducts: { label: any; units: any; sales: any; price: any; }[];
    topCustomers: { lastName: string; totalCommands: number; sales: number; }[];
    topDeliveredCompanies: { lastName: string; totalCommands: number; }[];
    topCities: { name: string; totalCommands: number; }[];
    user: any;

    constructor(
        private commandService: CommandService,
        private productService: ProductService,
        private clientService: ClientService,
        private userService: UserService,
        private cityService: CityService
    ) {
    }

    ngOnInit(): void {
        this.user = JSON.parse(localStorage.getItem('user'));
        this.commandService.getStatsOfYear().subscribe(response => {
            this.charCommandsData = response.data;
            this.data = {
                labels: moment.months(),
                datasets: [
                    {
                        label: 'Total Sales',
                        backgroundColor: '#42A5F5',
                        borderColor: '#1E88E5',
                        data: this.charCommandsData
                    },
                ]
            };
        });

        this.commandService.getDashboardStats().subscribe((data) => this.dashboardStats = data);
    }

    fetchTopStats() {
        const startDate = (this.rangeDates[0] as Date).toISOString().substring(0, 10);
        const endDate = (this.rangeDates[1] as Date).toISOString().substring(0, 10);
        this.productService.getTopProducts(startDate, endDate).subscribe(data => this.topProducts = data);
        this.clientService.getTopCustomers(startDate, endDate).subscribe(data => this.topCustomers = data);
        this.userService.getTopDeliveryCompanies(startDate, endDate).subscribe(data => this.topDeliveredCompanies = data);
        this.cityService.getTopCities(startDate, endDate).subscribe(data => this.topCities = data);
    }

    currentYear() {
        return new Date().getFullYear();
    }
}
