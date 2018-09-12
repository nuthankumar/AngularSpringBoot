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

import com.exide.sfcrm.config.SmtpConfig;
import com.exide.sfcrm.constants.ApplicationConstants;
import com.exide.sfcrm.constants.MessageConstants;
import com.exide.sfcrm.constants.PropertyConstants;
import com.exide.sfcrm.model.AgentWiseContestTicketView;
import com.exide.sfcrm.model.AgentWiseContestView;
import com.exide.sfcrm.model.ServiceResponse;
import com.exide.sfcrm.model.User;
import com.exide.sfcrm.service.AuditLogService;
import com.exide.sfcrm.service.CheckerContestListService;
import com.exide.sfcrm.util.CommonUtil;
import com.fasterxml.jackson.core.JsonProcessingException;
import com.fasterxml.jackson.databind.ObjectMapper;

/**
 * 
 * @author vasavivr
 *
 */
@Controller
public class CheckerContestListController {

	private static final Logger LOGGER = Logger
			.getLogger(MasterController.class);

	@Autowired
	CheckerContestListService checkerContestListService;

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

	@RequestMapping(value = { "/checkerContestList" }, method = RequestMethod.GET)
	@ResponseBody
	public String getChekerContestList(
			@RequestParam(value = "pageNumber") int pageNumber) {
		String response = null;
		try {
			Map<String, Object> data = checkerContestListService
					.getCheckerContestList("neethub",
							commonUtil.getOffset(pageNumber),
							propertyConstants.PAGE_LIMIT);
			/*List<User>user=userManagementController.getUser("checker");
			smtpConfig.sendMailtoGroup(user);*/
			ServiceResponse<Map<String, Object>> serviceResponse = new ServiceResponse<Map<String, Object>>();
			serviceResponse.setData(data);
			serviceResponse.setSuccess(ApplicationConstants.TRUE);
			serviceResponse.setMessage(MessageConstants.SUCCESS_RESPONSE);
			response = objectMapper.writeValueAsString(serviceResponse);
			activityLogService
					.addActivity(
							"Get checker contest details",
							"Success",
							"Get checker contest details request completed successfully",
							data.toString(), commonUtil.getUserName());
		} catch (Exception e) {
			LOGGER.error(
					"Error occured while getting Checker contest list  details "
							+ e, e);
			ServiceResponse<String> serviceResponse = new ServiceResponse<String>();
			serviceResponse.setData(null);
			serviceResponse.setMessage(MessageConstants.EXCEPTION_RESPONSE);
			serviceResponse.setSuccess(ApplicationConstants.FALSE);
			try {
				response = objectMapper.writeValueAsString(serviceResponse);
			} catch (JsonProcessingException e1) {
				LOGGER.error(
						"Error occured while converting response object in catch block of get Checker contest list details"
								+ e1, e1);
				activityLogService
						.addActivity(
								"Get Checker contest details",
								"Success",
								"Get Checker contest details request completed successfully",
								"", commonUtil.getUserName());
			}
		}

		return response;

	}

	@RequestMapping(value = { "/agentWiseCheckerContestList" }, method = RequestMethod.GET)
	@ResponseBody
	public String getAgentWiseCheckerContestList(
			@RequestParam(value = "contestId") String contestId) {

		String response = null;
		try {
			List<AgentWiseContestView> agentWiseCheckerContestList = checkerContestListService
					.getAgentWiseCheckerContestList("neethub", contestId);
			ServiceResponse<List<AgentWiseContestView>> serviceResponse = new ServiceResponse<List<AgentWiseContestView>>();
			serviceResponse.setData(agentWiseCheckerContestList);
			serviceResponse.setSuccess(ApplicationConstants.TRUE);
			serviceResponse.setMessage(MessageConstants.SUCCESS_RESPONSE);
			response = objectMapper.writeValueAsString(serviceResponse);
			activityLogService
					.addActivity(
							"Get agent wise checker contest details",
							"Success",
							"Get agent wise checker contest detail request completed successfully",
							agentWiseCheckerContestList.toString(),
							commonUtil.getUserName());
		} catch (Exception e) {
			LOGGER.error(
					"Error occured while getting  agent wise checker contest details"
							+ e, e);
			ServiceResponse<String> serviceResponse = new ServiceResponse<String>();
			serviceResponse.setData(null);
			serviceResponse.setMessage(MessageConstants.EXCEPTION_RESPONSE);
			serviceResponse.setSuccess(ApplicationConstants.FALSE);
			try {
				response = objectMapper.writeValueAsString(serviceResponse);
			} catch (JsonProcessingException e1) {
				LOGGER.error(
						"Error occured while converting response object in catch block of agent wise checker contest details"
								+ e, e);
				activityLogService
						.addActivity(
								"Get agent wise checker contest details",
								"Success",
								"Get agent wise checker contest details request completed successfully",
								"", commonUtil.getUserName());
			}

		}

		return response;

	}

