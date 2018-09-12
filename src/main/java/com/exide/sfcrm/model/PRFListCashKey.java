/**
 * 
 */
package com.exide.sfcrm.model;

import java.io.Serializable;
import java.sql.Date;

import javax.persistence.Column;
import javax.persistence.Embeddable;

/**
 * @author neethub
 *
 */
@Embeddable
public class PRFListCashKey implements Serializable{

	/**
	 * 
	 */
	private static final long serialVersionUID = -261762212920916244L;

	
	@Column (name="agentno")
	private String agentNo;
	
	@Column (name="agentname")
	private String agentName;
	
	@Column (name="trandate")
	private Date tranDate;
	
	@Column (name="netamount")
	private Float netAmount;
	
	@Column (name="recoverbleamount")
	private Float recoverbleAmount;
	
	@Column (name="deviationamt")
	private Float deviationAmt;
	
	@Column (name="advancepayout")
	private Float advancePayout;
	
	@Column (name="advancerecoverable")
	private Float advanceRecoverable;
	
	@Column (name="maxrecoverableamt")
	private Float maxRecoverableAmt;
	
	@Column (name="netpayout")
	private Float netPayout;
	
	@Column (name="agclass")
	private Float agClass;
	
	@Column (name="selectrecrd")
	private String selectRecrd;
	
	@Column (name="prfcomment")
	private String prfComment;
	
	@Column (name = "agtype")
	private Integer agType;
	
	@Column(name = "selectid")
	private Integer transAutoId;
	
	

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
	 * @return the tranDate
	 */
	public Date getTranDate() {
		return tranDate;
	}

	/**
	 * @param tranDate the tranDate to set
	 */
	public void setTranDate(Date tranDate) {
		this.tranDate = tranDate;
	}

	/**
	 * @return the NetAmount
	 */
	public Float getNetAmount() {
		return netAmount;
	}

	/**
	 * @param NetAmount the NetAmount to set
	 */
	public void setNetAmount(Float NetAmount) {
		this.netAmount = NetAmount;
	}

	/**
	 * @return the RecoverbleAmount
	 */
	public Float getRecoverbleAmount() {
		return recoverbleAmount;
	}

	/**
	 * @param RecoverbleAmount the RecoverbleAmount to set
	 */
	public void setRecoverbleAmount(Float RecoverbleAmount) {
		this.recoverbleAmount = RecoverbleAmount;
	}

	/**
	 * @return the DeviationAmt
	 */
	public Float getDeviationAmt() {
		return deviationAmt;
	}

	/**
	 * @param DeviationAmt the DeviationAmt to set
	 */
	public void setDeviationAmt(Float DeviationAmt) {
		this.deviationAmt = DeviationAmt;
	}

	/**
	 * @return the AdvancePayout
	 */
	public Float getAdvancePayout() {
		return advancePayout;
	}

	/**
	 * @param AdvancePayout the AdvancePayout to set
	 */
	public void setAdvancePayout(Float AdvancePayout) {
		this.advancePayout = AdvancePayout;
	}

	/**
	 * @return the AdvanceRecoverable
	 */
	public Float getAdvanceRecoverable() {
		return advanceRecoverable;
	}

	/**
	 * @param AdvanceRecoverable the AdvanceRecoverable to set
	 */
	public void setAdvanceRecoverable(Float AdvanceRecoverable) {
		this.advanceRecoverable = AdvanceRecoverable;
	}

	/**
	 * @return the MaxRecoverableAmt
	 */
	public Float getMaxRecoverableAmt() {
		return maxRecoverableAmt;
	}

	/**
	 * @param MaxRecoverableAmt the MaxRecoverableAmt to set
	 */
	public void setMaxRecoverableAmt(Float MaxRecoverableAmt) {
		this.maxRecoverableAmt = MaxRecoverableAmt;
	}

	/**
	 * @return the NetPayout
	 */
	public Float getNetPayout() {
		return netPayout;
	}

	/**
	 * @param NetPayout the NetPayout to set
	 */
	public void setNetPayout(Float NetPayout) {
		this.netPayout = NetPayout;
	}

	/**
	 * @return the agClass
	 */
	public Float getAgClass() {
		return agClass;
	}

	/**
	 * @param agClass the agClass to set
	 */
	public void setAgClass(Float agClass) {
		this.agClass = agClass;
	}

	/**
	 * @return the selectRecrd
	 */
	public String getSelectRecrd() {
		return selectRecrd;
	}

	/**
	 * @param selectRecrd the selectRecrd to set
	 */
	public void setSelectRecrd(String selectRecrd) {
		this.selectRecrd = selectRecrd;
	}

	/**
	 * @return the prfComment
	 */
	public String getPrfComment() {
		return prfComment;
	}

	/**
	 * @param prfComment the prfComment to set
	 */
	public void setPrfComment(String prfComment) {
		this.prfComment = prfComment;
	}

	/**
	 * @return the agType
	 */
	public Integer getAgType() {
		return agType;
	}

	/**
	 * @param agType the agType to set
	 */
	public void setAgType(Integer agType) {
		this.agType = agType;
	}

	/**
	 * @return the transAutoId
	 */
	public Integer getTransAutoId() {
		return transAutoId;
	}

	/**
	 * @param transAutoId the transAutoId to set
	 */
	public void setTransAutoId(Integer transAutoId) {
		this.transAutoId = transAutoId;
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

	
	

}
