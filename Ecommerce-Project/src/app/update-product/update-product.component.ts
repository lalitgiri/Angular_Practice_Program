import { Component, OnInit } from '@angular/core';
import { Http } from '@angular/http';
import { environment } from '../../environments/environment';
import { FormGroup,FormControl } from '@angular/forms'
@Component({
  selector: 'app-update-product',
  templateUrl: './update-product.component.html',
  styleUrls: ['./update-product.component.css']
})
export class UpdateProductComponent implements OnInit {

  updateProductForm;

  itemData: any;
  data;
 
  productid;
  UproductName; 
  UproductCategory; 
  UproductQuantity; 
  UproductPrice; 
  description ;
  constructor(private http: Http) { }
  imgUrl=environment.serverUrl;
  ngOnInit() {
    this.setTable();
    this.updateProductForm = new FormGroup({
      productid : new FormControl({value:"",disabled:true}),
      UproductName : new FormControl(""),
      UproductCategory : new FormControl(""),
      UproductQuantity : new FormControl(""),
      UproductPrice : new FormControl(""),
      description : new FormControl("")
    });
  }

  onSelect(data) {
     this.productid=data.productId;
     this.UproductName=data.productName; 
     this.UproductCategory=data.productCategory; 
     this.UproductQuantity=data.productQuantity; 
     this.UproductPrice=data.productPrice; 
     this.description=data.description;
     console.log(data);
   
   }
  setTable() {
    this.http.get(environment.serverUrl + "getallproduct").
      map(response => response.json()).
      subscribe(data => this.itemData = data);
  }
  onUpdate(formValue){
    this.data =
    {
      "productId":this.productid,
      "productName": formValue.UproductName,
      "productCategory": formValue.UproductCategory,
      "productQuantity": formValue.UproductQuantity,
      "productPrice": formValue.UproductPrice,
      "description": formValue.description,
      "imageUrl": this.imgUrl,
      "cartId": null
    };
   console.log(this.data);
   /* this.http.get(environment.serverUrl + "getallproduct").
    map(response => response.json()).
    subscribe(data => this.itemData = data);*/
  }
}
