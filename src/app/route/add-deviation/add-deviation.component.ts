import { Component } from '@angular/core';
import { HttpClientModule, HttpClient } from '@angular/common/http';
import { ContestService } from '../../services/contest.service'
import { IDeviation } from '../../model/deviation';
import {Router,ActivatedRoute, Params} from '@angular/router';
import {GridOptions} from "ag-grid/main";

@Component({
    selector: 'add-deviation',
    templateUrl: 'add-deviation.component.html',
    styleUrls: ['add-deviation.component.scss']
})
export class AddDeviationComponent {
    private lists:IDeviation[];
     private gridOptions:GridOptions;
     selectedData: any;
     deviationApproveList:any;
     data:any;
     rejectedData:any;
     private selectedrow:any;
     constructor(private contestservice: ContestService, private router:Router){
        this.gridOptions = <GridOptions>{};
    }
     columnDefs = [
         { field: '',width: 140, headerCheckboxSelection: true,
        headerCheckboxSelectionFilteredOnly: true,
        checkboxSelection: true, suppressSorting: true,
                suppressMenu: true},,
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
ngOnInit(){
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
}
