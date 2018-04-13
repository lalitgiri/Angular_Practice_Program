import { Component, OnInit, Input } from '@angular/core';
import { TokenDecoderService } from '../../service/token-decoder.service';
import { Http } from '@angular/http';
import { environment } from '../../../environments/environment';
import { DataSharingService } from '../../service/data-sharing.service';

@Component({
  selector: 'app-order',
  templateUrl: './order.component.html',
  styleUrls: ['./order.component.css']
})
export class OrderComponent implements OnInit {


  flag = 0;
  parsedToken = this.tokenDecoder.decodeToken(sessionStorage.getItem("token"));
  userId = this.parsedToken.phoneNumber;
  cartId = this.parsedToken.userId;
  userDetails;
  cartDetails;
  products;
  constructor(private tokenDecoder: TokenDecoderService, private http: Http, private dataSharingService: DataSharingService) { }


  ngOnInit() {  
    this.products = this.dataSharingService.getProduct();
   
      console.log(this.products);

    this.http.get(environment.serverUrl + "getuser/" + this.userId)
      .map(response => response.json())
      .subscribe(data => {
        this.userDetails = data;

        console.log(data);

      }, (error: Error) => { alert(error.message) });

  }

  onclick(flag) {
    if (this.flag == flag)
      flag = 0;
    this.flag = flag;
   
  }
}
