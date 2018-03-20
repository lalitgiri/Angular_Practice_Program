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
      [{ "employeeName": employee.employeeName,
        "employeeRole": employee.employeeRole,
        "contactNumber": employee.contactNumber,
        "address": employee.address,
        "status": "true",
        "joiningDate": employee.joiningDate,
        "resigningDate": "null"
      }];
    const body = JSON.stringify(employee);
    const  headers = new Headers({ 'Content-Type': 'application/json' });
    //  headers.append('Access-Control-Allow-Origin','*');
    let options = new RequestOptions({
      headers: headers,
    });

    console.log(this.body);
    this.http.post('http://localhost:8080/addemployee',this.data,headers).subscribe((response: Response) => { console.log(response) });
  }
}




