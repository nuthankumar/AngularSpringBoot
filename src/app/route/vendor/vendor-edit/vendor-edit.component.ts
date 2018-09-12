import { Component } from '@angular/core';
import { VendorService } from '../../../services/vendor.service'
import { Vendor } from '../../../model/vendor';
import { Router } from '@angular/router';

@Component({
  selector: 'vendor-edit',
  templateUrl: 'vendor-edit.component.html',
  styleUrls: ['vendor-edit.component.scss']
})
export class VendorEditComponent {
  private vendor: Vendor;
  constructor(private vendorService: VendorService, private router: Router) {

  }
  ngOnInit() {
    this.vendor = this.vendorService.getter();
  }
  form() {

    this.vendorService.updateVendorData(this.vendor).subscribe((vendor) => {
      console.log(vendor);
      this.router.navigate(['/vendor']);
    }, (error) => {
      console.log(error);
    });


  }


}
