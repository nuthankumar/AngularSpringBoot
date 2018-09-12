/**
 * 
 */
package com.exide.sfcrm.controller;

import org.apache.log4j.Logger;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.ResponseBody;

import com.exide.sfcrm.constants.ApplicationConstants;
import com.exide.sfcrm.constants.MessageConstants;
import com.exide.sfcrm.service.AuditLogService;
import com.exide.sfcrm.service.CallidusService;
import com.exide.sfcrm.util.CommonUtil;
import com.fasterxml.jackson.core.JsonProcessingException;

/**
 * @author saurabhp
 *
 */
@Controller
public class CallidusController {
	
	@Autowired
	private CallidusService callidusService;
	
	@Autowired
	private CommonUtil commonUtil;
	
	@Autowired
	private AuditLogService activityLogService;
	
	
	/**
	 * Logger.
	 */
	private static final Logger LOGGER = Logger.getLogger(CallidusController.class);
	
	/**
	 * 
	 * @return
	 */
	@RequestMapping(value="/getViewData", method = RequestMethod.GET)
	@ResponseBody
	public String getDataIntoTables(){
		
		LOGGER.debug("Inside Get all data into tables method");
		
		 String response =  null;
		 boolean status = false;
		
		try {
			
			status = callidusService.getDataIntoTables();
			
			response = commonUtil.serviceResponse(MessageConstants.SUCCESS_RESPONSE, ApplicationConstants.TRUE, status);
			
			activityLogService.addActivity("Get All Data Into tables", MessageConstants.SUCCESS, "Get All data in tables request completed successfully",
					String.valueOf(status), commonUtil.getUserName());
			LOGGER.debug("Get All Data Into tables method executed successfully");
		} catch (Exception e) {
			
			LOGGER.error("Error occured while getting Get All Data Into tables "+e,e);
			try {
				response =  commonUtil.serviceResponse(MessageConstants.EXCEPTION_RESPONSE, ApplicationConstants.FALSE, null);
			} catch (JsonProcessingException e1) {
				LOGGER.error("Error occured while converting response object in catch block of Get All Data Into tables"+e,e);
			}
			
			activityLogService.addActivity("Get All Data Into tables", MessageConstants.FAILURE, "Get All Data Into tables request failed",
					"", commonUtil.getUserName());
		}
		
		return response;
	}
	
	/**
	 * 
	 * @return
	 */
	@RequestMapping(value="/callidusRun", method = RequestMethod.GET)
	@ResponseBody
	public String callidusRun(){
		
		LOGGER.debug("Inside Callidus Run method");
		
		 String response =  null;
		 boolean status = false;
		
		try {
			
			status = callidusService.callidusRun();
			
			response = commonUtil.serviceResponse(MessageConstants.SUCCESS_RESPONSE, ApplicationConstants.TRUE, status);
			
			activityLogService.addActivity("Callidus Run", MessageConstants.SUCCESS, "Get All data in tables request completed successfully",
					String.valueOf(status), commonUtil.getUserName());
			LOGGER.debug("Callidus Run method executed successfully");
		} catch (Exception e) {
			
			LOGGER.error("Error occured while getting Callidus Run "+e,e);
			try {
				response =  commonUtil.serviceResponse(MessageConstants.EXCEPTION_RESPONSE, ApplicationConstants.FALSE, null);
			} catch (JsonProcessingException e1) {
				LOGGER.error("Error occured while converting response object in catch block of Callidus Run"+e,e);
			}
			
			activityLogService.addActivity("Callidus Run", MessageConstants.FAILURE, "Callidus Run request failed",
					"", commonUtil.getUserName());
		}
		
		return response;
	}

}
