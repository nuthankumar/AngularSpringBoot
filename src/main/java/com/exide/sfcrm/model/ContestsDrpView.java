package com.exide.sfcrm.model;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.Id;
import javax.persistence.Table;


@Entity
@Table(name="contestviewdrp")
public class ContestsDrpView {
	
	@Id
	@Column(name = "contestid")
	private Integer contestId;

	@Column(name = "contestname")
	private String contestName;

	@Column(name = "startdate")
	private String startDate;

	@Column(name = "enddate")
	private String endDate;
	
	@Column(name="contestidname")
	private String contestIDName;

	/**
	 * @return the contestId
	 */
	public Integer getContestId() {
		return contestId;
	}

	/**
	 * @param contestId the contestId to set
	 */
	public void setContestId(Integer contestId) {
		this.contestId = contestId;
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
	 * @return the contestIDName
	 */
	public String getContestIDName() {
		return contestIDName;
	}

	/**
	 * @param contestIDName the contestIDName to set
	 */
	public void setContestIDName(String contestIDName) {
		this.contestIDName = contestIDName;
	}

	

}
