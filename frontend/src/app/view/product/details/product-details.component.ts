import { Component, OnInit } from '@angular/core';
import {ProductVo} from '../../../controller/model/product.model';
import {ProductService} from '../../../controller/service/Product.service';

@Component({
  selector: 'app-product-details',
  templateUrl: './product-details.component.html',
  styleUrls: ['./product-details.component.css']
})

export class ProductDetailsComponent implements OnInit {

  constructor(private _productService : ProductService) {}


   get productService (): ProductService {
    return this._productService;
  }

  set productService (value: ProductService) {
    this._productService = value ;
  }

  get productDetail (): ProductVo {
    return this.productService.productDetail;
}

  set productDetail (value: ProductVo) {
  this.productService.productDetail = value ;
}


get productShowDetail (): boolean  {
  return this.productService.productShowDetail;
}

set productShowDetail (value: boolean ) {
  this.productService.productShowDetail = value ;
}

  ngOnInit(): void {

  }

public detailHide(){
       this.productService.detailHide();
}

}