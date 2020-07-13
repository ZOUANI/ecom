import {Component, OnInit} from '@angular/core';
import {UserService} from '../../../controller/service/User.service';
import {UserVo} from '../../../controller/model/user.model';
import {RoleVo} from '../../../controller/model/Role.model';
import {CityVo} from '../../../controller/model/City.model';
import {DeliveryTypeVo} from '../../../controller/model/DeliveryType.model';

@Component({
  selector: 'app-user-edit',
  templateUrl: './user-edit.component.html',
  styleUrls: ['./user-edit.component.css']
})
export class UserEditComponent implements OnInit {
  constructor(private userService: UserService) { }

   ngOnInit(): void {
       this.findAllsuperAdmins();
       this.findAlldeliveryTypes();
       this.findAllcitys();
       this.findAllauthoritys();
    }

   get user(): UserVo {
    return this.userService.user;
  }

   get editableUsers(): Array<UserVo> {
    return this.userService.editableUsers;
   }

   set editableUsers(value: Array<UserVo>) {
    this.userService.editableUsers = value;
   }

  get superAdmins(): Array<UserVo> {
   return this.userService.superAdmins;
  }
  get deliveryTypes(): Array<DeliveryTypeVo> {
   return this.userService.deliveryTypes;
  }
  get citys(): Array<CityVo> {
   return this.userService.citys;
  }
  get authoritys(): Array<RoleVo> {
   return this.userService.authoritys;
  }

   editUser() {
    this.userService.editUser();
  }
    findAllsuperAdmins() {
     this.userService.findAllsuperAdmins();
    }
    findAlldeliveryTypes() {
     this.userService.findAlldeliveryTypes();
    }
    findAllcitys() {
     this.userService.findAllcitys();
    }
    findAllauthoritys() {
     this.userService.findAllauthoritys();
    }

     findBycode(ref: string) {
      this.userService.findBycode(ref);
     }


}