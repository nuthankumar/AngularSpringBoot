/**
 * 
 */
package com.exide.sfcrm.model;

import java.io.Serializable;

import javax.persistence.Column;
import javax.persistence.Embeddable;

/**
 * @author neethub
 *
 */
@Embeddable
public class PRFListCashAdvanceKey implements Serializable{
	/**
	 * 
	 */
	private static final long serialVersionUID = -6164182549454991017L;

	@Column(name = "agentno")
	private String agentNo;
	
	@Column(name = "trandate")
	private Float transDate;
	
	@Column(name = "netamount")
	private Float netAmount;
	
	@Column(name = "recoverbleamount")
	private Float recoverbleAmount;
	
	@Column(name = "deviationamt")
	private Float deviationAmt;
	
	@Column(name = "advancepayout")
	private Float advancePayout;
	
	@Column(name = "advancerecoverable")
	private Float advanceRecoverable;
	
	@Column(name = "maxrecoverableamt")
	private Float maxRecoverableAmt;
	
	@Column(name = "netpayout")
	private Float netPayout;
	
	@Column(name = "agclass")
	private Integer agClass;

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
	 * @return the transDate
	 */
	public Float getTransDate() {
		return transDate;
	}

	/**
	 * @param transDate the transDate to set
	 */
	public void setTransDate(Float transDate) {
		this.transDate = transDate;
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
	 * @return the recoverbleAmount
	 */
	public Float getRecoverbleAmount() {
		return recoverbleAmount;
	}

	/**
	 * @param recoverbleAmount the recoverbleAmount to set
	 */
	public void setRecoverbleAmount(Float recoverbleAmount) {
		this.recoverbleAmount = recoverbleAmount;
	}

	/**
	 * @return the deviationAmt
	 */
	public Float getDeviationAmt() {
		return deviationAmt;
	}

	/**
	 * @param deviationAmt the deviationAmt to set
	 */
	public void setDeviationAmt(Float deviationAmt) {
		this.deviationAmt = deviationAmt;
	}

	/**
	 * @return the advancePayout
	 */
	public Float getAdvancePayout() {
		return advancePayout;
	}

	/**
	 * @param advancePayout the advancePayout to set
	 */
	public void setAdvancePayout(Float advancePayout) {
		this.advancePayout = advancePayout;
	}

	/**
	 * @return the advanceRecoverable
	 */
	public Float getAdvanceRecoverable() {
		return advanceRecoverable;
	}

	/**
	 * @param advanceRecoverable the advanceRecoverable to set
	 */
	public void setAdvanceRecoverable(Float advanceRecoverable) {
		this.advanceRecoverable = advanceRecoverable;
	}

	/**
	 * @return the maxRecoverableAmt
	 */
	public Float getMaxRecoverableAmt() {
		return maxRecoverableAmt;
	}

	/**
	 * @param maxRecoverableAmt the maxRecoverableAmt to set
	 */
	public void setMaxRecoverableAmt(Float maxRecoverableAmt) {
		this.maxRecoverableAmt = maxRecoverableAmt;
	}

	/**
	 * @return the netPayout
	 */
	public Float getNetPayout() {
		return netPayout;
	}

	/**
	 * @param netPayout the netPayout to set
	 */
	public void setNetPayout(Float netPayout) {
		this.netPayout = netPayout;
	}

	/**
	 * @return the agClass
	 */
	public Integer getAgClass() {
		return agClass;
	}

	/**
	 * @param agClass the agClass to set
	 */
	public void setAgClass(Integer agClass) {
		this.agClass = agClass;
	}
	
	

}
