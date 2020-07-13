import { Component, OnInit } from '@angular/core';
import {CategoryVo} from '../../../controller/model/category.model';
import {CategoryService} from '../../../controller/service/Category.service';

@Component({
  selector: 'app-category-details',
  templateUrl: './category-details.component.html',
  styleUrls: ['./category-details.component.css']
})

export class CategoryDetailsComponent implements OnInit {

  constructor(private _categoryService : CategoryService) {}


   get categoryService (): CategoryService {
    return this._categoryService;
  }

  set categoryService (value: CategoryService) {
    this._categoryService = value ;
  }

  get categoryDetail (): CategoryVo {
    return this.categoryService.categoryDetail;
}

  set categoryDetail (value: CategoryVo) {
  this.categoryService.categoryDetail = value ;
}


get categoryShowDetail (): boolean  {
  return this.categoryService.categoryShowDetail;
}

set categoryShowDetail (value: boolean ) {
  this.categoryService.categoryShowDetail = value ;
}

  ngOnInit(): void {

  }

public detailHide(){
       this.categoryService.detailHide();
}

}