import { Injectable } from '@angular/core';
import {HttpClient} from '@angular/common/http';
import {CategoryProductVo} from '../model/categoryProduct.model';
import {CategoryVo} from '../model/Category.model';
import {ProductVo} from '../model/Product.model';
@Injectable({
  providedIn: 'root'
})
export class CategoryProductService {

  constructor(private http: HttpClient) { }
  private _categoryProductDetail : CategoryProductVo =  new CategoryProductVo() ;
  private _categoryProductListe  : Array<CategoryProductVo> = new Array<CategoryProductVo>();
  
  private _categoryProductSearch : CategoryProductVo = new CategoryProductVo();
  private _categoryProduct: CategoryProductVo =  new CategoryProductVo();
  private _searchedCategoryProducts: Array<CategoryProductVo> = new Array<CategoryProductVo>();
  private _editableCategoryProducts: Array<CategoryProductVo> = new Array<CategoryProductVo>();
  private _categorys: Array<CategoryVo> = new Array<CategoryVo>();
  private _products: Array<ProductVo> = new Array<ProductVo>();
   get categorys(): Array<CategoryVo> {
    return this._categorys;
   }

   set categorys(value: Array<CategoryVo>) {
    this._categorys = value;
   }
   get products(): Array<ProductVo> {
    return this._products;
   }

   set products(value: Array<ProductVo>) {
    this._products = value;
   }

  get categoryProduct(): CategoryProductVo {
    if (this._categoryProduct == null) {
      this._categoryProduct = new CategoryProductVo();
    }
    return this._categoryProduct;
  }

  set categoryProduct(value: CategoryProductVo) {
    this._categoryProduct = value;
  }

  get categoryProductListe (): Array<CategoryProductVo> {
  return this._categoryProductListe;
}

set categoryProductListe (value: Array<CategoryProductVo>) {
  this._categoryProductListe = value ;
}

get categoryProductDetail (): CategoryProductVo {
  return this._categoryProductDetail;
}

set categoryProductDetail (value: CategoryProductVo) {
  this._categoryProductDetail = value ;
}

get categoryProductSearch (): CategoryProductVo {
  return this._categoryProductSearch;
}

set categoryProductSearch (value: CategoryProductVo) {
  this._categoryProductSearch = value ;
}

get categoryProductShowDetail (): boolean  {
  return this._categoryProductShowDetail;
}

set categoryProductShowDetail (value: boolean ) {
  this._categoryProductShowDetail = value ;
}

  get editableCategoryProducts (): Array<CategoryProductVo> {
   return this._editableCategoryProducts;
  }

  set editableCategoryProducts (value: Array<CategoryProductVo>) {
   this._editableCategoryProducts = value;
  }

  public findAll(){
  this.http.get<Array<CategoryProductVo>>('http://localhost:8036/generated/categoryProduct/').subscribe(
    value => {
      if (value != null) {
           this.categoryProductListe = value;
           this.editableCategoryProducts = value;
                                                 
      }
    }
  );
}

  public saveCategoryProduct() {
  this.http.post('http://localhost:8036/generated/categoryProduct/', this.categoryProduct).subscribe();
  this.findAll();
  }

  public editCategoryProduct() {
  this.http.put('http://localhost:8036/generated/categoryProduct/', this.categoryProduct).subscribe();
        this.findAll();
  }

   public findCategoryProduct ( pojo : CategoryProductVo ){
  this.http.post<Array<CategoryProductVo>>('http://localhost:8036/generated/categoryProduct/search/', pojo).subscribe(
    value =>{
       this.categoryProductListe = value;  
    } );
}

public detailShow ( pojo : CategoryProductVo ){
  this.http.get<CategoryProductVo>('http://localhost:8036/generated/categoryProduct/id/'+pojo.id).subscribe(
    value =>{
     if (value != null) { this.categoryProductDetail = value;
        this.categoryProductShowDetail = true;		}
    } );
}



delete(pojo: CategoryProductVo) {
   this.http.delete<CategoryProductVo>('http://localhost:8036/generated/categoryProduct/id/'+pojo.id).subscribe(
        value => {
        var index = this.categoryProductListe.indexOf(pojo);
if (index > -1) {
   this.categoryProductListe.splice(index, 1);
}
}
        );


}


        public findByid(identifier: string) {
        this.http.get<CategoryProductVo>('http://localhost:8036/generated/categoryProduct/id/' + identifier).subscribe(
          value => {
          if (value != null) { this.categoryProduct = value; }
          }
          );
          }

            public findAllcategorys() {
             this.http.get<Array<CategoryVo>>('http://localhost:8036/generated/category/').subscribe(
            value => {
            if (value != null) { this.categorys = value; }
            }
            );
            }
            public findAllproducts() {
             this.http.get<Array<ProductVo>>('http://localhost:8036/generated/product/').subscribe(
            value => {
            if (value != null) { this.products = value; }
            }
            );
            }


          /***********************************************************************************************/
        private _categoryProductShowDetail : boolean;
              public detailHide (){

       this.categoryProductShowDetail = false;
       this.categoryProductDetail = null;
                                  }
 private _categoryProductShowEdit : boolean;

 private _categoryProductShowCreate : boolean;

get categoryProductShowEdit (): boolean  {
  return this._categoryProductShowEdit;
}

set categoryProductShowEdit (value: boolean ) {
  this._categoryProductShowEdit = value ;
}
get categoryProductShowCreate (): boolean  {
  return this._categoryProductShowCreate;
}

set categoryProductShowCreate (value: boolean ) {
  this._categoryProductShowCreate = value ;
}
             public editShow(pojo : CategoryProductVo ){

       this.categoryProductShowEdit = true;
       this.categoryProduct = pojo;
                                  }

              public editHide (){

       this.categoryProductShowEdit = false;
       this.categoryProduct = new CategoryProductVo();
                                  }

               public createShow(){

       this.categoryProductShowCreate = true;
       this.categoryProduct = new CategoryProductVo();
                                  }

              public createHide (){

       this.categoryProductShowCreate = false;
       this.categoryProduct = new CategoryProductVo();
                                  }
}