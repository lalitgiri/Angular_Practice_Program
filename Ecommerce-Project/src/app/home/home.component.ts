import { Component, OnInit, Input } from '@angular/core';
import { HttpModule, Http } from '@angular/http';
import 'rxjs/add/operator/map';
import { environment } from '../../environments/environment';
@Component({
  selector: 'app-home',
  templateUrl: './home.component.html',
  styleUrls: ['./home.component.css'],
})
export class HomeComponent implements OnInit {

  constructor(private http:Http) { }
  httpData=[];
  itemData;
  url=environment.serverUrl;
  i=0;
  id=0;
  
  ngOnInit() {
    this.http.get(environment.serverUrl+"getallproductCategory").
    map(response=>response.json()).
    subscribe(data => {
      this.httpData=data
    });

    this.http.get(environment.serverUrl+"getproductbycategory/"+this.httpData[this.i]).
    //this.http.get(environment.serverUrl+"getallproduct").
    map(response=>response.json()).
    subscribe(data => {this.itemData=data
      this.i++;
      console.log(this.httpData[this.i]);
  } ); 

  }
}
