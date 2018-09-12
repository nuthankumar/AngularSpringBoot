package com.exide.sfcrm.util;

import java.util.Arrays;

import org.json.simple.JSONArray;
import org.json.simple.JSONObject;
import org.springframework.stereotype.Component;

@Component
public class JSONUtils {

	
	//List of Parent JSON object labels
	public final String MASTER="Master";
	public final String CONTEST_DATA="Contest Data";
	public final String ADVANCE="Advance";
	public final String DEVIATION="Deviation";
	public final String PRF="PRF";
	public final String CALLIDUS="Callidus";
	//List of ID's
	public final String ID_1="1";
	public final String ID_2="2";

	//List of Level names for both parent and children JSON objects
	public final String LEVEL_NAME_GROUP="group";
	public final String LEVEL_NAME_PERSON="person";
	public final String LEVEL_NAME_SPEAKERNOTES="speaker_notes";
	public final String LEVEL_NAME_FEEDBACK="feedback";
	public final String LEVEL_NAME_APPROVEONE="approveOne";
	public final String LEVEL_NAME_D="d";
	//List of children JSON objects labels
	public final String LABEL_CONTEST_MASTER="Contest Master";
	public final String LABEL_AGENT_GREG_LIST="Agent Greg List";
	public final String LABEL_VENDOR="Vendor";
	public final String LABEL_EXIDE_CONTEST="Exide Contest";
	public final String LABEL_EXIDE_REPORT_DATAUPDATE="Exide Report DataUpdate";
	public final String LABEL_EXIDE_RULE_ENGINE="Exide Rule Engine";
	public final String LABEL_ADVANCE_PAY_MAKER="Advance Pay Maker";
	public final String LABEL_MAKER_QUEUE="Maker Queue";
	public final String LABEL_PRF_LIST="PRF List";
	public final String LABEL_PRF_PRINT="PRF Print";
	public final String LABEL_DESTINATION="Destination";
	public final String LABEL_REASONS="Reasons";
	public final String LABEL_CHECKER_QUEUE="Checker Queue";
	public final String LABEL_DEVIATION_APPROVE="Deviation Approve";
	public final String LABEL_APPROVER1="Approver1";
	public final String LABEL_APPROVER2="Approver2";
	public final String LABEL_DEVIATION_ENTRY="Deviation Entry";
	public final String LABEL_ADVANCE_PAY_CHECKER="Advance Pay Checker";
	public final String LABEL_CALLIDUS_RUN="Callidus Run";
	public final String LABEL_GET_VIEW_DATA="Get View Data";
	public final String LABEL_APPROVER3="Approver3";
	public final String LABEL_UPLOAD_DOWNLOAD="Upload/Download Ticket";
	public final String LABEL_UTR="UTR";
	public final String LABEL_VENDOR_PRF="Vendor PRF";
	public final String LABEL_USER="User Management";

	//List of links for children JSON objects
	public final String LINK_CONTEST_MASTER = "/contestmaster";
	public final String LINK_DEFAULT = "/#";
	public final String LINK_VENDOR = "/vendor";
	public final String LINK_EXIDE_CONTEST = "/exideContest";
	public final String LINK_EXIDE_REPORT_DATA_UPDATE = "/exideReportDataUpdate";
	public final String LINK_EXIDE_RULE_ENGINE = "/exideRuleEngine";
	public final String LINK_ADVANCE_PAY = "/advancePay";
	public final String LINK_MAKER_CONTEST_LIST = "/makerContestlist";
	public final String LINK_PRF_LIST = "/prfList";
	public final String LINK_PRF_PRINT = "/prfPrint";
	public final String LINK_DESTINATION = "/destination";
	public final String LINK_REASONS = "/reasons";
	public final String LINK_ADVANCE_PAY_CHECKER = "/advancePayChecker";
	public final String LINK_CHECKER_CONTEST_LIST = "/checkerContestList";
	public final String LINK_DEVIATION = "/deviation";
	public final String LINK_APPROVE_ONE = "/approveOne";
	public final String LINK_APPROVE_TWO = "/approveTwo";
	public final String LINK_ADD_DEVIATION = "/addDeviation";
	public final String LINK_CALLIDUS_RUN = "/callidusRun";
	public final String LINK_GET_VIEW_DATA = "/getViewData";
	public final String LINK_UPLOAD_DOWNLOAD = "/uploadDownload";
	public final String LINK_UTR = "/utr";
	public final String LINK_VENDOR_PRF = "/vendorPRF";
	public final String LINK_GREGLIST = "/gregList";
	public final String LINK_APPROVE_THREE = "/approveThree";
	public final String LINK_USER = "/listUser";
	
