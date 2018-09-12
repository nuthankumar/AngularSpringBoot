import {Injectable} from "@angular/core";
import {Http, Response, RequestOptions, Headers} from "@angular/http";
import {Observable} from "rxjs/Observable";
import "rxjs/add/operator/map";
import "rxjs/add/operator/catch";
import {AdvancePay} from "../model/advance-pay";
@Injectable()
export class AdvancePayService {
    private apiURl  = "/SFCRM/";
    private headers = new Headers({"content-Type": "application/json"});
    private options = new RequestOptions({headers: this.headers});
    constructor(private http: Http) {
    }
    getAdvancePayList() {
        return this.http.get(this.apiURl + "/advancePayMakerList?pageNumber=1", this.options)
        .map((response: Response) => response.json());
    }
    updateToAdvancePay(advancePay: AdvancePay): Observable<any> {
        return this.http.put(this.apiURl + "/approveAdvancePayMakerCash", JSON.stringify(advancePay), this.options);
    }
    getAdvancePayCheckerList() {
        return this.http.get(this.apiURl + "/advancePayCashCheckerList?pageNumber=1", this.options)
        .map((response: Response) => response.json());
    }
    updateAdvancePayChecker(advancePay: AdvancePay): Observable<any> {
        return this.http.put(this.apiURl + "/approveAdvancePayCheckerCash", JSON.stringify(advancePay), this.options);
    }
    updateAdvancePaymentsEntry(advancePay: any): Observable<any> {
        return this.http.put(this.apiURl + "/advancePaymentsEntry", JSON.stringify(advancePay), this.options);
    }
    emailAttachment(list:any){
    
    console.log("list",list);
    console.log("listjson",JSON.stringify(list));
       return this.http.post(this.apiURl + "/emailAttach" , list)
        .map((response: Response) => response);

}
    
    
}
