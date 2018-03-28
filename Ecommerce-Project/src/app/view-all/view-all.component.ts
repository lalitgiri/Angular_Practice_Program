import { Component, OnInit } from '@angular/core';
import { Http, HttpModule } from '@angular/http';
import { ActivatedRoute } from '@angular/router';
import { environment } from '../../environments/environment';
@Component({
  selector: 'app-view-all',
  templateUrl: './view-all.component.html',
  styleUrls: ['./view-all.component.css']
})
export class ViewAllComponent implements OnInit {

  constructor(private http: Http, private route: ActivatedRoute) { }
  url = environment.serverUrl;
  itemData;

  ngOnInit() {
    const id = this.route.snapshot.paramMap.get('id');

    this.http.get(environment.serverUrl + "getproductbycategory/" + id).
      map(response => response.json()).
      subscribe(data => this.itemData = data);
  }
}
