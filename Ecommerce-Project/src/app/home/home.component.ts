import { Component, OnInit } from '@angular/core';

import { animation } from '@angular/animations'
import {ICarouselConfig,AnimationConfig} from 'angular4-carousel';
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

  public config: ICarouselConfig={
    verifyBeforeLoad:true,
    log:false,
    animation:true,
    animationType:AnimationConfig.SLIDE,
    autoplay:true,
    autoplayDelay:2000,
    stopAutoplayMinWidth:768
  };
}
