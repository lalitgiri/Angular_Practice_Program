import { Component, OnInit } from '@angular/core';

import { animation } from '@angular/animations'

@Component({
  selector: 'app-home',
  templateUrl: './home.component.html',
  styleUrls: ['./home.component.css']
})
export class HomeComponent implements OnInit {

  constructor() { }

  public imagesSources:string[]=[
    '../../assets/images/img.jpeg',
    '../../assets/images/img1.jpeg',
    '../../assets/images/img2.jpg',
    '../../assets/images/img3.jpg',
    '../../assets/images/img4.jpg',
    '../../assets/images/img5.jpg'
  ];
  ngOnInit() {
  }


}
