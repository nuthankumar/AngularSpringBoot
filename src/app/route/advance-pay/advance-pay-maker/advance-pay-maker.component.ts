import { Component } from '@angular/core';
import { AdvancePayService } from '../../../services/advance-pay.service'
import { AdvancePay } from '../../../model/advance-pay';
import {Router} from '@angular/router';
import {GridOptions} from "ag-grid/main";
@Component({
    selector: 'advance-pay-maker',
    templateUrl: 'advance-pay-maker.component.html',
    styleUrls: ['advance-pay-maker.component.scss']
})
export class AdvancePayMakerComponent {
    private advancePay:AdvancePay[];
          private gridOptions:GridOptions;
          advancePayListData:any;
          data:any;
          selectedData:any;
           private selectedrow:any;
          constructor(private advancePayService: AdvancePayService, private router:Router){
        this.gridOptions = <GridOptions>{};

    }
    columnDefs = [
        { field: '',width: 60, headerCheckboxSelection: true,
        headerCheckboxSelectionFilteredOnly: true,
        checkboxSelection: true, suppressSorting: true,
                suppressMenu: true},
         {headerName: 'Agent No', field: 'agentNo' },
        {headerName: 'Advance Date', field: 'advDate' },
        {headerName: 'Effective Date', field: 'effectiveStartDateForRecovery'},
        {headerName: 'Amount', field: 'amount'},
        {headerName: 'Recoverable', field: 'recoverable',valueGetter: 'if(data.recoverable==1){return "Yes"}else {return "No"}',},
        
        {headerName: 'Recoverable per cycle', field: 'maxRecoverblePerCycle'},
        {headerName: 'Net Recovered', field: 'netBalance'},
        {headerName: 'Comments', field: 'remarks'}
        ];
ngOnInit(){
          this.gridOptions.rowHeight=30;
    this.gridOptions.headerHeight=40;
        this.advancePayService.getAdvancePayList().subscribe((advancePay)=>{
             this.advancePay = advancePay.data.advancePayList;
             console.log(this.advancePay)
            this.advancePayListData  = [];
               this.advancePay.forEach((ele: any) => {
                   ele.advancePayCashKey.remarks = ele.remarks
                   this.advancePayListData.push(ele.advancePayCashKey);
                 })
          },(error)=>{
            console.log(error);
         })
         
    }
    advancePayApprove(){
        this.selectedrow= this.gridOptions.api.getSelectedRows();
    this.selectedData = {};
    let selectedRowData =[];
    for(var i = 0 ; i < this.selectedrow.length ; i++){ 
    selectedRowData.push({
            "agentNo" :this.selectedrow[i].agentNo,
            "advDate":this.selectedrow[i].advDate
        });
    this.selectedData["selectedRowData"] = selectedRowData;
    this.data=selectedRowData;
}
        this.advancePayService.updateToAdvancePay(this.data).subscribe((response)=>{
       console.log(this.data);
        var selectedNodes = this.gridOptions.api.getSelectedNodes();
            this.gridOptions.api.removeItems(selectedNodes);
        },(error)=>{
          console.log(error);
        });
      
    

    }
}

