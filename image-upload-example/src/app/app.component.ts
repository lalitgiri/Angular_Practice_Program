
import { Component, OnInit } from '@angular/core';

import {  FileUploader } from 'ng2-file-upload/ng2-file-upload';

const URL = 'http://localhost:8080/upload';

//D:\WorkSpace\Angular_Practice_Program\image-upload-example\src\assets
@Component({
   
    selector: 'app-root',
    templateUrl: './app.component.html',
    styleUrls: ['./app.component.css']
})
export class AppComponent implements OnInit {
   public uploader:FileUploader = new FileUploader({url: URL, itemAlias: 'photo'});
    title = 'app works!';

    ngOnInit() {
       //override the onAfterAddingfile property of the uploader so it doesn't authenticate with //credentials.
       this.uploader.onAfterAddingFile = (file)=> { file.withCredentials = false; };
       //overide the onCompleteItem property of the uploader so we are 
       //able to deal with the server response.
       this.uploader.onCompleteItem = (item:any, response:any, status:any, headers:any) => {
            console.log("ImageUpload:uploaded:", item, status, response);
        };
    }
}