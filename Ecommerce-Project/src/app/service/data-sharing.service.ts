import { Injectable } from '@angular/core';

@Injectable()
export class DataSharingService {

  public product:any;
  constructor() { 

  }
   setProduct(product): void{
    this.product=product;

  
  }

   getProduct(): any{

    return this.product;
  
  }
}
