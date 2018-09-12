import { Component } from '@angular/core';
import { HttpClientModule, HttpClient } from '@angular/common/http';
import { ContestService } from '../../../services/contest.service'
import { IDeviation } from '../../../model/deviation';
import {Router,ActivatedRoute, Params} from '@angular/router';
import {GridOptions} from "ag-grid/main";

@Component({
    selector: 'deviation-approval',
    templateUrl: 'deviation-approval.component.html',
    styleUrls: ['deviation-approval.component.scss']
})
export class DeviationApprovalComponent {
    private lists:IDeviation[];
     private gridOptions:GridOptions;
     private gridOptions1:GridOptions;
     pageSize:number;
    private pages:number;
    private gridApi:any;
   private gridColumnApi:any;
   private rowData: any[];
   private autoGroupColumnDef:any;
   private rowSelection:any;
   private rowGroupPanelShow:any;
   private pivotPanelShow:any;
   private paginationPageSize:any;
   private paginationNumberFormatter:any;
   private defaultColDef:any;
     selectedData: any;
     deviationApproveList:any;
     deviationApproveListTicket:any;
     data:any;
     rejectedData:any;
     ticketlists:any;
     private selectedrow:any;
     constructor(private contestservice: ContestService, private router:Router){
        this.gridOptions = <GridOptions>{};
        this.gridOptions1 = <GridOptions>{};
    }
     columnDefs = [
         { field: '',width: 140, headerCheckboxSelection: true, headerCheckboxSelectionFilteredOnly: true,
           checkboxSelection: true, suppressSorting: true, suppressMenu: true},
         {headerName: 'Contest ID', field: 'contestID',width: 140 },
         {headerName: 'Name', field: 'contestName',width: 140 },
         {headerName: 'Agent No', field: 'agentNo',width: 140 },
         {headerName: 'Load Date', field: 'loadDate',width: 140 },
         {headerName: 'Previous Net Payable', field: 'previousNetPayable',width: 140 },
         {headerName: 'Final Payable', field: 'netPayable',width: 140 },
         {headerName: 'Sel', field: '',width: 140 },
         {headerName: 'Deviation Entry', field: '',width: 140 },
         {headerName: 'Account Number', field: 'bankACNumber',width: 140 },
         {headerName: 'IFSC', field: 'ifscCode',width: 140 },
         {headerName: 'PAN', field: '',width: 140 },
         {headerName: 'Date Term', field: 'dtTerm',width: 140 },
         {headerName: 'Branch Code', field: 'branchCode',width: 140 },
];
columnDefs1 = [
         { field: '',width: 140, headerCheckboxSelection: true, headerCheckboxSelectionFilteredOnly: true,
           checkboxSelection: true, suppressSorting: true, suppressMenu: true},
         {headerName: 'Contest ID', field: 'contestID',width: 140 },
         {headerName: 'Name', field: 'contestName',width: 140 },
         {headerName: 'Agent No', field: 'agentNo',width: 140 },
         {headerName: 'Ticket Lists', field: 'ticketLists',width: 140 },
         {headerName: 'Option', field: 'option',width: 140 },
         {headerName: 'Dest ID', field: 'destId',width: 140 },
         {headerName: 'Previous Net Payable', field: 'previousNetPayable',width: 140 },
         {headerName: 'Final Payable', field: 'netPayable',width: 140 },
         {headerName: 'Remarks', field: 'remarks',width: 140 },
         {headerName: 'Entry Flag', field: 'entryFlag',width: 140 },
         {headerName: 'Status', field: 'status',width: 140 }
];
ngOnInit(){
    this.paginationPageSize = 10;
       this.gridOptions.rowHeight=40;
    this.gridOptions.headerHeight=40;
    this.contestservice.getdeviationCashList().subscribe((lists)=>{
            this.lists = lists.data.deviationListCash;
            this.deviationApproveList  = [];
               this.lists.forEach((ele : any) => {
                   this.deviationApproveList.push(ele.deviationCashKey);
                 })
               console.log(this.deviationApproveList)
          },(error)=>{
            console.log(error);
         })
         this.contestservice.getdeviationTicketsList().subscribe((ticketlists)=>{
            this.ticketlists = ticketlists.data.deviationTicketsList;
             console.log("data",ticketlists);
           for(let i=0; i<this.ticketlists.length;i++){
                var test = this.ticketlists[i].deviationTicketsKey.agentNo;
                var date = this.ticketlists[i].deviationTicketsKey.option;
                this.ticketlists[i].agentNo= test;
                this.ticketlists[i].option= date;
            }
          },(error)=>{
            console.log(error);
         })
         
}
 sendToApproverDeviation(){
          this.selectedrow=this.gridOptions.api.getSelectedRows();
    this.selectedrow=this.selectedrow;
    this.selectedData = {};
    let selectedRowData =[];
    for(var i = 0 ; i < this.selectedrow.length ; i++){ 
    selectedRowData.push({
            "contestId" :this.selectedrow[i].contestID,
            "agentNo":this.selectedrow[i].agentNo,
            "remarks":this.selectedrow[i].remarks
        });
    this.selectedData["selectedRowData"] = selectedRowData;
    this.rejectedData=selectedRowData;
}
        this.contestservice.updateApproveDeviationCash(this.rejectedData).subscribe((response)=>{
       console.log(this.rejectedData);
        var selectedNodes = this.gridOptions.api.getSelectedNodes();
this.gridOptions.api.removeItems(selectedNodes);
        },(error)=>{
          console.log(error);
        });
      
    }
     sendToApproverDeviationTicket(){
          this.selectedrow=this.gridOptions1.api.getSelectedRows();
    this.selectedrow=this.selectedrow;
    this.selectedData = {};
    let selectedRowData =[];
    for(var i = 0 ; i < this.selectedrow.length ; i++){ 
    selectedRowData.push({
            "contestId" :this.selectedrow[i].contestID,
            "agentNo":this.selectedrow[i].agentNo,
            "remarks":this.selectedrow[i].remarks,
            "option":this.selectedrow[i].option,
            "ticketLists":this.selectedrow[i].ticketLists,
            "destid":this.selectedrow[i].destId
        });
    this.selectedData["selectedRowData"] = selectedRowData;
    this.rejectedData=selectedRowData;
}
        this.contestservice.updateApproveDeviationTicket(this.rejectedData).subscribe((response)=>{
       console.log(this.rejectedData);
        var selectedNodes = this.gridOptions1.api.getSelectedNodes();
this.gridOptions1.api.removeItems(selectedNodes);
        },(error)=>{
          console.log(error);
        });
      
    }
    rejectFromDeviation(){
             this.selectedrow=this.gridOptions.api.getSelectedRows();
    this.selectedrow=this.selectedrow;
    this.selectedData = {};
    let selectedRowData =[];
    for(var i = 0 ; i < this.selectedrow.length ; i++){ 
    selectedRowData.push({
            "contestId" :this.selectedrow[i].contestID,
            "agentNo":this.selectedrow[i].agentNo,
            "remarks":this.selectedrow[i].remarks
        });
    this.selectedData["selectedRowData"] = selectedRowData;
    this.data=selectedRowData;
}
        this.contestservice.rejectDeviationCash(this.data).subscribe((response)=>{
       console.log(this.data);
        },(error)=>{
          console.log(error);
        });
    }
    rejectFromDeviationTicket(){
             this.selectedrow=this.gridOptions1.api.getSelectedRows();
    this.selectedrow=this.selectedrow;
    this.selectedData = {};
    let selectedRowData =[];
    for(var i = 0 ; i < this.selectedrow.length ; i++){ 
    selectedRowData.push({
            "contestId" :this.selectedrow[i].contestID,
            "agentNo":this.selectedrow[i].agentNo,
            "remarks":this.selectedrow[i].remarks,
            "ticketLists":this.selectedrow[i].ticketLists,
            "destid":this.selectedrow[i].destId
        });
    this.selectedData["selectedRowData"] = selectedRowData;
    this.data=selectedRowData;
}
        this.contestservice.rejectDeviationCash(this.data).subscribe((response)=>{
       console.log(this.data);
       
        },(error)=>{
          console.log(error);
        });
    }

    onPageSizeChanged(newPageSize:any) {
        var value = (<HTMLInputElement>document.getElementById("page-size")).value;
        this.gridOptions.api.paginationSetPageSize(Number(value));
        //this.gridApi.paginationSetPageSize(Number(value));
        // this.paginationPageSize = 10;
        this.paginationNumberFormatter = function(params:any) {
          return "[" + params.value.toLocaleString() + "]";
        };
        this.defaultColDef = {
          editable: true,
          enableRowGroup: true,
          enablePivot: true,
          enableValue: true
        };
      }
      
}
