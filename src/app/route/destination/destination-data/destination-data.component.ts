import { Component } from '@angular/core';
import { DestinationService } from '../../../services/destination.service'
import { Destination } from '../../../model/destination';
import {Router} from '@angular/router';
import {GridOptions} from "ag-grid/main";
import "ag-grid-enterprise";

@Component({
    selector: 'destination-data',
    templateUrl: 'destination-data.component.html',
    styleUrls: ['destination-data.component.scss']
})
export class DestinationDataComponent {
     private destination: Destination[];
     private gridOptions:GridOptions;
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
    isvalid :boolean=true;

     constructor(private destinationService: DestinationService, private router:Router){
        this.gridOptions = <GridOptions>{};
     }
    columnDefs = [
        { field: '',width: 60, headerCheckboxSelection: false, headerCheckboxSelectionFilteredOnly: false,
        checkboxSelection: true, suppressSorting: true, suppressMenu: true},
        {headerName: 'Destination ID', field: 'destID' ,width:250},
        {headerName: 'Destination Name', field: 'destName',width:300},
        {headerName: 'Destination Description', field: 'destDescrp',width:270}
    ];
    ngOnInit(){
        this.paginationPageSize = 10;
        this.gridOptions.rowHeight=30;
        this.gridOptions.headerHeight=40;
        this.destinationService.getDestinationList().subscribe((destination)=>{
            this.destination=destination.data;
            debugger
            console.log(destination)
          },(error)=>{
            console.log(error);
         })
    }
    updateList(destinations:any)
    {
        this.destination = this.gridOptions.api.getSelectedRows();

        this.destinationService.setter(this.destination[0]);
        this.router.navigate(['/editDestination'])
        
      }
      createList(){
        let destination= new Destination();
        this.destinationService.setter(destination);
        this.router.navigate(['/addDestination']);
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

