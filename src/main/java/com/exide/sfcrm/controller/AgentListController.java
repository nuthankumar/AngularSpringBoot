package com.exide.sfcrm.controller;

import java.util.List;
import java.util.Map;

import org.apache.log4j.Logger;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.ResponseBody;

import com.exide.sfcrm.constants.ApplicationConstants;
import com.exide.sfcrm.constants.MessageConstants;
import com.exide.sfcrm.constants.PropertyConstants;
import com.exide.sfcrm.model.AgentList;
import com.exide.sfcrm.model.AgentListView;
import com.exide.sfcrm.model.ServiceResponse;
import com.exide.sfcrm.repository.AgentListRepository;
import com.exide.sfcrm.service.AgentListService;
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
public class AgentListController {

	/**
	 * Logger.
	 */
	private static final Logger LOGGER = Logger
			.getLogger(AgentListController.class);

	@Autowired
	AgentListService agentListService;

	@Autowired
	ObjectMapper objectMapper;

	@Autowired
	private AuditLogService activityLogService;

	@Autowired
	private CommonUtil commonUtil;

	@Autowired
	AgentListRepository agentListRepository;

	@Autowired
	private PropertyConstants propertyConstants;

	@RequestMapping(value = { "/agentList" }, method = RequestMethod.GET)
	@ResponseBody
	public String getAgentList(
			@RequestParam(value = "pageNumber") int pageNumber) {

		String response = null;
		try {

			Map<String, Object> data = agentListService.getAgentList("neethub",
					commonUtil.getOffset(pageNumber),
					propertyConstants.PAGE_LIMIT);
			ServiceResponse<Map<String, Object>> serviceResponse = new ServiceResponse<Map<String, Object>>();
			serviceResponse.setData(data);
			serviceResponse.setSuccess(ApplicationConstants.TRUE);
			serviceResponse.setMessage(MessageConstants.SUCCESS_RESPONSE);
			response = objectMapper.writeValueAsString(serviceResponse);
			activityLogService.addActivity("Get agent details", "Success",
					"Get agent details request completed successfully",
					data.toString(), commonUtil.getUserName());
		} catch (Exception e) {
			LOGGER.error(
					"Error occured while getting Agent list  details " + e, e);
			ServiceResponse<String> serviceResponse = new ServiceResponse<String>();
			serviceResponse.setData(null);
			serviceResponse.setMessage(MessageConstants.EXCEPTION_RESPONSE);
			serviceResponse.setSuccess(ApplicationConstants.FALSE);
			try {
				response = objectMapper.writeValueAsString(serviceResponse);
			} catch (JsonProcessingException e1) {
				LOGGER.error(
						"Error occured while converting response object in catch block of get Agent list details"
								+ e1, e1);
				activityLogService.addActivity("get Agent list details",
						"Success",
						"Get agent details request completed successfully", "",
						commonUtil.getUserName());
			}
		}
		return response;

	}
	@RequestMapping(value = { "/agents" }, method = RequestMethod.GET)
	@ResponseBody
	public String getAgents() {

		String response = null;
		try {

			List<AgentListView> agents= agentListService.getAgents("neethub");
			response=commonUtil.serviceResponse(MessageConstants.SUCCESS,ApplicationConstants.TRUE , agents);
			activityLogService.addActivity("Get agent details", "Success",
					"Get agent details request completed successfully",
					agents.toString(), commonUtil.getUserName());
		} catch (Exception e) {
			LOGGER.error(
					"Error occured while getting Agent list  details " + e, e);
		
			try {
				response=commonUtil.serviceResponse(MessageConstants.EXCEPTION_RESPONSE, ApplicationConstants.FALSE, null);
			} catch (JsonProcessingException e1) {
				LOGGER.error(
						"Error occured while converting response object in catch block of get Agent list details"
								+ e1, e1);
				activityLogService.addActivity("get Agent list details",
						"Success",
						"Get agent details request completed successfully", "",
						commonUtil.getUserName());
			}
		}
		return response;

	}

}
