import { Component } from '@angular/core';
import { VendorService } from '../../../services/vendor.service'
import { Vendor } from '../../../model/vendor';
import {Router} from '@angular/router';

@Component({
    selector: 'vendor-add',
    templateUrl: 'vendor-add.component.html',
    styleUrls: ['vendor-add.component.scss']
})
export class VendorAddComponent {
     private vendor:Vendor;
 constructor(private vendorService: VendorService,private router:Router){

 }
  ngOnInit(){
    this.vendor=this.vendorService.getter();
   
     }
     form(){
 
     this.vendorService.postVendorData(this.vendor).subscribe((vendor)=>{
        console.log(vendor);
        this.router.navigate(['/vendor']);
      },(error)=>{
        console.log(error);
      });


}

}
