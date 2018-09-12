/**
 * 
 */
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
import com.exide.sfcrm.model.PRFListCashView;
import com.exide.sfcrm.model.PrfListTicketView;
import com.exide.sfcrm.model.ServiceResponse;
import com.exide.sfcrm.model.TblPRFGeneratedCashView;
import com.exide.sfcrm.model.TblPRFGeneratedTicketView;
import com.exide.sfcrm.service.AuditLogService;
import com.exide.sfcrm.service.PRFListService;
import com.exide.sfcrm.util.CommonUtil;
import com.fasterxml.jackson.core.JsonProcessingException;
import com.fasterxml.jackson.databind.ObjectMapper;

/**
 * @author neethub
 *
 */
@Controller
public class PRFListController {

	/**
	 * Logger.
	 */
	private static final Logger LOGGER = Logger
			.getLogger(PRFListController.class);

	@Autowired
	PRFListService prfListService;

	@Autowired
	ObjectMapper objectMapper;

	@Autowired
	PropertyConstants propertyConstants;

	@Autowired
	private AuditLogService activityLogService;

	@Autowired
	private CommonUtil commonUtil;

	@RequestMapping(value = { "/prfCashList" }, method = RequestMethod.GET)
	@ResponseBody
		
	public String getAgentList(
				@RequestParam(value = "agentType") String agentType,
				@RequestParam(value = "pageNumber") Integer pageNumber) {

		String response = null;
		try {
			String userName = commonUtil.getLoggedInUser().getUserName();
			List<PRFListCashView> prfListCash = prfListService.getPRFListCash(
					agentType, userName, commonUtil.getOffset(pageNumber),
					propertyConstants.PAGE_LIMIT);

			ServiceResponse<List<PRFListCashView>> serviceResponse = new ServiceResponse<List<PRFListCashView>>();
			serviceResponse.setData(prfListCash);
			serviceResponse.setSuccess(ApplicationConstants.TRUE);
			serviceResponse.setMessage(MessageConstants.SUCCESS_RESPONSE);
			
			
			response = objectMapper.writeValueAsString(serviceResponse);
			activityLogService.addActivity("Get PRFList cash details",
					"Success",
					"Get PRFList cash details request completed successfully",
					prfListCash.toString(), commonUtil.getUserName());
		} catch (Exception e) {
			LOGGER.error("Error occured while getting PRFList cash details "
					+ e, e);
			ServiceResponse<String> serviceResponse = new ServiceResponse<String>();
			serviceResponse.setData(null);
			serviceResponse.setMessage(MessageConstants.EXCEPTION_RESPONSE);
			serviceResponse.setSuccess(ApplicationConstants.FALSE);
			try {
				response = objectMapper.writeValueAsString(serviceResponse);
			} catch (JsonProcessingException e1) {
				LOGGER.error(
						"Error occured while converting response object in catch block of get PRFList cash details"
								+ e1, e1);
				activityLogService
						.addActivity(
								"get PRFList cash details",
								"Success",
								"Get PRFList cash details request completed successfully",
								"", commonUtil.getUserName());
			}
		}
		return response;
	}
	@RequestMapping(value = { "/generatePrf" }, method = RequestMethod.PUT)
	@ResponseBody
	public String generatePRF(@RequestBody Map<String,Object> json) {
		
		String response = null;
		try {
			String userName = commonUtil.getLoggedInUser().getUserName();
			prfListService.generatePRF(json,userName);


			response = commonUtil.serviceResponse(
					MessageConstants.SUCCESS_RESPONSE,
					ApplicationConstants.TRUE, response);
			activityLogService
					.addActivity(
							"Get prfNo list",
							"Success",
							"Get prfNo list request completed successfully",
							response.toString(), commonUtil.getUserName());
		} catch (Exception e) {
			LOGGER.error(
					"Error occured while getting prfNo list details "
							+ e, e);

			try {
				response = commonUtil.serviceResponse(
						MessageConstants.EXCEPTION_RESPONSE,
						ApplicationConstants.FALSE, null);
			} catch (JsonProcessingException e1) {
				LOGGER.error(
						"Error occured while converting response object in catch block of get prfNo list details"
								+ e1, e1);
				activityLogService
						.addActivity(
								"get prfNo list details",
								"Success",
								"Get prfNo list details request completed successfully",
								"", commonUtil.getUserName());
			}
		}
		return response;

	}
	@RequestMapping(value = { "/agentTypes" }, method = RequestMethod.GET)
	@ResponseBody
	public String getAgentType() {

		String response = null;
		try {
			List<String> agentTypes = prfListService.getAgentTypes();
			ServiceResponse<List<String>> serviceResponse = new ServiceResponse<List<String>>();
			serviceResponse.setData(agentTypes);
			serviceResponse.setSuccess(ApplicationConstants.TRUE);
			serviceResponse.setMessage(MessageConstants.SUCCESS_RESPONSE);
			response = objectMapper.writeValueAsString(serviceResponse);
		} catch (Exception e) {

			LOGGER.error("Error occured while getting agentTypes "
					+ e, e);

			ServiceResponse<String> serviceResponse = new ServiceResponse<String>();
			serviceResponse.setData(null);
			serviceResponse.setMessage(MessageConstants.EXCEPTION_RESPONSE);
			serviceResponse.setSuccess(ApplicationConstants.FALSE);
			try {
				response = objectMapper.writeValueAsString(serviceResponse);
			} catch (JsonProcessingException e1) {
				LOGGER.error(
						"Error occured while converting response object in catch block of get agentTypes "
								+ e, e);
			}

		}
		return response;
	}
	
