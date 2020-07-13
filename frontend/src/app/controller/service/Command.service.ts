import {Injectable} from '@angular/core';
import {HttpClient} from '@angular/common/http';
import {CommandVo} from '../model/command.model';
import {UserVo} from '../model/User.model';
import {OrderLineVo} from '../model/OrderLine.model';
import {CityVo} from '../model/City.model';
import {ClientVo} from '../model/Client.model';
import {OrderStatusVo} from '../model/OrderStatus.model';
import {map} from 'rxjs/operators';
import * as moment from 'moment';
import {environment} from '../../../environments/environment';

@Injectable({
    providedIn: 'root'
})
export class CommandService {

    constructor(private http: HttpClient) {
    }

    private _commandDetail: CommandVo = new CommandVo();
    private _commandListe: Array<CommandVo> = new Array<CommandVo>();

    private _commandSearch: CommandVo = new CommandVo();
    private _command: CommandVo = new CommandVo();
    private _searchedCommands: Array<CommandVo> = new Array<CommandVo>();
    private _editableCommands: Array<CommandVo> = new Array<CommandVo>();
    private _deliverys: Array<UserVo> = new Array<UserVo>();
    private _validators: Array<UserVo> = new Array<UserVo>();
    private _admins: Array<UserVo> = new Array<UserVo>();
    private _clients: Array<ClientVo> = new Array<ClientVo>();
    private _orderStatuss: Array<OrderStatusVo> = new Array<OrderStatusVo>();
    private _citys: Array<CityVo> = new Array<CityVo>();
    private _orderLine: OrderLineVo;

    get orderLine(): OrderLineVo {
        if (this._orderLine == null) {
            this._orderLine = new OrderLineVo();
        }
        return this._orderLine;
    }

    set orderLine(value: OrderLineVo) {
        this._orderLine = value;
    }

    get deliverys(): Array<UserVo> {
        return this._deliverys;
    }

    set deliverys(value: Array<UserVo>) {
        this._deliverys = value;
    }

    get validators(): Array<UserVo> {
        return this._validators;
    }

    set validators(value: Array<UserVo>) {
        this._validators = value;
    }

    get admins(): Array<UserVo> {
        return this._admins;
    }

    set admins(value: Array<UserVo>) {
        this._admins = value;
    }

    get clients(): Array<ClientVo> {
        return this._clients;
    }

    set clients(value: Array<ClientVo>) {
        this._clients = value;
    }

    get orderStatuss(): Array<OrderStatusVo> {
        return this._orderStatuss;
    }

    set orderStatuss(value: Array<OrderStatusVo>) {
        this._orderStatuss = value;
    }

    get citys(): Array<CityVo> {
        return this._citys;
    }

    set citys(value: Array<CityVo>) {
        this._citys = value;
    }

    get command(): CommandVo {
        if (this._command == null) {
            this._command = new CommandVo();
        }
        return this._command;
    }

    set command(value: CommandVo) {
        this._command = value;
    }

    get commandListe(): Array<CommandVo> {
        return this._commandListe;
    }

    set commandListe(value: Array<CommandVo>) {
        this._commandListe = value;
    }

    get commandDetail(): CommandVo {
        return this._commandDetail;
    }

    set commandDetail(value: CommandVo) {
        this._commandDetail = value;
    }

    get commandSearch(): CommandVo {
        return this._commandSearch;
    }

    set commandSearch(value: CommandVo) {
        this._commandSearch = value;
    }

    get commandShowDetail(): boolean {
        return this._commandShowDetail;
    }

    set commandShowDetail(value: boolean) {
        this._commandShowDetail = value;
    }

    get editableCommands(): Array<CommandVo> {
        return this._editableCommands;
    }

    set editableCommands(value: Array<CommandVo>) {
        this._editableCommands = value;
    }

    public findAll() {
        this.http.get<Array<CommandVo>>('http://localhost:8036/generated/command/').subscribe(
            value => {
                if (value != null) {
                    this.commandListe = value;
                    this.editableCommands = value;

                }
            }
        );
    }

    public saveCommand() {
        this.http.post('http://localhost:8036/generated/command/', this.command).subscribe();
        this.command.orderLinesVo.length = 0;
    }

    public editCommand() {
        this.http.put('http://localhost:8036/generated/command/', this.command).subscribe();
        this.command.orderLinesVo.length = 0;
    }

    public addOrderLine() {
        this.command.orderLinesVo.push(this.cloneOrderLine(this.orderLine));
    }

    public cloneOrderLine(orderLine: OrderLineVo) {
        const myOrderLineClone = new OrderLineVo();
        myOrderLineClone.price = orderLine.price;
        myOrderLineClone.id = orderLine.id;
        myOrderLineClone.commandVo.reference = orderLine.commandVo.reference;
        7;
        myOrderLineClone.productVo.reference = orderLine.productVo.reference;
        7;
        return myOrderLineClone;
    }

    public removeOrderLine(i: number) {
        this.command.orderLinesVo.splice(i, 1);
    }

    public findCommand(pojo: CommandVo) {
        this.http.post<Array<CommandVo>>('http://localhost:8036/generated/command/search/', pojo).subscribe(
            value => {
                this.commandListe = value;
            });
    }

    public detailShow(pojo: CommandVo) {
        this.http.get<CommandVo>('http://localhost:8036/generated/command/reference/' + pojo.reference).subscribe(
            value => {
                if (value != null) {
                    this.commandDetail = value;
                    this.commandShowDetail = true;
                }
            });
    }


