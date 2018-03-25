import { Component, OnInit } from '@angular/core';
import{Http,HttpModule} from '@angular/http';
@Component({
  selector: 'app-view-all',
  templateUrl: './view-all.component.html',
  styleUrls: ['./view-all.component.css']
})
export class ViewAllComponent implements OnInit {

  constructor(private http:Http) { }
  httpData;
  itemData;
 
  ngOnInit() {
    this.http.get("http://localhost:8080/getallproduct").
    map(response=>response.json()).
    subscribe(data => this.itemData=data);
  }
}
