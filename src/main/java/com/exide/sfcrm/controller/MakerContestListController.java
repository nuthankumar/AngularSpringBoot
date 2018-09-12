package com.exide.sfcrm.controller;

import java.util.List;
import java.util.Map;
import java.util.Set;

import org.apache.log4j.Logger;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.ResponseBody;

import com.exide.sfcrm.config.SmtpConfig;
import com.exide.sfcrm.constants.ApplicationConstants;
import com.exide.sfcrm.constants.MessageConstants;
import com.exide.sfcrm.constants.PropertyConstants;
import com.exide.sfcrm.model.AgentWiseContestTicketView;
import com.exide.sfcrm.model.AgentWiseContestView;
import com.exide.sfcrm.model.ServiceResponse;
import com.exide.sfcrm.model.User;
import com.exide.sfcrm.model.UserGroup;
import com.exide.sfcrm.service.AuditLogService;
import com.exide.sfcrm.service.MakerContestListService;
import com.exide.sfcrm.util.CommonUtil;
import com.exide.sfcrm.util.JSONUtils;
import com.fasterxml.jackson.core.JsonProcessingException;
import com.fasterxml.jackson.databind.ObjectMapper;

/**
 * 
 * @author neethub
 *
 */
@Controller
public class MakerContestListController {

	/**
	 * Logger.
	 */
	private static final Logger LOGGER = Logger
			.getLogger(MasterController.class);

	@Autowired
	MakerContestListService makerContestListService;

	@Autowired
	private ObjectMapper objectMapper;

	@Autowired
	private AuditLogService activityLogService;

	@Autowired
	private CommonUtil commonUtil;

	@Autowired
	private PropertyConstants propertyConstants;
	
	@Autowired
	private UserManagementController userManagementController;
	
	@Autowired
	private SmtpConfig smtpConfig;
	
	@Autowired
	private JSONUtils jsonUtils;

	@RequestMapping(value = { "/makerContestList" }, method = RequestMethod.GET)
	@ResponseBody
	public String getMakerContestList(
			@RequestParam(value = "pageNumber") int pageNumber) {

		String response = null;
		try {
			String userName = commonUtil.getLoggedInUser().getUserName();
			Map<String, Object> data = makerContestListService .getMakerContestList(userName, commonUtil.getOffset(pageNumber),
							propertyConstants.PAGE_LIMIT);
		
			ServiceResponse<Map<String, Object>> serviceResponse = new ServiceResponse<Map<String, Object>>();
			serviceResponse.setData(data);
			serviceResponse.setSuccess(ApplicationConstants.TRUE);
			serviceResponse.setMessage(MessageConstants.SUCCESS_RESPONSE);
			response = objectMapper.writeValueAsString(serviceResponse);
			activityLogService.addActivity("Get maker contest details",
					"Success",
					"Get maker contest details request completed successfully",
					data.toString(), commonUtil.getUserName());
		} catch (Exception e) {
			LOGGER.error(
					"Error occured while getting Maker contest list  details "
							+ e, e);
			ServiceResponse<String> serviceResponse = new ServiceResponse<String>();
			serviceResponse.setData(null);
			serviceResponse.setMessage(MessageConstants.EXCEPTION_RESPONSE);
			serviceResponse.setSuccess(ApplicationConstants.FALSE);
			try {
				response = objectMapper.writeValueAsString(serviceResponse);
			} catch (JsonProcessingException e1) {
				LOGGER.error(
						"Error occured while converting response object in catch block of get Maker contest list details"
								+ e1, e1);
				activityLogService
						.addActivity(
								"Get maker contest details",
								"Success",
								"Get maker contest details request completed successfully",
								"", commonUtil.getUserName());
			}
		}
		return response;
	}

	@RequestMapping(value = { "/agentWiseMakerContestList" }, method = RequestMethod.GET)
	@ResponseBody
	public String getAgentWiseMakerContestList(
			@RequestParam(value = "contestId") String contestId) {

		String response = null;
		try {
			String userName = commonUtil.getLoggedInUser().getUserName();
			List<AgentWiseContestView> agentWiseContestList = makerContestListService
					.getAgentWiseMakerContestList(userName, contestId);
			ServiceResponse<List<AgentWiseContestView>> serviceResponse = new ServiceResponse<List<AgentWiseContestView>>();
			serviceResponse.setData(agentWiseContestList);
			serviceResponse.setSuccess(ApplicationConstants.TRUE);
			serviceResponse.setMessage(MessageConstants.SUCCESS_RESPONSE);
			response = objectMapper.writeValueAsString(serviceResponse);
			activityLogService.addActivity(
					"Get agent wise maker contest details", "Success"

					,
					"Get maker contest details request completed successfully",
					agentWiseContestList.toString(), commonUtil.getUserName());
		} catch (Exception e) {
			LOGGER.error(
					"Error occured while getting agent wise Maker contest list  details "
							+ e, e);
			ServiceResponse<String> serviceResponse = new ServiceResponse<String>();
			serviceResponse.setData(null);
			serviceResponse.setMessage(MessageConstants.EXCEPTION_RESPONSE);
			serviceResponse.setSuccess(ApplicationConstants.FALSE);
			try {
				response = objectMapper.writeValueAsString(serviceResponse);
			} catch (JsonProcessingException e1) {
				LOGGER.error(
						"Error occured while converting response object in catch block of get agent wise maker contest list details"
								+ e1, e1);
				activityLogService
						.addActivity(
								"Get  agent wise maker contest details",
								"Success",
								"Get agent wise maker contest details request completed successfully",
								"", commonUtil.getUserName());
			}
		}
		return response;
	}

