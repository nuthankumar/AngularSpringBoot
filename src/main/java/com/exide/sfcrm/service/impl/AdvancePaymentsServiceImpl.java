package com.exide.sfcrm.service.impl;

import java.util.HashMap;
import java.util.List;
import java.util.Map;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.exide.sfcrm.constants.PropertyConstants;
import com.exide.sfcrm.dao.AdvancePayDao;
import com.exide.sfcrm.model.AdvancePay;
import com.exide.sfcrm.model.AdvancePayCashView;
import com.exide.sfcrm.repository.TblAdvancePayRepository;
import com.exide.sfcrm.service.AdvancePaymentsService;

/**
 * 
 * @author vasavivr
 *
 */
@Service
public class AdvancePaymentsServiceImpl implements AdvancePaymentsService {

	@Autowired
	TblAdvancePayRepository advancePaymentsRepository;

	@Autowired
	PropertyConstants propertyConstants;

	@Autowired
	AdvancePayDao advancePaymentDao;

	@Override
	public Map<String, Object> getAdvancePayList(String userName,
			int pageNumber, int limit) {

		deleteTempTables();
		List<AdvancePayCashView> advancePayList = advancePaymentsRepository
				.TVFAdvanceAgentsLists(userName, pageNumber,
						propertyConstants.PAGE_LIMIT);
		Integer totalNumberOfadvancePayList = advancePaymentsRepository
				.getCountForAdvancePayList(userName);

		Map<String, Object> data = new HashMap<String, Object>();

		data.put("advancePayList", advancePayList);
		data.put("advancePayListCount", totalNumberOfadvancePayList);
		insertTmpAdvancePayCash(advancePayList);
		return data;

	}

	private void insertTmpAdvancePayCash(List<AdvancePayCashView> advancePayList) {
		advancePaymentDao.insertTmpAdvancePayCash(advancePayList);
	}

	/**
	 * 
	 */
	@Override
	public AdvancePay createAdvancePay(AdvancePay advancePay) throws Exception {
		return advancePaymentDao.createAdvancePay(advancePay);
	}

	@Override
	public int updateAdvancePayCash(String makerId, String makerName,
			List<Map<String, String>> json) {
		String agentNo = null;
		String advDate = null;
		Integer data = 0;
		for (Map<String, String> rows : json) {
			agentNo = rows.get("agentNo");
			advDate = rows.get("advDate");
			data = advancePaymentsRepository.updateAdvancePayMakerCash(makerId,
					makerName, Integer.valueOf(advDate), agentNo);
			deleteTempTables();
		}

		return data;
	}

	private void deleteTempTables() {

		advancePaymentsRepository.deleteTmptblAdvancePayCash();
	}

	@Override
	public Map<String, Object> getAdvancePayCheckerList(String userName,
			int pageNumber, int limit) {
		deleteTempTables();
		List<AdvancePayCashView> advancePayCheckerList = advancePaymentsRepository
				.TVFAdvanceAgentsListsChecker(userName, pageNumber,
						propertyConstants.PAGE_LIMIT);
		Integer totalNumberOfadvancePayCheckerList = advancePaymentsRepository
				.getCountForAdvancePayCheckerList(userName);

		Map<String, Object> data = new HashMap<String, Object>();

		data.put("advancePayCheckerList", advancePayCheckerList);
		data.put("advancePayCheckerListCount",
				totalNumberOfadvancePayCheckerList);
		insertTmpAdvancePayCheckerCash(advancePayCheckerList);
		return data;

	}

	private void insertTmpAdvancePayCheckerCash(
			List<AdvancePayCashView> advancePayCheckerList) {
		advancePaymentDao.insertTmpAdvancePayCheckerCash(advancePayCheckerList);

	}

	@Override
	public int updateAdvancePayCashChecker(String checkerId,
			String checkerName, List<Map<String, String>> json) {
		Integer data = 0;
		String agentNo = null;
		String advDate = null;
		for (Map<String, String> rows : json) {
			agentNo = rows.get("agentNo");
			advDate = rows.get("advDate");
			data = advancePaymentsRepository.updateAdvancePayCheckerCash(
					checkerId, checkerName, Integer.valueOf(advDate), agentNo);
			deleteTempTables();

		}
		return data;
	}

	@Override
	public void addAdvancePayments(List<Map<String, String>> json, String userId) {
		for (Map<String, String> rows : json) {
			String agentNo = rows.get("agentNo");
			String advDate = rows.get("advDate");
			String effStartDt = rows.get("effStartDt");
			String amount = rows.get("amount");
			String recoverable = rows.get("recoverable");
			String remarks = rows.get("remarks");
			String maxRecoverblePerCycle = rows.get("maxRecoverblePerCycle");
			String netBalance = rows.get("netBalance");
			String confAttchment = rows.get("confAttchment");
			callSp(userId, agentNo, advDate, effStartDt, amount, recoverable,
					remarks, maxRecoverblePerCycle, netBalance, confAttchment);
		}

	}

	private void callSp(String userId, String agentNo, String advDate,
			String effStartDt, String amount, String recoverable,
			String remarks, String maxRecoverblePerCycle, String netBalance,
			String confAttchment) {
		advancePaymentsRepository.executeAddAdvancePayments(userId, agentNo,
				Integer.valueOf(advDate), Integer.valueOf(effStartDt),
				Integer.valueOf(amount), Integer.valueOf(recoverable), remarks,
				Integer.valueOf(maxRecoverblePerCycle),
				Integer.valueOf(netBalance), confAttchment);

	}
}
