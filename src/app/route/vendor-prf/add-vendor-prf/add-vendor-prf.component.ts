import { Component } from '@angular/core';
import { VendorPRFService } from '../../../services/vendorPRF.service';
import { Router } from '@angular/router';
import { GridOptions } from "ag-grid/main";

@Component({
    selector: 'add-vendor-prf',
    templateUrl: 'add-vendor-prf.component.html',
    styleUrls: ['add-vendor-prf.component.scss']
})
export class AddVendorPrfComponent {
     private vendor:any;
 constructor(private vendorPRFService: VendorPRFService,private router:Router){

 }
  ngOnInit(){
    debugger;
     this.vendorPRFService.getcostCenterlList().subscribe((vendor)=>{
       debugger;
        console.log(vendor);
      },(error)=>{
        console.log(error);
      });

    this.vendor=this.vendorPRFService.getter();

   
     }
     form(){
     
}
}
