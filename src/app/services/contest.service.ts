import {Injectable} from "@angular/core";
import {Http, Response, RequestOptions, Headers} from "@angular/http";
import {Observable} from "rxjs/Observable";
import "rxjs/add/operator/map";
import "rxjs/add/operator/catch";
import {ITransactionCash} from "../model/transaction-cash";
import {IPRFList} from "../model/prf-list";
//import {Menu} from '../route/dashboard.component.model';

@Injectable()
export class ContestService {
     private apiURl  = "/SFCRM/";
    private headers = new Headers({"content-Type": "application/json"});
    private options = new RequestOptions({headers: this.headers});
    constructor(private http: Http) {
    }
    getExideContest() {
        return this.http.get(this.apiURl + "/exideContest", this.options)
        .map((response: Response) => response.json());
    }
    getExideRuleEngine() {
        return this.http.get(this.apiURl + "/exideRuleEngine", this.options)
        .map((response: Response) => response.json());
    }
    getExideReportUpdate() {
        return this.http.get(this.apiURl + "/exidReportDataUpdate", this.options)
        .map((response: Response) => response.json());
    }
    getapproverTwoContestList() {
        return this.http.get(this.apiURl + "/approverTwoContestList?pageNumber=1", this.options)
        .map((response: Response) => response.json());
    }
    getPRFList(agentTypes: any) {
        return this.http.get(this.apiURl + "/prfCashList?pageNumber=1&agentType=" + agentTypes, this.options)
        .map((response: Response) => response.json());
    }
    getagentTypes() {
        return this.http.get(this.apiURl + "/agentTypes", this.options)
        .map((response: Response) => response.json());
    }
    getChannelList(){
         return this.http.get(this.apiURl + "/channelList?pageNumber=1", this.options)
        .map((response: Response) => response.json());
    }
    getdeviationCashList() {
        return this.http.get(this.apiURl + "/deviationCashList?pageNumber=1", this.options)
        .map((response: Response) => response.json());
    }
    getdeviationTicketsList() {
        return this.http.get(this.apiURl + "/deviationTicketsList?pageNumber=1", this.options)
        .map((response: Response) => response.json());
    }
    
    getMasterContest(){
        return this.http.get(this.apiURl + "/allContests", this.options)
        .map((response: Response) => response.json());
    }
    allContestsDrp(){
        return this.http.get(this.apiURl + "/allContestsDrp", this.options)
        .map((response: Response) => response.json());
    }
    contestMasterWithTripDetails(){
        return this.http.get(this.apiURl + "/contestMasterWithTripDetails", this.options)
        .map((response: Response) => response.json());
    }
    updateApproveDeviationCash(list: ITransactionCash): Observable<any> {
        return this.http.put(this.apiURl + "/approveDeviationCash", JSON.stringify(list), this.options);
    }
    updateApproveDeviationTicket(list: ITransactionCash): Observable<any> {
        return this.http.put(this.apiURl + "/approveDeviationTickets", JSON.stringify(list), this.options);
    }
    rejectDeviationCash(list: ITransactionCash): Observable<any> {
        return this.http.put(this.apiURl + "/rejectDeviationCash", JSON.stringify(list), this.options);
    }
     updategeneratePrf(list: any): Observable<any> {
        return this.http.put(this.apiURl + "/generatePrf" , JSON.stringify(list), this.options);
    }
     updateDeviationCash(list: any): Observable<any> {
        return this.http.put(this.apiURl + "/deviationEntryCash" , JSON.stringify(list), this.options);
    }
     updateDeviationTicket(list: any): Observable<any> {
        return this.http.put(this.apiURl + "/deviationEntryTicket" , JSON.stringify(list), this.options);
    }
    updateMasterContest(list: any): Observable<any> {
    return this.http.put(this.apiURl + "/addContest" , JSON.stringify(list), this.options);
}
 updategeneratePrfTicket(list: any): Observable<any> {
        return this.http.put(this.apiURl + "/generatePrfTicket" , JSON.stringify(list), this.options);
    }
     updateutr(list: any): Observable<any> {
        return this.http.put(this.apiURl + "/utrNoForCash" , JSON.stringify(list), this.options);
    }
    updateGregList(list: any): Observable<any> {
        return this.http.put(this.apiURl + "/addAgentGregList" , JSON.stringify(list), this.options);
    }

