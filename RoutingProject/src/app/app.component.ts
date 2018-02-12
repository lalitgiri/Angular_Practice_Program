import { Component } from '@angular/core';

@Component({
  selector: 'app-root',
  templateUrl: './app.component.html',
  styleUrls: ['./app.component.css']
})
export class AppComponent {
  title = 'app';
  appTitle: string = 'Welcome';
   
  appList: any[] = [{
     "ID": "1",
     "Name": "One",
     //"url": 'app/Images/One.jpg'
  },
  {
     "ID": "2",
     "Name": "Two",
     //"url": 'app/Images/two.jpg'
  } ];

}
