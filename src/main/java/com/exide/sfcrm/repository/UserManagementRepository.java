/**
 * 
 */
package com.exide.sfcrm.repository;

import java.util.List;

import javax.transaction.Transactional;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Modifying;
import org.springframework.data.jpa.repository.Query;
import org.springframework.stereotype.Repository;

import com.exide.sfcrm.model.User;



/**
 * @author saurabhp
 *
 */
@Repository
@Transactional
public interface UserManagementRepository extends JpaRepository<User, Long> {

	
	public User findByUserName(String userName)throws Exception;
	
	@Query(value= "SELECT * from Users where id = ?1 and is_active_user = 1", nativeQuery = true)
	public User findByUserId(Integer userId);
	
	@Query(value= "SELECT * from Users where is_active_user = 1", nativeQuery = true)
	public List<User> findAll();

	@Query(value = "SELECT * FROM Users WHERE id in (select user_id from Users_User_Group where user_group_id  in ( select id from user_group where name = ?1  ) ) and is_active_user = 1", nativeQuery = true)
	public Iterable<User> findRoleBasedUsers(String role);
	
	@Modifying
	@Query(value="update users set is_active_user = ?2 where user_name IN ?1", nativeQuery = true)
	public void updateUserStatus(List<String> userName, boolean status);

}
