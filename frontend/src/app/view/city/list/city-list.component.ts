import { Component, OnInit } from '@angular/core';
import {CityVo} from '../../../controller/model/city.model';
import {CityService} from '../../../controller/service/City.service';

@Component({
  selector: 'app-city-list',
  templateUrl: './city-list.component.html',
  styleUrls: ['./city-list.component.css']
})
export class CitylistComponent implements OnInit {

  constructor(private _cityService : CityService) {}


  ngOnInit(): void {
    this.findAll();
  }

  get cityService (): CityService {
    return this._cityService;
  }

  set cityService (value: CityService) {
    this._cityService = value ;
  }

  get cityListe (): Array<CityVo> {
    return this.cityService.cityListe;
  }

  set cityListe (value: Array<CityVo>) {
    this.cityService.cityListe = value ;
  }

  get cityDetail (): CityVo {
    return this.cityService.cityDetail;
}

  set cityDetail (value: CityVo) {
  this.cityService.cityDetail = value ;
}

get citySearch (): CityVo {
  return this.cityService.citySearch;
}

set citySearch (value: CityVo) {
  this.cityService.citySearch = value ;
}


get cityShowDetail (): boolean  {
  return this.cityService.cityShowDetail;
}

set cityShowDetail (value: boolean ) {
  this.cityService.cityShowDetail = value ;
}

get cityShowCreate (): boolean  {
  return this.cityService.cityShowCreate;
}

set cityShowCreate (value: boolean ) {
  this.cityService.cityShowCreate = value ;
}
get cityShowEdit (): boolean  {
  return this.cityService.cityShowEdit;
}

set cityShowEdit (value: boolean ) {
  this.cityService.cityShowEdit = value ;
}

  editShow( pojo : CityVo ) {
  this.cityService.editShow(pojo);

}
  createShow()  {
  this.cityService.createShow();

}

   delete( pojo : CityVo ) {
    this.cityService.delete(pojo);
  }


 detailShow( pojo : CityVo ) {
  this.cityService.detailShow( pojo);

}

 findCity(pojo : CityVo ) {
  this.cityService.findCity( pojo);

}
 findAll() {
  this.cityService.findAll();
}


}
