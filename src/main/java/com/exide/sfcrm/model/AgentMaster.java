package com.exide.sfcrm.model;

import java.io.Serializable;
import java.sql.Date;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.Table;


/**
 * 
 * @author vasavivr
 *
 */

@Entity
@Table(name="agentmaster")
public class AgentMaster implements Serializable  {
	
	private static final long serialVersionUID = 1L;

	@Id
	@Column(name="transautoid",nullable=false)
	@GeneratedValue(strategy=GenerationType.IDENTITY)
	private Integer transAutoId;
	
	@Column(name="agentno")
	private String agentNo;
	
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
	
	@Column(name="Load_Date")
	private Date loadDate;
	
	public Integer getTransAutoId() {
		return transAutoId;
	}

	public void setTransAutoId(Integer transAutoId) {
		this.transAutoId = transAutoId;
	}

	public String getAgentNo() {
		return agentNo;
	}

	public void setAgentNo(String agentNo) {
		this.agentNo = agentNo;
	}

	public String getAgentName() {
		return agentName;
	}

	public void setAgentName(String agentName) {
		this.agentName = agentName;
	}

	public String getAgType() {
		return agType;
	}

	public void setAgType(String agType) {
		this.agType = agType;
	}

	public String getIrdNo() {
		return irdNo;
	}

	public void setIrdNo(String irdNo) {
		this.irdNo = irdNo;
	}

	public Date getDtApp() {
		return dtApp;
	}

	public void setDtApp(Date dtApp) {
		this.dtApp = dtApp;
	}

	public Date getDtTerm() {
		return dtTerm;
	}

	public void setDtTerm(Date dtTerm) {
		this.dtTerm = dtTerm;
	}

	public String getBranchCode() {
		return branchCode;
	}

	public void setBranchCode(String branchCode) {
		this.branchCode = branchCode;
	}

	public String getBankACNumber() {
		return bankACNumber;
	}

	public void setBankACNumber(String bankACNumber) {
		this.bankACNumber = bankACNumber;
	}

	public String getIfscCode() {
		return ifscCode;
	}

	public void setIfscCode(String ifscCode) {
		this.ifscCode = ifscCode;
	}

	public Date getLoadDate() {
		return loadDate;
	}

	public void setLoadDate(Date loadDate) {
		this.loadDate = loadDate;
	}

	
	

}
