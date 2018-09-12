package com.exide.sfcrm.service;

import java.text.ParseException;
import java.util.List;
import java.util.Map;

import com.exide.sfcrm.model.DeviationTicketPojo;
import com.exide.sfcrm.model.DeviationTicketsView;
//import com.exide.sfcrm.pojo.DeviationTicketViewPojo;

public interface DeviationTicketsService {

	Map<String, Object> getDeviationTicketsList(String userId, Integer pageNumber,
			Integer limit);

	int updateTransactionTicketDeviation(String deviationApprId,
			String deviationApprName, List<Map<String, String>> json);

	int rejectTransactionTicketsDeviation(String deviationApprId,
			String deviationApprName, List<Map<String, String>> json);

	void addDeviation(List<Map<String, String>> json, String userId) throws NumberFormatException, ParseException;

	


	List<Object> deviationTicketCount(Integer contestId,
			String agentNo, Integer destid);

	

}
