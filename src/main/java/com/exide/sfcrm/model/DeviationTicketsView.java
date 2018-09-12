package com.exide.sfcrm.model;

import javax.persistence.Column;
import javax.persistence.EmbeddedId;
import javax.persistence.Entity;
import javax.persistence.Table;

@Entity
@Table(name = "tmptblticketsdeviation")
public class DeviationTicketsView {

	@Column(name = "contestid")
	private Integer contestID;

	@Column(name = "contestname")
	private String contestName;

	@Column(name = "loaddate")
	private Integer loadDate;

	@Column(name = "ticketlists")
	private Integer ticketLists;

	@Column(name = "destid")
	private Integer destId;

	@Column(name = "status")
	private String status;

	@Column(name = "entryflag")
	private Integer entryFlag;

	@Column(name = "netpayable")
	private Float netPayable;

	@Column(name = "previousnetpayable")
	private Float previousNetPayable;

	@Column(name = "deviationapprremarks")
	private String deviationApprRemarks;

	@Column(name = "approver1remarks")
	private String approver1Remarks;
	
	@Column(name = "remarks")
	private String remarks;
	
	

	@EmbeddedId
	DeviationTicketsKey deviationTicketsKey;

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


	public String getStatus() {
		return status;
	}

	public void setStatus(String status) {
		this.status = status;
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

	public DeviationTicketsKey getDeviationTicketsKey() {
		return deviationTicketsKey;
	}

	public void setDeviationTicketsKey(DeviationTicketsKey deviationTicketsKey) {
		this.deviationTicketsKey = deviationTicketsKey;
	}



}
