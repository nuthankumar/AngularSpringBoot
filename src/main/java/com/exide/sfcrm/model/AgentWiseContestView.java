/**
 * 
 */
package com.exide.sfcrm.model;

import java.sql.Date;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.Id;
import javax.persistence.Table;

/**
 * @author neethub
 *
 */
@Entity
@Table(name = "agentcontestview")
public class AgentWiseContestView {
	
	@Column(name="contestid" , unique = false)
	private Integer contestId;
	
	@Column(name="contestname")
	private String contestName;
	
	@Id
	@Column(name="agentno")
	private String agentNo;
	
	@Column(name="netamount")
	private Float netAmount;
	
	@Column(name="previousnetpayable")
	private Float previousNetPayable;
	
	@Column(name="netpayable")
	private Float netPayable;
	
	@Column(name="entryflag")
	private Integer entryFlag;
	
	@Column(name="[status]")
	private String status;
	
	@Column(name="agentname")
	private String agentName;
	
	@Column(name="agtype")
	private String agType;
	
	@Column(name="irdno")
	private String irdNo;
	
	@Column(name="dtapp")
	private Date dtApp;
	
	@Column(name="dtterm")
	private Date dtTerm;
	
	@Column(name="branchcode")
	private String branchCode;
	
	@Column(name="bankacnumber")
	private String bankACNumber;
	
	@Column(name="ifsccode")
	private String ifscCode;
	
	@Column(name="[Validation]")
	private String validation;

	/**
	 * @return the contestId
	 */
	public Integer getContestId() {
		return contestId;
	}

	/**
	 * @param contestId the contestId to set
	 */
	public void setContestId(Integer contestId) {
		this.contestId = contestId;
	}

	/**
	 * @return the contestName
	 */
	public String getContestName() {
		return contestName;
	}

	/**
	 * @param contestName the contestName to set
	 */
	public void setContestName(String contestName) {
		this.contestName = contestName;
	}

	/**
	 * @return the agentNo
	 */
	public String getAgentNo() {
		return agentNo;
	}

	/**
	 * @param agentNo the agentNo to set
	 */
	public void setAgentNo(String agentNo) {
		this.agentNo = agentNo;
	}

	/**
	 * @return the netAmount
	 */
	public Float getNetAmount() {
		return netAmount;
	}

	/**
	 * @param netAmount the netAmount to set
	 */
	public void setNetAmount(Float netAmount) {
		this.netAmount = netAmount;
	}

	/**
	 * @return the previousNetPayable
	 */
	public Float getPreviousNetPayable() {
		return previousNetPayable;
	}

	/**
	 * @param previousNetPayable the previousNetPayable to set
	 */
	public void setPreviousNetPayable(Float previousNetPayable) {
		this.previousNetPayable = previousNetPayable;
	}

	/**
	 * @return the netPayable
	 */
	public Float getNetPayable() {
		return netPayable;
	}

	/**
	 * @param netPayable the netPayable to set
	 */
	public void setNetPayable(Float netPayable) {
		this.netPayable = netPayable;
	}

	/**
	 * @return the entryFlag
	 */
	public Integer getEntryFlag() {
		return entryFlag;
	}

	/**
	 * @param entryFlag the entryFlag to set
	 */
	public void setEntryFlag(Integer entryFlag) {
		this.entryFlag = entryFlag;
	}

	
	public String getStatus() {
		return status;
	}

	public void setStatus(String status) {
		this.status = status;
	}

	/**
	 * @return the agentName
	 */
	public String getAgentName() {
		return agentName;
	}

	/**
	 * @param agentName the agentName to set
	 */
	public void setAgentName(String agentName) {
		this.agentName = agentName;
	}

	/**
	 * @return the agType
	 */
	public String getAgType() {
		return agType;
	}

	/**
	 * @param agType the agType to set
	 */
	public void setAgType(String agType) {
		this.agType = agType;
	}

	/**
	 * @return the irdNo
	 */
	public String getIrdNo() {
		return irdNo;
	}

	/**
	 * @param irdNo the irdNo to set
	 */
	public void setIrdNo(String irdNo) {
		this.irdNo = irdNo;
	}

	/**
	 * @return the dtApp
	 */
	public Date getDtApp() {
		return dtApp;
	}

	/**
	 * @param dtApp the dtApp to set
	 */
	public void setDtApp(Date dtApp) {
		this.dtApp = dtApp;
	}

	/**
	 * @return the dtTerm
	 */
	public Date getDtTerm() {
		return dtTerm;
	}

	/**
	 * @param dtTerm the dtTerm to set
	 */
	public void setDtTerm(Date dtTerm) {
		this.dtTerm = dtTerm;
	}

	/**
	 * @return the branchCode
	 */
	public String getBranchCode() {
		return branchCode;
	}

	/**
	 * @param branchCode the branchCode to set
	 */
	public void setBranchCode(String branchCode) {
		this.branchCode = branchCode;
	}

	/**
	 * @return the bankACNumber
	 */
	public String getBankACNumber() {
		return bankACNumber;
	}

	/**
	 * @param bankACNumber the bankACNumber to set
	 */
	public void setBankACNumber(String bankACNumber) {
		this.bankACNumber = bankACNumber;
	}

	/**
	 * @return the ifscCode
	 */
	public String getIfscCode() {
		return ifscCode;
	}

	/**
	 * @param ifscCode the ifscCode to set
	 */
	public void setIfscCode(String ifscCode) {
		this.ifscCode = ifscCode;
	}

	/**
	 * @return the validation
	 */
	public String getValidation() {
		return validation;
	}

	/**
	 * @param validation the validation to set
	 */
	public void setValidation(String validation) {
		this.validation = validation;
	}
	
	

}
