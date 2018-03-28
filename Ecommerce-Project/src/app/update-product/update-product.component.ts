import { Component, OnInit } from '@angular/core';
import { Http } from '@angular/http';
import { environment } from '../../environments/environment';

@Component({
  selector: 'app-update-product',
  templateUrl: './update-product.component.html',
  styleUrls: ['./update-product.component.css']
})
export class UpdateProductComponent implements OnInit {

  itemData: any;

  data: any = [];
  constructor(private http: Http) { }
  imgUrl=environment.serverUrl;
  ngOnInit() {
    this.setTable();
  }

  onSelect(data) {
    this.data=[];
    this.data = data;
   }
  setTable() {
    this.http.get(environment.serverUrl + "getallproduct").
      map(response => response.json()).
      subscribe(data => this.itemData = data);
  }
  onUpdate(data){
    console.log(data);
   /* this.http.get(environment.serverUrl + "getallproduct").
    map(response => response.json()).
    subscribe(data => this.itemData = data);*/
  }
}
