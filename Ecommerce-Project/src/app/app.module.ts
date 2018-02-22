import { BrowserModule } from '@angular/platform-browser';
import { NgModule } from '@angular/core';
import {RouterModule,Routes} from '@angular/router';

import { AppComponent } from './app.component';
import { LoginComponent } from './login/login.component';
import { SignupComponent } from './signup/signup.component';
import { HomeComponent } from './home/home.component';

import { HttpModule} from '@angular/http';

const appRoutes: Routes = [
  
  {path:'login',component:LoginComponent},
  {path:'signUp',component:SignupComponent},
  { path: '**', component: HomeComponent }
];

@NgModule({
  declarations: [
    AppComponent,
    LoginComponent,
    SignupComponent,
    HomeComponent
  ],
  imports: [
    BrowserModule,RouterModule.forRoot(appRoutes),HttpModule
  ],
  providers: [],
  bootstrap: [AppComponent]
})
export class AppModule { }