	@RequestMapping(value = { "/updateTransactionCashChecker" }, method = RequestMethod.PUT)
	@ResponseBody
	public String updateTransactionCash(
			@RequestBody List<Map<String, String>> json) {
		// http://localhost:8090/SFCRM/updateTransactionCashChecker?contestId=201712015&agentNo=60081489&remarks=Approved
		String response = null;

		try {
			String checkerId = "neethub", checkerName = "neethub";
			int update = checkerContestListService
					.updateTransactionCashChecker(checkerId, checkerName, json);
			ServiceResponse<String> serviceResponse = new ServiceResponse<String>();
			serviceResponse.setSuccess(ApplicationConstants.TRUE);
			serviceResponse.setMessage(MessageConstants.SUCCESS);
			response = objectMapper.writeValueAsString(serviceResponse);

			activityLogService
					.addActivity(
							"Update checker approval for payout",
							"Success",
							"Update checker approval for payout completed successfully",
							String.valueOf(update), commonUtil.getUserName());
		} catch (Exception e) {
			LOGGER.error(
					"Error occured while Updating checker approval for payout "
							+ e, e);
			ServiceResponse<String> serviceResponse = new ServiceResponse<String>();
			serviceResponse.setData(null);
			serviceResponse.setMessage(MessageConstants.EXCEPTION_RESPONSE);
			serviceResponse.setSuccess(ApplicationConstants.FALSE);
			try {
				response = objectMapper.writeValueAsString(serviceResponse);
			} catch (JsonProcessingException e1) {
				LOGGER.error(
						"Error occured while converting response object in catch block of Update checker approval for payout"
								+ e1, e1);
				activityLogService
						.addActivity(
								"Update checker approval for payout",
								"Success",
								"Update checker approval for payout completed successfully",
								"", commonUtil.getUserName());
			}
		}
		return response;
	}

	@RequestMapping(value = { "/checkerContestTicketsList" }, method = RequestMethod.GET)
	@ResponseBody
	public String getContestTicketsList(
			@RequestParam(value = "pageNumber") int pageNumber) {
		String response = null;

		try {
			Map<String, Object> data = checkerContestListService
					.getCheckerContestTicketsList("neethub",
							commonUtil.getOffset(pageNumber),
							propertyConstants.PAGE_LIMIT);
			response = commonUtil.serviceResponse(MessageConstants.SUCCESS,
					ApplicationConstants.TRUE, data);
			activityLogService.addActivity("Get  checkerTicket list",
					"Success",
					"Get checkerTicket list request completed successfully",
					data.toString(), commonUtil.getUserName());
		} catch (Exception e) {
			LOGGER.error(
					"Error occured while getting checkerTicket list details "
							+ e, e);

			try {
				response = commonUtil.serviceResponse(
						MessageConstants.EXCEPTION_RESPONSE,
						ApplicationConstants.FALSE, null);
			} catch (JsonProcessingException e1) {
				LOGGER.error(
						"Error occured while converting response object in catch block of get checkerTicket list details"
								+ e1, e1);
				activityLogService
						.addActivity(
								"get checkerTicket list details",
								"Success",
								"Get checkerTicket list details request completed successfully",
								"", commonUtil.getUserName());
			}

		}
		return response;

	}

	@RequestMapping(value = { "/agentWiseCheckerContestTicketList" }, method = RequestMethod.GET)
	@ResponseBody
	public String getAgentWiseMakerContestTicketList(
			@RequestParam(value = "contestId") String contestId) {
		String response = null;
		try {
			List<AgentWiseContestTicketView> data = checkerContestListService
					.getCheckerContestTicketsList("vasavivr", contestId);
			response = commonUtil.serviceResponse(MessageConstants.SUCCESS,
					ApplicationConstants.TRUE, data);
			activityLogService
					.addActivity(
							"Get  agentWiseCheckerTicket list",
							"Success",
							"Get agent Wise checkerTicket list request completed successfully",
							data.toString(), commonUtil.getUserName());
		} catch (Exception e) {
			LOGGER.error(
					"Error occured while getting checkerTicket list details "
							+ e, e);

			try {
				response = commonUtil.serviceResponse(
						MessageConstants.EXCEPTION_RESPONSE,
						ApplicationConstants.FALSE, null);
			} catch (JsonProcessingException e1) {
				LOGGER.error(
						"Error occured while converting response object in catch block of get agentWiseCheckerTicket list details"
								+ e1, e1);
				activityLogService
						.addActivity(
								"get agentWiseCheckerTicket list details",
								"Success",
								"Get agentWiseCheckerTicket list details request completed successfully",
								"", commonUtil.getUserName());
			}

		}
		return response;

	}

