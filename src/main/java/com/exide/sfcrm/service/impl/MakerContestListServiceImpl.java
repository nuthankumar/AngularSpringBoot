package com.exide.sfcrm.service.impl;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;
import java.util.Set;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;

import com.exide.sfcrm.config.SmtpConfig;
import com.exide.sfcrm.constants.PropertyConstants;
import com.exide.sfcrm.controller.UserManagementController;
import com.exide.sfcrm.model.AgentWiseContestTicketView;
import com.exide.sfcrm.model.AgentWiseContestView;
import com.exide.sfcrm.model.MakerContestListView;
import com.exide.sfcrm.model.User;
import com.exide.sfcrm.repository.MakerAgentWiseContestListRepository;
import com.exide.sfcrm.repository.MakerAgentWiseContestTicketListRepository;
import com.exide.sfcrm.repository.MakerContestListRepository;
import com.exide.sfcrm.repository.TblTransactionCashRepository;
import com.exide.sfcrm.repository.TblTransactionTicketsRepository;
import com.exide.sfcrm.service.MakerContestListService;
import com.exide.sfcrm.service.UserManagementService;
import com.exide.sfcrm.util.CommonUtil;
import com.fasterxml.jackson.databind.ObjectMapper;

@Component
public class MakerContestListServiceImpl implements MakerContestListService {

	@Autowired
	private MakerContestListRepository makerContestListRepository;

	@Autowired
	private MakerAgentWiseContestListRepository makerAgentWiseContestListRepository;

	@Autowired
	private MakerAgentWiseContestTicketListRepository makerAgentWiseContestTicketListRepository;

	@Autowired
	private TblTransactionCashRepository transactionCashRepository;

	@Autowired
	private TblTransactionTicketsRepository tblTransactionTicketsRepository;

	@Autowired
	private ObjectMapper objectMapper;

	@Autowired
	private CommonUtil commonUtil;

	@Autowired
	private PropertyConstants propertyConstants;

	@Autowired
	private UserManagementController userManagementController;

	@Autowired
	private SmtpConfig smtpConfig;

	@Override
	public Map<String, Object> getMakerContestList(String userName,
			int pageNumber, int limit) throws Exception {
		int totalMakerContestListCount = makerContestListRepository
				.getMakerContestListCount(userName);
		List<MakerContestListView> maketContestList = makerContestListRepository
				.findAll(userName, pageNumber, propertyConstants.PAGE_LIMIT);
		Map<String, Object> data = new HashMap<String, Object>();
		data.put("makerContestListCount", totalMakerContestListCount);

		data.put("maketContestList", maketContestList);
		return data;
	}

	public List<AgentWiseContestView> getAgentWiseMakerContestList(
			String userName, String contestId) {
		Set<AgentWiseContestView> agentWiseMakerContestSet = makerAgentWiseContestListRepository
				.find(userName, Long.valueOf(contestId));
		List<AgentWiseContestView> agentWiseMakerContestList = new ArrayList<AgentWiseContestView>();
		agentWiseMakerContestSet.forEach(e -> agentWiseMakerContestList.add(e));
		return agentWiseMakerContestList;
	}

	@Override
	public int updateTransactionCashMaker(List<Map<String, String>> json,
			String makerId, String makerName) {
		Integer response = 0;
		String contestId = null;
		String agentNo = null;
		String remarks = null;

		for (Map<String, String> rows : json) {
			contestId = rows.get("contestId");
			agentNo = rows.get("agentNo");
			remarks = rows.get("remarks");
			response = transactionCashRepository.updateTblTransactionCashMaker(
					makerId, makerName, remarks, Integer.valueOf(contestId),
					agentNo);
		}

		return response;
	}

	@Override
	public int rejectTransactionCashMaker(List<Map<String, String>> json,
			String makerId, String makerName) {

		Integer response = 0;
		String contestId = null;
		String remarks = null;

		for (Map<String, String> rows : json) {
			contestId = rows.get("contestId");
			remarks = rows.get("remarks");
			response = transactionCashRepository.rejectTblTransactionCashMaker(
					makerId, makerName, remarks, Integer.valueOf(contestId));
		}
		return response;
	}

	@Override
	public Map<String, Object> getMakerContestTicketsList(String userId,
			Integer pageNumber, Integer limit) {
		int totalMakerContestTicketsList = makerContestListRepository
				.getMakerContestTicketsList(userId);
		List<MakerContestListView> makerContestTicketsList = makerContestListRepository
				.getMakerContestTicketsList(userId, pageNumber,
						propertyConstants.PAGE_LIMIT);
		Map<String, Object> data = new HashMap<String, Object>();
		data.put("totalMakerContestTicketsList", totalMakerContestTicketsList);
		data.put("makerContestTicketsList", makerContestTicketsList);
		return data;
	}

	@Override
	public List<AgentWiseContestTicketView> getMakerContestTicketsList(
			String userId, String contestId) {
		Set<AgentWiseContestTicketView> agentWiseContestTicketViewSet = makerAgentWiseContestTicketListRepository
				.getakerAgentWiseContestTicketsList(userId,
						Long.valueOf(contestId));
		List<AgentWiseContestTicketView> agentWiseMakerContestTicketList = new ArrayList<AgentWiseContestTicketView>();
		agentWiseContestTicketViewSet
				.forEach(e -> agentWiseMakerContestTicketList.add(e));
		return agentWiseMakerContestTicketList;

	}

	@Override
	public int updateTransactionTicketMaker(List<Map<String, String>> json,
			String makerId, String makerName) {

		Integer response = 0;
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
					.updateTblTransactionTicketsMaker(makerId, makerName,
							remarks, Integer.valueOf(contestId), agentNo,
							option, Integer.valueOf(ticketLists),
							Integer.valueOf(destid));
		}
		return response;
	}

	@Override
	public int rejectTransactionTicketMaker(List<Map<String, String>> json,
			String makerId, String makerName) {
		Integer response = 0;
		String contestId = null;
		String remarks = null;
		for (Map<String, String> rows : json) {
			contestId = rows.get("contestId");
			remarks = rows.get("remarks");
			response = tblTransactionTicketsRepository
					.rejectTransactionTicketMaker(makerId, makerName,
							Integer.valueOf(contestId), remarks);
		}
		return response;
	}

}
