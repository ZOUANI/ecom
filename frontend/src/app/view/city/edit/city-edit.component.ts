import {Component, OnInit} from '@angular/core';
import {CityService} from '../../../controller/service/City.service';
import {CityVo} from '../../../controller/model/city.model';

@Component({
  selector: 'app-city-edit',
  templateUrl: './city-edit.component.html',
  styleUrls: ['./city-edit.component.css']
})
export class CityEditComponent implements OnInit {
  constructor(private cityService: CityService) { }

   ngOnInit(): void {
    }

   get city(): CityVo {
    return this.cityService.city;
  }

   get editableCitys(): Array<CityVo> {
    return this.cityService.editableCitys;
   }

   set editableCitys(value: Array<CityVo>) {
    this.cityService.editableCitys = value;
   }


   editCity() {
    this.cityService.editCity();
  }

     findByname(ref: string) {
      this.cityService.findByname(ref);
     }

    editHide() {
      this.cityService.editHide();
    }
    

}