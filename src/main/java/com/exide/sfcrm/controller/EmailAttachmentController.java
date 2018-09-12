package com.exide.sfcrm.controller;

import java.io.IOException;

import javax.ws.rs.Consumes;

import org.apache.log4j.Logger;
import org.apache.poi.EncryptedDocumentException;
import org.apache.poi.openxml4j.exceptions.InvalidFormatException;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.ResponseBody;
import org.springframework.web.bind.annotation.RestController;
import org.springframework.web.multipart.MultipartFile;

import com.exide.sfcrm.constants.ApplicationConstants;
import com.exide.sfcrm.constants.MessageConstants;
import com.exide.sfcrm.constants.PropertyConstants;
import com.exide.sfcrm.service.AuditLogService;
import com.exide.sfcrm.service.EmailAttachmentService;
import com.exide.sfcrm.util.CommonUtil;
import com.fasterxml.jackson.databind.ObjectMapper;

/**
 * 
 * @author vasavivr
 *
 */


@RestController
public class EmailAttachmentController {
	private static final Logger LOGGER = Logger
			.getLogger(EmailAttachmentController.class);
	@Autowired
	ObjectMapper objectMapper;

	@Autowired
	private AuditLogService activityLogService;

	@Autowired
	private CommonUtil commonUtil;

	@Autowired
	PropertyConstants propertyConstants;

	@Autowired
	EmailAttachmentService emailAttachmentService;

	@RequestMapping(value = "/emailAttach", method = RequestMethod.POST)
	@Consumes("multipart/form-data")
	public @ResponseBody String emailAttach(
			@RequestParam("file") MultipartFile file)throws EncryptedDocumentException, InvalidFormatException, IOException
			 {
		String response = "";
		try {
			response = emailAttachmentService.emailAttach(file);
			response = commonUtil.serviceResponse(MessageConstants.SUCCESS,
					ApplicationConstants.TRUE, response);
		} catch (Exception e) {
			response = "Fail";
			response = commonUtil.serviceResponse(MessageConstants.FAILURE,
					ApplicationConstants.FALSE, response);
			LOGGER.error("Error occured while uploading email attachment " + e,
					e);

		}
		return response;
	}
	@RequestMapping(value = "/emailAttachs", method = RequestMethod.POST)
	@Consumes("multipart/form-data")
	public @ResponseBody String emailAttachs(
			@RequestParam("file") MultipartFile[] uploadfiles)throws EncryptedDocumentException, InvalidFormatException, IOException
			 {
		String response = "";
		try {
			response = emailAttachmentService.emailAttachs(uploadfiles);
			response = commonUtil.serviceResponse(MessageConstants.SUCCESS,
					ApplicationConstants.TRUE, response);
		} catch (Exception e) {
			response = "Fail";
			response = commonUtil.serviceResponse(MessageConstants.FAILURE,
					ApplicationConstants.FALSE, response);
			LOGGER.error("Error occured while uploading email attachment " + e,
					e);

		}
		return response;
	}
}
