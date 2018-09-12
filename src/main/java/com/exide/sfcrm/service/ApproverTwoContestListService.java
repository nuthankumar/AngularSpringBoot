package com.exide.sfcrm.service;

import java.util.List;
import java.util.Map;

public interface ApproverTwoContestListService {

	Map<String, Object> getApproverTwoContestList(String userId,
			int pageNumber, int limit);

	public void updateTransactionCashApproverTwo(String approverId,
			String approverName, List<Map<String, String>> json);

	List<Object> getApproverTwoPRFGeneratedCash(int prfNoGenREF);

	Map<String, Object> getApproveTwoTickets(String userId, Integer pageNumber,
			Integer limit);

	void updateApproverTwoTransactionTicket(String approverId,
			String approverName, List<Map<String, String>> json);

	void rejectApproverTwoTransactionTicket(String approverId,
			String approverName, List<Map<String, String>> json);

	void rejectApproverTwoTransactionCash(String approverId,
			String approverName, List<Map<String, String>> json);

}
