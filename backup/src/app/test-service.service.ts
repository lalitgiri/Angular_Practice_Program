import { Injectable } from '@angular/core';

import {Http,Response} from "@angular/http";
@Injectable()
export class TestService {

  private _url:string="testServiceData/navData.json";
  constructor(private _http:Http) { }

    getNavData(){
      return this._http.get(this._url).
      map((response:Response)=>response.json());
    }
}
