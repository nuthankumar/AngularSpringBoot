import {Injectable} from "@angular/core";
import {Http, Response, RequestOptions, Headers} from "@angular/http";
import {Observable} from "rxjs/Observable";
import "rxjs/add/operator/map";
import "rxjs/add/operator/catch";
import {ITransactionCash} from "../model/transaction-cash";
@Injectable()
export class CheckerService {
    private apiURl  = "/SFCRM/";
    private headers = new Headers({"content-Type": "application/json"});
    private options = new RequestOptions({headers: this.headers});
    constructor(private http: Http) {
    }
    getcheckerContestList() {
        return this.http.get(this.apiURl + "/checkerContestList?pageNumber=1", this.options)
        .map((response: Response) => response.json());
    }
    getagentWiseCheckerContestList(contestId: any) {
        return this.http.get(this.apiURl + "/agentWiseCheckerContestList?contestId=" + contestId, this.options)
        .map((response: Response) => response.json());
    }
    updateToApprover(list: ITransactionCash): Observable<any> {
        return this.http.put(this.apiURl + "/updateTransactionCashChecker", JSON.stringify(list), this.options);
    }
    getcheckerContestTicket() {
        return this.http.get(this.apiURl + "/checkerContestTicketsList?pageNumber=1", this.options)
        .map((response: Response) => response.json());
    }
     getagentWiseCheckerContestTicket(contestId: any) {
        return this.http.get(this.apiURl + "/agentWiseCheckerContestTicketList?contestId=" + contestId, this.options)
        .map((response: Response) => response.json());
    }
     updateToApproverTicket(list: ITransactionCash): Observable<any> {
        return this.http.put(this.apiURl + "/transactionTicketChecker", JSON.stringify(list), this.options);
    }
    rejectTransactionCashChecker(list: ITransactionCash): Observable<any> {
        return this.http.put(this.apiURl + "/rejectTransactionCashChecker", JSON.stringify(list), this.options);
    }
    rejectransactionTicketChecker(list: ITransactionCash): Observable<any> {
        return this.http.put(this.apiURl + "/rejectransactionTicketChecker", JSON.stringify(list), this.options);
    }
}
