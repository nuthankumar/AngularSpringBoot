import { Component } from '@angular/core';
import { DestinationService } from '../../../services/destination.service'
import { Destination } from '../../../model/destination';
import {Router} from '@angular/router';

@Component({
    selector: 'destination-edit',
    templateUrl: 'destination-edit.component.html',
    styleUrls: ['destination-edit.component.scss']
})
export class DestinationEditComponent {
    private destination:Destination;
    constructor(private destinationService: DestinationService,private router:Router){
 }
    ngOnInit(){
        this.destination=this.destinationService.getter();
    }
     form(){
        console.log(this.destination);
        this.destinationService.updateDestinationData(this.destination).subscribe((destination)=>{
          console.log(destination);
          this.router.navigate(['/destination']);
        },(error)=>{
          console.log(error);
        });
     }
}

