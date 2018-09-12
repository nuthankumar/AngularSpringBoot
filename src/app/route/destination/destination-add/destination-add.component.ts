import { Component } from '@angular/core';
import { DestinationService } from '../../../services/destination.service'
import { Destination } from '../../../model/destination';
import {Router} from '@angular/router';

@Component({
    selector: 'destination-add',
    templateUrl: 'destination-add.component.html',
    styleUrls: ['destination-add.component.scss']
})
export class DestinationAddComponent {
    private destination: Destination;
 constructor(private destinationService: DestinationService,private router:Router){

 }
  ngOnInit(){
    this.destination=this.destinationService.getter();
   
     }
     form(){
     this.destinationService.postDestinationData(this.destination).subscribe((destination)=>{
       debugger;
        console.log(destination);
        this.router.navigate(['/destination']);
      },(error)=>{
        console.log(error);
      });
}
}
