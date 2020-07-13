import { Component, OnInit } from '@angular/core';
import {CategoryProductVo} from '../../../controller/model/categoryProduct.model';
import {CategoryProductService} from '../../../controller/service/CategoryProduct.service';
import {CategoryVo} from '../../../controller/model/Category.model';
import {ProductVo} from '../../../controller/model/Product.model';

@Component({
  selector: 'app-categoryProduct-list',
  templateUrl: './categoryProduct-list.component.html',
  styleUrls: ['./categoryProduct-list.component.css']
})
export class CategoryProductlistComponent implements OnInit {

  constructor(private _categoryProductService : CategoryProductService) {}

  get categorys(): Array<CategoryVo> {
   return this.categoryProductService.categorys;
  }
  get products(): Array<ProductVo> {
   return this.categoryProductService.products;
  }

  ngOnInit(): void {
    this.findAll();
      this.findAllcategorys();
      this.findAllproducts();
  }

  get categoryProductService (): CategoryProductService {
    return this._categoryProductService;
  }

  set categoryProductService (value: CategoryProductService) {
    this._categoryProductService = value ;
  }

  get categoryProductListe (): Array<CategoryProductVo> {
    return this.categoryProductService.categoryProductListe;
  }

  set categoryProductListe (value: Array<CategoryProductVo>) {
    this.categoryProductService.categoryProductListe = value ;
  }

  get categoryProductDetail (): CategoryProductVo {
    return this.categoryProductService.categoryProductDetail;
}

  set categoryProductDetail (value: CategoryProductVo) {
  this.categoryProductService.categoryProductDetail = value ;
}

get categoryProductSearch (): CategoryProductVo {
  return this.categoryProductService.categoryProductSearch;
}

set categoryProductSearch (value: CategoryProductVo) {
  this.categoryProductService.categoryProductSearch = value ;
}


get categoryProductShowDetail (): boolean  {
  return this.categoryProductService.categoryProductShowDetail;
}

set categoryProductShowDetail (value: boolean ) {
  this.categoryProductService.categoryProductShowDetail = value ;
}

get categoryProductShowCreate (): boolean  {
  return this.categoryProductService.categoryProductShowCreate;
}

set categoryProductShowCreate (value: boolean ) {
  this.categoryProductService.categoryProductShowCreate = value ;
}
get categoryProductShowEdit (): boolean  {
  return this.categoryProductService.categoryProductShowEdit;
}

set categoryProductShowEdit (value: boolean ) {
  this.categoryProductService.categoryProductShowEdit = value ;
}

  editShow( pojo : CategoryProductVo ) {
  this.categoryProductService.editShow(pojo);

}
  createShow()  {
  this.categoryProductService.createShow();

}

   delete( pojo : CategoryProductVo ) {
    this.categoryProductService.delete(pojo);
  }


 detailShow( pojo : CategoryProductVo ) {
  this.categoryProductService.detailShow( pojo);

}

 findCategoryProduct(pojo : CategoryProductVo ) {
  this.categoryProductService.findCategoryProduct( pojo);

}
 findAll() {
  this.categoryProductService.findAll();
}

   findAllcategorys() {
     this.categoryProductService.findAllcategorys();
   }
   findAllproducts() {
     this.categoryProductService.findAllproducts();
   }

}
