import { Component, OnInit, ChangeDetectorRef } from '@angular/core';
import { environment } from '../../../environments/environment';
import { Http, RequestOptions, Headers } from '@angular/http';
import { Router } from '@angular/router';
import { TokenDecoderService } from '../../service/token-decoder.service';

@Component({
  selector: 'app-header',
  templateUrl: './header.component.html',
  styleUrls: ['./header.component.css']
})
export class HeaderComponent implements OnInit {

  token = false;
  tokenValue = true;
  status: boolean = false;
  name = "";
  constructor(private http: Http, private router: Router, private cdRef: ChangeDetectorRef,
    private tokenDecoder: TokenDecoderService) {
    if (sessionStorage.getItem("token") != null) {
      this.token = true;
      this.tokenValue = false;
      var parsedToken = tokenDecoder.decodeToken(sessionStorage.getItem("token"));
      this.name = parsedToken.userName;
      //console.log("hello " + this.name);
    }
   // console.log("token : " + sessionStorage.getItem("token"));
  }
  itemData;
  flag = false;


  ngOnInit() {
    this.http.get(environment.serverUrl + "getallproductCategory").
      map(response => response.json()).
      subscribe(data => {
        this.itemData = data
        this.flag = true;
      },
        (error: Error) => { alert(error.message) });
  }

  inValidateSession() {
   // console.log("hye");
   
    let myheaders = new Headers({ 'Content-Type': 'application/json' });    //x-www-form-urlencoded
    myheaders.append('token', sessionStorage.getItem("token"));

    this.http.get(environment.serverUrl + "logout", { headers: myheaders }).
      map(response => response.json()).
      subscribe(data => {
       // console.log(data);
        if (data == true) {
          sessionStorage.removeItem("token");
          window.location.reload();
          alert("Sucessfully Logout");
          sessionStorage.clear();
          this.router.navigate(['/']);
        }

      },
        (error: Error) => { alert(error.message) });

  }



  clicked(event) {
    if (this.status == true)
      this.status = false;
    else
      this.status = true;
  }
  hide(event) {
    this.status = false;
  }
  navigate(category: string) {
    this.router.navigate(['/viewAll', category]);
    console.log(category);
  }
  ngAfterViewChecked() {
    this.cdRef.detectChanges();
  }
}
