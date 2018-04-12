import { Component, OnInit } from '@angular/core';
import { TokenDecoderService } from '../../service/token-decoder.service';
import { Http } from '@angular/http';
import { environment } from '../../../environments/environment';

@Component({
  selector: 'app-order',
  templateUrl: './order.component.html',
  styleUrls: ['./order.component.css']
})
export class OrderComponent implements OnInit {

  flag=0;
  parsedToken = this.tokenDecoder.decodeToken(sessionStorage.getItem("token"));
  userId=this.parsedToken.phoneNumber;
  userDetails;  
  constructor(private tokenDecoder:TokenDecoderService,private http:Http) { }


  ngOnInit() {
    this.http.get(environment.serverUrl+"getuser/"+this.userId)
        .map(response=>response.json())
        .subscribe(data=>{      
          this.userDetails=data;
           console.log(data);
    },(error: Error) => { alert(error.message) });
  }

  onclick(flag) {
    if(this.flag==flag)
      flag=0;
    this.flag=flag;
  }
}
