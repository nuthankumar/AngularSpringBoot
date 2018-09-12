export class Menu{
	id:number;
	label:string;
	link?:string="#";
	level?:number;
	levelName?:string;
	children?: Array<Menu> = [];
}