package com.exide.sfcrm.controller;

import java.io.IOException;
import java.util.List;

import org.apache.log4j.Logger;
import org.apache.poi.EncryptedDocumentException;
import org.apache.poi.openxml4j.exceptions.InvalidFormatException;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.ResponseBody;
import org.springframework.web.multipart.MultipartFile;

import com.exide.sfcrm.constants.ApplicationConstants;
import com.exide.sfcrm.constants.MessageConstants;
import com.exide.sfcrm.constants.PropertyConstants;
import com.exide.sfcrm.model.PRFListCashView;
import com.exide.sfcrm.model.ServiceResponse;
import com.exide.sfcrm.model.TblTransactionTickets;
import com.exide.sfcrm.model.TicketExcelView;
import com.exide.sfcrm.pojo.TicketExcelPojo;
import com.exide.sfcrm.service.AuditLogService;
import com.exide.sfcrm.service.DeviationTicketsService;
import com.exide.sfcrm.service.TicketUploadService;
import com.exide.sfcrm.util.CommonUtil;
import com.fasterxml.jackson.core.JsonProcessingException;
import com.fasterxml.jackson.databind.ObjectMapper;

/**
 * 
 * @author vasavivr
 *
 */
@Controller
public class TicketUploadController {

	private static final Logger LOGGER = Logger
			.getLogger(TicketUploadController.class);

	@Autowired
	ObjectMapper objectMapper;

	@Autowired
	private AuditLogService activityLogService;


	@Autowired
	PropertyConstants propertyConstants;

	@Autowired
	CommonUtil commonUtil;

	@Autowired
	private TicketUploadService ticketUploadService;

	@RequestMapping(value = { "/uploadTicketData" }, method = RequestMethod.POST)
	@ResponseBody
	public String uploadTicketData(@RequestParam MultipartFile file)
			throws EncryptedDocumentException, InvalidFormatException,
			IOException {

		String response = "";
		try {
			response = ticketUploadService.uploadTicketDetails(file);
			ServiceResponse<String> serviceResponse = new ServiceResponse<String>();
			serviceResponse.setData(response);
			serviceResponse.setSuccess(ApplicationConstants.TRUE);
			serviceResponse.setMessage(MessageConstants.SUCCESS_RESPONSE);
		} catch (Exception ex) {
			response = "Fail";
			ServiceResponse<String> serviceResponse = new ServiceResponse<String>();
			serviceResponse.setData(response);
			serviceResponse.setSuccess(ApplicationConstants.FALSE);
			serviceResponse.setMessage(MessageConstants.FAILURE);
			LOGGER.error("Error occoured while updating ticket details for agent choice");
		}
		return response;
	}

	@RequestMapping(value = { "/downloadExcel" }, method = RequestMethod.GET)
	@ResponseBody
	public String downloadExcel() {

		String response = null;
		try {
			List<TicketExcelView> data = ticketUploadService
					.downloadExcel("neethub");

			response = commonUtil.serviceResponse(
					MessageConstants.SUCCESS_RESPONSE,
					ApplicationConstants.TRUE, data);
			activityLogService.addActivity("Get ticket list",
					"Success",
					"Get ticket listcount request completed successfully",
					"", commonUtil.getUserName());
		} catch (Exception e) {
			LOGGER.error("Error occoured while downloading ticket details for agent choice"
					+ e, e);

			try {
				response = commonUtil.serviceResponse(
						MessageConstants.EXCEPTION_RESPONSE,
						ApplicationConstants.FALSE, null);
			} catch (JsonProcessingException e1) {
				LOGGER.error(
						"Error occured while converting response object in catch block of get ticket list details"
								+ e1, e1);
				activityLogService
						.addActivity(
								"get ticket list details",
								"Success",
								"Get ticket list details request completed successfully",
								"", commonUtil.getUserName());
			}
		}
		return response;
	}

}
