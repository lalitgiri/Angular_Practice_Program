import { Component, OnInit, ChangeDetectorRef } from '@angular/core';
import { environment } from '../../../environments/environment';
import { Http } from '@angular/http';
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
  name = "dssa";
  constructor(private http: Http, private router: Router, private cdRef: ChangeDetectorRef, private tokenDecoder: TokenDecoderService) {
    if (sessionStorage.getItem("token") != null) {
      this.token = true;
      this.tokenValue = false;
      var parsedToken = tokenDecoder.decodeToken(sessionStorage.getItem("token"));
      this.name = parsedToken.sub;
      console.log("hello " + this.name);
    }
    console.log("token : " + sessionStorage.getItem("token"));
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
    console.log("hye");
    sessionStorage.removeItem("token");
    window.location.reload();
  }
  status: boolean = false;
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
    console.log(this.router.navigate(['/viewAll', category]));
    console.log(category);
  }
  ngAfterViewChecked() {
    this.cdRef.detectChanges();
  }
}
