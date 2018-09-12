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
import com.exide.sfcrm.model.AgentMaster;
import com.exide.sfcrm.model.Destination;
import com.exide.sfcrm.model.ExideContest;
import com.exide.sfcrm.model.ExideReportDataUpdate;
import com.exide.sfcrm.model.ExideRuleEngine;
import com.exide.sfcrm.model.LastUpdateView;
import com.exide.sfcrm.model.ServiceResponse;
import com.exide.sfcrm.model.TripDetailsView;
import com.exide.sfcrm.service.AgentMasterService;
import com.exide.sfcrm.service.AuditLogService;
import com.exide.sfcrm.service.ContestMasterService;
import com.exide.sfcrm.service.DestinationService;
import com.exide.sfcrm.service.MasterService;
import com.exide.sfcrm.util.CommonUtil;
import com.fasterxml.jackson.core.JsonProcessingException;
import com.fasterxml.jackson.databind.ObjectMapper;

/**
 * 
 * @author neethub
 *
 */
@Controller
public class MasterController {

	/**
	 * Logger.
	 */
	private static final Logger LOGGER = Logger
			.getLogger(MasterController.class);

	@Autowired
	MasterService masterService;

	@Autowired
	AgentMasterService agentMasterService;

	@Autowired
	ContestMasterService contestMasterService;

	@Autowired
	DestinationService destinationService;

	@Autowired
	private ObjectMapper objectMapper;

	@Autowired
	PropertyConstants propertyConstants;
	@Autowired
	private AuditLogService activityLogService;

	@Autowired
	private CommonUtil commonUtil;

	@RequestMapping(value = { "/exideContest" }, method = RequestMethod.GET)
	@ResponseBody
	public String getExideContest() {

		String response = null;
		try {
			List<ExideContest> exideContests = masterService.getExideContest();
			ServiceResponse<List<ExideContest>> serviceResponse = new ServiceResponse<List<ExideContest>>();
			serviceResponse.setData(exideContests);
			serviceResponse.setSuccess(ApplicationConstants.TRUE);
			serviceResponse.setMessage(MessageConstants.SUCCESS_RESPONSE);
			response = objectMapper.writeValueAsString(serviceResponse);
		} catch (Exception e) {

			LOGGER.error("Error occured while getting ExideContest details "
					+ e, e);

			ServiceResponse<String> serviceResponse = new ServiceResponse<String>();
			serviceResponse.setData(null);
			serviceResponse.setMessage(MessageConstants.EXCEPTION_RESPONSE);
			serviceResponse.setSuccess(ApplicationConstants.FALSE);
			try {
				response = objectMapper.writeValueAsString(serviceResponse);
			} catch (JsonProcessingException e1) {
				LOGGER.error(
						"Error occured while converting response object in catch block of get ExideContest details"
								+ e, e);
			}

		}
		return response;
	}

	@RequestMapping(value = { "/exideRuleEngine" }, method = RequestMethod.GET)
	@ResponseBody
	public String getExideRuleEngine() {
		String response = null;
		try {

			List<ExideRuleEngine> exideContests = masterService
					.getExideRuleEngine();
			ServiceResponse<List<ExideRuleEngine>> serviceResponse = new ServiceResponse<List<ExideRuleEngine>>();
			serviceResponse.setData(exideContests);
			serviceResponse.setSuccess(ApplicationConstants.TRUE);
			serviceResponse.setMessage(MessageConstants.SUCCESS_RESPONSE);
			response = objectMapper.writeValueAsString(serviceResponse);
		} catch (Exception ex) {
			LOGGER.error("Error occured while getting ExideRuleEngine details "
					+ ex, ex);
			ServiceResponse<String> serviceResponse = new ServiceResponse<String>();
			serviceResponse.setData(null);
			serviceResponse.setMessage(MessageConstants.EXCEPTION_RESPONSE);
			serviceResponse.setSuccess(ApplicationConstants.FALSE);
			try {
				response = objectMapper.writeValueAsString(serviceResponse);
			} catch (JsonProcessingException e1) {
				LOGGER.error(
						"Error occured while converting response object in catch block of get ExideRuleEngine details"
								+ e1, e1);
			}
		}

		return response;
	}

