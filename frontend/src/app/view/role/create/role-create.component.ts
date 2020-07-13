import {Component, OnInit} from '@angular/core';
import {RoleService} from '../../../controller/service/Role.service';
import {RoleVo} from '../../../controller/model/role.model';

@Component({
  selector: 'app-role-create',
  templateUrl: './role-create.component.html',
  styleUrls: ['./role-create.component.css']
})
export class RoleCreateComponent implements OnInit {
  constructor(private roleService: RoleService) { }

   ngOnInit(): void {
    }

   get role(): RoleVo {
    return this.roleService.role;
  }


   saveRole() {
    this.roleService.saveRole();
  }


get roleShowCreate (): boolean  {
  return this.roleService.roleShowCreate;
}

set roleShowCreate (value: boolean ) {
  this.roleService.roleShowCreate = value ;
}
public createHide(){
       this.roleService.createHide();
}
}