import { Component, OnInit, HostListener } from '@angular/core';
import { Http } from '@angular/http';
import { HttpClient } from 'selenium-webdriver/http';
import { FormGroup, FormControl } from '@angular/forms';

@Component({
  selector: 'app-signup',
  templateUrl: './signup.component.html',
  styleUrls: ['./signup.component.css']
})
export class SignupComponent implements OnInit {

  constructor(private http:Http) { }
  
  SignUpForm;
  isd_code
  ngOnInit() {
    this.http.get("../../assets/products/isd_code.json").
      map(response => response.json()).
      subscribe(data => this.isd_code = data); console.log(this.isd_code)
    
      this.SignUpForm=new FormGroup({
        "name":new FormControl(""),
        "emailId": new FormControl(""),
        "countryCode":new FormControl(""),
        "contactNumber": new FormControl(""),
        "password":new FormControl("")
      })
  
    }

    @HostListener('window:beforeunload', ['$event'])
    beforeunloadHandler(event) {
     
    }
    onUpdate(data){
      console.log(data);
      this.SignUpForm.reset();
    }


}
