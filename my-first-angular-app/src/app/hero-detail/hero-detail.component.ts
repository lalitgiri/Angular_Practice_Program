import { Component, OnInit, Input } from '@angular/core';
import {Lalit} from '../hero1';
@Component({
  selector: 'app-hero-detail',
  templateUrl: './hero-detail.component.html',
  styleUrls: ['./hero-detail.component.css']
})


export class HeroDetailComponent implements OnInit {

  constructor() { }
  @Input() hero1: Lalit;
  ngOnInit() {
  }

}
