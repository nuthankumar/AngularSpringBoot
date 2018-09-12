/**
 * 
 */
package com.exide.sfcrm.repository;

import java.util.List;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.stereotype.Repository;

import com.exide.sfcrm.model.UserGroupPermission;

/**
 * @author saurabhp
 *
 */
@Repository
public interface UserGroupPermissionsRepository extends JpaRepository<UserGroupPermission, Long>{

	
	@Query(value= "SELECT * from User_Group_Permission where user_group_id in ?1 ", nativeQuery = true)
	public List<UserGroupPermission> getUserGroupPermissionBasedOnId(List<Integer> id);
}
