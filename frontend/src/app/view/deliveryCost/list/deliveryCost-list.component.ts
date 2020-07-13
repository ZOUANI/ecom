import { Component, OnInit } from '@angular/core';
import {DeliveryCostVo} from '../../../controller/model/deliveryCost.model';
import {DeliveryCostService} from '../../../controller/service/DeliveryCost.service';
import {UserVo} from '../../../controller/model/User.model';
import {CityVo} from '../../../controller/model/City.model';

@Component({
  selector: 'app-deliveryCost-list',
  templateUrl: './deliveryCost-list.component.html',
  styleUrls: ['./deliveryCost-list.component.css']
})
export class DeliveryCostlistComponent implements OnInit {

  constructor(private _deliveryCostService : DeliveryCostService) {}

  get citys(): Array<CityVo> {
   return this.deliveryCostService.citys;
  }
  get deliverys(): Array<UserVo> {
   return this.deliveryCostService.deliverys;
  }

  ngOnInit(): void {
    this.findAll();
      this.findAllcitys();
      this.findAlldeliverys();
  }

  get deliveryCostService (): DeliveryCostService {
    return this._deliveryCostService;
  }

  set deliveryCostService (value: DeliveryCostService) {
    this._deliveryCostService = value ;
  }

  get deliveryCostListe (): Array<DeliveryCostVo> {
    return this.deliveryCostService.deliveryCostListe;
  }

  set deliveryCostListe (value: Array<DeliveryCostVo>) {
    this.deliveryCostService.deliveryCostListe = value ;
  }

  get deliveryCostDetail (): DeliveryCostVo {
    return this.deliveryCostService.deliveryCostDetail;
}

  set deliveryCostDetail (value: DeliveryCostVo) {
  this.deliveryCostService.deliveryCostDetail = value ;
}

get deliveryCostSearch (): DeliveryCostVo {
  return this.deliveryCostService.deliveryCostSearch;
}

set deliveryCostSearch (value: DeliveryCostVo) {
  this.deliveryCostService.deliveryCostSearch = value ;
}


get deliveryCostShowDetail (): boolean  {
  return this.deliveryCostService.deliveryCostShowDetail;
}

set deliveryCostShowDetail (value: boolean ) {
  this.deliveryCostService.deliveryCostShowDetail = value ;
}

get deliveryCostShowCreate (): boolean  {
  return this.deliveryCostService.deliveryCostShowCreate;
}

set deliveryCostShowCreate (value: boolean ) {
  this.deliveryCostService.deliveryCostShowCreate = value ;
}
get deliveryCostShowEdit (): boolean  {
  return this.deliveryCostService.deliveryCostShowEdit;
}

set deliveryCostShowEdit (value: boolean ) {
  this.deliveryCostService.deliveryCostShowEdit = value ;
}

  editShow( pojo : DeliveryCostVo ) {
  this.deliveryCostService.editShow(pojo);

}
  createShow()  {
  this.deliveryCostService.createShow();

}

   delete( pojo : DeliveryCostVo ) {
    this.deliveryCostService.delete(pojo);
  }


 detailShow( pojo : DeliveryCostVo ) {
  this.deliveryCostService.detailShow( pojo);

}

 findDeliveryCost(pojo : DeliveryCostVo ) {
  this.deliveryCostService.findDeliveryCost( pojo);

}
 findAll() {
  this.deliveryCostService.findAll();
}

   findAllcitys() {
     this.deliveryCostService.findAllcitys();
   }
   findAlldeliverys() {
     this.deliveryCostService.findAlldeliverys();
   }

}
