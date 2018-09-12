import {Injectable} from "@angular/core";
import {Http, Response, RequestOptions, Headers} from "@angular/http";
import "rxjs/add/operator/map";
import "rxjs/add/operator/catch";
import { Vendor } from "../model/vendor";
@Injectable()
export class VendorService {
    private vendor = new Vendor();
    private apiURl  = "/SFCRM/";
    private headers = new Headers({"content-Type": "application/json"});
    private options = new RequestOptions({
        headers: this.headers
    });
    constructor(private http: Http) {
    }
    getVendorList() {
        return this.http.get(this.apiURl + "/vendorList" , this.options).map((response: Response) => response.json());
    }
    postVendorData(vendor: Vendor) {
        return this.http.post(this.apiURl + "/createVendor" , JSON.stringify(vendor), this.options)
        .map((response: Response) => response.json());
    }
    updateVendorData(vendor: Vendor) {
        return this.http.put(this.apiURl + "/editVendor" , JSON.stringify(vendor), this.options)
        .map((response: Response) => response.json());
    }
    setter(vendor: Vendor) {
        this.vendor = vendor;
    }
    getter() {
        return this.vendor;
    }
}
