import {Injectable} from "@angular/core";
import {Http, Response, RequestOptions, Headers} from "@angular/http";
import "rxjs/add/operator/map";
import "rxjs/add/operator/catch";
import { Vendor } from "../model/vendor";
@Injectable()
export class VendorPRFService {
    private vendor = new Vendor();
    private apiURl  = "/SFCRM/";
    private headers = new Headers({"content-Type": "application/json"});
    private options = new RequestOptions({
        headers: this.headers
    });
    constructor(private http: Http) {
    }
    getVendorTranscationList() {
        return this.http.get(this.apiURl + "/VendorTranscationList" , this.options).map((response: Response) => response.json());
    }
    getcostCenterlList() {
        return this.http.get(this.apiURl + "/costCenterlList" , this.options).map((response: Response) => response.json());
    }
    // addVendorPayout(lists: any){
    //      return this.http.post(this.apiURl + "/" , JSON.stringify(lists), this.options)
    //     .map((response: Response) => response.json());
    // }
    setter(vendor: Vendor) {
        this.vendor = vendor;
    }
    getter() {
        return this.vendor;
    }
}
