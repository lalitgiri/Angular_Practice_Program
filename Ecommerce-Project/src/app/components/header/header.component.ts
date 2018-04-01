import { Component, OnInit, ChangeDetectorRef } from '@angular/core';
import { environment } from '../../../environments/environment';
import { Http } from '@angular/http';
import { Router } from '@angular/router';

@Component({
  selector: 'app-header',
  templateUrl: './header.component.html',
  styleUrls: ['./header.component.css']
})
export class HeaderComponent implements OnInit {

  constructor(private http:Http,private router:Router,private cdRef:ChangeDetectorRef){}
  itemData;
  flag=false;

  ngOnInit() {
    this.http.get(environment.serverUrl + "getallproductCategory").
    map(response=>response.json()).
    subscribe(data => {this.itemData=data
        this.flag=true;
    },
    (error:Error)=>{ alert(error.message)});
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
