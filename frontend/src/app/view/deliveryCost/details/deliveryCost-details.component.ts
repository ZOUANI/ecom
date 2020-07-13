import { Component, OnInit } from '@angular/core';
import {DeliveryCostVo} from '../../../controller/model/deliveryCost.model';
import {DeliveryCostService} from '../../../controller/service/DeliveryCost.service';

@Component({
  selector: 'app-deliveryCost-details',
  templateUrl: './deliveryCost-details.component.html',
  styleUrls: ['./deliveryCost-details.component.css']
})

export class DeliveryCostDetailsComponent implements OnInit {

  constructor(private _deliveryCostService : DeliveryCostService) {}


   get deliveryCostService (): DeliveryCostService {
    return this._deliveryCostService;
  }

  set deliveryCostService (value: DeliveryCostService) {
    this._deliveryCostService = value ;
  }

  get deliveryCostDetail (): DeliveryCostVo {
    return this.deliveryCostService.deliveryCostDetail;
}

  set deliveryCostDetail (value: DeliveryCostVo) {
  this.deliveryCostService.deliveryCostDetail = value ;
}


get deliveryCostShowDetail (): boolean  {
  return this.deliveryCostService.deliveryCostShowDetail;
}

set deliveryCostShowDetail (value: boolean ) {
  this.deliveryCostService.deliveryCostShowDetail = value ;
}

  ngOnInit(): void {

  }

public detailHide(){
       this.deliveryCostService.detailHide();
}

}