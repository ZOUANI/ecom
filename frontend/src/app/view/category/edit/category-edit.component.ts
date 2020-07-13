import {Component, OnInit} from '@angular/core';
import {CategoryService} from '../../../controller/service/Category.service';
import {CategoryVo} from '../../../controller/model/category.model';

@Component({
  selector: 'app-category-edit',
  templateUrl: './category-edit.component.html',
  styleUrls: ['./category-edit.component.css']
})
export class CategoryEditComponent implements OnInit {
  constructor(private categoryService: CategoryService) { }

   ngOnInit(): void {
    }

   get category(): CategoryVo {
    return this.categoryService.category;
  }

   get editableCategorys(): Array<CategoryVo> {
    return this.categoryService.editableCategorys;
   }

   set editableCategorys(value: Array<CategoryVo>) {
    this.categoryService.editableCategorys = value;
   }


   editCategory() {
    this.categoryService.editCategory();
  }

     findBylabel(ref: string) {
      this.categoryService.findBylabel(ref);
     }

    editHide() {
      this.categoryService.editHide();
    }
    

}