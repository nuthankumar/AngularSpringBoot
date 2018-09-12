package com.exide.sfcrm.model;

import java.sql.Date;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.Id;
import javax.persistence.Table;


@Entity
@Table(name="tbltransactiontickets")
public class TblTransactionTickets {

	@Id
	@Column(name = "transautoid")
	private Integer transAutoId;

	@Column(name = "contestid")
	private Integer contestID;

	@Column(name = "contestname")
	private String contestName;

	@Column(name = "startdate")
	private Integer startDate;

	@Column(name = "enddate")
	private Integer endDate;

	@Column(name = "agentno")
	private String agentNo;

	@Column(name = "loaddate")
	private Integer loadDate;

	@Column(name = "createddate")
	private Integer createdDate;

	@Column(name = "ticketlists")
	private Integer ticketLists;

	@Column(name = "netvalue")
	private Float netValue;

	@Column(name = "netpayable")
	private Float netPayable;

	@Column(name = "netpaid")
	private Float netPaid;

	@Column(name = "previouspaid")
	private Float previousPaid;

	@Column(name = "balancepayable")
	private Float balancePayable;

	@Column(name = "previousnetpayable")
	private Float previousNetPayable;

	@Column(name = "[Option]")
	private String option;

	@Column(name = "destid")
	private Integer destId;

	@Column(name = "rulename")
	private String ruleName;

	@Column(name = "seq")
	private String seq;

	@Column(name = "validflag")
	private Integer validFlag;

	@Column(name = "paymentflag")
	private Integer paymentFlag;

	@Column(name = "entryflag")
	private Integer entryFlag;

	@Column(name = "recordcreatedate")
	private Integer recordCreateDate;

	@Column(name = "selectrecrd")
	private Boolean selectRecrd;

	@Column(name = "status")
	private Integer status;

	@Column(name = "remarks")
	private String remarks;

	@Column(name = "agtypes")
	private String agTypes;

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

	@Column(name = "deviationappruid")
	private String deviationApprUID;

	@Column(name = "deviationapprname")
	private String deviationApprName;

	@Column(name = "deviationapprdate")
	private Integer deviationApprdate;

	@Column(name = "deviationapprtime")
	private Date deviationApprTime;

	@Column(name = "deviationapprremarks")
	private String deviationApprRemarks;

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

	@Column(name = "paymentdate")
	private Integer paymentdate;

	@Column(name = "paymenttime")
	private Date paymentTime;

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

	@Column(name = "confirmationemailattchfilepath")
	private String confirmationEMailAttchFilePath;

	@Column(name = "confirmationemailattchby")
	private String confirmationEMailAttchBy;

	@Column(name = "confirmationemailattchtime")
	private Date confirmationEMailAttchTime;

	@Column(name = "cyclecount")
	private Float cycleCount;

	@Column(name = "currticketscount")
	private Integer currTicketsCount;

	@Column(name = "priticketscount")
	private Integer priTicketsCount;

	@Column(name = "netvalueticket")
	private Integer netValueTicket;

	@Column(name = "netrecoverdtickets")
	private Integer netRecoverdTickets;

	@Column(name = "netpayabletickes")
	private Integer netPayableTickes;

	@Column(name = "qualifiedtickets")
	private Integer qualifiedTickets;

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
	 * @return the contestID
	 */
	public Integer getContestID() {
		return contestID;
	}

	/**
	 * @param contestID the contestID to set
	 */
	public void setContestID(Integer contestID) {
		this.contestID = contestID;
	}

	/**
	 * @return the contestName
	 */
	public String getContestName() {
		return contestName;
	}

	/**
	 * @param contestName the contestName to set
	 */
	public void setContestName(String contestName) {
		this.contestName = contestName;
	}

	/**
	 * @return the startDate
	 */
	public Integer getStartDate() {
		return startDate;
	}

	/**
	 * @param startDate the startDate to set
	 */
	public void setStartDate(Integer startDate) {
		this.startDate = startDate;
	}

