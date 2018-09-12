/**
 * 
 */
package com.exide.sfcrm.controller;

import java.util.List;
import java.util.Map;

import org.apache.log4j.Logger;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.ResponseBody;

import com.exide.sfcrm.constants.ApplicationConstants;
import com.exide.sfcrm.constants.MessageConstants;
import com.exide.sfcrm.constants.PropertyConstants;
import com.exide.sfcrm.model.ServiceResponse;
import com.exide.sfcrm.repository.ApproverOneContestListRepository;
import com.exide.sfcrm.service.ApproverOneContestListService;
import com.exide.sfcrm.service.AuditLogService;
import com.exide.sfcrm.util.CommonUtil;
import com.fasterxml.jackson.core.JsonProcessingException;
import com.fasterxml.jackson.databind.ObjectMapper;

/**
 * @author neethub
 *
 */
@Controller
public class ApproverOneController {

	/**
	 * Logger.
	 */
	private static final Logger LOGGER = Logger
			.getLogger(ApproverOneController.class);
	@Autowired
	ObjectMapper objectMapper;

	@Autowired
	private ApproverOneContestListService approverOneContestListService;

	@Autowired
	private AuditLogService activityLogService;

	@Autowired
	private CommonUtil commonUtil;

	@Autowired
	private ApproverOneContestListRepository approverOneContestListRepository;

	@Autowired
	private PropertyConstants propertyConstants;

	/**
	 * This method is used to get the approver one contest list.
	 * 
	 * @param offset
	 * @param limit
	 * @return
	 */
	@RequestMapping(value = { "/approverOneContestList" }, method = RequestMethod.GET)
	@ResponseBody
	public String getApproverOneContestList(
			@RequestParam(value = "pageNumber") int pageNumber) {
		String response = null;
		try {

			Map<String, Object> data = approverOneContestListService
					.getApproverOneContestList("neethub",
							commonUtil.getOffset(pageNumber),
							propertyConstants.PAGE_LIMIT);
			ServiceResponse<Map<String, Object>> serviceResponse = new ServiceResponse<Map<String, Object>>();
			serviceResponse.setData(data);
			serviceResponse.setSuccess(ApplicationConstants.TRUE);
			serviceResponse.setMessage(MessageConstants.SUCCESS_RESPONSE);
			response = objectMapper.writeValueAsString(serviceResponse);
			activityLogService
					.addActivity(
							"Get agent details",
							"Success",
							"Get approverOne ContestList request completed successfully",
							data.toString(), commonUtil.getUserName());
		} catch (Exception e) {
			LOGGER.error(
					"Error occured while getting approverOne ContestList details "
							+ e, e);
			ServiceResponse<String> serviceResponse = new ServiceResponse<String>();
			serviceResponse.setData(null);
			serviceResponse.setMessage(MessageConstants.EXCEPTION_RESPONSE);
			serviceResponse.setSuccess(ApplicationConstants.FALSE);
			try {
				response = objectMapper.writeValueAsString(serviceResponse);
			} catch (JsonProcessingException e1) {
				LOGGER.error(
						"Error occured while converting response object in catch block of get approverOne ContestList details"
								+ e1, e1);
				activityLogService
						.addActivity(
								"get approverOne ContestList details",
								"Success",
								"Get approverOne ContestList details request completed successfully",
								"", commonUtil.getUserName());
			}
		}
		return response;

	}

