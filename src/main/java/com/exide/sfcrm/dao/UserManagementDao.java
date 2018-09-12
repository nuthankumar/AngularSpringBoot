/**
 * 
 */
package com.exide.sfcrm.dao;

import com.exide.sfcrm.model.User;

/**
 * @author saurabhp
 *
 */
public interface UserManagementDao {
	
	
	

	/**
	 * 
	 * @param user
	 * @throws Exception
	 */
	public User createOrUpdateUser(User user) throws Exception;

	/**
	 * 
	 * @param user
	 * @throws Exception
	 */
	public void insertIntoCuMap(User user) throws Exception;

	

	

}
