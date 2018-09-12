package com.exide.sfcrm.model;

import java.io.Serializable;

import javax.persistence.Column;
import javax.persistence.Embeddable;


/**
 * @author vasavivr
 *
 */
@Embeddable
public class AdvancePayCashKey implements Serializable{

	/**
	 * 
	 */
	
	private static final long serialVersionUID = -1246668198082163592L;

	/**
	 * 
	 */

	@Column(name = "agentno")
	private String agentNo;

	@Column(name = "advdate")
	private Integer advDate;

	@Column(name = "effectivestartdateforrecovery")
	private Integer effectiveStartDateForRecovery;

	@Column(name = "amount")
	private Integer amount;

	@Column(name = "recoverable")
	private Integer recoverable;

	@Column(name = "maxrecoverblepercycle")
	private Integer maxRecoverblePerCycle;

	@Column(name = "netbalance")
	private Integer netBalance;
	
	


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
	 * @return the advDate
	 */
	public Integer getAdvDate() {
		return advDate;
	}

	/**
	 * @param advDate the advDate to set
	 */
	public void setAdvDate(Integer advDate) {
		this.advDate = advDate;
	}

	/**
	 * @return the effectiveStartDateForRecovery
	 */
	public Integer getEffectiveStartDateForRecovery() {
		return effectiveStartDateForRecovery;
	}

	/**
	 * @param effectiveStartDateForRecovery the effectiveStartDateForRecovery to set
	 */
	public void setEffectiveStartDateForRecovery(
			Integer effectiveStartDateForRecovery) {
		this.effectiveStartDateForRecovery = effectiveStartDateForRecovery;
	}

	/**
	 * @return the amount
	 */
	public Integer getAmount() {
		return amount;
	}

	/**
	 * @param amount the amount to set
	 */
	public void setAmount(Integer amount) {
		this.amount = amount;
	}

	/**
	 * @return the recoverable
	 */
	public Integer getRecoverable() {
		return recoverable;
	}

	/**
	 * @param recoverable the recoverable to set
	 */
	public void setRecoverable(Integer recoverable) {
		this.recoverable = recoverable;
	}


	/**
	 * @return the maxRecoverblePerCycle
	 */
	public Integer getMaxRecoverblePerCycle() {
		return maxRecoverblePerCycle;
	}

	/**
	 * @param maxRecoverblePerCycle the maxRecoverblePerCycle to set
	 */
	public void setMaxRecoverblePerCycle(Integer maxRecoverblePerCycle) {
		this.maxRecoverblePerCycle = maxRecoverblePerCycle;
	}

	/**
	 * @return the netBalance
	 */
	public Integer getNetBalance() {
		return netBalance;
	}

	/**
	 * @param netBalance the netBalance to set
	 */
	public void setNetBalance(Integer netBalance) {
		this.netBalance = netBalance;
	}


	
}
