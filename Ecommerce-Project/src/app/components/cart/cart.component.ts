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
  imgurl=environment.serverUrl;;
  parsedToken = this.tokenDecoder.decodeToken(sessionStorage.getItem("token"));
  id=this.parsedToken.userId;
  name=this.parsedToken.userName;
  address;
  email=this.parsedToken.sub;
  p;  
  cartPrice=0;
 
  constructor(private http:Http,private tokenDecoder: TokenDecoderService) {
    console.log("hello id:"+this.id);
    this.http.get(environment.serverUrl + "getcart/" + this.id).
    map(response => response.json()).
    subscribe(data => {
      this.itemData = data
      this.productData=this.itemData.productId;
      this.address=this.itemData.deliveryAddress;
      console.log(this.productData);
      this.findProductPrice();
      
    },(error:Error)=>{ alert(error.message)});
    
   }
  
   findProductPrice(){
     this.productData.forEach(element => {
       this.cartPrice=element.productPrice+this.cartPrice;
       
     });

   }
    
  ngOnInit() {
 
}
}
