import {Component, OnInit} from '@angular/core';
import {StockService} from '../../../controller/service/Stock.service';
import {StockVo} from '../../../controller/model/stock.model';
import {UserVo} from '../../../controller/model/User.model';
import {ProductVo} from '../../../controller/model/Product.model';
import {CityVo} from '../../../controller/model/City.model';

@Component({
  selector: 'app-stock-edit',
  templateUrl: './stock-edit.component.html',
  styleUrls: ['./stock-edit.component.css']
})
export class StockEditComponent implements OnInit {
  constructor(private stockService: StockService) { }

   ngOnInit(): void {
       this.findAllcitys();
       this.findAllproducts();
       this.findAlladmins();
    }

   get stock(): StockVo {
    return this.stockService.stock;
  }

   get editableStocks(): Array<StockVo> {
    return this.stockService.editableStocks;
   }

   set editableStocks(value: Array<StockVo>) {
    this.stockService.editableStocks = value;
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

   editStock() {
    this.stockService.editStock();
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

      findByid(identifier: string) {
       this.stockService.findByid(identifier);
      }

    editHide() {
      this.stockService.editHide();
    }
    

}