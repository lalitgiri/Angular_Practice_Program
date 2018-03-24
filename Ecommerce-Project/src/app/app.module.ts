import { BrowserModule } from '@angular/platform-browser';
import { NgModule } from '@angular/core';
import { RouterModule,Routes } from '@angular/router';
import { HttpModule} from '@angular/http';
import { ReactiveFormsModule,FormsModule } from '@angular/forms';
import { HttpClientModule } from '@angular/common/http';

import { AppComponent } from './app.component';
import { LoginComponent } from './login/login.component';
import { SignupComponent } from './signup/signup.component';
import { HomeComponent } from './home/home.component';


import { DescriptionComponent } from './description/description.component';
import { ViewAllComponent } from './view-all/view-all.component';
import { AdminComponent } from './admin/admin.component';
import { AddProductComponent } from './add-product/add-product.component';
import { UpdateProductComponent } from './update-product/update-product.component';
import { WelcomeComponent } from './welcome/welcome.component';
import { DeleteComponent } from './delete/delete.component';
import { OrderDetailComponent } from './order-detail/order-detail.component';
import { AddVendorComponent } from './add-vendor/add-vendor.component';

const appRoutes: Routes = [
  {path:'admin',component:AdminComponent,
      children: [
    { path: 'addUser',component:AddVendorComponent, outlet:'admin'},
    { path: 'modifyProduct',component:UpdateProductComponent, outlet:'admin'},
    { path: 'delete',component:DeleteComponent, outlet:'admin'},
    { path: 'order',component:OrderDetailComponent, outlet:'admin'},
    { path: 'addProduct',component:AddProductComponent, outlet:'admin'}
  ]},
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
    DeleteComponent,
    OrderDetailComponent,
    AddVendorComponent
  ],
  imports: [
    BrowserModule,ReactiveFormsModule,FormsModule,RouterModule.forRoot(appRoutes),HttpModule,HttpClientModule
  ],
  providers: [],
  bootstrap: [AppComponent]
})
export class AppModule { }
