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
import com.exide.sfcrm.model.DeviationTicketPojo;
import com.exide.sfcrm.model.DeviationTicketsView;
//import com.exide.sfcrm.pojo.DeviationTicketViewPojo;
import com.exide.sfcrm.service.AuditLogService;
import com.exide.sfcrm.service.DeviationTicketsService;
import com.exide.sfcrm.util.CommonUtil;
import com.fasterxml.jackson.core.JsonProcessingException;
import com.fasterxml.jackson.databind.ObjectMapper;

@Controller
public class DeviationTicketsController {

	/**
	 * Logger.
	 */
	private static final Logger LOGGER = Logger
			.getLogger(DeviationTicketsController.class);

	@Autowired
	ObjectMapper objectMapper;

	@Autowired
	private AuditLogService activityLogService;

	@Autowired
	DeviationTicketsService deviationTicketsService;

	@Autowired
	PropertyConstants propertyConstants;

	@Autowired
	CommonUtil commonUtil;
	
	//@Autowired
	//DeviationTicketViewPojo deviationTicketViewPojo;

	@RequestMapping(value = { "/deviationTicketsList" }, method = RequestMethod.GET)
	@ResponseBody
	public String getDeviationTicketsList(
			@RequestParam(value = "pageNumber") int pageNumber) {
		String response = null;
		try {
			Map<String, Object> data = deviationTicketsService
					.getDeviationTicketsList("vasavivr",
							commonUtil.getOffset(pageNumber),
							propertyConstants.PAGE_LIMIT);
			response = commonUtil.serviceResponse(
					MessageConstants.SUCCESS_RESPONSE,
					ApplicationConstants.TRUE, data);
			activityLogService
					.addActivity(
							"Get deviation ticket details",
							"Success",
							"Get deviation ticket details request completed successfully",
							data.toString(), commonUtil.getUserName());
		} catch (Exception e) {
			LOGGER.error(
					"Error occured while getting deviation ticket details " + e,
					e);

			try {
				response = commonUtil.serviceResponse(
						MessageConstants.EXCEPTION_RESPONSE,
						ApplicationConstants.FALSE, null);
			} catch (JsonProcessingException e1) {
				LOGGER.error(
						"Error occured while converting response object in catch block of get deviation ticket details"
								+ e1, e1);
				activityLogService
						.addActivity(
								"get deviation ticket details",
								"Success",
								"Get deviation ticket details request completed successfully",
								"", commonUtil.getUserName());
			}
		}
		return response;
	}

	@RequestMapping(value = { "/approveDeviationTickets" }, method = RequestMethod.PUT)
	@ResponseBody
	public String updateTransactionTicketsDeviation(
			@RequestBody List<Map<String, String>> json) {
		String response = null;
		try {
			String deviationApprId = "NULL", deviationApprName = "NULL";
			int update = deviationTicketsService
					.updateTransactionTicketDeviation(deviationApprId,
							deviationApprName, json);
			response = commonUtil.serviceResponse(MessageConstants.SUCCESS,
					ApplicationConstants.TRUE, update);
			activityLogService.addActivity("Update deviation approval ",
					"Success",
					"Updating deviation approval completed successfully",
					String.valueOf(update), commonUtil.getUserName());
		} catch (Exception e) {
			LOGGER.error(
					"Error occured while updating deviation approval Transaction ticket details "
							+ e, e);
			try {
				response = commonUtil.serviceResponse(
						MessageConstants.EXCEPTION_RESPONSE,
						ApplicationConstants.FALSE, null);
			} catch (JsonProcessingException e1) {
				LOGGER.error(
						"Error occured while converting response object in catch block of Update deviation ticket approval"
								+ e1, e1);
				activityLogService.addActivity(
						"Update deviation ticket approval", "Success",
						"Updating deviation approval completed successfully",
						"", commonUtil.getUserName());
			}
		}
		return response;
	}

