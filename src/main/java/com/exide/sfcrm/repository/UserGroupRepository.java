/**
 * 
 */
package com.exide.sfcrm.repository;

import java.util.Set;

import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.CrudRepository;
import org.springframework.stereotype.Repository;

import com.exide.sfcrm.model.UserGroup;

/**
 * @author saurabhp
 *
 */
@Repository
public interface UserGroupRepository extends CrudRepository<UserGroup, Long>  {
	
	 @Query(value = "SELECT * FROM User_Group WHERE id in (select user_group_id from Users_User_Group where user_id = ?1 ) ", nativeQuery = true)
		Set<UserGroup> getAllUserGroup(Integer id);
	 
	 @Query(value = "SELECT * FROM User_Group WHERE Name = ?1", nativeQuery = true)
	 	UserGroup getUserGroupBasedOnRole(String role);
	 
	 @Override
	public Iterable<UserGroup> findAll();

}
