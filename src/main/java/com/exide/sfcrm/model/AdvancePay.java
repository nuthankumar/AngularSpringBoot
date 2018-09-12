/**
 * 
 */
package com.exide.sfcrm.model;

import java.math.BigDecimal;
import java.util.Date;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.Table;

/**
 * @author saurabhp
 *
 */

@Entity
@Table(name = "Advance_Pay")
public class AdvancePay {
	
	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	@Column(name = "Advance_Payment_Id")
	private Integer id;
	
	@Column(name = "Agent_No")
	private String agentNo;
	
	@Column(name = "Agent_Date")
	private Date advanceDate;
	
	@Column(name = "Start_Date")
	private Date startDate;
	
	@Column(name = "Amount")
	private BigDecimal amount;
	
	@Column(name = "Max_Recoverable")
	private BigDecimal maxRecoverable;
	
	@Column(name = "Net_Balance")
	private BigDecimal netBalance;
	
	@Column(name = "Remarks")
	private String remarks;
	
	
	/**
	 * @return this.the agentNo
	 */
	public String getAgentNo() {
		return this.agentNo;
	}
	/**
	 * @param agentNo the agentNo to set
	 */
	public void setAgentNo(String agentNo) {
		this.agentNo = agentNo;
	}
	/**
	 * @return this.the advanceDate
	 */
	public Date getAdvanceDate() {
		return this.advanceDate;
	}
	/**
	 * @param advanceDate the advanceDate to set
	 */
	public void setAdvanceDate(Date advanceDate) {
		this.advanceDate = advanceDate;
	}
	/**
	 * @return this.the startDate
	 */
	public Date getStartDate() {
		return this.startDate;
	}
	/**
	 * @param startDate the startDate to set
	 */
	public void setStartDate(Date startDate) {
		this.startDate = startDate;
	}
	/**
	 * @return this.the amount
	 */
	public BigDecimal getAmount() {
		return this.amount;
	}
	/**
	 * @param amount the amount to set
	 */
	public void setAmount(BigDecimal amount) {
		this.amount = amount;
	}
	/**
	 * @return this.the maxRecoverable
	 */
	public BigDecimal getMaxRecoverable() {
		return this.maxRecoverable;
	}
	/**
	 * @param maxRecoverable the maxRecoverable to set
	 */
	public void setMaxRecoverable(BigDecimal maxRecoverable) {
		this.maxRecoverable = maxRecoverable;
	}
	/**
	 * @return this.the netBalance
	 */
	public BigDecimal getNetBalance() {
		return this.netBalance;
	}
	/**
	 * @param netBalance the netBalance to set
	 */
	public void setNetBalance(BigDecimal netBalance) {
		this.netBalance = netBalance;
	}
	/**
	 * @return this.the remarks
	 */
	public String getRemarks() {
		return this.remarks;
	}
	/**
	 * @param remarks the remarks to set
	 */
	public void setRemarks(String remarks) {
		this.remarks = remarks;
	}
	/**
	 * @return the id
	 */
	public Integer getId() {
		return this.id;
	}
	/**
	 * @param id the id to set
	 */
	public void setId(Integer id) {
		this.id = id;
	}
	

}
