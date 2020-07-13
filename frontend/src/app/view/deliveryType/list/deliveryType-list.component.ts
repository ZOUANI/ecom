import { Component, OnInit } from '@angular/core';
import {DeliveryTypeVo} from '../../../controller/model/deliveryType.model';
import {DeliveryTypeService} from '../../../controller/service/DeliveryType.service';

@Component({
  selector: 'app-deliveryType-list',
  templateUrl: './deliveryType-list.component.html',
  styleUrls: ['./deliveryType-list.component.css']
})
export class DeliveryTypelistComponent implements OnInit {

  constructor(private _deliveryTypeService : DeliveryTypeService) {}


  ngOnInit(): void {
    this.findAll();
  }

  get deliveryTypeService (): DeliveryTypeService {
    return this._deliveryTypeService;
  }

  set deliveryTypeService (value: DeliveryTypeService) {
    this._deliveryTypeService = value ;
  }

  get deliveryTypeListe (): Array<DeliveryTypeVo> {
    return this.deliveryTypeService.deliveryTypeListe;
  }

  set deliveryTypeListe (value: Array<DeliveryTypeVo>) {
    this.deliveryTypeService.deliveryTypeListe = value ;
  }

  get deliveryTypeDetail (): DeliveryTypeVo {
    return this.deliveryTypeService.deliveryTypeDetail;
}

  set deliveryTypeDetail (value: DeliveryTypeVo) {
  this.deliveryTypeService.deliveryTypeDetail = value ;
}

get deliveryTypeSearch (): DeliveryTypeVo {
  return this.deliveryTypeService.deliveryTypeSearch;
}

set deliveryTypeSearch (value: DeliveryTypeVo) {
  this.deliveryTypeService.deliveryTypeSearch = value ;
}


get deliveryTypeShowDetail (): boolean  {
  return this.deliveryTypeService.deliveryTypeShowDetail;
}

set deliveryTypeShowDetail (value: boolean ) {
  this.deliveryTypeService.deliveryTypeShowDetail = value ;
}

get deliveryTypeShowCreate (): boolean  {
  return this.deliveryTypeService.deliveryTypeShowCreate;
}

set deliveryTypeShowCreate (value: boolean ) {
  this.deliveryTypeService.deliveryTypeShowCreate = value ;
}
get deliveryTypeShowEdit (): boolean  {
  return this.deliveryTypeService.deliveryTypeShowEdit;
}

set deliveryTypeShowEdit (value: boolean ) {
  this.deliveryTypeService.deliveryTypeShowEdit = value ;
}

  editShow( pojo : DeliveryTypeVo ) {
  this.deliveryTypeService.editShow(pojo);

}
  createShow()  {
  this.deliveryTypeService.createShow();

}

   delete( pojo : DeliveryTypeVo ) {
    this.deliveryTypeService.delete(pojo);
  }


 detailShow( pojo : DeliveryTypeVo ) {
  this.deliveryTypeService.detailShow( pojo);

}

 findDeliveryType(pojo : DeliveryTypeVo ) {
  this.deliveryTypeService.findDeliveryType( pojo);

}
 findAll() {
  this.deliveryTypeService.findAll();
}


}
