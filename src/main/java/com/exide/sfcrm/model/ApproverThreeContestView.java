package com.exide.sfcrm.model;

import javax.persistence.Column;
import javax.persistence.EmbeddedId;
import javax.persistence.Entity;
import javax.persistence.Table;

@Entity
@Table(name = "approverthreecashview")
public class ApproverThreeContestView {

	@Column(name = "prfnogenref")
	private Integer prfGenRef;

	@Column(name = "prfgendate")
	private String prfGenDate;

	@Column(name = "prfamount")
	private Float prfAmount;

	@Column(name = "status")
	private String status;
	
	@EmbeddedId
	private ApproverOneKey approverOneKey;

	/**
	 * @return the prfGenRef
	 */
	public Integer getPrfGenRef() {
		return prfGenRef;
	}

	/**
	 * @param prfGenRef
	 *            the prfGenRef to set
	 */
	public void setPrfGenRef(Integer prfGenRef) {
		this.prfGenRef = prfGenRef;
	}

	/**
	 * @return the prfGenDate
	 */
	public String getPrfGenDate() {
		return prfGenDate;
	}

	/**
	 * @param prfGenDate
	 *            the prfGenDate to set
	 */
	public void setPrfGenDate(String prfGenDate) {
		this.prfGenDate = prfGenDate;
	}

	/**
	 * @return the prfAmount
	 */
	public Float getPrfAmount() {
		return prfAmount;
	}

	/**
	 * @param prfAmount
	 *            the prfAmount to set
	 */
	public void setPrfAmount(Float prfAmount) {
		this.prfAmount = prfAmount;
	}

	/**
	 * @return the status
	 */
	public String getStatus() {
		return status;
	}

	/**
	 * @param status
	 *            the status to set
	 */
	public void setStatus(String status) {
		this.status = status;
	}

}