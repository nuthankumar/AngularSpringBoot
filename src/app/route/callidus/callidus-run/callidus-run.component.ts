import { Component } from '@angular/core';
import { ContestService } from '../../../services/contest.service';
import {GridOptions} from "ag-grid/main";
import {Router} from '@angular/router';

@Component({
    selector: 'callidus-run',
    templateUrl: 'callidus-run.component.html',
    styleUrls: ['callidus-run.component.scss']
})
export class CallidusRunComponent {
    private lists:any;
     private gridOptions:GridOptions;
    constructor(private contestservice: ContestService, private router:Router){
        this.gridOptions = <GridOptions>{};

    }

       ngOnInit(){
        this.contestservice.getCallidus().subscribe((lists)=>{
            this.lists=lists;
            console.log(this.lists);
            alert("Callidus Run Successfully");
          },(error)=>{
            console.log(error);
            alert("Callidus Run Unsuccessfully");
         })
         
    
    }
}
