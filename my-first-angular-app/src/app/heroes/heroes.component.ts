import { Component, OnInit } from '@angular/core';
import {Lalit} from '../hero1';
import {HEROES} from '../mock-heroes';
import {HeroService} from '../hero.service';

@Component({
  selector: 'app-heroes',
  templateUrl: './heroes.component.html',
  styleUrls: ['./heroes.component.css']
})
export class HeroesComponent implements OnInit {

  constructor(private heroService: HeroService) { }
  
  ngOnInit() {
    this.getHeroes();
  }
  hero: Lalit= {
    
    id : 1, name : 'Lalit Giri'
  };
  //heroes=HEROES;
  heroes:Lalit[];
  selectedHero:Lalit;
  
  /*getHeroes(): void {
    this.heroes = this.heroService.getHeroes();
  }*/

  getHeroes():void{
    this.heroService.getHeroes().subscribe(heros=> this.heroes=HEROES);
  }
   onSelect(hero1:Lalit):void{
    this.selectedHero=hero1;
   }
}
