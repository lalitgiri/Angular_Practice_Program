import { Component } from '@angular/core';
import {IProduct} from '../product';
import {ProductService} from '../service/product.service';

import { Http , Response } from '@angular/http';
import { Observable } from 'rxjs/Observable';
import 'rxjs/add/operator/map';

@Component({
  selector: 'app-root',
 
   templateUrl: './app.component.html',
   providers: [ProductService]
})
export class AppComponent {

  iproducts:IProduct[];
  constructor(private _product: ProductService){


  }
 ngOnInit() : void{

  this._product.getproducts().subscribe(IProduct =>this.iproducts =IProduct);
 }
  
}
