import { Component } from '@angular/core';
import { UserManagementService } from '../../../services/user-management.service';
import { UserModel } from '../../../model/user-management';
import { Router } from '@angular/router';
import { ReasonsService } from '../../../services/reasons.service'
import { Reasons } from '../../../model/reasons';
import { FormGroup, FormBuilder, FormControl, Validators } from '@angular/forms';

@Component({
    selector: 'add-user',
    templateUrl: 'add-user.component.html',
    styleUrls: ['add-user.component.scss']
})
export class AddUserComponent {
    private userModel: UserModel;

    userGroupList: any[] = [];

    userGroupEvent: any;
    userGroup: any[] = [];
    // samAccountName: any;

    AdduserName: any;
    isUserGroupChecked: boolean = false;

    disableFields: boolean = false;
    // surName: string;
    cid: any;

    register: FormGroup;
    result: any = null;
    isSubmitted: boolean = false;


    constructor(private userManagementService: UserManagementService, private router: Router, private reasonsService: ReasonsService, private frmBuilder: FormBuilder) {

    }
    ngOnInit() {
        debugger;

        this.register = this.frmBuilder.group({
            'code': new FormControl(''),
            'samAccountName': new FormControl('', Validators.compose([Validators.required])),
            'givenName': new FormControl({ value: "", disabled: true }, Validators.compose([Validators.required])),
            'surName': new FormControl({ value: "", disabled: true }, Validators.compose([Validators.required])),
            'mail': new FormControl({ value: "", disabled: true }, Validators.compose([Validators.required])),
            'userGroupName': new FormControl('', Validators.compose([Validators.required]))
        });


        this.userModel = this.userManagementService.getter();
        // to get the user groups in add group
        this.getUserDetails();
    }

    // on selection of checkbox
    addRoleUserGroup(event: any) {
        debugger
        if (this.isUserGroupChecked) {

        }
        this.userGroupEvent = event;
        this.userGroup.push(this.userGroupEvent);
    }

    // to get the user groups in edit group
    getUserDetails() {
        this.userManagementService.getUserGroup().subscribe((lists) => {
            debugger
            this.userGroupList = lists.data;
            console.log("users" + lists);

        });
    }

    get code() { return this.register.get('code'); }
    get samAccountName() { return this.register.get('samAccountName'); }
    get givenName() { return this.register.get('givenName'); }
    get surName() { return this.register.get('surName'); }
    get mail() { return this.register.get('mail'); }

    get userGroupName() { return this.register.get('userGroupName'); }

    // to save the details of the edit user
    form() {
        debugger
        let addUserDetails: any = {
            "cid": this.userModel.cid,
            "firstName": this.userModel.givenName,
            "lastName": this.userModel.surName,
            "userName": this.userModel.samAccountName,
            "password": "",
            "emailId": this.userModel.mail,
            "userGroup": this.userGroup,
            "createdBy": "shwethacr",
            "modifiedBy": "shwethacr",
            "createdDate": this.userModel.createdDate,
            "modifiedDate": this.userModel.modifiedDate,
            "adUser": true,
            "activeUser": true
        }
        console.log(addUserDetails);
        this.userManagementService.addUserModel(addUserDetails).subscribe((response) => {
            debugger
            console.log(this.userModel);
        });

    }


    validateUserName() {
        debugger

        this.userManagementService.getValidUserName(this.userModel.samAccountName).subscribe((response) => {
            debugger
            this.userModel = response;
            if (response.success === false) {
                this.disableFields = false;
            }
            this.disableFields = true;

        });
    }
}