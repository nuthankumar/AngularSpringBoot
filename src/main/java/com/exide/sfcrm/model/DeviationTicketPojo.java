package com.exide.sfcrm.model;


public class DeviationTicketPojo {
	
	private Integer destID;

	private Float cashAmt;

	private Float tripAmt;
	
	private String destName;

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
	
	

}
