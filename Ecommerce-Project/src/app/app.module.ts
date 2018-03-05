import { BrowserModule } from '@angular/platform-browser';
import { NgModule } from '@angular/core';
import {RouterModule,Routes} from '@angular/router';

import { AppComponent } from './app.component';
import { LoginComponent } from './login/login.component';
import { SignupComponent } from './signup/signup.component';
import { HomeComponent } from './home/home.component';

import { HttpModule} from '@angular/http';
import { DescriptionComponent } from './description/description.component';
import { ViewAllComponent } from './view-all/view-all.component';
import { AdminComponent } from './admin/admin.component';
import { AddProductComponent } from './add-product/add-product.component';
import { UpdateProductComponent } from './update-product/update-product.component';
import { WelcomeComponent } from './welcome/welcome.component';
import { DeleteComponent } from './delete/delete.component';

const appRoutes: Routes = [
  {path:'admin',component:AdminComponent},
  {path:'description',component:DescriptionComponent},
  {path:'login',component:LoginComponent},
  {path:'signup',component:SignupComponent},
  {path:'viewAll',component:ViewAllComponent},
  { path: '**', component: HomeComponent }
];

@NgModule({
  declarations: [
    AppComponent,
    LoginComponent,
    SignupComponent,
    HomeComponent,
    DescriptionComponent,
    ViewAllComponent,
    AdminComponent,
    AddProductComponent,
    UpdateProductComponent,
    WelcomeComponent,
    DeleteComponent
  ],
  imports: [
    BrowserModule,RouterModule.forRoot(appRoutes),HttpModule
  ],
  providers: [],
  bootstrap: [AppComponent]
})
export class AppModule { }
