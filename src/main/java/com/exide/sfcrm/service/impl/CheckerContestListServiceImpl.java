package com.exide.sfcrm.service.impl;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;
import java.util.Set;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.exide.sfcrm.constants.PropertyConstants;
import com.exide.sfcrm.model.AgentWiseContestTicketView;
import com.exide.sfcrm.model.AgentWiseContestView;
import com.exide.sfcrm.model.MakerContestListView;
import com.exide.sfcrm.repository.CheckerAgentWiseContestListRepository;
import com.exide.sfcrm.repository.CheckerAgentWiseContestTicketListRepository;
import com.exide.sfcrm.repository.CheckerContestListRepository;
import com.exide.sfcrm.repository.TblTransactionCashRepository;
import com.exide.sfcrm.repository.TblTransactionTicketsRepository;
import com.exide.sfcrm.service.CheckerContestListService;
import com.exide.sfcrm.util.CommonUtil;

/**
 * 
 * @author vasavivr
 *
 */
@Service
public class CheckerContestListServiceImpl implements CheckerContestListService {

	@Autowired
	CheckerAgentWiseContestListRepository checkerAgentWiseContestListRepository;

	@Autowired
	CheckerAgentWiseContestTicketListRepository checkerAgentWiseContestTicketListRepository;

	@Autowired
	TblTransactionTicketsRepository tblTransactionTicketsRepository;

	@Autowired
	CheckerContestListRepository checkerContestListRepository;

	@Autowired
	private TblTransactionCashRepository transactionCashRepository;

	@Autowired
	CommonUtil commonUtil;

	@Autowired
	PropertyConstants propertyConstants;

	@Override
	public Map<String, Object> getCheckerContestList(String userName,
			int pageNumber, int limit) {
		// TODO Auto-generated method stub
		int totalCheckerListCount = checkerContestListRepository
				.getCheckerListCount(userName);

		List<MakerContestListView> checkerContestList = checkerContestListRepository
				.TVFUserWiseTdyContestListsCashCheker(userName, pageNumber,
						propertyConstants.PAGE_LIMIT);
		Map<String, Object> data = new HashMap<String, Object>();

		data.put("checkerContestList", checkerContestList);
		data.put("totalCheckerListCount", totalCheckerListCount);
		return data;
	}

	@Override
	public List<AgentWiseContestView> getAgentWiseCheckerContestList(
			String userName, String contestId) {
		List<AgentWiseContestView> agentWiseCheckerContestList = checkerAgentWiseContestListRepository
				.TVFTdyContestWiseagentsListsCashCheker(userName, contestId);
		return agentWiseCheckerContestList;
	}

	@Override
	public int updateTransactionCashChecker(String checkerId,
			String checkerName, List<Map<String, String>> json) {
		String contestId = null;
		String agentNo = null;
		String remarks = null;
		Integer response = 0;

		for (Map<String, String> rows : json) {
			contestId = rows.get("contestId");
			agentNo = rows.get("agentNo");
			remarks = rows.get("remarks");
			response = transactionCashRepository
					.updateTblTransactionCashChecker(checkerId, checkerName,
							remarks, Integer.valueOf(contestId), agentNo);
		}

		return response;
	}

	@Override
	public Map<String, Object> getCheckerContestTicketsList(String userId,
			Integer pageNumber, Integer limit) {
		int totalCheckerContestTicketsList = checkerContestListRepository
				.getMakerContestTicketsList(userId);
		List<MakerContestListView> checkerContestTicketsList = checkerContestListRepository
				.getMakerContestTicketsList(userId, pageNumber,
						propertyConstants.PAGE_LIMIT);
		Map<String, Object> data = new HashMap<String, Object>();
		data.put("totalCheckerContestListTicketsList",
				totalCheckerContestTicketsList);
		data.put("checkerContestTicketsList", checkerContestTicketsList);
		return data;
	}

	@Override
	public List<AgentWiseContestTicketView> getCheckerContestTicketsList(
			String userId, String contestId) {
		Set<AgentWiseContestTicketView> agentWiseContestTicketViewSet = checkerAgentWiseContestTicketListRepository
				.getcheckerAgentWiseContestTicketsList(userId,
						Long.valueOf(contestId));
		List<AgentWiseContestTicketView> agentWiseCheckerContestTicketList = new ArrayList<AgentWiseContestTicketView>();
		agentWiseContestTicketViewSet
				.forEach(e -> agentWiseCheckerContestTicketList.add(e));
		return agentWiseCheckerContestTicketList;
	}

	@Override
	public int updateTransactionTicketChecker(List<Map<String, String>> json,
			String checkerId, String checkerName) {

		Integer response = null;
		String contestId = null;
		String agentNo = null;
		String option = null;
		String ticketLists = null;
		String destid = null;
		String remarks = null;
		for (Map<String, String> rows : json) {
			contestId = rows.get("contestId");
			agentNo = rows.get("agentNo");
			option = rows.get("option");
			ticketLists = rows.get("ticketLists");
			destid = rows.get("destid");
			remarks = rows.get("remarks");
			response = tblTransactionTicketsRepository
					.updateTblTransactionTicketsChecker(checkerId, checkerName,
							remarks, Integer.valueOf(contestId), agentNo,
							option, Integer.valueOf(ticketLists),
							Integer.valueOf(destid));
		}
		return response;
	}

	@Override
	public int rejectTransactionCashChecker(List<Map<String, String>> json,
			String checkerId, String checkerName) {
		Integer response = 0;
		String contestId = null;
		String remarks = null;

		for (Map<String, String> rows : json) {
			contestId = rows.get("contestId");
			remarks = rows.get("remarks");
			response = transactionCashRepository
					.rejectTblTransactionCashChecker(checkerId, checkerName,
							remarks, Integer.valueOf(contestId));
		}
		return response;

	}

	@Override
	public int rejectTransactionTicketChecker(List<Map<String, String>> json,
			String checkerId, String checkerName) {
		Integer response = 0;
		String contestId = null;
		String remarks = null;

		for (Map<String, String> rows : json) {
			contestId = rows.get("contestId");
			remarks = rows.get("remarks");
			response = tblTransactionTicketsRepository
					.rejectTransactionTicketChecker(checkerId, checkerName,
							remarks, Integer.valueOf(contestId));
		}
	return response;

	
}
}
