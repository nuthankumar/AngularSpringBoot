import { Component } from '@angular/core';
import { HttpClientModule, HttpClient } from '@angular/common/http';
import { MakerService } from '../../services/maker.service'
import { IMakerList } from '../../model/master-contest';
import { Router } from '@angular/router';
import { GridOptions } from "ag-grid/main";

@Component({
    selector: 'maker-contest-list',
    templateUrl: 'maker-contest-list.component.html',
    styleUrls: ['maker-contest-list.component.scss']
})
export class MakerContestListComponent {
    private lists: IMakerList[];
    private ticketlists: IMakerList[];
    private gridOptions: GridOptions;
    private gridOptions1: GridOptions;
    private tabValue: any = 'Cash';
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
    
    selectedValue: any;
    selectedData: any;
    value: any;
    data: any;
    
    constructor(private makerService: MakerService, private router:Router){
        this.gridOptions = <GridOptions>{};
        this.gridOptions1 = <GridOptions>{};
    }
    columnDefs = [
        {headerName: 'Contest List', field: 'contestId',suppressResize: true,width: 200 },
        {headerName: 'Contest Name', field: 'contestName',suppressResize: true,width: 320 },
        {headerName: 'AG Class', field: 'agType',suppressResize: true,width: 200},
        {headerName: 'Agent Count', field: 'countOfAgentNo',suppressResize: true,width: 230},
        {headerName: 'Net Payable', field: 'sumOfNetPayable',suppressResize: true,width: 230}
    ];
    ngOnInit(){
        this.paginationPageSize = 10;
        this.gridOptions.rowHeight=30;
        this.gridOptions1.rowHeight=30;
         this.gridOptions1.headerHeight=40;
        this.gridOptions.headerHeight=40;
        this.makerService.getMakerContestList().subscribe((lists) => {
            this.lists=lists.data.maketContestList;
            console.log(lists)
          },(error)=>{
            console.log(error);
         })
         this.makerService.getMakerContestTicket().subscribe((ticketlists) => {
            this.ticketlists=ticketlists.data.makerContestTicketsList;
            console.log(ticketlists)
          },(error)=>{
            console.log(error);
         })
         
    }

    tabClicked(value: any) {
        this.tabValue = value;
    }

    onRowClicked(e: any) {
        let data=e.data;
        let contestId=data.contestId;
        let selectedTab =  this.tabValue
        this.router.navigate(['/makerContestListDetails', contestId]); 
    }
    rejectBtn(){
        this.value=this.selectedValue;
        console.log(this.value);
        this.selectedData = {};
        let selectedRowData =[];
        selectedRowData.push({
            "contestId": this.value, 
            "agentNo": null,
            "remarks": null
        });
        this.selectedData["selectedRowData"] = selectedRowData;
        this.data=selectedRowData;
        this.makerService.updateToRejectMaker(this.data).subscribe((response) => {
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
        this.makerService.updateToRejectMakerTicket(this.data).subscribe((response) => {
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
