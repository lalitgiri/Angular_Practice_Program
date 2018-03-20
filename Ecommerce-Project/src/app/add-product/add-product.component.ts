import { Component, OnInit } from '@angular/core';
import { Http,Response } from '@angular/http';

@Component({
  selector: 'app-add-product',
  templateUrl: './add-product.component.html',
  styleUrls: ['./add-product.component.css']
})
export class AddProductComponent implements OnInit {

  data:any;
  constructor(private http:Http) { }

  ngOnInit() {
  }

  onSubmit=function(product){
    if(product.productName!=null && product.productQuantity!=null&& product.productCategory!=null
      && product.productPrice!=null && product.description!=null)
          {console.log(product);
          
            this.data = 
            { "productName": product.productName,
              "productCategory": product.productCategory,
              "productQuantity": product.productQuantity,
              "productPrice": product.productPrice,
              "productDescription":product.description,
              "procuct.imageUrl":null,
              "product.cartId":null
            };
            console.log(this.data);
          this.http.post('http://localhost:8080/addproduct',this.data)
          .subscribe((response: Response) => { console.log(response) });
        }
  }
}
