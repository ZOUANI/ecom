import { Component, OnInit } from '@angular/core';
import {StockVo} from '../../../controller/model/stock.model';
import {StockService} from '../../../controller/service/Stock.service';

@Component({
  selector: 'app-stock-details',
  templateUrl: './stock-details.component.html',
  styleUrls: ['./stock-details.component.css']
})

export class StockDetailsComponent implements OnInit {

  constructor(private _stockService : StockService) {}


   get stockService (): StockService {
    return this._stockService;
  }

  set stockService (value: StockService) {
    this._stockService = value ;
  }

  get stockDetail (): StockVo {
    return this.stockService.stockDetail;
}

  set stockDetail (value: StockVo) {
  this.stockService.stockDetail = value ;
}


get stockShowDetail (): boolean  {
  return this.stockService.stockShowDetail;
}

set stockShowDetail (value: boolean ) {
  this.stockService.stockShowDetail = value ;
}

  ngOnInit(): void {

  }

public detailHide(){
       this.stockService.detailHide();
}

}