	//List of roles
	public final String MAKER = "Maker";
	public final String CHECKER = "Checker";
	public final String APPROVER_1 = "Approver1";
	public final String APPROVER_2 = "Approver2";
	public final String ADMINISTRATOR = "Administrator";

	/*	public void main(String[] args) {
			String roles[] = { "Maker", "Checker", "Administrator" };
			String roles[] = { "Approver1" };
			String roles[] = { "Approver2" };
			long startTime = System.nanoTime();
			String roles[] = {"Maker","Checker","Administrator","Approver1","Approver2"};
			JSONObject resultOject = new JSONObject();
			JSONArray resultNavArray = new JSONArray();
			JSONObject master = new JSONObject();
			JSONObject contest = new JSONObject();
			JSONObject advance = new JSONObject();
			JSONObject deviation = new JSONObject();
			JSONObject prf = new JSONObject();

			if (Arrays.asList(roles).contains(MAKER) || Arrays.asList(roles).contains(CHECKER) || Arrays.asList(roles).contains(ADMINISTRATOR)) {
				master = getMasterJSON(roles);
				contest = getContestJSON(roles);
				advance = getAdvanceJSON(roles);
			}
			if (Arrays.asList(roles).contains(APPROVER_1) || Arrays.asList(roles).contains(ADMINISTRATOR)) {
				deviation = getDeviationJSON(roles);
			}
			prf = getPrfJSON(roles);
			resultOject = consolidateNavJSON(master, contest, advance, deviation, prf, resultOject, resultNavArray);
			long endTime = System.nanoTime();

			long duration = (endTime - startTime); 
			System.out.println(duration/1000000);
			System.gc();
		}
		*/
		@SuppressWarnings("unchecked")
		public JSONObject consolidateNavJSON(JSONObject master, JSONObject contest, JSONObject advance, JSONObject callidus, JSONObject deviation, JSONObject prf, JSONObject resultOject, JSONArray resultNavArray) {
			if(!master.isEmpty()) resultNavArray.add(master);
			if(!contest.isEmpty()) resultNavArray.add(contest);
			if(!advance.isEmpty()) resultNavArray.add(advance);
			if(!callidus.isEmpty()) resultNavArray.add(callidus);
			if(!deviation.isEmpty()) resultNavArray.add(deviation);
			if(!prf.isEmpty()) resultNavArray.add(prf);
			resultOject.put("navigationItems", resultNavArray);
			return resultOject;
		}

