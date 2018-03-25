import { Component, OnInit } from '@angular/core';
import { Http } from '@angular/http';

@Component({
  selector: 'app-update-product',
  templateUrl: './update-product.component.html',
  styleUrls: ['./update-product.component.css']
})
export class UpdateProductComponent implements OnInit {

  itemData:any;
  constructor(private http:Http) { }

  ngOnInit() {
    
    this.http.get("http://localhost:8080/getallproduct").
  map(response=>response.json()).
  subscribe(data => this.itemData=data);
  }

}
