import { Component, OnInit } from '@angular/core';
import {StockVo} from '../../../controller/model/stock.model';
import {StockService} from '../../../controller/service/Stock.service';
import {UserVo} from '../../../controller/model/User.model';
import {ProductVo} from '../../../controller/model/Product.model';
import {CityVo} from '../../../controller/model/City.model';

@Component({
  selector: 'app-stock-list',
  templateUrl: './stock-list.component.html',
  styleUrls: ['./stock-list.component.css']
})
export class StocklistComponent implements OnInit {

  constructor(private _stockService : StockService) {}

  get citys(): Array<CityVo> {
   return this.stockService.citys;
  }
  get products(): Array<ProductVo> {
   return this.stockService.products;
  }
  get admins(): Array<UserVo> {
   return this.stockService.admins;
  }

  ngOnInit(): void {
    this.findAll();
      this.findAllcitys();
      this.findAllproducts();
      this.findAlladmins();
  }

  get stockService (): StockService {
    return this._stockService;
  }

  set stockService (value: StockService) {
    this._stockService = value ;
  }

  get stockListe (): Array<StockVo> {
    return this.stockService.stockListe;
  }

  set stockListe (value: Array<StockVo>) {
    this.stockService.stockListe = value ;
  }

  get stockDetail (): StockVo {
    return this.stockService.stockDetail;
}

  set stockDetail (value: StockVo) {
  this.stockService.stockDetail = value ;
}

get stockSearch (): StockVo {
  return this.stockService.stockSearch;
}

set stockSearch (value: StockVo) {
  this.stockService.stockSearch = value ;
}


get stockShowDetail (): boolean  {
  return this.stockService.stockShowDetail;
}

set stockShowDetail (value: boolean ) {
  this.stockService.stockShowDetail = value ;
}

get stockShowCreate (): boolean  {
  return this.stockService.stockShowCreate;
}

set stockShowCreate (value: boolean ) {
  this.stockService.stockShowCreate = value ;
}
get stockShowEdit (): boolean  {
  return this.stockService.stockShowEdit;
}

set stockShowEdit (value: boolean ) {
  this.stockService.stockShowEdit = value ;
}

  editShow( pojo : StockVo ) {
  this.stockService.editShow(pojo);

}
  createShow()  {
  this.stockService.createShow();

}

   delete( pojo : StockVo ) {
    this.stockService.delete(pojo);
  }


 detailShow( pojo : StockVo ) {
  this.stockService.detailShow( pojo);

}

 findStock(pojo : StockVo ) {
  this.stockService.findStock( pojo);

}
 findAll() {
  this.stockService.findAll();
}

   findAllcitys() {
     this.stockService.findAllcitys();
   }
   findAllproducts() {
     this.stockService.findAllproducts();
   }
   findAlladmins() {
     this.stockService.findAlladmins();
   }

}
