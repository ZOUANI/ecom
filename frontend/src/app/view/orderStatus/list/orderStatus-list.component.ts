import { Component, OnInit } from '@angular/core';
import {OrderStatusVo} from '../../../controller/model/orderStatus.model';
import {OrderStatusService} from '../../../controller/service/OrderStatus.service';

@Component({
  selector: 'app-orderStatus-list',
  templateUrl: './orderStatus-list.component.html',
  styleUrls: ['./orderStatus-list.component.css']
})
export class OrderStatuslistComponent implements OnInit {

  constructor(private _orderStatusService : OrderStatusService) {}


  ngOnInit(): void {
    this.findAll();
  }

  get orderStatusService (): OrderStatusService {
    return this._orderStatusService;
  }

  set orderStatusService (value: OrderStatusService) {
    this._orderStatusService = value ;
  }

  get orderStatusListe (): Array<OrderStatusVo> {
    return this.orderStatusService.orderStatusListe;
  }

  set orderStatusListe (value: Array<OrderStatusVo>) {
    this.orderStatusService.orderStatusListe = value ;
  }

  get orderStatusDetail (): OrderStatusVo {
    return this.orderStatusService.orderStatusDetail;
}

  set orderStatusDetail (value: OrderStatusVo) {
  this.orderStatusService.orderStatusDetail = value ;
}

get orderStatusSearch (): OrderStatusVo {
  return this.orderStatusService.orderStatusSearch;
}

set orderStatusSearch (value: OrderStatusVo) {
  this.orderStatusService.orderStatusSearch = value ;
}


get orderStatusShowDetail (): boolean  {
  return this.orderStatusService.orderStatusShowDetail;
}

set orderStatusShowDetail (value: boolean ) {
  this.orderStatusService.orderStatusShowDetail = value ;
}

get orderStatusShowCreate (): boolean  {
  return this.orderStatusService.orderStatusShowCreate;
}

set orderStatusShowCreate (value: boolean ) {
  this.orderStatusService.orderStatusShowCreate = value ;
}
get orderStatusShowEdit (): boolean  {
  return this.orderStatusService.orderStatusShowEdit;
}

set orderStatusShowEdit (value: boolean ) {
  this.orderStatusService.orderStatusShowEdit = value ;
}

  editShow( pojo : OrderStatusVo ) {
  this.orderStatusService.editShow(pojo);

}
  createShow()  {
  this.orderStatusService.createShow();

}

   delete( pojo : OrderStatusVo ) {
    this.orderStatusService.delete(pojo);
  }


 detailShow( pojo : OrderStatusVo ) {
  this.orderStatusService.detailShow( pojo);

}

 findOrderStatus(pojo : OrderStatusVo ) {
  this.orderStatusService.findOrderStatus( pojo);

}
 findAll() {
  this.orderStatusService.findAll();
}


}
