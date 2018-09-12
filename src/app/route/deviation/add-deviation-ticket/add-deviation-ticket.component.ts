import { Component } from '@angular/core';
import { HttpClientModule, HttpClient } from '@angular/common/http';
import { ContestService } from '../../../services/contest.service'
import { ContestMasterList } from '../../../model/contest-list';
import { IDeviation } from '../../../model/deviation';
import {Router,ActivatedRoute, Params} from '@angular/router';
import {GridOptions} from "ag-grid/main";
import { AgentMasterService } from '../../../services/agent-master.service';

@Component({
    selector: 'add-deviation-ticket',
    templateUrl: 'add-deviation-ticket.component.html',
    styleUrls: ['add-deviation-ticket.component.scss']
})
export class AddDeviationTicketComponent {
    private lists:any;
    // private data:IDeviation[];
    loadDate : any;
    agentNo: any;
    netPayable: any;
    remarks: any;
    selectedAgent:any;
    attachment:any=null;
    selectedValue:Object={};
    selectedValue1:Object={};
    selectedValueDest:Object={};
     private gridOptions:GridOptions;
     someName:any;
     public counter : number = 0;
     public counterT : number = 0;
     cashA:any;
     qualifiedTicketCount:any;
     qualifiedCashCount:any;
     paidTicketCount:any;
     paidCashCount:any;
     cash: any;
     allpaidCount:any;
     recoverable:any;
     trip:any;
     ticketDev:any;
     additional:any;
     recover:any;
     is_edit:boolean=true;
     aglists:any;
     dest:any;
    constructor(private contestservice: ContestService, private router:Router,private agentMasterService: AgentMasterService){
        this.gridOptions = <GridOptions>{};
          this.lists=[];
    }
    ngOnInit(){
        this.cash = 0;
        this.trip = 0;
        this.gridOptions.rowHeight=40;
        this.gridOptions.headerHeight=40;
       
       this.contestservice.allContestsDrp().subscribe((lists) => {
      debugger;
      this.lists = lists.data;
      console.log("lists",this.lists)
    }, (error) => {
      console.log(error);
    })
    this.agentMasterService.AgentList().subscribe((aglists)=>{
      console.log(aglists);
      this.aglists=aglists.data;
      for(let i=0;i<this.aglists.length;i++){
          var number= this.aglists[i].agentListKey.agentNo;
          this.aglists[i].agentNo=number;
      }
     
     
});
        // this.contestservice.contestMasterWithTripDetails().subscribe((lists)=>{
        //     debugger;
        //     this.lists=lists.data.contestMasters;
        //     console.log("data",this.lists);
        //     for(let i=0; i<this.lists.length;i++){
        //         var cashA = this.lists[i].deviationTicketPojo.cashAmt;
        //         var destid = this.lists[i].deviationTicketPojo.destID;
        //         var destname = this.lists[i].deviationTicketPojo.destName;
        //         var tripA = this.lists[i].deviationTicketPojo.tripAmt;
        //         if(destname==null){
        //             this.lists[i].cashAmt= cashA;
        //         this.lists[i].destID= destid;
        //         this.lists[i].destName= destname;
        //         this.lists[i].tripAmt= tripA;
        //         }else{
        //             var name = destname.split("+");
        //         this.lists[i].cashAmt= cashA;
        //         this.lists[i].destID= destid;
        //         this.lists[i].destName= name;
        //         this.lists[i].tripAmt= tripA;
        //         }
                
        //         console.log('destNamea',this.lists[i].destName);
                
        //     }
        //     console.log('destName',destname);
        //        // console.log('destNamea',this.lists[i].destName);

        //     console.log("data",this.lists);
        //   },(error)=>{
        //     console.log(error);
        //  })
         
    }
    getDest(contestId:any){
        var data = this.selectedValue["contestId"];
        this.contestservice.getTripDetails(data).subscribe((dest) => {
      debugger;
      this.dest = dest.data;
      console.log("trip det",this.dest)
    }, (error) => {
      console.log(error);
    })
    }
    form(){
        console.log(data);
        debugger;
        console.log()
        var getDate= this.loadDate;
       var newStr = getDate.replace(/-/g, "");
        if(this.additional==true){
            this.additional=1;
            this.recover=0;
        }else{
            this.additional=0;
            this.recover=1;
        }
       var data =[{
           'contestId': this.selectedValue["contestId"],
           'agentNo' : this.selectedAgent["agentNo"],
           'contestName': this.selectedValue["contestName"],
           'startDate': this.selectedValue["startDate"],
           'endDate': this.selectedValue["endDate"],
           'loadDate' : newStr,
           'destid':this.selectedValueDest["destID"],
           'qualifiedTicketCount':this.counter,
           'qualifiedCashCount':this.counterT,
           'cashValue':this.selectedValueDest["cashAmt"],
           'ticketValue':this.selectedValueDest["tripAmt"],
           'paidTicketCount':this.paidTicketCount,
           'paidCashCount':this.paidCashCount,
           'allpaidCount':this.allpaidCount,
           'remarks' : this.remarks,
           'attachment':this.attachment,
           'additional':this.additional,
           'recover':this.recover

        }]
        console.log(data);
        this.contestservice.updateDeviationTicket(data).subscribe((data)=>{
          console.log(data);
          
        },(error)=>{
          console.log(error);
        });
     }
    
//     valueChange(list){
//     this.someName=this.list.contestName;
// }
   incNumberCash(){
    this.counter += 1;
    this.cash=this.selectedValueDest["cashAmt"];
   this.cash = this.cash*this.counter
    console.log("data",this.cash);
}
   decNumberCash(){
       this.counter -= 1;
        this.cash=this.selectedValueDest["cashAmt"];
   this.cash = this.cash*this.counter
}
incNumberTrip(){
    this.counterT += 1;
    this.trip=this.selectedValueDest["tripAmt"];
   this.trip = this.cash*this.counterT
    console.log("data",this.trip);
}
decNumberTrip(){
    this.counterT -= 1;
        this.trip=this.selectedValueDest["tripAmt"];
   this.trip = this.trip*this.counterT
}
  
    onChange(event:any): void {  // event will give you full breif of action
    const newVal = this.selectedAgent;
    var val=this.selectedValue["contestId"];
    var valDest= this.selectedValueDest["destID"];
    console.log(this.selectedValueDest,this.selectedAgent,val);
     var data;
    if(val!=null && this.selectedValueDest!=null && this.selectedAgent!=null){
         
        this.contestservice.getCountForDev(val,this.selectedAgent,valDest).subscribe((list)=>{
            this.ticketDev=list.data;
          console.log("this.ticketDev",this.ticketDev[0].allpaidCount);
          this.allpaidCount=this.ticketDev[0].allpaidCount;
          this.paidCashCount=this.ticketDev[0].paidCashCount;
          this.paidTicketCount=this.ticketDev[0].paidTicketCount;
        },(error)=>{
          console.log(error);
        });
    }else{

    }
  }
   checkboxState(){
        if(this.additional==true){
            this.is_edit=false;
        }else{
            this.is_edit=true;
        }
   }
   checkboxStateRecover(){

       if(this.allpaidCount>0 &&  this.paidCashCount>0 && this.paidTicketCount>0 ){
            this.is_edit=false;
        }else{
            this.is_edit=true;
        }
   }

}
