import { Component, Input } from '@angular/core';
import { Menu } from '../../model/menu';

@Component({
    selector: 'menu',
    templateUrl: 'menu.component.html'
})
export class MenuComponent {
	@Input() menu: Menu;
	constructor(){}
	ngOnInit(){}
}