		@SuppressWarnings("unchecked")
		public JSONObject getCallidusJSON(String[] roles) {
			boolean adminAdded = false;
			JSONObject callidusParent = new JSONObject();
			JSONArray callidusChildren = new JSONArray();
			if (Arrays.asList(roles).contains(ADMINISTRATOR)) {
				JSONObject callidus1= new JSONObject();
				callidus1.put("id", ID_1);
				callidus1.put("label", LABEL_CALLIDUS_RUN);
				callidus1.put("levelName", LEVEL_NAME_PERSON);
				callidus1.put("link", LINK_CALLIDUS_RUN);
				callidusChildren.add(callidus1);
				
				JSONObject callidus2= new JSONObject();
				callidus2.put("id", ID_1);
				callidus2.put("label", LABEL_GET_VIEW_DATA);
				callidus2.put("levelName", LEVEL_NAME_PERSON);
				callidus2.put("link", LINK_GET_VIEW_DATA);
				callidusChildren.add(callidus2);
				adminAdded=true;
			}
			else {
				if(!adminAdded) {
					JSONObject callidus1= new JSONObject();
					callidus1.put("id", ID_1);
					callidus1.put("label", LABEL_CALLIDUS_RUN);
					callidus1.put("levelName", LEVEL_NAME_PERSON);
					callidus1.put("link", LINK_CALLIDUS_RUN);
					callidusChildren.add(callidus1);
					
					JSONObject callidus2= new JSONObject();
					callidus2.put("id", ID_1);
					callidus2.put("label", LABEL_GET_VIEW_DATA);
					callidus2.put("levelName", LEVEL_NAME_PERSON);
					callidus2.put("link", LINK_GET_VIEW_DATA);
					callidusChildren.add(callidus2);
				}
			}
			callidusParent.put("id", ID_1);
			callidusParent.put("label", CALLIDUS);
			callidusParent.put("levelName", LEVEL_NAME_FEEDBACK);
			callidusParent.put("children", callidusChildren);
			return callidusParent;
		}
		@SuppressWarnings("unchecked")
		public JSONObject getMasterJSON(String[] roles) {
			boolean adminAdded = false;
			boolean checkerAdded = false;
			JSONObject masterParent = new JSONObject();
			JSONArray masterChildren = new JSONArray();
			if (Arrays.asList(roles).contains(ADMINISTRATOR)) {
				JSONObject master1= new JSONObject();
				master1.put("id", ID_1);
				master1.put("label", LABEL_USER);
				master1.put("levelName",LEVEL_NAME_PERSON);
				master1.put("link", LINK_USER);
				
				JSONObject master2= new JSONObject();
				master2.put("id", ID_1);
				master2.put("label", LABEL_CONTEST_MASTER);
				master2.put("levelName", LEVEL_NAME_PERSON);
				master2.put("link", LINK_CONTEST_MASTER);
				
				JSONObject master3= new JSONObject();
				master3.put("id", ID_1);
				master3.put("label", LABEL_DESTINATION);
				master3.put("levelName", LEVEL_NAME_PERSON);
				master3.put("link", LINK_DESTINATION);
				
				JSONObject master4= new JSONObject();
				master4.put("id", ID_1);
				master4.put("label", LABEL_REASONS);
				master4.put("levelName", LEVEL_NAME_PERSON);
				master4.put("link", LINK_REASONS);
				
				JSONObject master5= new JSONObject();
				master5.put("id", ID_1);
				master5.put("label", LABEL_AGENT_GREG_LIST);
				master5.put("levelName", LEVEL_NAME_PERSON);
				master5.put("link", LINK_GREGLIST);
				
				JSONObject master6= new JSONObject();
				master6.put("id", ID_1);
				master6.put("label", LABEL_VENDOR);
				master6.put("levelName", LEVEL_NAME_PERSON);
				master6.put("link", LINK_VENDOR);
				masterChildren.add(master1);
				masterChildren.add(master2);
				masterChildren.add(master3);
				masterChildren.add(master4);
				masterChildren.add(master5);
				masterChildren.add(master6);
				adminAdded=true;
			}
			if (Arrays.asList(roles).contains(CHECKER) && !adminAdded) {
				
				JSONObject master2= new JSONObject();
				master2.put("id", ID_1);
				master2.put("label", LABEL_CONTEST_MASTER);
				master2.put("levelName", LEVEL_NAME_PERSON);
				master2.put("link", LINK_CONTEST_MASTER);
				
				JSONObject master3= new JSONObject();
				master3.put("id", ID_1);
				master3.put("label", LABEL_DESTINATION);
				master3.put("levelName", LEVEL_NAME_PERSON);
				master3.put("link", LINK_DESTINATION);
				
				JSONObject master4= new JSONObject();
				master4.put("id", ID_1);
				master4.put("label", LABEL_REASONS);
				master4.put("levelName", LEVEL_NAME_PERSON);
				master4.put("link", LINK_REASONS);
				
				JSONObject master5= new JSONObject();
				master5.put("id", ID_1);
				master5.put("label", LABEL_AGENT_GREG_LIST);
				master5.put("levelName", LEVEL_NAME_PERSON);
				master5.put("link", LINK_GREGLIST);
				
				JSONObject master6= new JSONObject();
				master6.put("id", ID_1);
				master6.put("label", LABEL_VENDOR);
				master6.put("levelName", LEVEL_NAME_PERSON);
				master6.put("link", LINK_VENDOR);
				masterChildren.add(master2);
				masterChildren.add(master3);
				masterChildren.add(master4);
				masterChildren.add(master5);
				masterChildren.add(master6);
				checkerAdded = true;
			}
			if (Arrays.asList(roles).contains(MAKER) && !adminAdded && !checkerAdded) {
				
				JSONObject master2= new JSONObject();
				master2.put("id", ID_1);
				master2.put("label", LABEL_CONTEST_MASTER);
				master2.put("levelName", LEVEL_NAME_PERSON);
				master2.put("link", LINK_CONTEST_MASTER);
				
				JSONObject master5= new JSONObject();
				master5.put("id", ID_1);
				master5.put("label", LABEL_AGENT_GREG_LIST);
				master5.put("levelName", LEVEL_NAME_PERSON);
				master5.put("link", LINK_GREGLIST);
				
				JSONObject master6= new JSONObject();
				master6.put("id", ID_1);
				master6.put("label", LABEL_VENDOR);
				master6.put("levelName", LEVEL_NAME_PERSON);
				master6.put("link", LINK_VENDOR);
				masterChildren.add(master2);
				masterChildren.add(master5);
				masterChildren.add(master6);
			}
			masterParent.put("id", ID_1);
			masterParent.put("label", MASTER);
			masterParent.put("levelName", LEVEL_NAME_GROUP);
			masterParent.put("children", masterChildren);
			return masterParent;
		}
		@SuppressWarnings("unchecked")
		public JSONObject getContestJSON(String[] roles) {
			JSONObject contestParent = new JSONObject();
			JSONArray contestChildren = new JSONArray();

			JSONObject contest1= new JSONObject();
			contest1.put("id", ID_1);
			contest1.put("label", LABEL_EXIDE_CONTEST);
			contest1.put("levelName", LEVEL_NAME_PERSON);
			contest1.put("link", LINK_EXIDE_CONTEST);
			
			JSONObject contest2= new JSONObject();
			contest2.put("id", ID_1);
			contest2.put("label", LABEL_EXIDE_REPORT_DATAUPDATE);
			contest2.put("levelName", LEVEL_NAME_PERSON);
			contest2.put("link", LINK_EXIDE_REPORT_DATA_UPDATE);
			
			JSONObject contest3= new JSONObject();
			contest3.put("id", ID_1);
			contest3.put("label", LABEL_EXIDE_RULE_ENGINE);
			contest3.put("levelName", LEVEL_NAME_PERSON);
			contest3.put("link", LINK_EXIDE_RULE_ENGINE);
			
			contestChildren.add(contest1);
			contestChildren.add(contest2);
			contestChildren.add(contest3);
			contestParent.put("id", ID_1);
			contestParent.put("label", CONTEST_DATA);
			contestParent.put("levelName", LEVEL_NAME_SPEAKERNOTES);
			contestParent.put("children", contestChildren);
			return contestParent;
		}
		