	@RequestMapping(value = { "/transactionCashMaker" }, method = RequestMethod.PUT)
	@ResponseBody
	public String updateTransactionCash(
			@RequestBody List<Map<String, String>> json) {

		// http://localhost:8090/SFCRM/transactionCashMaker?contestId=201712015&agentNo=60081489&remarks=Approved
		String response = null;
		try {
			String makerId = "neethub", makerName = "Neethu";
			int update = makerContestListService.updateTransactionCashMaker(
					json, makerId, makerName);

			ServiceResponse<String> serviceResponse = new ServiceResponse<String>();
			serviceResponse.setData(MessageConstants.SUCCESS);
			serviceResponse.setSuccess(ApplicationConstants.TRUE);
			serviceResponse.setMessage(MessageConstants.SUCCESS_RESPONSE);
			response = objectMapper.writeValueAsString(serviceResponse);
			activityLogService.addActivity("Update maker approval for payout",
					"Success",
					"Update maker approval for payout completed successfully",
					String.valueOf(update), commonUtil.getUserName());
		} catch (Exception e) {
			LOGGER.error(
					"Error occured while Updating maker approval for payout "
							+ e, e);
			ServiceResponse<String> serviceResponse = new ServiceResponse<String>();
			serviceResponse.setData(null);
			serviceResponse.setMessage(MessageConstants.EXCEPTION_RESPONSE);
			serviceResponse.setSuccess(ApplicationConstants.FALSE);
			try {
				response = objectMapper.writeValueAsString(serviceResponse);
			} catch (JsonProcessingException e1) {
				LOGGER.error(
						"Error occured while converting response object in catch block of Update maker approval for payout"
								+ e1, e1);
				activityLogService
						.addActivity(
								"Update maker approval for payout",
								"Success",
								"Update maker approval for payout completed successfully",
								"", commonUtil.getUserName());
			}
		}
		return response;
	}

	@RequestMapping(value = { "/rejectTransactionCashMaker" }, method = RequestMethod.PUT)
	@ResponseBody
	public String rejectTransactionCash(
			@RequestBody List<Map<String, String>> json) {
		String response = null;
		try {
			String makerId = "neethub", makerName = "Neethu";
			int update = makerContestListService.rejectTransactionCashMaker(
					json, makerId, makerName);
			response = commonUtil.serviceResponse(MessageConstants.SUCCESS,
					ApplicationConstants.TRUE, null);
			activityLogService.addActivity("reject maker approval for payout",
					"Success",
					"reject maker approval for payout completed successfully",
					String.valueOf(update), commonUtil.getUserName());
		} catch (Exception e) {
			LOGGER.error(
					"Error occured while Rejecting maker approval for payout "
							+ e, e);

			try {
				response = commonUtil.serviceResponse(
						MessageConstants.EXCEPTION_RESPONSE,
						ApplicationConstants.FALSE, null);
			} catch (JsonProcessingException e1) {
				LOGGER.error(
						"Error occured while converting response object in catch block of reject maker approval for payout"
								+ e1, e1);
				activityLogService
						.addActivity(
								"reject maker approval for payout",
								"Success",
								"reject maker approval for payout completed successfully",
								"", commonUtil.getUserName());
			}
		}
		return response;
	}

	@RequestMapping(value = { "/makerContestTicketsList" }, method = RequestMethod.GET)
	@ResponseBody
	public String getMakerContestTicketsList(
			@RequestParam(value = "pageNumber") int pageNumber) {
		String response = null;

		try {
			String userName = commonUtil.getLoggedInUser().getUserName();
			Map<String, Object> data = makerContestListService
					.getMakerContestTicketsList(userName,
							commonUtil.getOffset(pageNumber),
							propertyConstants.PAGE_LIMIT);
			response = commonUtil.serviceResponse(MessageConstants.SUCCESS,
					ApplicationConstants.TRUE, data);
			activityLogService.addActivity("Get  makerTicket list", "Success",
					"Get makerTicket list request completed successfully",
					data.toString(), commonUtil.getUserName());
		} catch (Exception e) {
			LOGGER.error(
					"Error occured while getting makerTicket list details " + e,
					e);

			try {
				response = commonUtil.serviceResponse(
						MessageConstants.EXCEPTION_RESPONSE,
						ApplicationConstants.FALSE, null);
			} catch (JsonProcessingException e1) {
				LOGGER.error(
						"Error occured while converting response object in catch block of get makerTicket list details"
								+ e1, e1);
				activityLogService
						.addActivity(
								"get makerTicket list details",
								"Success",
								"Get makerTicket list details request completed successfully",
								"", commonUtil.getUserName());
			}

		}
		return response;

	}

