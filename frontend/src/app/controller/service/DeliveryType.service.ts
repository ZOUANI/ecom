import { Injectable } from '@angular/core';
import {HttpClient} from '@angular/common/http';
import {DeliveryTypeVo} from '../model/deliveryType.model';
@Injectable({
  providedIn: 'root'
})
export class DeliveryTypeService {

  constructor(private http: HttpClient) { }
  private _deliveryTypeDetail : DeliveryTypeVo =  new DeliveryTypeVo() ;
  private _deliveryTypeListe  : Array<DeliveryTypeVo> = new Array<DeliveryTypeVo>();
  
  private _deliveryTypeSearch : DeliveryTypeVo = new DeliveryTypeVo();
  private _deliveryType: DeliveryTypeVo =  new DeliveryTypeVo();
  private _searchedDeliveryTypes: Array<DeliveryTypeVo> = new Array<DeliveryTypeVo>();
  private _editableDeliveryTypes: Array<DeliveryTypeVo> = new Array<DeliveryTypeVo>();

  get deliveryType(): DeliveryTypeVo {
    if (this._deliveryType == null) {
      this._deliveryType = new DeliveryTypeVo();
    }
    return this._deliveryType;
  }

  set deliveryType(value: DeliveryTypeVo) {
    this._deliveryType = value;
  }

  get deliveryTypeListe (): Array<DeliveryTypeVo> {
  return this._deliveryTypeListe;
}

set deliveryTypeListe (value: Array<DeliveryTypeVo>) {
  this._deliveryTypeListe = value ;
}

get deliveryTypeDetail (): DeliveryTypeVo {
  return this._deliveryTypeDetail;
}

set deliveryTypeDetail (value: DeliveryTypeVo) {
  this._deliveryTypeDetail = value ;
}

get deliveryTypeSearch (): DeliveryTypeVo {
  return this._deliveryTypeSearch;
}

set deliveryTypeSearch (value: DeliveryTypeVo) {
  this._deliveryTypeSearch = value ;
}

get deliveryTypeShowDetail (): boolean  {
  return this._deliveryTypeShowDetail;
}

set deliveryTypeShowDetail (value: boolean ) {
  this._deliveryTypeShowDetail = value ;
}

  get editableDeliveryTypes (): Array<DeliveryTypeVo> {
   return this._editableDeliveryTypes;
  }

  set editableDeliveryTypes (value: Array<DeliveryTypeVo>) {
   this._editableDeliveryTypes = value;
  }

  public findAll(){
  this.http.get<Array<DeliveryTypeVo>>('http://localhost:8036/generated/deliveryType/').subscribe(
    value => {
      if (value != null) {
           this.deliveryTypeListe = value;
           this.editableDeliveryTypes = value;
                                                 
      }
    }
  );
}

  public saveDeliveryType() {
  this.http.post('http://localhost:8036/generated/deliveryType/', this.deliveryType).subscribe();
  this.findAll();
  }

  public editDeliveryType() {
  this.http.put('http://localhost:8036/generated/deliveryType/', this.deliveryType).subscribe();
        this.findAll();
  }

   public findDeliveryType ( pojo : DeliveryTypeVo ){
  this.http.post<Array<DeliveryTypeVo>>('http://localhost:8036/generated/deliveryType/search/', pojo).subscribe(
    value =>{
       this.deliveryTypeListe = value;  
    } );
}

public detailShow ( pojo : DeliveryTypeVo ){
  this.http.get<DeliveryTypeVo>('http://localhost:8036/generated/deliveryType/label/'+pojo.label).subscribe(
    value =>{
     if (value != null) { this.deliveryTypeDetail = value;
        this.deliveryTypeShowDetail = true;		}
    } );
}



delete(pojo: DeliveryTypeVo) {
   this.http.delete<DeliveryTypeVo>('http://localhost:8036/generated/deliveryType/id/'+pojo.id).subscribe(
        value => {
        var index = this.deliveryTypeListe.indexOf(pojo);
if (index > -1) {
   this.deliveryTypeListe.splice(index, 1);
}
}
        );


}


       public findBylabel(ref: string) {
      this.http.get<DeliveryTypeVo>('http://localhost:8036/generated/deliveryType/label/' + ref).subscribe(
        value => {
        if (value != null) { this.deliveryType = value; }
        }
        );
        }



          /***********************************************************************************************/
        private _deliveryTypeShowDetail : boolean;
              public detailHide (){

       this.deliveryTypeShowDetail = false;
       this.deliveryTypeDetail = null;
                                  }
 private _deliveryTypeShowEdit : boolean;

 private _deliveryTypeShowCreate : boolean;

get deliveryTypeShowEdit (): boolean  {
  return this._deliveryTypeShowEdit;
}

set deliveryTypeShowEdit (value: boolean ) {
  this._deliveryTypeShowEdit = value ;
}
get deliveryTypeShowCreate (): boolean  {
  return this._deliveryTypeShowCreate;
}

set deliveryTypeShowCreate (value: boolean ) {
  this._deliveryTypeShowCreate = value ;
}
             public editShow(pojo : DeliveryTypeVo ){

       this.deliveryTypeShowEdit = true;
       this.deliveryType = pojo;
                                  }

              public editHide (){

       this.deliveryTypeShowEdit = false;
       this.deliveryType = new DeliveryTypeVo();
                                  }

               public createShow(){

       this.deliveryTypeShowCreate = true;
       this.deliveryType = new DeliveryTypeVo();
                                  }

              public createHide (){

       this.deliveryTypeShowCreate = false;
       this.deliveryType = new DeliveryTypeVo();
                                  }
}