package com.exide.sfcrm.service;

import java.util.List;
import java.util.Map;

public interface ApproverThreeService {

	Map<String, Object> getApproverThreeContestList(String string,
			Integer offset, Integer limit);

	void updateTransactionCashApproverThree(String approverId,
			String approverName, List<Map<String, String>> json);

	void rejectApproverThreeTransactionCash(String approverId,
			String approverName, List<Map<String, String>> json);

}