		@SuppressWarnings("unchecked")
		public JSONObject getAdvanceJSON(String[] roles) {
			JSONObject advanceParent = new JSONObject();
			JSONArray advanceChildren = new JSONArray();
			boolean adminAdded = false;
			
			if(Arrays.asList(roles).contains(ADMINISTRATOR)) {
			JSONObject advance1= new JSONObject();
			advance1.put("id", ID_1);
			advance1.put("label", LABEL_ADVANCE_PAY_CHECKER);
			advance1.put("levelName", LEVEL_NAME_PERSON);
			advance1.put("link", LINK_ADVANCE_PAY_CHECKER);
			advanceChildren.add(advance1);
			
			JSONObject advance2= new JSONObject();
			advance2.put("id", ID_1);
			advance2.put("label", LABEL_ADVANCE_PAY_MAKER);
			advance2.put("levelName", LEVEL_NAME_PERSON);
			advance2.put("link", LINK_ADVANCE_PAY);
			advanceChildren.add(advance2);
			adminAdded = true;
			}
			if (Arrays.asList(roles).contains(CHECKER) && !adminAdded) {
				JSONObject advance2= new JSONObject();
				advance2.put("id", ID_1);
				advance2.put("label", LABEL_ADVANCE_PAY_CHECKER);
				advance2.put("levelName", LEVEL_NAME_PERSON);
				advance2.put("link", LINK_ADVANCE_PAY_CHECKER);
				advanceChildren.add(advance2);
			}
			
			if (Arrays.asList(roles).contains(MAKER) && !adminAdded) {
				JSONObject advance2= new JSONObject();
				advance2.put("id", ID_1);
				advance2.put("label", LABEL_ADVANCE_PAY_MAKER);
				advance2.put("levelName", LEVEL_NAME_PERSON);
				advance2.put("link", LINK_ADVANCE_PAY);
				advanceChildren.add(advance2);
			}
			advanceParent.put("id", ID_1);
			advanceParent.put("label", ADVANCE);
			advanceParent.put("levelName", LEVEL_NAME_FEEDBACK);
			advanceParent.put("children", advanceChildren);
			return advanceParent;
		}
		
