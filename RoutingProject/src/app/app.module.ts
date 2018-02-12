import { BrowserModule } from '@angular/platform-browser';
import { NgModule } from '@angular/core';
import { AppComponent } from './app.component';

import { PageNotFoundComponent } from  '../routes/NotFound.component'
import { Appproduct} from '../routes/product.component';
import { AppInventory } from '../routes/Inventory.component'
import { RouterModule,Routes } from '@angular/router'
import {Ng2PaginationModule} from 'ng2-pagination';
const appRoutes : Routes =[
    { path:'Inventory',component:AppInventory },
    { path:'Product', component:  Appproduct},
    { path: '**', component: PageNotFoundComponent } 

  ];
@NgModule({
  declarations: [ AppComponent ,Appproduct, AppInventory,
    PageNotFoundComponent],
  imports: [
    BrowserModule,RouterModule.forRoot(appRoutes),Ng2PaginationModule
  ],
  providers: [],
  bootstrap: [AppComponent]
})
export class AppModule { }
