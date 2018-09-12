/**
 * 
 */
package com.exide.sfcrm.service.impl;

import java.math.BigDecimal;
import java.sql.Date;
import java.util.ArrayList;
import java.util.Calendar;
import java.util.HashSet;
import java.util.List;
import java.util.Map;
import java.util.Set;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.exide.sfcrm.constants.ApplicationConstants;
import com.exide.sfcrm.constants.PropertyConstants;
import com.exide.sfcrm.dao.PRFListDao;
import com.exide.sfcrm.model.PRFListCashAdvanceView;
import com.exide.sfcrm.model.PRFListCashView;
import com.exide.sfcrm.model.PrfListTicketView;
import com.exide.sfcrm.model.TblPRFGeneratedCashView;
import com.exide.sfcrm.model.TblPRFGeneratedTicketView;
import com.exide.sfcrm.repository.AgentListRepository;
import com.exide.sfcrm.repository.PRFListCashAdvanceRepository;
import com.exide.sfcrm.repository.PRFListCashRepository;
import com.exide.sfcrm.repository.PrfListTicketRepository;
import com.exide.sfcrm.repository.TblPRFGeneartedTicketsRepository;
import com.exide.sfcrm.repository.TblPRFGeneratedCashViewRepository;
import com.exide.sfcrm.repository.TblPRFGeneratedTicketViewRepository;
import com.exide.sfcrm.repository.TblPRFGenratedCashRepository;
import com.exide.sfcrm.repository.TblTransactionCashRepository;
import com.exide.sfcrm.service.PRFListService;
import com.exide.sfcrm.util.CommonUtil;

/**
 * @author neethub
 *
 */
@Service
public class PRFListServiceImpl implements PRFListService {


	@Autowired
	private PRFListCashRepository prfListCashRepository;

	@Autowired
	private PRFListCashAdvanceRepository prfListCashAdvanceRepository;

	@Autowired
	private PrfListTicketRepository prfListTicketRepository;

	@Autowired
	private TblPRFGeneartedTicketsRepository tblPRFGeneartedTicketsRepository;
	
	
	@Autowired
	private TblPRFGeneratedTicketViewRepository tblPRFGeneratedTicketViewRepository;

	@Autowired
	private TblPRFGeneratedCashViewRepository tblPRFGeneratedCashViewRepository;

	@Autowired
	private PRFListDao prfListDao;

	@Autowired
	private TblTransactionCashRepository tblTransactionCashRepository;
	
	@Autowired
	private AgentListRepository agentListRepository;
	
	@Autowired
	private CommonUtil commonUtil;
	
	@Autowired
	private TblPRFGenratedCashRepository tblPRFGenratedCashRepository;
	

	@Autowired
	private PropertyConstants propertyConstants;

	@Override
	public List<PRFListCashView> getPRFListCash(String agentTypes,
			String userId, int offset, int limit) {
		Set<PRFListCashView> cashList = new HashSet<PRFListCashView>(); 
		String[] agentTypeArray = agentTypes.split(",");
		for (String agType : agentTypeArray) {
			
			BigDecimal id = getAgentTypeId(agType);
			List<PRFListCashView> tempList = prfListCashRepository.getPRFListCash(
					userId, Integer.parseInt(id.toString()));
			deleteTempTables();
			insertTmpPFRCashData(tempList);
			cashList.addAll(tempList);
		}
		List<PRFListCashView> list = convertSetToList(cashList);
		return list;
	}

	private List<PRFListCashView> convertSetToList(Set<PRFListCashView> cashList) {
		List<PRFListCashView> list = new ArrayList<PRFListCashView>();
		for (PRFListCashView prfListCashView : cashList) {
			list.add(prfListCashView);
		}
		return list;
	}

	@Override
	public BigDecimal getAgentTypeId(String agentTypeName) {
		return prfListCashRepository.getAgentTypeId(agentTypeName);
	}

	@Override
	public List<PRFListCashAdvanceView> getPRFListCashAdvance(String userId) {
		return prfListCashAdvanceRepository.getPRFListCashAdvance(userId);
	}

	@Override
	public void insertTmpPFRCashData(List<PRFListCashView> prfCashList) {
		prfListDao.insertTmpPFRCashData(prfCashList);
	}

	@Override
	public Integer getprfNoGen() {
		return prfListCashRepository.getprfNoGenREF();
	}

	@Override
	public String getPrfPreText() {
		return prfListCashRepository.getprfPreText();
	}

	@Override
	public String getPrfNo(String[] agentTypes,Integer prfGenRef) {
		
		String prfpretext = getPrfPreText();
		String formatted = String.format("%04d", prfGenRef);
		String AGTYPE = null;
		for (String agType : agentTypes) {
			if (agType != null) {
				AGTYPE = agType;
			} else {
				AGTYPE = ApplicationConstants.DEFAULT_AGENT_TYPE;
			}
		}
		Calendar now = Calendar.getInstance();
		int year = now.get(Calendar.YEAR);
		StringBuilder sb = new StringBuilder();
		sb.append(prfpretext).append(AGTYPE).append("/").append(year)
				.append("/").append(formatted);
		return sb.toString();

	}

