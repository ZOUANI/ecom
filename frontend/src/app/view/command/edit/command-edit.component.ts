import {Component, OnInit} from '@angular/core';
import {CommandService} from '../../../controller/service/Command.service';
import {CommandVo} from '../../../controller/model/command.model';
import {UserVo} from '../../../controller/model/User.model';
import {OrderLineVo} from '../../../controller/model/OrderLine.model';
import {CityVo} from '../../../controller/model/City.model';
import {ClientVo} from '../../../controller/model/Client.model';
import {OrderStatusVo} from '../../../controller/model/OrderStatus.model';

@Component({
  selector: 'app-command-edit',
  templateUrl: './command-edit.component.html',
  styleUrls: ['./command-edit.component.css']
})
export class CommandEditComponent implements OnInit {
  constructor(private commandService: CommandService) { }

   ngOnInit(): void {
       this.findAlldeliverys();
       this.findAllvalidators();
       this.findAlladmins();
       this.findAllclients();
       this.findAllorderStatuss();
       this.findAllcitys();
    }

   get command(): CommandVo {
    return this.commandService.command;
  }

   get editableCommands(): Array<CommandVo> {
    return this.commandService.editableCommands;
   }

   set editableCommands(value: Array<CommandVo>) {
    this.commandService.editableCommands = value;
   }

  get deliverys(): Array<UserVo> {
   return this.commandService.deliverys;
  }
  get validators(): Array<UserVo> {
   return this.commandService.validators;
  }
  get admins(): Array<UserVo> {
   return this.commandService.admins;
  }
  get clients(): Array<ClientVo> {
   return this.commandService.clients;
  }
  get orderStatuss(): Array<OrderStatusVo> {
   return this.commandService.orderStatuss;
  }
  get citys(): Array<CityVo> {
   return this.commandService.citys;
  }

  get orderLine(): OrderLineVo {
    return this.commandService.orderLine;
  }

  addOrderLine() {
   return this.commandService.addOrderLine();
  }

  removeOrderLine(i: number) {
   this.commandService.removeOrderLine(i);
  }
   editCommand() {
    this.commandService.editCommand();
  }
    findAlldeliverys() {
     this.commandService.findAlldeliverys();
    }
    findAllvalidators() {
     this.commandService.findAllvalidators();
    }
    findAlladmins() {
     this.commandService.findAlladmins();
    }
    findAllclients() {
     this.commandService.findAllclients();
    }
    findAllorderStatuss() {
     this.commandService.findAllorderStatuss();
    }
    findAllcitys() {
     this.commandService.findAllcitys();
    }

     findByreference(ref: string) {
      this.commandService.findByreference(ref);
     }


}