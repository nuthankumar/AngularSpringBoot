import { LOGGING_ERROR_HANDLER_OPTIONS, LOGGING_ERROR_HANDLER_PROVIDERS } from "./error-handling/LoggingErrorHandler";
import { AppComponent } from "./app.component";
import { BrowserModule } from "@angular/platform-browser";
import { ErrorLogService } from "./error-handling/ErrorLogService";
import { FormsModule } from "@angular/forms";
import { HttpModule } from "@angular/http";
import { HttpClientModule } from "@angular/common/http"; 
import { HttpService } from "./layers/http/http.layer";
// Services
import { ContestService } from "./services/contest.service";
import { AgentMasterService } from "./services/agent-master.service";
import { CheckerService } from "./services/checker.service";
import { MakerService } from "./services/maker.service";
import { VendorService } from "./services/vendor.service";
import { ReasonsService } from "./services/reasons.service";
import { DestinationService } from "./services/destination.service";
import { AdvancePayService } from "./services/advance-pay.service";
import { UserManagementService } from "./services/user-management.service";
import { GregListService } from "./services/greg-list.service";
import { ApproverOneService } from "./services/approver-one.service";
import { ApproverTwoService } from "./services/approver-two.service";
import { ApproverThreeService } from "./services/approver-three.service";
import { VendorPRFService } from "./services/vendorPRF.service";

import { CommonService } from "./services/common.service";

import { PrfPrintComponent } from './route/prf-print/prf-print.component';
import { NgModule } from "@angular/core";
import { AgGridModule } from "ag-grid-angular";
import { PageNotFound } from "./error-handling/page-not-found-component/404.component";
import { LoadersCssModule } from "angular2-loaders-css";
import { AppRoutingModule } from "./app.routing";
import { ContestMasterComponent } from "./route/contest-master/contest-master.component";
import { ExideRuleEngineComponent } from "./route/exide-rule-engine/exide-rule-engine.component";
import { DashboardComponent } from "./route/dashboard/dashboard.component";
import { ExideReportDataUpdateComponent } from "./route/exide-report-data-update/exide-report-data-update.component";
import { MakerContestListComponent } from "./route/maker-contest-list/maker-contest-list.component";
import { MakerContestListDetailComponent } from "./route/maker-contest-list-detail/maker-contest-list-detail.component";
import { AgentMasterListComponent } from "./route/agent-master/agent-master-list/agent-master-list.component";
import "ag-grid-enterprise/main";
import { NgMultiSelectDropDownModule } from "ng-multiselect-dropdown";
import { MultiselectDropdownModule } from "angular-2-dropdown-multiselect";
import { PrfListComponent } from "./route/prf-list/prf-list.component";
import { AngularMultiSelectModule } from "angular2-multiselect-dropdown/angular2-multiselect-dropdown";
import { CheckerContestListComponent } from "./route/checker-contest-list/checker-contest-list.component";
import { AddDeviationComponent } from "./route/deviation/add-deviation/add-deviation.component";
//import { EditDeviationComponent } from "./route/deviation/edit-deviation/edit-deviation.component";
import { AddDeviationTicketComponent } from "./route/deviation/add-deviation-ticket/add-deviation-ticket.component";
import { AddUserComponent } from "./route/user-management/add-user/add-user.component";
import { EditUserComponent } from "./route/user-management/edit-user/edit-user.component";
import { ListUserComponent } from "./route/user-management/list-user/list-user.component";
import { CallidusRunComponent } from "./route/callidus/callidus-run/callidus-run.component"
import { UtrComponent } from "./route/utr/utr.component";
import { EditGregListComponent } from "./route/agent-greg-list/edit-greg-list/edit-greg-list.component";
import { AddGregListComponent } from "./route/agent-greg-list/add-greg-list/add-greg-list.component";
import { DeviationApprovalComponent } from "./route/deviation/deviation-approval/deviation-approval.component";
import { VendorComponent } from "./route/vendor/vendor-data/vendor.component";
import { ReasonsAddComponent } from "./route/reasons/reasons-add/reasons-add.component";
import { ReasonsEditComponent } from "./route/reasons/reasons-edit/reasons-edit.component";
import { ReasonsDataComponent } from "./route/reasons/reasons-data/reasons-data.component";
import { VendorAddComponent } from "./route/vendor/vendor-add/vendor-add.component";
import { VendorEditComponent } from "./route/vendor/vendor-edit/vendor-edit.component";
import { AdvancePayMakerComponent } from "./route/advance-pay/advance-pay-maker/advance-pay-maker.component";
import { AdvancePayCheckerComponent } from "./route/advance-pay/advance-pay-checker/advance-pay-checker.component";
import { DestinationDataComponent } from "./route/destination/destination-data/destination-data.component";
import { DestinationAddComponent } from "./route/destination/destination-add/destination-add.component";
import { DestinationEditComponent } from "./route/destination/destination-edit/destination-edit.component";
import { CheckerContestListDetailComponent } from "./route/checker-contest-list-detail/checker-contest-list-detail.component";
import { ApproverOneContestViewComponent } from "./route/approver-one-contest-view/approver-one-contest-view.component";
import { ApproverTwoContestViewComponent } from "./route/approver-two-contest-view/approver-two-contest-view.component";
import { ApproverThreeContestViewComponent } from "./route/approver-three-contest-view/approver-three-contest-view.component";

