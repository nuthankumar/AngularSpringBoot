import { Component } from '@angular/core';
import { HttpClientModule, HttpClient } from '@angular/common/http';
import { ContestService } from '../../services/contest.service'
import { IPRFList } from '../../model/prf-list';
import { Router, ActivatedRoute, Params } from '@angular/router';
import { IMultiSelectOption } from 'angular-2-dropdown-multiselect';
import { GridOptions } from "ag-grid/main";
@Component({
    selector: 'prf-list',
    templateUrl: 'prf-list.component.html',
    styleUrls: ['prf-list.component.scss']
})
export class PrfListComponent {
    private gridOptions: GridOptions;
    private gridOptions1: GridOptions;
    private rowSelection: any;
    private lists: IPRFList[];
    private list: IPRFList[];
    private agentType: IPRFList[];
    private selectedItemss: any;
    private selectedItemssTicket: any;
    pageSize: number;
    private fnPaySt: any;
    private fnPayEn: any;
    private selectedValueReason: any = 'positive';
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

    prfCommentData: any;
    selectedDataA: any
    requestData = {};
    selectedData: any;
    dropdownSettings = {};
    data: any;
    agentTypes: any;
    agentTypeTicket: any;
    Ticketlists: any
    constructor(private contestservice: ContestService, private router: Router) {
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
        { headerName: 'Agent No', field: 'agentNo' },
        { headerName: 'Agent Name', field: 'agentName' },
        { headerName: 'Tran Date', field: 'tranDate' },
        { headerName: 'Net Amount', field: 'netAmount' },
        { headerName: 'Rec Amount', field: 'recoverbleAmount' },
        { headerName: 'Dev Amount', field: 'deviationAmt' },
        { headerName: 'AdvancePayout', field: 'advancePayout' },
        { headerName: 'Adva Recoverable', field: 'advanceRecoverable' },
        { headerName: 'Max Rec Amount', field: 'maxRecoverableAmt' },
        { headerName: 'Final Payable', field: 'netPayout' },
        { headerName: 'Comments', field: 'prfComment', editable: true, valueSetter: this.nameValueGetter, valueGetter: "" }
    ];

    onItemSelect(list: any) {
        console.log('this.selectedItemss', this.selectedItemss)
        this.agentTypes = this.selectedItemss;
        this.agentTypeTicket = this.selectedItemssTicket;
        let selectedRowData = [];
        if(this.agentTypes.length) {
            this.contestservice.getPRFList(this.agentTypes).subscribe((records) => {
                // this.selectedData = {};
                records.data.forEach(element => {
                    console.log('element', element)
                    // this.selectedData.selectedRowData = selectedRowData;
                    if(this.selectedValueReason === 'positive') {
                        if(element.prfListCashKey.netPayout >= 0) {
                            selectedRowData.push(element.prfListCashKey);
                        }
                    }
                    if(this.selectedValueReason === 'negative') {
                        if(element.prfListCashKey.netPayout < 0) {
                            selectedRowData.push(element.prfListCashKey);
                        }
                    }
                    if(this.selectedValueReason === 'all') {
                        selectedRowData.push(element.prfListCashKey);
                    }
                });
                this.lists = selectedRowData;    
            }, (error) => {
                console.log(error);
            })
        } else {
            this.lists = selectedRowData;
        }

        if(this.agentTypeTicket.length) {
            this.contestservice.getPRFListTicket(this.agentTypeTicket).subscribe((Ticketlists) => {
                this.Ticketlists = Ticketlists.data;
                console.log(this.Ticketlists);
            }, (error) => {
                console.log(error);
            })
        } else {
            this.Ticketlists = selectedRowData;
        }
    }

