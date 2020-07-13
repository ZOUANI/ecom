import {Component, OnInit} from '@angular/core';
import {CategoryProductService} from '../../../controller/service/CategoryProduct.service';
import {CategoryProductVo} from '../../../controller/model/categoryProduct.model';
import {CategoryVo} from '../../../controller/model/Category.model';
import {ProductVo} from '../../../controller/model/Product.model';

@Component({
  selector: 'app-categoryProduct-create',
  templateUrl: './categoryProduct-create.component.html',
  styleUrls: ['./categoryProduct-create.component.css']
})
export class CategoryProductCreateComponent implements OnInit {
  constructor(private categoryProductService: CategoryProductService) { }

   ngOnInit(): void {
      this.findAllcategorys();
      this.findAllproducts();
    }

   get categoryProduct(): CategoryProductVo {
    return this.categoryProductService.categoryProduct;
  }

  get categorys(): Array<CategoryVo> {
   return this.categoryProductService.categorys;
  }
  get products(): Array<ProductVo> {
   return this.categoryProductService.products;
  }

   saveCategoryProduct() {
    this.categoryProductService.saveCategoryProduct();
  }

   findAllcategorys() {
     this.categoryProductService.findAllcategorys();
   }
   findAllproducts() {
     this.categoryProductService.findAllproducts();
   }

get categoryProductShowCreate (): boolean  {
  return this.categoryProductService.categoryProductShowCreate;
}

set categoryProductShowCreate (value: boolean ) {
  this.categoryProductService.categoryProductShowCreate = value ;
}
public createHide(){
       this.categoryProductService.createHide();
}
}