	@RequestMapping(value = { "/generatePrfTicket" }, method = RequestMethod.PUT)
	@ResponseBody
	public String generatePRFTicket(@RequestBody Map<String,Object> json) {
		
		String response = null;
		try {
			String userName = commonUtil.getLoggedInUser().getUserName();
			prfListService.generatePRFTicket(json,userName);


		response = commonUtil.serviceResponse(
					MessageConstants.SUCCESS_RESPONSE,
					ApplicationConstants.TRUE, "");
			activityLogService
					.addActivity(
							"Get prfNo list",
							"Success",
							"Get prfNo list request completed successfully",
							"", commonUtil.getUserName());
		} catch (Exception e) {
			LOGGER.error(
					"Error occured while getting prf ticket "
							+ e, e);

			try {
				response = commonUtil.serviceResponse(
						MessageConstants.EXCEPTION_RESPONSE,
						ApplicationConstants.FALSE, null);
			} catch (JsonProcessingException e1) {
				LOGGER.error(
						"Error occured while converting response object in catch block of prf ticket "
								+ e1, e1);
				activityLogService
						.addActivity(
								"prf generate ticket ",
								"Fail",
								"Prf generate failed",
								"", commonUtil.getUserName());
			}
		}
		return response;

	}

	
	@RequestMapping(value = { "/prfTicketList" }, method = RequestMethod.GET)
	@ResponseBody
		
	public String getPrfTicketListDetails(
				@RequestParam(value = "agentType") String agentType,
				@RequestParam(value = "pageNumber") Integer pageNumber) {

		String response = null;
		try {
			String userName = commonUtil.getLoggedInUser().getUserName();
			List<PrfListTicketView> prfListTicket = prfListService.getPRFListTicket(
					agentType, userName, commonUtil.getOffset(pageNumber),
					propertyConstants.PAGE_LIMIT);

			response = commonUtil.serviceResponse(MessageConstants.SUCCESS_RESPONSE, ApplicationConstants.TRUE, prfListTicket);
			activityLogService.addActivity("Get PRFList cash details",
					"Success",
					"Get PRFList cash details request completed successfully",
					prfListTicket.toString(), commonUtil.getUserName());
		} catch (Exception e) {
			LOGGER.error("Error occured while getting PRFList ticket details "
					+ e, e);
				try {
					response = commonUtil.serviceResponse(MessageConstants.ERROR_RESPONSE, ApplicationConstants.FALSE, null);
				} catch (JsonProcessingException e1) {
					LOGGER.error(
							"Error occured while converting response object in catch block of get prf list  tickets details "
									+ e1, e1);
					activityLogService
							.addActivity(
									"get prf list ticket details",
									"Fail",
									"Prf list ticket details request failed",
									"", commonUtil.getUserName());
				}
		}
		return response;
	}
	@RequestMapping(value = { "/getPrfListGenerated" }, method = RequestMethod.GET)
	@ResponseBody
	public String getPrfPrintListGenerated() {
		String response = null;
		try {
	List<String> prfPrintList = prfListService.getPrfPrintListGenerated();
			response = commonUtil.serviceResponse(
					MessageConstants.SUCCESS_RESPONSE,
					ApplicationConstants.TRUE, prfPrintList);
			activityLogService.addActivity("Get prfPrintList ", "Success",
					"Getting prfPrintList completed successfully",
					String.valueOf(prfPrintList), commonUtil.getUserName());
		} catch (Exception e) {
			LOGGER.error("Error occured while Getting prfPrintList details "
					+ e, e);
			try {
				response = commonUtil.serviceResponse(
						MessageConstants.EXCEPTION_RESPONSE,
						ApplicationConstants.FALSE, null);
			} catch (JsonProcessingException e1) {
				LOGGER.error(
						"Error occured while converting response object in catch block of Getting prfPrintList"
								+ e1, e1);
				activityLogService.addActivity("Getting prfPrintList",
						"Success",
						"Getting prfPrintList completed successfully", "",
						commonUtil.getUserName());
			}
		}

		return response;
	}	
	

