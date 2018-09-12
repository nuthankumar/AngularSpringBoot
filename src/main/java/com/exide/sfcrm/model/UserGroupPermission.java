/**
 * 
 */
package com.exide.sfcrm.model;

import java.io.Serializable;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.OneToOne;
import javax.persistence.Table;

/**
 * @author saurabhp
 *
 */
@Entity
@Table(name="USER_GROUP_PERMISSION")
public class UserGroupPermission implements Serializable{
	
	/**
	 * 
	 */
	private static final long serialVersionUID = -3256566069337043303L;
	
	@Id
	@Column(name="Id")
	@GeneratedValue(strategy=GenerationType.IDENTITY)
	private Integer id;
	
	@Column(name="User_Group_Permission")
	private String userGroupPsermissions;
	
	@OneToOne
	private UserGroup userGroup;
	
	
	/**
	 * @return the id.
	 */
	public Integer getId() {
		return this.id;
	}
	/**
	 * @param id the id to set.
	 */
	public void setId(Integer id) {
		this.id = id;
	}
	/**
	 * @return this.the userGroupPsermission.
	 */
	public String getUserGroupPsermissions() {
		return this.userGroupPsermissions;
	}
	/**
	 * @param userGroupPsermission the userGroupPsermission to set.
	 */
	public void setUserGroupPsermissions(String userGroupPsermissions) {
		this.userGroupPsermissions = userGroupPsermissions;
	}
	/**
	 * @return this.the userGroup.
	 */
	public UserGroup getUserGroup() {
		return this.userGroup;
	}
	/**
	 * @param userGroup the userGroup to set.
	 */
	public void setUserGroup(UserGroup userGroup) {
		this.userGroup = userGroup;
	}
	
}