	/**
	 * @return the endDate
	 */
	public Integer getEndDate() {
		return endDate;
	}

	/**
	 * @param endDate the endDate to set
	 */
	public void setEndDate(Integer endDate) {
		this.endDate = endDate;
	}

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
	 * @return the loadDate
	 */
	public Integer getLoadDate() {
		return loadDate;
	}

	/**
	 * @param loadDate the loadDate to set
	 */
	public void setLoadDate(Integer loadDate) {
		this.loadDate = loadDate;
	}

	/**
	 * @return the createdDate
	 */
	public Integer getCreatedDate() {
		return createdDate;
	}

	/**
	 * @param createdDate the createdDate to set
	 */
	public void setCreatedDate(Integer createdDate) {
		this.createdDate = createdDate;
	}

	/**
	 * @return the ticketLists
	 */
	public Integer getTicketLists() {
		return ticketLists;
	}

	/**
	 * @param ticketLists the ticketLists to set
	 */
	public void setTicketLists(Integer ticketLists) {
		this.ticketLists = ticketLists;
	}

	/**
	 * @return the netValue
	 */
	public Float getNetValue() {
		return netValue;
	}

	/**
	 * @param netValue the netValue to set
	 */
	public void setNetValue(Float netValue) {
		this.netValue = netValue;
	}

	/**
	 * @return the netPayable
	 */
	public Float getNetPayable() {
		return netPayable;
	}

	/**
	 * @param netPayable the netPayable to set
	 */
	public void setNetPayable(Float netPayable) {
		this.netPayable = netPayable;
	}

	/**
	 * @return the netPaid
	 */
	public Float getNetPaid() {
		return netPaid;
	}

	/**
	 * @param netPaid the netPaid to set
	 */
	public void setNetPaid(Float netPaid) {
		this.netPaid = netPaid;
	}

	/**
	 * @return the previousPaid
	 */
	public Float getPreviousPaid() {
		return previousPaid;
	}

	/**
	 * @param previousPaid the previousPaid to set
	 */
	public void setPreviousPaid(Float previousPaid) {
		this.previousPaid = previousPaid;
	}

	/**
	 * @return the balancePayable
	 */
	public Float getBalancePayable() {
		return balancePayable;
	}

	/**
	 * @param balancePayable the balancePayable to set
	 */
	public void setBalancePayable(Float balancePayable) {
		this.balancePayable = balancePayable;
	}

	/**
	 * @return the previousNetPayable
	 */
	public Float getPreviousNetPayable() {
		return previousNetPayable;
	}

	/**
	 * @param previousNetPayable the previousNetPayable to set
	 */
	public void setPreviousNetPayable(Float previousNetPayable) {
		this.previousNetPayable = previousNetPayable;
	}

	/**
	 * @return the option
	 */
	public String getOption() {
		return option;
	}

	/**
	 * @param option the option to set
	 */
	public void setOption(String option) {
		this.option = option;
	}

	/**
	 * @return the destId
	 */
	public Integer getDestId() {
		return destId;
	}

	/**
	 * @param destId the destId to set
	 */
	public void setDestId(Integer destId) {
		this.destId = destId;
	}

	/**
	 * @return the ruleName
	 */
	public String getRuleName() {
		return ruleName;
	}

	/**
	 * @param ruleName the ruleName to set
	 */
	public void setRuleName(String ruleName) {
		this.ruleName = ruleName;
	}

	/**
	 * @return the seq
	 */
	public String getSeq() {
		return seq;
	}

	/**
	 * @param seq the seq to set
	 */
	public void setSeq(String seq) {
		this.seq = seq;
	}

	/**
	 * @return the validFlag
	 */
	public Integer getValidFlag() {
		return validFlag;
	}

	/**
	 * @param validFlag the validFlag to set
	 */
	public void setValidFlag(Integer validFlag) {
		this.validFlag = validFlag;
	}

