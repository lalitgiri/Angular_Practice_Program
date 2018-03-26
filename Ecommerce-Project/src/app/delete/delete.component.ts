import { Component, OnInit } from '@angular/core';
import { Http } from '@angular/http';
import { environment } from '../../environments/environment';

@Component({
  selector: 'app-delete',
  templateUrl: './delete.component.html',
  styleUrls: ['./delete.component.css']
})
export class DeleteComponent implements OnInit {

  itemData:any;
  constructor(private http:Http) { }

  ngOnInit() { 
    this.http.get(environment.serverUrl+"getallproduct").
  map(response=>response.json()).
  subscribe(data => this.itemData=data);
  }

}
