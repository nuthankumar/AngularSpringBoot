package com.exide.sfcrm.model;

import java.sql.Date;

import javax.persistence.Column;
import javax.persistence.EmbeddedId;
import javax.persistence.Entity;
import javax.persistence.Table;

/**
 * 
 * @author vasavivr
 *
 */
@Entity
@Table(name="agentwisecontestticketview")
public class AgentWiseContestTicketView {

	@Column(name="contestid" , unique = false)
	private Integer contestId;
	
	@Column(name="contestname")
	private String contestName;
	
	@Column(name="netvalue")
	private Float netValue;
	
	@Column(name="previousnetpayable")
	private Float previousNetPayable;
	
	@Column(name="netpayable")
	private Float netPayable;
	
	@Column(name = "ticketlists")
	private Integer ticketLists;


	@Column(name = "destid")
	private Integer destId;
	
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
	
	@EmbeddedId
	private AgentWiseContestTicketKey agentWiseContestTicketKey;

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
	 * @return the netValue
	 */
	public Float getNetValue() {
		return netValue;
	}

	/**
	 * @param netValue the netValue to set
	 */
	public void setNetValue(Float netValue) {
		this.netValue = netValue;
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
	 * @return the ticketLists
	 */
	public Integer getTicketLists() {
		return ticketLists;
	}

	/**
	 * @param ticketLists the ticketLists to set
	 */
	public void setTicketLists(Integer ticketLists) {
		this.ticketLists = ticketLists;
	}



	/**
	 * @return the destId
	 */
	public Integer getDestId() {
		return destId;
	}

	/**
	 * @param destId the destId to set
	 */
	public void setDestId(Integer destId) {
		this.destId = destId;
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

	public AgentWiseContestTicketKey getAgentWiseContestTicketKey() {
		return agentWiseContestTicketKey;
	}

	public void setAgentWiseContestTicketKey(
			AgentWiseContestTicketKey agentWiseContestTicketKey) {
		this.agentWiseContestTicketKey = agentWiseContestTicketKey;
	}
	
	

}
