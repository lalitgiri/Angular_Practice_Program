import { Component,OnInit } from '@angular/core';
import { HomeComponent } from './home/home.component';
import { Http,HttpModule } from '@angular/http';

@Component({
  selector: 'app-root',
  templateUrl: './app.component.html',
  styleUrls: ['./app.component.css']
})
export class AppComponent implements OnInit  {

  constructor(private http:Http){}
  itemData;


  ngOnInit() {
    this.http.get("../../assets/test-files/navData.json").
    map(response=>response.json()).
    subscribe(data => this.itemData=data);
  }
  
  status: boolean=false;
  clicked(event){
        if(this.status==true)
          this.status=false;
        else
          this.status=true;  
  }
  hide(event){
    this.status=false;
  }
}
