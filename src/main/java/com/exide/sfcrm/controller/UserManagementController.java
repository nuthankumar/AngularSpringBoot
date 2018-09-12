/**
 * 
 */
package com.exide.sfcrm.controller;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.Date;
import java.util.HashMap;
import java.util.List;
import java.util.Map;
import java.util.Set;

import org.apache.log4j.Logger;
import org.json.JSONObject;
import org.json.simple.JSONArray;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.ResponseBody;

import com.exide.sfcrm.authentication.ActiveDirectoryUser;
import com.exide.sfcrm.constants.ApplicationConstants;
import com.exide.sfcrm.constants.MessageConstants;
import com.exide.sfcrm.constants.PropertyConstants;
import com.exide.sfcrm.model.User;
import com.exide.sfcrm.model.UserGroup;
import com.exide.sfcrm.model.UserGroupPermission;
import com.exide.sfcrm.service.AuditLogService;
import com.exide.sfcrm.service.UserManagementService;
import com.exide.sfcrm.util.CommonUtil;
import com.exide.sfcrm.util.JSONUtils;
import com.fasterxml.jackson.core.JsonProcessingException;
import com.fasterxml.jackson.databind.ObjectMapper;

/**
 * @author saurabhp
 *
 */
@Controller
@RequestMapping("/user")
public class UserManagementController {

	/**
	 * Logger.
	 */
	private static final Logger LOGGER = Logger.getLogger(UserManagementController.class);
	
	@Autowired
	private UserManagementService userManagementService;
	
	@Autowired
	private ObjectMapper objectMapper;
	
	@Autowired
	private AuditLogService activityLogService;
	
	@Autowired
	private CommonUtil commonUtil;
	
	@Autowired
	private JSONUtils jsonUtils;
	
	@Autowired
	private PropertyConstants propertyConstants;
	
	@Autowired
	private ActiveDirectoryUser activeDirectory;

	
	/**
	 * Get all users.
	 * @return
	 */
	@RequestMapping(value={"/users"}, method = RequestMethod.GET)
	@ResponseBody
	public String getAllUsers(){
		
		LOGGER.debug("Inside Get all users method");
		
		 String response =  null;
		
		try {
			
			List<User> users = userManagementService.getUserList();
			if(null != users){
				
				for(User user : users){
					Set<UserGroup> userGroups = userManagementService.getAllUserGroupBasedOnId(user.getId());
					user.setUserGroup(userGroups);
				}
			
			}
			response = commonUtil.serviceResponse(MessageConstants.SUCCESS_RESPONSE, ApplicationConstants.TRUE, users);
			
			activityLogService.addActivity("Get All Users", MessageConstants.SUCCESS, "Get User request completed successfully",
					users.toString(), commonUtil.getUserName());
			LOGGER.debug("Get user method executed successfully");
		} catch (Exception e) {
			
			LOGGER.error("Error occured while getting user details "+e,e);
			try {
				response =  commonUtil.serviceResponse(MessageConstants.EXCEPTION_RESPONSE, ApplicationConstants.FALSE, null);
			} catch (JsonProcessingException e1) {
				LOGGER.error("Error occured while converting response object in catch block of get user details"+e,e);
			}
			
			activityLogService.addActivity("Get All Users", MessageConstants.FAILURE, "Get User request failed",
					"", commonUtil.getUserName());
		}
		
		return response;
	} 
	
	
	/**
	 * Get users based on roles.
	 * @return
	 */
	@RequestMapping(value={"/roleBasedUsers"}, method = RequestMethod.GET)
	@ResponseBody
	public String getUsersBasedonRoles(@RequestParam(value="role" ) String role){
		
		 LOGGER.debug("Inside Get users based on roles method");
		 String response =  null;
		
		try {
			
			List<User> users = getUser(role);
			if(null != users){
				
				for(User user : users){
					Set<UserGroup> userGroups = userManagementService.getAllUserGroupBasedOnId(user.getId());
					user.setUserGroup(userGroups);
				}
			
			}
			
			response = commonUtil.serviceResponse(MessageConstants.SUCCESS_RESPONSE, ApplicationConstants.TRUE, users);
			
			activityLogService.addActivity("Get All Users based on roles", MessageConstants.SUCCESS, "Get User based in roles request completed successfully",
					users.toString(), commonUtil.getUserName());
			LOGGER.debug("Role based users method executed successfully");
			
			
		} catch (Exception e) {
			
			LOGGER.error("Error occured while getting user details based on roles "+e,e);
			try {
				response =  commonUtil.serviceResponse(MessageConstants.EXCEPTION_RESPONSE, ApplicationConstants.FALSE, null);
			} catch (JsonProcessingException e1) {
				LOGGER.error("Error occured while converting response object in catch block of get user details based on roles "+e,e);
			}
			

			activityLogService.addActivity("Get All User based on roles", MessageConstants.FAILURE, "Get All User based on roles request failed",
					"", commonUtil.getUserName());
		}
		
		return response;
	} 
	
	
	