	@RequestMapping(value = { "/printPrfGenDate" }, method = RequestMethod.GET)
	@ResponseBody
	public String getPrfPrintList(
			@RequestParam(value = "prfGENDate") String prfGENDate) {
		String response = null;
		try {
			String userName = commonUtil.getLoggedInUser().getUserName();
			List<TblPRFGeneratedCashView> prfPrintList = prfListService.getPrfPrintList(
					prfGENDate, userName);
			response = commonUtil.serviceResponse(
					MessageConstants.SUCCESS_RESPONSE,
					ApplicationConstants.TRUE, prfPrintList);
			activityLogService.addActivity("Get prfPrintList ", "Success",
					"Getting prfPrintList completed successfully",
					String.valueOf(prfPrintList), commonUtil.getUserName());
		} catch (Exception e) {
			LOGGER.error("Error occured while Getting prfPrintList details "
					+ e, e);
			try {
				response = commonUtil.serviceResponse(
						MessageConstants.EXCEPTION_RESPONSE,
						ApplicationConstants.FALSE, null);
			} catch (JsonProcessingException e1) {
				LOGGER.error(
						"Error occured while converting response object in catch block of Getting prfPrintList"
								+ e1, e1);
				activityLogService.addActivity("Getting prfPrintList",
						"Success",
						"Getting prfPrintList completed successfully", "",
						commonUtil.getUserName());
			}
		}

		return response;
	}

	@RequestMapping(value = { "/printPrfNo" }, method = RequestMethod.GET)
	@ResponseBody
	public String getPrfPrintListByNo(
			@RequestParam(value = "prfNo") String prfNo) {
		String response = null;
		try {
			String userName = commonUtil.getLoggedInUser().getUserName();
			List<TblPRFGeneratedCashView> prfPrintList = prfListService.getPrfPrintListByNo(
					prfNo, userName);
			response = commonUtil.serviceResponse(
					MessageConstants.SUCCESS_RESPONSE,
					ApplicationConstants.TRUE, prfPrintList);
			activityLogService.addActivity("Get prfPrintList ", "Success",
					"Getting prfPrintList completed successfully",
					String.valueOf(prfPrintList), commonUtil.getUserName());
		} catch (Exception e) {
			LOGGER.error("Error occured while Getting prfPrintList details "
					+ e, e);
			try {
				response = commonUtil.serviceResponse(
						MessageConstants.EXCEPTION_RESPONSE,
						ApplicationConstants.FALSE, null);
			} catch (JsonProcessingException e1) {
				LOGGER.error(
						"Error occured while converting response object in catch block of Getting prfPrintList"
								+ e1, e1);
				activityLogService.addActivity("Getting prfPrintList",
						"Success",
						"Getting prfPrintList completed successfully", "",
						commonUtil.getUserName());
			}
		}

		return response;
	}

