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
import com.exide.sfcrm.service.AuditLogService;
import com.exide.sfcrm.service.DeviationCashService;
import com.exide.sfcrm.util.CommonUtil;
import com.fasterxml.jackson.core.JsonProcessingException;
import com.fasterxml.jackson.databind.ObjectMapper;

/**
 * 
 * @author vasavivr
 *
 */
@Controller
public class DeviationCashController {

	/**
	 * Logger.
	 */
	private static final Logger LOGGER = Logger
			.getLogger(DeviationCashController.class);

	@Autowired
	DeviationCashService deviationService;

	@Autowired
	ObjectMapper objectMapper;

	@Autowired
	PropertyConstants propertyConstants;

	@Autowired
	private AuditLogService activityLogService;

	@Autowired
	private CommonUtil commonUtil;

	@RequestMapping(value = { "/deviationCashList" }, method = RequestMethod.GET)
	@ResponseBody
	public String getDeviationListCash(
			@RequestParam(value = "pageNumber") int pageNumber) {

		String response = null;
		try {

			Map<String, Object> data = deviationService.getDeviationListCash(
					"neethub", commonUtil.getOffset(pageNumber),
					propertyConstants.PAGE_LIMIT);
			response = commonUtil.serviceResponse(
					MessageConstants.SUCCESS_RESPONSE,
					ApplicationConstants.TRUE, data);
			activityLogService
					.addActivity(
							"Get deviation cash details",
							"Success",
							"Get deviation cash details request completed successfully",
							data.toString(), commonUtil.getUserName());
		} catch (Exception e) {
			LOGGER.error("Error occured while getting deviation cash details "
					+ e, e);

			try {
				response = commonUtil.serviceResponse(
						MessageConstants.EXCEPTION_RESPONSE,
						ApplicationConstants.FALSE, null);
			} catch (JsonProcessingException e1) {
				LOGGER.error(
						"Error occured while converting response object in catch block of get deviation cash details"
								+ e1, e1);
				activityLogService
						.addActivity(
								"get deviation cash details",
								"Success",
								"Get deviation cash details request completed successfully",
								"", commonUtil.getUserName());
			}
		}
		return response;
	}

	@RequestMapping(value = { "/approveDeviationCash" }, method = RequestMethod.PUT)
	@ResponseBody
	public String updateTransactionCashDeviation(
			@RequestBody List<Map<String, String>> json) {
		String response = null;
		try {
			String deviationApprId = "NULL", deviationApprName = "NULL";
			int update = deviationService.updateTransactionCashDeviation(
					deviationApprId, deviationApprName, json);
			response = commonUtil.serviceResponse(MessageConstants.SUCCESS,
					ApplicationConstants.TRUE, update);
			activityLogService.addActivity("Update deviation approval ",
					"Success",
					"Updating deviation approval completed successfully",
					String.valueOf(update), commonUtil.getUserName());
		} catch (Exception e) {
			LOGGER.error(
					"Error occured while updating deviation approval Transaction Cash details "
							+ e, e);
			try {
				response = commonUtil.serviceResponse(
						MessageConstants.EXCEPTION_RESPONSE,
						ApplicationConstants.FALSE, null);
			} catch (JsonProcessingException e1) {
				LOGGER.error(
						"Error occured while converting response object in catch block of Update deviation approval"
								+ e1, e1);
				activityLogService.addActivity("Update deviation approval",
						"Success",
						"Updating deviation approval completed successfully",
						"", commonUtil.getUserName());
			}
		}
		return response;
	}

	@RequestMapping(value = { "/rejectDeviationCash" }, method = RequestMethod.PUT)
	@ResponseBody
	public String rejectTransactionCashDeviation(
			@RequestBody List<Map<String, String>> json) {
		String response = null;
		try {
			String deviationApprId = "NULL", deviationApprName = "NULL";
			int update = deviationService.rejectTransactionCashDeviation(
					deviationApprId, deviationApprName, json);
			response = commonUtil.serviceResponse(MessageConstants.SUCCESS,
					ApplicationConstants.TRUE, update);
			activityLogService.addActivity("Reject deviation approval",
					"Success",
					"Rejecting deviation approvalcompleted successfully",
					String.valueOf(update), commonUtil.getUserName());
		} catch (Exception e) {
			LOGGER.error(
					"Error occured while rejecting deviation approval Transaction Cash details "
							+ e, e);
			try {
				response = commonUtil.serviceResponse(
						MessageConstants.EXCEPTION_RESPONSE,
						ApplicationConstants.FALSE, null);
			} catch (JsonProcessingException e1) {
				LOGGER.error(
						"Error occured while converting response object in catch block of reject deviation approval"
								+ e1, e1);
				activityLogService.addActivity("Reject deviation approval",
						"Success",
						"Rejecting deviation approval completed successfully",
						"", commonUtil.getUserName());
			}
		}
		return response;
	}

	@RequestMapping(value = { "/deviationEntryCash" }, method = RequestMethod.PUT)
	@ResponseBody
	public String deviationEntryCash(@RequestBody List<Map<String, String>> json) {

		String response = null;
		try {
			deviationService.addDeviation(json, "neethub");

			/*
			 * response = commonUtil.serviceResponse(
			 * MessageConstants.SUCCESS_RESPONSE, ApplicationConstants.TRUE,
			 * prfNo); activityLogService .addActivity( "Get deviation list",
			 * "Success", "Get deviation list request completed successfully", ,
			 * commonUtil.getUserName());
			 */
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
}
