import {Injectable} from "@angular/core";
import {Http, Response, RequestOptions, Headers} from "@angular/http";
import "rxjs/add/operator/map";
import "rxjs/add/operator/catch";
import {Reasons} from "../model/reasons";
@Injectable()
export class ReasonsService {
    private reasons = new Reasons();
    reason:string;
    private apiURl  = "/SFCRM/";
    private headers = new Headers({"content-Type": "application/json"});
    private options = new RequestOptions({headers: this.headers});
    constructor(private http: Http) {}
    getReasonsList() {
        return this.http.get(this.apiURl + "/reasonsList" , this.options)
        .map((response: Response) => response.json());
    }
    postReasonsData(reasons: Reasons) {
        return this.http.post(this.apiURl + "/addReasons" , JSON.stringify(reasons), this.options)
        .map((response: Response) => response.json());
    }
    updateReasonsData(reasons: Reasons) {
        return this.http.put(this.apiURl + "/editReasonList" , JSON.stringify(reasons), this.options)
        .map((response: Response) => response.json());
    }
    updateStatus(reasons: Reasons){
        return this.http.put(this.apiURl + "/updateStatus" , JSON.stringify(reasons), this.options)
        .map((response: Response) => response.json());
    }
    setter(reasons: Reasons) {
        this.reasons = reasons;
    }
    getter() {
        return this.reasons;
    }
}
