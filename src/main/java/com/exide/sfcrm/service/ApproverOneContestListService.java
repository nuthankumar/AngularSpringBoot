package com.exide.sfcrm.service;

import java.util.List;
import java.util.Map;

public interface ApproverOneContestListService {

	/**
	 * This method is used to get the contest list for maker.
	 * 
	 * @param userName
	 * @return
	 */
	public Map<String, Object> getApproverOneContestList(String userId,
			int pageNumber, int limit);

	/**
	 * 
	 * @param approverId
	 * @param approverName
	 * @param json
	 */
	public void updateTransactionCashApproverOne(String approverId,
			String approverName, List<Map<String, String>> json);

	/**
	 * 
	 * @param prfNoGenREF
	 * @return
	 */
	public List<Object> getApproverOnePRFGeneratedCash(Integer prfNoGenREF);

	/**
	 * 
	 * @param userId
	 * @param pageNumber
	 * @param limit
	 * @return
	 */
	public Map<String, Object> getApproveOneTickets(String userId,
			Integer pageNumber, Integer limit);

	/**
	 * 
	 * @param approverId
	 * @param approverName
	 * @param json
	 */
	public void updateApproverOneTransactionTicket(String approverId,
			String approverName, List<Map<String, String>> json);

	/**
	 * 
	 * @param approverId
	 * @param approverName
	 * @param json
	 */
	public void rejectApproverOneTransactionCash(String approverId,
			String approverName, List<Map<String, String>> json);

	/**
	 * 
	 * @param approverId
	 * @param approverName
	 * @param json
	 */
	public void rejectApproverOneTransactionTicket(String approverId,
			String approverName, List<Map<String, String>> json);

}
