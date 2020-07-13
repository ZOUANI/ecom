import {Injectable} from '@angular/core';
import {HttpClient} from '@angular/common/http';
import {ClientVo} from '../model/client.model';
import {CommandVo} from '../model/Command.model';
import {CityVo} from '../model/City.model';
import {map} from 'rxjs/operators';
import {environment} from '../../../environments/environment';

@Injectable({
    providedIn: 'root'
})
export class ClientService {

    constructor(private http: HttpClient) {
    }

    private _clientDetail: ClientVo = new ClientVo();
    private _clientListe: Array<ClientVo> = new Array<ClientVo>();

    private _clientSearch: ClientVo = new ClientVo();
    private _client: ClientVo = new ClientVo();
    private _searchedClients: Array<ClientVo> = new Array<ClientVo>();
    private _editableClients: Array<ClientVo> = new Array<ClientVo>();
    private _citys: Array<CityVo> = new Array<CityVo>();
    private _command: CommandVo;

    get command(): CommandVo {
        if (this._command == null) {
            this._command = new CommandVo();
        }
        return this._command;
    }

    set command(value: CommandVo) {
        this._command = value;
    }

    get citys(): Array<CityVo> {
        return this._citys;
    }

    set citys(value: Array<CityVo>) {
        this._citys = value;
    }

    get client(): ClientVo {
        if (this._client == null) {
            this._client = new ClientVo();
        }
        return this._client;
    }

    set client(value: ClientVo) {
        this._client = value;
    }

    get clientListe(): Array<ClientVo> {
        return this._clientListe;
    }

    set clientListe(value: Array<ClientVo>) {
        this._clientListe = value;
    }

    get clientDetail(): ClientVo {
        return this._clientDetail;
    }

    set clientDetail(value: ClientVo) {
        this._clientDetail = value;
    }

    get clientSearch(): ClientVo {
        return this._clientSearch;
    }

    set clientSearch(value: ClientVo) {
        this._clientSearch = value;
    }

    get clientShowDetail(): boolean {
        return this._clientShowDetail;
    }

    set clientShowDetail(value: boolean) {
        this._clientShowDetail = value;
    }

    get editableClients(): Array<ClientVo> {
        return this._editableClients;
    }

    set editableClients(value: Array<ClientVo>) {
        this._editableClients = value;
    }

    public findAll() {
        this.http.get<Array<ClientVo>>('http://localhost:8036/generated/client/').subscribe(
            value => {
                if (value != null) {
                    this.clientListe = value;
                    this.editableClients = value;

                }
            }
        );
    }

    public saveClient() {
        this.http.post('http://localhost:8036/generated/client/', this.client).subscribe();
        this.client.commandsVo.length = 0;
    }

    public editClient() {
        this.http.put('http://localhost:8036/generated/client/', this.client).subscribe();
        this.client.commandsVo.length = 0;
    }

    public addCommand() {
        this.client.commandsVo.push(this.cloneCommand(this.command));
    }

    public cloneCommand(command: CommandVo) {
        const myCommandClone = new CommandVo();
        myCommandClone.total = command.total;
        myCommandClone.regulationDate = command.regulationDate;
        myCommandClone.adress = command.adress;
        myCommandClone.reference = command.reference;
        myCommandClone.remarque = command.remarque;
        myCommandClone.orderDate = command.orderDate;
        myCommandClone.id = command.id;
        myCommandClone.deliveryVo.code = command.deliveryVo.code;
        7;
        myCommandClone.validatorVo.code = command.validatorVo.code;
        7;
        myCommandClone.adminVo.code = command.adminVo.code;
        7;
        myCommandClone.clientVo.id = command.clientVo.id;
        myCommandClone.orderStatusVo.label = command.orderStatusVo.label;
        7;
        myCommandClone.cityVo.name = command.cityVo.name;
        7;
        return myCommandClone;
    }

    public removeCommand(i: number) {
        this.client.commandsVo.splice(i, 1);
    }

    public findClient(pojo: ClientVo) {
        this.http.post<Array<ClientVo>>('http://localhost:8036/generated/client/search/', pojo).subscribe(
            value => {
                this.clientListe = value;
            });
    }

    public detailShow(pojo: ClientVo) {
        this.http.get<ClientVo>('http://localhost:8036/generated/client/id/' + pojo.id).subscribe(
            value => {
                if (value != null) {
                    this.clientDetail = value;
                    this.clientShowDetail = true;
                }
            });
    }


    delete(pojo: ClientVo) {
        this.http.delete<ClientVo>('http://localhost:8036/generated/client/id/' + pojo.id).subscribe(
            value => {
                var index = this.clientListe.indexOf(pojo);
                if (index > -1) {
                    this.clientListe.splice(index, 1);
                }
            }
        );


    }


    public findByid(identifier: string) {
        this.http.get<ClientVo>('http://localhost:8036/generated/client/id/' + identifier).subscribe(
            value => {
                if (value != null) {
                    this.client = value;
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
    private _clientShowDetail: boolean;

    public detailHide() {

        this.clientShowDetail = false;
        this.clientDetail = null;
    }

    getTopCustomers(startDate: string, endDate: string) {
        return this.http.get<any[]>(`${environment.apiUrl}client/startDate/${startDate}/endDate/${endDate}/`).pipe(
            map((customerVos: ClientVo[]) =>
                customerVos.map((customerVo) =>
                    ({ lastName: customerVo.lastName, totalCommands: customerVo.totalCommands, sales: customerVo.sales })
                )
            )
        );
    }
}
