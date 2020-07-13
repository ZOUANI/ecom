import { Component, OnInit } from '@angular/core';
import {CommandVo} from '../../../controller/model/command.model';
import {CommandService} from '../../../controller/service/Command.service';

@Component({
  selector: 'app-command-details',
  templateUrl: './command-details.component.html',
  styleUrls: ['./command-details.component.css']
})

export class CommandDetailsComponent implements OnInit {

  constructor(private _commandService : CommandService) {}


   get commandService (): CommandService {
    return this._commandService;
  }

  set commandService (value: CommandService) {
    this._commandService = value ;
  }

  get commandDetail (): CommandVo {
    return this.commandService.commandDetail;
}

  set commandDetail (value: CommandVo) {
  this.commandService.commandDetail = value ;
}


get commandShowDetail (): boolean  {
  return this.commandService.commandShowDetail;
}

set commandShowDetail (value: boolean ) {
  this.commandService.commandShowDetail = value ;
}

  ngOnInit(): void {

  }

public detailHide(){
       this.commandService.detailHide();
}

}