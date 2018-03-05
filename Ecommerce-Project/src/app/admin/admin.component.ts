import { Component, OnInit } from '@angular/core';

@Component({
  selector: 'app-admin',
  templateUrl: './admin.component.html',
  styleUrls: ['./admin.component.css']
})
export class AdminComponent implements OnInit {

  constructor() { }
  status:String="Welcome";
  ngOnInit() {
  }
  operation(arg) {
    if (this.status == arg)
      this.status = null;
    else
      this.status = arg;
  }
}
