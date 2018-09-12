import { Component } from '@angular/core';
import { UserManagementService } from '../../../services/user-management.service';
import { UserModel, userGroupModel } from '../../../model/user-management';
import { Router } from '@angular/router';
import { ReasonsService } from '../../../services/reasons.service'
import { Reasons } from '../../../model/reasons';
import { FormGroup, FormBuilder, FormControl, Validators } from '@angular/forms';

@Component({
    selector: 'edit-user',
    templateUrl: 'edit-user.component.html',
    styleUrls: ['edit-user.component.scss']
})
export class EditUserComponent {
    private userModel: UserModel;
    userGroupList: any[] = [];
    userGroupEvent: any;
    userGroup: any[] = [];

    register: FormGroup;
    result: any = null;
    isSubmitted: boolean = false;
    constructor(private userManagementService: UserManagementService, private router: Router, private reasonsService: ReasonsService, private frmBuilder: FormBuilder) {

    }

    ngOnInit() {
        

        this.register = this.frmBuilder.group({
            'code': new FormControl({ value: "", disabled: true }),
            'samAccountName': new FormControl('', Validators.compose([Validators.required])),
            'surName': new FormControl('', Validators.compose([Validators.required])),
            'emailId': new FormControl({ value: "", disabled: true }),
            'userGroupName': new FormControl('', Validators.compose([Validators.required]))
        });


        this.userModel = this.userManagementService.getter();
        // to get the user groups in edit group
        this.getUserGroups();
    }

    get code() { return this.register.get('code'); }
    get samAccountName() { return this.register.get('samAccountName'); }
    get surName() { return this.register.get('surName'); }
    get emailId() { return this.register.get('emailId'); }
    get userGroupName() { return this.register.get('userGroupName'); }

    // on selection of checkbox
    onUserGroupEdit(event: any) {
        debugger
        this.userGroupEvent = event;
        this.userGroup.push(this.userGroupEvent);
    }

    // to save the details of the edit user
    saveUserModel() {
        debugger
        let editUserDetails: any = {
            "cid": this.userModel.cid,
            "firstName": this.userModel.firstName,
            "lastName": this.userModel.lastName,
            "userName": this.userModel.userName,
            "password": '',
            "emailId": this.userModel.emailId,
            "userGroup": this.userGroup,
            "createdBy": "rajatgn",
            "modifiedBy": "rajatgn",
            "createdDate": this.userModel.createdDate,
            "modifiedDate": this.userModel.modifiedDate,
            "adUser": true,
            "activeUser": true

        }
        this.userManagementService.updateUserModel(editUserDetails).subscribe((response) => {
            debugger
            console.log(this.userModel);
        });
    }

    // to get the user groups in edit group
    getUserGroups() {
        this.userManagementService.getUserGroup().subscribe((lists) => {
            debugger
            this.userGroupList = lists.data;
            console.log("users" + lists);
        });
    }

}
