import {Injectable} from "@angular/core";
import {Http, Response, RequestOptions, Headers} from "@angular/http";
import {Observable} from "rxjs/Observable";
import "rxjs/add/operator/map";
import "rxjs/add/operator/catch";
import {ITransactionCash} from "../model/transaction-cash";
import {IPRFList} from "../model/prf-list";
//import {Menu} from '../route/dashboard.component.model';

@Injectable()
export class ApproverTwoService {
     private apiURl  = "/SFCRM/";
    private headers = new Headers({"content-Type": "application/json"});
    private options = new RequestOptions({headers: this.headers});
    constructor(private http: Http) {
    }
    getapproverTwoContestList() {
        return this.http.get(this.apiURl + "/approverTwoContestList?pageNumber=1", this.options)
        .map((response: Response) => response.json());
    }
    updateToPayout(list: ITransactionCash): Observable<any> {
        return this.http.put(this.apiURl + "/updateApproverTwoTransactionCash", JSON.stringify(list), this.options);
    }
    updateToPayoutTicket(list: ITransactionCash): Observable<any> {
        return this.http.put(this.apiURl + "/updateApproverTwoTransactionTicket", JSON.stringify(list), this.options);
    }
    
     getapproverTwoContestListTicket() {
        return this.http.get(this.apiURl + "/approveTwoTickets?pageNumber=1", this.options)
        .map((response: Response) => response.json());
    }
    rejectApproverTwoTransactionCash(list: ITransactionCash): Observable<any> {
        return this.http.put(this.apiURl + "/rejectApproverTwoTransactionCash", JSON.stringify(list), this.options);
    }
    rejectApproverTwoTransactionTicket(list: ITransactionCash): Observable<any> {
        return this.http.put(this.apiURl + "/rejectApproverTwoTransactionTicket", JSON.stringify(list), this.options);
    }

    
}
