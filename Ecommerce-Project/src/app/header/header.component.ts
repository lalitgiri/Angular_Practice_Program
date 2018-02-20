import { Component, OnInit } from '@angular/core';

import {TestService} from '../test-service.service'
import { Http } from '@angular/http';
import {} from 'bootstrap';
import 'rxjs/add/operator/map';
@Component({
  selector: 'app-header',
  templateUrl: './header.component.html',
  styleUrls: ['./header.component.css'
]
})
export class HeaderComponent implements OnInit {

  constructor(private http:Http) { }
  navData;
 // constructor(private _testService:TestService){}
  ngOnInit() {
     this.http.get("../../assets/testServiceData/navData.json").
    map(response=>response.json()).
    subscribe((data)=>{this.displayData(data);});
    

  //    this._testService.getNavData().
    //  subscribe(_result=>this.navData=_result);
  }

  displayData(data){this.navData=data;}
}