	/**
	 * Create User.
	 * @return
	 */
	@RequestMapping(value={"/user"}, method = RequestMethod.POST)
	@ResponseBody
	public String addUser(@RequestBody User user){
		
		 LOGGER.debug("Inside create user method");
		
		 String response =  null;
		
		try {
			
			user.setCreatedBy(commonUtil.getUserName());
			Integer id = userManagementService.createOrUpdateUser(user);
			
			if(null != id){
				
				response = commonUtil.serviceResponse(MessageConstants.SUCCESS_RESPONSE, ApplicationConstants.TRUE, id);
			}else{
				
				response = commonUtil.serviceResponse(MessageConstants.ERROR_RESPONSE, ApplicationConstants.FALSE, null);
			}
			//response = objectMapper.writeValueAsString(serviceResponse);
			activityLogService.addActivity("Add User", MessageConstants.SUCCESS, "Add User request completed successfully",
					id.toString(), commonUtil.getUserName());
			 LOGGER.debug("Create user method executed successfully");
			
		} catch (Exception e) {
			
			LOGGER.error("Error occured while creating user "+e,e);
			try {
				response = commonUtil.serviceResponse(MessageConstants.EXCEPTION_RESPONSE, ApplicationConstants.FALSE, null);
			} catch (JsonProcessingException e1) {
				LOGGER.error("Error occured while converting response object in catch block of create user "+e1,e1);
			}
			

			activityLogService.addActivity("Add user", MessageConstants.FAILURE, "Add User request failed",
					"", commonUtil.getUserName());
		}
		
		return response;
	}
	
	/**
	 * Validate User.
	 * @param userName
	 * @return
	 */
	@RequestMapping(value="/validateUser", method = RequestMethod.GET )
	@ResponseBody
	public String validateUser(@RequestParam(value="userName") String userName){
		
		 LOGGER.debug("Inside validate user method");
		
		String response =  null;
		try{
			boolean status = true; // userManagementService.checkUser(userName);
			JSONObject ldapUser = null;
			if(status){
				ldapUser = activeDirectory.userDetails(userName,propertyConstants.LDAP_DEFAULT_USER,propertyConstants.LDAP_DEFAULT_PASSWORD);
			}
			
			ldapUser.put("status", status);
			
			response =  ldapUser.toString();
			
			activityLogService.addActivity("Validate User", MessageConstants.SUCCESS, "Validate User request completed successfully",
					String.valueOf(status), commonUtil.getUserName());
			LOGGER.debug("Validate user method executed successfully");
		}catch(Exception e){
			
			LOGGER.error("Error occured while validating user "+e,e);
			
			try {
				response = commonUtil.serviceResponse(MessageConstants.EXCEPTION_RESPONSE, ApplicationConstants.FALSE, null);
			} catch (JsonProcessingException e1) {
				LOGGER.error("Error occured while converting response object in catch block of validate user "+e1,e1);
			}
			

			activityLogService.addActivity("Validate User", MessageConstants.FAILURE, "Valid user request failed",
					"", commonUtil.getUserName());
		}
		
		return response;
	}
	
	/**
	 * Update User.
	 * @param user
	 * @return
	 */
	@RequestMapping(value="/user", method = RequestMethod.PUT )
	@ResponseBody
	public String updateUser(@RequestBody User user){
	
		
		 LOGGER.debug("Inside update user method");
		String response =  null;
		try{
			
			//updateUserChangedData(presentUser,user);
			
			if(null == user.getPassword()){
				User presentUser = userManagementService.getUserByName(user.getUserName());
				user.setPassword(presentUser.getPassword());
			}
			user.setModifiedBy(commonUtil.getUserName());
			user.setModifiedDate(new Date());
			response = addUser(user);
			
			activityLogService.addActivity("Update User", MessageConstants.SUCCESS, "Update User request completed successfully",
					user.toString(), commonUtil.getUserName());

			
			LOGGER.debug("Update user method executed successfully");
		}catch(Exception e){
			
			LOGGER.error("Error occured while updating user "+e,e);
			try {
				response = commonUtil.serviceResponse(MessageConstants.EXCEPTION_RESPONSE, ApplicationConstants.FALSE, null);
			} catch (JsonProcessingException e1) {
				LOGGER.error("Error occured while converting response object in catch block of update user "+e1,e1);
			}
			

			activityLogService.addActivity("Update User", MessageConstants.FAILURE, "Update User request failed",
					"", commonUtil.getUserName());
		}
		
		return response;
		
	}
	
