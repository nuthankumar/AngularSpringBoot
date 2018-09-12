import { Component } from '@angular/core';
import { ApproverTwoService } from '../../services/approver-two.service'
import { IApproverTwoContestView } from '../../model/approver-two';
import {Router} from '@angular/router';
import { GridOptions } from "ag-grid/main";


@Component({
    selector: 'approver-two-contest-view',
    templateUrl: 'approver-two-contest-view.component.html',
    styleUrls: ['approver-two-contest-view.component.scss']
})
export class ApproverTwoContestViewComponent {
    private lists:any;
        gridOptions: GridOptions;
        gridOptions1: GridOptions;
        private Ticketlists:any;
        private selectedrow:any;
        pageSize: number;
    private pages: number;
    private gridApi: any;
    private gridColumnApi: any;
    private rowData: any[];
    private autoGroupColumnDef: any;
    private rowSelection: any;
    private rowGroupPanelShow: any;
    private pivotPanelShow: any;
    private paginationPageSize: any;
    private paginationNumberFormatter: any;
    private defaultColDef: any;

    selectedData: any;
   data:any;
    selectedValue:any;
    value:any;
   private isRowSelectable:any;
   
     constructor(private approverTwoService: ApproverTwoService, private router:Router){
        this.gridOptions = <GridOptions>{};
        this.gridOptions1 = <GridOptions>{};

    }
    columnDefs = [
         { field: '',width: 60, headerCheckboxSelection: true,
        headerCheckboxSelectionFilteredOnly: true,
        checkboxSelection: true, suppressSorting: true,
                suppressMenu: true},
         {headerName: 'PRF NO', field: 'prfNo' },
        {headerName: 'PRF GEN Date', field: 'prfGenDate' },
        {headerName: 'Net Payable', field: 'prfAmount'},
        {headerName: 'Status', field: 'status'},
        {headerName: 'Remarks', field: 'remarks',editable:true, valueSetter: this.nameValueGetter},
        
       


    ];
    ngOnInit(){
        this.paginationPageSize = 10;
          this.gridOptions.rowHeight=30;
    this.gridOptions.headerHeight=40;
    this.gridOptions1.rowHeight=30;
    this.gridOptions1.headerHeight=40;
        this.approverTwoService.getapproverTwoContestList().subscribe((lists)=>{
            this.lists=lists.data.approverTwoContestViewList;
            for(let i=0; i<this.lists.length;i++){
                var test = this.lists[i].approverOneKey.prfNo;
                var date = this.lists[i].approverOneKey.makerTimeActual;
                this.lists[i].prfNo= test;
                this.lists[i].makerTimeActual= date;
            }
            console.log(lists)
          },(error)=>{
            console.log(error);
         })
         this.approverTwoService.getapproverTwoContestListTicket().subscribe((Ticketlists)=>{
            this.Ticketlists=Ticketlists.data.approverOneTicketViewList;
            console.log(Ticketlists)
          },(error)=>{
            console.log(error);
         })
         
    }
    nameValueGetter(params:any) {
              params.data['remarks'] = params.newValue;
              
              return true;
     }
    
    sendToPayout(){
          this.selectedrow=this.gridOptions.api.getSelectedRows();
    this.selectedrow=this.selectedrow;
    this.selectedData = {};
    let selectedRowData =[];
    for(var i = 0 ; i < this.selectedrow.length ; i++){ 
    selectedRowData.push({
            "prfNoGenRef" :this.selectedrow[i].prfGenRef,
            "remarks":this.selectedrow[i].remarks,
            "prfNo" :this.selectedrow[i].prfNo,

        });
    this.selectedData["selectedRowData"] = selectedRowData;
    this.data=selectedRowData;
}
        this.approverTwoService.updateToPayout(this.data).subscribe((response)=>{
       console.log(this.data);
       var selectedNodes = this.gridOptions.api.getSelectedNodes();
        this.gridOptions.api.removeItems(selectedNodes);
        },(error)=>{
          console.log(error);
        });
      
    }
    sendToPayoutTicket(){
          this.selectedrow=this.gridOptions1.api.getSelectedRows();
    this.selectedrow=this.selectedrow;
    this.selectedData = {};
    let selectedRowData =[];
    for(var i = 0 ; i < this.selectedrow.length ; i++){ 
    selectedRowData.push({
            "prfNoGenREF" :this.selectedrow[i].prfGenRef,
            "remarks":this.selectedrow[i].remarks,

        });
    this.selectedData["selectedRowData"] = selectedRowData;
    this.data=selectedRowData;
}
        this.approverTwoService.updateToPayoutTicket(this.data).subscribe((response)=>{
       console.log(this.data);
       var selectedNodes = this.gridOptions1.api.getSelectedNodes();
        this.gridOptions1.api.removeItems(selectedNodes);
        },(error)=>{
          console.log(error);
        });
    }
    rejectBtn(){
          this.selectedrow=this.gridOptions.api.getSelectedRows();
    this.selectedrow=this.selectedrow;
    this.selectedData = {};
    let selectedRowData =[];
    for(var i = 0 ; i < this.selectedrow.length ; i++){
    selectedRowData.push({
            "prfNoGenREF" :this.selectedrow[i].prfGenRef,
            "remarks":this.selectedrow[i].remarks,
             "prfNo" :this.selectedrow[i].prfNo,
        });
        this.selectedData["selectedRowData"] = selectedRowData;
        this.data=selectedRowData;
        this.approverTwoService.rejectApproverTwoTransactionCash(this.data).subscribe((response) => {
        console.log("df",this.data);
        },(error)=>{
        this.router.navigate(['/login'])
        });
    }
    }
    rejectBtnTicket(){
          this.selectedrow=this.gridOptions1.api.getSelectedRows();
    this.selectedrow=this.selectedrow;
    this.selectedData = {};
    let selectedRowData =[];
    for(var i = 0 ; i < this.selectedrow.length ; i++){
    selectedRowData.push({
            "prfNoGenREF" :this.selectedrow[i].prfGenRef,
            "remarks":this.selectedrow[i].remarks
        });
        this.selectedData["selectedRowData"] = selectedRowData;
        this.data=selectedRowData;
        this.approverTwoService.rejectApproverTwoTransactionTicket(this.data).subscribe((response) => {
        console.log("df",this.data);
        },(error)=>{
        this.router.navigate(['/login'])
        });

    }
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
