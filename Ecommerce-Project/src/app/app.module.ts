import { BrowserModule } from '@angular/platform-browser';
import { NgModule } from '@angular/core';

import { AppComponent } from './app.component';
import { HeaderComponent } from './header/header.component';

import { LoginComponent } from './login-component/login-component.component';
import { RouterModule,Routes} from '@angular/router';

import {HttpModule} from '@angular/http';
const appRoutes: Routes = [
 
];
@NgModule({
  declarations: [
    AppComponent,
    HeaderComponent,
    LoginComponent
  ],
  imports: [
    BrowserModule,RouterModule.forRoot([{ path: 'login', component: LoginComponent }]),HttpModule  ],
  providers: [],
  bootstrap: [AppComponent]
})
export class AppModule { }
