package com.exide.sfcrm.model;



import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.Id;
import javax.persistence.Table;

@Entity
@Table(name = "ticketexcelview")
public class TicketExcelView {

	@Id
	@Column(name = "transautoid")
	private Integer transAutoId;

	@Column(name = "contestid")
	private Integer contestID;

	@Column(name = "contestname")
	private String contestName;

	@Column(name = "startdate")
	private String startDate;

	@Column(name = "enddate")
	private String endDate;

	@Column(name = "agentno")
	private String agentNo;

	@Column(name = "loaddate")
	private String loadDate;

	@Column(name = "ticketlists")
	private Integer ticketLists;

	@Column(name = "[Option]")
	private String option;

	@Column(name = "destid")
	private Integer destId;

	@Column(name = "rulename")
	private String ruleName;

	@Column(name = "seq")
	private String seq;

	@Column(name = "totalcount")
	private String totalCount;
	
	@Column(name = "totalqualified")
	private String totalQualified;
	
	@Column(name = "qualified")
	private String qualified;

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
	public String getStartDate() {
		return startDate;
	}

	/**
	 * @param startDate the startDate to set
	 */
	public void setStartDate(String startDate) {
		this.startDate = startDate;
	}

	/**
	 * @return the endDate
	 */
	public String getEndDate() {
		return endDate;
	}

	/**
	 * @param endDate the endDate to set
	 */
	public void setEndDate(String endDate) {
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
	public String getLoadDate() {
		return loadDate;
	}

	/**
	 * @param loadDate the loadDate to set
	 */
	public void setLoadDate(String loadDate) {
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
	 * @return the totalCount
	 */
	public String getTotalCount() {
		return totalCount;
	}

	/**
	 * @param totalCount the totalCount to set
	 */
	public void setTotalCount(String totalCount) {
		this.totalCount = totalCount;
	}

	/**
	 * @return the totalQualified
	 */
	public String getTotalQualified() {
		return totalQualified;
	}

	/**
	 * @param totalQualified the totalQualified to set
	 */
	public void setTotalQualified(String totalQualified) {
		this.totalQualified = totalQualified;
	}

	/**
	 * @return the qualified
	 */
	public String getQualified() {
		return qualified;
	}

	/**
	 * @param qualified the qualified to set
	 */
	public void setQualified(String qualified) {
		this.qualified = qualified;
	}
	
	

}