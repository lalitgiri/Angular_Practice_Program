import { Component, OnInit } from '@angular/core';
import { Response } from '@angular/http';
import { HttpClient } from '@angular/common/http';

@Component({
  selector: 'app-add-product',
  templateUrl: './add-product.component.html',
  styleUrls: ['./add-product.component.css']
})
export class AddProductComponent implements OnInit {

  selectedFile:any;
  imgUrl:String;
  data:any;
  flag:boolean=false;
  pCategory:String;
  fileInput:boolean=false;
  fileInputDummy:boolean=true;
  constructor(private http:HttpClient ) { }

  ngOnInit() {
  }
 
  onChange(){
    this.fileInputDummy=false;
    this.fileInput=true;
    console.log(this.fileInput);
  }
  onImageSelected(event) {
    
    this.selectedFile = <File>event.target.files[0];
    let fd = new FormData();
    fd.append('file', this.selectedFile, this.selectedFile.name);
     this.http.post('http://localhost:8080/upload/'+this.pCategory, fd, { responseType: 'text' })
      .subscribe((res) => {
        this.imgUrl=res
              console.log(res+" $$  "+ this.imgUrl)
              this.flag=true;
            });
}

  onSubmit=function(product){
    if(product.productName!=null && product.productQuantity!=null&& product.productCategory!=null
      && product.productPrice!=null && product.description!=null && this.imgUrl!=null)
          {console.log(product);
          
            this.data =
            {
              "productName": product.productName,
              "productCategory": product.productCategory,
              "productQuantity": product.productQuantity,
              "productPrice": product.productPrice,
              "productDescription":product.description,
              "imageUrl":this.imgUrl,
              "cartId":null
            };
            console.log(this.data);
          this.http.post('http://localhost:8080/addproduct',this.data,{ responseType: 'text' })
          .subscribe((response: Response) => { console.log(response) });
        }
  }
}
