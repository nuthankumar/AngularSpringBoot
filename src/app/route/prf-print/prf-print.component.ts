import { Component,Inject } from '@angular/core';
import { ContestService } from '../../services/contest.service'
import { IPRFList } from '../../model/prf-list';
import {Router,ActivatedRoute, Params} from '@angular/router';
import { IMultiSelectOption } from 'angular-2-dropdown-multiselect';
import {GridOptions} from "ag-grid/main";
import {DOCUMENT } from '@angular/common';
@Component({
    selector: 'prf-print',
    templateUrl: 'prf-print.component.html',
    styleUrls: ['prf-print.component.scss']
})
export class PrfPrintComponent {
    
     private gridOptions:GridOptions;
     private gridOptions1:GridOptions;
     pageSize: number;
    private pages: number;
    private gridApi: any;
    private gridColumnApi: any;
    private rowData: any[];
    private autoGroupColumnDef: any;
    private rowGroupPanelShow: any;
    private pivotPanelShow: any;
    private paginationPageSize: any;
    private paginationNumberFormatter: any;
    private defaultColDef: any;
 selectedDate:any;
     prfGENDate:any;
     lists:any
     date:any
     month:any
     year:any
     today:any
     rowSelection:any;
     selectedData: Object = {};
     selectedNo: Object = {};
     startDate:any;
     endDate:any;
     displayPRFNo:boolean;
     displayDate:boolean; 
     prfDetail:any;
     prfno:any
     listsPRF:any;
     Ticketlists:any;
     prfDetailTicket:any;
     prfPrintData:any;
     selectedDataA:any;
     constructor(private contestservice: ContestService, private router:Router,@Inject(DOCUMENT) private document: any){
        this.gridOptions = <GridOptions>{};
        this.gridOptions1 = <GridOptions>{};
        this.rowSelection = "multiple";
    }
     columnDefs = [
        { field: '',width: 60, headerCheckboxSelection: true,
        headerCheckboxSelectionFilteredOnly: true,
        checkboxSelection: true, suppressSorting: true,
                suppressMenu: true},
        {headerName: 'PRF No', field: 'prfNo'},
        {headerName: 'GEN. Date', field: 'prfGENDate'},
        {headerName: 'Net Payable', field: 'sumOfNetPayout'},
        {headerName: 'Remarks', field: 'remarks'},



    ];
     ngOnInit(){
        this.paginationPageSize = 10;
         this.displayPRFNo= false;
     this.displayDate = false; 
            this.today = new Date();
this.date = this.today.getDate();
this.month = this.today.getMonth()+1; //January is 0!
this.year = this.today.getFullYear();

if(this.date<10) {
    this.date = '0'+this.date
} 

if(this.month <10) {
    this.month  = '0'+this.month 
} 

this.today = this.year + '/' + this.month + '/' + this.date;
         this.prfGENDate=this.today;
         this.contestservice.getPRFPrintGenDate(this.prfGENDate).subscribe((lists)=>{
            this.lists=lists.data;
            console.log(lists);
            debugger
          },(error)=>{
            console.log(error);
        })
         this.contestservice.getPRFDetail().subscribe((prfDetail)=>{
            this.prfDetail=prfDetail.data;
            console.log("no",prfDetail);
            debugger
          },(error)=>{
            console.log(error);
        })
        this.contestservice.getPRFPrintTicketGenDate(this.prfGENDate).subscribe((Ticketlists)=>{
            this.Ticketlists=Ticketlists.data;
            console.log("today",Ticketlists);
            debugger
          },(error)=>{
            console.log(error);
        })
        this.contestservice.getPRFDetailTicket().subscribe((prfDetailTicket)=>{
            this.prfDetailTicket=prfDetailTicket.data;
            console.log("data",prfDetailTicket);
            debugger
          },(error)=>{
            console.log(error);
        })
        
        
        
     }

     getPRFDate(){
         this.startDate;
        this.startDate =  this.startDate.replace(/-/g, "/");
         this.endDate;
         this.endDate =  this.endDate.replace(/-/g, "/");
         console.log("date"+this.endDate);
         this.contestservice.getPRFPrintByDate(this.startDate,this.endDate).subscribe((lists)=>{
            this.lists=lists.data;
            console.log(lists);
            debugger
          },(error)=>{
            console.log(error);
            })
     }
     getPRFDateTicket(){
          this.startDate;
        this.startDate =  this.startDate.replace(/-/g, "/");
         this.endDate;
         this.endDate =  this.endDate.replace(/-/g, "/");
         console.log("date"+this.endDate);
         this.contestservice.getPRFPrintByDateTicket(this.startDate,this.endDate).subscribe((Ticketlists)=>{
            this.Ticketlists=Ticketlists.data;
            console.log(Ticketlists);
            debugger
          },(error)=>{
            console.log(error);
            })
     }
     getPRFByNo(){
         this.selectedNo=this.selectedNo;
         console.log("sdfs",this.selectedNo);
         this.contestservice.getPRFByNo(this.selectedNo).subscribe((lists)=>{
            this.lists=lists.data;
            console.log(lists);
            debugger
          },(error)=>{
            console.log(error);
            })

     }
     getPRFByNoTicket(){
         this.selectedNo=this.selectedNo;
         console.log("sdfs",this.selectedNo);
         this.contestservice.getPRFByNoTicket(this.selectedNo).subscribe((Ticketlists)=>{
            this.Ticketlists=Ticketlists.data;
            console.log(Ticketlists);
            debugger
          },(error)=>{
            console.log(error);
            })

     }
     
     selectedPRF(selectedDate:any){
         debugger;
         console.log("fdg",selectedDate);
         if(selectedDate === 'prfNo'){
           this.displayPRFNo= true;
         this.displayDate = false; 
         console.log("PRFNO",this.displayPRFNo);
         }
        else if(selectedDate === 'date'){
            this.displayPRFNo= false;
             this.displayDate = true;
             console.log("date",this.displayDate);
            } 
             else{
                 this.displayPRFNo= false;
             this.displayDate = false;
             } 

     }
     downloadPRF():void{
          this.prfPrintData = this.gridOptions.api.getSelectedRows();
          console.log("gen",this.prfPrintData);
          console.log("genda",this.prfPrintData[0].prfNoGenREF);
       var prfNo=this.prfPrintData[0].prfNoGenREF;
         this.document.location.href="http://nibc2274/ReportServer/Pages/ReportViewer.aspx?%2fSFCRM%2fReports%2fPRF_Print&rs:Format=PDF&PRFNoGenREF="+prfNo;
         this.contestservice.getPRDownload().subscribe((res)=>{
            var resp = window.URL.createObjectURL(res)
            debugger
          },(error)=>{
            console.log(error);
            })
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
