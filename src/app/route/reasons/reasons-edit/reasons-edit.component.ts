import { Component } from '@angular/core';
import { ReasonsService } from '../../../services/reasons.service'
import { Reasons } from '../../../model/reasons';
import {Router} from '@angular/router';
@Component({
    selector: 'reasons-edit',
    templateUrl: 'reasons-edit.component.html',
    styleUrls: ['reasons-edit.component.scss']
})
export class ReasonsEditComponent {
    private reasons:Reasons;
    constructor(private reasonService: ReasonsService,private router:Router){
 }
    ngOnInit(){
        this.reasons=this.reasonService.getter();
    }
     form(){
        console.log(this.reasons);
        this.reasonService.updateReasonsData(this.reasons).subscribe((reasons)=>{
          console.log(reasons);
          this.router.navigate(['/reasons']);
        },(error)=>{
          console.log(error);
        });
     }
}
