import { Component, OnInit } from '@angular/core';
import {CategoryProductVo} from '../../../controller/model/categoryProduct.model';
import {CategoryProductService} from '../../../controller/service/CategoryProduct.service';

@Component({
  selector: 'app-categoryProduct-details',
  templateUrl: './categoryProduct-details.component.html',
  styleUrls: ['./categoryProduct-details.component.css']
})

export class CategoryProductDetailsComponent implements OnInit {

  constructor(private _categoryProductService : CategoryProductService) {}


   get categoryProductService (): CategoryProductService {
    return this._categoryProductService;
  }

  set categoryProductService (value: CategoryProductService) {
    this._categoryProductService = value ;
  }

  get categoryProductDetail (): CategoryProductVo {
    return this.categoryProductService.categoryProductDetail;
}

  set categoryProductDetail (value: CategoryProductVo) {
  this.categoryProductService.categoryProductDetail = value ;
}


get categoryProductShowDetail (): boolean  {
  return this.categoryProductService.categoryProductShowDetail;
}

set categoryProductShowDetail (value: boolean ) {
  this.categoryProductService.categoryProductShowDetail = value ;
}

  ngOnInit(): void {

  }

public detailHide(){
       this.categoryProductService.detailHide();
}

}