	@RequestMapping(value = { "/printPrfByDate" }, method = RequestMethod.GET)
	@ResponseBody
	public String getPrfPrintListByDate(
			@RequestParam(value = "startDate") String startDate,
			@RequestParam(value = "endDate") String endDate) {
		String response = null;
		try {
			String userName = commonUtil.getLoggedInUser().getUserName();
			List<TblPRFGeneratedCashView> prfPrintList = prfListService.getPrfPrintListByDate(
					startDate, endDate, userName);
			response = commonUtil.serviceResponse(
					MessageConstants.SUCCESS_RESPONSE,
					ApplicationConstants.TRUE, prfPrintList);
			activityLogService.addActivity("Get prfPrintList ", "Success",
					"Getting prfPrintList completed successfully",
					String.valueOf(prfPrintList), commonUtil.getUserName());
		} catch (Exception e) {
			LOGGER.error("Error occured while Getting prfPrintList details "
					+ e, e);
			try {
				response = commonUtil.serviceResponse(
						MessageConstants.EXCEPTION_RESPONSE,
						ApplicationConstants.FALSE, null);
			} catch (JsonProcessingException e1) {
				LOGGER.error(
						"Error occured while converting response object in catch block of Getting prfPrintList"
								+ e1, e1);
				activityLogService.addActivity("Getting prfPrintList",
						"Success",
						"Getting prfPrintList completed successfully", "",
						commonUtil.getUserName());
			}
		}

		return response;
	}


	
	@RequestMapping(value = { "/utrNoForCash" }, method = RequestMethod.PUT)
	@ResponseBody
	public String updateUtrNo(@RequestBody List<Map<String, String>> json) {

		String response = null;
		try {
			Integer  update=prfListService.updateUtrNo(json);

			
			response = commonUtil.serviceResponse(MessageConstants.SUCCESS,
					ApplicationConstants.TRUE, null);
			activityLogService.addActivity("update utrNo and transferDate for prfdownload",
					"Success",
					" update utrNo and transferDate for prfdownload completed successfully",
					update.toString(), commonUtil.getUserName());
		} catch (Exception e) {
			LOGGER.error(
					"Error occured while Updating utrNo and transferDate for prfdownload "
							+ e, e);

			try {
				response = commonUtil.serviceResponse(
						MessageConstants.EXCEPTION_RESPONSE,
						ApplicationConstants.FALSE, null);
			} catch (JsonProcessingException e1) {
				LOGGER.error(
						"Error occured while converting response object in catch block of update utrNo and transferDate for prfdownload"
								+ e1, e1);
				activityLogService
						.addActivity(
								"update utrNo and transferDate for prfdownload",
								"Success",
								"update utrNo and transferDate for prfdownload",
								"", commonUtil.getUserName());
			}
		}
		return response;
	}
	
	@RequestMapping(value = { "/getPrfTicketListGenerated" }, method = RequestMethod.GET)
	@ResponseBody
	public String getPrfTicketListGenerated() {
		String response = null;
		try {
	List<String> prfPrintList = prfListService.getPrfTicketListGenerated();
			response = commonUtil.serviceResponse(
					MessageConstants.SUCCESS_RESPONSE,
					ApplicationConstants.TRUE, prfPrintList);
			activityLogService.addActivity("Get prfPrintList ", "Success",
					"Getting prfPrintList completed successfully",
					String.valueOf(prfPrintList), commonUtil.getUserName());
		} catch (Exception e) {
			LOGGER.error("Error occured while Getting prfPrintList details "
					+ e, e);
			try {
				response = commonUtil.serviceResponse(
						MessageConstants.EXCEPTION_RESPONSE,
						ApplicationConstants.FALSE, null);
			} catch (JsonProcessingException e1) {
				LOGGER.error(
						"Error occured while converting response object in catch block of Getting prfPrintList"
								+ e1, e1);
				activityLogService.addActivity("Getting prfPrintList",
						"Success",
						"Getting prfPrintList completed successfully", "",
						commonUtil.getUserName());
			}
		}

		return response;
	}
	
