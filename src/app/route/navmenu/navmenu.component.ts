import { Component } from '@angular/core';
import { Menu } from '../../model/menu';
import { MenuComponent } from '../menu/menu.component';
import { ContestService } from '../../services/contest.service';
import {Router,ActivatedRoute, Params} from '@angular/router';

@Component({
    selector: 'navmenu',
    templateUrl: 'navmenu.component.html'
})
export class NavMenuComponent {
	userDetails:any;
	masterDataArr:any={};
	navItems:any;
  name:any;
  lists:any;
  agentUpdate:any;
  contestUpdate:any;
  navigationDetails:any={};
	constructor(private contestService:ContestService,private router:Router){}
	ngOnInit(){
    debugger
    
    this.contestService.lastUpdateDate().subscribe((lists) => {
            this.agentUpdate=lists.data[0].lastAgentUpdate;
            this.contestUpdate=lists.data[0].lastContestUpdate;
            
            console.log(lists)
          },(error)=>{
            console.log(error);
         })
    this.contestService.getusers().subscribe((userDetails) => {
    debugger
    this.userDetails=userDetails.data.user.userGroup[0].name;
    this.navigationDetails=userDetails.data.navigationItems;

    //  this.checkMaker=true;
    this.name=userDetails.data.user.firstName + '  ' + userDetails.data.user.lastName;
    console.log("user details",userDetails.data.user.firstName);
    //console.log(this.navItems);
    this.routeOtherPages();
   });	
 
}
routeOtherPages(){      
     this.navItems = this.navigationDetails["navigationItems"];
}
}