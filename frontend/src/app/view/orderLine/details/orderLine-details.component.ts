import { Component, OnInit } from '@angular/core';
import {OrderLineVo} from '../../../controller/model/orderLine.model';
import {OrderLineService} from '../../../controller/service/OrderLine.service';

@Component({
  selector: 'app-orderLine-details',
  templateUrl: './orderLine-details.component.html',
  styleUrls: ['./orderLine-details.component.css']
})

export class OrderLineDetailsComponent implements OnInit {

  constructor(private _orderLineService : OrderLineService) {}


   get orderLineService (): OrderLineService {
    return this._orderLineService;
  }

  set orderLineService (value: OrderLineService) {
    this._orderLineService = value ;
  }

  get orderLineDetail (): OrderLineVo {
    return this.orderLineService.orderLineDetail;
}

  set orderLineDetail (value: OrderLineVo) {
  this.orderLineService.orderLineDetail = value ;
}


get orderLineShowDetail (): boolean  {
  return this.orderLineService.orderLineShowDetail;
}

set orderLineShowDetail (value: boolean ) {
  this.orderLineService.orderLineShowDetail = value ;
}

  ngOnInit(): void {

  }

public detailHide(){
       this.orderLineService.detailHide();
}

}