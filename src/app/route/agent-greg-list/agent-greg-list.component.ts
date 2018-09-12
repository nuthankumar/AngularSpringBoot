import { Component } from '@angular/core';
import { ContestService } from '../../services/contest.service';
import {Router} from '@angular/router';
import {GridOptions} from "ag-grid/main";
import { GregListService } from '../../services/greg-list.service';

import "ag-grid-enterprise";

@Component({
    selector: 'agent-greg-list',
    templateUrl: 'agent-greg-list.component.html',
    styleUrls: ['agent-greg-list.component.scss']
})
export class AgentGregListComponent {
    private gridOptions:GridOptions;
    lists:any;
    greglist:any;
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
   isvalid: boolean=true;

     constructor(private contestservice: ContestService, private router:Router,private gregListService:GregListService){
        this.gridOptions = <GridOptions>{};


    }
    columnDefs = [
         { field: '',width: 60, headerCheckboxSelection: false,
        headerCheckboxSelectionFilteredOnly: true,
        checkboxSelection: true, suppressSorting: true,
                suppressMenu: true},
         {headerName: 'Agent No', field: 'agentNo',width:200},
         {headerName: 'Agent Name', field: 'agentName',width:200 },
        {headerName: 'Agent Type', field: 'agentType' ,width:200},
        {headerName: 'Start Date', field: 'startDate',width:200},
        {headerName: 'End Date', field: 'endDate',width:200}
        //{headerName: 'Status', field: 'status'},
        



    ];
    ngOnInit(){
        this.paginationPageSize = 10;
          this.gridOptions.rowHeight=30;
    this.gridOptions.headerHeight=40;
        this.contestservice.getGregList().subscribe((lists)=>{
            this.lists=lists.data;
            console.log(this.lists);
            for(let i=0; i<this.lists.length;i++){
                var agentNumber = this.lists[i].agentGregListKey.agentNo;
                var agenttype = this.lists[i].agentGregListKey.agentType;
                var enddate = this.lists[i].agentGregListKey.endDate;
                var startdate = this.lists[i].agentGregListKey.startDate;
                this.lists[i].agentNo= agentNumber;
                this.lists[i].agentType= agenttype;
                this.lists[i].endDate= enddate;
                this.lists[i].startDate= startdate;
            }
            console.log(lists)
          },(error)=>{
            console.log(error);
         })
        }
        updategregList(greglist:any){
        this.greglist = this.gridOptions.api.getSelectedRows();
        this.gregListService.setter(this.greglist[0]);
        this.router.navigate(['/editGregList'])
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
