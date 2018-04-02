import { Component, OnInit } from '@angular/core';
import { FormGroup, FormControl } from '@angular/forms';
import { HttpClient } from '@angular/common/http';
import { environment } from '../../../../environments/environment';

@Component({
  selector: 'app-login',
  templateUrl: './login.component.html',
  styleUrls: ['./login.component.css']
})
export class LoginComponent implements OnInit {

  LoginForm;
  constructor(private httpClient:HttpClient) { }

  ngOnInit() {
    this.LoginForm=new FormGroup({
      "Username":new FormControl(""),
      "lpassword":new FormControl("")

    })
  }
  onLogin(data){
    console.log(data);
    this.httpClient.post(environment.serverUrl + 'getAuthentication',data,{ responseType: 'text' })
    .subscribe(response => {alert(response) 
      console.log(response)
      this.LoginForm.reset();
    },
    (error:Error)=>alert(error.message));
   
  }

}