import { UploadDownloadTicketComponent } from "./route/upload-download-ticket/upload-download-ticket.component";
import { LoginComponent } from "./route/login/login.component";
import { ContestMasterListComponent } from "./route/contest-master-list/contest-master-list.component";
import { AddAdvancePayComponent } from "./route/advance-pay/add-advance-pay/add-advance-pay.component";
import { HeaderComponent } from "./route/header-footer/header/header.component";
import { FooterComponent } from "./route/header-footer/footer/footer.component";
import { NgxTypeaheadModule } from 'ngx-typeahead';
import { AddContestMasterComponent } from "./route/add-contest-master/add-contest-master.component";
import { NavMenuComponent } from "./route/navmenu/navmenu.component";
import { MenuComponent } from './route/menu/menu.component';
import { MakerRouteComponent } from './route/maker-route/maker-route.component';
import { AgentGregListComponent } from './route/agent-greg-list/agent-greg-list.component';
import { GetViewDataComponent } from './route/callidus/get-view-data/get-view-data.component';
import { AddVendorPrfComponent } from './route/vendor-prf/add-vendor-prf/add-vendor-prf.component';
import { VendorPrfComponent } from './route/vendor-prf/vendor-prf.component';
//import {SelectModule} from 'ng-select';
import { NgSelectModule } from '@ng-select/ng-select';
import { ReactiveFormsModule } from '@angular/forms';
import { OnlyNumber } from './number.directive';
@NgModule({
    imports: [
        BrowserModule,
        FormsModule,
        HttpModule,
        HttpClientModule,
        AppRoutingModule,
        LoadersCssModule,
        AngularMultiSelectModule,
        NgxTypeaheadModule,
        NgMultiSelectDropDownModule.forRoot(),
        MultiselectDropdownModule,
        NgSelectModule,
        ReactiveFormsModule,
        AgGridModule.withComponents([])
    ],
    declarations: [
        OnlyNumber,
        AppComponent,
        PageNotFound,
        ContestMasterComponent,
        ExideRuleEngineComponent,
        DashboardComponent,
        AddDeviationComponent,
        ExideReportDataUpdateComponent,
        MakerContestListComponent,
        MakerContestListDetailComponent,
        AgentMasterListComponent,
        CheckerContestListComponent,
        CheckerContestListDetailComponent,
        ApproverOneContestViewComponent,
        ApproverTwoContestViewComponent,
        PrfListComponent,
        VendorComponent,
        VendorAddComponent,
        VendorEditComponent,
        ReasonsDataComponent,
        ReasonsAddComponent,
        ReasonsEditComponent,
        LoginComponent,
        ContestMasterListComponent,
        DestinationDataComponent,
        DestinationAddComponent,
        DestinationEditComponent,
        AdvancePayMakerComponent,
        AdvancePayCheckerComponent,
        DeviationApprovalComponent,
        AddAdvancePayComponent,
        AddContestMasterComponent,
        HeaderComponent,
        FooterComponent,
        NavMenuComponent,
        MenuComponent,
        PrfPrintComponent,
        MakerRouteComponent,
        AddDeviationTicketComponent,
        AddUserComponent,
        EditUserComponent,
        ListUserComponent,
        AgentGregListComponent,
        AddGregListComponent,
        EditGregListComponent,
        UtrComponent,
        CallidusRunComponent,
        GetViewDataComponent,
        VendorPrfComponent,
        AddVendorPrfComponent,
        ApproverThreeContestViewComponent,
        UploadDownloadTicketComponent,
    ],
    providers: [
        HttpService,
        ErrorLogService,
        ContestService,
        AgentMasterService,
        CheckerService,
        MakerService,
        VendorService,
        ReasonsService,
        DestinationService,
        AdvancePayService,
        UserManagementService,
        GregListService,
        ApproverOneService,
        ApproverTwoService,
        VendorPRFService,
        ApproverThreeService,
        CommonService,   
    
        // CAUTION: This providers collection overrides the CORE ErrorHandler with our
        // custom version of the service that logs errors to the ErrorLogService.
        LOGGING_ERROR_HANDLER_PROVIDERS,

        // OPTIONAL: By default, our custom LoggingErrorHandler has behavior around
        // rethrowing and / or unwrapping errors. In order to facilitate dependency-
        // injection instead of resorting to the use of a Factory for instantiation,
        // these options can be overridden in the providers collection.
        {
            provide: LOGGING_ERROR_HANDLER_OPTIONS,
            useValue: {
                rethrowError: false,
                unwrapError: true
            }
        }
    ],
    entryComponents: [
        AddDeviationComponent,
    ],
    bootstrap: [
        AppComponent
    ]
})
export class AppModule { }
