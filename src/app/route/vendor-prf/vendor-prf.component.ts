import { Component } from '@angular/core';
import { VendorPRFService } from '../../services/vendorPRF.service';
import { Router } from '@angular/router';
import { GridOptions } from "ag-grid/main";

@Component({
    selector: 'vendor-prf',
    templateUrl: 'vendor-prf.component.html',
    styleUrls: ['vendor-prf.component.scss']
})
export class VendorPrfComponent {
    private vendor: any;
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

    constructor(private vendorPRFService: VendorPRFService, private router: Router) {
        this.gridOptions = <GridOptions>{};
    }
    columnDefs = [
        {
            field: '', width: 60, headerCheckboxSelection: true,
            headerCheckboxSelectionFilteredOnly: true,
            checkboxSelection: true, suppressSorting: true,
            suppressMenu: true
        },
        { headerName: 'Cost Center', field: 'name', },
        { headerName: 'Channel Type', field: 'channelType' },
        { headerName: 'Vendor Name', field: 'vendorName' },
        { headerName: 'Gross Amount', field: 'amount' },
        { headerName: 'Tax', field: 'tax' },
        { headerName: 'Net Amount', field: 'netPayable' },
        { headerName: 'Amount in words', field: 'amountInWords' },
        { headerName: 'Mode of Payment', field: 'modeOfPayment' },
        { headerName: 'Date', field: 'date' }


    ];
    ngOnInit() {
        this.paginationPageSize = 10;
        this.gridOptions.rowHeight = 30;
        this.gridOptions.headerHeight = 40;
        this.vendorPRFService.getVendorTranscationList().subscribe((vendor) => {
            this.vendor = vendor.data;
            for (let i = 0; i < this.vendor.length; i++) {
                var Cname = this.vendor[i].costCenter.name;
                this.vendor[i].name = Cname;
            }

            debugger
            console.log(vendor)
        }, (error) => {
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
