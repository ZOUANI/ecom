import {Component, OnInit} from '@angular/core';
import {OrderLineService} from '../../../controller/service/OrderLine.service';
import {OrderLineVo} from '../../../controller/model/orderLine.model';
import {CommandVo} from '../../../controller/model/Command.model';
import {ProductVo} from '../../../controller/model/Product.model';

@Component({
  selector: 'app-orderLine-edit',
  templateUrl: './orderLine-edit.component.html',
  styleUrls: ['./orderLine-edit.component.css']
})
export class OrderLineEditComponent implements OnInit {
  constructor(private orderLineService: OrderLineService) { }

   ngOnInit(): void {
       this.findAllcommands();
       this.findAllproducts();
    }

   get orderLine(): OrderLineVo {
    return this.orderLineService.orderLine;
  }

   get editableOrderLines(): Array<OrderLineVo> {
    return this.orderLineService.editableOrderLines;
   }

   set editableOrderLines(value: Array<OrderLineVo>) {
    this.orderLineService.editableOrderLines = value;
   }

  get commands(): Array<CommandVo> {
   return this.orderLineService.commands;
  }
  get products(): Array<ProductVo> {
   return this.orderLineService.products;
  }

   editOrderLine() {
    this.orderLineService.editOrderLine();
  }
    findAllcommands() {
     this.orderLineService.findAllcommands();
    }
    findAllproducts() {
     this.orderLineService.findAllproducts();
    }

      findByid(identifier: string) {
       this.orderLineService.findByid(identifier);
      }

    editHide() {
      this.orderLineService.editHide();
    }
    

}