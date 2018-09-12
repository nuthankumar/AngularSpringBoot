import { Component,ChangeDetectorRef,NgZone  } from '@angular/core';
import { HttpClientModule, HttpClient } from '@angular/common/http';
import { MakerService } from '../../services/maker.service'
import { IAgentWiseMakerList } from '../../model/master-contest';
import { ITransactionCash } from '../../model/transaction-cash';
import {Router,ActivatedRoute, Params,RouterModule} from '@angular/router';
import { AgRendererComponent } from 'ag-grid-angular';
import {GridOptions} from "ag-grid/main";
@Component({
    selector: 'maker-contest-list-detail',
    templateUrl: 'maker-contest-list-detail.component.html',
    styleUrls: ['maker-contest-list-detail.component.scss']
})
export class MakerContestListDetailComponent implements AgRendererComponent{
   private gridOptions: GridOptions;
   private gridOptions1:GridOptions;
   private lists: IAgentWiseMakerList[];
   private list: IAgentWiseMakerList;
   private Ticketlists:any;
   private rowSelection: any;
   private rowData: any[];
   private isRowSelectable: any;
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
   contestname:any;
   contestid:any;
   data: any;
   params:any;
   private selectedrow: any;
   constructor(private makerService: MakerService, private router:Router,private ChangeDet:ChangeDetectorRef,private route: ActivatedRoute, private ngZone: NgZone,){
       this.gridOptions = <GridOptions>{};
       this.gridOptions1 = <GridOptions>{};
       this.rowSelection = "multiple";
    }
    columnDefs = [
         { field: '',width: 60, headerCheckboxSelection: true,
        headerCheckboxSelectionFilteredOnly: true,
        checkboxSelection: true, suppressSorting: true,
                suppressMenu: true},
         {headerName: 'Deviation', field: 'add',width: 120,cellRenderer: function(params) {
      return "<a class='clickableLabel' data-action-type='view'>add</a>";
    },
 },
         {headerName: 'Status', field: 'status',width: 100 },
         {headerName: 'Validation', field: 'validation',width: 120 },
         {headerName: 'Agent No', field: 'agentNo',width: 120 },
         {headerName: 'Agent Name', field: 'agentName',width: 140 },
         {headerName: 'Original Payable', field: 'previousNetPayable',width: 180 },
         {headerName: 'Final Payable', field: 'netPayable',width: 140 },
         {headerName: 'Entry', field: 'entryFlag',valueGetter: 'if(data.entryFlag==1){return "Deviation"}else {return "Callidus"}',width: 140 },
         {headerName: 'Account Number', field: 'bankACNumber',width: 180 },
         {headerName: 'IFSC Code', field: 'ifscCode',width: 140 },
         {headerName: 'PAN Number', field: 'irdNo',width: 140 },
         {headerName: 'Termination Date', field: 'dtTerm',width: 140 },
         {headerName: 'Branch Code', field: 'branchCode',width: 140 },
];
columnDefsTicket = [
    { field: '',width: 60, headerCheckboxSelection: true,
        headerCheckboxSelectionFilteredOnly: true,
        checkboxSelection: true, suppressSorting: true,
                suppressMenu: true},
         {headerName: 'Deviation', field: 'add', width: 120 },
         {headerName: 'Status', field: 'status',width: 100 },
         {headerName: 'Validation', field: 'validation',width: 120 },
         {headerName: 'Agent No', field: 'agentNo',width: 120 },
         {headerName: 'Agent Name', field: 'agentName',width: 140 },
         {headerName: 'Original Payable', field: 'previousNetPayable',width: 180 },
         {headerName: 'Final Payable', field: 'netPayable',width: 140 },
         {headerName: 'Entry', field: 'entryFlag',valueGetter: 'if(data.entryFlag==1){return "Deviation"}else {return "Callidus"}',width: 140 },
         {headerName: 'Ticket Lists', field: 'ticketLists',width: 140 },
         {headerName: 'Option', field: 'option',width: 140 },
         {headerName: 'Dest ID', field: 'destId',width: 140 },
         {headerName: 'Account Number', field: 'bankACNumber',width: 180 },
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
        
         this.route.params.switchMap((params: Params) =>
        this.makerService.getAgentWiseMakerContestList(+params['contestId'])).subscribe((lists)=>{
            this.lists=lists.data;
            console.log(this.lists);
            console.log(this.lists[0].contestName);
            this.contestname= this.lists[0].contestName;
            this.contestid= this.lists[0].contestId;
          },(error)=>{
            console.log(error);
         })


this.route.params.switchMap((params: Params) =>
        this.makerService.getAgentWiseMakerContestTicketList(+params['contestId'])).subscribe((Ticketlists)=>{
            this.Ticketlists=Ticketlists.data;
            this.contestname= this.Ticketlists[0].contestName;
             for(let i=0; i<this.Ticketlists.length;i++){
                var test = this.Ticketlists[i].agentWiseContestTicketKey.option;
                var number = this.Ticketlists[i].agentWiseContestTicketKey.agentNo;
                this.Ticketlists[i].option= test;
                this.Ticketlists[i].agentNo= number;
            }
            
            console.log("dsfs",this.Ticketlists);
          },(error)=>{
            console.log(error);
         })

         this.isRowSelectable = function(rowNode:any) {
             console.log("==>"+rowNode.id);
           return rowNode.data.validation == 'PASS' ? rowNode.data : rowNode.disabled;
    };
}

// navigate(link:any) {
//         this.ngZone.run(() => {
//             this.router.navigate(["/addDeviation"]);
//         });
//     }
    agInit(params: any): void {
        this.params = params;
    }

    refresh(params: any): boolean {
        return false;
    }
    onRowClicked(e) {
    if (e.event.target !== undefined) {
      debugger
      let data = e.data;
      let actionType = e.event.target.getAttribute("data-action-type");
      if (actionType === "view") {
          
        this.router.navigate(["/editDeviation",data.contestId]);
        console.log(data);
      }
    }

  }

     
sendToChecker(){
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
    
}

        this.makerService.updateData(this.data).subscribe((response)=>{
       console.log(this.data);
      var selectedNodes = this.gridOptions.api.getSelectedNodes();
this.gridOptions.api.removeItems(selectedNodes);

      
    // this.router.navigate(['/makerContestList']);
        },(error)=>{
          console.log(error);
        });
      
    }
    sendToCheckerTicket(){
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
    
}

        this.makerService.updateToCheckerTicket(this.data).subscribe((response)=>{
       console.log(this.data);
      var selectedNodes = this.gridOptions1.api.getSelectedNodes();
this.gridOptions1.api.removeItems(selectedNodes);

      
    // this.router.navigate(['/makerContestList']);
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