	@RequestMapping(value = { "/exidReportDataUpdate" }, method = RequestMethod.GET)
	@ResponseBody
	public String getExideReportDataUpdate() {
		String response = null;
		try {
			List<ExideReportDataUpdate> exideReportUpdate = masterService
					.getExideReportDataUpdate();
			ServiceResponse<List<ExideReportDataUpdate>> serviceResponse = new ServiceResponse<List<ExideReportDataUpdate>>();
			serviceResponse.setData(exideReportUpdate);
			serviceResponse.setSuccess(ApplicationConstants.TRUE);
			serviceResponse.setMessage(MessageConstants.SUCCESS_RESPONSE);
			response = objectMapper.writeValueAsString(serviceResponse);
		} catch (Exception e) {
			LOGGER.error(
					"Error occured while getting ExideReportDataUpdate details "
							+ e, e);
			ServiceResponse<String> serviceResponse = new ServiceResponse<String>();
			serviceResponse.setData(null);
			serviceResponse.setMessage(MessageConstants.EXCEPTION_RESPONSE);
			serviceResponse.setSuccess(ApplicationConstants.FALSE);
			try {
				response = objectMapper.writeValueAsString(serviceResponse);
			} catch (JsonProcessingException e1) {
				LOGGER.error(
						"Error occured while converting response object in catch block of get ExideReportDataUpdate details"
								+ e1, e1);
			}
		}

		return response;
	}

	@RequestMapping(value = { "/agentMaster" }, method = RequestMethod.GET)
	@ResponseBody
	public String getAgentMaster() {

		String response = null;
		try {
			List<AgentMaster> agentMasters = agentMasterService
					.getAgentMaster();
			ServiceResponse<List<AgentMaster>> serviceResponse = new ServiceResponse<List<AgentMaster>>();
			serviceResponse.setData(agentMasters);
			serviceResponse.setSuccess(ApplicationConstants.TRUE);
			serviceResponse.setMessage(MessageConstants.SUCCESS_RESPONSE);
			response = objectMapper.writeValueAsString(serviceResponse);
		} catch (Exception e) {

			LOGGER.error(
					"Error occured while getting agentMaster details " + e, e);

			ServiceResponse<String> serviceResponse = new ServiceResponse<String>();
			serviceResponse.setData(null);
			serviceResponse.setMessage(MessageConstants.EXCEPTION_RESPONSE);
			serviceResponse.setSuccess(ApplicationConstants.FALSE);
			try {
				response = objectMapper.writeValueAsString(serviceResponse);
			} catch (JsonProcessingException e1) {
				LOGGER.error(
						"Error occured while converting response object in catch block of get agentMaster details"
								+ e, e);
			}

		}
		return response;
	}

	@RequestMapping(value = { "/contestMasterWithTripDetails" }, method = RequestMethod.GET)
	@ResponseBody
	public String getContestMasterWithTripDetails() {

		String response = null;
		try {
			Map<String, Object> contestMasters = contestMasterService
					.getContestMasterWithTripDetails();
			ServiceResponse<Map<String, Object>> serviceResponse = new ServiceResponse<Map<String, Object>>();
			serviceResponse.setData(contestMasters);
			serviceResponse.setSuccess(ApplicationConstants.TRUE);
			serviceResponse.setMessage(MessageConstants.SUCCESS_RESPONSE);
			response = objectMapper.writeValueAsString(serviceResponse);

		} catch (Exception e) {

			LOGGER.error("Error occured while getting contestMaster details"
					+ e, e);
			ServiceResponse<String> serviceResponse = new ServiceResponse<String>();
			serviceResponse.setData(null);
			serviceResponse.setMessage(MessageConstants.EXCEPTION_RESPONSE);
			serviceResponse.setSuccess(ApplicationConstants.FALSE);
			try {
				response = objectMapper.writeValueAsString(serviceResponse);
			} catch (JsonProcessingException e1) {
				LOGGER.error(
						"Error occured while converting response object in catch block of get contestMaster details"
								+ e, e);
			}
		}
		return response;

	}

	@RequestMapping(value = { "/contestMaster" }, method = RequestMethod.GET)
	@ResponseBody
	public String getContestMaster(
			@RequestParam("pageNumber") Integer pageNumber) {

		String response = null;
		try {
			Map<String, Object> contestMasters = contestMasterService
					.getContestMaster(commonUtil.getOffset(pageNumber),
							propertyConstants.PAGE_LIMIT);
			ServiceResponse<Map<String, Object>> serviceResponse = new ServiceResponse<Map<String, Object>>();
			serviceResponse.setData(contestMasters);
			serviceResponse.setSuccess(ApplicationConstants.TRUE);
			serviceResponse.setMessage(MessageConstants.SUCCESS_RESPONSE);
			response = objectMapper.writeValueAsString(serviceResponse);

		} catch (Exception e) {

			LOGGER.error("Error occured while getting contestMaster details"
					+ e, e);
			ServiceResponse<String> serviceResponse = new ServiceResponse<String>();
			serviceResponse.setData(null);
			serviceResponse.setMessage(MessageConstants.EXCEPTION_RESPONSE);
			serviceResponse.setSuccess(ApplicationConstants.FALSE);
			try {
				response = objectMapper.writeValueAsString(serviceResponse);
			} catch (JsonProcessingException e1) {
				LOGGER.error(
						"Error occured while converting response object in catch block of get contestMaster details"
								+ e, e);
			}
		}
		return response;

	}

