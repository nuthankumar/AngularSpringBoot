import { Component } from '@angular/core';
import { VendorService } from '../../../services/vendor.service'
import { Vendor } from '../../../model/vendor';
import { Router } from '@angular/router';
import { GridOptions } from "ag-grid/main";
import "ag-grid-enterprise";

@Component({
    selector: 'vendor',
    templateUrl: 'vendor.component.html',
    styleUrls: ['vendor.component.scss']
})
export class VendorComponent {
    private vendor: Vendor[];
    private gridOptions: GridOptions;
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
    isvalid :boolean=true;

    constructor(private vendorService: VendorService, private router: Router) {
        this.gridOptions = <GridOptions>{};
    }
    columnDefs = [
        {
            field: '', width: 60, headerCheckboxSelection: false,
            headerCheckboxSelectionFilteredOnly: true,
            checkboxSelection: true, suppressSorting: true,
            suppressMenu: true
        },
        { headerName: 'Code', field: 'code', width: 270 },
        { headerName: 'Name', field: 'name', width: 300 },
        { headerName: 'Description', field: 'description', width: 270 },
        { headerName: 'Status', field: 'status', valueGetter: 'if(data.status==true){return "Active"}else {return "Inactive"}', width: 250 }


    ];
    ngOnInit() {
        this.paginationPageSize = 10;
        this.gridOptions.rowHeight = 30;
        this.gridOptions.headerHeight = 40;
        this.vendorService.getVendorList().subscribe((vendor) => {
            this.vendor = vendor.data;
            debugger
            console.log(vendor)
        }, (error) => {
            console.log(error);
        })

    }
    createList() {
        let vendor = new Vendor();
        this.vendorService.setter(vendor);
        this.router.navigate(['/addVendor']);
    }
    updateList(vendors: any) {
        debugger
        this.vendor = this.gridOptions.api.getSelectedRows();
        this.vendorService.setter(this.vendor[0]);
        this.router.navigate(['/editVendor'])
    }
    onRowSelected(event:any){
  if(event.node.selected==true){
    this.isvalid=false;
  }else{
    this.isvalid=true;
  }
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
