package com.exide.sfcrm.service.impl;

import java.util.HashMap;
import java.util.List;
import java.util.Map;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.exide.sfcrm.constants.PropertyConstants;
import com.exide.sfcrm.model.ApproverThreeContestView;
import com.exide.sfcrm.repository.ApproverThreeContestListRepository;
import com.exide.sfcrm.repository.TblPRFGenratedCashRepository;
import com.exide.sfcrm.repository.TblTransactionCashRepository;
import com.exide.sfcrm.service.ApproverThreeService;
import com.exide.sfcrm.util.CommonUtil;

@Service
public class ApproverThreeServiceImpl implements ApproverThreeService {

	@Autowired
	ApproverThreeContestListRepository approverThreeContestListRepository;
	@Autowired
	private PropertyConstants propertyConstants;

	@Autowired
	private TblTransactionCashRepository transactionCashRepository;

	@Autowired
	private TblPRFGenratedCashRepository tblPRFGenratedCashRepository;

	@Autowired
	private CommonUtil commonUtil;


	@Override
	public Map<String, Object> getApproverThreeContestList(String userId,
			Integer pageNumber, Integer limit) {
		List<ApproverThreeContestView> approverThreeContestCount = approverThreeContestListRepository
				.getApproverThreeContestList(userId,
						commonUtil.getOffset(pageNumber),
						propertyConstants.PAGE_LIMIT);
		Integer totalNoOfApprover3List = approverThreeContestListRepository
				.getApproverThreeContestListCount(userId);

		Map<String, Object> data = new HashMap<String, Object>();
		data.put("approverThreeContestCount", approverThreeContestCount);
		data.put("approver3ListCount", totalNoOfApprover3List);
		return data;
	}


	@Override
	public void updateTransactionCashApproverThree(String approverId,
			String approverName, List<Map<String, String>> json) {
		String prfNoGenREF = null;
		String remarks = null;
		for (Map<String, String> rows : json) {
			prfNoGenREF = rows.get("prfNoGenREF");
			remarks = rows.get("remarks");

			transactionCashRepository.updateTransactionCashApproverThree(
					approverId, approverName, Integer.valueOf(prfNoGenREF),
					remarks);
			tblPRFGenratedCashRepository
					.updateTblPRFGenratedCashApproverThree(Integer
							.valueOf(prfNoGenREF));

		}
	}
		
	


	@Override
	public void rejectApproverThreeTransactionCash(String approverId,
			String approverName, List<Map<String, String>> json) {
		String prfNoGenREF = null;
		String remarks = null;
		for (Map<String, String> rows : json) {
			prfNoGenREF = rows.get("prfNoGenREF");
			remarks = rows.get("remarks");
			transactionCashRepository.rejectTransactionCashApproverThree(
					approverId, approverName, Integer.valueOf(prfNoGenREF),
					remarks);
			tblPRFGenratedCashRepository
					.rejectTblPRFGenratedCashApproverThree(Integer
							.valueOf(prfNoGenREF));
		}
	}
		
	


}
