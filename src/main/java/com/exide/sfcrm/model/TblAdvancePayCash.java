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
@Table(name = "tbladvancepaycash")
public class TblAdvancePayCash implements Serializable {

	/**
	 * 
	 */
	private static final long serialVersionUID = 6038369952862703549L;

	@Id
	@Column(name = "[advancepayautoid]", nullable = false)
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	private Integer advancePayAutoID;

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

	@Column(name = "remarks")
	private String remarks;

	@Column(name = "maxrecoverblepercycle")
	private Integer maxRecoverblePerCycle;

	@Column(name = "netbalance")
	private Integer netBalance;

	@Column(name = "validflag")
	private Integer validFlag;

	@Column(name = "status")
	private Integer status;

	@Column(name = "maker1uid")
	private String maker1UID;

	@Column(name = "makername")
	private String makerName;

	@Column(name = "makerdate")
	private Integer makerDate;

	@Column(name = "makertime")
	private Date makerTime;

	@Column(name = "checkeruid")
	private String checkerUID;

	@Column(name = "checkername")
	private String checkerName;

	@Column(name = "checkerdate")
	private Integer checkerDate;

	@Column(name = "checkertime")
	private Date checkerTime;

	@Column(name = "approver1uid")
	private String approver1UID;

	@Column(name = "approver1name")
	private String approver1Name;

	@Column(name = "approver1date")
	private Integer approver1date;

	@Column(name = "approver1time")
	private Date approver1Time;

	@Column(name = "approver1remarks")
	private String approver1Remarks;

	@Column(name = "approver2uid")
	private String approver2UID;

	@Column(name = "approver2name")
	private String approver2Name;

	@Column(name = "approver2date")
	private Integer approver2Date;

	@Column(name = "approver2time")
	private Date approver2Time;

	@Column(name = "approver2remarks")
	private String approver2Remarks;

	@Column(name = "approver3uid")
	private String approver3UID;

	@Column(name = "approver3name")
	private String approver3Name;

	@Column(name = "approver3date")
	private Integer approver3Date;

	@Column(name = "approver3time")
	private Date approver3Time;

	@Column(name = "approver3remarks")
	private String approver3Remarks;

	@Column(name = "prfnogenref")
	private Integer prfNoGenREF;

	@Column(name = "prfno")
	private String prfNo;

	@Column(name = "prfgendate")
	private Integer prfGENDate;

	@Column(name = "confirmationemailattchfilepath")
	private String vonfirmationEMailAttchFilePath;

	@Column(name = "confirmationemailattchby")
	private String confirmationEMailAttchBy;

	@Column(name = "confirmationemailattchtime")
	private Date confirmationEMailAttchTime;

	@Column(name = "createdate")
	private Date createDate;

	@Column(name = "collectiondate")
	private Date collectionDate;

	@Column(name = "CPT_Option")
	private String cptOption;

	@Column(name = "ticketcount")
	private String ticketCount;

	@Column(name = "netrecovered")
	private Integer netRecovered;

	@Column(name = "payrecoverflag")
	private String payRecoverFlag;

	@Column(name = "paymentflag")
	private Integer paymentFlag;

	@Column(name = "paymentdate")
	private Integer paymentdate;

	@Column(name = "paymenttime")
	private Date paymentTime;

	@Column(name = "prfamount")
	private Float prfAmount;

	public Integer getAdvancePayAutoID() {
		return advancePayAutoID;
	}

	public void setAdvancePayAutoID(Integer advancePayAutoID) {
		this.advancePayAutoID = advancePayAutoID;
	}

	public String getAgentNo() {
		return agentNo;
	}

	public void setAgentNo(String agentNo) {
		this.agentNo = agentNo;
	}

	public Integer getAdvDate() {
		return advDate;
	}

	public void setAdvDate(Integer advDate) {
		this.advDate = advDate;
	}

	public Integer getEffectiveStartDateForRecovery() {
		return effectiveStartDateForRecovery;
	}

	public void setEffectiveStartDateForRecovery(
			Integer effectiveStartDateForRecovery) {
		this.effectiveStartDateForRecovery = effectiveStartDateForRecovery;
	}

	public Integer getAmount() {
		return amount;
	}

	public void setAmount(Integer amount) {
		this.amount = amount;
	}

	public Integer getRecoverable() {
		return recoverable;
	}

	public void setRecoverable(Integer recoverable) {
		this.recoverable = recoverable;
	}

	public String getRemarks() {
		return remarks;
	}

	public void setRemarks(String remarks) {
		this.remarks = remarks;
	}

	public Integer getMaxRecoverblePerCycle() {
		return maxRecoverblePerCycle;
	}

	public void setMaxRecoverblePerCycle(Integer maxRecoverblePerCycle) {
		this.maxRecoverblePerCycle = maxRecoverblePerCycle;
	}

	public Integer getNetBalance() {
		return netBalance;
	}

	public void setNetBalance(Integer netBalance) {
		this.netBalance = netBalance;
	}

	public Integer getValidFlag() {
		return validFlag;
	}

	public void setValidFlag(Integer validFlag) {
		this.validFlag = validFlag;
	}

	public Integer getStatus() {
		return status;
	}

	public void setStatus(Integer status) {
		this.status = status;
	}

	public String getMaker1UID() {
		return maker1UID;
	}

	public void setMaker1UID(String maker1uid) {
		maker1UID = maker1uid;
	}

	public String getMakerName() {
		return makerName;
	}

	public void setMakerName(String makerName) {
		this.makerName = makerName;
	}

	public Integer getMakerDate() {
		return makerDate;
	}

	public void setMakerDate(Integer makerDate) {
		this.makerDate = makerDate;
	}

	public Date getMakerTime() {
		return makerTime;
	}

