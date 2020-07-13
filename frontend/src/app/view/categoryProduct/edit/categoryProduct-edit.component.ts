import {Component, OnInit} from '@angular/core';
import {CategoryProductService} from '../../../controller/service/CategoryProduct.service';
import {CategoryProductVo} from '../../../controller/model/categoryProduct.model';
import {CategoryVo} from '../../../controller/model/Category.model';
import {ProductVo} from '../../../controller/model/Product.model';

@Component({
  selector: 'app-categoryProduct-edit',
  templateUrl: './categoryProduct-edit.component.html',
  styleUrls: ['./categoryProduct-edit.component.css']
})
export class CategoryProductEditComponent implements OnInit {
  constructor(private categoryProductService: CategoryProductService) { }

   ngOnInit(): void {
       this.findAllcategorys();
       this.findAllproducts();
    }

   get categoryProduct(): CategoryProductVo {
    return this.categoryProductService.categoryProduct;
  }

   get editableCategoryProducts(): Array<CategoryProductVo> {
    return this.categoryProductService.editableCategoryProducts;
   }

   set editableCategoryProducts(value: Array<CategoryProductVo>) {
    this.categoryProductService.editableCategoryProducts = value;
   }

  get categorys(): Array<CategoryVo> {
   return this.categoryProductService.categorys;
  }
  get products(): Array<ProductVo> {
   return this.categoryProductService.products;
  }

   editCategoryProduct() {
    this.categoryProductService.editCategoryProduct();
  }
    findAllcategorys() {
     this.categoryProductService.findAllcategorys();
    }
    findAllproducts() {
     this.categoryProductService.findAllproducts();
    }

      findByid(identifier: string) {
       this.categoryProductService.findByid(identifier);
      }

    editHide() {
      this.categoryProductService.editHide();
    }
    

}