	/**
	 * Update user status.
	 * @param data
	 * @return
	 */
	@RequestMapping(value="/status", method = RequestMethod.PUT )
	@ResponseBody
	public String updateUser(@RequestBody Map<String, Object> data){
	
		
		 LOGGER.debug("Inside update user status method");
		
		String response =  null;
		try{
			
			//updateUserChangedData(presentUser,user);
			
			userManagementService.userStatus((String[])data.get("userName"), Boolean.parseBoolean(String.valueOf(data.get("status"))));
			
			response = commonUtil.serviceResponse(MessageConstants.SUCCESS_RESPONSE, ApplicationConstants.TRUE, null);
			
			activityLogService.addActivity("Update Status", MessageConstants.SUCCESS, "Update Status request completed successfully",
					data.toString(), commonUtil.getUserName());
			
			LOGGER.debug("Update user status method executed successfully");
		}catch(Exception e){
			
			LOGGER.error("Error occured while updating status user "+e,e);
			try {
				response = commonUtil.serviceResponse(MessageConstants.EXCEPTION_RESPONSE, ApplicationConstants.FALSE, null);
			} catch (JsonProcessingException e1) {
				LOGGER.error("Error occured while converting response object in catch block of updating status user "+e1,e1);
			}
			

			activityLogService.addActivity("Update user status", MessageConstants.FAILURE, "Update User Status request failed",
					"", commonUtil.getUserName());
		}
		
		return response;
		
	}
	
	/**
	 * Get all user groups.
	 * @return
	 */
	@RequestMapping(value = "/userGroups", method = RequestMethod.GET )
	@ResponseBody
	public String getAllUserGroup(){
		
		 LOGGER.debug("Inside get user group method");
		
		String response =  null;
		try{
			
			List<UserGroup> userGroups = userManagementService.getAllUserGroup();
			
			response = commonUtil.serviceResponse(MessageConstants.SUCCESS_RESPONSE, ApplicationConstants.TRUE, userGroups);
			
			activityLogService.addActivity("User Group", MessageConstants.SUCCESS, "Get all User Group request completed successfully",
					userGroups.toString(), commonUtil.getUserName());
			
			LOGGER.debug("User Group method executed successfully");
			
		}catch(Exception e){
			
			LOGGER.error("Error occured while getting user group details "+e,e);
			try {
				response = commonUtil.serviceResponse(MessageConstants.EXCEPTION_RESPONSE, ApplicationConstants.FALSE, null);
			} catch (JsonProcessingException e1) {
				LOGGER.error("Error occured while converting response object in catch block of user group details "+e1,e1);
			}
			

			activityLogService.addActivity("Get All User Group", MessageConstants.FAILURE, "Get All User Group request failed",
					"", commonUtil.getUserName());
		}
		
		return response;
	}
	
