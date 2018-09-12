import { Component } from '@angular/core';
import { ApproverOneService } from '../../services/approver-one.service'
import { IApproverOneContestView } from '../../model/approver-one';
import { IApproverOneKey } from '../../model/approver-one';
import { Router } from '@angular/router';
import { GridOptions } from "ag-grid/main";
import * as moment from 'moment';

@Component({
    selector: 'approver-one-contest-view',
    templateUrl: 'approver-one-contest-view.component.html',
    styleUrls: ['approver-one-contest-view.component.scss']
})
export class ApproverOneContestViewComponent {
    private lists: any;
    private Ticketlists: any;
    private gridOptions: GridOptions;
    private gridOptions1: GridOptions;
    private selectedrow: any;
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

    selectedData: any;
    selectedValue: any;
    data: any;
    private isRowSelectable: any;
    
    value: any;

    constructor(private approverOneService: ApproverOneService, private router: Router) {
        this.gridOptions = <GridOptions>{};
        this.gridOptions1 = <GridOptions>{};
        this.rowSelection = "multiple";


    }
    columnDefs = [
        {
            field: '', width: 60, headerCheckboxSelection: true,
            headerCheckboxSelectionFilteredOnly: true,
            checkboxSelection: true, suppressSorting: true,
            suppressMenu: true
        },
        { headerName: 'PRF NO', field: 'prfNo' },
        { headerName: 'PRF GEN Date', field: 'prfGenDate'},
        { headerName: 'Net Payable', field: 'prfAmount' },
        { headerName: 'Status', field: 'status' },
        { headerName: 'Remarks', field: 'remarks', editable: true, valueSetter: this.nameValueGetter },



    ];
    ngOnInit() {
        this.paginationPageSize = 10;
        this.gridOptions.rowHeight = 30;
        this.gridOptions.headerHeight = 40;
        this.gridOptions1.rowHeight = 30;
        this.gridOptions1.headerHeight = 40;
        this.approverOneService.getapproverOneContestList().subscribe((lists) => {
            console.log(lists);
            this.lists = lists.data.approverOneContestViewList;
            for (let i = 0; i < this.lists.length; i++) {
                var test = this.lists[i].approverOneKey.prfNo;
                var date = this.lists[i].approverOneKey.makerTimeActual;
                this.lists[i].prfNo = test;
                this.lists[i].makerTimeActual = date;
            }
            console.log(this.lists)
        }, (error) => {
            console.log(error);
        })
        this.approverOneService.getapproverOneContestTicket().subscribe((Ticketlists) => {
            console.log(Ticketlists);
            this.Ticketlists = Ticketlists.data.approverOneTicketViewList;
            for (let i = 0; i < this.Ticketlists.length; i++) {
                var test = this.Ticketlists[i].approverOneKey.prfNo;
                var date = this.Ticketlists[i].approverOneKey.makerTimeActual;
                this.Ticketlists[i].prfNo = test;
                this.Ticketlists[i].makerTimeActual = date;
            }
            console.log(this.Ticketlists)
        }, (error) => {
            console.log(error);
        })


        this.isRowSelectable = function (rowNode: any) {
            return rowNode.data.validation == 'PASS' ? rowNode.data : rowNode.disabled;
        };

    }
    nameValueGetter(params: any) {
        params.data['remarks'] = params.newValue;

        return true;
    }
    selectAllCheckbox() {
        this.gridOptions.api.selectAll();
        this.selectedrow = this.gridOptions.api.getSelectedRows();
        console.log(this.selectedrow);
    }
    sendToApproverTwo() {
        this.selectedrow = this.gridOptions.api.getSelectedRows();
        this.selectedrow = this.selectedrow;
        this.selectedData = {};
        let selectedRowData = [];
        for (var i = 0; i < this.selectedrow.length; i++) {
            selectedRowData.push({
                "prfNoGenREF": this.selectedrow[i].prfGenRef,
                "remarks": this.selectedrow[i].remarks,
                "prfNo": this.selectedrow[i].prfNo,
            });
            this.selectedData["selectedRowData"] = selectedRowData;
            this.data = selectedRowData;
        }
        this.approverOneService.updateToApproverTwo(this.data).subscribe((response) => {
            console.log(this.data);
            var selectedNodes = this.gridOptions.api.getSelectedNodes();
            this.gridOptions.api.removeItems(selectedNodes);
        }, (error) => {
            console.log(error);
        });

    }
    sendToApproverTwoTicket() {
        this.selectedrow = this.gridOptions1.api.getSelectedRows();
        this.selectedrow = this.selectedrow;
        this.selectedData = {};
        let selectedRowData = [];
        for (var i = 0; i < this.selectedrow.length; i++) {
            selectedRowData.push({
                "prfNoGenREF": this.selectedrow[i].prfGenRef,
                "remarks": this.selectedrow[i].remarks,
            });
            this.selectedData["selectedRowData"] = selectedRowData;
            this.data = selectedRowData;
        }
        this.approverOneService.updateToApproverTwoTicket(this.data).subscribe((response) => {
            console.log(this.data);
            var selectedNodes = this.gridOptions1.api.getSelectedNodes();
            this.gridOptions1.api.removeItems(selectedNodes);
        }, (error) => {
            console.log(error);
        });

    }
    rejectBtn() {
        this.selectedrow = this.gridOptions.api.getSelectedRows();
        this.selectedrow = this.selectedrow;
        this.selectedData = {};
        let selectedRowData = [];
        for (var i = 0; i < this.selectedrow.length; i++) {
            selectedRowData.push({
                "prfNoGenREF": this.selectedrow[i].prfGenRef,
                "remarks": this.selectedrow[i].remarks,
                "prfNo": this.selectedrow[i].prfNo,
            });
            this.selectedData["selectedRowData"] = selectedRowData;
            this.data = selectedRowData;
            this.approverOneService.rejectApproverOneTransactionCash(this.data).subscribe((response) => {
                console.log("df", this.data);
            }, (error) => {
                this.router.navigate(['/login'])
            });
        }
    }
    rejectBtnTicket() {
        this.selectedrow = this.gridOptions1.api.getSelectedRows();
        this.selectedrow = this.selectedrow;
        this.selectedData = {};
        let selectedRowData = [];
        for (var i = 0; i < this.selectedrow.length; i++) {
            selectedRowData.push({
                "prfNoGenREF": this.selectedrow[i].prfGenRef,
                "remarks": this.selectedrow[i].remarks
            });
            this.selectedData["selectedRowData"] = selectedRowData;
            this.data = selectedRowData;
            this.approverOneService.rejectApproverOneTransactionTicket(this.data).subscribe((response) => {
                console.log("df", this.data);
            }, (error) => {
                this.router.navigate(['/login'])
            });

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
