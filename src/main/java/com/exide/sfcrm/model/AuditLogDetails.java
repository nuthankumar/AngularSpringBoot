package com.exide.sfcrm.model;

import java.util.Date;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.Table;

import org.hibernate.annotations.Type;

import com.fasterxml.jackson.annotation.JsonIgnore;

@Entity
@Table(name = "Audit_Log_Details")
public class AuditLogDetails {

	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	@Column(name = "Audit_Log_Details_Id")
	@JsonIgnore
	private Integer auditLogDetailsId;

	@Column(name = "Audit_Name")
	private String auditName;

	@Column(name = "Audit_Result")
	private String auditResult;

	@Column(name = "Audit_Time")
	private Date auditTime;

	@Column(name = "Comments")
	private String comments;

	@Column(name = "Created_Datetime")
	private Date createdDatetime;

	@Column(name = "Created_User")
	private String createdUser;

	@Column(name = "Modified_Datetime")
	private Date modifiedDatetime;

	@Column(name = "Modified_User")
	private String modifiedUser;

	@Column(name = "Data")
	@Type(type="text")
	private String data;

	@Column(name = "User_Name")
	private String userName;

	/**
	 * @return this.the auditLogDetailsId
	 */
	public Integer getAuditLogDetailsId() {
		return this.auditLogDetailsId;
	}

	/**
	 * @param auditLogDetailsId the auditLogDetailsId to set
	 */
	public void setAuditLogDetailsId(Integer auditLogDetailsId) {
		this.auditLogDetailsId = auditLogDetailsId;
	}

	/**
	 * @return this.the auditName
	 */
	public String getAuditName() {
		return this.auditName;
	}

	/**
	 * @param auditName the auditName to set
	 */
	public void setAuditName(String auditName) {
		this.auditName = auditName;
	}

	/**
	 * @return this.the auditResult
	 */
	public String getAuditResult() {
		return this.auditResult;
	}

	/**
	 * @param auditResult the auditResult to set
	 */
	public void setAuditResult(String auditResult) {
		this.auditResult = auditResult;
	}

	/**
	 * @return this.the auditTime
	 */
	public Date getAuditTime() {
		return this.auditTime;
	}

	/**
	 * @param auditTime the auditTime to set
	 */
	public void setAuditTime(Date auditTime) {
		this.auditTime = auditTime;
	}

	/**
	 * @return this.the comments
	 */
	public String getComments() {
		return this.comments;
	}

	/**
	 * @param comments the comments to set
	 */
	public void setComments(String comments) {
		this.comments = comments;
	}

	/**
	 * @return this.the createdDatetime
	 */
	public Date getCreatedDatetime() {
		return this.createdDatetime;
	}

	/**
	 * @param createdDatetime the createdDatetime to set
	 */
	public void setCreatedDatetime(Date createdDatetime) {
		this.createdDatetime = createdDatetime;
	}

	/**
	 * @return this.the createdUser
	 */
	public String getCreatedUser() {
		return this.createdUser;
	}

	/**
	 * @param createdUser the createdUser to set
	 */
	public void setCreatedUser(String createdUser) {
		this.createdUser = createdUser;
	}

	/**
	 * @return this.the modifiedDatetime
	 */
	public Date getModifiedDatetime() {
		return this.modifiedDatetime;
	}

	/**
	 * @param modifiedDatetime the modifiedDatetime to set
	 */
	public void setModifiedDatetime(Date modifiedDatetime) {
		this.modifiedDatetime = modifiedDatetime;
	}

	/**
	 * @return this.the modifiedUser
	 */
	public String getModifiedUser() {
		return this.modifiedUser;
	}

	/**
	 * @param modifiedUser the modifiedUser to set
	 */
	public void setModifiedUser(String modifiedUser) {
		this.modifiedUser = modifiedUser;
	}

	/**
	 * @return this.the data
	 */
	public String getData() {
		return this.data;
	}

	/**
	 * @param data the data to set
	 */
	public void setData(String data) {
		this.data = data;
	}

	/**
	 * @return this.the userName
	 */
	public String getUserName() {
		return this.userName;
	}

	/**
	 * @param userName the userName to set
	 */
	public void setUserName(String userName) {
		this.userName = userName;
	}

	
	
	
	
}
