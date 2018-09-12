import { Component } from '@angular/core';
import { GregListService } from '../../../services/greg-list.service'
import { AgentMasterService } from '../../../services/agent-master.service'
import { GregList } from '../../../model/greg-list';
import { ReasonsService } from '../../../services/reasons.service'
import { Reasons } from '../../../model/reasons';
import {Router} from '@angular/router';

@Component({
    selector: 'add-greg-list',
    templateUrl: 'add-greg-list.component.html',
    styleUrls: ['add-greg-list.component.scss']
})
export class AddGregListComponent {
    private gregList:GregList;
    agentlist:any;
    lists:any;
     selectedValue:Object={};
     agentType:any;
     endDate:any;
     startDate:any;
     reasons:any;
 constructor(private gregListService: GregListService,private router:Router,private agentMasterService:AgentMasterService
 ,private reasonsService:ReasonsService){

 }
     ngOnInit(){
    this.gregList=this.gregListService.getter();
     this.agentMasterService.AgentList().subscribe((lists)=>{
            console.log(lists);
            this.lists=lists.data;
            for(let i=0;i<this.lists.length;i++){
                var number= this.lists[i].agentListKey.agentNo;
                this.lists[i].agentNo=number;
            }
           
           
  });
      this.reasonsService.getReasonsList().subscribe((reasons) => {
            this.reasons=reasons.data;
            console.log(reasons)
          },(error) => {
            console.log(error);
         })
   
     }
     form(){
     console.log("fsd",this.gregList);
     var newStr = this.startDate.replace(/-/g, "-");
     var newStr1 = this.endDate.replace(/-/g, "-");
     var data={
         "agentNo":this.selectedValue["agentNo"],
         "agentType":this.agentType,
         "endDate":newStr1,
         "startDate":newStr
     }
     this.gregListService.addGregList(data).subscribe((gregList)=>{
        console.log(gregList);
        this.router.navigate(['/gregList']);
      },(error)=>{
        console.log(error);
      });


}



}
