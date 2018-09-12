/**
 * 
 */
package com.exide.sfcrm.util;

import java.text.DateFormat;
import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.util.ArrayList;
import java.util.Calendar;
import java.util.Date;
import java.util.Iterator;
import java.util.List;
import java.util.Set;

import org.hibernate.mapping.Array;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.core.context.SecurityContextHolder;
import org.springframework.stereotype.Component;

import com.exide.sfcrm.constants.PropertyConstants;
import com.exide.sfcrm.model.ServiceResponse;
import com.exide.sfcrm.model.User;
import com.fasterxml.jackson.core.JsonProcessingException;
import com.fasterxml.jackson.databind.ObjectMapper;
import com.exide.sfcrm.model.UserGroup;
import com.exide.sfcrm.service.UserManagementService;

/**
 * @author saurabhp
 *
 */
@Component
public class CommonUtil {

	@Autowired
	private ObjectMapper objectMapper;

	@Autowired
	private PropertyConstants propertyConstants;

	@Autowired
	private UserManagementService userManagementService;

	/**
	 * Get Logged In username.
	 * 
	 * @return
	 */
	public String getUserName() {

		/*
		 * UserDetails userDetails = (UserDetails) SecurityContextHolder
		 * .getContext().getAuthentication().getPrincipal();
		 * 
		 * return userDetails.getUser().getUserName();
		 */

		return null;
	}

	/**
	 * This method is used to set the service response.
	 * 
	 * @param message
	 * @param status
	 * @param data
	 * @return
	 * @throws JsonProcessingException
	 */
	public String serviceResponse(String message, boolean status, Object data)
			throws JsonProcessingException {

		ServiceResponse<Object> serviceResponse = new ServiceResponse<Object>();
		serviceResponse.setData(data);
		serviceResponse.setSuccess(status);
		serviceResponse.setMessage(message);
		return objectMapper.writeValueAsString(serviceResponse);
	}

	/**
	 * This method is used to get the offset value from page number.
	 * 
	 * @param pageNumber
	 * @return
	 */
	public Integer getOffset(int pageNumber) {
		if (pageNumber != 0 && pageNumber != 1) {
			return ((pageNumber - 1) * propertyConstants.PAGE_LIMIT + 1);
		} else
			return 0;

	}

	/**
	 * 
	 * @return
	 * @throws Exception
	 */
	public User getLoggedInUser() throws Exception {

		if (SecurityContextHolder.getContext() != null
				&& SecurityContextHolder.getContext().getAuthentication() != null
				&& SecurityContextHolder.getContext().getAuthentication()
						.getPrincipal() != null) {
			com.exide.sfcrm.authentication.UserDetails userDetails = (com.exide.sfcrm.authentication.UserDetails) SecurityContextHolder
					.getContext().getAuthentication().getPrincipal();
			return userDetails.getUser();
		} else
			return null;

	}

	/**
	 * Method takes the user Group sets to get the user role name and store in
	 * string array for further process
	 * 
	 * @param userGroups
	 * @return String array for user group values
	 */
	public String[] getUserGroupStringArray(Set<UserGroup> userGroups) {
		Iterator<UserGroup> iter = userGroups.iterator();
		String array[] = new String[userGroups.size()];
		int count = 0;
		while (iter.hasNext()) {
			String roleName = iter.next().getName();
			array[count] = roleName;
			count++;
		}
		return array;
	}

	public List<User> covertUserGrouptoListofUser(Set<UserGroup> usergroupSet)
			throws Exception {
		Iterator iter = usergroupSet.iterator();
		List<User> alluserlist = new ArrayList<User>();
		while (iter.hasNext()) {
			UserGroup usergroup = (UserGroup) iter.next();
			List<User> collection = userManagementService
					.getRoleBasedUserList(usergroup.getName());
			alluserlist.addAll(collection);
		}
		return alluserlist;
	}

	public String getDateFormat(String str_date) throws ParseException {
		SimpleDateFormat formatter = new SimpleDateFormat("dd-MMM-yyyy");
		SimpleDateFormat target = new SimpleDateFormat("YYYYMMdd");
		String newDate = target.format(formatter.parse(str_date));	
		return newDate;

	}
}
