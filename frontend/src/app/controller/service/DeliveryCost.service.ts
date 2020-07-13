import { Injectable } from '@angular/core';
import {HttpClient} from '@angular/common/http';
import {DeliveryCostVo} from '../model/deliveryCost.model';
import {UserVo} from '../model/User.model';
import {CityVo} from '../model/City.model';
@Injectable({
  providedIn: 'root'
})
export class DeliveryCostService {

  constructor(private http: HttpClient) { }
  private _deliveryCostDetail : DeliveryCostVo =  new DeliveryCostVo() ;
  private _deliveryCostListe  : Array<DeliveryCostVo> = new Array<DeliveryCostVo>();
  
  private _deliveryCostSearch : DeliveryCostVo = new DeliveryCostVo();
  private _deliveryCost: DeliveryCostVo =  new DeliveryCostVo();
  private _searchedDeliveryCosts: Array<DeliveryCostVo> = new Array<DeliveryCostVo>();
  private _editableDeliveryCosts: Array<DeliveryCostVo> = new Array<DeliveryCostVo>();
  private _citys: Array<CityVo> = new Array<CityVo>();
  private _deliverys: Array<UserVo> = new Array<UserVo>();
   get citys(): Array<CityVo> {
    return this._citys;
   }

   set citys(value: Array<CityVo>) {
    this._citys = value;
   }
   get deliverys(): Array<UserVo> {
    return this._deliverys;
   }

   set deliverys(value: Array<UserVo>) {
    this._deliverys = value;
   }

  get deliveryCost(): DeliveryCostVo {
    if (this._deliveryCost == null) {
      this._deliveryCost = new DeliveryCostVo();
    }
    return this._deliveryCost;
  }

  set deliveryCost(value: DeliveryCostVo) {
    this._deliveryCost = value;
  }

  get deliveryCostListe (): Array<DeliveryCostVo> {
  return this._deliveryCostListe;
}

set deliveryCostListe (value: Array<DeliveryCostVo>) {
  this._deliveryCostListe = value ;
}

get deliveryCostDetail (): DeliveryCostVo {
  return this._deliveryCostDetail;
}

set deliveryCostDetail (value: DeliveryCostVo) {
  this._deliveryCostDetail = value ;
}

get deliveryCostSearch (): DeliveryCostVo {
  return this._deliveryCostSearch;
}

set deliveryCostSearch (value: DeliveryCostVo) {
  this._deliveryCostSearch = value ;
}

get deliveryCostShowDetail (): boolean  {
  return this._deliveryCostShowDetail;
}

set deliveryCostShowDetail (value: boolean ) {
  this._deliveryCostShowDetail = value ;
}

  get editableDeliveryCosts (): Array<DeliveryCostVo> {
   return this._editableDeliveryCosts;
  }

  set editableDeliveryCosts (value: Array<DeliveryCostVo>) {
   this._editableDeliveryCosts = value;
  }

  public findAll(){
  this.http.get<Array<DeliveryCostVo>>('http://localhost:8036/generated/deliveryCost/').subscribe(
    value => {
      if (value != null) {
           this.deliveryCostListe = value;
           this.editableDeliveryCosts = value;
                                                 
      }
    }
  );
}

  public saveDeliveryCost() {
  this.http.post('http://localhost:8036/generated/deliveryCost/', this.deliveryCost).subscribe();
  this.findAll();
  }

  public editDeliveryCost() {
  this.http.put('http://localhost:8036/generated/deliveryCost/', this.deliveryCost).subscribe();
        this.findAll();
  }

   public findDeliveryCost ( pojo : DeliveryCostVo ){
  this.http.post<Array<DeliveryCostVo>>('http://localhost:8036/generated/deliveryCost/search/', pojo).subscribe(
    value =>{
       this.deliveryCostListe = value;  
    } );
}

public detailShow ( pojo : DeliveryCostVo ){
  this.http.get<DeliveryCostVo>('http://localhost:8036/generated/deliveryCost/id/'+pojo.id).subscribe(
    value =>{
     if (value != null) { this.deliveryCostDetail = value;
        this.deliveryCostShowDetail = true;		}
    } );
}



delete(pojo: DeliveryCostVo) {
   this.http.delete<DeliveryCostVo>('http://localhost:8036/generated/deliveryCost/id/'+pojo.id).subscribe(
        value => {
        var index = this.deliveryCostListe.indexOf(pojo);
if (index > -1) {
   this.deliveryCostListe.splice(index, 1);
}
}
        );


}


        public findByid(identifier: string) {
        this.http.get<DeliveryCostVo>('http://localhost:8036/generated/deliveryCost/id/' + identifier).subscribe(
          value => {
          if (value != null) { this.deliveryCost = value; }
          }
          );
          }

            public findAllcitys() {
             this.http.get<Array<CityVo>>('http://localhost:8036/generated/city/').subscribe(
            value => {
            if (value != null) { this.citys = value; }
            }
            );
            }
            public findAlldeliverys() {
             this.http.get<Array<UserVo>>('http://localhost:8036/generated/user/').subscribe(
            value => {
            if (value != null) { this.deliverys = value; }
            }
            );
            }


          /***********************************************************************************************/
        private _deliveryCostShowDetail : boolean;
              public detailHide (){

       this.deliveryCostShowDetail = false;
       this.deliveryCostDetail = null;
                                  }
 private _deliveryCostShowEdit : boolean;

 private _deliveryCostShowCreate : boolean;

get deliveryCostShowEdit (): boolean  {
  return this._deliveryCostShowEdit;
}

set deliveryCostShowEdit (value: boolean ) {
  this._deliveryCostShowEdit = value ;
}
get deliveryCostShowCreate (): boolean  {
  return this._deliveryCostShowCreate;
}

set deliveryCostShowCreate (value: boolean ) {
  this._deliveryCostShowCreate = value ;
}
             public editShow(pojo : DeliveryCostVo ){

       this.deliveryCostShowEdit = true;
       this.deliveryCost = pojo;
                                  }

              public editHide (){

       this.deliveryCostShowEdit = false;
       this.deliveryCost = new DeliveryCostVo();
                                  }

               public createShow(){

       this.deliveryCostShowCreate = true;
       this.deliveryCost = new DeliveryCostVo();
                                  }

              public createHide (){

       this.deliveryCostShowCreate = false;
       this.deliveryCost = new DeliveryCostVo();
                                  }
}