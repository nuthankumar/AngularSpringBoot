package com.exide.sfcrm.model;

import java.io.Serializable;
import java.sql.Date;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.Id;
import javax.persistence.Table;

@Entity
@Table(name = "tblprfgeneratedcashview")
public class TblPRFGeneratedCashView implements Serializable {

	/**
	 * 
	 */
	private static final long serialVersionUID = 7267468705355990395L;

	@Id
	@Column(name = "[transautoid]")
	private Integer transAutoId;

	@Column(name = "prfnogenref")
	private Integer prfNoGenREF;

	@Column(name = "agentno")
	private String agentNo;

	@Column(name = "agentname")
	private String agentName;

	@Column(name = "prfno")
	private String prfNo;

	@Column(name = "prfgendate")
	private Integer prfGENDate;

	@Column(name = "sumofnetpayout")
	private Float sumOfNetPayout;

	@Column(name = "prfcomment")
	private String prfComment;

	@Column(name = "Agtypes")
	private String AgTypes;

	@Column(name = "costcentrecode")
	private String costCentreCode;

	@Column(name = "channel")
	private String channel;

	@Column(name = "locationbranchcode")
	private String locationBranchCode;

	@Column(name = "modeofpayment")
	private String modeOfPayment;
	
	@Column(name = "utrno")
	private String utrNo;

	@Column(name = "transferdate")
	private Date transferDate;

	public Integer getTransAutoId() {
		return transAutoId;
	}

	public void setTransAutoId(Integer transAutoId) {
		this.transAutoId = transAutoId;
	}

	public Integer getPrfNoGenREF() {
		return prfNoGenREF;
	}

	public void setPrfNoGenREF(Integer prfNoGenREF) {
		this.prfNoGenREF = prfNoGenREF;
	}

	public String getPrfNo() {
		return prfNo;
	}

	public void setPrfNo(String prfNo) {
		this.prfNo = prfNo;
	}

	public Integer getPrfGENDate() {
		return prfGENDate;
	}

	public void setPrfGENDate(Integer prfGENDate) {
		this.prfGENDate = prfGENDate;
	}

	public String getPrfComment() {
		return prfComment;
	}

	public void setPrfComment(String prfComment) {
		this.prfComment = prfComment;
	}

	public String getAgTypes() {
		return AgTypes;
	}

	public void setAgTypes(String agTypes) {
		AgTypes = agTypes;
	}

	public String getCostCentreCode() {
		return costCentreCode;
	}

	public void setCostCentreCode(String costCentreCode) {
		this.costCentreCode = costCentreCode;
	}

	public String getChannel() {
		return channel;
	}

	public void setChannel(String channel) {
		this.channel = channel;
	}

	public String getLocationBranchCode() {
		return locationBranchCode;
	}

	public void setLocationBranchCode(String locationBranchCode) {
		this.locationBranchCode = locationBranchCode;
	}

	public String getModeOfPayment() {
		return modeOfPayment;
	}

	public void setModeOfPayment(String modeOfPayment) {
		this.modeOfPayment = modeOfPayment;
	}

	public Float getSumOfNetPayout() {
		return sumOfNetPayout;
	}

	/**
	 * @return the agentNo
	 */
	public String getAgentNo() {
		return agentNo;
	}

	/**
	 * @param agentNo
	 *            the agentNo to set
	 */
	public void setAgentNo(String agentNo) {
		this.agentNo = agentNo;
	}

	public void setSumOfNetPayout(Float sumOfNetPayout) {
		this.sumOfNetPayout = sumOfNetPayout;
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
	 * @return the utrNo
	 */
	public String getUtrNo() {
		return utrNo;
	}

	/**
	 * @param utrNo the utrNo to set
	 */
	public void setUtrNo(String utrNo) {
		this.utrNo = utrNo;
	}

	/**
	 * @return the transferDate
	 */
	public Date getTransferDate() {
		return transferDate;
	}

	/**
	 * @param transferDate the transferDate to set
	 */
	public void setTransferDate(Date transferDate) {
		this.transferDate = transferDate;
	}

}
