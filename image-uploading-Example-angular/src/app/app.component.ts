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
  constructor(private http :HttpClient ){}
  onFileSelected(event){
    console.log(event);
    
    this.selectedFile= [];
    this.selectedFile[0]=<File>event.target.files[0];
    this.selectedFile[1]=<File>event.target.files[1];
  }
  onUpload(){
    if(this.flag==true)
    {
      for(this.i=0;this.i<2;this.i++){
        
        let fd = new FormData();
      fd.append('file',this.selectedFile[this.i],this.selectedFile[this.i].name);
      debugger;
      this.http.post('http://localhost:8080/upload',fd, {responseType: 'text'}).subscribe((res)=>console.log(res));
          console.log("hello"+this.i+"  ");
       }   }
  }
}