	@RequestMapping(value = { "/transactionTicketChecker" }, method = RequestMethod.PUT)
	@ResponseBody
	public String updateTransactionTicketMaker(
			@RequestBody List<Map<String, String>> json) {
		String response = null;
		try {
			String checkerId = "neethub", checkerName = "Neethu";
			int update = checkerContestListService.updateTransactionTicketChecker(
					json, checkerId, checkerName);
			response = commonUtil.serviceResponse(MessageConstants.SUCCESS,
					ApplicationConstants.TRUE, null);
			activityLogService.addActivity("update checker approval for payout",
					"Success",
					" update checker approval for payout completed successfully",
					String.valueOf(update), commonUtil.getUserName());
		} catch (Exception e) {
			LOGGER.error(
					"Error occured while Updating checker approval for payout "
							+ e, e);

			try {
				response = commonUtil.serviceResponse(
						MessageConstants.EXCEPTION_RESPONSE,
						ApplicationConstants.FALSE, null);
			} catch (JsonProcessingException e1) {
				LOGGER.error(
						"Error occured while converting response object in catch block of update checker approval for payout"
								+ e1, e1);
				activityLogService
						.addActivity(
								" update checker approval for payout",
								"Success",
								"update checker approval for payout completed successfully",
								"", commonUtil.getUserName());
			}
		}
		return response;
	}
	
	@RequestMapping(value = { "/rejectTransactionCashChecker" }, method = RequestMethod.PUT)
	@ResponseBody
	public String rejectTransactionCash(
			@RequestBody List<Map<String, String>> json) {
		String response = null;
		try {
			String checkerId = "neethub", checkerName = "Neethu";
			int update = checkerContestListService.rejectTransactionCashChecker(
					json, checkerId, checkerName);
			response = commonUtil.serviceResponse(MessageConstants.SUCCESS,
					ApplicationConstants.TRUE, null);
			activityLogService.addActivity("reject checker approval for payout",
					"Success",
					"reject checker approval for payout completed successfully",
					String.valueOf(update), commonUtil.getUserName());
		} catch (Exception e) {
			LOGGER.error(
					"Error occured while Rejecting checker approval for payout "
							+ e, e);

			try {
				response = commonUtil.serviceResponse(
						MessageConstants.EXCEPTION_RESPONSE,
						ApplicationConstants.FALSE, null);
			} catch (JsonProcessingException e1) {
				LOGGER.error(
						"Error occured while converting response object in catch block of reject checker approval for payout"
								+ e1, e1);
				activityLogService
						.addActivity(
								"reject checker approval for payout",
								"Success",
								"reject checker approval for payout completed successfully",
								"", commonUtil.getUserName());
			}
		}
		return response;
	}
	@RequestMapping(value = { "/rejectransactionTicketChecker" }, method = RequestMethod.PUT)
	@ResponseBody
	public String rejecttransactionTicketChecker(
			@RequestBody List<Map<String, String>> json) {
		String response = null;
		try {
			String checkerId = "neethub", checkerName = "Neethu";
			int update = checkerContestListService.rejectTransactionTicketChecker(
					json, checkerId, checkerName);
			response = commonUtil.serviceResponse(MessageConstants.SUCCESS,
					ApplicationConstants.TRUE, null);
			activityLogService.addActivity("reject checker approval for payout",
					"Success",
					" reject checker approval for payout completed successfully",
					String.valueOf(update), commonUtil.getUserName());
		} catch (Exception e) {
			LOGGER.error(
					"Error occured while rejecting checker approval for payout "
							+ e, e);

			try {
				response = commonUtil.serviceResponse(
						MessageConstants.EXCEPTION_RESPONSE,
						ApplicationConstants.FALSE, null);
			} catch (JsonProcessingException e1) {
				LOGGER.error(
						"Error occured while converting response object in catch block of reject checker approval for payout"
								+ e1, e1);
				activityLogService
						.addActivity(
								" reject checker approval for payout",
								"Success",
								"reject checker approval for payout completed successfully",
								"", commonUtil.getUserName());
			}
		}
		return response;
	}
	

}