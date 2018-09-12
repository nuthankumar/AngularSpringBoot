package com.exide.sfcrm.model;

import java.io.Serializable;

import javax.persistence.Column;
import javax.persistence.Embeddable;

@Embeddable
public class ApproverOneTicketKey implements Serializable {
	/**
	 * 
	 */
	private static final long serialVersionUID = 6398630663986194913L;

	@Column(name = "prfno")
	private String prfNo;

	/**
	 * @return the prfNo
	 */
	public String getPrfNo() {
		return prfNo;
	}

	/**
	 * @param prfNo
	 *            the prfNo to set
	 */
	public void setPrfNo(String prfNo) {
		this.prfNo = prfNo;
	}

}
