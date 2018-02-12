import { Injectable } from '@angular/core';
import {Lalit} from './hero1';
import { HEROES } from './mock-heroes';
import {Observable} from 'rxjs/Observable';
import {of} from 'rxjs/observable/of';
import {MessageService} from './message.service';
@Injectable()
export class HeroService {

  getHeroes():Observable<Lalit[]>
  {
    this.messageService.add('HeroService: fetched heroes');
    return of(HEROES);
  }

  constructor(private messageService:MessageService) { }

}