	@RequestMapping(value = { "/agentWiseMakerContestTicketList" }, method = RequestMethod.GET)
	@ResponseBody
	public String getAgentWiseMakerContestTicketList(
			@RequestParam(value = "contestId") String contestId) {
		String response = null;
		try {
			String userName = commonUtil.getLoggedInUser().getUserName();
			List<AgentWiseContestTicketView> data = makerContestListService
					.getMakerContestTicketsList(userName, contestId);
			response = commonUtil.serviceResponse(MessageConstants.SUCCESS,
					ApplicationConstants.TRUE, data);
			activityLogService
					.addActivity(
							"Get  agentWiseMakerTicket list",
							"Success",
							"Get agent Wise MakerTicket list request completed successfully",
							data.toString(), commonUtil.getUserName());
		} catch (Exception e) {
			LOGGER.error(
					"Error occured while getting makerTicket list details " + e,
					e);

			try {
				response = commonUtil.serviceResponse(
						MessageConstants.EXCEPTION_RESPONSE,
						ApplicationConstants.FALSE, null);
			} catch (JsonProcessingException e1) {
				LOGGER.error(
						"Error occured while converting response object in catch block of get agentWiseMakerTicket list details"
								+ e1, e1);
				activityLogService
						.addActivity(
								"get agentWiseMakerTicket list details",
								"Success",
								"Get agentWiseMakerTicket list details request completed successfully",
								"", commonUtil.getUserName());
			}

		}
		return response;

	}

	@RequestMapping(value = { "/transactionTicketMaker" }, method = RequestMethod.PUT)
	@ResponseBody
	public String updateTransactionTicketMaker(
			@RequestBody List<Map<String, String>> json) {
		String response = null;
		try {
			String makerId = "vasavivr", makerName = "Vasavi";
			int update = makerContestListService.updateTransactionTicketMaker(
					json, makerId, makerName);
			response = commonUtil.serviceResponse(MessageConstants.SUCCESS,
					ApplicationConstants.TRUE, null);
			activityLogService.addActivity("update maker approval for payout",
					"Success",
					" update maker approval for payout completed successfully",
					String.valueOf(update), commonUtil.getUserName());
		} catch (Exception e) {
			LOGGER.error(
					"Error occured while Updating maker approval for payout "
							+ e, e);

			try {
				response = commonUtil.serviceResponse(
						MessageConstants.EXCEPTION_RESPONSE,
						ApplicationConstants.FALSE, null);
			} catch (JsonProcessingException e1) {
				LOGGER.error(
						"Error occured while converting response object in catch block of update maker approval for payout"
								+ e1, e1);
				activityLogService
						.addActivity(
								" update maker approval for payout",
								"Success",
								"update maker approval for payout completed successfully",
								"", commonUtil.getUserName());
			}
		}
		return response;
	}
	@RequestMapping(value = { "/rejectTransactionTicketMaker" }, method = RequestMethod.PUT)
	@ResponseBody
	public String rejectTransactionTicketMaker(
			@RequestBody List<Map<String, String>> json) {
		String response = null;
		try {
			String makerId = "vasavivr", makerName = "Vasavi";
			int update = makerContestListService.rejectTransactionTicketMaker(
					json, makerId, makerName);
			response = commonUtil.serviceResponse(MessageConstants.SUCCESS,
					ApplicationConstants.TRUE, null);
			activityLogService.addActivity("update maker approval for payout",
					"Success",
					" update maker approval for payout completed successfully",
					String.valueOf(update), commonUtil.getUserName());
		} catch (Exception e) {
			LOGGER.error(
					"Error occured while Updating maker approval for payout "
							+ e, e);

			try {
				response = commonUtil.serviceResponse(
						MessageConstants.EXCEPTION_RESPONSE,
						ApplicationConstants.FALSE, null);
			} catch (JsonProcessingException e1) {
				LOGGER.error(
						"Error occured while converting response object in catch block of update maker approval for payout"
								+ e1, e1);
				activityLogService
						.addActivity(
								" update maker approval for payout",
								"Success",
								"update maker approval for payout completed successfully",
								"", commonUtil.getUserName());
			}
		}
		return response;
	}
}