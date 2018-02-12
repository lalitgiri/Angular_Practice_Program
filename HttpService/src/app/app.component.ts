import { Component } from '@angular/core';
import{Http} from '@angular/http';

import 'rxjs/add/operator/Map';

@Component({
  selector: 'app-root',
  templateUrl: './app.component.html',
  styleUrls: ['./app.component.css']
})
export class AppComponent {
  constructor(private http:Http){}
  httpdata;
  ngOnInit(){
    this.http.get("http://jsonplaceholder.typicode.com/users").
    map(r=>r.json())
    .subscribe((data)=>this.httpdata=data   //.subscribe((data) ⇒ console.log(data))
  )
  }
  title = 'app';
  displayData(data){
    this.httpdata=data;
  }
}
