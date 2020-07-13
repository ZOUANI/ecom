import {Component, OnInit} from '@angular/core';
import {StockService} from '../../../controller/service/Stock.service';
import {StockVo} from '../../../controller/model/stock.model';
import {UserVo} from '../../../controller/model/User.model';
import {ProductVo} from '../../../controller/model/Product.model';
import {CityVo} from '../../../controller/model/City.model';

@Component({
  selector: 'app-stock-create',
  templateUrl: './stock-create.component.html',
  styleUrls: ['./stock-create.component.css']
})
export class StockCreateComponent implements OnInit {
  constructor(private stockService: StockService) { }

   ngOnInit(): void {
      this.findAllcitys();
      this.findAllproducts();
      this.findAlladmins();
    }

   get stock(): StockVo {
    return this.stockService.stock;
  }

  get citys(): Array<CityVo> {
   return this.stockService.citys;
  }
  get products(): Array<ProductVo> {
   return this.stockService.products;
  }
  get admins(): Array<UserVo> {
   return this.stockService.admins;
  }

   saveStock() {
    this.stockService.saveStock();
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

get stockShowCreate (): boolean  {
  return this.stockService.stockShowCreate;
}

set stockShowCreate (value: boolean ) {
  this.stockService.stockShowCreate = value ;
}
public createHide(){
       this.stockService.createHide();
}
}