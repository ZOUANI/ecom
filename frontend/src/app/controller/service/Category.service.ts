import { Injectable } from '@angular/core';
import {HttpClient} from '@angular/common/http';
import {CategoryVo} from '../model/category.model';
@Injectable({
  providedIn: 'root'
})
export class CategoryService {

  constructor(private http: HttpClient) { }
  private _categoryDetail : CategoryVo =  new CategoryVo() ;
  private _categoryListe  : Array<CategoryVo> = new Array<CategoryVo>();
  
  private _categorySearch : CategoryVo = new CategoryVo();
  private _category: CategoryVo =  new CategoryVo();
  private _searchedCategorys: Array<CategoryVo> = new Array<CategoryVo>();
  private _editableCategorys: Array<CategoryVo> = new Array<CategoryVo>();

  get category(): CategoryVo {
    if (this._category == null) {
      this._category = new CategoryVo();
    }
    return this._category;
  }

  set category(value: CategoryVo) {
    this._category = value;
  }

  get categoryListe (): Array<CategoryVo> {
  return this._categoryListe;
}

set categoryListe (value: Array<CategoryVo>) {
  this._categoryListe = value ;
}

get categoryDetail (): CategoryVo {
  return this._categoryDetail;
}

set categoryDetail (value: CategoryVo) {
  this._categoryDetail = value ;
}

get categorySearch (): CategoryVo {
  return this._categorySearch;
}

set categorySearch (value: CategoryVo) {
  this._categorySearch = value ;
}

get categoryShowDetail (): boolean  {
  return this._categoryShowDetail;
}

set categoryShowDetail (value: boolean ) {
  this._categoryShowDetail = value ;
}

  get editableCategorys (): Array<CategoryVo> {
   return this._editableCategorys;
  }

  set editableCategorys (value: Array<CategoryVo>) {
   this._editableCategorys = value;
  }

  public findAll(){
  this.http.get<Array<CategoryVo>>('http://localhost:8036/generated/category/').subscribe(
    value => {
      if (value != null) {
           this.categoryListe = value;
           this.editableCategorys = value;
                                                 
      }
    }
  );
}

  public saveCategory() {
  this.http.post('http://localhost:8036/generated/category/', this.category).subscribe();
  this.findAll();
  }

  public editCategory() {
  this.http.put('http://localhost:8036/generated/category/', this.category).subscribe();
        this.findAll();
  }

   public findCategory ( pojo : CategoryVo ){
  this.http.post<Array<CategoryVo>>('http://localhost:8036/generated/category/search/', pojo).subscribe(
    value =>{
       this.categoryListe = value;  
    } );
}

public detailShow ( pojo : CategoryVo ){
  this.http.get<CategoryVo>('http://localhost:8036/generated/category/label/'+pojo.label).subscribe(
    value =>{
     if (value != null) { this.categoryDetail = value;
        this.categoryShowDetail = true;		}
    } );
}



delete(pojo: CategoryVo) {
   this.http.delete<CategoryVo>('http://localhost:8036/generated/category/id/'+pojo.id).subscribe(
        value => {
        var index = this.categoryListe.indexOf(pojo);
if (index > -1) {
   this.categoryListe.splice(index, 1);
}
}
        );


}


       public findBylabel(ref: string) {
      this.http.get<CategoryVo>('http://localhost:8036/generated/category/label/' + ref).subscribe(
        value => {
        if (value != null) { this.category = value; }
        }
        );
        }



          /***********************************************************************************************/
        private _categoryShowDetail : boolean;
              public detailHide (){

       this.categoryShowDetail = false;
       this.categoryDetail = null;
                                  }
 private _categoryShowEdit : boolean;

 private _categoryShowCreate : boolean;

get categoryShowEdit (): boolean  {
  return this._categoryShowEdit;
}

set categoryShowEdit (value: boolean ) {
  this._categoryShowEdit = value ;
}
get categoryShowCreate (): boolean  {
  return this._categoryShowCreate;
}

set categoryShowCreate (value: boolean ) {
  this._categoryShowCreate = value ;
}
             public editShow(pojo : CategoryVo ){

       this.categoryShowEdit = true;
       this.category = pojo;
                                  }

              public editHide (){

       this.categoryShowEdit = false;
       this.category = new CategoryVo();
                                  }

               public createShow(){

       this.categoryShowCreate = true;
       this.category = new CategoryVo();
                                  }

              public createHide (){

       this.categoryShowCreate = false;
       this.category = new CategoryVo();
                                  }
}