/**
 * 
 */
package com.exide.sfcrm.model;

import java.sql.Date;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.Table;

import com.fasterxml.jackson.annotation.JsonProperty;

/**
 * @author neethub
 *
 *        
 */

@Entity
@Table(name = "tblprfgenratedcash")
public class TblPRFGenratedCash {
	
	@Id
	@Column(name = "[transautoid]", nullable = false)
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	private Integer transAutoId;
	
	@Column(name = "agentno")
	@JsonProperty("agentno")
	private String agentNo;
	
	@Column(name = "agentname")
	private String agentName;
	
	@Column(name = "transdate")
	private Float transDate;
	
	@Column(name = "netamount")
	private Float netAmount;
	
	@Column(name = "recoverableamont")
	private Float recoverableAmont;
	
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
	
	@Column(name = "branchcode")
	private String branchCode;
	
	@Column(name = "bankacnumber")
	private String bankACNumber;
	
	@Column(name = "ifsccode")
	private String ifscCode;
	
	@Column(name = "irdno")
	private String irdNO;
	
	@Column(name = "prfamount")
	private Float prfAmount;
	
	@Column(name = "prfnogenref")
	private Integer prfNoGenREF;
	
	@Column(name = "prfno")
	private String prfNo;
	
	@Column(name = "prfgendate")
	private Integer prfGENDate;
	
	@Column(name = "prfcomment")
	private String prfComment;

	@Column(name = "lockrecord")
	private Integer lockRecord;

	@Column(name = "createddate")
	private Integer createdDate;

	@Column(name = "status")
	private Integer status;

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

	@Column(name = "prntcnt")
	private Integer prntCnt;

	@Column(name = "utrno")
	private String utrNo;

	@Column(name = "transferdate")
	private Date transferDate;

	@Column(name = "utruploaddt")
	private Date utrUploadDt;

	@Column(name = "cid")
	private Integer cid;

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

	public Float getTransDate() {
		return transDate;
	}

	public void setTransDate(Float transDate) {
		this.transDate = transDate;
	}

	public Float getNetAmount() {
		return netAmount;
	}

	public void setNetAmount(Float netAmount) {
		this.netAmount = netAmount;
	}

	public Float getRecoverableAmont() {
		return recoverableAmont;
	}

	public void setRecoverableAmont(Float recoverableAmont) {
		this.recoverableAmont = recoverableAmont;
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

	public String getIrdNO() {
		return irdNO;
	}

	public void setIrdNO(String irdNO) {
		this.irdNO = irdNO;
	}

	public Float getPrfAmount() {
		return prfAmount;
	}

	public void setPrfAmount(Float prfAmount) {
		this.prfAmount = prfAmount;
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

	public Integer getLockRecord() {
		return lockRecord;
	}

	public void setLockRecord(Integer lockRecord) {
		this.lockRecord = lockRecord;
	}

	public Integer getCreatedDate() {
		return createdDate;
	}

	public void setCreatedDate(Integer createdDate) {
		this.createdDate = createdDate;
	}

	public Integer getStatus() {
		return status;
	}

	public void setStatus(Integer status) {
		this.status = status;
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

	public Integer getPrntCnt() {
		return prntCnt;
	}

	public void setPrntCnt(Integer prntCnt) {
		this.prntCnt = prntCnt;
	}

	public String getUtrNo() {
		return utrNo;
	}

	public void setUtrNo(String utrNo) {
		this.utrNo = utrNo;
	}

	public Date getTransferDate() {
		return transferDate;
	}

	public void setTransferDate(Date transferDate) {
		this.transferDate = transferDate;
	}

	public Date getUtrUploadDt() {
		return utrUploadDt;
	}

	public void setUtrUploadDt(Date utrUploadDt) {
		this.utrUploadDt = utrUploadDt;
	}

	public Integer getCid() {
		return cid;
	}

	public void setCid(Integer cid) {
		this.cid = cid;
	}

}
