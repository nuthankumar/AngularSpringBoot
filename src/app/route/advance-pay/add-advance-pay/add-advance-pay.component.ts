import { Component } from '@angular/core';
import { HttpClientModule, HttpClient } from '@angular/common/http';
import { AgentMasterService } from '../../../services/agent-master.service';
import { IAgentMasterList } from '../../../model/agent-master';
import { IDeviation } from '../../../model/deviation';
import {Router,ActivatedRoute, Params} from '@angular/router';
import {GridOptions} from "ag-grid/main";
import { AdvancePayService } from '../../../services/advance-pay.service'
import { AdvancePay } from '../../../model/advance-pay';
import {NgSelectModule, NgOption} from '@ng-select/ng-select';

@Component({
    selector: 'add-advance-pay',
    templateUrl: 'add-advance-pay.component.html',
    styleUrls: ['add-advance-pay.component.scss']
})
export class AddAdvancePayComponent {
     private gridOptions:GridOptions;
    private pages:number;
     private currentPageNumber= 1;
     pageSize:number;
     private lists:any;
     recoverable:any;
     advDate:any
     amount:any
     effStartDt:any
     maxRecoverblePerCycle:any
     remarks:any
     netBalance:any
     confAttchment:any
     is_edit:boolean=true;
     agentNo:any;
     private selectedValue:Object={};
     constructor(private agentMasterService: AgentMasterService, private router:Router, private advancePayService:AdvancePayService){
        this.gridOptions = <GridOptions>{};
          
    }
     ngOnInit(){
        this.gridOptions.rowHeight=30;
        this.gridOptions.headerHeight=40;
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
         var getAdvDate= this.advDate;
       this.advDate= getAdvDate.replace(/-/g, "");
       var getEffStartDt= this.effStartDt;
       this.effStartDt= getEffStartDt.replace(/-/g, "");
   if(this.recoverable==true){
       this.recoverable=1;
       this.netBalance=this.amount;
   }else{
       this.recoverable=0;
       this.maxRecoverblePerCycle=0;
       this.netBalance=0;
   }
   
      var data=[{
                "agentNo":this.selectedValue["agentNo"],
                "advDate":this.advDate,
                "effStartDt":this.effStartDt,
                "amount":this.amount,
                "recoverable":this.recoverable,
                "remarks":this.remarks,
                "maxRecoverblePerCycle":this.maxRecoverblePerCycle,
                "netBalance":this.netBalance,
                "confAttchment":this.confAttchment
             }]
              console.log(data);
             this.advancePayService.updateAdvancePaymentsEntry(data).subscribe((data)=>{
          console.log(data);
           this.router.navigate(['/advancePay']);
          
        },(error)=>{
          console.log(error);
        });
    }
    
    checkboxState(){
        if(this.recoverable==true){
            this.is_edit=false;
        }else{
            this.is_edit=true;
        }
   }
   uploadData(event: any) : void{
        
        var file = event.target.files[0];
        let fileName = file.name;
        let payload = {file}
let formData: FormData = new FormData();
formData.append('file',file);
        console.log(file);
    this.advancePayService.emailAttachment(formData).subscribe((data)=>{
          console.log(data);
          
        },(error)=>{
          console.log(error);
   });
}
}
