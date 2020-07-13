import { Injectable } from '@angular/core';
import {HttpClient} from '@angular/common/http';
import {StockVo} from '../model/stock.model';
import {UserVo} from '../model/User.model';
import {ProductVo} from '../model/Product.model';
import {CityVo} from '../model/City.model';
@Injectable({
  providedIn: 'root'
})
export class StockService {

  constructor(private http: HttpClient) { }
  private _stockDetail : StockVo =  new StockVo() ;
  private _stockListe  : Array<StockVo> = new Array<StockVo>();
  
  private _stockSearch : StockVo = new StockVo();
  private _stock: StockVo =  new StockVo();
  private _searchedStocks: Array<StockVo> = new Array<StockVo>();
  private _editableStocks: Array<StockVo> = new Array<StockVo>();
  private _citys: Array<CityVo> = new Array<CityVo>();
  private _products: Array<ProductVo> = new Array<ProductVo>();
  private _admins: Array<UserVo> = new Array<UserVo>();
   get citys(): Array<CityVo> {
    return this._citys;
   }

   set citys(value: Array<CityVo>) {
    this._citys = value;
   }
   get products(): Array<ProductVo> {
    return this._products;
   }

   set products(value: Array<ProductVo>) {
    this._products = value;
   }
   get admins(): Array<UserVo> {
    return this._admins;
   }

   set admins(value: Array<UserVo>) {
    this._admins = value;
   }

  get stock(): StockVo {
    if (this._stock == null) {
      this._stock = new StockVo();
    }
    return this._stock;
  }

  set stock(value: StockVo) {
    this._stock = value;
  }

  get stockListe (): Array<StockVo> {
  return this._stockListe;
}

set stockListe (value: Array<StockVo>) {
  this._stockListe = value ;
}

get stockDetail (): StockVo {
  return this._stockDetail;
}

set stockDetail (value: StockVo) {
  this._stockDetail = value ;
}

get stockSearch (): StockVo {
  return this._stockSearch;
}

set stockSearch (value: StockVo) {
  this._stockSearch = value ;
}

get stockShowDetail (): boolean  {
  return this._stockShowDetail;
}

set stockShowDetail (value: boolean ) {
  this._stockShowDetail = value ;
}

  get editableStocks (): Array<StockVo> {
   return this._editableStocks;
  }

  set editableStocks (value: Array<StockVo>) {
   this._editableStocks = value;
  }

  public findAll(){
  this.http.get<Array<StockVo>>('http://localhost:8036/generated/stock/').subscribe(
    value => {
      if (value != null) {
           this.stockListe = value;
           this.editableStocks = value;
                                                 
      }
    }
  );
}

  public saveStock() {
  this.http.post('http://localhost:8036/generated/stock/', this.stock).subscribe();
  this.findAll();
  }

  public editStock() {
  this.http.put('http://localhost:8036/generated/stock/', this.stock).subscribe();
        this.findAll();
  }

   public findStock ( pojo : StockVo ){
  this.http.post<Array<StockVo>>('http://localhost:8036/generated/stock/search/', pojo).subscribe(
    value =>{
       this.stockListe = value;  
    } );
}

public detailShow ( pojo : StockVo ){
  this.http.get<StockVo>('http://localhost:8036/generated/stock/id/'+pojo.id).subscribe(
    value =>{
     if (value != null) { this.stockDetail = value;
        this.stockShowDetail = true;		}
    } );
}



delete(pojo: StockVo) {
   this.http.delete<StockVo>('http://localhost:8036/generated/stock/id/'+pojo.id).subscribe(
        value => {
        var index = this.stockListe.indexOf(pojo);
if (index > -1) {
   this.stockListe.splice(index, 1);
}
}
        );


}


        public findByid(identifier: string) {
        this.http.get<StockVo>('http://localhost:8036/generated/stock/id/' + identifier).subscribe(
          value => {
          if (value != null) { this.stock = value; }
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
            public findAllproducts() {
             this.http.get<Array<ProductVo>>('http://localhost:8036/generated/product/').subscribe(
            value => {
            if (value != null) { this.products = value; }
            }
            );
            }
            public findAlladmins() {
             this.http.get<Array<UserVo>>('http://localhost:8036/generated/user/').subscribe(
            value => {
            if (value != null) { this.admins = value; }
            }
            );
            }


          /***********************************************************************************************/
        private _stockShowDetail : boolean;
              public detailHide (){

       this.stockShowDetail = false;
       this.stockDetail = null;
                                  }
 private _stockShowEdit : boolean;

 private _stockShowCreate : boolean;

get stockShowEdit (): boolean  {
  return this._stockShowEdit;
}

set stockShowEdit (value: boolean ) {
  this._stockShowEdit = value ;
}
get stockShowCreate (): boolean  {
  return this._stockShowCreate;
}

set stockShowCreate (value: boolean ) {
  this._stockShowCreate = value ;
}
             public editShow(pojo : StockVo ){

       this.stockShowEdit = true;
       this.stock = pojo;
                                  }

              public editHide (){

       this.stockShowEdit = false;
       this.stock = new StockVo();
                                  }

               public createShow(){

       this.stockShowCreate = true;
       this.stock = new StockVo();
                                  }

              public createHide (){

       this.stockShowCreate = false;
       this.stock = new StockVo();
                                  }
}