     getCountForDev(contestId:any,endDate:any,destid:any) {
        return this.http.get(this.apiURl + "/deviationTicketCount?contestId="+ contestId + "&agentNo=" + endDate + "&destId=" +destid, this.options)
        .map((response: Response) => response.json());
    }

    
 getPRFListTicket(agentTypes: any) {
        return this.http.get(this.apiURl + "/prfTicketList?pageNumber=1&agentType=" + agentTypes, this.options)
        .map((response: Response) => response.json());
    }
     
    getPRFPrintGenDate(prfGENDate: any) {
        return this.http.get(this.apiURl + "/printPrfGenDate?prfGENDate=" + prfGENDate, this.options)
        .map((response: Response) => response.json());
    }
    getPRFPrintTicketGenDate(prfGENDate: any) {
        return this.http.get(this.apiURl + "/printTicketPrfGenDate?prfGENDate=" + prfGENDate, this.options)
        .map((response: Response) => response.json());
    }
     getPRFPrintByDate(startDate:any,endDate:any) {
        return this.http.get(this.apiURl + "/printPrfByDate?startDate="+ startDate + "&endDate=" + endDate, this.options)
        .map((response: Response) => response.json());
    }
    getPRFPrintByDateTicket(startDate:any,endDate:any) {
        return this.http.get(this.apiURl + "/printTicketPrfByDate?startDate="+ startDate + "&endDate=" + endDate, this.options)
        .map((response: Response) => response.json());
    }
     getPRFDetail() {
        return this.http.get(this.apiURl + "/getPrfListGenerated", this.options)
        .map((response: Response) => response.json());
    }
    getPRFDetailTicket() {
        return this.http.get(this.apiURl + "/getPrfTicketListGenerated", this.options)
        .map((response: Response) => response.json());
    }
    getGregList() {
        return this.http.get(this.apiURl + "/agentGregList", this.options)
        .map((response: Response) => response.json());
    }
    
    getPRFByNo(prfNo:any){
        return this.http.get(this.apiURl + "/printPrfNo?prfNo=" + prfNo, this.options)
        .map((response: Response) => response.json());
    }
    getPRFByNoTicket(prfNo:any){
        return this.http.get(this.apiURl + "/printTicketPrfNo?prfNo=" + prfNo, this.options)
        .map((response: Response) => response.json());
    }
    getTripDetails(contestId:any){
        return this.http.get(this.apiURl + "/tripDetails?contestId=" + contestId, this.options)
        .map((response: Response) => response.json());
    }
    getCallidus() {
        return this.http.get(this.apiURl + "/callidusRun", this.options)
        .map((response: Response) => response.json());
    }
    getViewData() {
        return this.http.get(this.apiURl + "/getViewData", this.options)
        .map((response: Response) => response.json());
    }
getPRDownload(){
      return this.http.get("http://nibc2274/ReportServer/Pages/ReportViewer.aspx?%2fSFCRM%2fReports%2fPRF_Print&rs:Format=PDF&PRFNoGenREF=1",this.options)
}
ticketUpload(list:any){
    
    console.log("list",list);
    console.log("listjson",JSON.stringify(list));
       return this.http.post(this.apiURl + "/uploadTicketData" , list)
        .map((response: Response) => response);

}
uploadUtrNo(list:any){
 console.log("list",list);
    console.log("listjson",JSON.stringify(list));
       return this.http.post(this.apiURl + "/uploadUtrNo" , list)
        .map((response: Response) => response);
}
downloadUtrExcel(){
    return this.http.get(this.apiURl + "/downloadUtrExcel", this.options)
        .map((response: Response) => response.json());
}
downloadExcel(){
    return this.http.get(this.apiURl + "/downloadExcel", this.options)
        .map((response: Response) => response.json());
}

getusers(){
debugger
    return this.http.get(this.apiURl + "/user/userDetail", this.options)
        .map((response: Response) => response.json());
}


//method to get all the configured data from the configure.json
 getConfigJson() {
        return this.http.get("./assets/json/config.json")
    .map((response: Response) => response.json());
    } 
    emailAttachment(list:any){
    
        console.log("list",list);
        console.log("listjson",JSON.stringify(list));
           return this.http.post(this.apiURl + "/emailAttach" , list)
            .map((response: Response) => response);
    
    }

lastUpdateDate(){
     return this.http.get(this.apiURl + "/lastUpdateDate", this.options)
        .map((response: Response) => response.json());
}
}