	@RequestMapping(value = { "/destinationPlace" }, method = RequestMethod.GET)
	@ResponseBody
	public String getDestinationPlace() {
		String response = null;
		try {
			List<Destination> destinations = destinationService
					.getDestinationPlace();
			ServiceResponse<List<Destination>> serviceResponse = new ServiceResponse<List<Destination>>();
			serviceResponse.setData(destinations);
			serviceResponse.setSuccess(ApplicationConstants.TRUE);
			serviceResponse.setMessage(MessageConstants.SUCCESS_RESPONSE);
			response = objectMapper.writeValueAsString(serviceResponse);

		} catch (Exception e) {
			LOGGER.error(
					"Error occured while getting Destination place details" + e,
					e);
			ServiceResponse<String> serviceResponse = new ServiceResponse<String>();
			serviceResponse.setData(null);
			serviceResponse.setMessage(MessageConstants.EXCEPTION_RESPONSE);
			serviceResponse.setSuccess(ApplicationConstants.FALSE);
			try {
				response = objectMapper.writeValueAsString(serviceResponse);
			} catch (JsonProcessingException e1) {
				LOGGER.error(
						"Error occured while converting response object in catch block of get destination details"
								+ e, e);
			}
		}
		return response;

	}

	@RequestMapping(value = { "/addDestinationPlace" }, method = RequestMethod.POST)
	@ResponseBody
	public String addDestination(@RequestBody Destination destination) {
		LOGGER.info("Inside addDestinationPlace method");

		String response = null;

		try {

			Destination add = destinationService
					.addDestinationPlace(destination);

			if (null != add) {

				response = commonUtil.serviceResponse(
						MessageConstants.SUCCESS_RESPONSE,
						ApplicationConstants.TRUE, add);
			} else {

				response = commonUtil.serviceResponse(
						MessageConstants.ERROR_RESPONSE,
						ApplicationConstants.FALSE, null);
				LOGGER.error("Error occured while adding destinationPlace ");
			}

		} catch (Exception e) {

			LOGGER.error("Error occured while adding destinationPlace " + e, e);
			try {
				response = commonUtil.serviceResponse(
						MessageConstants.EXCEPTION_RESPONSES,
						ApplicationConstants.FALSE, null);
			} catch (JsonProcessingException e1) {
				LOGGER.error(
						"Error occured while converting response object in catch block of adding destinationPlace "
								+ e1, e1);
			}
		}

		return response;
	}

	@RequestMapping(value = { "/editDestinationPlace" }, method = RequestMethod.PUT)
	@ResponseBody
	public String editDestinationPlace(@RequestBody Destination destination) {
		LOGGER.info("Inside addDestinationPlace method");

		String response = null;

		try {

			Destination edit = destinationService
					.updateDestinationPlace(destination);

			if (null != edit) {

				response = commonUtil.serviceResponse(
						MessageConstants.SUCCESS_RESPONSE,
						ApplicationConstants.TRUE, edit);
			} else {

				response = commonUtil.serviceResponse(
						MessageConstants.ERROR_RESPONSE,
						ApplicationConstants.FALSE, null);
			}

		} catch (Exception e) {

			LOGGER.error("Error occured while editing destinationPlace " + e, e);
			try {
				response = commonUtil.serviceResponse(
						MessageConstants.EXCEPTION_RESPONSE,
						ApplicationConstants.FALSE, null);
			} catch (JsonProcessingException e1) {
				LOGGER.error(
						"Error occured while converting response object in catch block of editing destinationPlace "
								+ e1, e1);
			}
		}

		return response;
	}

	@RequestMapping(value = { "/tripDetails" }, method = RequestMethod.GET)
	@ResponseBody
	public String getTripDetails(
			@RequestParam(value = "contestId") Integer contestId) {

		String response = null;
		try {

			List<TripDetailsView> tripDetails = contestMasterService
					.getTripDetails(contestId);
			response = commonUtil.serviceResponse(MessageConstants.SUCCESS,
					ApplicationConstants.TRUE, tripDetails);
			activityLogService.addActivity("Get contests details", "Success",
					"Get trip details request completed successfully",
					tripDetails.toString(), commonUtil.getUserName());
		} catch (Exception e) {
			LOGGER.error("Error occured while getting trip list  details "
					+ e, e);

			try {
				response = commonUtil.serviceResponse(
						MessageConstants.EXCEPTION_RESPONSE,
						ApplicationConstants.FALSE, null);
			} catch (JsonProcessingException e1) {
				LOGGER.error(
						"Error occured while converting response object in catch block of get trip list details"
								+ e1, e1);
				activityLogService.addActivity("get trip list details",
						"Success",
						"Get trip details request completed successfully",
						"", commonUtil.getUserName());
			}
		}
		return response;

	}

}
