import { Component, OnInit } from '@angular/core';
import {CategoryVo} from '../../../controller/model/category.model';
import {CategoryService} from '../../../controller/service/Category.service';

@Component({
  selector: 'app-category-list',
  templateUrl: './category-list.component.html',
  styleUrls: ['./category-list.component.css']
})
export class CategorylistComponent implements OnInit {

  constructor(private _categoryService : CategoryService) {}


  ngOnInit(): void {
    this.findAll();
  }

  get categoryService (): CategoryService {
    return this._categoryService;
  }

  set categoryService (value: CategoryService) {
    this._categoryService = value ;
  }

  get categoryListe (): Array<CategoryVo> {
    return this.categoryService.categoryListe;
  }

  set categoryListe (value: Array<CategoryVo>) {
    this.categoryService.categoryListe = value ;
  }

  get categoryDetail (): CategoryVo {
    return this.categoryService.categoryDetail;
}

  set categoryDetail (value: CategoryVo) {
  this.categoryService.categoryDetail = value ;
}

get categorySearch (): CategoryVo {
  return this.categoryService.categorySearch;
}

set categorySearch (value: CategoryVo) {
  this.categoryService.categorySearch = value ;
}


get categoryShowDetail (): boolean  {
  return this.categoryService.categoryShowDetail;
}

set categoryShowDetail (value: boolean ) {
  this.categoryService.categoryShowDetail = value ;
}

get categoryShowCreate (): boolean  {
  return this.categoryService.categoryShowCreate;
}

set categoryShowCreate (value: boolean ) {
  this.categoryService.categoryShowCreate = value ;
}
get categoryShowEdit (): boolean  {
  return this.categoryService.categoryShowEdit;
}

set categoryShowEdit (value: boolean ) {
  this.categoryService.categoryShowEdit = value ;
}

  editShow( pojo : CategoryVo ) {
  this.categoryService.editShow(pojo);

}
  createShow()  {
  this.categoryService.createShow();

}

   delete( pojo : CategoryVo ) {
    this.categoryService.delete(pojo);
  }


 detailShow( pojo : CategoryVo ) {
  this.categoryService.detailShow( pojo);

}

 findCategory(pojo : CategoryVo ) {
  this.categoryService.findCategory( pojo);

}
 findAll() {
  this.categoryService.findAll();
}


}
