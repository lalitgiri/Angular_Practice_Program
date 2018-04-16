import { Component, OnInit } from '@angular/core';
import { Response } from '@angular/http';
import { HttpClient } from '@angular/common/http';
import { environment } from '../../../../environments/environment';

@Component({
  selector: 'app-add-product',
  templateUrl: './add-product.component.html',
  styleUrls: ['./add-product.component.css']
})
export class AddProductComponent implements OnInit {

  selectedFile: any;
  imgUrl: String;
  data: any;
  flag: boolean = false;
  pCategory: String;
  fileInput: boolean = false;
  fileInputDummy: boolean = true;
  url = environment.serverUrl;
  constructor(private http: HttpClient) { }

  ngOnInit() {
       
  }


  onChange() {
    this.fileInputDummy = false;
    this.fileInput = true;
  }
  onImageSelected(event) {

    this.selectedFile = <File>event.target.files[0];
    let fd = new FormData();
    fd.append('file', this.selectedFile, this.selectedFile.name);
    this.http.post(environment.serverUrl + 'upload/' + this.pCategory, fd, { responseType: 'text' })
      .subscribe((res) => {
        this.imgUrl = res;
        this.flag = true;
      },
      (error:Error)=>{ alert(error.message)});
  }

  onSubmit = function (product) {
    if (product.productName != null && product.productQuantity != null && product.productCategory != null
      && product.productPrice != null && product.description != null && this.imgUrl != null) {
    
      this.data =
        {
          "productName": product.productName,
          "productCategory": product.productCategory,
          "productQuantity": product.productQuantity,
          "productPrice": product.productPrice,
          "description": product.description,
          "imageUrl": this.imgUrl,
          "cartId": null,
          "status":true
        };
     
      this.http.post(environment.serverUrl + 'addproduct', this.data, { responseType: 'text' })
        .subscribe((response: Response) => {alert(response)
        window.location.reload(); },
        (error:Error)=>{ alert(error.message)});
    }
  }
}