	@RequestMapping(value = { "/printTicketPrfGenDate" }, method = RequestMethod.GET)
	@ResponseBody
	public String getPrfTicketPrintList(
			@RequestParam(value = "prfGENDate") String prfGENDate) {
		String response = null;
		try {
			String userName = commonUtil.getLoggedInUser().getUserName();
			List<TblPRFGeneratedTicketView> prfPrintList = prfListService.getPrfTicketPrintList(
					prfGENDate, userName);
			response = commonUtil.serviceResponse(
					MessageConstants.SUCCESS_RESPONSE,
					ApplicationConstants.TRUE, prfPrintList);
			activityLogService.addActivity("Get prfPrintList ", "Success",
					"Getting prfPrintList completed successfully",
					String.valueOf(prfPrintList), commonUtil.getUserName());
		} catch (Exception e) {
			LOGGER.error("Error occured while Getting prfPrintList details "
					+ e, e);
			try {
				response = commonUtil.serviceResponse(
						MessageConstants.EXCEPTION_RESPONSE,
						ApplicationConstants.FALSE, null);
			} catch (JsonProcessingException e1) {
				LOGGER.error(
						"Error occured while converting response object in catch block of Getting prfPrintList"
								+ e1, e1);
				activityLogService.addActivity("Getting prfPrintList",
						"Success",
						"Getting prfPrintList completed successfully", "",
						commonUtil.getUserName());
			}
		}

		return response;
	}

	@RequestMapping(value = { "/printTicketPrfNo" }, method = RequestMethod.GET)
	@ResponseBody
	public String getPrfTicketPrintListByNo(
			@RequestParam(value = "prfNo") String prfNo) {
		String response = null;
		try {
			String userName = commonUtil.getLoggedInUser().getUserName();
			List<TblPRFGeneratedTicketView> prfPrintList = prfListService.getPrfTicketPrintListByNo(
					prfNo, userName);
			response = commonUtil.serviceResponse(
					MessageConstants.SUCCESS_RESPONSE,
					ApplicationConstants.TRUE, prfPrintList);
			activityLogService.addActivity("Get prfPrintList ", "Success",
					"Getting prfPrintList completed successfully",
					String.valueOf(prfPrintList), commonUtil.getUserName());
		} catch (Exception e) {
			LOGGER.error("Error occured while Getting prfPrintList details "
					+ e, e);
			try {
				response = commonUtil.serviceResponse(
						MessageConstants.EXCEPTION_RESPONSE,
						ApplicationConstants.FALSE, null);
			} catch (JsonProcessingException e1) {
				LOGGER.error(
						"Error occured while converting response object in catch block of Getting prfPrintList"
								+ e1, e1);
				activityLogService.addActivity("Getting prfPrintList",
						"Success",
						"Getting prfPrintList completed successfully", "",
						commonUtil.getUserName());
			}
		}

		return response;
	}

	@RequestMapping(value = { "/printTicketPrfByDate" }, method = RequestMethod.GET)
	@ResponseBody
	public String getPrfTicketPrintListByDate(
			@RequestParam(value = "startDate") String startDate,
			@RequestParam(value = "endDate") String endDate) {
		String response = null;
		try {
			String userName = commonUtil.getLoggedInUser().getUserName();
			List<TblPRFGeneratedTicketView> prfPrintList = prfListService.getPrfTicketPrintListByDate(
					startDate, endDate, userName);
			response = commonUtil.serviceResponse(
					MessageConstants.SUCCESS_RESPONSE,
					ApplicationConstants.TRUE, prfPrintList);
			activityLogService.addActivity("Get prfPrintList ", "Success",
					"Getting prfPrintList completed successfully",
					String.valueOf(prfPrintList), commonUtil.getUserName());
		} catch (Exception e) {
			LOGGER.error("Error occured while Getting prfPrintList details "
					+ e, e);
			try {
				response = commonUtil.serviceResponse(
						MessageConstants.EXCEPTION_RESPONSE,
						ApplicationConstants.FALSE, null);
			} catch (JsonProcessingException e1) {
				LOGGER.error(
						"Error occured while converting response object in catch block of Getting prfPrintList"
								+ e1, e1);
				activityLogService.addActivity("Getting prfPrintList",
						"Success",
						"Getting prfPrintList completed successfully", "",
						commonUtil.getUserName());
			}
		}

		return response;
	}
}