    delete(pojo: CommandVo) {
        this.http.delete<CommandVo>('http://localhost:8036/generated/command/id/' + pojo.id).subscribe(
            value => {
                var index = this.commandListe.indexOf(pojo);
                if (index > -1) {
                    this.commandListe.splice(index, 1);
                }
            }
        );


    }


    public findByreference(ref: string) {
        this.http.get<CommandVo>('http://localhost:8036/generated/command/reference/' + ref).subscribe(
            value => {
                if (value != null) {
                    this.command = value;
                }
            }
        );
    }

    public findAlldeliverys() {
        this.http.get<Array<UserVo>>('http://localhost:8036/generated/user/').subscribe(
            value => {
                if (value != null) {
                    this.deliverys = value;
                }
            }
        );
    }

    public findAllvalidators() {
        this.http.get<Array<UserVo>>('http://localhost:8036/generated/user/').subscribe(
            value => {
                if (value != null) {
                    this.validators = value;
                }
            }
        );
    }

    public findAlladmins() {
        this.http.get<Array<UserVo>>('http://localhost:8036/generated/user/').subscribe(
            value => {
                if (value != null) {
                    this.admins = value;
                }
            }
        );
    }

    public findAllclients() {
        this.http.get<Array<ClientVo>>('http://localhost:8036/generated/client/').subscribe(
            value => {
                if (value != null) {
                    this.clients = value;
                }
            }
        );
    }

    public findAllorderStatuss() {
        this.http.get<Array<OrderStatusVo>>('http://localhost:8036/generated/orderStatus/').subscribe(
            value => {
                if (value != null) {
                    this.orderStatuss = value;
                }
            }
        );
    }

    public findAllcitys() {
        this.http.get<Array<CityVo>>('http://localhost:8036/generated/city/').subscribe(
            value => {
                if (value != null) {
                    this.citys = value;
                }
            }
        );
    }
    /***********************************************************************************************/
    private _commandShowDetail: boolean;

    public detailHide() {

        this.commandShowDetail = false;
        this.commandDetail = null;
    }

    public getDashboardStats() {
        return this.http.get<any>(`${environment.apiUrl}command/dashboard/`).pipe(map((dashboardStats: CommandVo) => ({
                totalSalesCurrentDay: dashboardStats.totalSalesCurrentDay,
                totalConfirmedCurrentDay: dashboardStats.totalConfirmedCurrentDay,
                totalClosedCurrentDay: dashboardStats.totalClosedCurrentDay,
                totalCommandsSales: dashboardStats.totalCommandsSales,
                totalValidator: dashboardStats.totalValidator,
                totalDelivery: dashboardStats.totalDelivery,
                confirmedCommands: dashboardStats.confirmedCommands,
                totalConfirmedCommands: dashboardStats.totalConfirmedCommands,
                returnedCommands: dashboardStats.returnedCommands,
                closedCommands: dashboardStats.closedCommands,
                totalClosedCommands: dashboardStats.totalClosedCommands,
                processedCommand: dashboardStats.processedCommand
            })
        ));
    }

    public getStatsOfYear() {
        return this.http.get<any[]>(`${environment.apiUrl}command/statisticsOfYear/`).pipe(
            map((dashboardStats: any[]) => ({
                    data: moment.months().map((_, index) => dashboardStats.find((value) => (value.month - 1) === index)?.totalInMonth | 0)
                })
            )
        );
    }

    public getAnalyticsStats(startDate: string, endDate: string) {
        return this.http.get<any>(`${environment.apiUrl}command/totalAmount/startDate/${startDate}/endDate/${endDate}/`).pipe(
            map((commandVo: CommandVo) => ({
                    totalCommandsConfirmed: commandVo.totalCommandsConfirmed,
                    totalCommandsPaid: commandVo.totalCommandsPaid,
                    totalCommandsDelivred: commandVo.totalCommandsDelivred,
                    totalCommands: commandVo.totalCommands
                })
            )
        );
    }

    public getTotalOrdersChartStats() {
        return this.http.get<any[]>(`${environment.apiUrl}command/totalStatistics`).pipe(
            map((commandVos: CommandVo[]) => ({
                    totalOrders: commandVos.reduce((sum, currentCommand) => sum + currentCommand.totalCommandInDay, 0),
                    labels: this.last7Days().map(mmt => moment.months(mmt.get('months')) + ' ' + mmt.get('D')),
                    data: this.last7Days().map(mmt => commandVos.find((v) => v.day === mmt.get('D') && v.month === (mmt.get('months') + 1))?.totalCommandInDay | 0)
                })
            )
        );
    }

    public getConfirmedAndDeliveredOrdersChartStats(status: string) {
        return this.http.get<any[]>(`${environment.apiUrl}command/status/${status}`).pipe(
            map((commandVos: CommandVo[]) => ({
                    totalOrders: commandVos.reduce((sum, currentCommand) => sum + currentCommand.totalCommandInDay, 0),
                    labels: this.last7Days().map(mmt => moment.months(mmt.get('months')) + ' ' + mmt.get('D')),
                    data: this.last7Days().map(mmt => commandVos.find((v) => v.day === mmt.get('D') && v.month === (mmt.get('months') + 1))?.totalCommandInDay | 0)
                })
            )
        );
    }

    last7Days() {
        return '6,5,4,3,2,1,0'.split(',').map(day => moment().subtract(Number.parseInt(day), 'days'));
    }
}
