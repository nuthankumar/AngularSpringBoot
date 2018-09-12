import { Component } from '@angular/core';
import { HttpClientModule, HttpClient } from '@angular/common/http';
import { ContestService } from '../../../services/contest.service'
import { ContestMasterList } from '../../../model/contest-list';
import { IDeviation } from '../../../model/deviation';
import { Router, ActivatedRoute, Params } from '@angular/router';
import { GridOptions } from "ag-grid/main";
import { ReasonsService } from '../../../services/reasons.service'
import { Reasons } from '../../../model/reasons';
import { AgentMasterService } from '../../../services/agent-master.service';
import { FormGroup, FormBuilder, FormControl, Validators } from '@angular/forms';

@Component({
  selector: 'add-deviation',
  templateUrl: 'add-deviation.component.html',
  styleUrls: ['add-deviation.component.scss']
})
export class AddDeviationComponent {
  private lists: any;
  // private data:IDeviation[];
  loadDate: any;


  netPayable: any;
  remarks: any;
  confAttchment: any = null;
  private selectedValue: Object = {};
  private gridOptions: GridOptions;
  someName: any;
  reasons: any;
  aglists:any;
  register: FormGroup;
  result: any = null;
  isSubmitted: boolean = false;
  selectedAgent:Object={};

  constructor(private contestservice: ContestService, private router: Router, private reasonsService: ReasonsService, private frmBuilder: FormBuilder
  ,private agentMasterService: AgentMasterService) {
    this.gridOptions = <GridOptions>{};
    this.lists = [];
  }
  ngOnInit() {
    // this.register = this.frmBuilder.group({
    //   'formagentNo': new FormControl('', Validators.compose([Validators.required])),
    //   'formNetValue': new FormControl('', Validators.compose([Validators.required]))
    // });


    this.gridOptions.rowHeight = 40;
    this.gridOptions.headerHeight = 40;
    this.agentMasterService.AgentList().subscribe((aglists)=>{
      console.log(aglists);
      this.aglists=aglists.data;
      for(let i=0;i<this.aglists.length;i++){
          var number= this.aglists[i].agentListKey.agentNo;
          this.aglists[i].agentNo=number;
      }
     
     
});

    this.contestservice.allContestsDrp().subscribe((lists) => {
      debugger;
      this.lists = lists.data;
      console.log("lists",this.lists)
    }, (error) => {
      console.log(error);
    })
    this.reasonsService.getReasonsList().subscribe((reasons) => {
      this.reasons = reasons.data;
      console.log(reasons)
    }, (error) => {
      console.log(error);
    })

  }
  // get formagentNo() { return this.register.get('formagentNo'); }
  // get formNetValue() { return this.register.get('formNetValue'); }

  form() {
    console.log(data);
    debugger;
    console.log()
    var getDate = this.loadDate;
    var newStr = getDate.replace(/-/g, "");
    var data = [{
      'loadDate': newStr,
      'formNetValue': this.netPayable,
      'agentNo': this.selectedAgent["agentNo"],
      'netAmount': this.netPayable,
      'remarks': this.remarks,
      'contestId': this.selectedValue["contestId"],
      'startDate': this.selectedValue["startDate"],
      'endDate': this.selectedValue["endDate"],
      'contestName': this.selectedValue["contestName"],
      'attachment': this.confAttchment

    }]
    this.contestservice.updateDeviationCash(data).subscribe((data) => {
      console.log(data);

    }, (error) => {
      console.log(error);
    });

  }
  uploadData(event: any) : void{
     for(var i=0;i< event.target.files.length;i++){  
    var file = event.target.files[i];
     }
    let fileName = file.name;
    let payload = {
file,
}
let formData: FormData = new FormData();
formData.append('file',file);
    console.log(file);
this.contestservice.emailAttachment(formData).subscribe((data)=>{
      console.log(data);
      
    },(error)=>{
      console.log(error);
});
}


  //     valueChange(list){
  //     this.someName=this.list.contestName;
  // }


}
