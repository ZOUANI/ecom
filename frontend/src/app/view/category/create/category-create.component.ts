import {Component, OnInit} from '@angular/core';
import {CategoryService} from '../../../controller/service/Category.service';
import {CategoryVo} from '../../../controller/model/category.model';

@Component({
  selector: 'app-category-create',
  templateUrl: './category-create.component.html',
  styleUrls: ['./category-create.component.css']
})
export class CategoryCreateComponent implements OnInit {
  constructor(private categoryService: CategoryService) { }

   ngOnInit(): void {
    }

   get category(): CategoryVo {
    return this.categoryService.category;
  }


   saveCategory() {
    this.categoryService.saveCategory();
  }


get categoryShowCreate (): boolean  {
  return this.categoryService.categoryShowCreate;
}

set categoryShowCreate (value: boolean ) {
  this.categoryService.categoryShowCreate = value ;
}
public createHide(){
       this.categoryService.createHide();
}
}