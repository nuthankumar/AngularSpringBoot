import {Injectable} from "@angular/core";
import {Http, Response, RequestOptions, Headers} from "@angular/http";
import "rxjs/add/operator/map";
import "rxjs/add/operator/catch";
import { Destination } from "../model/destination";
@Injectable()
export class DestinationService {
    private destination = new Destination();
    private apiURl  = "/SFCRM/";
    private headers = new Headers({"content-Type": "application/json"});
    private options = new RequestOptions({
        headers: this.headers
    });
    constructor(private http: Http) {
    }
    getDestinationList() {
        return this.http.get(this.apiURl + "/destinationPlace" , this.options).map((response: Response) => response.json());
    }
    postDestinationData(destination: Destination) {
        return this.http.post(this.apiURl + "/addDestinationPlace" , JSON.stringify(destination), this.options)
        .map((response: Response) => response.json());
    }
    updateDestinationData(destination: Destination) {
        return this.http.put(this.apiURl + "/editDestinationPlace" , JSON.stringify(destination), this.options)
        .map((response: Response) => response.json());
    }
    setter(destination: Destination) {
        this.destination = destination;
    }
    getter() {
        return this.destination;
    }
}
