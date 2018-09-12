package com.exide.sfcrm.service.impl;

import java.util.HashMap;
import java.util.List;
import java.util.Map;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.exide.sfcrm.constants.PropertyConstants;
import com.exide.sfcrm.model.ApproverOneContestView;
import com.exide.sfcrm.model.ApproverOneTicketView;
import com.exide.sfcrm.repository.ApproverOneContestListRepository;
import com.exide.sfcrm.repository.ApproverOneTicketRepository;
import com.exide.sfcrm.repository.TblAdvancePayCashRepository;
import com.exide.sfcrm.repository.TblPRFGeneartedTicketsRepository;
import com.exide.sfcrm.repository.TblPRFGenratedCashRepository;
import com.exide.sfcrm.repository.TblTransactionCashRepository;
import com.exide.sfcrm.repository.TblTransactionTicketsRepository;
import com.exide.sfcrm.service.ApproverOneContestListService;
import com.exide.sfcrm.util.CommonUtil;

@Service
public class ApproverOneContestListServiceImpl implements
		ApproverOneContestListService {

	@Autowired
	private ApproverOneContestListRepository approverOneContestListRepository;

	@Autowired
	private PropertyConstants propertyConstants;

	@Autowired
	private TblTransactionCashRepository transactionCashRepository;

	@Autowired
	private TblAdvancePayCashRepository tblAdvancePayCashRepository;
	
	@Autowired
	private TblPRFGeneartedTicketsRepository tblPRFGeneartedTicketsRepository;

	@Autowired
	private TblPRFGenratedCashRepository tblPRFGenratedCashRepository;

	@Autowired
	private CommonUtil commonUtil;

	@Autowired
	private TblTransactionTicketsRepository tblTransactionTicketsRepository;

	@Autowired
	private ApproverOneTicketRepository approverOneTicketRepository;

	@Override
	public Map<String, Object> getApproverOneContestList(String userId,
			int pageNumber, int limit) {

		List<ApproverOneContestView> approverOneContestViewList = approverOneContestListRepository
				.getApproverOneContestList(userId,
						commonUtil.getOffset(pageNumber),
						propertyConstants.PAGE_LIMIT);
		Integer totalNoOfApprover1List = approverOneContestListRepository
				.getCashApprove1List(userId);

		Map<String, Object> data = new HashMap<String, Object>();
		data.put("approverOneContestViewList", approverOneContestViewList);
		data.put("approver1ListCount", totalNoOfApprover1List);
		return data;
	}

	@Override
	public void updateTransactionCashApproverOne(String approverId,
			String approverName, List<Map<String, String>> json) {

		String prfNoGenREF = null;
		String remarks = null;
		String prfNo = null;
		for (Map<String, String> rows : json) {
			prfNoGenREF = rows.get("prfNoGenREF");
			remarks = rows.get("remarks");
			prfNo = rows.get("prfNo");
			if (prfNo.contains("Advance")) {
				tblAdvancePayCashRepository
						.updateTransactionCashApproverOneAdvance(approverId,
								approverName, Integer.valueOf(prfNoGenREF), remarks);
				tblPRFGenratedCashRepository.updateTblPRFGenratedCashApproverOne(Integer.valueOf(prfNoGenREF));

			} else

				transactionCashRepository.updateTransactionCashApproverOne(
						approverId, approverName, Integer.valueOf(prfNoGenREF),
						remarks);
			tblPRFGenratedCashRepository.updateTblPRFGenratedCashApproverOne(Integer.valueOf(prfNoGenREF));

		}
		
	}

	@Override
	public List<Object> getApproverOnePRFGeneratedCash(Integer prfNoGenREF) {

		List<Object> approverOnePRFGeneratedCashList = tblPRFGenratedCashRepository
				.findByprfNoGenREF(prfNoGenREF);
		return approverOnePRFGeneratedCashList;
	}

	@Override
	public Map<String, Object> getApproveOneTickets(String userId,
			Integer pageNumber, Integer limit) {
		List<ApproverOneTicketView> approverOneTicketViewList = approverOneTicketRepository
				.getApproverOneTicketContestList(userId, pageNumber,
						propertyConstants.PAGE_LIMIT);
		Integer totalNoOfApprove1Ticket = approverOneTicketRepository
				.getTicketApprove1(userId);
		Map<String, Object> data = new HashMap<String, Object>();
		data.put("totalNoOfApprove1Ticket", totalNoOfApprove1Ticket);
		data.put("approverOneTicketViewList", approverOneTicketViewList);
		return data;
	}

	@Override
	public void updateApproverOneTransactionTicket(String approverId,
			String approverName, List<Map<String, String>> json) {
		String prfNoGenREF = null;
		String remarks = null;
		for (Map<String, String> rows : json) {
			prfNoGenREF = rows.get("prfNoGenREF");
			remarks = rows.get("remarks");
			tblTransactionTicketsRepository
					.updateTransactionTicketApproverOne(approverId,
							approverName, Integer.valueOf(prfNoGenREF), remarks);
			tblPRFGeneartedTicketsRepository.updateTransactionTicketApproverOne(Integer.valueOf(prfNoGenREF));
		}
		
	}

	@Override
	public void rejectApproverOneTransactionCash(String approverId,
			String approverName, List<Map<String, String>> json) {

		String prfNoGenREF = null;
		String remarks = null;
		String prfNo = null;
		for (Map<String, String> rows : json) {
			prfNoGenREF = rows.get("prfNoGenREF");
			remarks = rows.get("remarks");
			prfNo = rows.get("prfNo");
			if (prfNo.contains("Advance")) {
				tblAdvancePayCashRepository
						.rejectTransactionCashApproverOneAdvance(approverId,
								approverName, Integer.valueOf(prfNoGenREF), remarks);
				tblPRFGenratedCashRepository.rejectTblPRFGenratedCashApproverOne(Integer.valueOf(prfNoGenREF));

			} else

				transactionCashRepository.rejectTransactionCashApproverOne(
						approverId, approverName, Integer.valueOf(prfNoGenREF),
						remarks);
			tblPRFGenratedCashRepository.rejectTblPRFGenratedCashApproverOne(Integer.valueOf(prfNoGenREF));

		}
		
	}
	@Override
	public void rejectApproverOneTransactionTicket(String approverId,
			String approverName, List<Map<String, String>> json) {
		String prfNoGenREF = null;
		String remarks = null;
		for (Map<String, String> rows : json) {
			prfNoGenREF = rows.get("prfNoGenREF");
			remarks = rows.get("remarks");
			tblTransactionTicketsRepository
					.rejectTransactionTicketApproverOne(approverId,
							approverName, Integer.valueOf(prfNoGenREF), remarks);
			tblPRFGeneartedTicketsRepository.rejectTransactionTicketApproverOne(Integer.valueOf(prfNoGenREF));
		}
		
	}


}
