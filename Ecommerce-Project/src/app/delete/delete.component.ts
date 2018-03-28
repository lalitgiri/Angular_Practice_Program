import { Component, OnInit } from '@angular/core';
import { Http } from '@angular/http';
import { environment } from '../../environments/environment';

@Component({
  selector: 'app-delete',
  templateUrl: './delete.component.html',
  styleUrls: ['./delete.component.css']
})
export class DeleteComponent implements OnInit {

  itemData: any;
  idArray = [];
  index = 0;
  url = environment.serverUrl;
  imgFlag=false;
  viewImage;
  constructor(private http: Http) { }

  ngOnInit() {
    this.http.get(environment.serverUrl + "getallproduct").
      map(response => response.json()).
      subscribe(data => this.itemData = data);
  }

  add(id) {
    this.idArray[this.index] = id
    console.log("this.idArray : " + this.idArray + "  id : " + id)
    this.index++;
  }
  toggleEditable(event, id) {
    if (event.target.checked)
      this.add(id)
    else
      this.remove(id)
  }

  remove(id) {
    const index: number = this.idArray.indexOf(id);
    if (index !== -1) {
      this.idArray.splice(index, 1);
      console.log("this.idArray : " + this.idArray + "  id : " + id)
    }
  }

  
  imageViewFunction(path){
    this.viewImage=this.url+'images/'+path;
    this.imgFlag=true;
  }
}
