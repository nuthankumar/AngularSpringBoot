/**
 * 
 */
package com.exide.sfcrm.model;

import java.io.Serializable;
import java.util.Date;
import java.util.HashSet;
import java.util.Set;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.JoinTable;
import javax.persistence.ManyToMany;
import javax.persistence.Table;
import javax.persistence.Transient;
import javax.persistence.UniqueConstraint;

import com.fasterxml.jackson.annotation.JsonIgnore;

/**
 * @author saurabhp
 *
 */
@Entity
@Table(name = "USERS")
public class User implements Serializable {

	/**
	 * 
	 */
	private static final long serialVersionUID = -8364877168884722958L;

	private Integer id;

	private String firstName;

	private String lastName;

	private String userName;

	private boolean isActiveUser;

	private String password;

	private String emailId;

	// @OneToMany
	// @Column(name="user_group_id")
	private Set<UserGroup> userGroup = new HashSet<UserGroup>(0);

	private String createdBy;

	private String modifiedBy;

	private Date createdDate;

	private Date modifiedDate;

	private boolean isAdUser;
	
	private int cid;
	
	

	/**
	 * @return the isActiveUser.
	 */
	@Column(name = "Is_Ad_User" , nullable = false, updatable = false)
	@JsonIgnore
	public boolean getIsAdUser() {
		return this.isAdUser;
	}

	/**
	 * @return the isAdUser.
	 */
	@Transient
	public boolean isAdUser() {
		return this.isAdUser;
	}

	/**
	 * @param isAdUser
	 *            the isAdUser to set.
	 */
	public void setIsAdUser(boolean isAdUser) {
		this.isAdUser = isAdUser;
	}

	/**
	 * @return the firstName.
	 */
	@Column(name = "First_Name", nullable = false)
	public String getFirstName() {
		return this.firstName;
	}

	/**
	 * @param firstName
	 *            the firstName to set.
	 */
	public void setFirstName(String firstName) {
		this.firstName = firstName;
	}

	/**
	 * @return the lastName.
	 */
	@Column(name = "Last_Name", nullable = false)
	public String getLastName() {
		return this.lastName;
	}

	/**
	 * @param lastName
	 *            the lastName to set.
	 */
	public void setLastName(String lastName) {
		this.lastName = lastName;
	}

	/**
	 * @return the userName.
	 */
	@Column(name = "User_Name", nullable = false, unique = true, updatable = false)
	public String getUserName() {
		return this.userName;
	}

	/**
	 * @param userName
	 *            the userName to set.
	 */
	public void setUserName(String userName) {
		this.userName = userName;
	}

	/**
	 * @return the isActiveUser.
	 */
	@Transient
	public boolean isActiveUser() {
		return this.isActiveUser;
	}

	/**
	 * @return the isActiveUser.
	 */
	@Column(name = "Is_Active_User", nullable = false, updatable = false)
	@JsonIgnore
	public boolean getIsActiveUser() {
		return this.isActiveUser;
	}

	/**
	 * @param isActiveUser
	 *            the isActiveUser to set.
	 */
	public void setIsActiveUser(boolean isActiveUser) {
		this.isActiveUser = isActiveUser;
	}

	/**
	 * @return the password.
	 */
	@Column(name = "Password")
	public String getPassword() {
		return this.password;
	}

	/**
	 * @param password
	 *            the password to set.
	 */
	public void setPassword(String password) {
		this.password = password;
	}

	/**
	 * @return the id.
	 */
	@Id
	@Column(name = "Id")
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	public Integer getId() {
		return id;
	}

	/**
	 * @param id
	 *            the id to set.
	 */
	public void setId(Integer id) {
		this.id = id;
	}

	/**
	 * @return the userGroup.
	 */
	@ManyToMany
	@JoinTable(name = "users_user_group", joinColumns = { @JoinColumn(
	// table = "framework_files",
	name = "user_id", referencedColumnName = "id", unique = false) }, inverseJoinColumns = @JoinColumn(name = "user_group_id", referencedColumnName = "id", unique = false), uniqueConstraints = { @UniqueConstraint(columnNames = {
			"user_id", "user_group_id" }) })
	public Set<UserGroup> getUserGroup() {
		return this.userGroup;
	}

	/**
	 * @param userGroup
	 *            the userGroup to set.
	 */
	public void setUserGroup(Set<UserGroup> userGroup) {
		this.userGroup = userGroup;
	}

	/**
	 * @return the createdBy.
	 */
	@Column(name = "Created_By" , updatable = false)
	public String getCreatedBy() {
		return this.createdBy;
	}

	/**
	 * @param createdBy
	 *            the createdBy to set.
	 */
	public void setCreatedBy(String createdBy) {
		this.createdBy = createdBy;
	}

	/**
	 * @return the modifiedBy.
	 */
	@Column(name = "Modified_By")
	public String getModifiedBy() {
		return this.modifiedBy;
	}

	/**
	 * @param modifiedBy
	 *            the modifiedBy to set.
	 */
	public void setModifiedBy(String modifiedBy) {
		this.modifiedBy = modifiedBy;
	}

	/**
	 * @return the createdDate.
	 */
	@Column(name = "Created_Date" , updatable = false)
	public Date getCreatedDate() {
		return this.createdDate;
	}

	/**
	 * @param createdDate
	 *            the createdDate to set.
	 */
	public void setCreatedDate(Date createdDate) {
		this.createdDate = createdDate;
	}

	/**
	 * @return the modifiedDate.
	 */
	@Column(name = "Modified_Date")
	public Date getModifiedDate() {
		return this.modifiedDate;
	}

	/**
	 * @param modifiedDate
	 *            the modifiedDate to set.
	 */
	public void setModifiedDate(Date modifiedDate) {
		this.modifiedDate = modifiedDate;
	}

	/**
	 * @return the emailId.
	 */
	@Column(name = "Email_Id")
	public String getEmailId() {
		return this.emailId;
	}

	/**
	 * @param emailId
	 *            the emailId to set.
	 */
	public void setEmailId(String emailId) {
		this.emailId = emailId;
	}
	
	
	

	/**
	 * @return the cid
	 */
	@Transient
	public int getCid() {
		return cid;
	}

	/**
	 * @param cid the cid to set
	 */
	public void setCid(int cid) {
		this.cid = cid;
	}

	/*
	 * (non-Javadoc)
	 * 
	 * @see java.lang.Object#toString()
	 */
	@Override
	public String toString() {
		return "UserList [loginId=" + id + ", firstName=" + firstName
				+ ", lastName=" + lastName + ", userName=" + userName
				+ ", IsActiveUser=" + isActiveUser + ", password=" + password
				+ ",isAdUser=" + isAdUser +",cid=" + cid + ",emailId=" + emailId + "]";
	}

}
