import { BrowserModule } from '@angular/platform-browser';
import { NgModule } from '@angular/core';
import { RouterModule,Routes } from '@angular/router';
import { HttpModule} from '@angular/http';
import { ReactiveFormsModule,FormsModule } from '@angular/forms';
import { HttpClientModule } from '@angular/common/http';

import { AppComponent } from './app.component';

import { AdminComponent } from './components/admin-components/admin/admin.component';
import { AddProductComponent } from './components/admin-components/add-product/add-product.component';
import { UpdateProductComponent } from './components/admin-components/update-product/update-product.component';
import { DeleteComponent } from './components/admin-components/delete/delete.component';
import { OrderDetailComponent } from './components/admin-components/order-detail/order-detail.component';
import { AddVendorComponent } from './components/admin-components/add-vendor/add-vendor.component';
import { ExportDataBaseComponent } from './components/admin-components/export-data-base/export-data-base.component';
import { LoginComponent } from './components/user-authentication-component/login/login.component';
import { SignupComponent } from './components/user-authentication-component/signup/signup.component';
import { HomeComponent } from './components/home/home.component';
import { DescriptionComponent } from './components/description/description.component';
import { ViewAllComponent } from './components/view-all/view-all.component';
import { WelcomeComponent } from './components/welcome/welcome.component';
import { HomeChildComponent } from './components/home/home-child/home-child.component';
import { HeaderComponent } from './components/header/header.component';
import { AppRoutingModule } from './routing/app-routing.module';
//import { routing } from './routing/app-routing.module';

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
    AddVendorComponent,
    ExportDataBaseComponent,
    HomeChildComponent,
    HeaderComponent
  ],
  imports: [
    BrowserModule,ReactiveFormsModule,FormsModule/*,routing*/,HttpModule,HttpClientModule, AppRoutingModule
  ],
  providers: [],
  bootstrap: [AppComponent]
})
export class AppModule { }
