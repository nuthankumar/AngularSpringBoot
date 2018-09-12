package com.exide.sfcrm.model;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.Id;
import javax.persistence.Table;

@Entity
@Table(name = "makerview")
public class MakerContestListView {
	@Id
	@Column(name="contestid")
	private Integer contestId;
	
	@Column(name="contestname")
	private String contestName;
	
	@Column(name = "agtypes")
	private String agType;
	
	@Column(name="countofagentno")
	private Integer countOfAgentNo;
	
	@Column(name="sumofnetpayable")
	private Double sumOfNetPayable;
	
	@Column(name="sumofpreviouspaid")
	private Double sumOfPreviousPaid;

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
	 * @return the agType
	 */
	public String getAgType() {
		return agType;
	}

	/**
	 * @param agType the agType to set
	 */
	public void setAgType(String agType) {
		this.agType = agType;
	}

	/**
	 * @return the countOfAgentNo
	 */
	public Integer getCountOfAgentNo() {
		return countOfAgentNo;
	}

	/**
	 * @param countOfAgentNo the countOfAgentNo to set
	 */
	public void setCountOfAgentNo(Integer countOfAgentNo) {
		this.countOfAgentNo = countOfAgentNo;
	}

	/**
	 * @return the sumOfNetPayable
	 */
	public Double getSumOfNetPayable() {
		return sumOfNetPayable;
	}

	/**
	 * @param sumOfNetPayable the sumOfNetPayable to set
	 */
	public void setSumOfNetPayable(Double sumOfNetPayable) {
		this.sumOfNetPayable = sumOfNetPayable;
	}

	/**
	 * @return the sumOfPreviousPaid
	 */
	public Double getSumOfPreviousPaid() {
		return sumOfPreviousPaid;
	}

	/**
	 * @param sumOfPreviousPaid the sumOfPreviousPaid to set
	 */
	public void setSumOfPreviousPaid(Double sumOfPreviousPaid) {
		this.sumOfPreviousPaid = sumOfPreviousPaid;
	}
	
	
	
	
	
	

}
