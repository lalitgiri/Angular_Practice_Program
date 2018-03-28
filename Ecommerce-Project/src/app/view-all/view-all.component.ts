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

  constructor(private http: Http, private route: ActivatedRoute) {
    /*
      problem: router navigator does not reload the content of the page if we are on the same page or component.

      Ans:
            You can inject the ActivatedRoute and subscribe to params

            constructor(route:ActivatedRoute) {
                            route.params.subscribe(val => {
                           // put the code from `ngOnInit` here
                            });
                        }

            The router only destroys and recreates the component when it navigates 
            to a different route. When only route params or query params are updated
            but the route is the same, the component won't be destroyed and recreated.

    */
    route.params.subscribe(val => {

      const id = this.route.snapshot.paramMap.get('id');
      this.http.get(environment.serverUrl + "getproductbycategory/" + id).
        map(response => response.json()).
        subscribe(data => this.itemData = data);
    });

  }
  url = environment.serverUrl;
  itemData;
  ngOnInit() {

  }
}