	/**
	 * @return the paymentFlag
	 */
	public Integer getPaymentFlag() {
		return paymentFlag;
	}

	/**
	 * @param paymentFlag the paymentFlag to set
	 */
	public void setPaymentFlag(Integer paymentFlag) {
		this.paymentFlag = paymentFlag;
	}

	/**
	 * @return the entryFlag
	 */
	public Integer getEntryFlag() {
		return entryFlag;
	}

	/**
	 * @param entryFlag the entryFlag to set
	 */
	public void setEntryFlag(Integer entryFlag) {
		this.entryFlag = entryFlag;
	}

	/**
	 * @return the recordCreateDate
	 */
	public Integer getRecordCreateDate() {
		return recordCreateDate;
	}

	/**
	 * @param recordCreateDate the recordCreateDate to set
	 */
	public void setRecordCreateDate(Integer recordCreateDate) {
		this.recordCreateDate = recordCreateDate;
	}

	/**
	 * @return the selectRecrd
	 */
	public Boolean getSelectRecrd() {
		return selectRecrd;
	}

	/**
	 * @param selectRecrd the selectRecrd to set
	 */
	public void setSelectRecrd(Boolean selectRecrd) {
		this.selectRecrd = selectRecrd;
	}

	/**
	 * @return the status
	 */
	public Integer getStatus() {
		return status;
	}

	/**
	 * @param status the status to set
	 */
	public void setStatus(Integer status) {
		this.status = status;
	}

	/**
	 * @return the remarks
	 */
	public String getRemarks() {
		return remarks;
	}

	/**
	 * @param remarks the remarks to set
	 */
	public void setRemarks(String remarks) {
		this.remarks = remarks;
	}

	/**
	 * @return the agTypes
	 */
	public String getAgTypes() {
		return agTypes;
	}

	/**
	 * @param agTypes the agTypes to set
	 */
	public void setAgTypes(String agTypes) {
		this.agTypes = agTypes;
	}

	/**
	 * @return the maker1UID
	 */
	public String getMaker1UID() {
		return maker1UID;
	}

	/**
	 * @param maker1uid the maker1UID to set
	 */
	public void setMaker1UID(String maker1uid) {
		maker1UID = maker1uid;
	}

	/**
	 * @return the makerName
	 */
	public String getMakerName() {
		return makerName;
	}

	/**
	 * @param makerName the makerName to set
	 */
	public void setMakerName(String makerName) {
		this.makerName = makerName;
	}

	/**
	 * @return the makerDate
	 */
	public Integer getMakerDate() {
		return makerDate;
	}

	/**
	 * @param makerDate the makerDate to set
	 */
	public void setMakerDate(Integer makerDate) {
		this.makerDate = makerDate;
	}

	/**
	 * @return the makerTime
	 */
	public Date getMakerTime() {
		return makerTime;
	}

	/**
	 * @param makerTime the makerTime to set
	 */
	public void setMakerTime(Date makerTime) {
		this.makerTime = makerTime;
	}

	/**
	 * @return the checkerUID
	 */
	public String getCheckerUID() {
		return checkerUID;
	}

	/**
	 * @param checkerUID the checkerUID to set
	 */
	public void setCheckerUID(String checkerUID) {
		this.checkerUID = checkerUID;
	}

	/**
	 * @return the checkerName
	 */
	public String getCheckerName() {
		return checkerName;
	}

	/**
	 * @param checkerName the checkerName to set
	 */
	public void setCheckerName(String checkerName) {
		this.checkerName = checkerName;
	}

	/**
	 * @return the checkerDate
	 */
	public Integer getCheckerDate() {
		return checkerDate;
	}

	/**
	 * @param checkerDate the checkerDate to set
	 */
	public void setCheckerDate(Integer checkerDate) {
		this.checkerDate = checkerDate;
	}

