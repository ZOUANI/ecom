import {Component, OnInit} from '@angular/core';
import {UserService} from '../../../controller/service/User.service';
import {UserVo} from '../../../controller/model/user.model';
import {RoleVo} from '../../../controller/model/Role.model';
import {CityVo} from '../../../controller/model/City.model';
import {DeliveryTypeVo} from '../../../controller/model/DeliveryType.model';

@Component({
  selector: 'app-user-create',
  templateUrl: './user-create.component.html',
  styleUrls: ['./user-create.component.css']
})
export class UserCreateComponent implements OnInit {
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

   saveUser() {
    this.userService.saveUser();
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

}