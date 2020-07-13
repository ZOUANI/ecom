import {Component, OnInit} from '@angular/core';
import {ClientService} from '../../../controller/service/Client.service';
import {ClientVo} from '../../../controller/model/client.model';
import {CommandVo} from '../../../controller/model/Command.model';
import {CityVo} from '../../../controller/model/City.model';

@Component({
  selector: 'app-client-create',
  templateUrl: './client-create.component.html',
  styleUrls: ['./client-create.component.css']
})
export class ClientCreateComponent implements OnInit {
  constructor(private clientService: ClientService) { }

   ngOnInit(): void {
      this.findAllcitys();
    }

   get client(): ClientVo {
    return this.clientService.client;
  }

  get citys(): Array<CityVo> {
   return this.clientService.citys;
  }

  get command(): CommandVo {
    return this.clientService.command;
  }

  addCommand() {
   return this.clientService.addCommand();
  }

  removeCommand(i: number) {
   this.clientService.removeCommand(i);
  }
   saveClient() {
    this.clientService.saveClient();
  }

   findAllcitys() {
     this.clientService.findAllcitys();
   }

}