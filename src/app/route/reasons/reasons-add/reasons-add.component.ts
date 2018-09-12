import { Component } from '@angular/core';
import { ReasonsService } from '../../../services/reasons.service'
import { Reasons } from '../../../model/reasons';
import {Router} from '@angular/router';

@Component({
    selector: 'reasons-add',
    templateUrl: 'reasons-add.component.html',
    styleUrls: ['reasons-add.component.scss']
})
export class ReasonsAddComponent {
       private reasons:Reasons;
 constructor(private reasonsService: ReasonsService,private router:Router){

 }
  ngOnInit(){
    debugger;
    this.reasons=this.reasonsService.getter();
    this.reasons.status = true;
   
     }
     form(){
     this.reasonsService.postReasonsData(this.reasons).subscribe((reasons)=>{
       debugger;
        console.log(reasons);
        this.router.navigate(['/reasons']);
      },(error)=>{
        console.log(error);
      });


}
}
