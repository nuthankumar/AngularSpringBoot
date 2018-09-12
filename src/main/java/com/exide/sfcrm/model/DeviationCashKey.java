package com.exide.sfcrm.model;

import java.io.Serializable;

import javax.persistence.Column;
import javax.persistence.Embeddable;

/**
 * 
 * @author vasavivr
 *
 */
@Embeddable
public class DeviationCashKey implements Serializable {

	/**
	 * 
	 */
	private static final long serialVersionUID = 6812523314494484890L;
	
	

	@Column(name = "contestid")
	private Integer contestID;

	@Column(name = "contestname")
	private String contestName;

	@Column(name = "agentno")
	private String agentNo;

	@Column(name = "loaddate")
	private Integer loadDate;

	@Column(name = "status")
	private String status;

	@Column(name = "entryflag")
	private Integer entryFlag;

	@Column(name = "netpayable")
	private Float netPayable;

	public Integer getContestID() {
		return contestID;
	}

	public void setContestID(Integer contestID) {
		this.contestID = contestID;
	}

	public String getContestName() {
		return contestName;
	}

	public void setContestName(String contestName) {
		this.contestName = contestName;
	}

	public String getAgentNo() {
		return agentNo;
	}

	public void setAgentNo(String agentNo) {
		this.agentNo = agentNo;
	}

	public Integer getLoadDate() {
		return loadDate;
	}

	public void setLoadDate(Integer loadDate) {
		this.loadDate = loadDate;
	}



	/*
	 * public Boolean getSelectRecrd() { return selectRecrd; }
	 * 
	 * public void setSelectRecrd(Boolean selectRecrd) { this.selectRecrd =
	 * selectRecrd; }
	 */



	public Integer getEntryFlag() {
		return entryFlag;
	}

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

	public String getStatus() {
		return status;
	}

	public void setStatus(String status) {
		this.status = status;
	}

	
}
