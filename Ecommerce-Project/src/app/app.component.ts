import { Component,OnInit, ChangeDetectorRef } from '@angular/core';
import { HomeComponent } from './home/home.component';
import { Http,HttpModule } from '@angular/http';
import { environment } from '../environments/environment';
import { Router } from '@angular/router';

@Component({
  selector: 'app-root',
  templateUrl: './app.component.html',
  styleUrls: ['./app.component.css']
})
export class AppComponent implements OnInit  {

  constructor(private http:Http,private router:Router,private cdRef:ChangeDetectorRef){}
  itemData;
  flag=false;

  ngOnInit() {
    this.http.get(environment.serverUrl + "getallproductCategory").
    map(response=>response.json()).
    subscribe(data => {this.itemData=data
        this.flag=true;
    });
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
  navigate(category:string){
      console.log(this.router.navigate(['/viewAll',category]));
      console.log(category);
  }
  ngAfterViewChecked() {
    this.cdRef.detectChanges();
  }
}
