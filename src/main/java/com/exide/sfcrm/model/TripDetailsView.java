package com.exide.sfcrm.model;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.Id;
import javax.persistence.Table;

@Entity
@Table(name = "tripdetailsview")
public class TripDetailsView {

	@Id
	@Column(name = "destid")
	private Integer destID;

	@Column(name = "destname")
	private String destName;

	@Column(name = "cashamt")
	private Float cashAmt;

	@Column(name = "tripamt")
	private Float tripAmt;

	/**
	 * @return the destID
	 */
	public Integer getDestID() {
		return destID;
	}

	/**
	 * @param destID the destID to set
	 */
	public void setDestID(Integer destID) {
		this.destID = destID;
	}

	/**
	 * @return the destName
	 */
	public String getDestName() {
		return destName;
	}

	/**
	 * @param destName the destName to set
	 */
	public void setDestName(String destName) {
		this.destName = destName;
	}

	/**
	 * @return the cashAmt
	 */
	public Float getCashAmt() {
		return cashAmt;
	}

	/**
	 * @param cashAmt the cashAmt to set
	 */
	public void setCashAmt(Float cashAmt) {
		this.cashAmt = cashAmt;
	}

	/**
	 * @return the tripAmt
	 */
	public Float getTripAmt() {
		return tripAmt;
	}

	/**
	 * @param tripAmt the tripAmt to set
	 */
	public void setTripAmt(Float tripAmt) {
		this.tripAmt = tripAmt;
	}

	
	
}
