import {Injectable} from "@angular/core";
import {Http, Response, RequestOptions, Headers} from "@angular/http";
import {Observable} from "rxjs/Observable";
import "rxjs/add/operator/map";
import "rxjs/add/operator/catch";
import {ITransactionCash} from "../model/transaction-cash";
import {IPRFList} from "../model/prf-list";
//import {Menu} from '../route/dashboard.component.model';

@Injectable()
export class ApproverThreeService {
     private apiURl  = "/SFCRM/";
    private headers = new Headers({"content-Type": "application/json"});
    private options = new RequestOptions({headers: this.headers});
    constructor(private http: Http) {
    }
    getapproverThreeContestList() {
        return this.http.get(this.apiURl + "/approverThreeContestList?pageNumber=1", this.options)
        .map((response: Response) => response.json());
    }
    updateApproverThree(list: ITransactionCash): Observable<any> {
        return this.http.put(this.apiURl + "/updateApproverThreeTransactionCash", JSON.stringify(list), this.options);
    }
    rejectApproverThreeTransactionCash(list: ITransactionCash): Observable<any> {
        return this.http.put(this.apiURl + "/rejectApproverThreeTransactionCash", JSON.stringify(list), this.options);
    }

    
}
