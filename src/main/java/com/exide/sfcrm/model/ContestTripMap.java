package com.exide.sfcrm.model;

import java.io.Serializable;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.Table;


@Entity
@Table(name = "tblcontesttripmap")
public class ContestTripMap implements Serializable{

	/**
	 * 
	 */
	private static final long serialVersionUID = 6751977513811581006L;

	
	@Id
	@Column(name = "transautoid", nullable = false)
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	private Integer transAutoId;

	@Column(name = "contestid")
	private Integer contestId;

	@Column(name = "destid")
	private Integer destID;

	@Column(name = "cashamt")
	private Float cashAmt;

	@Column(name = "tripamt")
	private Float tripAmt;

	/**
	 * @return the transAutoId
	 */
	public Integer getTransAutoId() {
		return transAutoId;
	}

	/**
	 * @param transAutoId the transAutoId to set
	 */
	public void setTransAutoId(Integer transAutoId) {
		this.transAutoId = transAutoId;
	}

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

}
