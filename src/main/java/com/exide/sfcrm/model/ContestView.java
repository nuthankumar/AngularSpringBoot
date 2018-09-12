package com.exide.sfcrm.model;

import java.io.Serializable;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.Id;
import javax.persistence.Table;


@Entity
@Table(name="contestview")
public class ContestView  implements Serializable{

	/**
	 * 
	 */
	private static final long serialVersionUID = -5378737901812443944L;

	@Id
	@Column(name = "contestid")
	private Integer contestId;

	@Column(name = "contestname")
	private String contestName;

	@Column(name = "startdate")
	private String startDate;

	@Column(name = "enddate")
	private String endDate;

	@Column(name = "agtypes")
	private String agTypes;

	@Column(name = "Incentive_YorN")
	private String incentive_YorN;
	
	@Column(name = "chanelname")
	private String chanelName;

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
	 * @return the incentive_YorN
	 */
	public String getIncentive_YorN() {
		return incentive_YorN;
	}

	/**
	 * @param incentive_YorN the incentive_YorN to set
	 */
	public void setIncentive_YorN(String incentive_YorN) {
		this.incentive_YorN = incentive_YorN;
	}

	/**
	 * @return the chanelName
	 */
	public String getChanelName() {
		return chanelName;
	}

	/**
	 * @param chanelName the chanelName to set
	 */
	public void setChanelName(String chanelName) {
		this.chanelName = chanelName;
	}

	
	
}
