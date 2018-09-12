import { Component } from '@angular/core';
import { ContestService } from '../../services/contest.service'
import { IPRFList } from '../../model/prf-list';
import {Router,ActivatedRoute, Params} from '@angular/router';
import { IMultiSelectOption } from 'angular-2-dropdown-multiselect';
import {GridOptions} from "ag-grid/main";

@Component({
    selector: 'utr',
    templateUrl: 'utr.component.html',
    styleUrls: ['utr.component.scss']
})
export class UtrComponent {
     private gridOptions:GridOptions;
     private gridOptions1:GridOptions;
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
     data:any;
     selectedDataA:any;
     constructor(private contestservice: ContestService, private router:Router){
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
        {headerName: 'Agent Number', field: 'agentNo'},
        {headerName: 'Agent Name', field: 'agentName'},
        
        {headerName: 'Net Payout', field: 'sumOfNetPayout'},
         {headerName: 'UTR number', field: 'utrNo',editable:true, valueSetter: this.nameValueGetter , valueGetter: ""},
          {headerName: 'Transfer Date', field: 'transferDate',editable:true, valueSetter: this.nameValueGetterDate , valueGetter: ""}



    ];
     ngOnInit(){
        this.lists=[];
         this.contestservice.getPRFDetail().subscribe((prfDetail)=>{
            this.prfDetail=prfDetail.data;
            console.log("no",prfDetail);
            debugger
          },(error)=>{
            console.log(error);
        })
        
        
        
     }
      public uploadUTR(event: any) : void {
        var file = event.target.files[0];
        let fileName = file.name;
        let payload = {
  file,
}
let formData: FormData = new FormData();
formData.append('file',file);
        console.log(file);
   
   this.contestservice.uploadUtrNo(formData).subscribe((res)=>{
            console.log(formData);
            alert("Uploaded successfully");
            debugger
          },(error)=>{
            alert("Error while uploading");
        })
     
    }
    downloadExcel(){
 this.contestservice.downloadUtrExcel().subscribe((res)=>{
            console.log(res);
            alert("downloaded successfully");
          },(error)=>{
            console.log(error);
            alert("Error while downloading");
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
     nameValueGetter(params:any) {
        
              params.data['utrNo'] = params.newValue;
              
              return true;
     }
     nameValueGetterDate(params:any) {
              params.data['transferDate'] = params.newValue;
              
              return true;
     }
     Update(){
           this.data = this.gridOptions.api.getSelectedRows();
        this.selectedDataA = {};
    let selectedRowData =[];
    for(var i = 0 ; i < this.data.length ; i++){ 
    selectedRowData.push({  
            "agentNo":  this.data[i].agentNo,     
            "prfNoGenREF" :this.data[i].prfNoGenREF,
            'utrNo':this.data[i].utrNo,
            'transferDate':this.data[i].transferDate
        });
    this.selectedDataA["selectedRowData"] = selectedRowData;
    this.data=selectedRowData;
    
}
           this.contestservice.updateutr(this.data).subscribe((response)=>{
               console.log(this.data);
          },(error)=>{
            console.log(error);
         })
     }
     

}
