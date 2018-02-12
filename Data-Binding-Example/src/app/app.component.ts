import { Component } from '@angular/core';

@Component({
  selector: 'app-root',
  templateUrl: './app.component.html',
  styleUrls: ['./app.component.css']
})
export class AppComponent {
  title = 'app';

  appList:any[]=[{
    "ID":"1",
    "url":"assets/images/download.jpg"
  },
{
  "ID":"2",
  "url":"assets/images/embed2.jpg"
}];
}
