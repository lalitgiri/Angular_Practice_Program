import { Component, OnInit } from '@angular/core';
import { Http } from '@angular/http';
import { ActivatedRoute } from '@angular/router';
import { environment } from '../../environments/environment';

@Component({
  selector: 'app-description',
  templateUrl: './description.component.html',
  styleUrls: ['./description.component.css']
})
export class DescriptionComponent implements OnInit {

  constructor(private http:Http,private route:ActivatedRoute) { }
    itemData;
    url=environment.serverUrl;
  ngOnInit() {
    
    const id = this.route.snapshot.paramMap.get('id');
    console.log(id);
    this.http.get(environment.serverUrl+"getproduct/"+id).
   // this.http.get(environment.serverUrl+"getallproduct").
    map(response=>response.json()).
    subscribe(
      data => {this.itemData=data;
        console.log(this.itemData);
      });
  }

}
