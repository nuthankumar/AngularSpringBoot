package com.exide.sfcrm.model;

import java.io.Serializable;
import java.sql.Date;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.Id;
import javax.persistence.Table;
/**
 * 
 * @author vasavivr
 *
 */
@Entity
@Table(name="tblagentmaster")
public class AgentList implements Serializable {

	/**
	 * 
	 */
	private static final long serialVersionUID = -4146036742715059093L;

	@Id
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
	
	@Column(name="[Load_Date]")
	private String loadDate;
/**
 * 
 * @return
 */
	public String getAgentNo() {
		return agentNo;
	}
/**
 * 
 * @param agentNo
 */
	public void setAgentNo(String agentNo) {
		this.agentNo = agentNo;
	}
/**
 * 
 * @return
 */
	public String getAgentName() {
		return agentName;
	}
/**
 * 
 * @param agentName
 */
	public void setAgentName(String agentName) {
		this.agentName = agentName;
	}
/**
 * 
 * @return
 */
	public String getAgType() {
		return agType;
	}
/**
 * 
 * @param agType
 */
	public void setAgType(String agType) {
		this.agType = agType;
	}
/**
 * 
 * @return
 */
	public String getIrdNo() {
		return irdNo;
	}
/**
 * 
 * @param irdNo
 */
	public void setIrdNo(String irdNo) {
		this.irdNo = irdNo;
	}
/**
 * 
 * @return
 */
	public Date getDtApp() {
		return dtApp;
	}
/**
 * 
 * @param dtApp
 */
	public void setDtApp(Date dtApp) {
		this.dtApp = dtApp;
	}
/**
 * 
 * @return
 */
	public Date getDtTerm() {
		return dtTerm;
	}
/**
 * 
 * @param dtTerm
 */
	public void setDtTerm(Date dtTerm) {
		this.dtTerm = dtTerm;
	}
/**
 * 
 * @return
 */
	public String getBranchCode() {
		return branchCode;
	}
/**
 * 
 * @param branchCode
 */
	public void setBranchCode(String branchCode) {
		this.branchCode = branchCode;
	}
/**
 * 
 * @return
 */
	public String getBankACNumber() {
		return bankACNumber;
	}
/**
 * 
 * @param bankACNumber
 */
	public void setBankACNumber(String bankACNumber) {
		this.bankACNumber = bankACNumber;
	}
/**
 * 
 * @return
 */
	public String getIfscCode() {
		return ifscCode;
	}
/**
 * 
 * @param ifscCode
 */
	public void setIfscCode(String ifscCode) {
		this.ifscCode = ifscCode;
	}
/**
 * 
 * @return
 */
	public String getLoadDate() {
		return loadDate;
	}
/**
 * 
 * @param loadDate
 */
	public void setLoadDate(String loadDate) {
		this.loadDate = loadDate;
	}
}
