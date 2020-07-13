import {Component, OnInit} from '@angular/core';
import {DeliveryTypeService} from '../../../controller/service/DeliveryType.service';
import {DeliveryTypeVo} from '../../../controller/model/deliveryType.model';

@Component({
  selector: 'app-deliveryType-edit',
  templateUrl: './deliveryType-edit.component.html',
  styleUrls: ['./deliveryType-edit.component.css']
})
export class DeliveryTypeEditComponent implements OnInit {
  constructor(private deliveryTypeService: DeliveryTypeService) { }

   ngOnInit(): void {
    }

   get deliveryType(): DeliveryTypeVo {
    return this.deliveryTypeService.deliveryType;
  }

   get editableDeliveryTypes(): Array<DeliveryTypeVo> {
    return this.deliveryTypeService.editableDeliveryTypes;
   }

   set editableDeliveryTypes(value: Array<DeliveryTypeVo>) {
    this.deliveryTypeService.editableDeliveryTypes = value;
   }


   editDeliveryType() {
    this.deliveryTypeService.editDeliveryType();
  }

     findBylabel(ref: string) {
      this.deliveryTypeService.findBylabel(ref);
     }

    editHide() {
      this.deliveryTypeService.editHide();
    }
    

}