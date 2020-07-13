import {Component, OnInit} from '@angular/core';
import {DeliveryCostService} from '../../../controller/service/DeliveryCost.service';
import {DeliveryCostVo} from '../../../controller/model/deliveryCost.model';
import {UserVo} from '../../../controller/model/User.model';
import {CityVo} from '../../../controller/model/City.model';

@Component({
  selector: 'app-deliveryCost-edit',
  templateUrl: './deliveryCost-edit.component.html',
  styleUrls: ['./deliveryCost-edit.component.css']
})
export class DeliveryCostEditComponent implements OnInit {
  constructor(private deliveryCostService: DeliveryCostService) { }

   ngOnInit(): void {
       this.findAllcitys();
       this.findAlldeliverys();
    }

   get deliveryCost(): DeliveryCostVo {
    return this.deliveryCostService.deliveryCost;
  }

   get editableDeliveryCosts(): Array<DeliveryCostVo> {
    return this.deliveryCostService.editableDeliveryCosts;
   }

   set editableDeliveryCosts(value: Array<DeliveryCostVo>) {
    this.deliveryCostService.editableDeliveryCosts = value;
   }

  get citys(): Array<CityVo> {
   return this.deliveryCostService.citys;
  }
  get deliverys(): Array<UserVo> {
   return this.deliveryCostService.deliverys;
  }

   editDeliveryCost() {
    this.deliveryCostService.editDeliveryCost();
  }
    findAllcitys() {
     this.deliveryCostService.findAllcitys();
    }
    findAlldeliverys() {
     this.deliveryCostService.findAlldeliverys();
    }

      findByid(identifier: string) {
       this.deliveryCostService.findByid(identifier);
      }

    editHide() {
      this.deliveryCostService.editHide();
    }
    

}