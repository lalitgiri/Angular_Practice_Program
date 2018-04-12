import { Component, OnInit } from '@angular/core';

@Component({
  selector: 'app-order',
  templateUrl: './order.component.html',
  styleUrls: ['./order.component.css']
})
export class OrderComponent implements OnInit {

  flag=0;
  constructor() { }

  ngOnInit() {
  }

  onclick(flag) {
    if(this.flag==flag)
      flag=0;
    this.flag=flag;
  }
}
