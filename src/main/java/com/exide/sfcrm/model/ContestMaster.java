package com.exide.sfcrm.model;

import java.io.Serializable;
import java.sql.Date;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.Table;
import javax.persistence.Transient;
/**
 * 
 * @author vasavivr
 *
 */
@Entity
@Table(name = "tblcontestmaster")
public class ContestMaster implements Serializable {

	/**
	 * 
	 */
	private static final long serialVersionUID = 7966532453752405782L;

	@Id
	@Column(name = "contestautoid",nullable=false)
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	private Integer contestAutoId;

	@Column(name = "contestid")
	private Integer contestId;

	@Column(name = "crtday")
	private Integer crtDay;

	@Column(name = "crtmnt")
	private Integer crtMnt;

	@Column(name = "crtyr")
	private Integer crtYr;

	@Column(name = "activerecrd")
	private Integer activeRecrd;

	@Column(name = "contestname")
	private String contestName;

	@Column(name = "startdate")
	private Integer startDate;

	@Column(name = "enddate")
	private Integer endDate;

	@Column(name = "agtypes")
	private String agTypes;

	@Column(name = "ctsttype")
	private String ctstType;

	@Column(name = "confirmationemailattchfilepath")
	private String confirmationEMailAttchFilePath;

	@Column(name = "confirmationemailattchby")
	private String confirmationEMailAttchBy;

	@Column(name = "confirmationemailattchtime")
	private Date confirmationEMailAttchTime;
	
	
	@Column(name="cmcounter")
	private Integer cmCounter;
	
	@Column(name="Incentive_YorN")
	private String incentive_YorN;
	
	
	@Column(name="advancecounter")
	private Integer advancecounter;
	
	
	@Column(name="Cid")
	private Integer cid;
	
	@Transient
	private DeviationTicketPojo deviationTicketPojo;


	public Integer getContestAutoId() {
		return contestAutoId;
	}


	public void setContestAutoId(Integer contestAutoId) {
		this.contestAutoId = contestAutoId;
	}


	public Integer getContestId() {
		return contestId;
	}


	public void setContestId(Integer contestId) {
		this.contestId = contestId;
	}


	public Integer getCrtDay() {
		return crtDay;
	}


	public void setCrtDay(Integer crtDay) {
		this.crtDay = crtDay;
	}


	public Integer getCrtMnt() {
		return crtMnt;
	}


	public void setCrtMnt(Integer crtMnt) {
		this.crtMnt = crtMnt;
	}


	public Integer getCrtYr() {
		return crtYr;
	}


	public void setCrtYr(Integer crtYr) {
		this.crtYr = crtYr;
	}


	public Integer getActiveRecrd() {
		return activeRecrd;
	}


	public void setActiveRecrd(Integer activeRecrd) {
		this.activeRecrd = activeRecrd;
	}


	public String getContestName() {
		return contestName;
	}


	public void setContestName(String contestName) {
		this.contestName = contestName;
	}


	public Integer getStartDate() {
		return startDate;
	}


	public void setStartDate(Integer startDate) {
		this.startDate = startDate;
	}


	public Integer getEndDate() {
		return endDate;
	}


	public void setEndDate(Integer endDate) {
		this.endDate = endDate;
	}


	public String getAgTypes() {
		return agTypes;
	}


	public void setAgTypes(String agTypes) {
		this.agTypes = agTypes;
	}


	public String getCtstType() {
		return ctstType;
	}


	public void setCtstType(String ctstType) {
		this.ctstType = ctstType;
	}


	public String getConfirmationEMailAttchFilePath() {
		return confirmationEMailAttchFilePath;
	}


	public void setConfirmationEMailAttchFilePath(
			String confirmationEMailAttchFilePath) {
		this.confirmationEMailAttchFilePath = confirmationEMailAttchFilePath;
	}


	public String getConfirmationEMailAttchBy() {
		return confirmationEMailAttchBy;
	}


	public void setConfirmationEMailAttchBy(String confirmationEMailAttchBy) {
		this.confirmationEMailAttchBy = confirmationEMailAttchBy;
	}


	public Date getConfirmationEMailAttchTime() {
		return confirmationEMailAttchTime;
	}


	public void setConfirmationEMailAttchTime(Date confirmationEMailAttchTime) {
		this.confirmationEMailAttchTime = confirmationEMailAttchTime;
	}


	public Integer getCmCounter() {
		return cmCounter;
	}


	public void setCmCounter(Integer cmCounter) {
		this.cmCounter = cmCounter;
	}


	public String getIncentive_YorN() {
		return incentive_YorN;
	}


	public void setIncentive_YorN(String incentive_YorN) {
		this.incentive_YorN = incentive_YorN;
	}


	public Integer getAdvancecounter() {
		return advancecounter;
	}


	public void setAdvancecounter(Integer advancecounter) {
		this.advancecounter = advancecounter;
	}


	public Integer getCid() {
		return cid;
	}


	public void setCid(Integer cid) {
		this.cid = cid;
	}


	/**
	 * @return the deviationTicketPojo
	 */
	public DeviationTicketPojo getDeviationTicketPojo() {
		return deviationTicketPojo;
	}


	/**
	 * @param deviationTicketPojo the deviationTicketPojo to set
	 */
	public void setDeviationTicketPojo(DeviationTicketPojo deviationTicketPojo) {
		this.deviationTicketPojo = deviationTicketPojo;
	}

	
}
