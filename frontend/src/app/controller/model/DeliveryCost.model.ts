import {UserVo} from './User.model';
import {CityVo} from './City.model';

export class DeliveryCostVo {
  public shippingCost: string;
  public id: string;
     public shippingCostMax: string ;
     public shippingCostMin: string ;
      public cityVo: CityVo = new CityVo();
      public deliveryVo: UserVo = new UserVo();


}