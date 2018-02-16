import { Component, OnInit, style } from '@angular/core';

@Component({
  selector: 'app-login-component',
  templateUrl: './login-component.component.html',
  styleUrls: ['./login-component.component.css']
})
export class LoginComponent implements OnInit {

  ab;
  constructor() { }

  ngOnInit() {
  }
   
  abc(event)
  {
    this.ab='visible';
  }
      
  abc1(event)
  {
    this.ab='hidden';
  }
      
  
}
