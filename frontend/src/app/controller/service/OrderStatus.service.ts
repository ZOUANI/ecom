import { Injectable } from '@angular/core';
import {HttpClient} from '@angular/common/http';
import {OrderStatusVo} from '../model/orderStatus.model';
@Injectable({
  providedIn: 'root'
})
export class OrderStatusService {

  constructor(private http: HttpClient) { }
  private _orderStatusDetail : OrderStatusVo =  new OrderStatusVo() ;
  private _orderStatusListe  : Array<OrderStatusVo> = new Array<OrderStatusVo>();
  
  private _orderStatusSearch : OrderStatusVo = new OrderStatusVo();
  private _orderStatus: OrderStatusVo =  new OrderStatusVo();
  private _searchedOrderStatuss: Array<OrderStatusVo> = new Array<OrderStatusVo>();
  private _editableOrderStatuss: Array<OrderStatusVo> = new Array<OrderStatusVo>();

  get orderStatus(): OrderStatusVo {
    if (this._orderStatus == null) {
      this._orderStatus = new OrderStatusVo();
    }
    return this._orderStatus;
  }

  set orderStatus(value: OrderStatusVo) {
    this._orderStatus = value;
  }

  get orderStatusListe (): Array<OrderStatusVo> {
  return this._orderStatusListe;
}

set orderStatusListe (value: Array<OrderStatusVo>) {
  this._orderStatusListe = value ;
}

get orderStatusDetail (): OrderStatusVo {
  return this._orderStatusDetail;
}

set orderStatusDetail (value: OrderStatusVo) {
  this._orderStatusDetail = value ;
}

get orderStatusSearch (): OrderStatusVo {
  return this._orderStatusSearch;
}

set orderStatusSearch (value: OrderStatusVo) {
  this._orderStatusSearch = value ;
}

get orderStatusShowDetail (): boolean  {
  return this._orderStatusShowDetail;
}

set orderStatusShowDetail (value: boolean ) {
  this._orderStatusShowDetail = value ;
}

  get editableOrderStatuss (): Array<OrderStatusVo> {
   return this._editableOrderStatuss;
  }

  set editableOrderStatuss (value: Array<OrderStatusVo>) {
   this._editableOrderStatuss = value;
  }

  public findAll(){
  this.http.get<Array<OrderStatusVo>>('http://localhost:8036/generated/orderStatus/').subscribe(
    value => {
      if (value != null) {
           this.orderStatusListe = value;
           this.editableOrderStatuss = value;
                                                 
      }
    }
  );
}

  public saveOrderStatus() {
  this.http.post('http://localhost:8036/generated/orderStatus/', this.orderStatus).subscribe();
  this.findAll();
  }

  public editOrderStatus() {
  this.http.put('http://localhost:8036/generated/orderStatus/', this.orderStatus).subscribe();
        this.findAll();
  }

   public findOrderStatus ( pojo : OrderStatusVo ){
  this.http.post<Array<OrderStatusVo>>('http://localhost:8036/generated/orderStatus/search/', pojo).subscribe(
    value =>{
       this.orderStatusListe = value;  
    } );
}

public detailShow ( pojo : OrderStatusVo ){
  this.http.get<OrderStatusVo>('http://localhost:8036/generated/orderStatus/label/'+pojo.label).subscribe(
    value =>{
     if (value != null) { this.orderStatusDetail = value;
        this.orderStatusShowDetail = true;		}
    } );
}



delete(pojo: OrderStatusVo) {
   this.http.delete<OrderStatusVo>('http://localhost:8036/generated/orderStatus/id/'+pojo.id).subscribe(
        value => {
        var index = this.orderStatusListe.indexOf(pojo);
if (index > -1) {
   this.orderStatusListe.splice(index, 1);
}
}
        );


}


       public findBylabel(ref: string) {
      this.http.get<OrderStatusVo>('http://localhost:8036/generated/orderStatus/label/' + ref).subscribe(
        value => {
        if (value != null) { this.orderStatus = value; }
        }
        );
        }



          /***********************************************************************************************/
        private _orderStatusShowDetail : boolean;
              public detailHide (){

       this.orderStatusShowDetail = false;
       this.orderStatusDetail = null;
                                  }
 private _orderStatusShowEdit : boolean;

 private _orderStatusShowCreate : boolean;

get orderStatusShowEdit (): boolean  {
  return this._orderStatusShowEdit;
}

set orderStatusShowEdit (value: boolean ) {
  this._orderStatusShowEdit = value ;
}
get orderStatusShowCreate (): boolean  {
  return this._orderStatusShowCreate;
}

set orderStatusShowCreate (value: boolean ) {
  this._orderStatusShowCreate = value ;
}
             public editShow(pojo : OrderStatusVo ){

       this.orderStatusShowEdit = true;
       this.orderStatus = pojo;
                                  }

              public editHide (){

       this.orderStatusShowEdit = false;
       this.orderStatus = new OrderStatusVo();
                                  }

               public createShow(){

       this.orderStatusShowCreate = true;
       this.orderStatus = new OrderStatusVo();
                                  }

              public createHide (){

       this.orderStatusShowCreate = false;
       this.orderStatus = new OrderStatusVo();
                                  }
}