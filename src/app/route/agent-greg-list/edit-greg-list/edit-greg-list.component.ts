import { Component } from '@angular/core';
import { GregListService } from '../../../services/greg-list.service'
import { GregList } from '../../../model/greg-list';
import {Router} from '@angular/router';
import { ReasonsService } from '../../../services/reasons.service'
import { Reasons } from '../../../model/reasons';
import { AgentMasterService } from '../../../services/agent-master.service'

@Component({
    selector: 'edit-greg-list',
    templateUrl: 'edit-greg-list.component.html',
    styleUrls: ['edit-greg-list.component.scss']
})
export class EditGregListComponent {
     private gregList:GregList;
     reasons:any;
     lists:any;
 constructor(private gregListService: GregListService,private agentMasterService:AgentMasterService,private router:Router,private reasonsService:ReasonsService){

 }
     ngOnInit(){
   this.gregList = this.gregListService.getter();
   this.reasonsService.getReasonsList().subscribe((reasons) => {
            this.reasons=reasons.data;
            console.log(reasons)
          },(error) => {
            console.log(error);
         })
   this.agentMasterService.AgentList().subscribe((lists)=>{
            console.log(lists);
            this.lists=lists.data;
            for(let i=0;i<this.lists.length;i++){
                var number= this.lists[i].agentListKey.agentNo;
                this.lists[i].agentNo=number;
            }
             });
   
     }
    form(){
 
     this.gregListService.updateGregList(this.gregList).subscribe((gregList)=>{
        console.log(gregList);
        this.router.navigate(['/gregList']);
      },(error)=>{
        console.log(error);
      });


}
}
