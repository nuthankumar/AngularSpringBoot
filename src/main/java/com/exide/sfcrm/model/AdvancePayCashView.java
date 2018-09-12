package com.exide.sfcrm.model;

import javax.persistence.Column;
import javax.persistence.EmbeddedId;
import javax.persistence.Entity;
import javax.persistence.Table;


@Entity
@Table(name = "tmptbladvancepaycash")
public class AdvancePayCashView {

	
	@EmbeddedId
	AdvancePayCashKey advancePayCashKey;
	
	@Column(name = "remarks")
	private String remarks;


	/**
	 * @return the advancePayCashKey
	 */
	public AdvancePayCashKey getAdvancePayCashKey() {
		return advancePayCashKey;
	}

	/**
	 * @param advancePayCashKey the advancePayCashKey to set
	 */
	public void setAdvancePayCashKey(AdvancePayCashKey advancePayCashKey) {
		this.advancePayCashKey = advancePayCashKey;
	}
	
	
	/**
	 * @return the remarks
	 */
	public String getRemarks() {
		return remarks;
	}

	/**
	 * @param remarks the remarks to set
	 */
	public void setRemarks(String remarks) {
		this.remarks = remarks;
	}
	
}
