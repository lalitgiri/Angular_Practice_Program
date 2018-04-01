import { Component, OnInit } from '@angular/core';
import { Http } from '@angular/http';
import { ActivatedRoute } from '@angular/router';
import { environment } from '../../../environments/environment';

@Component({
  selector: 'app-description',
  templateUrl: './description.component.html',
  styleUrls: ['./description.component.css']
})
export class DescriptionComponent implements OnInit {

  constructor(private http: Http, private route: ActivatedRoute) { }
  itemData;
  url = environment.serverUrl;
  flag = false;
  imgUrl: string;
  pname: string;
  pprice: number;
  pdescription: string;
  pcategory: string;
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
        },
        (error:Error)=>{ alert(error.message)});
  }




}
