import { Injectable } from '@angular/core';
import {HttpClient} from '@angular/common/http';
import {RoleVo} from '../model/role.model';
@Injectable({
  providedIn: 'root'
})
export class RoleService {

  constructor(private http: HttpClient) { }
  private _roleDetail : RoleVo =  new RoleVo() ;
  private _roleListe  : Array<RoleVo> = new Array<RoleVo>();
  
  private _roleSearch : RoleVo = new RoleVo();
  private _role: RoleVo =  new RoleVo();
  private _searchedRoles: Array<RoleVo> = new Array<RoleVo>();
  private _editableRoles: Array<RoleVo> = new Array<RoleVo>();

  get role(): RoleVo {
    if (this._role == null) {
      this._role = new RoleVo();
    }
    return this._role;
  }

  set role(value: RoleVo) {
    this._role = value;
  }

  get roleListe (): Array<RoleVo> {
  return this._roleListe;
}

set roleListe (value: Array<RoleVo>) {
  this._roleListe = value ;
}

get roleDetail (): RoleVo {
  return this._roleDetail;
}

set roleDetail (value: RoleVo) {
  this._roleDetail = value ;
}

get roleSearch (): RoleVo {
  return this._roleSearch;
}

set roleSearch (value: RoleVo) {
  this._roleSearch = value ;
}

get roleShowDetail (): boolean  {
  return this._roleShowDetail;
}

set roleShowDetail (value: boolean ) {
  this._roleShowDetail = value ;
}

  get editableRoles (): Array<RoleVo> {
   return this._editableRoles;
  }

  set editableRoles (value: Array<RoleVo>) {
   this._editableRoles = value;
  }

  public findAll(){
  this.http.get<Array<RoleVo>>('http://localhost:8036/generated/role/').subscribe(
    value => {
      if (value != null) {
           this.roleListe = value;
           this.editableRoles = value;
                                                 
      }
    }
  );
}

  public saveRole() {
  this.http.post('http://localhost:8036/generated/role/', this.role).subscribe();
  this.findAll();
  }

  public editRole() {
  this.http.put('http://localhost:8036/generated/role/', this.role).subscribe();
        this.findAll();
  }

   public findRole ( pojo : RoleVo ){
  this.http.post<Array<RoleVo>>('http://localhost:8036/generated/role/search/', pojo).subscribe(
    value =>{
       this.roleListe = value;  
    } );
}

public detailShow ( pojo : RoleVo ){
  this.http.get<RoleVo>('http://localhost:8036/generated/role/authority/'+pojo.authority).subscribe(
    value =>{
     if (value != null) { this.roleDetail = value;
        this.roleShowDetail = true;		}
    } );
}



delete(pojo: RoleVo) {
   this.http.delete<RoleVo>('http://localhost:8036/generated/role/id/'+pojo.id).subscribe(
        value => {
        var index = this.roleListe.indexOf(pojo);
if (index > -1) {
   this.roleListe.splice(index, 1);
}
}
        );


}


       public findByauthority(ref: string) {
      this.http.get<RoleVo>('http://localhost:8036/generated/role/authority/' + ref).subscribe(
        value => {
        if (value != null) { this.role = value; }
        }
        );
        }



          /***********************************************************************************************/
        private _roleShowDetail : boolean;
              public detailHide (){

       this.roleShowDetail = false;
       this.roleDetail = null;
                                  }
 private _roleShowEdit : boolean;

 private _roleShowCreate : boolean;

get roleShowEdit (): boolean  {
  return this._roleShowEdit;
}

set roleShowEdit (value: boolean ) {
  this._roleShowEdit = value ;
}
get roleShowCreate (): boolean  {
  return this._roleShowCreate;
}

set roleShowCreate (value: boolean ) {
  this._roleShowCreate = value ;
}
             public editShow(pojo : RoleVo ){

       this.roleShowEdit = true;
       this.role = pojo;
                                  }

              public editHide (){

       this.roleShowEdit = false;
       this.role = new RoleVo();
                                  }

               public createShow(){

       this.roleShowCreate = true;
       this.role = new RoleVo();
                                  }

              public createHide (){

       this.roleShowCreate = false;
       this.role = new RoleVo();
                                  }
}