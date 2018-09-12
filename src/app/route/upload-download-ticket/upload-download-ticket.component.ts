import { Component } from '@angular/core';
import { ContestService } from '../../services/contest.service'
import { ContestMasterList } from '../../model/contest-list';
import {GridOptions} from "ag-grid/main";
import {Router} from '@angular/router';
import "ag-grid-enterprise";


@Component({
    selector: 'upload-download-ticket',
    templateUrl: 'upload-download-ticket.component.html',
    styleUrls: ['upload-download-ticket.component.scss']
})
export class UploadDownloadTicketComponent {
    constructor(private contestservice: ContestService, private router:Router){

    }
     public uploadData(event: any) : void {
        var file = event.target.files[0];
        let fileName = file.name;
        let payload = {
  file,
}
let formData: FormData = new FormData();
formData.append('file',file);
        console.log(file);
    this.contestservice.ticketUpload(formData).subscribe((res)=>{
            console.log(formData);
            alert("Uploaded successfully");
          },(error)=>{
            console.log(error);
            alert("Error while uploading");
         })
    }
downloadExcel(){
 this.contestservice.downloadExcel().subscribe((res)=>{
            console.log(res);
            alert("downloaded successfully");
          },(error)=>{
            console.log(error);
            alert("Error while downloading");
         })
}
}
