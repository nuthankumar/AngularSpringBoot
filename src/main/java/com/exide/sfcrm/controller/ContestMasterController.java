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
import com.exide.sfcrm.model.AgentListView;
import com.exide.sfcrm.model.ContestView;
import com.exide.sfcrm.model.ContestsDrpView;
import com.exide.sfcrm.model.LastUpdateView;
import com.exide.sfcrm.service.AuditLogService;
import com.exide.sfcrm.service.ContestMasterService;
import com.exide.sfcrm.util.CommonUtil;
import com.fasterxml.jackson.core.JsonProcessingException;
import com.fasterxml.jackson.databind.ObjectMapper;
/**
 * 
 * @author vasavivr
 *
 */

@Controller
public class ContestMasterController {

	@Autowired
	ContestMasterService contestMasterService;

	@Autowired
	ObjectMapper objectMapper;

	@Autowired
	PropertyConstants propertyConstants;

	@Autowired
	private AuditLogService activityLogService;

	@Autowired
	private CommonUtil commonUtil;
	/**
	 * Logger.
	 */
	private static final Logger LOGGER = Logger
			.getLogger(ContestMasterController.class);
	
	@RequestMapping(value = { "/channelList" }, method = RequestMethod.GET)
	@ResponseBody
	public String getAdvancePayList(
			@RequestParam(value = "pageNumber") int pageNumber) {

		String response = null;
		try {
			Map<String, Object> data = contestMasterService
					.getChannelList(true,"vasavivr",
							commonUtil.getOffset(pageNumber),
							propertyConstants.PAGE_LIMIT);

			response = commonUtil.serviceResponse(
					MessageConstants.SUCCESS_RESPONSE,
					ApplicationConstants.TRUE, data);
			activityLogService.addActivity("Get  channel  list", "Success",
					"Get channel list request completed successfully",
					data.toString(), commonUtil.getUserName());
		} catch (Exception e) {
			LOGGER.error("Error occured while getting channel list details "
					+ e, e);

			try {
				response = commonUtil.serviceResponse(
						MessageConstants.EXCEPTION_RESPONSE,
						ApplicationConstants.FALSE, null);
			} catch (JsonProcessingException e1) {
				LOGGER.error(
						"Error occured while converting response object in catch block of get channel list details"
								+ e1, e1);
				activityLogService
						.addActivity(
								"get channel list details",
								"Success",
								"Get channel list details request completed successfully",
								"", commonUtil.getUserName());
			}
		}
		return response;

	}
	@RequestMapping(value = { "/addContest" }, method = RequestMethod.PUT)
	@ResponseBody
	public String addContest(@RequestBody List<Map<String, String>> json) {

		String response = null;
		try {
			contestMasterService.addContest(json, "vasavivr");

			/*
			 * response = commonUtil.serviceResponse(
			 * MessageConstants.SUCCESS_RESPONSE, ApplicationConstants.TRUE,
			 * prfNo); activityLogService .addActivity( "Get contest list",
			 * "Success", "Get contest list request completed successfully", ,
			 * commonUtil.getUserName());
			 */
		} catch (Exception e) {
			LOGGER.error("Error occured while getting contest list details "
					+ e, e);

			try {
				response = commonUtil.serviceResponse(
						MessageConstants.EXCEPTION_RESPONSE,
						ApplicationConstants.FALSE, null);
			} catch (JsonProcessingException e1) {
				LOGGER.error(
						"Error occured while converting response object in catch block of get contest list details"
								+ e1, e1);
				activityLogService
						.addActivity(
								"get contest list details",
								"Success",
								"Get contest list details request completed successfully",
								"", commonUtil.getUserName());
			}
		}
		return response;
	}
	@RequestMapping(value = { "/allContests" }, method = RequestMethod.GET)
	@ResponseBody
	public String getAllContests() {

		String response = null;
		try {

			List<ContestView> contests= contestMasterService.getAllContests();
			response=commonUtil.serviceResponse(MessageConstants.SUCCESS,ApplicationConstants.TRUE , contests);
			activityLogService.addActivity("Get contests details", "Success",
					"Get contests details request completed successfully",
					contests.toString(), commonUtil.getUserName());
		} catch (Exception e) {
			LOGGER.error(
					"Error occured while getting contests list  details " + e, e);
		
			try {
				response=commonUtil.serviceResponse(MessageConstants.EXCEPTION_RESPONSE, ApplicationConstants.FALSE, null);
			} catch (JsonProcessingException e1) {
				LOGGER.error(
						"Error occured while converting response object in catch block of get contests list details"
								+ e1, e1);
				activityLogService.addActivity("get contests list details",
						"Success",
						"Get contests details request completed successfully", "",
						commonUtil.getUserName());
			}
		}
		return response;

	}

	@RequestMapping(value = { "/allContestsDrp" }, method = RequestMethod.GET)
	@ResponseBody
	public String getAllContestsDrp() {

		String response = null;
		try {

			List<ContestsDrpView> contestsdrp= contestMasterService.getAllContestsDrp();
			response=commonUtil.serviceResponse(MessageConstants.SUCCESS,ApplicationConstants.TRUE , contestsdrp);
			activityLogService.addActivity("Get contests details", "Success",
					"Get contests details request completed successfully",
					contestsdrp.toString(), commonUtil.getUserName());
		} catch (Exception e) {
			LOGGER.error(
					"Error occured while getting contests list  details " + e, e);
		
			try {
				response=commonUtil.serviceResponse(MessageConstants.EXCEPTION_RESPONSE, ApplicationConstants.FALSE, null);
			} catch (JsonProcessingException e1) {
				LOGGER.error(
						"Error occured while converting response object in catch block of get contests list details"
								+ e1, e1);
				activityLogService.addActivity("get contests list details",
						"Success",
						"Get contests details request completed successfully", "",
						commonUtil.getUserName());
			}
		}
		return response;

	}
	@RequestMapping(value = { "/lastUpdateDate" }, method = RequestMethod.GET)
	@ResponseBody
	public String getlastUpdateDate() {

		String response = null;
		try {

			List<LastUpdateView> lastUpdateDate= contestMasterService.getlastUpdateDate();
			response=commonUtil.serviceResponse(MessageConstants.SUCCESS,ApplicationConstants.TRUE , lastUpdateDate);
			activityLogService.addActivity("Get contests details", "Success",
					"Get contests details request completed successfully",
					lastUpdateDate.toString(), commonUtil.getUserName());
		} catch (Exception e) {
			LOGGER.error(
					"Error occured while getting contests list  details " + e, e);
		
			try {
				response=commonUtil.serviceResponse(MessageConstants.EXCEPTION_RESPONSE, ApplicationConstants.FALSE, null);
			} catch (JsonProcessingException e1) {
				LOGGER.error(
						"Error occured while converting response object in catch block of get contests list details"
								+ e1, e1);
				activityLogService.addActivity("get contests list details",
						"Success",
						"Get contests details request completed successfully", "",
						commonUtil.getUserName());
			}
		}
		return response;

	}

}