	/**
	 * Get all User Group permissions based on id
	 * @param id
	 * @return
	 */
	@RequestMapping(value="/userDetail", method = RequestMethod.GET)
	@ResponseBody
	public String getAllUserGroupPermissions(){
		
		
		 LOGGER.debug("Inside user group permissions method");
		String response =  null;
		try{
			
			User user = commonUtil.getLoggedInUser();
			
			if(null != user){
				
				
					Set<UserGroup> userGroups = userManagementService.getAllUserGroupBasedOnId(user.getId());
					user.setUserGroup(userGroups);
				
					List<Integer> userGrouIds = new ArrayList<Integer>();
					String[] roles = commonUtil.getUserGroupStringArray(userGroups);
					//String roles[] = {"Maker","Checker"};
					org.json.simple.JSONObject resultOject = new org.json.simple.JSONObject();
					JSONArray resultNavArray = new JSONArray();
					org.json.simple.JSONObject master = new org.json.simple.JSONObject();
					org.json.simple.JSONObject contest = new org.json.simple.JSONObject();
					org.json.simple.JSONObject advance = new org.json.simple.JSONObject();
					org.json.simple.JSONObject deviation = new org.json.simple.JSONObject();
					org.json.simple.JSONObject prf = new org.json.simple.JSONObject();
					org.json.simple.JSONObject callidus = new org.json.simple.JSONObject();
					if (Arrays.asList(roles).contains(jsonUtils.MAKER) || Arrays.asList(roles).contains(jsonUtils.CHECKER) || Arrays.asList(roles).contains(jsonUtils.ADMINISTRATOR)) {
						master = jsonUtils.getMasterJSON(roles);
						contest = jsonUtils.getContestJSON(roles);
						advance = jsonUtils.getAdvanceJSON(roles);
						if (Arrays.asList(roles).contains(jsonUtils.MAKER) || Arrays.asList(roles).contains(jsonUtils.ADMINISTRATOR)) {
							callidus = jsonUtils.getCallidusJSON(roles);
							}
					}
					if (Arrays.asList(roles).contains(jsonUtils.APPROVER_1) || Arrays.asList(roles).contains(jsonUtils.ADMINISTRATOR)) {
						deviation = jsonUtils.getDeviationJSON(roles);
					}
					prf = jsonUtils.getPrfJSON(roles);
					resultOject = jsonUtils.consolidateNavJSON(master, contest, advance, callidus, deviation, prf, resultOject, resultNavArray);
					
					for(UserGroup userGroup : user.getUserGroup()){
						
						userGrouIds.add(userGroup.getId());
					}
			
			List<UserGroupPermission> userGroupPermissions = userManagementService.getAllUserGroupPermission(userGrouIds);
			Map<String,Object> loggedInUser =  new HashMap<String,Object>();
			
			loggedInUser.put("user", user);
			loggedInUser.put("permissions", userGroupPermissions);
			loggedInUser.put("navigationItems", resultOject);
			
			response = commonUtil.serviceResponse(MessageConstants.SUCCESS_RESPONSE, ApplicationConstants.TRUE, loggedInUser);
			
			activityLogService.addActivity("User Group permissions", MessageConstants.SUCCESS, "Get all User Group permissions request completed successfully",
					userGroupPermissions.toString(), commonUtil.getUserName());
			
			}
			
			
			
			LOGGER.debug("User Group Permissions method executed successfully");
			
		}catch(Exception e){
			
			LOGGER.error("Error occured while getting user group details "+e,e);
			try {
				response = commonUtil.serviceResponse(MessageConstants.EXCEPTION_RESPONSE, ApplicationConstants.FALSE, null);
			} catch (JsonProcessingException e1) {
				LOGGER.error("Error occured while converting response object in catch block of user group details "+e1,e1);
			}
			

			activityLogService.addActivity("Get All User Group Permissions", MessageConstants.FAILURE, "Get All User Group Permissions request failed",
					"", commonUtil.getUserName());
		}
		
		return response;
	}
	
	public List<User> getUser(String role)throws Exception{
		
		List<User> users = userManagementService.getRoleBasedUserList(role);
		return users;
	}

	public User getUserfromUsername(String username) throws Exception {
		User user=userManagementService.getUserByName(username);
		return null;
	}
	
	/*private User updateUserChangedData(User presentUser, User changedUser) throws IllegalArgumentException, IllegalAccessException{
		
		List<Field> fields = Arrays.stream(User.class.getDeclaredFields()).filter(f -> !f.getName().equals("serialVersionUID")).collect(Collectors.toList());
		for (Field field : fields) {
	        //field.setAccessible(true); // if you want to modify private fields
			field.setAccessible(true);
	        System.out.println(field.getName()
	                 + " - " + field.getType()
	                 + " - " + field.get(changedUser));
	        
	        String[] unchangeableFields = {"isActiveUser","isAdUser", "createdBy", "createdDate", "userName","id"};
	        
	        if((null == field.get(changedUser) || (field.getName().equals("userGroup") && ((Set)(field.get(changedUser))).isEmpty()) ) && !unchangeableFields.toString().contains(field.getName())){
	        	
	            field.set(changedUser,  field.get(presentUser) );
	        }
	        
            
            System.out.println("User ==>"+changedUser.toString());
	    }
		
		return null;
	}*/
	
}
