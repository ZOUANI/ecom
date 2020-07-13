import {Component, OnInit} from '@angular/core';
import {ClientService} from '../../../controller/service/Client.service';
import {ClientVo} from '../../../controller/model/client.model';
import {CommandVo} from '../../../controller/model/Command.model';
import {CityVo} from '../../../controller/model/City.model';

@Component({
  selector: 'app-client-edit',
  templateUrl: './client-edit.component.html',
  styleUrls: ['./client-edit.component.css']
})
export class ClientEditComponent implements OnInit {
  constructor(private clientService: ClientService) { }

   ngOnInit(): void {
       this.findAllcitys();
    }

   get client(): ClientVo {
    return this.clientService.client;
  }

   get editableClients(): Array<ClientVo> {
    return this.clientService.editableClients;
   }

   set editableClients(value: Array<ClientVo>) {
    this.clientService.editableClients = value;
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
   editClient() {
    this.clientService.editClient();
  }
    findAllcitys() {
     this.clientService.findAllcitys();
    }

      findByid(identifier: string) {
       this.clientService.findByid(identifier);
      }


}