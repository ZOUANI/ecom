import { Component, OnInit } from '@angular/core';
import {ClientVo} from '../../../controller/model/client.model';
import {ClientService} from '../../../controller/service/Client.service';
import {CommandVo} from '../../../controller/model/Command.model';
import {CityVo} from '../../../controller/model/City.model';

@Component({
  selector: 'app-client-list',
  templateUrl: './client-list.component.html',
  styleUrls: ['./client-list.component.css']
})
export class ClientlistComponent implements OnInit {

  constructor(private _clientService : ClientService) {}

  get citys(): Array<CityVo> {
   return this.clientService.citys;
  }

  ngOnInit(): void {
    this.findAll();
      this.findAllcitys();
  }

  get clientService (): ClientService {
    return this._clientService;
  }

  set clientService (value: ClientService) {
    this._clientService = value ;
  }

  get clientListe (): Array<ClientVo> {
    return this.clientService.clientListe;
  }

  set clientListe (value: Array<ClientVo>) {
    this.clientService.clientListe = value ;
  }

  get clientDetail (): ClientVo {
    return this.clientService.clientDetail;
}

  set clientDetail (value: ClientVo) {
  this.clientService.clientDetail = value ;
}

get clientSearch (): ClientVo {
  return this.clientService.clientSearch;
}

set clientSearch (value: ClientVo) {
  this.clientService.clientSearch = value ;
}


get clientShowDetail (): boolean  {
  return this.clientService.clientShowDetail;
}

set clientShowDetail (value: boolean ) {
  this.clientService.clientShowDetail = value ;
}


   delete( pojo : ClientVo ) {
    this.clientService.delete(pojo);
  }


 detailShow( pojo : ClientVo ) {
  this.clientService.detailShow( pojo);

}

 findClient(pojo : ClientVo ) {
  this.clientService.findClient( pojo);

}
 findAll() {
  this.clientService.findAll();
}

   findAllcitys() {
     this.clientService.findAllcitys();
   }

}
