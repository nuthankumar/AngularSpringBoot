import { Component } from '@angular/core';
import { ContestService } from '../../../services/contest.service';
import {GridOptions} from "ag-grid/main";
import {Router} from '@angular/router';

@Component({
    selector: 'get-view-data',
    templateUrl: 'get-view-data.component.html',
    styleUrls: ['get-view-data.component.scss']
})
export class GetViewDataComponent {
   private lists:any;
     private gridOptions:GridOptions;
    constructor(private contestservice: ContestService, private router:Router){
        this.gridOptions = <GridOptions>{};

    }

       ngOnInit(){
        this.contestservice.getViewData().subscribe((lists)=>{
            this.lists=lists;
            console.log(this.lists);
            alert("Get View Data Successful");
          },(error)=>{
            console.log(error);
            alert("Get View Data Unsuccessful");
         })
         
    
    }
}
