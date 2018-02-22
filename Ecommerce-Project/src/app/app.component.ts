import { Component } from '@angular/core';
import { HomeComponent } from './home/home.component';

@Component({
  selector: 'app-root',
  templateUrl: './app.component.html',
  styleUrls: ['./app.component.css']
})
export class AppComponent {
  title = 'app';

  message="hello";
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
