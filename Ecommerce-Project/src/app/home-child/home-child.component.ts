import { Component, OnInit, Input, Output, SimpleChanges } from '@angular/core';
import { environment } from '../../environments/environment';
import { Http } from '@angular/http';

@Component({
  selector: 'app-home-child',
  templateUrl: './home-child.component.html',
  
  styleUrls: ['./home-child.component.css']
})
export class HomeChildComponent implements OnInit {

  @Input() category: String;
  constructor(private http:Http) { }
  itemData;
  url=environment.serverUrl;
  ngOnInit() {

  }
  ngOnChanges(changes: SimpleChanges) {
    
  this.http.get(environment.serverUrl+"getproductbycategory/"+this.category).
  //this.http.get(environment.serverUrl+"getallproduct").
  map(response=>response.json()).
  subscribe(data => {this.itemData=data
  console.log(this.category);
} ); 
}

}