	@Override
	public List<Double> getNetPayout(String flag,String agentNo) {
		if (flag.equals("positive")) {
			return prfListCashRepository.getNetPayoutForPositiveTransaction();
		}
		else if (flag.equals("negative")){
			return prfListCashRepository.getNetPayoutForNegativeTransaction();
		} else {
			return prfListCashRepository.getNetPayoutForPositiveTransactionType9(agentNo);
		}
	}

	public Double getPrfAmount(String flag,String agentNo) {
		List<Double> netpayout = getNetPayout(flag,agentNo);
		Double sum = 0.0;
		for (Double netPay : netpayout) {
			sum += netPay;
		}
		if (flag.equals("positive") || flag.equals("") ) {
			return sum;
		} else if (flag.equals("negative")){
			return -1 * sum;
		} else {
			return sum;
		}
		
	}

	@Override
	public List<String> getAgentTypes() {
		 List<String> agentTypes = prfListCashRepository.getAgentTypes();
		 return agentTypes;
	}

	@Override
	public void generatePRF(Map<String,Object> json, String userId) {

		String[] agentTypeArray =  json.get("agentTypes").toString().split(",");
        List<Map<String,Object>> recordMap =  (List<Map<String,Object>>) json.get("selectedRecords");
        for (Map<String, Object> map : recordMap) {
        	String agentNo = (String) map.get("agentNo");
        	String comment  = (String) map.get("prfComment");
        	Integer agentId = (Integer) map.get("agId");
        	Integer transAutoId = (Integer) map.get("transAutoId");
        	markSelectedRecordTblTransactionCash(transAutoId);
        	callSP(comment, agentId, userId, agentNo, agentTypeArray,transAutoId);
        	
		}
	}

	private void markSelectedRecordTblTransactionCash(Integer transAutoId) {
		prfListCashRepository.updateTblTransactionCashForSelectedRecord(transAutoId);
		prfListCashRepository.updatetmptblPRFListCashSelectRecord(transAutoId);
	}
	
	private void markUnSelectRecordTblTransactionCash(Integer transAutoId) {
		prfListCashRepository.updateTblTransactionCashForUnSelectRecord(transAutoId);
	}
	
	private void markUnSelectedRecordtblPrfListCash(Integer transAutoId) {
		prfListCashRepository.updatetmptblPRFListCashUnSelectRecord(transAutoId);
	}

	private void callPrfRecoverableCash(String userId, Integer agentType,String prfNumber,String prfGenRef,String prfComment,Float prfAmount,String agentNo){
		prfListCashRepository.executePrfRecoverbleCash(userId, agentType, prfNumber,agentNo,
				String.valueOf(prfGenRef), prfComment, prfAmount.floatValue());
	}

	@Override
	public void deleteTempTables() {
		prfListCashRepository.deleteTmptblPRFListCash();
		//prfListCashRepository.deleteTbltmpPRFGenSupportTbl();
		
	}
	
	private void callSP(String comment,Integer agentTypeId,String userId,String agentNo,String[] agentTypeArray,Integer transAutoId){
		Integer prfGenRef = getprfNoGen();
		Double prfAmount = 0.0;
		String pfrNumber = getPrfNo(agentTypeArray,prfGenRef);
		if (agentTypeArray != null && agentTypeArray.length > 0) {
		
		for (String agentType : agentTypeArray) {
			
			if (agentTypeId != 9) {
				if (prfListCashRepository.getCountOfPositiveNetAmount() > 0) {
					prfAmount = getPrfAmount("positive",agentNo);
				    prfListCashRepository.executePrfCompleteCashPositive(pfrNumber,agentNo ,String.valueOf(prfGenRef), comment, agentType, prfAmount.floatValue());
				    callPrfRecoverableCash(userId, agentTypeId, pfrNumber, String.valueOf(prfGenRef), comment, prfAmount.floatValue(),agentNo);
				    prfListCashRepository.updateTblPrfGeneratedCash(agentListRepository.getCidFromAgType(agentType));
				    markUnSelectRecordTblTransactionCash(transAutoId);
				} else if (prfListCashRepository.getCountOfPositiveNetAmount() > 0) {
					prfAmount = getPrfAmount("negative",agentNo);
					prfListCashRepository.executePrfCompleteCashNegative(userId, agentTypeId, pfrNumber,agentNo,
							String.valueOf(prfGenRef), comment, prfAmount.floatValue());
					callPrfRecoverableCash(userId, agentTypeId, pfrNumber,String.valueOf(prfGenRef), comment, prfAmount.floatValue(),agentNo);
					markUnSelectRecordTblTransactionCash(transAutoId);
				} 
				
			} else if (agentTypeId == 9) {
				prfAmount = getPrfAmount("",agentNo);
				prfListCashRepository.executeAdvancePaymentCash(pfrNumber, String.valueOf(prfGenRef), comment, prfAmount.floatValue());
				Integer cid = agentListRepository.getCidFromAgType(agentType);
				prfListCashRepository.executePRFTypeAdvance(pfrNumber, String.valueOf(prfGenRef), comment, String.valueOf(agentTypeId),cid , prfAmount.floatValue());
				markUnSelectedRecordtblPrfListCash(transAutoId);
			}
			deleteTempTables();
			
	   }
		}
	}
	
