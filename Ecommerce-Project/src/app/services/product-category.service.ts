

// unused service.......


import { Injectable } from '@angular/core';
import { environment } from '../../environments/environment';
import { Http } from '@angular/http';

@Injectable()
export class ProductCategoryService {

  static httpData:string[];
  constructor(private http:Http) { 
   
  }
  getCategory():string[]{
    this.http.get(environment.serverUrl+"getallproductCategory").
    map(response=>response.json()).
    subscribe(data => {
      ProductCategoryService.httpData=data;
      
    });
    return ProductCategoryService.httpData; 
    
  }

}
