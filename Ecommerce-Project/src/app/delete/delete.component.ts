import { Component, OnInit } from '@angular/core';
import { Http } from '@angular/http';
@Component({
  selector: 'app-delete',
  templateUrl: './delete.component.html',
  styleUrls: ['./delete.component.css']
})
export class DeleteComponent implements OnInit {

  itemData:any;
  constructor(private http:Http) { }

  ngOnInit() { 
    this.http.get("http://localhost:8080/getallproduct").
  map(response=>response.json()).
  subscribe(data => this.itemData=data);
  }

}
