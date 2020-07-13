import {Injectable} from '@angular/core';
import {HttpClient} from '@angular/common/http';
import {UserVo} from '../model/user.model';
import {RoleVo} from '../model/Role.model';
import {CityVo} from '../model/City.model';
import {DeliveryTypeVo} from '../model/DeliveryType.model';
import {map} from 'rxjs/operators';
import {environment} from '../../../environments/environment';

@Injectable({
    providedIn: 'root'
})
export class UserService {

    constructor(private http: HttpClient) {
    }

    private _userDetail: UserVo = new UserVo();
    private _userListe: Array<UserVo> = new Array<UserVo>();

    private _userSearch: UserVo = new UserVo();
    private _user: UserVo = new UserVo();
    private _searchedUsers: Array<UserVo> = new Array<UserVo>();
    private _editableUsers: Array<UserVo> = new Array<UserVo>();
    private _superAdmins: Array<UserVo> = new Array<UserVo>();
    private _deliveryTypes: Array<DeliveryTypeVo> = new Array<DeliveryTypeVo>();
    private _citys: Array<CityVo> = new Array<CityVo>();
    private _authoritys: Array<RoleVo> = new Array<RoleVo>();

    get superAdmins(): Array<UserVo> {
        return this._superAdmins;
    }

    set superAdmins(value: Array<UserVo>) {
        this._superAdmins = value;
    }

    get deliveryTypes(): Array<DeliveryTypeVo> {
        return this._deliveryTypes;
    }

    set deliveryTypes(value: Array<DeliveryTypeVo>) {
        this._deliveryTypes = value;
    }

    get citys(): Array<CityVo> {
        return this._citys;
    }

    set citys(value: Array<CityVo>) {
        this._citys = value;
    }

    get authoritys(): Array<RoleVo> {
        return this._authoritys;
    }

    set authoritys(value: Array<RoleVo>) {
        this._authoritys = value;
    }

    get user(): UserVo {
        if (this._user == null) {
            this._user = new UserVo();
        }
        return this._user;
    }

    set user(value: UserVo) {
        this._user = value;
    }

    get userListe(): Array<UserVo> {
        return this._userListe;
    }

    set userListe(value: Array<UserVo>) {
        this._userListe = value;
    }

    get userDetail(): UserVo {
        return this._userDetail;
    }

    set userDetail(value: UserVo) {
        this._userDetail = value;
    }

    get userSearch(): UserVo {
        return this._userSearch;
    }

    set userSearch(value: UserVo) {
        this._userSearch = value;
    }

    get userShowDetail(): boolean {
        return this._userShowDetail;
    }

    set userShowDetail(value: boolean) {
        this._userShowDetail = value;
    }

    get editableUsers(): Array<UserVo> {
        return this._editableUsers;
    }

    set editableUsers(value: Array<UserVo>) {
        this._editableUsers = value;
    }

    public findAll() {
        this.http.get<Array<UserVo>>('http://localhost:8036/generated/user/').subscribe(
            value => {
                if (value != null) {
                    this.userListe = value;
                    this.editableUsers = value;

                }
            }
        );
    }

    public saveUser() {
        this.http.post('http://localhost:8036/generated/user/', this.user).subscribe();
    }

    public editUser() {
        this.http.put('http://localhost:8036/generated/user/', this.user).subscribe();
    }

    public findUser(pojo: UserVo) {
        this.http.post<Array<UserVo>>('http://localhost:8036/generated/user/search/', pojo).subscribe(
            value => {
                this.userListe = value;
            });
    }

    public detailShow(pojo: UserVo) {
        this.http.get<UserVo>('http://localhost:8036/generated/user/code/' + pojo.code).subscribe(
            value => {
                if (value != null) {
                    this.userDetail = value;
                    this.userShowDetail = true;
                }
            });
    }


    delete(pojo: UserVo) {
        this.http.delete<UserVo>('http://localhost:8036/generated/user/id/' + pojo.id).subscribe(
            value => {
                var index = this.userListe.indexOf(pojo);
                if (index > -1) {
                    this.userListe.splice(index, 1);
                }
            }
        );


    }


    public findBycode(ref: string) {
        this.http.get<UserVo>('http://localhost:8036/generated/user/code/' + ref).subscribe(
            value => {
                if (value != null) {
                    this.user = value;
                }
            }
        );
    }

    public findAllsuperAdmins() {
        this.http.get<Array<UserVo>>('http://localhost:8036/generated/user/').subscribe(
            value => {
                if (value != null) {
                    this.superAdmins = value;
                }
            }
        );
    }

    public findAlldeliveryTypes() {
        this.http.get<Array<DeliveryTypeVo>>('http://localhost:8036/generated/deliveryType/').subscribe(
            value => {
                if (value != null) {
                    this.deliveryTypes = value;
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

    public findAllauthoritys() {
        this.http.get<Array<RoleVo>>('http://localhost:8036/generated/role/').subscribe(
            value => {
                if (value != null) {
                    this.authoritys = value;
                }
            }
        );
    }


    /***********************************************************************************************/
    private _userShowDetail: boolean;

    public detailHide() {
        this.userShowDetail = false;
        this.userDetail = null;
    }

    getTopDeliveryCompanies(startDate: string, endDate: string) {
        return this.http.get<any[]>(`${environment.apiUrl}user/top5/startDate/${startDate}/endDate/${endDate}/`).pipe(
            map((userVos: UserVo[]) =>
                userVos.map(userVo =>
                    ({lastName: userVo.lastName, totalCommands: userVo.totalCommandDelivered})
                )
            )
        );
    }
}
