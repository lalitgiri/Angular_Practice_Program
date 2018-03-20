import { Component, OnInit } from '@angular/core';
import { Http, Headers, RequestOptions, ResponseContentType } from "@angular/http";
import { Observable } from 'rxjs';
import 'rxjs/add/operator/catch';
@Component({
  selector: 'app-add-vendor',
  templateUrl: './add-vendor.component.html',
  styleUrls: ['./add-vendor.component.css']
})
export class AddVendorComponent implements OnInit {

  constructor(private http: Http) { }
  data: any;
  ngOnInit() {
  }

  onSubmit = function (employee) {
    /*
      {
          "employeeName":"Lalit",
          "employeeRole":"Admin",
          "contactNumber":"9555104600",
          "address":"Dadri",
          "status":"true",
          "joiningDate":"2010-10-15",
          "resigningDate":"null"
}
    */

    console.log(employee);
    /*this.data=[{
      "employeeName":employee.employeeName,
      "employeeRole":employee.employeeRole,
      "contactNumber":employee.contactNumber,
      "address":employee.address,
      "status":"true",
      "joiningDate":employee.joiningDate,
      "resigningDate":"null"
 
    }];
    */
    this.data = 
      { "employeeName": employee.employeeName,
        "employeeRole": employee.employeeRole,
        "contactNumber": employee.contactNumber,
        "address": employee.address,
        "status": "true",
        "joiningDate": employee.joiningDate,
        "resigningDate": "null"
      };
    const body = JSON.stringify(this.data);
    console.log(body);
    const  headers = new Headers({ 'Content-Type': 'application/json'});    //x-www-form-urlencoded
    headers.append('Access-Control-Allow-Origin','*');
    let options = new RequestOptions({
      headers: headers,
    });

    this.http.post('http://localhost:8080/addemployee',headers).subscribe((response: Response) => { console.log(response) });
  }
}




