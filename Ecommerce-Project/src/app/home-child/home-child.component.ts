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

  @Input() category: string;
  constructor(private http:Http) {
    
   }
  itemData;
  flag=false;
  static i=0;
  url=environment.serverUrl;
  dateNow:Date;
  ngOnInit() {
  
   
  }
  ngOnChanges(changes: SimpleChanges) {
    
     if(this.category.length>0)
        this.getData(this.category);
         
            
      }
    getData(ctype:string){
      this.http.get(environment.serverUrl+"getproductbycategory/"+ctype).
           //this.http.get(environment.serverUrl+"getallproduct").
             map(response=>response.json()).
               subscribe(data => {this.itemData=data
                
            } );
    }
}



