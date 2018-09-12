import { Component } from '@angular/core';
import { NavMenuComponent } from "../navmenu/navmenu.component";
//import { ContestService } from '../../services/contest.service'
@Component({
    selector: 'dashboard',
    templateUrl: 'dashboard.component.html',
    styleUrls: ['dashboard.component.scss']
})
export class DashboardComponent {
    userDetails:any;
    constructor(){
    }
//     ngOnInit(){
//     this.contestService.getusers().subscribe((userDetails) => {
//             this.userDetails=userDetails.data;
//             console.log("user details"+this.userDetails);
//    });	
//     }
}