	@RequestMapping(value = { "/updateApproverOneTransactionCash" }, method = RequestMethod.PUT)
	@ResponseBody
	public String updateApproverOneTransactionCash(
			@RequestBody List<Map<String, String>> json) {
		/*
		 * http://localhost:8090/SFCRM/updateApproverOneTransactionCash?remarks=
		 * Approved&prfNoGenRef=2
		 */String response = null;
		try {
			String approverId = "NULL", approverName = "NULL";
			 approverOneContestListService
					.updateTransactionCashApproverOne(approverId, approverName,
							json);
			response = commonUtil.serviceResponse(MessageConstants.SUCCESS,
					ApplicationConstants.TRUE, null);
			activityLogService.addActivity("Update approval one ", "Success",
					"Updating approval one completed successfully",
					response.toString(), commonUtil.getUserName());
		} catch (Exception e) {
			LOGGER.error(
					"Error occured while updating approverOne Transaction Cash details "
							+ e, e);
			try {
				response = commonUtil.serviceResponse(
						MessageConstants.EXCEPTION_RESPONSE,
						ApplicationConstants.FALSE, null);
			} catch (JsonProcessingException e1) {
				LOGGER.error(
						"Error occured while converting response object in catch block of Update approval1"
								+ e1, e1);
				activityLogService.addActivity("Update approval1", "Success",
						"Updating approval1 completed successfully", "",
						commonUtil.getUserName());
			}
		}
		return response;

	}

	@RequestMapping(value = { "/approverOnePRFGeneratedCash" }, method = RequestMethod.GET)
	@ResponseBody
	public String getApproverOnePRFGeneratedCash(
			@RequestParam(value = "prfNoGenREF") int prfNoGenREF) {
		/*
		 * http://localhost:8090/SFCRM/approverOnePRFGeneratedCash?prfNoGenREF=2
		 */String response = null;

		try {
			List<Object> approverOnePrfGeneratedCashList = approverOneContestListService
					.getApproverOnePRFGeneratedCash(prfNoGenREF);
			response = commonUtil.serviceResponse(
					MessageConstants.SUCCESS_RESPONSE,
					ApplicationConstants.TRUE, approverOnePrfGeneratedCashList);

			activityLogService
					.addActivity(
							"Get agent details",
							"Success",
							"Get approverOne PrfGeneratedCashList request completed successfully",
							approverOnePrfGeneratedCashList.toString(),
							commonUtil.getUserName());
		} catch (Exception e) {
			LOGGER.error(
					"Error occured while getting approverOne PrfGeneratedCashList details "
							+ e, e);

			try {
				response = commonUtil.serviceResponse(
						MessageConstants.EXCEPTION_RESPONSE,
						ApplicationConstants.FALSE, null);
			} catch (JsonProcessingException e1) {
				LOGGER.error(
						"Error occured while converting response object in catch block of get approverOne PrfGeneratedCashList details"
								+ e1, e1);
				activityLogService
						.addActivity(
								"get approverOne PrfGeneratedCashList",
								"Success",
								"Get approverOne PrfGeneratedCashList request completed successfully",
								"", commonUtil.getUserName());
			}
		}
		return response;

	}

