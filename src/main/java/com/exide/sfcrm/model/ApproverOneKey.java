package com.exide.sfcrm.model;

import java.io.Serializable;


import java.text.DateFormat;
import java.text.SimpleDateFormat;
import java.util.Date;

import javax.persistence.Column;
import javax.persistence.Embeddable;
import javax.persistence.Transient;

@Embeddable
public class ApproverOneKey implements Serializable{

	private static final long serialVersionUID = 1452421363766475904L;
	
	
	
	
	@Column(name="prfno")
	private String prfNo;


	/**
	 * @return the prfNo
	 */
	public String getPrfNo() {
		return prfNo;
	}

	/**
	 * @param prfNo the prfNo to set
	 */
	public void setPrfNo(String prfNo) {
		this.prfNo = prfNo;
	}
	
	

}