	@RequestMapping(value = { "/rejectDeviationTickets" }, method = RequestMethod.PUT)
	@ResponseBody
	public String rejectTransactionTicketsDeviation(
			@RequestBody List<Map<String, String>> json) {
		String response = null;
		try {
			String deviationApprId = "NULL", deviationApprName = "NULL";
			int update = deviationTicketsService
					.rejectTransactionTicketsDeviation(deviationApprId,
							deviationApprName, json);
			response = commonUtil.serviceResponse(MessageConstants.SUCCESS,
					ApplicationConstants.TRUE, update);
			activityLogService.addActivity("Reject deviation approval ",
					"Success",
					"reject deviation ticket approval completed successfully",
					String.valueOf(update), commonUtil.getUserName());
		} catch (Exception e) {
			LOGGER.error("Error occured while Reject deviation ticket details "
					+ e, e);
			try {
				response = commonUtil.serviceResponse(
						MessageConstants.EXCEPTION_RESPONSE,
						ApplicationConstants.FALSE, null);
			} catch (JsonProcessingException e1) {
				LOGGER.error(
						"Error occured while converting response object in catch block of Rejecting deviation ticket approval"
								+ e1, e1);
				activityLogService
						.addActivity(
								"Rejecting deviation ticket approval",
								"Success",
								"Reject deviation ticket approval completed successfully",
								"", commonUtil.getUserName());
			}
		}
		return response;
	}
	
	@RequestMapping(value = { "/deviationTicketCount" }, method = RequestMethod.GET)
	@ResponseBody
	public String deviationTicketCount(@RequestParam(value = "contestId") Integer contestId,@RequestParam(value = "agentNo") String agentNo,@RequestParam(value = "destId") Integer destid) {

		String response = null;
		try {
			List<Object> deviationTicketsListCount= deviationTicketsService.deviationTicketCount(contestId,agentNo,destid);

			
			
			
			response = commonUtil.serviceResponse(
					MessageConstants.SUCCESS_RESPONSE,
					ApplicationConstants.TRUE, deviationTicketsListCount);
			activityLogService
					.addActivity(
							"Get deviation listcount",
							"Success",
							"Get deviation listcount request completed successfully",
							"", commonUtil.getUserName());
		} catch (Exception e) {
			LOGGER.error("Error occured while getting deviation list details "
					+ e, e);

			try {
				response = commonUtil.serviceResponse(
						MessageConstants.EXCEPTION_RESPONSE,
						ApplicationConstants.FALSE, null);
			} catch (JsonProcessingException e1) {
				LOGGER.error(
						"Error occured while converting response object in catch block of get deviation list details"
								+ e1, e1);
				activityLogService
						.addActivity(
								"get deviation list details",
								"Success",
								"Get deviation list details request completed successfully",
								"", commonUtil.getUserName());
			}
		}
		return response;
	}
	@RequestMapping(value = { "/deviationEntryTicket" }, method = RequestMethod.PUT)
	@ResponseBody
	public String deviationEntryTickets(@RequestBody List<Map<String, String>> json) {

		String response = null;
		try {
			deviationTicketsService.addDeviation(json, "vasavivr");

			response = commonUtil.serviceResponse(
					MessageConstants.SUCCESS_RESPONSE,
					ApplicationConstants.TRUE, "");
			activityLogService
					.addActivity(
							"add deviation",
							"Success",
							"add deviation request completed successfully",
							"", commonUtil.getUserName());
		} catch (Exception e) {
			LOGGER.error("Error occured while adding deviation list details "
					+ e, e);

			try {
				response = commonUtil.serviceResponse(
						MessageConstants.EXCEPTION_RESPONSE,
						ApplicationConstants.FALSE, null);
			} catch (JsonProcessingException e1) {
				LOGGER.error(
						"Error occured while converting response object in catch block of add deviation list details"
								+ e1, e1);
				activityLogService
						.addActivity(
								"add deviation list details",
								"Success",
								"add deviation list details request completed successfully",
								"", commonUtil.getUserName());
			}
		}
		return response;
	}
}