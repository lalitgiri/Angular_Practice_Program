import { BrowserModule } from '@angular/platform-browser';
import { NgModule } from '@angular/core';

import { AppComponent } from './app.component';
import { HeaderComponent } from './header/header.component';

import { LoginComponent } from './login-component/login-component.component';
import { RouterModule,Routes} from '@angular/router';

import {HttpModule} from '@angular/http';
import { HomeComponent } from './home/home.component';
import {CarouselModule } from 'angular4-carousel';

const appRoutes: Routes = [
 
];
@NgModule({
  declarations: [
    AppComponent,
    HeaderComponent,
    LoginComponent,
    HomeComponent
  ],
  imports: [
    BrowserModule,RouterModule.forRoot([{ path: 'login', component: LoginComponent }]),HttpModule,CarouselModule  ],
  providers: [],
  bootstrap: [AppComponent]
})
export class AppModule { }
