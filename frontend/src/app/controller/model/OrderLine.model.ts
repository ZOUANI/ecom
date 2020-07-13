import {CommandVo} from './Command.model';
import {ProductVo} from './Product.model';

export class OrderLineVo {
  public price: string;
  public id: string;
     public priceMax: string ;
     public priceMin: string ;
      public commandVo: CommandVo = new CommandVo();
      public productVo: ProductVo = new ProductVo();


}