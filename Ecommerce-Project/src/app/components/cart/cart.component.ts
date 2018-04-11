import { Component, OnInit } from '@angular/core';
import { environment } from '../../../environments/environment';
import { Http } from '@angular/http';
import { TokenDecoderService } from '../../service/token-decoder.service';

@Component({
  selector: 'app-cart',
  templateUrl: './cart.component.html',
  styleUrls: ['./cart.component.css']
})
export class CartComponent implements OnInit {

  itemData;
  productData;
  imgurl;
  parsedToken = this.tokenDecoder.decodeToken(sessionStorage.getItem("token"));
  id=this.parsedToken.userId;
  p;
  flag=false;
  constructor(private http:Http,private tokenDecoder: TokenDecoderService) {
    console.log("hello id:"+this.id);
    this.imgurl=environment.serverUrl;
    this.http.get(environment.serverUrl + "getcart/" + this.id).
    map(response => response.json()).
    subscribe(data => {
      this.itemData = data
      this.productData=this.itemData.productId;
      console.log(this.productData);
      this.flag=true;
    
    },(error:Error)=>{ alert(error.message)});
   }
  
  
  ngOnInit() {
   
    }


}
