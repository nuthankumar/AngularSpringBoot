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
import com.exide.sfcrm.model.AdvancePay;
import com.exide.sfcrm.service.AdvancePaymentsService;
import com.exide.sfcrm.service.AuditLogService;
import com.exide.sfcrm.util.CommonUtil;
import com.fasterxml.jackson.core.JsonProcessingException;

/**
 * 
 * @author vasavivr
 *
 */

@Controller
public class AdvancePaymentsMakerController {
	/**
	 * Logger.
	 */
	private static final Logger LOGGER = Logger
			.getLogger(AdvancePaymentsMakerController.class);

	@Autowired
	AdvancePaymentsService advancePaymentsService;

	@Autowired
	private AuditLogService activityLogService;

	@Autowired
	CommonUtil commonUtil;

	@Autowired
	PropertyConstants propertyConstants;

	@RequestMapping(value = { "/advancePayMakerList" }, method = RequestMethod.GET)
	@ResponseBody
	public String getAdvancePayList(
			@RequestParam(value = "pageNumber") int pageNumber) {

		String response = null;
		try {
			Map<String, Object> data = advancePaymentsService
					.getAdvancePayList("neethub",
							commonUtil.getOffset(pageNumber),
							propertyConstants.PAGE_LIMIT);

			response = commonUtil.serviceResponse(
					MessageConstants.SUCCESS_RESPONSE,
					ApplicationConstants.TRUE, data);
			activityLogService.addActivity("Get  advance pay list", "Success",
					"Get advancePay list request completed successfully",
					data.toString(), commonUtil.getUserName());
		} catch (Exception e) {
			LOGGER.error("Error occured while getting advancePay list details "
					+ e, e);

			try {
				response = commonUtil.serviceResponse(
						MessageConstants.EXCEPTION_RESPONSE,
						ApplicationConstants.FALSE, null);
			} catch (JsonProcessingException e1) {
				LOGGER.error(
						"Error occured while converting response object in catch block of get advancePay list details"
								+ e1, e1);
				activityLogService
						.addActivity(
								"get advancePay list details",
								"Success",
								"Get advancePay list details request completed successfully",
								"", commonUtil.getUserName());
			}
		}
		return response;

	}

	@RequestMapping(value = { "/approveAdvancePayMakerCash" }, method = RequestMethod.PUT)
	@ResponseBody
	public String updateAdvancePayCash(
			@RequestBody List<Map<String, String>> json) {
		String response = null;
		try {
			String makerId = "NULL", makerName = "NULL";
			int update = advancePaymentsService.updateAdvancePayCash(makerId,
					makerName, json);
			response = commonUtil.serviceResponse(MessageConstants.SUCCESS,
					ApplicationConstants.TRUE, update);
			activityLogService
					.addActivity(
							"Update advance pay approval Cash ",
							"Success",
							"Updating advance pay approval Cash completed successfully",
							String.valueOf(update), commonUtil.getUserName());
		} catch (Exception e) {
			LOGGER.error(
					"Error occured while updating advance pay approval Cash details "
							+ e, e);
			try {
				response = commonUtil.serviceResponse(
						MessageConstants.EXCEPTION_RESPONSE,
						ApplicationConstants.FALSE, null);
			} catch (JsonProcessingException e1) {
				LOGGER.error(
						"Error occured while converting response object in catch block of Update advance pay approval Cash"
								+ e1, e1);
				activityLogService
						.addActivity(
								"Update advance pay approval Cash",
								"Success",
								"Updating advance pay approval Cash completed successfully",
								"", commonUtil.getUserName());
			}
		}
		return response;
	}

	/**
	 * 
	 * @param advancePay
	 * @return
	 */
	@RequestMapping(value = "/advancePay", method = RequestMethod.POST)
	@ResponseBody
	public String createAdvancePay(@RequestBody AdvancePay advancePay) {

		LOGGER.debug("Inside create advance pay method");

		String response = null;

		try {

			advancePay = advancePaymentsService.createAdvancePay(advancePay);

			if (null != advancePay && null != advancePay.getId()) {

				response = commonUtil.serviceResponse(
						MessageConstants.SUCCESS_RESPONSE,
						ApplicationConstants.TRUE, advancePay.getId());
			} else {

				response = commonUtil.serviceResponse(
						MessageConstants.ERROR_RESPONSE,
						ApplicationConstants.FALSE, null);
			}
			// response = objectMapper.writeValueAsString(serviceResponse);

			activityLogService.addActivity("Advance Pay",
					MessageConstants.SUCCESS,
					"Insert advance pay request completed successfully",
					advancePay.toString(), commonUtil.getUserName());

			LOGGER.debug("Create advance pay method executed successfully");

		} catch (Exception e) {

			LOGGER.error("Error occured while creating advance pay " + e, e);
			try {
				response = commonUtil.serviceResponse(
						MessageConstants.EXCEPTION_RESPONSE,
						ApplicationConstants.FALSE, null);
			} catch (JsonProcessingException e1) {
				LOGGER.error(
						"Error occured while converting response object in catch block of advance pay "
								+ e1, e1);
			}

			activityLogService.addActivity("Get Advance pay",
					MessageConstants.ERROR_RESPONSE,
					"Get Advance Pay request failed", "",
					commonUtil.getUserName());
		}

		return response;
	}

	@RequestMapping(value = { "/advancePaymentsEntry" }, method = RequestMethod.PUT)
	@ResponseBody
	public String deviationEntryCash(@RequestBody List<Map<String, String>> json) {

		String response = null;
		try {
			advancePaymentsService.addAdvancePayments(json, "vasavivr");

			/*
			 * response = commonUtil.serviceResponse(
			 * MessageConstants.SUCCESS_RESPONSE, ApplicationConstants.TRUE,
			 * prfNo); activityLogService .addActivity(
			 * "Get advancePayments list", "Success",
			 * "Get advancePayments list request completed successfully", ,
			 * commonUtil.getUserName());
			 */
		} catch (Exception e) {
			LOGGER.error(
					"Error occured while getting advancePayments list details "
							+ e, e);

			try {
				response = commonUtil.serviceResponse(
						MessageConstants.EXCEPTION_RESPONSE,
						ApplicationConstants.FALSE, null);
			} catch (JsonProcessingException e1) {
				LOGGER.error(
						"Error occured while converting response object in catch block of get advancePayments list details"
								+ e1, e1);
				activityLogService
						.addActivity(
								"get advancePayments list details",
								"Success",
								"Get advancePayments list details request completed successfully",
								"", commonUtil.getUserName());
			}
		}
		return response;
	}
}
