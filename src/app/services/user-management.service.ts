import {Injectable} from "@angular/core";
import {Http, Response, RequestOptions, Headers} from "@angular/http";
import {Observable} from "rxjs/Observable";
import "rxjs/add/operator/map";
import "rxjs/add/operator/catch";
import {AdvancePay} from "../model/advance-pay";
import {UserModel} from '../model/user-management';


@Injectable()
export class UserManagementService {
    private userModel = new UserModel();
    private apiURl  = "/SFCRM/";
    private headers = new Headers({"content-Type": "application/json"});
    private options = new RequestOptions({headers: this.headers});
    constructor(private http: Http) {
    }


    // to get the userlist in the list component
    getUserList() {
        return this.http.get(this.apiURl + "/user/users", this.options)
        .map((response: Response) => response.json());
    }

    // to get the usergroups to display the different user group
    getUserGroup() {
        return this.http.get(this.apiURl + "/user/userGroups", this.options)
        .map((response: Response) => response.json());
    }

    // to save the details of the add user
    addUserModel(userModel:any){
        return this.http.post(this.apiURl + "/user/user" , JSON.stringify(userModel), this.options)
        .map((response: Response) => response.json());
    }

    // to save the details of the edit user
    updateUserModel(editUserDetails:any): Observable<any> {
        return this.http.put(this.apiURl + "/user/user", JSON.stringify(editUserDetails), this.options);
    }

  // to get the userlist in the list component
  getValidUserName(username:any) {
      debugger
    return this.http.get(this.apiURl + "/user/validateUser?userName="+ username , this.options)
    .map((response: Response) => response.json());
  }

    setter(userModel: UserModel) {
        this.userModel = userModel;
    }
    getter() {
        return this.userModel;
    }
}
