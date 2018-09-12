package com.exide.sfcrm.model;

import javax.persistence.Column;
import javax.persistence.EmbeddedId;
import javax.persistence.Entity;
import javax.persistence.Table;

@Entity
@Table(name = "approveroneview")
public class ApproverOneContestView {
	
	
	@Column(name="prfnogenref")
	private Integer prfGenRef;
	
	@Column(name="prfgendate")
	private String prfGenDate;
	
	@Column(name="prfamount")
	private Float prfAmount;
	
	@Column(name="status")
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
	 * @param prfGenRef the prfGenRef to set
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
	 * @param prfGenDate the prfGenDate to set
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
	 * @param prfAmount the prfAmount to set
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
	 * @param status the status to set
	 */
	public void setStatus(String status) {
		this.status = status;
	}

	/**
	 * @return the approverOneKey
	 */
	public ApproverOneKey getApproverOneKey() {
		return approverOneKey;
	}

	/**
	 * @param approverOneKey the approverOneKey to set
	 */
	public void setApproverOneKey(ApproverOneKey approverOneKey) {
		this.approverOneKey = approverOneKey;
	}
	
	/*@Override
	public int hashCode() {
		return this.prfGenRef + this.prfGenDate + this.prfAmount.intValue() + this.approverOneKey.hashCode();
	}*/
	
	@Override
	public boolean equals(Object obj) {
		ApproverOneContestView view = (ApproverOneContestView) obj;
		if((view.prfGenRef == this.prfGenRef) && (view.prfAmount == this.prfAmount) && (view.prfGenDate == this.prfGenDate)
				
		&& 	(view.prfGenRef == this.prfGenRef)	){
			return true;
		} else {
			return false;
		}
		
	}

}
