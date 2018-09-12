import { Component } from '@angular/core';
import { ApproverThreeService } from '../../services/approver-three.service';
import { Router } from '@angular/router';
import { GridOptions } from "ag-grid/main";

@Component({
    selector: 'approver-three-contest-view',
    templateUrl: 'approver-three-contest-view.component.html',
    styleUrls: ['approver-three-contest-view.component.scss']
})
export class ApproverThreeContestViewComponent {
    private lists:any;
        gridOptions: GridOptions;
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
   
     constructor(private approverThreeService: ApproverThreeService, private router:Router){
        this.gridOptions = <GridOptions>{};

    }
    columnDefs = [
         { field: '',width: 60, headerCheckboxSelection: true,
        headerCheckboxSelectionFilteredOnly: true,
        checkboxSelection: true, suppressSorting: true,
                suppressMenu: true},
         {headerName: 'PRF Gen Ref', field: 'prfGenRef' },
        {headerName: 'PRF GEN Date', field: 'prfGenDate' },
        {headerName: 'Net Payable', field: 'prfAmount'},
        {headerName: 'Status', field: 'status'},
        {headerName: 'Remarks', field: 'remarks',editable:true, valueSetter: this.nameValueGetter},
        
       


    ];
    ngOnInit(){
        this.paginationPageSize = 10;
          this.gridOptions.rowHeight=30;
    this.gridOptions.headerHeight=40;
        this.approverThreeService.getapproverThreeContestList().subscribe((lists)=>{
            this.lists=lists.data.approverThreeContestCount;
           
            console.log(lists);
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
            "prfNoGenREF" :this.selectedrow[i].prfGenRef,
            "remarks":this.selectedrow[i].remarks

        });
    this.selectedData["selectedRowData"] = selectedRowData;
    this.data=selectedRowData;
}
        this.approverThreeService.updateApproverThree(this.data).subscribe((response)=>{
       console.log(this.data);
       var selectedNodes = this.gridOptions.api.getSelectedNodes();
        this.gridOptions.api.removeItems(selectedNodes);
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
            "remarks":this.selectedrow[i].remarks
        });
        this.selectedData["selectedRowData"] = selectedRowData;
        this.data=selectedRowData;
        this.approverThreeService.rejectApproverThreeTransactionCash(this.data).subscribe((response) => {
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