	/**
	 * @return the checkerTime
	 */
	public Date getCheckerTime() {
		return checkerTime;
	}

	/**
	 * @param checkerTime the checkerTime to set
	 */
	public void setCheckerTime(Date checkerTime) {
		this.checkerTime = checkerTime;
	}

	/**
	 * @return the deviationApprUID
	 */
	public String getDeviationApprUID() {
		return deviationApprUID;
	}

	/**
	 * @param deviationApprUID the deviationApprUID to set
	 */
	public void setDeviationApprUID(String deviationApprUID) {
		this.deviationApprUID = deviationApprUID;
	}

	/**
	 * @return the deviationApprName
	 */
	public String getDeviationApprName() {
		return deviationApprName;
	}

	/**
	 * @param deviationApprName the deviationApprName to set
	 */
	public void setDeviationApprName(String deviationApprName) {
		this.deviationApprName = deviationApprName;
	}

	/**
	 * @return the deviationApprdate
	 */
	public Integer getDeviationApprdate() {
		return deviationApprdate;
	}

	/**
	 * @param deviationApprdate the deviationApprdate to set
	 */
	public void setDeviationApprdate(Integer deviationApprdate) {
		this.deviationApprdate = deviationApprdate;
	}

	/**
	 * @return the deviationApprTime
	 */
	public Date getDeviationApprTime() {
		return deviationApprTime;
	}

	/**
	 * @param deviationApprTime the deviationApprTime to set
	 */
	public void setDeviationApprTime(Date deviationApprTime) {
		this.deviationApprTime = deviationApprTime;
	}

	/**
	 * @return the deviationApprRemarks
	 */
	public String getDeviationApprRemarks() {
		return deviationApprRemarks;
	}

	/**
	 * @param deviationApprRemarks the deviationApprRemarks to set
	 */
	public void setDeviationApprRemarks(String deviationApprRemarks) {
		this.deviationApprRemarks = deviationApprRemarks;
	}

	/**
	 * @return the approver1UID
	 */
	public String getApprover1UID() {
		return approver1UID;
	}

	/**
	 * @param approver1uid the approver1UID to set
	 */
	public void setApprover1UID(String approver1uid) {
		approver1UID = approver1uid;
	}

	/**
	 * @return the approver1Name
	 */
	public String getApprover1Name() {
		return approver1Name;
	}

	/**
	 * @param approver1Name the approver1Name to set
	 */
	public void setApprover1Name(String approver1Name) {
		this.approver1Name = approver1Name;
	}

	/**
	 * @return the approver1date
	 */
	public Integer getApprover1date() {
		return approver1date;
	}

	/**
	 * @param approver1date the approver1date to set
	 */
	public void setApprover1date(Integer approver1date) {
		this.approver1date = approver1date;
	}

	/**
	 * @return the approver1Time
	 */
	public Date getApprover1Time() {
		return approver1Time;
	}

	/**
	 * @param approver1Time the approver1Time to set
	 */
	public void setApprover1Time(Date approver1Time) {
		this.approver1Time = approver1Time;
	}

	/**
	 * @return the approver1Remarks
	 */
	public String getApprover1Remarks() {
		return approver1Remarks;
	}

	/**
	 * @param approver1Remarks the approver1Remarks to set
	 */
	public void setApprover1Remarks(String approver1Remarks) {
		this.approver1Remarks = approver1Remarks;
	}

	/**
	 * @return the approver2UID
	 */
	public String getApprover2UID() {
		return approver2UID;
	}

	/**
	 * @param approver2uid the approver2UID to set
	 */
	public void setApprover2UID(String approver2uid) {
		approver2UID = approver2uid;
	}

	/**
	 * @return the approver2Name
	 */
	public String getApprover2Name() {
		return approver2Name;
	}

	/**
	 * @param approver2Name the approver2Name to set
	 */
	public void setApprover2Name(String approver2Name) {
		this.approver2Name = approver2Name;
	}

