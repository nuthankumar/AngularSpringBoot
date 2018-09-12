package com.exide.sfcrm.model;

import java.sql.Date;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.Id;
import javax.persistence.Table;


@Entity
@Table(name = "prflistticketview")
public class PrfListTicketView {
	
	@Id
	@Column(name = "id")
	private Integer transAutoId;

	@Column(name = "agentno")
	private String agentNo;
	
	@Column (name="agentname")
	private String agentName;
	
	@Column(name = "ticketlists")
	private Integer ticketLists;
	
	@Column(name = "netamount")
	private Float netAmount;
	
	@Column(name = "deviationamt")
	private Float deviationAmt;
	
	@Column(name = "netpayout")
	private Float netPayout;
	
	@Column(name = "agclass")
	private Integer agClass;
	
	@Column(name = "trandate")
	private Date TranDate;

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
	 * @return the netPayable
	 */
	public Float getNetAmount() {
		return netAmount;
	}

	/**
	 * @param netPayable the netAmount to set
	 */
	public void setNetAmount(Float netAmount) {
		this.netAmount = netAmount;
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

	/**
	 * @return the tranDate
	 */
	public Date getTranDate() {
		return TranDate;
	}

	/**
	 * @param tranDate the tranDate to set
	 */
	public void setTranDate(Date tranDate) {
		TranDate = tranDate;
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
