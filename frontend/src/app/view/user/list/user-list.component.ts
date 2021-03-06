import { Component, OnInit } from '@angular/core';
import {UserVo} from '../../../controller/model/user.model';
import {UserService} from '../../../controller/service/User.service';
import {RoleVo} from '../../../controller/model/Role.model';
import {CityVo} from '../../../controller/model/City.model';
import {DeliveryTypeVo} from '../../../controller/model/DeliveryType.model';

@Component({
  selector: 'app-user-list',
  templateUrl: './user-list.component.html',
  styleUrls: ['./user-list.component.css']
})
export class UserlistComponent implements OnInit {

  constructor(private _userService : UserService) {}

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

  ngOnInit(): void {
    this.findAll();
      this.findAllsuperAdmins();
      this.findAlldeliveryTypes();
      this.findAllcitys();
      this.findAllauthoritys();
  }

  get userService (): UserService {
    return this._userService;
  }

  set userService (value: UserService) {
    this._userService = value ;
  }

  get userListe (): Array<UserVo> {
    return this.userService.userListe;
  }

  set userListe (value: Array<UserVo>) {
    this.userService.userListe = value ;
  }

  get userDetail (): UserVo {
    return this.userService.userDetail;
}

  set userDetail (value: UserVo) {
  this.userService.userDetail = value ;
}

get userSearch (): UserVo {
  return this.userService.userSearch;
}

set userSearch (value: UserVo) {
  this.userService.userSearch = value ;
}


get userShowDetail (): boolean  {
  return this.userService.userShowDetail;
}

set userShowDetail (value: boolean ) {
  this.userService.userShowDetail = value ;
}


   delete( pojo : UserVo ) {
    this.userService.delete(pojo);
  }


 detailShow( pojo : UserVo ) {
  this.userService.detailShow( pojo);

}

 findUser(pojo : UserVo ) {
  this.userService.findUser( pojo);

}
 findAll() {
  this.userService.findAll();
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
