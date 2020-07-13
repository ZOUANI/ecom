import { Component, OnInit } from '@angular/core';
import {OrderStatusVo} from '../../../controller/model/orderStatus.model';
import {OrderStatusService} from '../../../controller/service/OrderStatus.service';

@Component({
  selector: 'app-orderStatus-details',
  templateUrl: './orderStatus-details.component.html',
  styleUrls: ['./orderStatus-details.component.css']
})

export class OrderStatusDetailsComponent implements OnInit {

  constructor(private _orderStatusService : OrderStatusService) {}


   get orderStatusService (): OrderStatusService {
    return this._orderStatusService;
  }

  set orderStatusService (value: OrderStatusService) {
    this._orderStatusService = value ;
  }

  get orderStatusDetail (): OrderStatusVo {
    return this.orderStatusService.orderStatusDetail;
}

  set orderStatusDetail (value: OrderStatusVo) {
  this.orderStatusService.orderStatusDetail = value ;
}


get orderStatusShowDetail (): boolean  {
  return this.orderStatusService.orderStatusShowDetail;
}

set orderStatusShowDetail (value: boolean ) {
  this.orderStatusService.orderStatusShowDetail = value ;
}

  ngOnInit(): void {

  }

public detailHide(){
       this.orderStatusService.detailHide();
}

}