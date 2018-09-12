import { Component } from '@angular/core';
import { HttpClientModule, HttpClient } from '@angular/common/http';
import { ContestService } from '../../services/contest.service'
import { IPRFList } from '../../model/prf-list';
import { IDeviation } from '../../model/deviation';
import {Router,ActivatedRoute, Params} from '@angular/router';
import {GridOptions} from "ag-grid/main";
import { AdvancePayService } from '../../services/advance-pay.service'
import { AdvancePay } from '../../model/advance-pay';
import { Channel } from '../../model/channel';
@Component({
    selector: 'add-contest-master',
    templateUrl: 'add-contest-master.component.html',
    styleUrls: ['add-contest-master.component.scss']
})
export class AddContestMasterComponent {
    private gridOptions:GridOptions;
    private agentTypes:IPRFList[];
    selectedChannel:Object={};
    selectedAG:Object={};
    selectedCategory:Object={};
    channelTypes: Channel[];
    contestName:any
    trip:any
    cash:any
    startDate:any;
    endDate:any;
    confAttchment:any;
    destId:any=0;
    cashAmt:any=0;
    tripAmt:any=0;
constructor(private contestService: ContestService, private router:Router){
        this.gridOptions = <GridOptions>{};
          
    }
    ngOnInit(){
       this.gridOptions.rowHeight=40;
    this.gridOptions.headerHeight=40;
         this.contestService.getagentTypes().subscribe((agentTypes)=>{
            this.agentTypes=agentTypes.data;
            debugger
          },(error)=>{
            console.log(error);
            })
         
         this.contestService.getChannelList().subscribe((channelTypes)=>{
            this.channelTypes=channelTypes.data.channelMasters;
            console.log(channelTypes)
          },(error)=>{
            console.log(error);
            })
         }

         form(){
 var getstartDate= this.startDate;
       this.startDate= getstartDate.replace(/-/g, "");
       var getendDate= this.endDate;
       this.endDate= getendDate.replace(/-/g, "");
    if(this.trip==true){
       this.trip=true;
    }else{
       this.trip=false;
   }
    
             var data=[{
                "chkTrip": this.trip,
                "chkCash": this.cash,
                "destId": this.destId,
                "cashAmt": this.cashAmt,
                "tripAmt": this.tripAmt,
                "contestName": this.contestName,
                "startDate": this.startDate,
                "cid": this.selectedChannel["cid"],
                "endDate": this.endDate,
                "contestType": this.selectedCategory,
                "agtypes": this.selectedAG,
                "attachment": this.confAttchment
             }]
             console.log(data);
            this.contestService.updateMasterContest(data).subscribe((data)=>{
          console.log(data);
          },(error)=>{
          console.log(error);
        });
               
         }
}
