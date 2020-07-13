import {Component, OnInit} from '@angular/core';
import {OrderStatusService} from '../../../controller/service/OrderStatus.service';
import {OrderStatusVo} from '../../../controller/model/orderStatus.model';

@Component({
  selector: 'app-orderStatus-edit',
  templateUrl: './orderStatus-edit.component.html',
  styleUrls: ['./orderStatus-edit.component.css']
})
export class OrderStatusEditComponent implements OnInit {
  constructor(private orderStatusService: OrderStatusService) { }

   ngOnInit(): void {
    }

   get orderStatus(): OrderStatusVo {
    return this.orderStatusService.orderStatus;
  }

   get editableOrderStatuss(): Array<OrderStatusVo> {
    return this.orderStatusService.editableOrderStatuss;
   }

   set editableOrderStatuss(value: Array<OrderStatusVo>) {
    this.orderStatusService.editableOrderStatuss = value;
   }


   editOrderStatus() {
    this.orderStatusService.editOrderStatus();
  }

     findBylabel(ref: string) {
      this.orderStatusService.findBylabel(ref);
     }

    editHide() {
      this.orderStatusService.editHide();
    }
    

}