package com.exide.sfcrm.service.impl;

import java.text.ParseException;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.Iterator;
import java.util.List;
import java.util.Map;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.exide.sfcrm.constants.PropertyConstants;
import com.exide.sfcrm.dao.DeviationListDao;
import com.exide.sfcrm.model.DeviationTicketsView;
//import com.exide.sfcrm.pojo.DeviationTicketViewPojo;
import com.exide.sfcrm.repository.DeviationTicketsRepository;
import com.exide.sfcrm.repository.TblTransactionTicketsRepository;
import com.exide.sfcrm.service.DeviationTicketsService;
import com.exide.sfcrm.util.CommonUtil;

/**
 * 
 * @author vasavivr
 *
 */

@Service
public class DeviationTicketsServiceImpl implements DeviationTicketsService {

	@Autowired
	DeviationTicketsRepository deviationTicketsRepository;

	@Autowired
	PropertyConstants propertyConstants;

	@Autowired
	private DeviationListDao deviationListDao;

	// @Autowired
	// private DeviationTicketViewPojo deviationTicketViewPojo;

	@Autowired
	TblTransactionTicketsRepository tblTransactionTicketsRepository;

	@Autowired
	CommonUtil commonUtil;

	@Override
	public Map<String, Object> getDeviationTicketsList(String userId,
			Integer pageNumber, Integer limit) {
		// deleteTempTables();
		List<DeviationTicketsView> deviationTicketsList = deviationTicketsRepository
				.getDeviationTicketsList(userId, pageNumber,
						propertyConstants.PAGE_LIMIT);
		Integer totalCountOfdeviationCash = deviationTicketsRepository
				.getDeviationTicketsCount(userId);
		Map<String, Object> data = new HashMap<String, Object>();
		data.put("totalCountOfdeviationCash", totalCountOfdeviationCash);
		data.put("deviationTicketsList", deviationTicketsList);
		insertTmpDeviationTicketData(deviationTicketsList);
		return data;
	}

	private void deleteTempTables() {

		deviationTicketsRepository.deleteTmptblTicketsDeviation();
	}

	private void insertTmpDeviationTicketData(
			List<DeviationTicketsView> deviationTicketsList) {

		deviationListDao.insertTmpDeviationTicketData(deviationTicketsList);
	}

	@Override
	public int updateTransactionTicketDeviation(String deviationApprId,
			String deviationApprName, List<Map<String, String>> json) {
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
		}
		return tblTransactionTicketsRepository
				.updateTransactionTicketsDeviation(deviationApprId,
						deviationApprName, remarks, Integer.valueOf(contestId),
						agentNo, option, Integer.valueOf(ticketLists),
						Integer.valueOf(destid));
	}

	@Override
	public int rejectTransactionTicketsDeviation(String deviationApprId,
			String deviationApprName, List<Map<String, String>> json) {
		String contestId = null;
		String agentNo = null;
		String ticketLists = null;
		String destid = null;
		String remarks = null;
		for (Map<String, String> rows : json) {
			contestId = rows.get("contestId");
			agentNo = rows.get("agentNo");
			ticketLists = rows.get("ticketLists");
			destid = rows.get("destid");
			remarks = rows.get("remarks");
		}
		return tblTransactionTicketsRepository
				.rejectTransactionTicketsDeviation(deviationApprId,
						deviationApprName, remarks, Integer.valueOf(contestId),
						agentNo, Integer.valueOf(ticketLists),
						Integer.valueOf(destid));
	}

	@Override
	public void addDeviation(List<Map<String, String>> json, String userId) throws NumberFormatException, ParseException {
		for (Map<String, String> rows : json) {
			String contestId = rows.get("contestId");
			String agentNo = rows.get("agentNo");
			String contestName = rows.get("contestName");
			String startDate = rows.get("startDate");
			String endDate = rows.get("endDate");
			String loadDate = rows.get("loadDate");
			String destid = rows.get("destid");
			String qualifiedTicketCount = rows.get("qualifiedTicketCount");
			String qualifiedCashCount = rows.get("qualifiedCashCount");
			String ticketValue = rows.get("ticketValue");
			String cashValue = rows.get("cashValue");
			String paidTicketCount = rows.get("paidTicketCount");
			String paidCashCount = rows.get("paidCashCount");
			String allpaidCount = rows.get("allpaidCount");
			String additional = rows.get("additional");
			String recover = rows.get("recover");
			String attachment = rows.get("attachment");
			String remarks = rows.get("remarks");

			callSp(userId, contestId, agentNo, contestName, startDate, endDate,
					loadDate, destid, qualifiedTicketCount, qualifiedCashCount,
					ticketValue, cashValue, paidTicketCount, paidCashCount,
					allpaidCount, additional, recover, attachment, remarks);
		}

	}

	private void callSp(String userId, String contestId, String agentNo,
			String contestName, String startDate, String endDate,
			String loadDate, String destid, String qualifiedTicketCount,
			String qualifiedCashCount, String ticketValue, String cashValue,
			String paidTicketCount, String paidCashCount, String allpaidCount,
			String additional, String recover, String attachment, String remarks)
			throws NumberFormatException, ParseException {
		int startdt = Integer.parseInt(commonUtil.getDateFormat(startDate));
		int enddt = Integer.parseInt(commonUtil.getDateFormat(endDate));
		tblTransactionTicketsRepository.executeDeviationTicket(userId,
				Integer.valueOf(contestId), agentNo, contestName, startdt,
				enddt, Integer.valueOf(loadDate), Integer.valueOf(destid),
				Float.valueOf(qualifiedTicketCount),
				Float.valueOf(qualifiedCashCount), Float.valueOf(ticketValue),
				Float.valueOf(cashValue), Float.valueOf(paidTicketCount),
				Float.valueOf(paidCashCount), Float.valueOf(allpaidCount),
				Boolean.valueOf(additional), Boolean.valueOf(recover),
				attachment, remarks);
	}

	@Override
	public List<Object> deviationTicketCount(Integer contestId, String agentNo,
			Integer destid) {

		List<Object> deviationTicketCount = (List<Object>) tblTransactionTicketsRepository
				.executeDeviationTicketCount(contestId, agentNo, destid);

		Iterator itr = deviationTicketCount.iterator();

		List<Object> deviationTicketCountList = new ArrayList<>();
		while (itr.hasNext()) {
			Object[] obj = (Object[]) itr.next();
			HashMap<String, Object> hm = new HashMap<String, Object>();
			hm.put("paidTicketCount", String.valueOf(obj[0]));
			hm.put("paidCashCount", String.valueOf(obj[1]));
			hm.put("allpaidCount", String.valueOf(obj[2]));
			deviationTicketCountList.add(hm);

		}

		return deviationTicketCountList;
	}

}