	@Override
	public void generatePRFTicket(Map<String, Object> json, String userId) {
		
		String[] agentTypeArray =  json.get("agentTypes").toString().split(",");
		
        @SuppressWarnings("unchecked")
		List<Map<String,Object>> recordMap =  (List<Map<String,Object>>) json.get("selectedRecords");
        for (Map<String, Object> map : recordMap) {

        	String comment  = (String) map.get("prfComment");
        	String agentNo = (String) map.get("agentNo");
        	
        	for(String agentType : agentTypeArray){
        		
        		prfListTicketRepository.generatePrfForTickets(comment, agentType, userId, agentNo);
        	}
		}
		
	}

	@Override
	public List<PrfListTicketView> getPRFListTicket(String agentTypes,
			String userId, int offset, int limit) {

		List<PrfListTicketView> list = null;
		String[] agentTypeArray = agentTypes.split(",");
		for (String agType : agentTypeArray) {
			
			BigDecimal id = getAgentTypeId(agType);
			list = prfListTicketRepository.getPRFListTicket(
					userId, Integer.parseInt(id.toString()));
			
		}
		return list;
	
	}

	@Override
	public List<TblPRFGeneratedCashView> getPrfPrintList(String prfGENDate,
			String uid) {
		Integer id = getCid(uid);
		String prfGENDates = prfGENDate.replace("/", "");
		List<TblPRFGeneratedCashView> prfListByprfgenDate = tblPRFGeneratedCashViewRepository
				.findByPrfGENDate(Integer.valueOf(prfGENDates), id);

		return prfListByprfgenDate;
	}

	private Integer getCid(String uid) {

		return tblPRFGeneratedCashViewRepository.findByCid(uid);
	}

	@Override
	public List<TblPRFGeneratedCashView> getPrfPrintListByNo(String prfNo,
			String uid) {
		Integer id = getCid(uid);

		List<TblPRFGeneratedCashView> prfListByprfgenNo = tblPRFGeneratedCashViewRepository
				.findByPrfNo(prfNo, id);

		return prfListByprfgenNo;
	}

	@Override
	public List<TblPRFGeneratedCashView> getPrfPrintListByDate(
			String startDate, String endDate, String uid) {
		String startDates = startDate.replace("/", "");
		String endDates = endDate.replace("/", "");
		Integer id = getCid(uid);
		List<TblPRFGeneratedCashView> prfListByDate = tblPRFGeneratedCashViewRepository
				.findByDate(Integer.valueOf(startDates),
						Integer.valueOf(endDates), id);
		return prfListByDate;
	}

	@Override
	public Integer updateUtrNo(List<Map<String, String>> json) {
		Integer response = 0;
		String agentNo = null;
		String prfNoGenREF = null;
		String utrNo = null;
		String transferDate = null;
		for (Map<String, String> rows : json) {
			agentNo = rows.get("agentNo");
			prfNoGenREF = rows.get("prfNoGenREF");
			utrNo = rows.get("utrNo");
			transferDate = rows.get("transferDate");
			response = tblPRFGenratedCashRepository.updateUtrNo(utrNo,
					Date.valueOf(transferDate), Integer.valueOf(prfNoGenREF),
					agentNo);
		}
		return response;
	}

	@Override
	public List<String> getPrfPrintListGenerated() {
		List<String> prfList = tblPRFGenratedCashRepository.findByprfNo();
		return prfList;
	}

	@Override
	public List<String> getPrfTicketListGenerated() {
		List<String> prfList = tblPRFGeneartedTicketsRepository.findByprfNo();
		return prfList;
	}

	@Override
	public List<TblPRFGeneratedTicketView> getPrfTicketPrintList(
			String prfGENDate, String uid) {
		Integer id = getCid(uid);
		String prfGENDates = prfGENDate.replace("/", "");
		List<TblPRFGeneratedTicketView> prfListByprfTicketgenDate = tblPRFGeneratedTicketViewRepository
				.findByPrfGENDate(Integer.valueOf(prfGENDates), id);
		return prfListByprfTicketgenDate;
	}

	@Override
	public List<TblPRFGeneratedTicketView> getPrfTicketPrintListByNo(
			String prfNo, String uid) {
		Integer id = getCid(uid);
		List<TblPRFGeneratedTicketView> prfListByprfgenNo = tblPRFGeneratedTicketViewRepository
				.findByPrfNo(prfNo, id);
		return prfListByprfgenNo;
	}


	@Override
	public List<TblPRFGeneratedTicketView> getPrfTicketPrintListByDate(
			String startDate, String endDate, String uid) {
		String startDates = startDate.replace("/", "");
		String endDates = endDate.replace("/", "");
		Integer id = getCid(uid);
		List<TblPRFGeneratedTicketView> prfListByDate = tblPRFGeneratedTicketViewRepository
				.findByDate(Integer.valueOf(startDates),
						Integer.valueOf(endDates), id);
		return prfListByDate;
	}


	
}