	@RequestMapping(value = { "/approveOneTickets" }, method = RequestMethod.GET)
	@ResponseBody
	public String getApproveOneTickets(
			@RequestParam(value = "pageNumber") int pageNumber) {

		String response = null;
		try {

			Map<String, Object> data = approverOneContestListService
					.getApproveOneTickets("vasavivr",
							commonUtil.getOffset(pageNumber),
							propertyConstants.PAGE_LIMIT);
			response = commonUtil.serviceResponse(
					MessageConstants.SUCCESS_RESPONSE,
					ApplicationConstants.TRUE, data);
			activityLogService
					.addActivity("Get agent details",
							"Success",
							"Get approverOne TicketList request completed successfully",
							data.toString(), commonUtil.getUserName());
		} catch (Exception e) {
			LOGGER.error(
					"Error occured while getting approverOne TicketList details "
							+ e, e);
			try {
				response = commonUtil.serviceResponse(
						MessageConstants.EXCEPTION_RESPONSE,
						ApplicationConstants.FALSE, null);
			} catch (JsonProcessingException e1) {
				LOGGER.error(
						"Error occured while converting response object in catch block of Update approval1"
								+ e1, e1);
				activityLogService.addActivity("Update approval1", "Success",
						"Updating approval1 completed successfully", "",
						commonUtil.getUserName());
			}
		}
		return response;
	}
	@RequestMapping(value = { "/updateApproverOneTransactionTicket" }, method = RequestMethod.PUT)
	@ResponseBody
	public String updateApproverOneTransactionTicket(
			@RequestBody List<Map<String, String>> json) {
	
		 String response = null;
		try {
			String approverId = "NULL", approverName = "NULL";
			approverOneContestListService
					.updateApproverOneTransactionTicket(approverId, approverName,
							json);
			response = commonUtil.serviceResponse(MessageConstants.SUCCESS,
					ApplicationConstants.TRUE, null);
			activityLogService.addActivity("Update approval one ", "Success",
					"Updating approval one completed successfully",
					response.toString(), commonUtil.getUserName());
		} catch (Exception e) {
			LOGGER.error(
					"Error occured while updating approverOne Transaction Ticket details "
							+ e, e);
			try {
				response = commonUtil.serviceResponse(
						MessageConstants.EXCEPTION_RESPONSE,
						ApplicationConstants.FALSE, null);
			} catch (JsonProcessingException e1) {
				LOGGER.error(
						"Error occured while converting response object in catch block of Update approval1"
								+ e1, e1);
				activityLogService.addActivity("Update approval1", "Success",
						"Updating approval1 completed successfully", "",
						commonUtil.getUserName());
			}
		}
		return response;

	}
	@RequestMapping(value = { "/rejectApproverOneTransactionCash" }, method = RequestMethod.PUT)
	@ResponseBody
	public String rejectApproverOneTransactionCash(
			@RequestBody List<Map<String, String>> json) {
		
		 String response = null;
		try {
			String approverId = "NULL", approverName = "NULL";
			 approverOneContestListService
					.rejectApproverOneTransactionCash(approverId, approverName,
							json);
			response = commonUtil.serviceResponse(MessageConstants.SUCCESS,
					ApplicationConstants.TRUE, null);
			activityLogService.addActivity("Update approval one ", "Success",
					"Updating approval one completed successfully",
					response.toString(), commonUtil.getUserName());
		} catch (Exception e) {
			LOGGER.error(
					"Error occured while updating approverOne Transaction Cash details "
							+ e, e);
			try {
				response = commonUtil.serviceResponse(
						MessageConstants.EXCEPTION_RESPONSE,
						ApplicationConstants.FALSE, null);
			} catch (JsonProcessingException e1) {
				LOGGER.error(
						"Error occured while converting response object in catch block of Update approval1"
								+ e1, e1);
				activityLogService.addActivity("Update approval1", "Success",
						"Updating approval1 completed successfully", "",
						commonUtil.getUserName());
			}
		}
		return response;

	}
	@RequestMapping(value = { "/rejectApproverOneTransactionTicket" }, method = RequestMethod.PUT)
	@ResponseBody
	public String rejectApproverOneTransactionTicket(
			@RequestBody List<Map<String, String>> json) {
	
		 String response = null;
		try {
			String approverId = "NULL", approverName = "NULL";
			approverOneContestListService
					.rejectApproverOneTransactionTicket(approverId, approverName,
							json);
			response = commonUtil.serviceResponse(MessageConstants.SUCCESS,
					ApplicationConstants.TRUE, null);
			activityLogService.addActivity("Reject approval one ", "Success",
					"Rejecting approval one completed successfully",
					response.toString(), commonUtil.getUserName());
		} catch (Exception e) {
			LOGGER.error(
					"Error occured while rejecting approverOne Transaction Ticket details "
							+ e, e);
			try {
				response = commonUtil.serviceResponse(
						MessageConstants.EXCEPTION_RESPONSE,
						ApplicationConstants.FALSE, null);
			} catch (JsonProcessingException e1) {
				LOGGER.error(
						"Error occured while converting response object in catch block of Update approval1"
								+ e1, e1);
				activityLogService.addActivity("Update approval1", "Success",
						"Updating approval1 completed successfully", "",
						commonUtil.getUserName());
			}
		}
		return response;
}
}
