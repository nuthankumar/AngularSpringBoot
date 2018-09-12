package com.exide.sfcrm.service;

import java.math.BigDecimal;
import java.util.List;
import java.util.Map;

import org.json.simple.parser.ParseException;

import com.exide.sfcrm.model.PRFListCashAdvanceView;
import com.exide.sfcrm.model.PRFListCashView;
import com.exide.sfcrm.model.PrfListTicketView;
import com.exide.sfcrm.model.TblPRFGeneratedCashView;
import com.exide.sfcrm.model.TblPRFGeneratedTicketView;
import com.exide.sfcrm.model.TblPRFGenratedCash;
import com.exide.sfcrm.model.TblPRFGenratedTickets;

public interface PRFListService {
	/**
	 * This method is used to get the PRFList details for type 'Cash'.
	 * 
	 * @param agentType
	 * @param userId
	 * @param offset
	 * @param limit
	 * @return
	 */

	public List<PRFListCashView> getPRFListCash(String agentType,
			String userId, int offset, int limit);

	/**
	 * This method is used to get agentTypeId from gentTypeName.
	 * 
	 * @param agentTypeName
	 * @return
	 */

	public BigDecimal getAgentTypeId(String agentTypeName);

	/**
	 * This method is used to advance amount details for type 'Cash'.
	 * 
	 * @param userId
	 * @return
	 */
	public List<PRFListCashAdvanceView> getPRFListCashAdvance(String userId);

	/**
	 * This method is used to insert the PRFList for type cash into temporary
	 * table.
	 * 
	 * @param prfCashList
	 */
	public void insertTmpPFRCashData(List<PRFListCashView> prfCashList);

	/**
	 * This method is used to generate the PRF.
	 * 
	 * @throws ParseException
	 */
	public void generatePRF(Map<String, Object> json, String userId);

	/**
	 * This method is used to generate the PRF for Tickets.
	 * 
	 * @throws ParseException
	 */
	public void generatePRFTicket(Map<String, Object> json, String userId);

	/**
	 * This method is used to the agent number for PRF list.
	 * 
	 * @return
	 */
	public List<String> getAgentTypes();

	/**
	 * This method is used to get the PRFGenRef number
	 * 
	 * @return
	 */
	public Integer getprfNoGen();

	/**
	 * This method is used to get the PRF pretext
	 * 
	 * @return
	 */

	public String getPrfPreText();

	/**
	 * This method is used to generate the PRF number.
	 * 
	 * @param agentTypes
	 * @param prfGenRef
	 * @return
	 */
	public String getPrfNo(String[] agentTypes, Integer prfGenRef);

	/**
	 * This method is used to get the Netpayout for the PRF
	 * 
	 * @return
	 */
	public List<Double> getNetPayout(String flag, String agentNo);

	/**
	 * This method is used to calculate the Net amount to be paid out after
	 * deductions in the PRF.
	 * 
	 * @return
	 */
	public Double getPrfAmount(String flag, String agentNo);

	/**
	 * This method is used to delete the temp tables
	 */
	public void deleteTempTables();

	public List<PrfListTicketView> getPRFListTicket(String agentType,
			String userId, int offset, int limit);

	public List<TblPRFGeneratedCashView> getPrfPrintListByNo(String prfNo,
			String uid);

	/**
	 * This method is used to get the list of agents for whom the prf needs to
	 * be generated for the contest type ticket
	 * 
	 * @param agentType
	 * @param userId
	 * @param offset
	 * @param limit
	 * @return
	 */
	public List<TblPRFGeneratedCashView> getPrfPrintList(String prfGENDate,
			String uid);

	/**
	 * 
	 * @param startDate
	 * @param endDate
	 * @param uid
	 * @return
	 */
	public List<TblPRFGeneratedCashView> getPrfPrintListByDate(
			String startDate, String endDate, String uid);

	/**
	 * 
	 * @param json
	 * @return
	 */
	public Integer updateUtrNo(List<Map<String, String>> json);

	/**
	 * 
	 * @return
	 */
	public List<String> getPrfPrintListGenerated();

	/**
	 * 
	 * @return
	 */
	public List<String> getPrfTicketListGenerated();


	/**
	 * 
	 * @param prfGENDate
	 * @param string
	 * @return
	 */
	public List<TblPRFGeneratedTicketView> getPrfTicketPrintList(
			String prfGENDate, String uid);
	
	/**
	 * 
	 * @param prfNo
	 * @param string
	 * @return
	 */

	public List<TblPRFGeneratedTicketView> getPrfTicketPrintListByNo(
			String prfNo, String uid);
	
/**
 * 
 * @param startDate
 * @param endDate
 * @param uid
 * @return
 */

	public List<TblPRFGeneratedTicketView> getPrfTicketPrintListByDate(
			String startDate, String endDate, String uid);

}
