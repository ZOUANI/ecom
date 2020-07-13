import {CategoryVo} from './Category.model';
import {ProductVo} from './Product.model';

export class CategoryProductVo {
  public id: string;
      public categoryVo: CategoryVo = new CategoryVo();
      public productVo: ProductVo = new ProductVo();


}