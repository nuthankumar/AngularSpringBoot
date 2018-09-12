import { Component } from '@angular/core';
import { ReasonsService } from '../../../services/reasons.service'
import { Reasons } from '../../../model/reasons';
import {Router} from '@angular/router';
import {GridOptions} from "ag-grid/main";
import "ag-grid-enterprise";


@Component({
    selector: 'reasons-data',
    templateUrl: 'reasons-data.component.html',
    styleUrls: ['reasons-data.component.scss']
})
export class ReasonsDataComponent {
    private reasons:Reasons[];
    private gridOptions:GridOptions;
    pageSize:number;
    private pages:number;
    private gridApi:any;
   private gridColumnApi :any;
   private rowData: any[];
   private autoGroupColumnDef:any;
   private rowSelection:any;
   private rowGroupPanelShow:any;
   private pivotPanelShow:any;
   private paginationPageSize:any;
   private paginationNumberFormatter:any;
   private defaultColDef:any;
isvalid:boolean=true;
    constructor(private reasonsService: ReasonsService, private router:Router) {
        this.gridOptions = <GridOptions>{};
    }
    columnDefs = [
        { field: '',width: 60, headerCheckboxSelection: true,
        headerCheckboxSelectionFilteredOnly: true,
        checkboxSelection: true, suppressSorting: true,
                suppressMenu: true},
        {headerName: 'Code', field: 'code' ,width:250},
        {headerName: 'Name', field: 'name' ,width:250},
        {headerName: 'Description', field: 'description',width:250},
        {headerName: 'Status', field: 'status',valueGetter: 'if(data.status==true){return "Active"}else {return "Inactive"}',width:250}
    ];
   ngOnInit() {
        this.paginationPageSize = 10;
        this.gridOptions.rowHeight=30;
        this.gridOptions.headerHeight=40;
        this.reasonsService.getReasonsList().subscribe((reasons) => {
            this.reasons=reasons.data;
            debugger
            console.log(reasons)
          },(error) => {
            console.log(error);
         })
         
    }
    updateList(reason:any){
        this.reasons = this.gridOptions.api.getSelectedRows();
        this.reasonsService.setter(this.reasons[0]);
        this.router.navigate(['/editReasons'])
    }
    updateReason(reason:any){
        this.reasons = this.gridOptions.api.getSelectedRows();
        this.reasonsService.setter(this.reasons[0]);
        this.router.navigate(['/editReasons'])
    }
    createList() {
        let reason= new Reasons();
        this.reasonsService.setter(reason);
        this.router.navigate(['/addReasons']);
    }
    valueNameSetter(params:any) {
        var data = params.data;
        console.log("data"+data);
        if(data.status==false) {
            data.status='Active'
            return true
        }
        else {
            data.status='Active';
            return false
        }
    }
    onRowSelected(event:any){
  if(event.node.selected==true){
    this.isvalid=false;
    
  }else{
    this.isvalid=true;
  }
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
