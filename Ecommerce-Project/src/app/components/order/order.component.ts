import { Component, OnInit, Input } from '@angular/core';
import { TokenDecoderService } from '../../service/token-decoder.service';
import { Http } from '@angular/http';
import { environment } from '../../../environments/environment';
import { DataSharingService } from '../../service/data-sharing.service';
import { Route } from '@angular/compiler/src/core';
import { ActivatedRoute } from '@angular/router';

@Component({
  selector: 'app-order',
  templateUrl: './order.component.html',
  styleUrls: ['./order.component.css']
})
export class OrderComponent implements OnInit {


  flag = 0;
  pFlag;
  addCardDetail
  parsedToken = this.tokenDecoder.decodeToken(sessionStorage.getItem("token"));
  userId = this.parsedToken.phoneNumber;
  cartId = this.parsedToken.userId;
  userDetails;
  cartDetails;
  products;
  productId;
  summaryFlag=null;
  imgUrl=environment.serverUrl+"images/";
  cost=0;
  order;
  constructor(private tokenDecoder: TokenDecoderService,private route:ActivatedRoute, private http: Http, private dataSharingService: DataSharingService) { }


  ngOnInit() {  
    //this.products = this.dataSharingService.getProduct().productId;
    
    this.http.get(environment.serverUrl + "getuser/" + this.userId)
    .map(response => response.json())
    .subscribe(data => {
      this.userDetails = data;
      console.log(this.userDetails)
      //console.log(data);
     
    }, (error: Error) => { alert(error.message) });
   
    console.log(this.imgUrl)
      this.summaryFlag=this.route.snapshot.paramMap.get('id');

      if(this.summaryFlag=='product')
        {
           this.products=JSON.parse(sessionStorage.getItem('services_assigned'));
            this.cost=this.products.productPrice;
      }
       else
       {
          this.products = JSON.parse(sessionStorage.getItem('services_assigned')).productId;
          this. findProductPrice();
        }
      console.log(this.products)

  }

  onclick(flag) {
    if (this.flag == flag)
      flag = 0;
    this.flag = flag;
   if(flag==4)
    this.pFlag="payment"
    else
    this.pFlag=null;
  }

  
  findProductPrice() {
    this.products.forEach(element => {
      this.cost = element.productPrice + this.cost;

    });
  }

  payment(data){
    this.flag=data;
    this.pFlag='hi';

    this.order={
        "userId":this.userDetails,
        "address":this.userDetails.cart.deliveryAddress,
        "itemDetail":this.products,
        "orderId":1
     }
 /*    this.http.post(environment.serverUrl + 'addorder', this.order)
     .subscribe((response) => {alert(response.text()) },
     (error:Error)=>{ alert(error.message)});

*/
  }

}
