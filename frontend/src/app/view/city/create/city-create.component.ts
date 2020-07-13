import {Component, OnInit} from '@angular/core';
import {CityService} from '../../../controller/service/City.service';
import {CityVo} from '../../../controller/model/city.model';

@Component({
  selector: 'app-city-create',
  templateUrl: './city-create.component.html',
  styleUrls: ['./city-create.component.css']
})
export class CityCreateComponent implements OnInit {
  constructor(private cityService: CityService) { }

   ngOnInit(): void {
    }

   get city(): CityVo {
    return this.cityService.city;
  }


   saveCity() {
    this.cityService.saveCity();
  }


get cityShowCreate (): boolean  {
  return this.cityService.cityShowCreate;
}

set cityShowCreate (value: boolean ) {
  this.cityService.cityShowCreate = value ;
}
public createHide(){
       this.cityService.createHide();
}
}