package com.exide.sfcrm.controller;

import java.util.List;

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
import com.exide.sfcrm.model.AgentGregList;
import com.exide.sfcrm.model.AgentGregListView;
import com.exide.sfcrm.service.AgentGregListService;
import com.exide.sfcrm.service.AuditLogService;
import com.exide.sfcrm.util.CommonUtil;
import com.fasterxml.jackson.core.JsonProcessingException;
import com.fasterxml.jackson.databind.ObjectMapper;

@Controller
public class AgentGregListController {
	/**
	 * Logger.
	 */
	private static final Logger LOGGER = Logger
			.getLogger(AgentGregListController.class);

	@Autowired
	private AgentGregListService agentGregListService;
	
	@Autowired
	private ObjectMapper objectMapper;

	@Autowired
	private AuditLogService activityLogService;

	@Autowired
	private CommonUtil commonUtil;
	
	@RequestMapping(value = { "/agentGregList" }, method = RequestMethod.GET)
	@ResponseBody
	public String getAllAgents() {

		LOGGER.info("Inside Get all agentGregList method");

		String response = null;

		try {

			List<AgentGregListView> agentGregList = agentGregListService.getAgentGregList();
			response = commonUtil.serviceResponse(
					MessageConstants.SUCCESS_RESPONSE,
					ApplicationConstants.TRUE, agentGregList);

			activityLogService.addActivity("Get All Vendor", "Success",
					"Get agentGregList details request completed successfully",
					agentGregList.toString(), commonUtil.getUserName());
		} catch (Exception e) {

			LOGGER.error("Error occured while getting agentGregList details " + e, e);
			try {
				response = commonUtil.serviceResponse(
						MessageConstants.EXCEPTION_RESPONSE,
						ApplicationConstants.FALSE, null);
			} catch (JsonProcessingException e1) {
				LOGGER.error(
						"Error occured while converting response object in catch block of get agentGregList details"
								+ e, e);
			}

			activityLogService.addActivity("Get All Vendor", "Failure",
					"Get agentGregList request failed", "", commonUtil.getUserName());
		}

		return response;
	}
	@RequestMapping(value = { "/addAgentGregList" }, method = RequestMethod.POST)
	@ResponseBody
	public String addDestination(@RequestBody AgentGregList agentGregList) {
		LOGGER.info("Inside addagentGregList method");

		String response = null;

		try {

			AgentGregList add = agentGregListService.addAgentGregList(agentGregList);
			if (null != add) {

				response = commonUtil.serviceResponse(
						MessageConstants.SUCCESS_RESPONSE,
						ApplicationConstants.TRUE, add);
			} else {

				response = commonUtil.serviceResponse(
						MessageConstants.ERROR_RESPONSE,
						ApplicationConstants.FALSE, null);
			}

		} catch (Exception e) {

			LOGGER.error("Error occured while adding destinationPlace " + e, e);
			try {
				response = commonUtil.serviceResponse(
						MessageConstants.EXCEPTION_RESPONSE,
						ApplicationConstants.FALSE, null);
			} catch (JsonProcessingException e1) {
				LOGGER.error(
						"Error occured while converting response object in catch block of adding destinationPlace "
								+ e1, e1);
			}
		}

		return response;
	}
	
	@RequestMapping(value = { "/editAgentGregList" }, method = RequestMethod.PUT)
	@ResponseBody
	public String updateAgentGregList(@RequestBody AgentGregList agentGregList) {
		LOGGER.info("Inside edit AgentGregList method");

		String response = null;

		try {

			AgentGregList code = agentGregListService.updateAgentGregList(agentGregList);

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
}
