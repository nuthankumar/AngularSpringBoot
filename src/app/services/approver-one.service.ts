import {Injectable} from "@angular/core";
import {Http, Response, RequestOptions, Headers} from "@angular/http";
import {Observable} from "rxjs/Observable";
import "rxjs/add/operator/map";
import "rxjs/add/operator/catch";
import {ITransactionCash} from "../model/transaction-cash";
//import {Menu} from '../route/dashboard.component.model';

@Injectable()
export class ApproverOneService {
     private apiURl  = "/SFCRM/";
    private headers = new Headers({"content-Type": "application/json"});
    private options = new RequestOptions({headers: this.headers});
    constructor(private http: Http) {
    }
    
    getapproverOneContestList() {
        return this.http.get(this.apiURl + "/approverOneContestList?pageNumber=1", this.options)
        .map((response: Response) => response.json());
    }
    getapproverOneContestTicket() {
        return this.http.get(this.apiURl + "/approveOneTickets?pageNumber=1", this.options)
        .map((response: Response) => response.json());
    }
    
    updateToApproverTwo(list: ITransactionCash): Observable<any> {
        return this.http.put(this.apiURl + "/updateApproverOneTransactionCash", JSON.stringify(list), this.options);
    }
    updateToApproverTwoTicket(list: ITransactionCash): Observable<any> {
        return this.http.put(this.apiURl + "/updateApproverOneTransactionTicket", JSON.stringify(list), this.options);
    }
    rejectApproverOneTransactionCash(list: ITransactionCash): Observable<any> {
        return this.http.put(this.apiURl + "/rejectApproverOneTransactionCash", JSON.stringify(list), this.options);
    }
    rejectApproverOneTransactionTicket(list: ITransactionCash): Observable<any> {
        return this.http.put(this.apiURl + "/rejectApproverOneTransactionTicket", JSON.stringify(list), this.options);
    }
    

}
