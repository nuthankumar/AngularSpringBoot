package com.exide.sfcrm.controller;

import java.util.List;
import java.util.Map;

import org.apache.log4j.Logger;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.ResponseBody;

import com.exide.sfcrm.constants.ApplicationConstants;
import com.exide.sfcrm.constants.MessageConstants;
import com.exide.sfcrm.model.Reasons;
import com.exide.sfcrm.service.AuditLogService;
import com.exide.sfcrm.service.ReasonsService;
import com.exide.sfcrm.util.CommonUtil;
import com.fasterxml.jackson.core.JsonProcessingException;
import com.fasterxml.jackson.databind.ObjectMapper;

/**
 * 
 * @author vasavivr
 *
 */

@Controller
public class ReasonsController {
	private static final Logger LOGGER = Logger
			.getLogger(ReasonsController.class);

	@Autowired
	ReasonsService reasonsService;

	@Autowired
	private ObjectMapper objectMapper;

	@Autowired
	private AuditLogService activityLogService;

	@Autowired
	private CommonUtil commonUtil;

	@RequestMapping(value = { "/reasonsList" }, method = RequestMethod.GET)
	@ResponseBody
	public String getReasonList() {

		LOGGER.info("Inside Get reason list method");

		String response = null;

		try {

			List<Reasons> reasons = reasonsService.getReasonList();
			response = commonUtil.serviceResponse(
					MessageConstants.SUCCESS_RESPONSE,
					ApplicationConstants.TRUE, reasons);

			activityLogService.addActivity("Get reason list", "Success",
					"Get reason list request completed successfully",
					reasons.toString(), commonUtil.getUserName());
		} catch (Exception e) {

			LOGGER.error(
					"Error occured while getting reason list details " + e, e);
			try {
				response = commonUtil.serviceResponse(
						MessageConstants.EXCEPTION_RESPONSE,
						ApplicationConstants.FALSE, null);
			} catch (JsonProcessingException e1) {
				LOGGER.error(
						"Error occured while converting response object in catch block of get reason list details"
								+ e, e);
			}

			activityLogService.addActivity("Get reason list", "Failure",
					"Get reason list request failed", "",
					commonUtil.getUserName());
		}

		return response;
	}

	@RequestMapping(value = { "/addReasons" }, method = RequestMethod.POST)
	@ResponseBody
	public String addAllData(@RequestBody Reasons reason) {
		LOGGER.info("Inside add reasons method");

		String response = null;

		try {

			Reasons code = reasonsService.addReasons(reason);

			if (null != code) {

				response = commonUtil.serviceResponse(
						MessageConstants.SUCCESS_RESPONSE,
						ApplicationConstants.TRUE, code);
			} else {

				response = commonUtil.serviceResponse(
						MessageConstants.ERROR_RESPONSE,
						ApplicationConstants.FALSE, null);
			}

		} catch (Exception e) {

			LOGGER.error("Error occured while adding reasons " + e, e);
			try {
				response = commonUtil.serviceResponse(
						MessageConstants.EXCEPTION_RESPONSE,
						ApplicationConstants.FALSE, null);
			} catch (JsonProcessingException e1) {
				LOGGER.error(
						"Error occured while converting response object in catch block of add reasons "
								+ e1, e1);
			}
		}

		return response;
	}

	@RequestMapping(value = { "/editReasonList" }, method = RequestMethod.PUT)
	@ResponseBody
	public String updateReasonList(@RequestBody Reasons reason) {
		LOGGER.info("Inside edit reason method");

		String response = null;

		try {

			Reasons code = reasonsService.updateReasonList(reason);

			if (null != code) {

				response = commonUtil.serviceResponse(
						MessageConstants.SUCCESS_RESPONSE,
						ApplicationConstants.TRUE, code);
			} else {

				response = commonUtil.serviceResponse(
						MessageConstants.ERROR_RESPONSE,
						ApplicationConstants.FALSE, null);
			}

		} catch (Exception e) {

			LOGGER.error("Error occured while editing reasons " + e, e);
			try {
				response = commonUtil.serviceResponse(
						MessageConstants.EXCEPTION_RESPONSE,
						ApplicationConstants.FALSE, null);
			} catch (JsonProcessingException e1) {
				LOGGER.error(
						"Error occured while converting response object in catch block of editing reasons "
								+ e1, e1);
			}
		}

		return response;
	}
	@RequestMapping(value = { "/updateStatus" }, method = RequestMethod.PUT)
	@ResponseBody
	public String updateUtrNo(@RequestBody List<Map<String, String>> json) {

		String response = null;
		try {
			Integer  update=reasonsService.updateStatus(json);

			
			response = commonUtil.serviceResponse(MessageConstants.SUCCESS,
					ApplicationConstants.TRUE, null);
			activityLogService.addActivity("update status for reasons",
					"Success",
					" updating status for reasons completed successfully",
					update.toString(), commonUtil.getUserName());
		} catch (Exception e) {
			LOGGER.error(
					"Error occured while Updating status for raesons "
							+ e, e);

			try {
				response = commonUtil.serviceResponse(
						MessageConstants.EXCEPTION_RESPONSE,
						ApplicationConstants.FALSE, null);
			} catch (JsonProcessingException e1) {
				LOGGER.error(
						"Error occured while converting response object in catch block of updating status for reasons"
								+ e1, e1);
				activityLogService
						.addActivity(
								"update status for reasons",
								"Success",
								"update status for reasons",
								"", commonUtil.getUserName());
			}
		}
		return response;
	}
}