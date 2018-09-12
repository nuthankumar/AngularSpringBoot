package com.exide.sfcrm.model;

import javax.persistence.Column;
import javax.persistence.EmbeddedId;
import javax.persistence.Entity;
import javax.persistence.Table;


@Entity
@Table(name="tmptblcashdeviation")
public class DeviationCashView {
	
	@Column(name = "previousnetpayable")
	private Float previousNetPayable;


	@Column(name = "deviationapprremarks")
	private String deviationApprRemarks;

	@Column(name = "approver1remarks")
	private String approver1Remarks;

	@Column(name = "remarks")
	private String remarks;
	
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
	@EmbeddedId
	private DeviationCashKey deviationCashKey;

	/**
	 * 
	 * @return deviationCashKey
	 */
	public DeviationCashKey getDeviationCashKey() {
		return deviationCashKey;
	}
	/**
	 * 
	 * @param deviationCashKey the deviationCashKey to set
	 */

	public void setDeviationCashKey(DeviationCashKey deviationCashKey) {
		this.deviationCashKey = deviationCashKey;
	}
	

}
