import { Component, OnInit } from '@angular/core';
import { Http } from '@angular/http';
import { FormGroup, FormControl } from '@angular/forms';
import { HttpClient } from '@angular/common/http';

import { PatternValidator } from '@angular/forms';
import { environment } from '../../../../environments/environment';

@Component({
  selector: 'app-signup',
  templateUrl: './signup.component.html',
  styleUrls: ['./signup.component.css']
})
export class SignupComponent implements OnInit {

  constructor(private http:Http,private httpClient:HttpClient) { }
  
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
        "phoneNumber": new FormControl(""),
        "password":new FormControl(""),

      })
  
    }
    

    onUpdate(data){
      console.log(data);
      this.httpClient.post(environment.serverUrl + 'adduser',data,{ responseType: 'text' })
      .subscribe(response => {alert(response) 
        console.log(response)
        this.SignUpForm.reset();
      },
      (error:Error)=>alert(error.message));
     
    }


}
