import { Injectable } from '@angular/core';
import { Http, Headers } from '@angular/http';

@Injectable()
export class AddHeaderInHttpService {

  constructor(private http: Http) { }

  createAuthorizationHeader() {
    let headers = new Headers();
    if (sessionStorage.getItem('token')) {
      headers.append('token', sessionStorage.getItem('token'));
    }

    else
      headers.append('token', 'Lalit');
    
      return headers;
    }
  get(url) {
    let headers : Headers= this.createAuthorizationHeader();
    console.log("Get Header = "+headers.get('token'));
         
    return this.http.get(url, {
      headers: headers      
    });
    
  }

  post(url, data) {
    let header =new Headers()
    header= this.createAuthorizationHeader();
    console.log("Post Header : "+header.get('token'));
    
    return this.http.post(url, data, {
      headers: header
    });
  }
}
