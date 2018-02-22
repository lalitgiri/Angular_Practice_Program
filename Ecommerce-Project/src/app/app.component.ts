import { Component } from '@angular/core';

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
}
