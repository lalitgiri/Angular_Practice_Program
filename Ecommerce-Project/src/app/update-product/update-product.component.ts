import { Component, OnInit } from '@angular/core';
import { Http } from '@angular/http';
import { environment } from '../../environments/environment';

@Component({
  selector: 'app-update-product',
  templateUrl: './update-product.component.html',
  styleUrls: ['./update-product.component.css']
})
export class UpdateProductComponent implements OnInit {

  itemData:any;
  pname="";
  constructor(private http:Http) { }

  ngOnInit() {
    
    this.http.get(environment.serverUrl+"getallproduct").
  map(response=>response.json()).
  subscribe(data => this.itemData=data);
  }

  onSelect(data){
    this.pname=data.productName;
    console.log(data);
  }
}
