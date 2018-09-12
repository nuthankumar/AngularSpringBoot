import { Component } from '@angular/core';
import { HttpClientModule, HttpClient } from '@angular/common/http';
import { AgentMasterService } from '../../../services/agent-master.service'
import { IAgentMasterList } from '../../../model/agent-master';
import {Router,ActivatedRoute, Params} from '@angular/router';
import { GridOptions } from "ag-grid/main";
import "ag-grid-enterprise";


@Component({
    selector: 'agent-master-list',
    templateUrl: 'agent-master-list.component.html',
    styleUrls: ['agent-master-list.component.scss']
})
export class AgentMasterListComponent {
     private lists:IAgentMasterList[];
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
     gridOptions: GridOptions;

     private pages:number;
     private currentPageNumber= 1;
     pageSize:number;
     selected=true;
     Valid=true;
  //   private agentListData:IAgentMasterList[];
     optionSelected:any
        constructor(private agentMasterservice: AgentMasterService, private router:Router,private route: ActivatedRoute,private http: HttpClient){
       this.gridOptions = <GridOptions>{}
    }
     columnDefs = [
         { field: '',width: 60, headerCheckboxSelection: true,
        headerCheckboxSelectionFilteredOnly: true,
        checkboxSelection: true, suppressSorting: true,
                suppressMenu: true},
         {headerName: 'Status', field: 'status',width: 140 },
         {headerName: 'Status', field: 'validation',width: 140 },
         {headerName: 'Agent No', field: 'agentNo',width: 140 },
         {headerName: 'Name', field: 'agentName',width: 140 },
         {headerName: 'Original Payable', field: 'previousNetPayable',width: 140 },
         {headerName: 'Final Payable', field: 'netPayable',width: 140 },
         {headerName: 'Entry Type', field: '',width: 140 },
         {headerName: 'Deviation Entry', field: '',width: 140 },
         {headerName: 'Account Number', field: 'bankACNumber',width: 140 },
         {headerName: 'IFSC', field: 'ifscCode',width: 140 },
         {headerName: 'PAN', field: '',width: 140 },
         {headerName: 'Date Term', field: 'dtTerm',width: 140 },
         {headerName: 'Branch Code', field: 'branchCode',width: 140 },
];



ngOnInit(){
    this.paginationPageSize=10;
   this.gridOptions.rowHeight=30;
    this.gridOptions.headerHeight=40;
            this.getAgentList();
            if(this.currentPageNumber == 1){
                    this.Valid=false;
            }else{
                this.Valid=true;
            }
    }

     onScroll() {
    console.log("scrolled!!");
  }

  getAgentList(){
   
        this.agentMasterservice.getAgentList().subscribe((lists)=>{
            this.lists=lists.data.agentList;
            this.pageSize = ((lists.data.agentListCount/20)+(lists.data.agentListCount % 20 !=0 ? 1 : 0));
            this.pageSize = Math.trunc( this.pageSize );
            this.pages = this.pageSize;
  });
      
  }
 
  
  onPageSizeChanged(newPageSize:any) {
    var value = (<HTMLInputElement>document.getElementById("page-size")).value;
    this.gridOptions.api.paginationSetPageSize(Number(value));
    //this.gridApi.paginationSetPageSize(Number(value));
    this.paginationPageSize = 10;
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
