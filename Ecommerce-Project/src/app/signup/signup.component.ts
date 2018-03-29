import { Component, OnInit } from '@angular/core';
import { Http } from '@angular/http';
import { HttpClient } from 'selenium-webdriver/http';

@Component({
  selector: 'app-signup',
  templateUrl: './signup.component.html',
  styleUrls: ['./signup.component.css']
})
export class SignupComponent implements OnInit {

  constructor(private http:Http) { }
  isd_code
  ngOnInit() {
    this.http.get("../../assets/products/isd_code.json").
      map(response => response.json()).
      subscribe(data => this.isd_code = data); console.log(this.isd_code)
  }

}
