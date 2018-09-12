package com.exide.sfcrm.service;

import java.text.ParseException;
import java.util.List;
import java.util.Map;
/**
 * 
 * @author vasavivr
 *
 */
public interface DeviationCashService  {


	
	Map<String, Object> getDeviationListCash(String userId, int pageNumber,
			int limit);

int updateTransactionCashDeviation(String deviationApprId, String deviationApprName,
			List<Map<String, String>> json);

int rejectTransactionCashDeviation(String deviationApprId,
		String deviationApprName, List<Map<String, String>> json);

void addDeviation(List<Map<String, String>> json, String string) throws ParseException;




}
