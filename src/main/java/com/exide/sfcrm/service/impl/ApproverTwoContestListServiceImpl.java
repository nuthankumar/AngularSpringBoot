package com.exide.sfcrm.service.impl;

import java.util.HashMap;
import java.util.List;
import java.util.Map;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.exide.sfcrm.constants.PropertyConstants;
import com.exide.sfcrm.model.ApproverOneTicketView;
import com.exide.sfcrm.model.ApproverTwoContestView;
import com.exide.sfcrm.model.ApproverTwoTicketView;
import com.exide.sfcrm.repository.ApproverTwoContestListRepository;
import com.exide.sfcrm.repository.ApproverTwoTicketRepository;
import com.exide.sfcrm.repository.TblAdvancePayCashRepository;
import com.exide.sfcrm.repository.TblPRFGeneartedTicketsRepository;
import com.exide.sfcrm.repository.TblPRFGenratedCashRepository;
import com.exide.sfcrm.repository.TblTransactionCashRepository;
import com.exide.sfcrm.repository.TblTransactionTicketsRepository;
import com.exide.sfcrm.service.ApproverTwoContestListService;
import com.exide.sfcrm.util.CommonUtil;

@Service
public class ApproverTwoContestListServiceImpl implements
		ApproverTwoContestListService {

	@Autowired
	ApproverTwoContestListRepository approverTwoContestListRepository;

	@Autowired
	TblTransactionCashRepository tblTransactionCashRepository;

	@Autowired
	TblPRFGenratedCashRepository tblPRFGenratedCashRepository;

	@Autowired
	TblTransactionTicketsRepository tblTransactionTicketsRepository;

	@Autowired
	ApproverTwoTicketRepository approverTwoTicketRepository;

	@Autowired
	TblAdvancePayCashRepository tblAdvancePayCashRepository;

	@Autowired
	private TblPRFGeneartedTicketsRepository tblPRFGeneartedTicketsRepository;

	@Autowired
	CommonUtil commonUtil;

	@Autowired
	PropertyConstants propertyConstants;

	@Override
	public Map<String, Object> getApproverTwoContestList(String userId,
			int pageNumber, int limit) {
		List<ApproverTwoContestView> approverTwoContestViewList = approverTwoContestListRepository
				.getApproverTwoContestList(userId, pageNumber,
						propertyConstants.PAGE_LIMIT);
		Integer totalNoOfApprover2List = approverTwoContestListRepository
				.getCashApprove2List(userId);
		Map<String, Object> data = new HashMap<String, Object>();
		data.put("approverTwoContestViewList", approverTwoContestViewList);
		data.put("approver2ListCount", totalNoOfApprover2List);
		return data;
	}

	@Override
	public void updateTransactionCashApproverTwo(String approverId,
			String approverName, List<Map<String, String>> json) {
		// TODO Auto-generated method stub
		String prfNoGenRef = null;
		String remarks = null;
		String prfNo = null;
		for (Map<String, String> rows : json) {
			prfNoGenRef = rows.get("prfNoGenRef");
			remarks = rows.get("remarks");
			prfNo = rows.get("prfNo");
			if (prfNo.contains("Advance")) {
				tblAdvancePayCashRepository.updateTransactionCashApproverTwo(
						approverId, approverName, remarks,
						Integer.valueOf(prfNoGenRef));
				tblPRFGenratedCashRepository
						.updateTblPRFGenratedCashApproverTwoAdvance(Integer
								.valueOf(prfNoGenRef));
			} else {
				tblTransactionCashRepository.updateTransactionCashApproverTwo(
						approverId, approverName, remarks,
						Integer.valueOf(prfNoGenRef));
				tblPRFGenratedCashRepository
						.updateTblPRFGenratedCashApproverTwo(Integer
								.valueOf(prfNoGenRef));
			}
		}

	}

	@Override
	public List<Object> getApproverTwoPRFGeneratedCash(int prfNoGenREF) {
		return tblPRFGenratedCashRepository.findByprfNoGenREF(prfNoGenREF);
	}

	@Override
	public Map<String, Object> getApproveTwoTickets(String userId,
			Integer pageNumber, Integer limit) {
		List<ApproverTwoTicketView> approverOneTicketViewList = approverTwoTicketRepository
				.getApproverTwoTicketContestList(userId, pageNumber,
						propertyConstants.PAGE_LIMIT);
		Integer totalNoOfApprove1Ticket = approverTwoTicketRepository
				.getTicketApprove2(userId);
		Map<String, Object> data = new HashMap<String, Object>();
		data.put("totalNoOfApprove1Ticket", totalNoOfApprove1Ticket);
		data.put("approverOneTicketViewList", approverOneTicketViewList);
		return data;
	}

	@Override
	public void updateApproverTwoTransactionTicket(String approverId,
			String approverName, List<Map<String, String>> json) {

		String prfNoGenREF = null;
		String remarks = null;
		for (Map<String, String> rows : json) {
			prfNoGenREF = rows.get("prfNoGenREF");
			remarks = rows.get("remarks");

			tblTransactionTicketsRepository.updateTransactionTicketApproverTwo(
					approverId, approverName, Integer.valueOf(prfNoGenREF),
					remarks);
			tblPRFGeneartedTicketsRepository
					.updateTransactionTicketApproverTwo(Integer
							.valueOf(prfNoGenREF));

		}
	}

	@Override
	public void rejectApproverTwoTransactionTicket(String approverId,
			String approverName, List<Map<String, String>> json) {
		String prfNoGenREF = null;
		String remarks = null;
		for (Map<String, String> rows : json) {
			prfNoGenREF = rows.get("prfNoGenREF");
			remarks = rows.get("remarks");
			tblTransactionTicketsRepository.rejectTransactionTicketApproverTwo(
					approverId, approverName, Integer.valueOf(prfNoGenREF),
					remarks);
			tblPRFGeneartedTicketsRepository
					.rejectTransactionTicketApproverTwo(Integer
							.valueOf(prfNoGenREF));
		}

	}

	@Override
	public void rejectApproverTwoTransactionCash(String approverId,
			String approverName, List<Map<String, String>> json) {
		String prfNoGenREF = null;
		String remarks = null;
		String prfNo=null;
		for (Map<String, String> rows : json) {
			prfNoGenREF = rows.get("prfNoGenREF");
			remarks = rows.get("remarks");
			prfNo = rows.get("prfNo");
			if (prfNo.contains("Advance")) {
				tblAdvancePayCashRepository.rejectTransactionCashApproverTwoAdvance(
						approverId, approverName, remarks,
						Integer.valueOf(prfNoGenREF));
				tblPRFGenratedCashRepository
						.rejectTblPRFGenratedCashApproverTwoAdvance(Integer
								.valueOf(prfNoGenREF));
			} else {
				tblTransactionCashRepository.rejectApproverTwoTransactionCash(
						approverId, approverName, remarks,
						Integer.valueOf(prfNoGenREF)); 
				tblPRFGenratedCashRepository
						.rejectTblPRFGenratedCashApproverTwo(Integer
								.valueOf(prfNoGenREF));
			}
		}

	}
}
	