		@SuppressWarnings("unchecked")
		public JSONObject getDeviationJSON(String[] roles) {
			JSONObject deviationParent = new JSONObject();
			JSONArray deviationChildren = new JSONArray();
			boolean adminAdded = false;
			if(Arrays.asList(roles).contains(ADMINISTRATOR)) {
				JSONObject deviation1= new JSONObject();
				deviation1.put("id", ID_1);
				deviation1.put("label", LABEL_DEVIATION_APPROVE);
				deviation1.put("levelName", LEVEL_NAME_PERSON);
				deviation1.put("link", LINK_DEVIATION);
				deviationChildren.add(deviation1);
				
				adminAdded = true;
				}
			if (Arrays.asList(roles).contains(APPROVER_1) && !adminAdded) {
				JSONObject deviation3= new JSONObject();
				deviation3.put("id", ID_1);
				deviation3.put("label", LABEL_DEVIATION_APPROVE);
				deviation3.put("levelName", LEVEL_NAME_PERSON);
				deviation3.put("link", LINK_DEVIATION);
				deviationChildren.add(deviation3);
			}
			deviationParent.put("id", ID_1);
			deviationParent.put("label", DEVIATION);
			deviationParent.put("levelName", LEVEL_NAME_GROUP);
			deviationParent.put("children", deviationChildren);
			return deviationParent;
		}
		