	public void setMakerTime(Date makerTime) {
		this.makerTime = makerTime;
	}

	public String getCheckerUID() {
		return checkerUID;
	}

	public void setCheckerUID(String checkerUID) {
		this.checkerUID = checkerUID;
	}

	public String getCheckerName() {
		return checkerName;
	}

	public void setCheckerName(String checkerName) {
		this.checkerName = checkerName;
	}

	public Integer getCheckerDate() {
		return checkerDate;
	}

	public void setCheckerDate(Integer checkerDate) {
		this.checkerDate = checkerDate;
	}

	public Date getCheckerTime() {
		return checkerTime;
	}

	public void setCheckerTime(Date checkerTime) {
		this.checkerTime = checkerTime;
	}

	public String getApprover1UID() {
		return approver1UID;
	}

	public void setApprover1UID(String approver1uid) {
		approver1UID = approver1uid;
	}

	public String getApprover1Name() {
		return approver1Name;
	}

	public void setApprover1Name(String approver1Name) {
		this.approver1Name = approver1Name;
	}

	public Integer getApprover1date() {
		return approver1date;
	}

	public void setApprover1date(Integer approver1date) {
		this.approver1date = approver1date;
	}

	public Date getApprover1Time() {
		return approver1Time;
	}

	public void setApprover1Time(Date approver1Time) {
		this.approver1Time = approver1Time;
	}

	public String getApprover1Remarks() {
		return approver1Remarks;
	}

	public void setApprover1Remarks(String approver1Remarks) {
		this.approver1Remarks = approver1Remarks;
	}

	public String getApprover2UID() {
		return approver2UID;
	}

	public void setApprover2UID(String approver2uid) {
		approver2UID = approver2uid;
	}

	public String getApprover2Name() {
		return approver2Name;
	}

	public void setApprover2Name(String approver2Name) {
		this.approver2Name = approver2Name;
	}

	public Integer getApprover2Date() {
		return approver2Date;
	}

	public void setApprover2Date(Integer approver2Date) {
		this.approver2Date = approver2Date;
	}

	public Date getApprover2Time() {
		return approver2Time;
	}

	public void setApprover2Time(Date approver2Time) {
		this.approver2Time = approver2Time;
	}

	public String getApprover2Remarks() {
		return approver2Remarks;
	}

	public void setApprover2Remarks(String approver2Remarks) {
		this.approver2Remarks = approver2Remarks;
	}

	public String getApprover3UID() {
		return approver3UID;
	}

	public void setApprover3UID(String approver3uid) {
		approver3UID = approver3uid;
	}

	public String getApprover3Name() {
		return approver3Name;
	}

	public void setApprover3Name(String approver3Name) {
		this.approver3Name = approver3Name;
	}

	public Integer getApprover3Date() {
		return approver3Date;
	}

	public void setApprover3Date(Integer approver3Date) {
		this.approver3Date = approver3Date;
	}

	public Date getApprover3Time() {
		return approver3Time;
	}

	public void setApprover3Time(Date approver3Time) {
		this.approver3Time = approver3Time;
	}

	public String getApprover3Remarks() {
		return approver3Remarks;
	}

	public void setApprover3Remarks(String approver3Remarks) {
		this.approver3Remarks = approver3Remarks;
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

	public String getVonfirmationEMailAttchFilePath() {
		return vonfirmationEMailAttchFilePath;
	}

	public void setVonfirmationEMailAttchFilePath(
			String vonfirmationEMailAttchFilePath) {
		this.vonfirmationEMailAttchFilePath = vonfirmationEMailAttchFilePath;
	}

	public String getConfirmationEMailAttchBy() {
		return confirmationEMailAttchBy;
	}

	public void setConfirmationEMailAttchBy(String confirmationEMailAttchBy) {
		this.confirmationEMailAttchBy = confirmationEMailAttchBy;
	}

	public Date getConfirmationEMailAttchTime() {
		return confirmationEMailAttchTime;
	}

	public void setConfirmationEMailAttchTime(Date confirmationEMailAttchTime) {
		this.confirmationEMailAttchTime = confirmationEMailAttchTime;
	}

	public Date getCreateDate() {
		return createDate;
	}

	public void setCreateDate(Date createDate) {
		this.createDate = createDate;
	}

	public Date getCollectionDate() {
		return collectionDate;
	}

	public void setCollectionDate(Date collectionDate) {
		this.collectionDate = collectionDate;
	}

	public String getCptOption() {
		return cptOption;
	}

	public void setCptOption(String cptOption) {
		this.cptOption = cptOption;
	}

	public String getTicketCount() {
		return ticketCount;
	}

	public void setTicketCount(String ticketCount) {
		this.ticketCount = ticketCount;
	}

	public Integer getNetRecovered() {
		return netRecovered;
	}

	public void setNetRecovered(Integer netRecovered) {
		this.netRecovered = netRecovered;
	}

	public String getPayRecoverFlag() {
		return payRecoverFlag;
	}

	public void setPayRecoverFlag(String payRecoverFlag) {
		this.payRecoverFlag = payRecoverFlag;
	}

	public Integer getPaymentFlag() {
		return paymentFlag;
	}

	public void setPaymentFlag(Integer paymentFlag) {
		this.paymentFlag = paymentFlag;
	}

	public Integer getPaymentdate() {
		return paymentdate;
	}

	public void setPaymentdate(Integer paymentdate) {
		this.paymentdate = paymentdate;
	}

	public Date getPaymentTime() {
		return paymentTime;
	}

	public void setPaymentTime(Date paymentTime) {
		this.paymentTime = paymentTime;
	}

	public Float getPrfAmount() {
		return prfAmount;
	}

	public void setPrfAmount(Float prfAmount) {
		this.prfAmount = prfAmount;
	}

}
