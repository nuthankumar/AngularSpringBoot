package com.exide.sfcrm.controller;

import java.util.List;

import org.apache.log4j.Logger;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.ResponseBody;
import org.springframework.web.bind.annotation.RestController;

import com.exide.sfcrm.constants.ApplicationConstants;
import com.exide.sfcrm.constants.MessageConstants;
import com.exide.sfcrm.dto.VendorTransactionDto;
import com.exide.sfcrm.model.CostCenter;
import com.exide.sfcrm.model.VendorTransaction;
import com.exide.sfcrm.service.AuditLogService;
import com.exide.sfcrm.service.VendorService;
import com.exide.sfcrm.service.VendorTransactionService;
import com.exide.sfcrm.util.CommonUtil;
import com.fasterxml.jackson.core.JsonProcessingException;
import com.fasterxml.jackson.databind.ObjectMapper;

@RestController
public class VendorTransactionController {
	
	private static final Logger LOGGER = Logger
			.getLogger(VendorTransactionController.class);
	@Autowired
	VendorTransactionService vendorTranscationService;
	
	@Autowired
	VendorService vendorService;

	@Autowired
	private ObjectMapper objectMapper;

	@Autowired
	private AuditLogService activityLogService;

	@Autowired
	private CommonUtil commonUtil;
	
	
	
	@RequestMapping(value = { "/VendorTranscationList" }, method = RequestMethod.GET)
	@ResponseBody
	public String getVendorTranscationList() {

		LOGGER.info("Inside Get all users method");

		String response = null;

		try {

			List<VendorTransaction> vendorTranscations = vendorTranscationService.getVendorTranscationList();
			response = commonUtil.serviceResponse(
					MessageConstants.SUCCESS_RESPONSE,
					ApplicationConstants.TRUE, vendorTranscations);

		} catch (Exception e) {

			LOGGER.error("Error occured while getting vendor List " + e, e);
			try {
				response = commonUtil.serviceResponse(
						MessageConstants.EXCEPTION_RESPONSE,
						ApplicationConstants.FALSE, null);
			} catch (JsonProcessingException e1) {
				LOGGER.error(
						"Error occured while converting response object in catch block of get vendor List"
								+ e, e);
			}
		}

		return response;
	}
	
	
	@RequestMapping(value = { "/costCenterlList" }, method = RequestMethod.GET)
	@ResponseBody
	public String getcostCenterlList() {

		LOGGER.info("Inside getcostCenterlList method");

		String response = null;

		try {
			List<CostCenter> costCenterList = vendorTranscationService.getCostCenterDetails();
			response = commonUtil.serviceResponse(
					MessageConstants.SUCCESS_RESPONSE,
					ApplicationConstants.TRUE, costCenterList);

		} catch (Exception e) {

			LOGGER.error("Error occured while getting getcostCenterlList " + e, e);
			try {
				response = commonUtil.serviceResponse(
						MessageConstants.EXCEPTION_RESPONSE,
						ApplicationConstants.FALSE, null);
			} catch (JsonProcessingException e1) {
				LOGGER.error(
						"Error occured while converting response object in catch block of getcostCenterlList"
								+ e, e);
			}
		}

		return response;
	}
	
	
	@RequestMapping(value = { "/channelType" }, method = RequestMethod.GET)
	@ResponseBody
	public String getChannelType(@RequestParam (value  = "costCenterId") Integer costCenter) {

		LOGGER.info("Inside getcostCenterlList method");

		String response = null;

		try {
			String channeltype = vendorTranscationService.getChannelType(costCenter);
			response = commonUtil.serviceResponse(
					MessageConstants.SUCCESS_RESPONSE,
					ApplicationConstants.TRUE, channeltype);

		} catch (Exception e) {

			LOGGER.error("Error occured while getting getcostCenterlList " + e, e);
			try {
				response = commonUtil.serviceResponse(
						MessageConstants.EXCEPTION_RESPONSE,
						ApplicationConstants.FALSE, null);
			} catch (JsonProcessingException e1) {
				LOGGER.error(
						"Error occured while converting response object in catch block of getcostCenterlList"
								+ e, e);
			}
		}

		return response;
	}
	
	 // Pagination
	
	@RequestMapping(value = { "/VendorTranscationPageList" }, method = RequestMethod.GET)
	@ResponseBody
	public String getVendorTranscationPagingList(Pageable pageable) {

		LOGGER.info("Inside Get all users method");

		String response = null;

		try {

			Page<VendorTransaction> vendorTranscations = vendorTranscationService.getVendorTranscationListPagination(pageable);
			response = commonUtil.serviceResponse(
					MessageConstants.SUCCESS_RESPONSE,
					ApplicationConstants.TRUE, vendorTranscations);

		} catch (Exception e) {

			LOGGER.error("Error occured while getting vendor List " + e, e);
			try {
				response = commonUtil.serviceResponse(
						MessageConstants.EXCEPTION_RESPONSE,
						ApplicationConstants.FALSE, null);
			} catch (JsonProcessingException e1) {
				LOGGER.error(
						"Error occured while converting response object in catch block of get vendor List"
								+ e, e);
			}
		}

		return response;
	}
	
	
	@RequestMapping(value = { "/saveTrans" }, method = RequestMethod.POST,produces="application/json")
	@ResponseBody
	public String saveTranscation(@RequestBody VendorTransactionDto vendorTranscation) {
		LOGGER.info(" save Transcation method");
		System.out.println("save transcation method");
		String response = null;

		try {

			VendorTransaction code = vendorTranscationService.save(vendorTranscation);

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

			LOGGER.error("Error occured while saving vendorTranscation " + e, e);
			try {
				response = commonUtil.serviceResponse(
						MessageConstants.EXCEPTION_RESPONSE,
						ApplicationConstants.FALSE, null);
			} catch (JsonProcessingException e1) {
				LOGGER.error(
						"Error occured while converting response object in catch block of save vendorTranscation "
								+ e1, e1);
			}
		}

		return response;
	}

}
