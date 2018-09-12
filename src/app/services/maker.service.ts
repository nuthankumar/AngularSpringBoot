import {Injectable} from "@angular/core";
import {Http, Response, RequestOptions, Headers} from "@angular/http";
import {Observable} from "rxjs/Observable";
import "rxjs/add/operator/map";
import "rxjs/add/operator/catch";
import {ITransactionCash} from "../model/transaction-cash";
@Injectable()
export class MakerService {
    private apiURl  = "/SFCRM/";
    private headers = new Headers({"content-Type": "application/json"});
    private options = new RequestOptions({headers: this.headers});
    constructor(private http: Http) {
    }


    getCompositeDataByID(compID:any) {
       return this.http.get(this.apiURl + "/agentWiseMakerContestList?contestId=" + compID,this.options)
       .map((response: Response) => response.json());      
    }

    getMakerContestList() {
        return this.http.get(this.apiURl + "/makerContestList?pageNumber=1", this.options)
        .map((response: Response) => response.json());
    }
    getAgentWiseMakerContestList(contestId: any) {
        return this.http.get(this.apiURl + "/agentWiseMakerContestList?contestId=" + contestId, this.options)
        .map((response: Response) => response.json());
    }
    updateData(list: ITransactionCash): Observable<any> {
        return this.http.put(this.apiURl + "/transactionCashMaker", JSON.stringify(list), this.options);
    }
    updateToRejectMaker(list: ITransactionCash): Observable<any> {
        return this.http.put(this.apiURl + "/rejectTransactionCashMaker", JSON.stringify(list), this.options);
    }
    getMakerContestTicket() {
        return this.http.get(this.apiURl + "/makerContestTicketsList?pageNumber=1", this.options)
        .map((response: Response) => response.json());
    }
    getAgentWiseMakerContestTicketList(contestId: any) {
        return this.http.get(this.apiURl + "/agentWiseMakerContestTicketList?contestId=" + contestId, this.options)
        .map((response: Response) => response.json());
    }
    updateToCheckerTicket(list: ITransactionCash): Observable<any> {
        return this.http.put(this.apiURl + "/transactionTicketMaker", JSON.stringify(list), this.options);
    }
     updateToRejectMakerTicket(list: ITransactionCash): Observable<any> {
        return this.http.put(this.apiURl + "/rejectTransactionTicketMaker", JSON.stringify(list), this.options);
    }
    

}
