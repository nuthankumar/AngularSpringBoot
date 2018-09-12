import { Component } from '@angular/core';
import { UserManagementService } from '../../../services/user-management.service'
import { Router } from '@angular/router';
import { UserModel } from '../../../model/user-management';
import { GridOptions } from "ag-grid/main";



@Component({
  selector: 'list-User',
  templateUrl: 'list-user.component.html',
  styleUrls: ['list-user.component.scss']
})
export class ListUserComponent {
  private gridOptions: GridOptions;
  private pages: number;
  private currentPageNumber = 1;
  pageSize: number;
  userList: any;
  userListModel: any;
  private userModel: UserModel[];
  private rowData: any[];
  private autoGroupColumnDef: any;
  private rowSelection: any;
  private rowGroupPanelShow: any;
  private pivotPanelShow: any;
  private paginationPageSize: any;
  private paginationNumberFormatter: any;
  private defaultColDef: any;
  isvalid: boolean = true;


  // ag grid to display the user details
  columnDefsAdd = [
    {
      field: '', width: 60, headerCheckboxSelection: false,
      headerCheckboxSelectionFilteredOnly: true,
      checkboxSelection: true, suppressSorting: true,
      suppressMenu: true
    },
    { headerName: 'First Name', field: 'firstName', width: 200 },
    { headerName: 'Last Name', field: 'lastName', width: 200 },
    { headerName: 'User Name', field: 'userName', width: 200 },
    { headerName: 'Email', field: 'emailId', width: 200 },
    { headerName: 'User Group', field: 'name', width: 200 },
    //{headerName: 'Status', field: 'type',width: 200},

  ];
  constructor(private userManagementService: UserManagementService,
    private router: Router) { this.gridOptions = <GridOptions>{}; }

  ngOnInit() {

    this.userManagementService.getUserList().subscribe((lists) => {
      debugger
      this.userList = lists.data;
      for (let i = 0; i < this.userList.length; i++) {
        for (let j = 0; j < this.userList[i].userGroup.length; j++) {
          console.log(this.userList[i].userGroup[j].name);
          this.userList[i].name = this.userList[i].userGroup[j].name;
        }

      }


      console.log("users", lists);

    });

  }
  onRowSelected(event: any) {
    if (event.node.selected == true) {
      this.isvalid = false;
    } else {
      this.isvalid = true;
    }
  }
  onPageSizeChanged(newPageSize: any) {
    var value = (<HTMLInputElement>document.getElementById("page-size")).value;
    this.gridOptions.api.paginationSetPageSize(Number(value));
    //this.gridApi.paginationSetPageSize(Number(value));
    // this.paginationPageSize = 10;
    this.paginationNumberFormatter = function (params: any) {
      return "[" + params.value.toLocaleString() + "]";
    };
    this.defaultColDef = {
      editable: true,
      enableRowGroup: true,
      enablePivot: true,
      enableValue: true
    };
  }
  updateUser(user: any) {
    this.userList = this.gridOptions.api.getSelectedRows();
    this.userManagementService.setter(this.userList[0]);
    this.router.navigate(['/editUser'])
  }

}
