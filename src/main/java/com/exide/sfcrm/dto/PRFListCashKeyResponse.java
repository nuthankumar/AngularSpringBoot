package com.exide.sfcrm.dto;

import java.io.Serializable;
import java.sql.Date;

public class PRFListCashKeyResponse implements Serializable{

	/**
	 * 
	 */
	private static final long serialVersionUID = 1L;
	
	private String agentNo;
	private String agentName;
	private Date tranDate;
	private Float netAmount;
	private Float recoverbleAmount;
	private Float deviationAmt;
	private Float advancePayout;
	private Float advanceRecoverable;
	private Float maxRecoverableAmt;
	private Float netPayout;
	private Float agClass;
	private String selectRecrd;
	private String prfComment;
	private Integer agType;
	private Integer transAutoId;
	
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
	public Date getTranDate() {
		return tranDate;
	}
	public void setTranDate(Date tranDate) {
		this.tranDate = tranDate;
	}
	public Float getNetAmount() {
		return netAmount;
	}
	public void setNetAmount(Float netAmount) {
		this.netAmount = netAmount;
	}
	public Float getRecoverbleAmount() {
		return recoverbleAmount;
	}
	public void setRecoverbleAmount(Float recoverbleAmount) {
		this.recoverbleAmount = recoverbleAmount;
	}
	public Float getDeviationAmt() {
		return deviationAmt;
	}
	public void setDeviationAmt(Float deviationAmt) {
		this.deviationAmt = deviationAmt;
	}
	public Float getAdvancePayout() {
		return advancePayout;
	}
	public void setAdvancePayout(Float advancePayout) {
		this.advancePayout = advancePayout;
	}
	public Float getAdvanceRecoverable() {
		return advanceRecoverable;
	}
	public void setAdvanceRecoverable(Float advanceRecoverable) {
		this.advanceRecoverable = advanceRecoverable;
	}
	public Float getMaxRecoverableAmt() {
		return maxRecoverableAmt;
	}
	public void setMaxRecoverableAmt(Float maxRecoverableAmt) {
		this.maxRecoverableAmt = maxRecoverableAmt;
	}
	public Float getNetPayout() {
		return netPayout;
	}
	public void setNetPayout(Float netPayout) {
		this.netPayout = netPayout;
	}
	public Float getAgClass() {
		return agClass;
	}
	public void setAgClass(Float agClass) {
		this.agClass = agClass;
	}
	public String getSelectRecrd() {
		return selectRecrd;
	}
	public void setSelectRecrd(String selectRecrd) {
		this.selectRecrd = selectRecrd;
	}
	public String getPrfComment() {
		return prfComment;
	}
	public void setPrfComment(String prfComment) {
		this.prfComment = prfComment;
	}
	public Integer getAgType() {
		return agType;
	}
	public void setAgType(Integer agType) {
		this.agType = agType;
	}
	public Integer getTransAutoId() {
		return transAutoId;
	}
	public void setTransAutoId(Integer transAutoId) {
		this.transAutoId = transAutoId;
	}
	
	
}
