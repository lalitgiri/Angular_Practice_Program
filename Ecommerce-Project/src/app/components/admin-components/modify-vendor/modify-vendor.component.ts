import { Component, OnInit } from '@angular/core';
import { AddHeaderInHttpService } from '../../../service/add-header-in-http.service';
import { environment } from '../../../../environments/environment';

@Component({
  selector: 'app-modify-vendor',
  templateUrl: './modify-vendor.component.html',
  styleUrls: ['./modify-vendor.component.css']
})
export class ModifyVendorComponent implements OnInit {

  employeeData;
  constructor(private http:AddHeaderInHttpService) { }

  ngOnInit() {

      this.http.get(environment.serverUrl +'/getallemployee').map(res=>res.json()).subscribe(data =>{
          this.employeeData=data;
      });
  }

}
