import { Injectable } from '@angular/core';
import { Http, Headers } from '@angular/http';

@Injectable()
export class AddHeaderInHttpService {

  constructor(private http: Http) { }

  createAuthorizationHeader(headers: Headers) {
    if (sessionStorage.getItem('token')) {
      headers.append('token', sessionStorage.getItem('token'));
    }

    else
      headers.append('token', 'Lalit');
  }
  get(url) {
    let headers = new Headers();
    this.createAuthorizationHeader(headers);
    console.log("Get Header = "+headers.get('token'));
    return this.http.get(url, {
      headers: headers      
    });
    
  }

  post(url, data) {
    let headers = new Headers();
    this.createAuthorizationHeader(headers);
    console.log("Post Header : "+headers.get('token'));
    return this.http.post(url, data, {
      headers: headers
    });
  }
}
