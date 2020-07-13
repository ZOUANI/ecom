import { Component, OnInit } from '@angular/core';
import {CityVo} from '../../../controller/model/city.model';
import {CityService} from '../../../controller/service/City.service';

@Component({
  selector: 'app-city-details',
  templateUrl: './city-details.component.html',
  styleUrls: ['./city-details.component.css']
})

export class CityDetailsComponent implements OnInit {

  constructor(private _cityService : CityService) {}


   get cityService (): CityService {
    return this._cityService;
  }

  set cityService (value: CityService) {
    this._cityService = value ;
  }

  get cityDetail (): CityVo {
    return this.cityService.cityDetail;
}

  set cityDetail (value: CityVo) {
  this.cityService.cityDetail = value ;
}


get cityShowDetail (): boolean  {
  return this.cityService.cityShowDetail;
}

set cityShowDetail (value: boolean ) {
  this.cityService.cityShowDetail = value ;
}

  ngOnInit(): void {

  }

public detailHide(){
       this.cityService.detailHide();
}

}