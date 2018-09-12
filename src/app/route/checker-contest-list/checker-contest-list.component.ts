import { Component } from '@angular/core';
import { HttpClientModule, HttpClient } from '@angular/common/http';
import { CheckerService } from '../../services/checker.service'
import { ICheckerList } from '../../model/master-contest';
import {Router} from '@angular/router';
import { GridOptions } from "ag-grid/main";



@Component({
    selector: 'checker-contest-list',
    templateUrl: 'checker-contest-list.component.html',
    styleUrls: ['checker-contest-list.component.scss']
})
export class CheckerContestListComponent {
     private lists:ICheckerList[];
     private checkerTicket:any;
          private gridOptions:GridOptions;
          private gridOptions1:GridOptions;
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

          selectedValue: any=null;
    selectedData: any;
    value: any;
    data: any;

        constructor(private checkerService: CheckerService, private router:Router){
        this.gridOptions = <GridOptions>{};
        this.gridOptions1 = <GridOptions>{};

    }
     columnDefs = [
         {headerName: 'Contest List', field: 'contestId',width:180 },
        {headerName: 'Contest Name', field: 'contestName' ,width:260},
        {headerName: 'AG Class', field: 'agType',width:180},
        {headerName: 'Agent Count', field: 'countOfAgentNo',width:180},
        {headerName: 'Net Payable', field: 'sumOfNetPayable',width:180},
        {headerName: 'Previous Net Payable', field: 'sumOfPreviousPaid',width:200}


    ];
    ngOnInit(){
        this.paginationPageSize = 10;
          this.gridOptions.rowHeight=30;
          this.gridOptions1.rowHeight=30;
         this.gridOptions1.headerHeight=40;
    this.gridOptions.headerHeight=40;
        this.checkerService.getcheckerContestList().subscribe((lists)=>{
            this.lists=lists.data.checkerContestList;
            debugger
            console.log(lists)
          },(error)=>{
            console.log(error);
         })
          this.checkerService.getcheckerContestTicket().subscribe((checkerTicket)=>{
            this.checkerTicket=checkerTicket.data.checkerContestTicketsList;
            debugger
            console.log(checkerTicket)
          },(error)=>{
            console.log(error);
         })
    }
    onRowClicked(e:any){
        let data=e.data;
        let contestId=data.contestId;
       this.router.navigate(['/checkerContestListDetails', contestId ]); 
    }
    rejectBtn(){
        this.value=this.selectedValue;
        console.log(this.value);
        this.selectedData = {};
        let selectedRowData =[];
        selectedRowData.push({
            "contestId": this.value,
            "remarks": null
        });
        this.selectedData["selectedRowData"] = selectedRowData;
        this.data=selectedRowData;
        this.checkerService.rejectTransactionCashChecker(this.data).subscribe((response) => {
        console.log("df",this.data);
        },(error)=>{
        this.router.navigate(['/login'])
        });
    }
    rejectBtnTicket(){
        this.value=this.selectedValue;
        console.log(this.value);
        this.selectedData = {};
        let selectedRowData =[];
        selectedRowData.push({
            "contestId": this.value, 
            "remarks": null
        });
        this.selectedData["selectedRowData"] = selectedRowData;
        this.data=selectedRowData;
        this.checkerService.rejectransactionTicketChecker(this.data).subscribe((response) => {
        console.log("df",this.data);
        },(error)=>{
        this.router.navigate(['/login'])
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
