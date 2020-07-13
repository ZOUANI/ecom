import {Component, OnInit} from '@angular/core';
import {DeliveryCostService} from '../../../controller/service/DeliveryCost.service';
import {DeliveryCostVo} from '../../../controller/model/deliveryCost.model';
import {UserVo} from '../../../controller/model/User.model';
import {CityVo} from '../../../controller/model/City.model';

@Component({
  selector: 'app-deliveryCost-create',
  templateUrl: './deliveryCost-create.component.html',
  styleUrls: ['./deliveryCost-create.component.css']
})
export class DeliveryCostCreateComponent implements OnInit {
  constructor(private deliveryCostService: DeliveryCostService) { }

   ngOnInit(): void {
      this.findAllcitys();
      this.findAlldeliverys();
    }

   get deliveryCost(): DeliveryCostVo {
    return this.deliveryCostService.deliveryCost;
  }

  get citys(): Array<CityVo> {
   return this.deliveryCostService.citys;
  }
  get deliverys(): Array<UserVo> {
   return this.deliveryCostService.deliverys;
  }

   saveDeliveryCost() {
    this.deliveryCostService.saveDeliveryCost();
  }

   findAllcitys() {
     this.deliveryCostService.findAllcitys();
   }
   findAlldeliverys() {
     this.deliveryCostService.findAlldeliverys();
   }

get deliveryCostShowCreate (): boolean  {
  return this.deliveryCostService.deliveryCostShowCreate;
}

set deliveryCostShowCreate (value: boolean ) {
  this.deliveryCostService.deliveryCostShowCreate = value ;
}
public createHide(){
       this.deliveryCostService.createHide();
}
}