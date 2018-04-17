import { Component, OnInit } from '@angular/core';
import { Http } from '@angular/http';
import { ActivatedRoute, Router } from '@angular/router';
import { environment } from '../../../environments/environment';
import { TokenDecoderService } from '../../service/token-decoder.service';
import { DataSharingService } from '../../service/data-sharing.service';

@Component({
  selector: 'app-description',
  templateUrl: './description.component.html',
  styleUrls: ['./description.component.css']
})
export class DescriptionComponent implements OnInit {

  constructor(private http: Http, private dataSharingService: DataSharingService, private route: ActivatedRoute, private tokenDecoder: TokenDecoderService, private router: Router) { }
  itemData;
  url = environment.serverUrl;
  flag = false;
  imgUrl: string;
  pname: string;
  pprice: number;
  pdescription: string;
  description;
  pcategory: string;
  cartBtn = "Add To Cart";
  cartBtnflag = true;
  userId;
  token() {
    let parsedToken = this.tokenDecoder.decodeToken(sessionStorage.getItem("token"));
    this.userId = parsedToken.userId;

  }
  ngOnInit() {
    const id = this.route.snapshot.paramMap.get('id');
    this.imgUrl = this.url + "images/";
    this.http.get(environment.serverUrl + "getproduct/" + id).
      map(response => response.json()).
      subscribe(
        data => {
          this.itemData = data;
          this.pname = this.itemData.productName;
          this.pprice = this.itemData.productPrice;
          this.pcategory = this.itemData.productCategory;
          this.pdescription = this.itemData.description;
          this.imgUrl = this.imgUrl + this.itemData.imageUrl;
          this.flag = true;
          this.splitDescriptionString();
        },
        (error: Error) => { alert(error.message) });
  }

  splitDescriptionString() {
    
    this.description = this.pdescription.split(";");
    console.log(this.description);
  }

  addToCart() {
    if (sessionStorage.getItem("token") != null) {

      this.token();
      if (this.cartBtnflag) {
        this.http.post(environment.serverUrl + "updatecart/" + this.userId, this.itemData).
          subscribe(response => {
            this.cartBtn = "Added To Cart";
            this.cartBtnflag = false;
          },
            (error: Error) => { alert(error.message) });
      }
      else {
        this.cartBtnflag = false;
        alert("Item Already Added");
      }
    }
    else
      alert("Login First");


  }

  onClick() {
    //this.dataSharingService.setProduct(this.itemData);
    sessionStorage.setItem('services_assigned', JSON.stringify(this.itemData));
    if (sessionStorage.getItem("token") != null) {
      this.token();
      this.http.post(environment.serverUrl + "updatecart/" + this.userId, this.itemData).
        subscribe(response => {
          this.cartBtn = "Added To Cart";
          this.cartBtnflag = false;
        },
          (error: Error) => { alert(error.message) });
      this.router.navigate(['/order', "product"]);
    }
    else
      alert("Login First");
  }

}


