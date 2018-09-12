import { Component } from '@angular/core';
import { ContestService } from '../../services/contest.service'
import { ContestMasterList } from '../../model/contest-list';
import {GridOptions} from "ag-grid/main";
import {Router} from '@angular/router';
import "ag-grid-enterprise";


@Component({
    selector: 'contest-master-list',
    templateUrl: 'contest-master-list.component.html',
    styleUrls: ['contest-master-list.component.scss']
})
export class ContestMasterListComponent {
    private lists:ContestMasterList[];
     private gridOptions:GridOptions;
      private currentPageNumber= 1;
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

     Valid=true;
    constructor(private contestservice: ContestService, private router:Router){
        this.gridOptions = <GridOptions>{};

    }
     columnDefs = [
         
        {headerName: 'SL No', field: 'contestAutoId',width: 100 },
        {headerName: 'Contest ID', field: 'contestId',width: 220 },
        {headerName: 'Contest Name', field: 'contestName',width: 220},
        {headerName: 'Start Date', field: 'startDate',width: 220},
        {headerName: 'End Date', field: 'endDate',width: 220},
        {headerName: 'AG Types', field: 'agTypes',width: 220},
        {headerName: 'Category', field: 'incentive_YorN',width: 220},
        {headerName: 'Channel', field: 'chanelName',width: 200},
        //{headerName: 'Status', field: '',width: 200}
     ];
    
     ngOnInit(){
        this.paginationPageSize = 10;
        this.gridOptions.rowHeight=30;
        this.gridOptions.headerHeight=40;
        this.getContestList();
         
    }
    getContestList(){
      
        this.contestservice.getMasterContest().subscribe((lists)=>{
            this.lists=lists.data;
            
            console.log(lists);
          },(error)=>{
            console.log(error);
         })

      
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