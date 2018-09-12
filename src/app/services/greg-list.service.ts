import {Injectable} from "@angular/core";
import {Http, Response, RequestOptions, Headers} from "@angular/http";
import {Observable} from "rxjs/Observable";
import "rxjs/add/operator/map";
import "rxjs/add/operator/catch";``
import {GregList} from '../model/greg-list'

@Injectable()
export class GregListService {
    private gregList = new GregList();
     private apiURl  = "/SFCRM/";
    private headers = new Headers({"content-Type": "application/json"});
    private options = new RequestOptions({headers: this.headers});
    constructor(private http: Http) {
    }
    addGregList(list: any): Observable<any> {
        return this.http.post(this.apiURl + "/addAgentGregList" , JSON.stringify(list), this.options);
    }
    getGregList() {
        return this.http.get(this.apiURl + "/agentGregList", this.options)
        .map((response: Response) => response.json());
    }
    updateGregList(list: any): Observable<any>{
         return this.http.put(this.apiURl + "/editAgentGregList" , JSON.stringify(list), this.options);
    }
     setter(gregList: GregList) {
        this.gregList = gregList;
    }
    getter() {
        return this.gregList;
    }
}