    ngOnInit() {
        this.paginationPageSize = 10;
        this.gridOptions.rowHeight = 30;
        this.gridOptions.headerHeight = 40;
        this.gridOptions1.rowHeight = 30;
        this.gridOptions1.headerHeight = 40;
        this.dropdownSettings = {
            singleSelection: false,
            selectAllText: 'Select All',
            unSelectAllText: 'UnSelect All',
        };
        this.lists = [];
        this.Ticketlists = [];
        this.contestservice.getagentTypes().subscribe((agentType) => {
            this.agentType = agentType.data;
            debugger
        }, (error) => {
            console.log(error);
        })
    }

    filterFinalPayable() {
        let fnPaySt = this.fnPaySt;
        let fnPayEn = this.fnPayEn;
        if((this.fnPaySt === undefined || this.fnPaySt === null) && (this.fnPayEn === undefined || this.fnPayEn === null)) {
            this.gridOptions.api.selectAll()
        } else {
            this.gridOptions.api.forEachNode( function(rowNode: any) {
                if((rowNode.data.netPayout >= fnPaySt) && (rowNode.data.netPayout <= fnPayEn)) {
                    rowNode.setSelected(false);
                } else {
                    rowNode.setSelected(true);
                }
            });
        }
    }
    onRowSelected(event:any){
    //     console.log('event', event)
    //     //         event.node.setSelected(false);
    //     if(!(this.fnPaySt === undefined || this.fnPaySt === null) && !(this.fnPayEn === undefined || this.fnPayEn === null)) {
    //         if((event.data.netPayout >= this.fnPaySt) && (event.data.netPayout <= this.fnPayEn)) {
    //             event.node.setSelected(false);
    //         } else {
    //             event.node.setSelected(true);
    //         }
    //     }
    }
    onModelUpdated(event:any) {
        event.api.selectAll()
    }

    generatePrf() {
        this.prfCommentData = this.gridOptions.api.getSelectedRows();
        this.selectedDataA = {};
        let selectedRowData = [];
        for (var i = 0; i < this.prfCommentData.length; i++) {
            selectedRowData.push({
                "agentNo": this.prfCommentData[i].agentNo,
                "prfComment": this.prfCommentData[i].prfComment,
                "agId": this.prfCommentData[i].agType,
                "transAutoId": this.prfCommentData[i].transAutoId
            });
            this.selectedDataA["selectedRowData"] = selectedRowData;
            this.data = selectedRowData;

        }
        this.agentTypes = this.selectedItemss;
        this.requestData["agentTypes"] = "" + this.selectedItemss;
        this.requestData["selectedRecords"] = this.data;

        console.log("Request generate==>" + JSON.stringify(this.requestData));
        this.contestservice.updategeneratePrf(this.requestData).subscribe((response) => {
            var selectedNodes = this.gridOptions.api.getSelectedNodes();
            this.gridOptions.api.removeItems(selectedNodes);
            console.log(this.requestData);
        }, (error) => {
            console.log(error);
        })
    }

    nameValueGetter(params: any) {
        params.data['prfComment'] = params.newValue;
        return true;
    }

    generatePrfTicket() {
        this.prfCommentData = this.gridOptions1.api.getSelectedRows();
        this.selectedDataA = {};
        let selectedRowData = [];
        for (var i = 0; i < this.prfCommentData.length; i++) {
            selectedRowData.push({
                "agentNo": this.prfCommentData[i].agentNo,
                "prfComment": this.prfCommentData[i].prfComment,
                // "agId":this.prfCommentData[i].agType,
                // "transAutoId":this.prfCommentData[i].transAutoId
            });
            this.selectedDataA["selectedRowData"] = selectedRowData;
            this.data = selectedRowData;

        }
        this.agentTypeTicket = this.selectedItemssTicket;
        this.requestData["agentTypes"] = "" + this.selectedItemssTicket;
        this.requestData["selectedRecords"] = this.data;
        console.log("Request generate==>" + JSON.stringify(this.requestData));
        this.contestservice.updategeneratePrfTicket(this.requestData).subscribe((response) => {
            console.log(this.requestData);
            var selectedNodes = this.gridOptions1.api.getSelectedNodes();
            this.gridOptions1.api.removeItems(selectedNodes);
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
