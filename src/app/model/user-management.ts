export class UserModel{
    activeUser:string;
    adUser:boolean;
    createdBy:string;
    createdDate:number;
    emailId:string;
    givenName:string;
    cid:any;
    lastName:string;
    modifiedBy:string;
    modifiedDate:number;
    password:any;
    userGroup:userGroupModel[];
    userName:any;
    samAccountName:string;
    surName:string;
    mail:any;
    firstName:string
}

export class userGroupModel{
    id:any;
    name:any; 
}
