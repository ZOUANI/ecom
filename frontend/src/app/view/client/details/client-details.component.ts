import { Component, OnInit } from '@angular/core';
import {ClientVo} from '../../../controller/model/client.model';
import {ClientService} from '../../../controller/service/Client.service';

@Component({
  selector: 'app-client-details',
  templateUrl: './client-details.component.html',
  styleUrls: ['./client-details.component.css']
})

export class ClientDetailsComponent implements OnInit {

  constructor(private _clientService : ClientService) {}


   get clientService (): ClientService {
    return this._clientService;
  }

  set clientService (value: ClientService) {
    this._clientService = value ;
  }

  get clientDetail (): ClientVo {
    return this.clientService.clientDetail;
}

  set clientDetail (value: ClientVo) {
  this.clientService.clientDetail = value ;
}


get clientShowDetail (): boolean  {
  return this.clientService.clientShowDetail;
}

set clientShowDetail (value: boolean ) {
  this.clientService.clientShowDetail = value ;
}

  ngOnInit(): void {

  }

public detailHide(){
       this.clientService.detailHide();
}

}