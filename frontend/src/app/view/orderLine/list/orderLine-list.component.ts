import { Component, OnInit } from '@angular/core';
import {OrderLineVo} from '../../../controller/model/orderLine.model';
import {OrderLineService} from '../../../controller/service/OrderLine.service';
import {CommandVo} from '../../../controller/model/Command.model';
import {ProductVo} from '../../../controller/model/Product.model';

@Component({
  selector: 'app-orderLine-list',
  templateUrl: './orderLine-list.component.html',
  styleUrls: ['./orderLine-list.component.css']
})
export class OrderLinelistComponent implements OnInit {

  constructor(private _orderLineService : OrderLineService) {}

  get commands(): Array<CommandVo> {
   return this.orderLineService.commands;
  }
  get products(): Array<ProductVo> {
   return this.orderLineService.products;
  }

  ngOnInit(): void {
    this.findAll();
      this.findAllcommands();
      this.findAllproducts();
  }

  get orderLineService (): OrderLineService {
    return this._orderLineService;
  }

  set orderLineService (value: OrderLineService) {
    this._orderLineService = value ;
  }

  get orderLineListe (): Array<OrderLineVo> {
    return this.orderLineService.orderLineListe;
  }

  set orderLineListe (value: Array<OrderLineVo>) {
    this.orderLineService.orderLineListe = value ;
  }

  get orderLineDetail (): OrderLineVo {
    return this.orderLineService.orderLineDetail;
}

  set orderLineDetail (value: OrderLineVo) {
  this.orderLineService.orderLineDetail = value ;
}

get orderLineSearch (): OrderLineVo {
  return this.orderLineService.orderLineSearch;
}

set orderLineSearch (value: OrderLineVo) {
  this.orderLineService.orderLineSearch = value ;
}


get orderLineShowDetail (): boolean  {
  return this.orderLineService.orderLineShowDetail;
}

set orderLineShowDetail (value: boolean ) {
  this.orderLineService.orderLineShowDetail = value ;
}

get orderLineShowCreate (): boolean  {
  return this.orderLineService.orderLineShowCreate;
}

set orderLineShowCreate (value: boolean ) {
  this.orderLineService.orderLineShowCreate = value ;
}
get orderLineShowEdit (): boolean  {
  return this.orderLineService.orderLineShowEdit;
}

set orderLineShowEdit (value: boolean ) {
  this.orderLineService.orderLineShowEdit = value ;
}

  editShow( pojo : OrderLineVo ) {
  this.orderLineService.editShow(pojo);

}
  createShow()  {
  this.orderLineService.createShow();

}

   delete( pojo : OrderLineVo ) {
    this.orderLineService.delete(pojo);
  }


 detailShow( pojo : OrderLineVo ) {
  this.orderLineService.detailShow( pojo);

}

 findOrderLine(pojo : OrderLineVo ) {
  this.orderLineService.findOrderLine( pojo);

}
 findAll() {
  this.orderLineService.findAll();
}

   findAllcommands() {
     this.orderLineService.findAllcommands();
   }
   findAllproducts() {
     this.orderLineService.findAllproducts();
   }

}
