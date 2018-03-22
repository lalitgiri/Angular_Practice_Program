import { Component } from '@angular/core';
import { HttpClient } from '@angular/common/http';
import { Response } from '@angular/http';

@Component({
  selector: 'app-root',
  templateUrl: './app.component.html',
  styleUrls: ['./app.component.css']
})
export class AppComponent {
  selectedFile:any[];
  flag=true;
  i:number=0;
  count:number=0;
  constructor(private http :HttpClient ){}
  onFileSelected(event){
    console.log(event);
    this.selectedFile= [];
    for(this.i=0;event.target.files[this.i]!=null;this.i++)
      this.selectedFile[this.i]=<File>event.target.files[this.i];

      debugger;
  }
  onUpload(){
    if(this.flag==true)
    {
      for(this.count=0;this.count<this.i;this.count++){
      let fd = new FormData();
      fd.append('file',this.selectedFile[this.count],this.selectedFile[this.count].name);
      
      this.http.post('http://localhost:8080/upload',fd, {responseType: 'text'}).subscribe((res)=>console.log(res));
          console.log("hello"+this.count+"  ");
       }   }
  }
}
