import {Injectable} from '@angular/core';
import {HttpClient} from '@angular/common/http';
import {CityVo} from '../model/city.model';
import {environment} from '../../../environments/environment';
import {map} from 'rxjs/operators';

@Injectable({
    providedIn: 'root'
})
export class CityService {

    constructor(private http: HttpClient) {
    }

    private _cityDetail: CityVo = new CityVo();
    private _cityListe: Array<CityVo> = new Array<CityVo>();

    private _citySearch: CityVo = new CityVo();
    private _city: CityVo = new CityVo();
    private _searchedCitys: Array<CityVo> = new Array<CityVo>();
    private _editableCitys: Array<CityVo> = new Array<CityVo>();

    get city(): CityVo {
        if (this._city == null) {
            this._city = new CityVo();
        }
        return this._city;
    }

    set city(value: CityVo) {
        this._city = value;
    }

    get cityListe(): Array<CityVo> {
        return this._cityListe;
    }

    set cityListe(value: Array<CityVo>) {
        this._cityListe = value;
    }

    get cityDetail(): CityVo {
        return this._cityDetail;
    }

    set cityDetail(value: CityVo) {
        this._cityDetail = value;
    }

    get citySearch(): CityVo {
        return this._citySearch;
    }

    set citySearch(value: CityVo) {
        this._citySearch = value;
    }

    get cityShowDetail(): boolean {
        return this._cityShowDetail;
    }

    set cityShowDetail(value: boolean) {
        this._cityShowDetail = value;
    }

    get editableCitys(): Array<CityVo> {
        return this._editableCitys;
    }

    set editableCitys(value: Array<CityVo>) {
        this._editableCitys = value;
    }

    public findAll() {
        this.http.get<Array<CityVo>>('http://localhost:8036/generated/city/').subscribe(
            value => {
                if (value != null) {
                    this.cityListe = value;
                    this.editableCitys = value;

                }
            }
        );
    }

    public saveCity() {
        this.http.post('http://localhost:8036/generated/city/', this.city).subscribe();
        this.findAll();
    }

    public editCity() {
        this.http.put('http://localhost:8036/generated/city/', this.city).subscribe();
        this.findAll();
    }

    public findCity(pojo: CityVo) {
        this.http.post<Array<CityVo>>('http://localhost:8036/generated/city/search/', pojo).subscribe(
            value => {
                this.cityListe = value;
            });
    }

    public detailShow(pojo: CityVo) {
        this.http.get<CityVo>('http://localhost:8036/generated/city/name/' + pojo.name).subscribe(
            value => {
                if (value != null) {
                    this.cityDetail = value;
                    this.cityShowDetail = true;
                }
            });
    }


    delete(pojo: CityVo) {
        this.http.delete<CityVo>('http://localhost:8036/generated/city/id/' + pojo.id).subscribe(
            value => {
                var index = this.cityListe.indexOf(pojo);
                if (index > -1) {
                    this.cityListe.splice(index, 1);
                }
            }
        );


    }


    public findByname(ref: string) {
        this.http.get<CityVo>('http://localhost:8036/generated/city/name/' + ref).subscribe(
            value => {
                if (value != null) {
                    this.city = value;
                }
            }
        );
    }


    /***********************************************************************************************/
    private _cityShowDetail: boolean;

    public detailHide() {

        this.cityShowDetail = false;
        this.cityDetail = null;
    }

    private _cityShowEdit: boolean;

    private _cityShowCreate: boolean;

    get cityShowEdit(): boolean {
        return this._cityShowEdit;
    }

    set cityShowEdit(value: boolean) {
        this._cityShowEdit = value;
    }

    get cityShowCreate(): boolean {
        return this._cityShowCreate;
    }

    set cityShowCreate(value: boolean) {
        this._cityShowCreate = value;
    }

    public editShow(pojo: CityVo) {

        this.cityShowEdit = true;
        this.city = pojo;
    }

    public editHide() {

        this.cityShowEdit = false;
        this.city = new CityVo();
    }

    public createShow() {

        this.cityShowCreate = true;
        this.city = new CityVo();
    }

    public createHide() {

        this.cityShowCreate = false;
        this.city = new CityVo();
    }

    getTopCities(startDate: string, endDate: string) {
        return this.http.get<any[]>(`${environment.apiUrl}city/startDate/${startDate}/endDate/${endDate}/`).pipe(
            map((cityVos: CityVo[]) =>
                cityVos.map((cityVo) =>
                    ({ name: cityVo.name, totalCommands: cityVo.totalCommands })
                )
            )
        );
    }
}