		@SuppressWarnings("unchecked")
		public JSONObject getPrfJSON(String[] roles) {
			JSONObject prfParent = new JSONObject();
			JSONArray prfChildren = new JSONArray();
			boolean adminAdded = false;
			if(Arrays.asList(roles).contains(ADMINISTRATOR)) {
				
				JSONObject prf0= new JSONObject();
				prf0.put("id", ID_1);
				prf0.put("label", LABEL_UPLOAD_DOWNLOAD);
				prf0.put("levelName", LEVEL_NAME_PERSON);
				prf0.put("link", LINK_UPLOAD_DOWNLOAD);
				prfChildren.add(prf0);
				
				JSONObject prf1= new JSONObject();
				prf1.put("id", ID_1);
				prf1.put("label", LABEL_MAKER_QUEUE);
				prf1.put("levelName", LEVEL_NAME_PERSON);
				prf1.put("link", LINK_MAKER_CONTEST_LIST);
				prfChildren.add(prf1);
				
				JSONObject prf2= new JSONObject();
				prf2.put("id", ID_1);
				prf2.put("label", LABEL_CHECKER_QUEUE);
				prf2.put("levelName", LEVEL_NAME_PERSON);
				prf2.put("link", LINK_CHECKER_CONTEST_LIST);
				prfChildren.add(prf2);
				
				JSONObject prf3= new JSONObject();
				prf3.put("id", ID_1);
				prf3.put("label", LABEL_PRF_LIST);
				prf3.put("levelName", LEVEL_NAME_PERSON);
				prf3.put("link", LINK_PRF_LIST);
				prfChildren.add(prf3);
				
				JSONObject prf4= new JSONObject();
				prf4.put("id", ID_1);
				prf4.put("label", LABEL_PRF_PRINT);
				prf4.put("levelName", LEVEL_NAME_PERSON);
				prf4.put("link", LINK_PRF_PRINT);
				prfChildren.add(prf4);
				
				JSONObject prf5= new JSONObject();
				prf5.put("id", ID_1);
				prf5.put("label", LABEL_APPROVER1);
				prf5.put("levelName", LEVEL_NAME_APPROVEONE);
				prf5.put("link", LINK_APPROVE_ONE);
				prfChildren.add(prf5);
				
				JSONObject prf6= new JSONObject();
				prf6.put("id", ID_1);
				prf6.put("label", LABEL_APPROVER2);
				prf6.put("levelName", LEVEL_NAME_PERSON);
				prf6.put("link", LINK_APPROVE_TWO);
				prfChildren.add(prf6);
				
				JSONObject prf7= new JSONObject();
				prf7.put("id", ID_1);
				prf7.put("label", LABEL_APPROVER3);
				prf7.put("levelName", LEVEL_NAME_PERSON);
				prf7.put("link", LINK_APPROVE_THREE);
				prfChildren.add(prf7);
				
				JSONObject prf8= new JSONObject();
				prf8.put("id", ID_1);
				prf8.put("label", LABEL_UTR);
				prf8.put("levelName", LEVEL_NAME_PERSON);
				prf8.put("link", LINK_UTR);
				prfChildren.add(prf8);
				
				JSONObject prf9= new JSONObject();
				prf9.put("id", ID_1);
				prf9.put("label", LABEL_VENDOR_PRF);
				prf9.put("levelName", LEVEL_NAME_PERSON);
				prf9.put("link", LINK_VENDOR_PRF);
				prfChildren.add(prf9);
				
				prfParent.put("id", ID_1);
				prfParent.put("label", PRF );
				prfParent.put("levelName", LEVEL_NAME_FEEDBACK);
				prfParent.put("children", prfChildren);
				adminAdded = true;
			}
			if(!adminAdded) {
				if(Arrays.asList(roles).contains(MAKER) || Arrays.asList(roles).contains(CHECKER)) {
					JSONObject prf3= new JSONObject();
					prf3.put("id", ID_1);
					prf3.put("label", LABEL_PRF_LIST);
					prf3.put("levelName", LEVEL_NAME_PERSON);
					prf3.put("link", LINK_PRF_LIST);
					prfChildren.add(prf3);
					
					JSONObject prf4= new JSONObject();
					prf4.put("id", ID_1);
					prf4.put("label", LABEL_PRF_PRINT);
					prf4.put("levelName", LEVEL_NAME_PERSON);
					prf4.put("link", LINK_PRF_PRINT);
					prfChildren.add(prf4);
					
					JSONObject prf8= new JSONObject();
					prf8.put("id", ID_1);
					prf8.put("label", LABEL_UTR);
					prf8.put("levelName", LEVEL_NAME_PERSON);
					prf8.put("link", LINK_UTR);
					prfChildren.add(prf8);
					
					JSONObject prf0= new JSONObject();
					prf0.put("id", ID_1);
					prf0.put("label", LABEL_UPLOAD_DOWNLOAD);
					prf0.put("levelName", LEVEL_NAME_PERSON);
					prf0.put("link", LINK_UPLOAD_DOWNLOAD);
					prfChildren.add(prf0);
					
					if((Arrays.asList(roles).contains(MAKER))) {
						JSONObject prf1= new JSONObject();
						prf1.put("id", ID_1);
						prf1.put("label", LABEL_MAKER_QUEUE);
						prf1.put("levelName", LEVEL_NAME_PERSON);
						prf1.put("link", LINK_MAKER_CONTEST_LIST);
						prfChildren.add(prf1);
					}
					if((Arrays.asList(roles).contains(CHECKER))) {
						JSONObject prf2= new JSONObject();
						prf2.put("id", ID_1);
						prf2.put("label", LABEL_CHECKER_QUEUE);
						prf2.put("levelName", LEVEL_NAME_PERSON);
						prf2.put("link", LINK_CHECKER_CONTEST_LIST);
						prfChildren.add(prf2);
					}
					prfParent.put("id", ID_1);
					prfParent.put("label", PRF );
					prfParent.put("levelName", LEVEL_NAME_FEEDBACK);
					prfParent.put("children", prfChildren);
				}
				else {
					if(Arrays.asList(roles).contains(LABEL_APPROVER1)){
						JSONObject prf5= new JSONObject();
						prf5.put("id", ID_1);
						prf5.put("label", LABEL_APPROVER1);
						prf5.put("levelName", LEVEL_NAME_PERSON);
						prf5.put("link", LINK_APPROVE_ONE);
						prfChildren.add(prf5);
					}
					if(Arrays.asList(roles).contains(LABEL_APPROVER2)){
						JSONObject prf6= new JSONObject();
						prf6.put("id", ID_1);
						prf6.put("label", LABEL_APPROVER2);
						prf6.put("levelName", LEVEL_NAME_PERSON);
						prf6.put("link", LINK_APPROVE_TWO);
						prfChildren.add(prf6);
					}
					prfParent.put("id", ID_1);
					prfParent.put("label", PRF );
					prfParent.put("levelName", LEVEL_NAME_GROUP);
					prfParent.put("children", prfChildren);
				}
			}
			return prfParent;
		}
}
