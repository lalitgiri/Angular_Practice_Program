import { BrowserModule } from '@angular/platform-browser';
import { NgModule, NO_ERRORS_SCHEMA } from '@angular/core';

import { AppComponent } from './app.component';
import { HeaderComponent } from './header/header.component';

import { LoginComponent } from './login-component/login-component.component';
import { RouterModule,Routes} from '@angular/router';

import {HttpModule} from '@angular/http';
import { HomeComponent } from './home/home.component';

import {MDBBootstrapModule} from 'angular-bootstrap-md';

const appRoutes: Routes = [
 
];
@NgModule({
  declarations: [
    AppComponent,
    HeaderComponent,
    LoginComponent,
    HomeComponent
  ],
  imports: [MDBBootstrapModule.forRoot(),
    BrowserModule,RouterModule.forRoot([{ path: 'signup', component: LoginComponent }]),HttpModule],
    schemas:[NO_ERRORS_SCHEMA],
  providers: [],
  bootstrap: [AppComponent]
})
export class AppModule { }
