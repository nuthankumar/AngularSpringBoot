import {Injectable} from "@angular/core";
import {Http, Response, RequestOptions, Headers} from "@angular/http";
import "rxjs/add/operator/map";
import "rxjs/add/operator/catch";
@Injectable()
export class AgentMasterService {
    private apiURl  = "/SFCRM/";
    private headers = new Headers({"content-Type": "application/json"});
    private options = new RequestOptions({headers: this.headers});
    constructor(private http: Http) {
    }
    getAgentList() {
        return this.http.get(this.apiURl + "/agentList?pageNumber=1", this.options)
        .map((response: Response) => response.json());
    }
    AgentList() {
        return this.http.get(this.apiURl + "/agents", this.options)
        .map((response: Response) => response.json());
    }
}
