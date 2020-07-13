import { Component, OnInit } from '@angular/core';
import {DeliveryTypeVo} from '../../../controller/model/deliveryType.model';
import {DeliveryTypeService} from '../../../controller/service/DeliveryType.service';

@Component({
  selector: 'app-deliveryType-details',
  templateUrl: './deliveryType-details.component.html',
  styleUrls: ['./deliveryType-details.component.css']
})

export class DeliveryTypeDetailsComponent implements OnInit {

  constructor(private _deliveryTypeService : DeliveryTypeService) {}


   get deliveryTypeService (): DeliveryTypeService {
    return this._deliveryTypeService;
  }

  set deliveryTypeService (value: DeliveryTypeService) {
    this._deliveryTypeService = value ;
  }

  get deliveryTypeDetail (): DeliveryTypeVo {
    return this.deliveryTypeService.deliveryTypeDetail;
}

  set deliveryTypeDetail (value: DeliveryTypeVo) {
  this.deliveryTypeService.deliveryTypeDetail = value ;
}


get deliveryTypeShowDetail (): boolean  {
  return this.deliveryTypeService.deliveryTypeShowDetail;
}

set deliveryTypeShowDetail (value: boolean ) {
  this.deliveryTypeService.deliveryTypeShowDetail = value ;
}

  ngOnInit(): void {

  }

public detailHide(){
       this.deliveryTypeService.detailHide();
}

}