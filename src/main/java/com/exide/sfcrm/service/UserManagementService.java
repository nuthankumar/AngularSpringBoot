/**
 * 
 */
package com.exide.sfcrm.service;

import java.util.List;
import java.util.Set;

import com.exide.sfcrm.model.User;
import com.exide.sfcrm.model.UserGroup;
import com.exide.sfcrm.model.UserGroupPermission;

/**
 * @author saurabhp
 *
 */
public interface UserManagementService {

	/**
	 * 
	 * @return
	 * @throws Exception
	 */
	public List<User> getUserList() throws Exception;
	
	/**
	 * 
	 * @return
	 * @throws Exception
	 */
	public List<User> getRoleBasedUserList(String Role) throws Exception;

	/***
	 * 
	 * @param users
	 * @param staus
	 * @throws Exception
	 */
	public void userStatus(String[] users, boolean staus) throws Exception;

	/***
	 * 
	 * @param user
	 * @throws Exception
	 */
	public Integer createOrUpdateUser(User user) throws Exception;

	/**
	 * 
	 * @return
	 * @throws Exception
	 */
	public Set<UserGroup> getAllUserGroupBasedOnId(Integer id) throws Exception;
	
	/**
	 * 
	 * @return
	 * @throws Exception
	 */
	public List<UserGroup> getAllUserGroup() throws Exception;

	/**
	 * 
	 * @param userName
	 * @return
	 * @throws Exception
	 */
	public boolean checkUser(String userName)throws Exception;

	/***
	 * 
	 * @param userId
	 * @return
	 * @throws Exception
	 */
	public User getUser(Integer userId) throws Exception;

	/***
	 * 
	 * @param userName
	 * @return
	 * @throws Exception
	 */
	public User getUserByName(String userName) throws Exception;
	
	/**
	 * 
	 * @param id
	 * @return
	 * @throws Exception
	 */
	public List<UserGroupPermission> getAllUserGroupPermission(List<Integer> id)throws Exception;


}
