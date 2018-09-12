package com.exide.sfcrm.service;

import java.util.List;
import java.util.Map;

import com.exide.sfcrm.model.AdvancePay;

/**
 * 
 * @author vasavivr
 *
 */

public interface AdvancePaymentsService {


	Map<String, Object> getAdvancePayList(String userName, int pageNumber,
			int limit);
	
	AdvancePay createAdvancePay(AdvancePay advancePay) throws Exception;

	int updateAdvancePayCash(String makerId, String makerName,
			List<Map<String, String>> json);

	Map<String, Object> getAdvancePayCheckerList(String userName, int pageNumber,
			int limit);

	int updateAdvancePayCashChecker(String checkerId, String checkerName,
			List<Map<String, String>> json);

	void addAdvancePayments(List<Map<String, String>> json, String userName);

	

}
