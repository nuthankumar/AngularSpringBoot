package com.exide.sfcrm.service;

import java.util.List;
import java.util.Map;

import com.exide.sfcrm.model.AgentWiseContestTicketView;
import com.exide.sfcrm.model.AgentWiseContestView;

/**
 * 
 * @author vasavivr
 *
 */
public interface CheckerContestListService {

	/**
	 * This method is used to get checker contest list
	 * 
	 * @param userName
	 * @return
	 */
	Map<String, Object> getCheckerContestList(String userName, int pageNumber,
			int limit);

	/**
	 * This method is used to get agent wise checker contest list
	 * 
	 * @param userName
	 * @param contestId
	 * @return
	 */
	List<AgentWiseContestView> getAgentWiseCheckerContestList(String userName,
			String contestId);

	/**
	 * This method is used to update the transactionCash table for checker
	 * approval.
	 * 
	 * @param agentNo
	 * @param contestId
	 * @param remarks
	 * @param checkerId
	 * @param checkerName
	 * @return
	 */
	public int updateTransactionCashChecker(String checkerId,
			String checkerName, List<Map<String, String>> json);

	/**
	 * 
	 * @param userId
	 * @param offset
	 * @param pAGE_LIMIT
	 * @return
	 */
	Map<String, Object> getCheckerContestTicketsList(String userId,
			Integer pageNumber, Integer limit);

	/**
	 * 
	 * @param userId
	 * @param contestId
	 * @return
	 */

	List<AgentWiseContestTicketView> getCheckerContestTicketsList(
			String userId, String contestId);
/**
 * 
 * @param json
 * @param checkerId
 * @param checkerName
 * @return
 */
	int updateTransactionTicketChecker(List<Map<String, String>> json,
			String checkerId, String checkerName);
/**
 * 
 * @param json
 * @param checkerId
 * @param checkerName
 * @return
 */
	int rejectTransactionCashChecker(List<Map<String, String>> json,
			String checkerId, String checkerName);
/**
 * 
 * @param json
 * @param checkerId
 * @param checkerName
 * @return
 */

int rejectTransactionTicketChecker(List<Map<String, String>> json,
		String checkerId, String checkerName);


}
