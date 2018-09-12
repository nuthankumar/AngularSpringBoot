package com.exide.sfcrm.service;

import java.util.List;
import java.util.Map;

import com.exide.sfcrm.model.AgentWiseContestTicketView;
import com.exide.sfcrm.model.AgentWiseContestView;

public interface MakerContestListService {

	/**
	 * This method is used to get the contest list for maker.
	 * 
	 * @param userName
	 * @return
	 * @throws Exception 
	 */
	public Map<String, Object> getMakerContestList(String userName,
			int pageNumber, int limit) throws Exception;

	/**
	 * This method is used to get agent wise contest list
	 * 
	 * @param userName
	 * @param contestId
	 * @return
	 */
	public List<AgentWiseContestView> getAgentWiseMakerContestList(
			String userName, String contestId);

	/**
	 * This method is used to update the transactionCash table for maker
	 * approval.
	 * 
	 * @param agentNo
	 * @param contestId
	 * @param remarks
	 * @param makerId
	 * @param makerName
	 * @return
	 */
	public int updateTransactionCashMaker(List<Map<String, String>> json,
			String makerId, String makerName);

	/**
	 * 
	 * @param json
	 * @param makerId
	 * @param makerName
	 * @return
	 */
	public int rejectTransactionCashMaker(List<Map<String, String>> json,
			String makerId, String makerName);

	/**
	 * 
	 * @param userId
	 * @param offset
	 * @param limit
	 * @return
	 */

	public Map<String, Object> getMakerContestTicketsList(String userId,
			Integer pageNumber, Integer limit);

	/**
	 * 
	 * @param string
	 * @param contestId
	 * @return
	 */

	public List<AgentWiseContestTicketView> getMakerContestTicketsList(
			String string, String contestId);

	/**
	 * 
	 * @param json
	 * @param makerId
	 * @param makerName
	 * @return
	 */
	public int updateTransactionTicketMaker(List<Map<String, String>> json,
			String makerId, String makerName);

	/**
	 * 
	 * @param json
	 * @param makerId
	 * @param makerName
	 * @return
	 */
	public int rejectTransactionTicketMaker(List<Map<String, String>> json,
			String makerId, String makerName);

}
