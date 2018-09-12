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
public class AdvancePaymentsCheckerController {

	/**
	 * Logger.
	 */
	private static final Logger LOGGER = Logger
			.getLogger(AdvancePaymentsCheckerController.class);

	@Autowired
	AdvancePaymentsService advancePaymentsService;

	@Autowired
	private AuditLogService activityLogService;

	@Autowired
	CommonUtil commonUtil;

	@Autowired
	PropertyConstants propertyConstants;
	@RequestMapping(value = { "/advancePayCashCheckerList" }, method = RequestMethod.GET)
	@ResponseBody
	public String getAdvancePayCashCheckerList(
			@RequestParam(value = "pageNumber") int pageNumber) {

		String response = null;
		try {
			Map<String, Object> data = advancePaymentsService
					.getAdvancePayCheckerList("neethub",
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
	@RequestMapping(value={"/approveAdvancePayCheckerCash"},method=RequestMethod.PUT)
	@ResponseBody
	public String updateAdvancePayCheckerCash(@RequestBody List<Map<String, String>> json){
		
		String response=null;
		try{
		String checkerId="NULL",checkerName="NULL";
		int update = advancePaymentsService.updateAdvancePayCashChecker(
				checkerId, checkerName, json);
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
		
	}

