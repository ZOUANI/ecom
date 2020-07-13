import {Component, OnInit} from '@angular/core';
import {DeliveryTypeService} from '../../../controller/service/DeliveryType.service';
import {DeliveryTypeVo} from '../../../controller/model/deliveryType.model';

@Component({
  selector: 'app-deliveryType-create',
  templateUrl: './deliveryType-create.component.html',
  styleUrls: ['./deliveryType-create.component.css']
})
export class DeliveryTypeCreateComponent implements OnInit {
  constructor(private deliveryTypeService: DeliveryTypeService) { }

   ngOnInit(): void {
    }

   get deliveryType(): DeliveryTypeVo {
    return this.deliveryTypeService.deliveryType;
  }


   saveDeliveryType() {
    this.deliveryTypeService.saveDeliveryType();
  }


get deliveryTypeShowCreate (): boolean  {
  return this.deliveryTypeService.deliveryTypeShowCreate;
}

set deliveryTypeShowCreate (value: boolean ) {
  this.deliveryTypeService.deliveryTypeShowCreate = value ;
}
public createHide(){
       this.deliveryTypeService.createHide();
}
}