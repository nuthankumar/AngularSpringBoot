import { Component } from '@angular/core';
import { HttpClientModule, HttpClient } from '@angular/common/http';
import { CheckerService } from '../../services/checker.service'
import { IAgentWiseMakerList } from '../../model/master-contest';
import { ITransactionCash } from '../../model/transaction-cash';
import {Router,ActivatedRoute, Params} from '@angular/router';
import {GridOptions} from "ag-grid/main";

@Component({
    selector: 'checker-contest-list-detail',
    templateUrl: 'checker-contest-list-detail.component.html',
    styleUrls: ['checker-contest-list-detail.component.scss']
})
export class CheckerContestListDetailComponent {
     private gridOptions:GridOptions;
   private lists:IAgentWiseMakerList[];
    private list:IAgentWiseMakerList;
     private gridOptions1:GridOptions;
   private rowSelection:any;
   private rowData: any[];
   private isRowSelectable:any;
   pageSize: number;
   private pages: number;
   private gridApi: any;
   private gridColumnApi: any;
   private autoGroupColumnDef: any;
   private rowGroupPanelShow: any;
   private pivotPanelShow: any;
   private paginationPageSize: any;
   private paginationNumberFormatter: any;
   private defaultColDef: any;


   selectedData: any;
   checkerTicket:any;
   data:any;
  private selectedrow:any;
constructor(private checkerService: CheckerService, private router:Router,private route: ActivatedRoute,){
       this.gridOptions = <GridOptions>{};
        this.gridOptions1 = <GridOptions>{};
        this.isRowSelectable = function(rowNode:any) {
           
           return rowNode.data.validation == 'PASS' ? rowNode.data : rowNode.disabled;
    };
    }
      columnDefs = [
         { field: '',width: 60, headerCheckboxSelection: true,
        headerCheckboxSelectionFilteredOnly: true,
        checkboxSelection: true, suppressSorting: true,
                suppressMenu: true},
         {headerName: 'Status', field: 'status',width: 130 },
         {headerName: 'Validation', field: 'validation',width: 140 },
         {headerName: 'Agent No', field: 'agentNo',width: 180 },
         {headerName: 'Agent Name', field: 'agentName',width: 190 },
         {headerName: 'Original Payable', field: 'previousNetPayable',width: 170 },
         {headerName: 'Final Payable', field: 'netPayable',width: 150 },
         {headerName: 'Entry', field: 'entryFlag',width: 160 ,valueGetter: 'if(data.entryFlag==1){return "Deviation"}else {return "Callidus"}'}
];
columnDefsTicket = [
    { field: '',width: 60, headerCheckboxSelection: true,
        headerCheckboxSelectionFilteredOnly: true,
        checkboxSelection: true, suppressSorting: true,
                suppressMenu: true},
         {headerName: 'Deviation', field: 'add', cellRenderer: function(params:any){
      return "<a routerLink='/addDeviation'>add</a>";},width: 120 },
         {headerName: 'Status', field: 'status',width: 100 },
         {headerName: 'Validation', field: 'validation',width: 120 },
         {headerName: 'Agent No', field: 'agentNo',width: 120 },
         {headerName: 'Agent Name', field: 'agentName',width: 140 },
         {headerName: 'Original Payable', field: 'previousNetPayable',width: 140 },
         {headerName: 'Final Payable', field: 'netPayable',width: 140 },
         {headerName: 'Entry', field: 'entryFlag',valueGetter: 'if(data.entryFlag==1){return "Deviation"}else {return "Callidus"}',width: 140 },
         {headerName: 'Ticket Lists', field: 'ticketLists',width: 140 },
         {headerName: 'Option', field: 'option',width: 140 },
         {headerName: 'Dest ID', field: 'destId',width: 140 },
         {headerName: 'Account Number', field: 'bankACNumber',width: 140 },
         {headerName: 'IFSC Code', field: 'ifscCode',width: 140 },
         {headerName: 'PAN Number', field: 'irdNo',width: 140 },
         {headerName: 'Termination Date', field: 'dtTerm',width: 140 },
         {headerName: 'Branch Code', field: 'branchCode',width: 140 },
]

ngOnInit(){
    this.paginationPageSize = 10;
      this.gridOptions.rowHeight=30;
       this.gridOptions1.rowHeight=30;
         this.gridOptions1.headerHeight=40;
    this.gridOptions.headerHeight=40;
         this.route.params.switchMap((params:Params) =>
        this.checkerService.getagentWiseCheckerContestList(+params['contestId'])).subscribe((lists)=>{
            this.lists=lists.data;
          },(error)=>{
            console.log(error);
         })
         this.route.params.switchMap((params:Params) =>
        this.checkerService.getagentWiseCheckerContestTicket(+params['contestId'])).subscribe((checkerTicket)=>{
            this.checkerTicket=checkerTicket.data;
            for(let i=0; i<this.checkerTicket.length;i++){
                var test = this.checkerTicket[i].agentWiseContestTicketKey.option;
                var number = this.checkerTicket[i].agentWiseContestTicketKey.agentNo;
                this.checkerTicket[i].option= test;
                this.checkerTicket[i].agentNo= number;
            }
          },(error)=>{
            console.log(error);
         })
        
         
    }
    selectAllCheckbox(){
        this.gridOptions.api.selectAll();
        this.selectedrow=this.gridOptions.api.getSelectedRows();
     }
        refresh(): void {
    window.location.reload();
}
      sendToApprover(){
          this.selectedrow=this.gridOptions.api.getSelectedRows();
    this.selectedrow=this.selectedrow;
    this.selectedData = {};
    let selectedRowData =[];
    for(var i = 0 ; i < this.selectedrow.length ; i++){ 
    selectedRowData.push({
            "contestId" :this.selectedrow[i].contestId,
            "agentNo" :this.selectedrow[i].agentNo ,
            "remarks":null
        });
    this.selectedData["selectedRowData"] = selectedRowData;
    this.data=selectedRowData;
    console.log("hdfkjs",this.data);
}
        this.checkerService.updateToApprover(this.data).subscribe((response)=>{
       console.log(this.data);
        var selectedNodes = this.gridOptions.api.getSelectedNodes();
        this.gridOptions.api.removeItems(selectedNodes);
        },(error)=>{
          console.log(error);
        });
      
    }
    sendToApproverTicket(){
          this.selectedrow=this.gridOptions1.api.getSelectedRows();
    this.selectedrow=this.selectedrow;
    this.selectedData = {};
    let selectedRowData =[];
    for(var i = 0 ; i < this.selectedrow.length ; i++){ 
    selectedRowData.push({
           "contestId" :this.selectedrow[i].contestId,
            "agentNo" :this.selectedrow[i].agentNo ,
           "destid": this.selectedrow[i].destId,
           "ticketLists":this.selectedrow[i].ticketLists,
           "option":this.selectedrow[i].option,
            "remarks":null
        });
    this.selectedData["selectedRowData"] = selectedRowData;
    this.data=selectedRowData;
    console.log("hdfkjs",this.data);
}
        this.checkerService.updateToApproverTicket(this.data).subscribe((response)=>{
       console.log(this.data);
        var selectedNodes = this.gridOptions1.api.getSelectedNodes();
        this.gridOptions1.api.removeItems(selectedNodes);
        },(error)=>{
          console.log(error);
        });
      
    }

    onPageSizeChanged(newPageSize: any) {
        var value = (<HTMLInputElement>document.getElementById("page-size")).value;
        this.gridOptions.api.paginationSetPageSize(Number(value));
        //this.gridApi.paginationSetPageSize(Number(value));
        // this.paginationPageSize = 10;
        this.paginationNumberFormatter = function (params: any) {
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
