import {Component, OnInit} from '@angular/core';
import {OrderStatusService} from '../../../controller/service/OrderStatus.service';
import {OrderStatusVo} from '../../../controller/model/orderStatus.model';

@Component({
  selector: 'app-orderStatus-create',
  templateUrl: './orderStatus-create.component.html',
  styleUrls: ['./orderStatus-create.component.css']
})
export class OrderStatusCreateComponent implements OnInit {
  constructor(private orderStatusService: OrderStatusService) { }

   ngOnInit(): void {
    }

   get orderStatus(): OrderStatusVo {
    return this.orderStatusService.orderStatus;
  }


   saveOrderStatus() {
    this.orderStatusService.saveOrderStatus();
  }


get orderStatusShowCreate (): boolean  {
  return this.orderStatusService.orderStatusShowCreate;
}

set orderStatusShowCreate (value: boolean ) {
  this.orderStatusService.orderStatusShowCreate = value ;
}
public createHide(){
       this.orderStatusService.createHide();
}
}