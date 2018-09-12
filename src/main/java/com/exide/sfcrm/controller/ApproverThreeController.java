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
import com.exide.sfcrm.service.ApproverThreeService;
import com.exide.sfcrm.service.AuditLogService;
import com.exide.sfcrm.util.CommonUtil;
import com.fasterxml.jackson.core.JsonProcessingException;
import com.fasterxml.jackson.databind.ObjectMapper;

/**
 * 
 * @author vasavivr
 *
 */
@Controller
public class ApproverThreeController {

	private static final Logger LOGGER = Logger
			.getLogger(ApproverThreeController.class);

	@Autowired
	ApproverThreeService approverThreeService;

	@Autowired
	ObjectMapper objectMapper;

	@Autowired
	private AuditLogService activityLogService;

	@Autowired
	private CommonUtil commonUtil;

	@Autowired
	PropertyConstants propertyConstants;

	@RequestMapping(value = { "/approverThreeContestList" }, method = RequestMethod.GET)
	@ResponseBody
	public String getApproverTwoContestList(
			@RequestParam("pageNumber") int pageNumber) {

		String response = null;
		try {
			Map<String, Object> data = approverThreeService
					.getApproverThreeContestList("neethub",
							commonUtil.getOffset(pageNumber),
							propertyConstants.PAGE_LIMIT);

			response = commonUtil.serviceResponse(
					MessageConstants.SUCCESS_RESPONSE,
					ApplicationConstants.TRUE, data);
			activityLogService
					.addActivity(
							"Get approverThree details",
							"Success",
							"Get approverThree ContestList request completed successfully",
							data.toString(), commonUtil.getUserName());
		} catch (Exception e) {
			LOGGER.error(
					"Error occured while getting approverThree ContestList details "
							+ e, e);

			try {
				response = commonUtil.serviceResponse(
						MessageConstants.EXCEPTION_RESPONSE,
						ApplicationConstants.FALSE, null);
			} catch (JsonProcessingException e1) {
				LOGGER.error(
						"Error occured while converting response object in catch block of get approverThree ContestList details"
								+ e1, e1);
				activityLogService
						.addActivity(
								"get approverThree ContestList details",
								"Success",
								"Get approverThree ContestList details request completed successfully",
								"", commonUtil.getUserName());
			}
		}
		return response;

	}

	@RequestMapping(value = { "/updateApproverThreeTransactionCash" }, method = RequestMethod.PUT)
	@ResponseBody
	public String updateApproverThreeTransactionCash(
			@RequestBody List<Map<String, String>> json) {
		String response = null;
		try {
			String approverId = "NULL", approverName = "NULL";
			approverThreeService.updateTransactionCashApproverThree(approverId,
					approverName, json);
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

	@RequestMapping(value = { "/rejectApproverThreeTransactionCash" }, method = RequestMethod.PUT)
	@ResponseBody
	public String rejectApproverThreeTransactionCash(
			@RequestBody List<Map<String, String>> json) {

		String response = null;
		try {
			String approverId = "NULL", approverName = "NULL";
			approverThreeService.rejectApproverThreeTransactionCash(approverId,
					approverName, json);
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

}
