import { Component } from '@angular/core';

@Component({
    selector: 'header-c',
    templateUrl: 'header.component.html',
    styleUrls: ['header.component.scss']
})
export class HeaderComponent {
    logout(){
     window.location.href = '../../../../../SFCRM/login.html';
    }
}
