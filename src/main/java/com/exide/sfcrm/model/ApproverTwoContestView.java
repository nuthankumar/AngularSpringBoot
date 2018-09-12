package com.exide.sfcrm.model;

import java.io.Serializable;

import javax.persistence.Column;
import javax.persistence.EmbeddedId;
import javax.persistence.Entity;
import javax.persistence.Table;

@Entity
@Table(name="approvertwoview")
public class ApproverTwoContestView  implements Serializable{
	/**
	 * 
	 */
	private static final long serialVersionUID = -6802435133915586271L;

	@Column(name="prfnogenref")
	private Integer prfGenRef;
	
	@Column(name="prfgendate")
	private String prfGenDate;
	
	@Column(name="prfamount")
	private Float prfAmount;
	
	@Column(name="status")
	private String status;
	
	public Integer getPrfGenRef() {
		return prfGenRef;
	}
	@EmbeddedId
	private ApproverOneKey approverOneKey;

	public void setPrfGenRef(Integer prfGenRef) {
		this.prfGenRef = prfGenRef;
	}

	public String getPrfGenDate() {
		return prfGenDate;
	}

	public void setPrfGenDate(String prfGenDate) {
		this.prfGenDate = prfGenDate;
	}

	public Float getPrfAmount() {
		return prfAmount;
	}

	public void setPrfAmount(Float prfAmount) {
		this.prfAmount = prfAmount;
	}

	public String getStatus() {
		return status;
	}

	public void setStatus(String status) {
		this.status = status;
	}

	public ApproverOneKey getApproverOneKey() {
		return approverOneKey;
	}

	public void setApproverOneKey(ApproverOneKey approverOneKey) {
		this.approverOneKey = approverOneKey;
	}

	
}
