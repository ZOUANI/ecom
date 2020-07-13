import {Component, OnInit} from '@angular/core';
import {OrderLineService} from '../../../controller/service/OrderLine.service';
import {OrderLineVo} from '../../../controller/model/orderLine.model';
import {CommandVo} from '../../../controller/model/Command.model';
import {ProductVo} from '../../../controller/model/Product.model';

@Component({
  selector: 'app-orderLine-create',
  templateUrl: './orderLine-create.component.html',
  styleUrls: ['./orderLine-create.component.css']
})
export class OrderLineCreateComponent implements OnInit {
  constructor(private orderLineService: OrderLineService) { }

   ngOnInit(): void {
      this.findAllcommands();
      this.findAllproducts();
    }

   get orderLine(): OrderLineVo {
    return this.orderLineService.orderLine;
  }

  get commands(): Array<CommandVo> {
   return this.orderLineService.commands;
  }
  get products(): Array<ProductVo> {
   return this.orderLineService.products;
  }

   saveOrderLine() {
    this.orderLineService.saveOrderLine();
  }

   findAllcommands() {
     this.orderLineService.findAllcommands();
   }
   findAllproducts() {
     this.orderLineService.findAllproducts();
   }

get orderLineShowCreate (): boolean  {
  return this.orderLineService.orderLineShowCreate;
}

set orderLineShowCreate (value: boolean ) {
  this.orderLineService.orderLineShowCreate = value ;
}
public createHide(){
       this.orderLineService.createHide();
}
}