	/**
	 * @return the approver2Date
	 */
	public Integer getApprover2Date() {
		return approver2Date;
	}

	/**
	 * @param approver2Date the approver2Date to set
	 */
	public void setApprover2Date(Integer approver2Date) {
		this.approver2Date = approver2Date;
	}

	/**
	 * @return the approver2Time
	 */
	public Date getApprover2Time() {
		return approver2Time;
	}

	/**
	 * @param approver2Time the approver2Time to set
	 */
	public void setApprover2Time(Date approver2Time) {
		this.approver2Time = approver2Time;
	}

	/**
	 * @return the approver2Remarks
	 */
	public String getApprover2Remarks() {
		return approver2Remarks;
	}

	/**
	 * @param approver2Remarks the approver2Remarks to set
	 */
	public void setApprover2Remarks(String approver2Remarks) {
		this.approver2Remarks = approver2Remarks;
	}

	/**
	 * @return the approver3UID
	 */
	public String getApprover3UID() {
		return approver3UID;
	}

	/**
	 * @param approver3uid the approver3UID to set
	 */
	public void setApprover3UID(String approver3uid) {
		approver3UID = approver3uid;
	}

	/**
	 * @return the approver3Name
	 */
	public String getApprover3Name() {
		return approver3Name;
	}

	/**
	 * @param approver3Name the approver3Name to set
	 */
	public void setApprover3Name(String approver3Name) {
		this.approver3Name = approver3Name;
	}

	/**
	 * @return the approver3Date
	 */
	public Integer getApprover3Date() {
		return approver3Date;
	}

	/**
	 * @param approver3Date the approver3Date to set
	 */
	public void setApprover3Date(Integer approver3Date) {
		this.approver3Date = approver3Date;
	}

	/**
	 * @return the approver3Time
	 */
	public Date getApprover3Time() {
		return approver3Time;
	}

	/**
	 * @param approver3Time the approver3Time to set
	 */
	public void setApprover3Time(Date approver3Time) {
		this.approver3Time = approver3Time;
	}

	/**
	 * @return the approver3Remarks
	 */
	public String getApprover3Remarks() {
		return approver3Remarks;
	}

	/**
	 * @param approver3Remarks the approver3Remarks to set
	 */
	public void setApprover3Remarks(String approver3Remarks) {
		this.approver3Remarks = approver3Remarks;
	}

	/**
	 * @return the paymentdate
	 */
	public Integer getPaymentdate() {
		return paymentdate;
	}

	/**
	 * @param paymentdate the paymentdate to set
	 */
	public void setPaymentdate(Integer paymentdate) {
		this.paymentdate = paymentdate;
	}

	/**
	 * @return the paymentTime
	 */
	public Date getPaymentTime() {
		return paymentTime;
	}

	/**
	 * @param paymentTime the paymentTime to set
	 */
	public void setPaymentTime(Date paymentTime) {
		this.paymentTime = paymentTime;
	}

	/**
	 * @return the prfAmount
	 */
	public Float getPrfAmount() {
		return prfAmount;
	}

	/**
	 * @param prfAmount the prfAmount to set
	 */
	public void setPrfAmount(Float prfAmount) {
		this.prfAmount = prfAmount;
	}

	/**
	 * @return the prfNoGenREF
	 */
	public Integer getPrfNoGenREF() {
		return prfNoGenREF;
	}

	/**
	 * @param prfNoGenREF the prfNoGenREF to set
	 */
	public void setPrfNoGenREF(Integer prfNoGenREF) {
		this.prfNoGenREF = prfNoGenREF;
	}

	/**
	 * @return the prfNo
	 */
	public String getPrfNo() {
		return prfNo;
	}

	/**
	 * @param prfNo the prfNo to set
	 */
	public void setPrfNo(String prfNo) {
		this.prfNo = prfNo;
	}

	/**
	 * @return the prfGENDate
	 */
	public Integer getPrfGENDate() {
		return prfGENDate;
	}

