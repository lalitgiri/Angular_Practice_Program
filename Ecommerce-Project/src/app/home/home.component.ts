import { Component, OnInit } from '@angular/core';
import { HttpModule, Http } from '@angular/http';
import 'rxjs/add/operator/map';
@Component({
  selector: 'app-home',
  templateUrl: './home.component.html',
  styleUrls: ['./home.component.css']
})
export class HomeComponent implements OnInit {

  constructor(private http:Http) { }
  httpData;
  itemData;
 


  ngOnInit() {
    this.http.get("../../assets/test-files/category.json").
    map(response=>response.json()).
    subscribe(data => this.httpData=data);

    this.http.get("../../assets/test-files/navData.json").
    map(response=>response.json()).
    subscribe(data => this.itemData=data);
  }
}
