import { Component, OnInit } from '@angular/core';
import { Http } from '@angular/http';
import { environment } from '../../../environments/environment';

@Component({
  selector: 'app-user-module',
  templateUrl: './user-module.component.html',
  styleUrls: ['./user-module.component.css']
})
export class UserModuleComponent implements OnInit {

  constructor(private http:Http) { }

  url=environment.serverUrl;
  orders;
  products;
  imgUrl=environment.serverUrl+'images/';
  ngOnInit() {

      this.http.get(this.url+'getallorder').map(res=>res.json()).subscribe(data=>{
        this.orders=data;
        this.products=data.itemDetail; 
        console.log(data);
        console.log(data[0].itemDetail);
      })

  }

}
