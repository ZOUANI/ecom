import {UserVo} from './User.model';
import {ProductVo} from './Product.model';
import {CityVo} from './City.model';

export class StockVo {
  public id: string;
  public qte: string;
     public qteMax: string ;
     public qteMin: string ;
      public cityVo: CityVo = new CityVo();
      public productVo: ProductVo = new ProductVo();
      public adminVo: UserVo = new UserVo();


}