	/**
	 * @param prfGENDate the prfGENDate to set
	 */
	public void setPrfGENDate(Integer prfGENDate) {
		this.prfGENDate = prfGENDate;
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
	 * @return the confirmationEMailAttchFilePath
	 */
	public String getConfirmationEMailAttchFilePath() {
		return confirmationEMailAttchFilePath;
	}

	/**
	 * @param confirmationEMailAttchFilePath the confirmationEMailAttchFilePath to set
	 */
	public void setConfirmationEMailAttchFilePath(
			String confirmationEMailAttchFilePath) {
		this.confirmationEMailAttchFilePath = confirmationEMailAttchFilePath;
	}

	/**
	 * @return the confirmationEMailAttchBy
	 */
	public String getConfirmationEMailAttchBy() {
		return confirmationEMailAttchBy;
	}

	/**
	 * @param confirmationEMailAttchBy the confirmationEMailAttchBy to set
	 */
	public void setConfirmationEMailAttchBy(String confirmationEMailAttchBy) {
		this.confirmationEMailAttchBy = confirmationEMailAttchBy;
	}

	/**
	 * @return the confirmationEMailAttchTime
	 */
	public Date getConfirmationEMailAttchTime() {
		return confirmationEMailAttchTime;
	}

	/**
	 * @param confirmationEMailAttchTime the confirmationEMailAttchTime to set
	 */
	public void setConfirmationEMailAttchTime(Date confirmationEMailAttchTime) {
		this.confirmationEMailAttchTime = confirmationEMailAttchTime;
	}

	/**
	 * @return the cycleCount
	 */
	public Float getCycleCount() {
		return cycleCount;
	}

	/**
	 * @param cycleCount the cycleCount to set
	 */
	public void setCycleCount(Float cycleCount) {
		this.cycleCount = cycleCount;
	}

	/**
	 * @return the currTicketsCount
	 */
	public Integer getCurrTicketsCount() {
		return currTicketsCount;
	}

	/**
	 * @param currTicketsCount the currTicketsCount to set
	 */
	public void setCurrTicketsCount(Integer currTicketsCount) {
		this.currTicketsCount = currTicketsCount;
	}

	/**
	 * @return the priTicketsCount
	 */
	public Integer getPriTicketsCount() {
		return priTicketsCount;
	}

	/**
	 * @param priTicketsCount the priTicketsCount to set
	 */
	public void setPriTicketsCount(Integer priTicketsCount) {
		this.priTicketsCount = priTicketsCount;
	}

	/**
	 * @return the netValueTicket
	 */
	public Integer getNetValueTicket() {
		return netValueTicket;
	}

	/**
	 * @param netValueTicket the netValueTicket to set
	 */
	public void setNetValueTicket(Integer netValueTicket) {
		this.netValueTicket = netValueTicket;
	}

	/**
	 * @return the netRecoverdTickets
	 */
	public Integer getNetRecoverdTickets() {
		return netRecoverdTickets;
	}

	/**
	 * @param netRecoverdTickets the netRecoverdTickets to set
	 */
	public void setNetRecoverdTickets(Integer netRecoverdTickets) {
		this.netRecoverdTickets = netRecoverdTickets;
	}

	/**
	 * @return the netPayableTickes
	 */
	public Integer getNetPayableTickes() {
		return netPayableTickes;
	}

	/**
	 * @param netPayableTickes the netPayableTickes to set
	 */
	public void setNetPayableTickes(Integer netPayableTickes) {
		this.netPayableTickes = netPayableTickes;
	}

	/**
	 * @return the qualifiedTickets
	 */
	public Integer getQualifiedTickets() {
		return qualifiedTickets;
	}

	/**
	 * @param qualifiedTickets the qualifiedTickets to set
	 */
	public void setQualifiedTickets(Integer qualifiedTickets) {
		this.qualifiedTickets = qualifiedTickets;
	}
	
}
