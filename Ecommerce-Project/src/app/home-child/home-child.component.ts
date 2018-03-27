import { Component, OnInit, Input, Output, SimpleChanges, ChangeDetectorRef } from '@angular/core';
import { environment } from '../../environments/environment';
import { Http } from '@angular/http';

import { ProductCategoryService } from '../services/product-category.service';
@Component({
  selector: 'app-home-child',
  templateUrl: './home-child.component.html',
  
  styleUrls: ['./home-child.component.css']
})
export class HomeChildComponent implements OnInit {

  @Input() category: String;
  constructor(private http:Http) { }
  itemData;
 
  static i=0;
  url=environment.serverUrl;
  dateNow:Date;
  ngOnInit() {
    /*const abc=this.productCategoryService.getCategory();
    console.log(abc);
    debugger;*/
  }
  ngOnChanges() {
    
        this.http.get(environment.serverUrl+"getproductbycategory/"+this.category).
           //this.http.get(environment.serverUrl+"getallproduct").
             map(response=>response.json()).
               subscribe(data => {this.itemData=data
         
            } ); 
      
}


}
