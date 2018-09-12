import { RouterModule, Routes } from "@angular/router";
import { NgModule } from "@angular/core";

import { ContestMasterComponent } from "./route/contest-master/contest-master.component";
import { DashboardComponent } from "./route/dashboard/dashboard.component";
import { ExideRuleEngineComponent } from "./route/exide-rule-engine/exide-rule-engine.component";
import { PrfListComponent } from "./route/prf-list/prf-list.component";
import { ExideReportDataUpdateComponent } from "./route/exide-report-data-update/exide-report-data-update.component";
import { MakerContestListComponent } from "./route/maker-contest-list/maker-contest-list.component";
import { MakerContestListDetailComponent } from "./route/maker-contest-list-detail/maker-contest-list-detail.component";
import { AgentMasterListComponent } from "./route/agent-master/agent-master-list/agent-master-list.component";
import { CheckerContestListComponent } from "./route/checker-contest-list/checker-contest-list.component";
import { AddDeviationComponent } from "./route/deviation/add-deviation/add-deviation.component";
import { VendorComponent } from "./route/vendor/vendor-data/vendor.component";
import { VendorAddComponent } from "./route/vendor/vendor-add/vendor-add.component";
import { VendorEditComponent } from "./route/vendor/vendor-edit/vendor-edit.component";
import { ReasonsAddComponent } from "./route/reasons/reasons-add/reasons-add.component";
import { ReasonsEditComponent } from "./route/reasons/reasons-edit/reasons-edit.component";
import { DeviationApprovalComponent } from "./route/deviation/deviation-approval/deviation-approval.component";
import { AddGregListComponent } from "./route/agent-greg-list/add-greg-list/add-greg-list.component";
import { ReasonsDataComponent } from "./route/reasons/reasons-data/reasons-data.component";
import { DestinationDataComponent } from "./route/destination/destination-data/destination-data.component";
import { DestinationAddComponent } from "./route/destination/destination-add/destination-add.component";
import { DestinationEditComponent } from "./route/destination/destination-edit/destination-edit.component";
import { CheckerContestListDetailComponent } from "./route/checker-contest-list-detail/checker-contest-list-detail.component";
import { ApproverOneContestViewComponent } from "./route/approver-one-contest-view/approver-one-contest-view.component";
import { ApproverTwoContestViewComponent } from "./route/approver-two-contest-view/approver-two-contest-view.component";
import { LoginComponent } from "./route/login/login.component";
import { ContestMasterListComponent } from "./route/contest-master-list/contest-master-list.component";
import { AdvancePayMakerComponent } from "./route/advance-pay/advance-pay-maker/advance-pay-maker.component";
import { AdvancePayCheckerComponent } from "./route/advance-pay/advance-pay-checker/advance-pay-checker.component";
import { AddAdvancePayComponent } from "./route/advance-pay/add-advance-pay/add-advance-pay.component";
import { AddContestMasterComponent } from "./route/add-contest-master/add-contest-master.component";
import { NavMenuComponent } from "./route/navmenu/navmenu.component";
import { MenuComponent } from './route/menu/menu.component';
import { PrfPrintComponent } from './route/prf-print/prf-print.component';
import { MakerRouteComponent } from './route/maker-route/maker-route.component';
import { AddUserComponent } from "./route/user-management/add-user/add-user.component";
import { EditUserComponent } from "./route/user-management/edit-user/edit-user.component";
import { ListUserComponent } from "./route/user-management/list-user/list-user.component";
import { VendorPrfComponent } from './route/vendor-prf/vendor-prf.component';
import { AgentGregListComponent } from './route/agent-greg-list/agent-greg-list.component';
import { EditGregListComponent } from "./route/agent-greg-list/edit-greg-list/edit-greg-list.component";
import { UtrComponent } from "./route/utr/utr.component";
import { GetViewDataComponent } from './route/callidus/get-view-data/get-view-data.component';
import { CallidusRunComponent } from "./route/callidus/callidus-run/callidus-run.component";
import { AddVendorPrfComponent } from './route/vendor-prf/add-vendor-prf/add-vendor-prf.component';
import { AddDeviationTicketComponent } from "./route/deviation/add-deviation-ticket/add-deviation-ticket.component";
import { ApproverThreeContestViewComponent } from "./route/approver-three-contest-view/approver-three-contest-view.component";
import { PageNotFound } from "./error-handling/page-not-found-component/404.component";
//import { EditDeviationComponent } from "./route/deviation/edit-deviation/edit-deviation.component";
import { UploadDownloadTicketComponent } from "./route/upload-download-ticket/upload-download-ticket.component";
const APP_ROUTES: Routes = [
    { path: "login", component: LoginComponent},    
    {   
        path: "",
        component: DashboardComponent,
        children: [
            { path: "exideContest", component: ContestMasterComponent  },
            { path: "exideRuleEngine", component: ExideRuleEngineComponent },
            { path: "exideReportDataUpdate", component: ExideReportDataUpdateComponent },
            { path: "makerContestlist", component: MakerContestListComponent },
            { path: "makerContestListDetails/:contestId", component: MakerContestListDetailComponent },
            { path: "agentMasterList", component: AgentMasterListComponent },
            { path: "checkerContestList", component: CheckerContestListComponent },
            { path: "checkerContestListDetails/:contestId", component: CheckerContestListDetailComponent },
            { path: "approveOne", component: ApproverOneContestViewComponent },
            { path: "approveTwo", component: ApproverTwoContestViewComponent },
            { path: "prfList", component: PrfListComponent },
            { path: "deviation", component: DeviationApprovalComponent },
            { path: "vendor", component: VendorComponent },
            { path: "addVendor", component: VendorAddComponent },
            { path: "editVendor", component: VendorEditComponent },
            { path: "reasons", component: ReasonsDataComponent },
            { path: "addReasons", component: ReasonsAddComponent },
            { path: "editReasons", component: ReasonsEditComponent },    
            { path: "contestmaster", component: ContestMasterListComponent },
            { path: "destination", component: DestinationDataComponent },
            { path: "addDestination", component: DestinationAddComponent },
            { path: "editDestination", component: DestinationEditComponent },
            { path: "advancePay", component: AdvancePayMakerComponent },
            { path: "advancePayChecker", component: AdvancePayCheckerComponent },
            { path: "addDeviation", component: AddDeviationComponent },
            //{ path: "editDeviation/:contestId", component: EditDeviationComponent },
            { path: "addAdvancePay", component: AddAdvancePayComponent },
            { path: "addContest", component: AddContestMasterComponent },
            { path: "prfPrint", component: PrfPrintComponent },
            { path: "maker", component: MakerRouteComponent },
            { path: "addDeviationTicket", component: AddDeviationTicketComponent },
            { path: "addUser", component: AddUserComponent },
            { path: "editUser", component: EditUserComponent },
            { path: "listUser", component: ListUserComponent },
            { path: "gregList", component: AgentGregListComponent },
            { path: "addGregList", component: AddGregListComponent },
            { path: "editGregList", component: EditGregListComponent },
            { path: "utr", component: UtrComponent },
            { path: "callidusRun", component: CallidusRunComponent },
            { path: "getViewData", component: GetViewDataComponent },
            { path: "vendorPRF", component: VendorPrfComponent },
             { path: "addvendorPRF", component: AddVendorPrfComponent },
             { path: "approveThree", component: ApproverThreeContestViewComponent },
             { path: "uploadDownload", component: UploadDownloadTicketComponent }

            
            
            
        ]
    },
    
    
];

@NgModule({
    imports: [RouterModule.forRoot(APP_ROUTES)],
    exports: [RouterModule]
})
export class AppRoutingModule { }
