import {Injectable} from "@angular/core";
import {Http, Response, RequestOptions, Headers} from "@angular/http";
import "rxjs/add/operator/map";
import "rxjs/add/operator/catch";
import { Menu } from "../model/Menu";
@Injectable()
export class MenuService {
	private loginUrl = "/api/login"

	constructor(private http: Http) {}

	loginUser(username:String,password:String){
		//this.http.post(this.loginUrl);
	}
}
